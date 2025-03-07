/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.messageboards.service.impl;

import com.liferay.documentlibrary.DuplicateDirectoryException;
import com.liferay.documentlibrary.DuplicateFileException;
import com.liferay.documentlibrary.NoSuchDirectoryException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowThreadLocal;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.ModelHintsUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextUtil;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.social.BlogsActivityKeys;
import com.liferay.portlet.blogs.util.LinkbackProducerUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.messageboards.MessageBodyException;
import com.liferay.portlet.messageboards.MessageSubjectException;
import com.liferay.portlet.messageboards.NoSuchDiscussionException;
import com.liferay.portlet.messageboards.RequiredMessageException;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategoryConstants;
import com.liferay.portlet.messageboards.model.MBDiscussion;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBThreadConstants;
import com.liferay.portlet.messageboards.model.impl.MBCategoryImpl;
import com.liferay.portlet.messageboards.model.impl.MBMessageDisplayImpl;
import com.liferay.portlet.messageboards.service.base.MBMessageLocalServiceBaseImpl;
import com.liferay.portlet.messageboards.social.MBActivityKeys;
import com.liferay.portlet.messageboards.util.MBUtil;
import com.liferay.portlet.messageboards.util.MailingListThreadLocal;
import com.liferay.portlet.messageboards.util.comparator.MessageThreadComparator;
import com.liferay.portlet.messageboards.util.comparator.ThreadLastPostDateComparator;
import com.liferay.portlet.social.model.SocialActivity;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.mail.internet.InternetAddress;

import javax.portlet.PortletPreferences;

import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 * @author Mika Koivisto
 * @author Jorge Ferrer
 */
public class MBMessageLocalServiceImpl extends MBMessageLocalServiceBaseImpl {

	public MBMessage addDiscussionMessage(
			long userId, String userName, long groupId, String className,
			long classPK, int workflowAction)
		throws PortalException, SystemException {

		long threadId = 0;
		long parentMessageId = 0;
		String subject = String.valueOf(classPK);
		String body = subject;

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setWorkflowAction(workflowAction);

		boolean workflowEnabled = WorkflowThreadLocal.isEnabled();

		WorkflowThreadLocal.setEnabled(false);

		try {
			return addDiscussionMessage(
				userId, userName, groupId, className, classPK, threadId,
				parentMessageId, subject, body, serviceContext);
		}
		finally {
			WorkflowThreadLocal.setEnabled(workflowEnabled);
		}
	}

	public MBMessage addDiscussionMessage(
			long userId, String userName, long groupId, String className,
			long classPK, long threadId, long parentMessageId, String subject,
			String body, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Message

		long categoryId = MBCategoryConstants.DISCUSSION_CATEGORY_ID;

		if (Validator.isNull(subject)) {
			subject = body.substring(0, Math.min(body.length(), 50)) + "...";
		}

		List<ObjectValuePair<String, byte[]>> files =
			new ArrayList<ObjectValuePair<String, byte[]>>();
		boolean anonymous = false;
		double priority = 0.0;
		boolean allowPingbacks = false;

		serviceContext.setAddCommunityPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setAttribute("className", className);
		serviceContext.setAttribute("classPK", String.valueOf(classPK));

		MBMessage message = addMessage(
			userId, userName, groupId, categoryId, threadId, parentMessageId,
			subject, body, files, anonymous, priority, allowPingbacks,
			serviceContext);

		// Discussion

		if (parentMessageId == MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {
			long classNameId = PortalUtil.getClassNameId(className);

			MBDiscussion discussion = mbDiscussionPersistence.fetchByC_C(
				classNameId, classPK);

			if (discussion == null) {
				discussion = mbDiscussionLocalService.addDiscussion(
					classNameId, classPK, message.getThreadId());
			}
		}

		return message;
	}

	public MBMessage addMessage(
			long userId, String userName, long groupId, long categoryId,
			long threadId, long parentMessageId, String subject, String body,
			List<ObjectValuePair<String, byte[]>> files, boolean anonymous,
			double priority, boolean allowPingbacks,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Message

		User user = userPersistence.findByPrimaryKey(userId);
		userName = user.isDefaultUser() ? userName : user.getFullName();
		subject = ModelHintsUtil.trimString(
			MBMessage.class.getName(), "subject", subject);

		PortletPreferences preferences =
			ServiceContextUtil.getPortletPreferences(serviceContext);

		if (preferences != null) {
			if (!MBUtil.isAllowAnonymousPosting(preferences)) {
				if (anonymous || user.isDefaultUser()) {
					throw new PrincipalException();
				}
			}
		}

		if (user.isDefaultUser()) {
			anonymous = true;
		}

		Date now = new Date();

		validate(subject, body);

		long messageId = counterLocalService.increment();

		MBMessage message = mbMessagePersistence.create(messageId);

		message.setUuid(serviceContext.getUuid());
		message.setGroupId(groupId);
		message.setCompanyId(user.getCompanyId());
		message.setUserId(user.getUserId());
		message.setUserName(userName);
		message.setCreateDate(serviceContext.getCreateDate(now));
		message.setModifiedDate(serviceContext.getModifiedDate(now));
		message.setAllowPingbacks(allowPingbacks);
		message.setStatus(WorkflowConstants.STATUS_DRAFT);
		message.setStatusByUserId(user.getUserId());
		message.setStatusByUserName(userName);
		message.setStatusDate(serviceContext.getModifiedDate(now));

		// Thread

		if (parentMessageId != MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {
			MBMessage parentMessage = mbMessagePersistence.fetchByPrimaryKey(
				parentMessageId);

			if (parentMessage == null) {
				parentMessageId = MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID;
			}
		}

		MBThread thread = null;

		if (threadId > 0) {
			thread = mbThreadPersistence.fetchByPrimaryKey(threadId);
		}

		if ((thread == null) ||
			(parentMessageId == MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID)) {

			threadId = counterLocalService.increment();

			thread = mbThreadPersistence.create(threadId);

			thread.setGroupId(groupId);
			thread.setCategoryId(categoryId);
			thread.setRootMessageId(messageId);
			thread.setStatus(WorkflowConstants.STATUS_DRAFT);
			thread.setStatusByUserId(user.getUserId());
			thread.setStatusByUserName(userName);
			thread.setStatusDate(serviceContext.getModifiedDate(now));
		}

		if ((priority != MBThreadConstants.PRIORITY_NOT_GIVEN) &&
			(thread.getPriority() != priority)) {

			thread.setPriority(priority);

			updatePriorities(thread.getThreadId(), priority);
		}

		// Message

		message.setCategoryId(categoryId);
		message.setThreadId(threadId);
		message.setRootMessageId(thread.getRootMessageId());
		message.setParentMessageId(parentMessageId);
		message.setSubject(subject);
		message.setBody(body);
		message.setAttachments(!files.isEmpty());
		message.setAnonymous(anonymous);

		if (priority != MBThreadConstants.PRIORITY_NOT_GIVEN) {
			message.setPriority(priority);
		}

		if (message.isDiscussion()) {
			long classNameId = PortalUtil.getClassNameId(
				(String)serviceContext.getAttribute("className"));
			long classPK = GetterUtil.getLong(
				(String)serviceContext.getAttribute("classPK"));

			message.setClassNameId(classNameId);
			message.setClassPK(classPK);
		}

		// Attachments

		if (files.size() > 0) {
			long companyId = message.getCompanyId();
			String portletId = CompanyConstants.SYSTEM_STRING;
			long dlGroupId = GroupConstants.DEFAULT_PARENT_GROUP_ID;
			long repositoryId = CompanyConstants.SYSTEM;
			String dirName = message.getAttachmentsDir();

			try {
				dlService.deleteDirectory(
					companyId, portletId, repositoryId, dirName);
			}
			catch (NoSuchDirectoryException nsde) {
				if (_log.isDebugEnabled()) {
					_log.debug(nsde.getMessage());
				}
			}

			dlService.addDirectory(companyId, repositoryId, dirName);

			for (int i = 0; i < files.size(); i++) {
				ObjectValuePair<String, byte[]> ovp = files.get(i);

				String fileName = ovp.getKey();
				byte[] bytes = ovp.getValue();

				try {
					dlService.addFile(
						companyId, portletId, dlGroupId, repositoryId,
						dirName + "/" + fileName, 0, StringPool.BLANK,
						message.getModifiedDate(), new ServiceContext(), bytes);
				}
				catch (DuplicateFileException dfe) {
					if (_log.isDebugEnabled()) {
						_log.debug(dfe.getMessage());
					}
				}
			}
		}

		// Commit

		mbThreadPersistence.update(thread, false);
		mbMessagePersistence.update(message, false);

		// Resources

		if (!message.isDiscussion()) {
			if (user.isDefaultUser()) {
				addMessageResources(message, true, true);
			}
			if (serviceContext.getAddCommunityPermissions() ||
				serviceContext.getAddGuestPermissions()) {

				addMessageResources(
					message, serviceContext.getAddCommunityPermissions(),
					serviceContext.getAddGuestPermissions());
			}
			else {
				addMessageResources(
					message, serviceContext.getCommunityPermissions(),
					serviceContext.getGuestPermissions());
			}
		}

		// Asset

		updateAsset(
			userId, message, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames());

		// Expando

		ExpandoBridge expandoBridge = message.getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);

		// Workflow

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
			user.getCompanyId(), groupId, userId,
			message.getWorkflowClassName(), message.getMessageId(), message,
			serviceContext);

		// Testing roll back

		/*if (true) {
			throw new SystemException("Testing roll back");
		}*/

		return message;
	}

	public MBMessage addMessage(
			long userId, String userName, long groupId, long categoryId,
			String subject, String body,
			List<ObjectValuePair<String, byte[]>> files, boolean anonymous,
			double priority, boolean allowPingbacks,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		long threadId = 0;
		long parentMessageId = 0;

		return addMessage(
			userId, userName, groupId, categoryId, threadId, parentMessageId,
			subject, body, files, anonymous, priority, allowPingbacks,
			serviceContext);
	}

	public void addMessageResources(
			long messageId, boolean addCommunityPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		MBMessage message = mbMessagePersistence.findByPrimaryKey(messageId);

		addMessageResources(
			message, addCommunityPermissions, addGuestPermissions);
	}

	public void addMessageResources(
			long messageId, String[] communityPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		MBMessage message = mbMessagePersistence.findByPrimaryKey(messageId);

		addMessageResources(message, communityPermissions, guestPermissions);
	}

	public void addMessageResources(
			MBMessage message, boolean addCommunityPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			message.getCompanyId(), message.getGroupId(), message.getUserId(),
			MBMessage.class.getName(), message.getMessageId(),
			false, addCommunityPermissions, addGuestPermissions);
	}

	public void addMessageResources(
			MBMessage message, String[] communityPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			message.getCompanyId(), message.getGroupId(), message.getUserId(),
			MBMessage.class.getName(), message.getMessageId(),
			communityPermissions, guestPermissions);
	}

	public void deleteDiscussionMessage(long messageId)
		throws PortalException, SystemException {

		MBMessage message = mbMessagePersistence.findByPrimaryKey(messageId);

		List<MBMessage> messages = new ArrayList<MBMessage>();

		messages.add(message);

		deleteDiscussionSocialActivities(BlogsEntry.class.getName(), messages);

		deleteMessage(message);
	}

	public void deleteDiscussionMessages(String className, long classPK)
		throws PortalException, SystemException {

		try {
			long classNameId = PortalUtil.getClassNameId(className);

			MBDiscussion discussion = mbDiscussionPersistence.findByC_C(
				classNameId, classPK);

			List<MBMessage> messages = mbMessagePersistence.findByT_P(
				discussion.getThreadId(),
				MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID, 0, 1);

			deleteDiscussionSocialActivities(
				BlogsEntry.class.getName(), messages);

			if (messages.size() > 0) {
				MBMessage message = messages.get(0);

				mbThreadLocalService.deleteThread(message.getThreadId());
			}

			mbDiscussionPersistence.remove(discussion);
		}
		catch (NoSuchDiscussionException nsde) {
			if (_log.isDebugEnabled()) {
				_log.debug(nsde.getMessage());
			}
		}
	}

	public void deleteMessage(long messageId)
		throws PortalException, SystemException {

		MBMessage message = mbMessagePersistence.findByPrimaryKey(messageId);

		deleteMessage(message);
	}

	public void deleteMessage(MBMessage message)
		throws PortalException, SystemException {

		// Indexer

		Indexer indexer = IndexerRegistryUtil.getIndexer(MBMessage.class);

		indexer.delete(message);

		// Attachments

		if (message.isAttachments()) {
			long companyId = message.getCompanyId();
			String portletId = CompanyConstants.SYSTEM_STRING;
			long repositoryId = CompanyConstants.SYSTEM;
			String dirName = message.getAttachmentsDir();

			try {
				dlService.deleteDirectory(
					companyId, portletId, repositoryId, dirName);
			}
			catch (NoSuchDirectoryException nsde) {
				if (_log.isDebugEnabled()) {
					_log.debug(nsde.getMessage());
				}
			}
		}

		// Thread

		int count = mbMessagePersistence.countByThreadId(message.getThreadId());

		// Message flags

		if (message.isRoot()) {
			mbMessageFlagLocalService.deleteQuestionAndAnswerFlags(
				message.getThreadId());
		}
		else if (mbMessageFlagLocalService.hasAnswerFlag(
					message.getMessageId())) {

			mbMessageFlagService.deleteAnswerFlag(message.getMessageId());
		}

		if (count == 1) {

			// Attachments

			long companyId = message.getCompanyId();
			String portletId = CompanyConstants.SYSTEM_STRING;
			long repositoryId = CompanyConstants.SYSTEM;
			String dirName = message.getThreadAttachmentsDir();

			try {
				dlService.deleteDirectory(
					companyId, portletId, repositoryId, dirName);
			}
			catch (NoSuchDirectoryException nsde) {
				if (_log.isDebugEnabled()) {
					_log.debug(nsde.getMessage());
				}
			}

			// Subscriptions

			subscriptionLocalService.deleteSubscriptions(
				message.getCompanyId(), MBThread.class.getName(),
				message.getThreadId());

			// Thread

			mbThreadPersistence.remove(message.getThreadId());

			// Category

			if ((message.getCategoryId() !=
					MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
				(message.getCategoryId() !=
					MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

				MBCategory category = mbCategoryPersistence.findByPrimaryKey(
					message.getCategoryId());

				category.setThreadCount(category.getThreadCount() - 1);
				category.setMessageCount(category.getMessageCount() - 1);

				mbCategoryPersistence.update(category, false);
			}
		}
		else if (count > 1) {
			MBThread thread = mbThreadPersistence.findByPrimaryKey(
				message.getThreadId());

			// Message is a root message

			if (thread.getRootMessageId() == message.getMessageId()) {
				List<MBMessage> childrenMessages =
					mbMessagePersistence.findByT_P(
						message.getThreadId(), message.getMessageId());

				if (childrenMessages.size() > 1) {
					throw new RequiredMessageException(
						String.valueOf(message.getMessageId()));
				}
				else if (childrenMessages.size() == 1) {
					MBMessage childMessage = childrenMessages.get(0);

					childMessage.setRootMessageId(childMessage.getMessageId());
					childMessage.setParentMessageId(
						MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID);

					mbMessagePersistence.update(childMessage, false);

					thread.setRootMessageId(childMessage.getMessageId());

					mbThreadPersistence.update(thread, false);
				}
			}

			// Message is a child message

			else {
				List<MBMessage> childrenMessages =
					mbMessagePersistence.findByT_P(
						message.getThreadId(), message.getMessageId());

				// Message has children messages

				if (childrenMessages.size() > 0) {
					Iterator<MBMessage> itr = childrenMessages.iterator();

					while (itr.hasNext()) {
						MBMessage childMessage = itr.next();

						childMessage.setParentMessageId(
							message.getParentMessageId());

						mbMessagePersistence.update(childMessage, false);
					}
				}
			}

			// Thread

			thread.setMessageCount(count - 1);

			mbThreadPersistence.update(thread, false);

			// Category

			if ((message.getCategoryId() !=
					MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
				(message.getCategoryId() !=
					MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

				MBCategory category = mbCategoryPersistence.findByPrimaryKey(
					message.getCategoryId());

				category.setMessageCount(category.getMessageCount() - 1);

				mbCategoryPersistence.update(category, false);
			}
		}

		// Asset

		assetEntryLocalService.deleteEntry(
			MBMessage.class.getName(), message.getMessageId());

		// Expando

		expandoValueLocalService.deleteValues(
			MBMessage.class.getName(), message.getMessageId());

		// Social

		socialActivityLocalService.deleteActivities(
			MBMessage.class.getName(), message.getMessageId());

		// Ratings

		ratingsStatsLocalService.deleteStats(
			MBMessage.class.getName(), message.getMessageId());

		// Statistics

		if (!message.isDiscussion()) {
			mbStatsUserLocalService.updateStatsUser(
				message.getGroupId(), message.getUserId());
		}

		// Message flags

		mbMessageFlagPersistence.removeByMessageId(message.getMessageId());

		// Resources

		if (!message.isDiscussion()) {
			resourceLocalService.deleteResource(
				message.getCompanyId(), MBMessage.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, message.getMessageId());
		}

		// Message

		mbMessagePersistence.remove(message);

		// Workflow

		workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(
			message.getCompanyId(), message.getGroupId(),
			message.getWorkflowClassName(), message.getMessageId());
	}

	public List<MBMessage> getCategoryMessages(
			long groupId, long categoryId, int status, int start, int end)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByG_C(
				groupId, categoryId, start, end);
		}
		else {
			return mbMessagePersistence.findByG_C_S(
				groupId, categoryId, status, start, end);
		}
	}

	public List<MBMessage> getCategoryMessages(
			long groupId, long categoryId, int status, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByG_C(
				groupId, categoryId, start, end, obc);
		}
		else {
			return mbMessagePersistence.findByG_C_S(
				groupId, categoryId, status, start, end, obc);
		}
	}

	public int getCategoryMessagesCount(
			long groupId, long categoryId, int status)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.countByG_C(groupId, categoryId);
		}
		else {
			return mbMessagePersistence.countByG_C_S(
				groupId, categoryId, status);
		}
	}

	public List<MBMessage> getCompanyMessages(
			long companyId, int status, int start, int end)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByCompanyId(companyId, start, end);
		}
		else {
			return mbMessagePersistence.findByC_S(
				companyId, status, start, end);
		}
	}

	public List<MBMessage> getCompanyMessages(
			long companyId, int status, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByCompanyId(
				companyId, start, end, obc);
		}
		else {
			return mbMessagePersistence.findByC_S(
				companyId, status, start, end, obc);
		}
	}

	public int getCompanyMessagesCount(long companyId, int status)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.countByCompanyId(companyId);
		}
		else {
			return mbMessagePersistence.countByC_S(companyId, status);
		}
	}

	public MBMessageDisplay getDiscussionMessageDisplay(
			long userId, long groupId, String className, long classPK,
			int status)
		throws PortalException, SystemException {

		return getDiscussionMessageDisplay(
			userId, groupId, className, classPK, status,
			MBThreadConstants.THREAD_VIEW_COMBINATION);
	}

	public MBMessageDisplay getDiscussionMessageDisplay(
			long userId, long groupId, String className, long classPK,
			int status, String threadView)
		throws PortalException, SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		MBMessage message = null;

		MBDiscussion discussion = mbDiscussionPersistence.fetchByC_C(
			classNameId, classPK);

		if (discussion != null) {
			List<MBMessage> messages = mbMessagePersistence.findByT_P(
				discussion.getThreadId(),
				MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID);

			message = messages.get(0);
		}
		else {
			boolean workflowEnabled = WorkflowThreadLocal.isEnabled();

			WorkflowThreadLocal.setEnabled(false);

			try {
				String subject = String.valueOf(classPK);
				//String body = subject;

				message = addDiscussionMessage(
					userId, null, groupId, className, classPK, 0,
					MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID, subject,
					subject, new ServiceContext());
			}
			catch (SystemException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Add failed, fetch {threadId=0, parentMessageId=" +
							MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID + "}");
				}

				List<MBMessage> messages = mbMessagePersistence.findByT_P(
					0, MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID);

				if (messages.isEmpty()) {
					throw se;
				}

				message = messages.get(0);
			}
			finally {
				WorkflowThreadLocal.setEnabled(workflowEnabled);
			}
		}

		return getMessageDisplay(message, status, threadView, false);
	}

	public int getDiscussionMessagesCount(
			long classNameId, long classPK, int status)
		throws SystemException {

		MBDiscussion discussion = mbDiscussionPersistence.fetchByC_C(
			classNameId, classPK);

		if (discussion == null) {
			return 0;
		}

		int count = 0;

		if (status == WorkflowConstants.STATUS_ANY) {
			count = mbMessagePersistence.countByThreadId(
				discussion.getThreadId());
		}
		else {
			count = mbMessagePersistence.countByT_S(
				discussion.getThreadId(), status);
		}

		if (count >= 1) {
			return count - 1;
		}
		else {
			return 0;
		}
	}

	public int getDiscussionMessagesCount(
			String className, long classPK, int status)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getDiscussionMessagesCount(classNameId, classPK, status);
	}

	public List<MBDiscussion> getDiscussions(String className)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return mbDiscussionPersistence.findByClassNameId(classNameId);
	}

	public List<MBMessage> getGroupMessages(
			long groupId, int status, int start, int end)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByGroupId(groupId, start, end);
		}
		else {
			return mbMessagePersistence.findByG_S(groupId, status, start, end);
		}
	}

	public List<MBMessage> getGroupMessages(
			long groupId, int status, int start, int end, OrderByComparator obc)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByGroupId(groupId, start, end, obc);
		}
		else {
			return mbMessagePersistence.findByG_S(
				groupId, status, start, end, obc);
		}
	}

	public List<MBMessage> getGroupMessages(
			long groupId, long userId, int status, int start, int end)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByG_U(groupId, userId, start, end);
		}
		else {
			return mbMessagePersistence.findByG_U_S(
				groupId, userId, status, start, end);
		}
	}

	public List<MBMessage> getGroupMessages(
			long groupId, long userId, int status, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByG_U(
				groupId, userId, start, end, obc);
		}
		else {
			return mbMessagePersistence.findByG_U_S(
				groupId, userId, status, start, end, obc);
		}
	}

	public int getGroupMessagesCount(long groupId, int status)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.countByGroupId(groupId);
		}
		else {
			return mbMessagePersistence.countByG_S(groupId, status);
		}
	}

	public int getGroupMessagesCount(long groupId, long userId, int status)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.countByG_U(groupId, userId);
		}
		else {
			return mbMessagePersistence.countByG_U_S(groupId, userId, status);
		}
	}

	public MBMessage getMessage(long messageId)
		throws PortalException, SystemException {

		return mbMessagePersistence.findByPrimaryKey(messageId);
	}

	public MBMessageDisplay getMessageDisplay(
			long messageId, int status, String threadView,
			boolean includePrevAndNext)
		throws PortalException, SystemException {

		MBMessage message = getMessage(messageId);

		return getMessageDisplay(
			message, status, threadView, includePrevAndNext);
	}

	public MBMessageDisplay getMessageDisplay(
			MBMessage message, int status, String threadView,
			boolean includePrevAndNext)
		throws PortalException, SystemException {

		MBCategory category = null;

		if ((message.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
			(message.getCategoryId() !=
				MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

			category = mbCategoryPersistence.findByPrimaryKey(
				message.getCategoryId());
		}
		else {
			category = new MBCategoryImpl();

			category.setCategoryId(message.getCategoryId());
		}

		MBMessage parentMessage = null;

		if (message.isReply()) {
			parentMessage = mbMessagePersistence.findByPrimaryKey(
				message.getParentMessageId());
		}

		MBThread thread = mbThreadPersistence.findByPrimaryKey(
			message.getThreadId());

		if (!message.isDiscussion() &&
			(message.getStatus() == WorkflowConstants.STATUS_APPROVED)) {

			mbThreadLocalService.updateThread(
				thread.getThreadId(), thread.getViewCount() + 1);
		}

		MBThread previousThread = null;
		MBThread nextThread = null;

		if ((message.getStatus() == WorkflowConstants.STATUS_APPROVED) &&
			includePrevAndNext) {

			ThreadLastPostDateComparator comparator =
				new ThreadLastPostDateComparator(false);

			MBThread[] prevAndNextThreads =
				mbThreadPersistence.findByG_C_PrevAndNext(
					message.getThreadId(), message.getGroupId(),
					message.getCategoryId(), comparator);

			previousThread = prevAndNextThreads[0];
			nextThread = prevAndNextThreads[2];
		}

		return new MBMessageDisplayImpl(
			message, parentMessage, category, thread,
			previousThread, nextThread, status, threadView);
	}

	public List<MBMessage> getMessages(
			String className, long classPK, int status)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByC_C(classNameId, classPK);
		}
		else {
			return mbMessagePersistence.findByC_C_S(
				classNameId, classPK, status);
		}
	}

	public List<MBMessage> getNoAssetMessages() throws SystemException {
		return mbMessageFinder.findByNoAssets();
	}

	public int getPositionInThread(long messageId)
		throws PortalException, SystemException {

		MBMessage message = mbMessagePersistence.findByPrimaryKey(messageId);

		return mbMessageFinder.countByC_T(
			message.getCreateDate(), message.getThreadId());
	}

	public List<MBMessage> getThreadMessages(long threadId, int status)
		throws SystemException {

		return getThreadMessages(
			threadId, status, new MessageThreadComparator());
	}

	public List<MBMessage> getThreadMessages(
			long threadId, int status, Comparator<MBMessage> comparator)
		throws SystemException {

		List<MBMessage> messages = null;

		if (status == WorkflowConstants.STATUS_ANY) {
			messages = mbMessagePersistence.findByThreadId(threadId);
		}
		else {
			messages = mbMessagePersistence.findByT_S(threadId, status);
		}

		return ListUtil.sort(messages, comparator);
	}

	public List<MBMessage> getThreadMessages(
			long threadId, int status, int start, int end)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByThreadId(threadId, start, end);
		}
		else {
			return mbMessagePersistence.findByT_S(threadId, status, start, end);
		}
	}

	public int getThreadMessagesCount(long threadId, int status)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.countByThreadId(threadId);
		}
		else {
			return mbMessagePersistence.countByT_S(threadId, status);
		}
	}

	public List<MBMessage> getThreadRepliesMessages(
			long threadId, int status, int start, int end)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbMessagePersistence.findByThreadReplies(
				threadId, start, end);
		}
		else {
			return mbMessagePersistence.findByTR_S(
				threadId, status, start, end);
		}
	}

	public void subscribeMessage(long userId, long messageId)
		throws PortalException, SystemException {

		MBMessage message = mbMessagePersistence.findByPrimaryKey(messageId);

		subscriptionLocalService.addSubscription(
			userId, MBThread.class.getName(), message.getThreadId());
	}

	public void unsubscribeMessage(long userId, long messageId)
		throws PortalException, SystemException {

		MBMessage message = mbMessagePersistence.findByPrimaryKey(messageId);

		subscriptionLocalService.deleteSubscription(
			userId, MBThread.class.getName(), message.getThreadId());
	}

	public void updateAsset(
			long userId, MBMessage message, long[] assetCategoryIds,
			String[] assetTagNames)
		throws PortalException, SystemException {

		boolean visible = false;

		if (message.getStatus() == WorkflowConstants.STATUS_APPROVED) {
			visible = true;
		}

		assetEntryLocalService.updateEntry(
			userId, message.getGroupId(), message.getWorkflowClassName(),
			message.getMessageId(), message.getUuid(), assetCategoryIds,
			assetTagNames, visible, null, null, null, null,
			ContentTypes.TEXT_HTML, message.getSubject(), null, null, null, 0,
			0, null, false);
	}

	public MBMessage updateDiscussionMessage(
			long userId, long messageId, String subject, String body,
			int workflowAction)
		throws PortalException, SystemException {

		if (Validator.isNull(subject)) {
			subject = body.substring(0, Math.min(body.length(), 50)) + "...";
		}

		List<ObjectValuePair<String, byte[]>> files =
			new ArrayList<ObjectValuePair<String, byte[]>>();
		List<String> existingFiles = new ArrayList<String>();
		double priority = 0.0;
		boolean allowPingbacks = false;

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setWorkflowAction(workflowAction);

		return updateMessage(
			userId, messageId, subject, body, files, existingFiles, priority,
			allowPingbacks, serviceContext);
	}

	public MBMessage updateMessage(
			long userId, long messageId, String subject, String body,
			List<ObjectValuePair<String, byte[]>> files,
			List<String> existingFiles, double priority, boolean allowPingbacks,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Message

		MBMessage message = mbMessagePersistence.findByPrimaryKey(messageId);

		subject = ModelHintsUtil.trimString(
			MBMessage.class.getName(), "subject", subject);
		Date now = new Date();

		validate(subject, body);

		message.setModifiedDate(serviceContext.getModifiedDate(now));
		message.setSubject(subject);
		message.setBody(body);
		message.setAttachments(!files.isEmpty() || !existingFiles.isEmpty());
		message.setAllowPingbacks(allowPingbacks);

		if (priority != MBThreadConstants.PRIORITY_NOT_GIVEN) {
			message.setPriority(priority);
		}

		// Attachments

		long companyId = message.getCompanyId();
		String portletId = CompanyConstants.SYSTEM_STRING;
		long groupId = GroupConstants.DEFAULT_PARENT_GROUP_ID;
		long repositoryId = CompanyConstants.SYSTEM;
		String dirName = message.getAttachmentsDir();

		if (!files.isEmpty() || !existingFiles.isEmpty()) {
			try {
				dlService.addDirectory(companyId, repositoryId, dirName);
			}
			catch (DuplicateDirectoryException dde) {
			}

			String[] fileNames = dlService.getFileNames(
				companyId, repositoryId, dirName);

			for (String fileName: fileNames) {
				if (!existingFiles.contains(fileName)) {
					dlService.deleteFile(
						companyId, portletId, repositoryId, fileName);
				}
			}

			for (int i = 0; i < files.size(); i++) {
				ObjectValuePair<String, byte[]> ovp = files.get(i);

				String fileName = ovp.getKey();
				byte[] bytes = ovp.getValue();

				try {
					dlService.addFile(
						companyId, portletId, groupId, repositoryId,
						dirName + "/" + fileName, 0, StringPool.BLANK,
						message.getModifiedDate(), new ServiceContext(), bytes);
				}
				catch (DuplicateFileException dfe) {
				}
			}
		}
		else {
			try {
				dlService.deleteDirectory(
					companyId, portletId, repositoryId, dirName);
			}
			catch (NoSuchDirectoryException nsde) {
			}
		}

		mbMessagePersistence.update(message, false);

		// Thread

		MBThread thread = mbThreadPersistence.findByPrimaryKey(
			message.getThreadId());

		if ((priority != MBThreadConstants.PRIORITY_NOT_GIVEN) &&
			(thread.getPriority() != priority)) {

			thread.setPriority(priority);

			mbThreadPersistence.update(thread, false);

			updatePriorities(thread.getThreadId(), priority);
		}

		// Asset

		updateAsset(
			userId, message, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames());

		// Expando

		ExpandoBridge expandoBridge = message.getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);

		// Workflow

		serviceContext.setAttribute("update", Boolean.TRUE.toString());

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
			companyId, message.getGroupId(), userId,
			message.getWorkflowClassName(), message.getMessageId(), message,
			serviceContext);

		return message;
	}

	public MBMessage updateMessage(long messageId, String body)
		throws PortalException, SystemException {

		MBMessage message = mbMessagePersistence.findByPrimaryKey(messageId);

		message.setBody(body);

		mbMessagePersistence.update(message, false);

		return message;
	}

	public MBMessage updateStatus(
			long userId, long messageId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		MBMessage message = getMessage(messageId);

		int oldStatus = message.getStatus();

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		message.setStatus(status);
		message.setStatusByUserId(userId);
		message.setStatusByUserName(user.getFullName());
		message.setStatusDate(serviceContext.getModifiedDate(now));

		mbMessagePersistence.update(message, false);

		// Thread

		MBThread thread = mbThreadPersistence.findByPrimaryKey(
			message.getThreadId());

		MBCategory category = null;

		if ((thread.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
			(thread.getCategoryId() !=
				MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

			category = mbCategoryPersistence.findByPrimaryKey(
				thread.getCategoryId());
		}

		if ((thread.getRootMessageId() == message.getMessageId()) &&
			(oldStatus != status)) {

			thread.setStatus(status);
			thread.setStatusByUserId(userId);
			thread.setStatusByUserName(user.getFullName());
			thread.setStatusDate(serviceContext.getModifiedDate(now));
		}

		Indexer indexer = IndexerRegistryUtil.getIndexer(MBMessage.class);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			if (oldStatus != WorkflowConstants.STATUS_APPROVED) {

				// Thread

				if ((category != null) &&
					(thread.getRootMessageId() == message.getMessageId())) {

					category.setThreadCount(category.getThreadCount() + 1);

					mbCategoryPersistence.update(category, false);
				}

				thread.setMessageCount(thread.getMessageCount() + 1);

				if (message.isAnonymous()) {
					thread.setLastPostByUserId(0);
				}
				else {
					thread.setLastPostByUserId(message.getUserId());
				}

				thread.setLastPostDate(serviceContext.getModifiedDate(now));

				// Category

				if (category != null) {
					category.setMessageCount(category.getMessageCount() + 1);
					category.setLastPostDate(
						serviceContext.getModifiedDate(now));

					mbCategoryPersistence.update(category, false);

				}

				if (!message.isDiscussion()) {

					// Asset

					assetEntryLocalService.updateVisible(
						MBMessage.class.getName(), message.getMessageId(),
						true);

					// Social

					if (!message.isAnonymous() && !user.isDefaultUser()) {
						int activityType = MBActivityKeys.ADD_MESSAGE;
						long receiverUserId = 0;
						String actionId = ActionKeys.ADD_MESSAGE;

						MBMessage parentMessage =
							mbMessagePersistence.fetchByPrimaryKey(
								message.getParentMessageId());

						if (parentMessage != null) {
							activityType = MBActivityKeys.REPLY_MESSAGE;
							receiverUserId = parentMessage.getUserId();

							if (receiverUserId != userId) {
								actionId = ActionKeys.REPLY_TO_MESSAGE;
							}
						}

						socialActivityLocalService.addActivity(
							userId, message.getGroupId(),
							MBMessage.class.getName(), message.getMessageId(),
							activityType, StringPool.BLANK, receiverUserId);

						socialEquityLogLocalService.addEquityLogs(
							userId, MBMessage.class.getName(), messageId,
							actionId);
					}
				}

				// Subscriptions

				notifySubscribers(message, serviceContext);
			}

			// Indexer

			if (!message.isDiscussion()) {
				indexer.reindex(message);
			}

			// Ping

			pingPingback(message, serviceContext);

			// Workflow

			if (message.isDiscussion()) {
				updateDiscussionMessageStatus(
					userId, messageId, status, oldStatus, serviceContext);
			}
		}
		else if ((oldStatus == WorkflowConstants.STATUS_APPROVED) &&
				 (status != WorkflowConstants.STATUS_APPROVED)) {

			// Thread

			if ((category != null) &&
				(thread.getRootMessageId() == message.getMessageId())) {

				category.setThreadCount(category.getThreadCount() - 1);

				mbCategoryPersistence.update(category, false);
			}

			thread.setMessageCount(thread.getMessageCount() - 1);

			// Category

			if (category != null) {
				category.setMessageCount(category.getMessageCount() - 1);

				mbCategoryPersistence.update(category, false);
			}

			if (!message.isDiscussion()) {

				// Asset

				assetEntryLocalService.updateVisible(
					MBMessage.class.getName(), message.getMessageId(), false);

				// Indexer

				indexer.delete(message);
			}

		}

		if (status != oldStatus) {
			mbThreadPersistence.update(thread, false);
		}

		// Statistics

		if (!message.isDiscussion()) {
			mbStatsUserLocalService.updateStatsUser(
				message.getGroupId(), userId,
				serviceContext.getModifiedDate(now));
		}

		return message;
	}

	public void updateUserName(long userId, String userName)
		throws SystemException {

		List<MBMessage> messages = mbMessagePersistence.findByUserId(userId);

		for (MBMessage message : messages) {
			message.setUserName(userName);

			mbMessagePersistence.update(message, false);
		}
	}

	protected void deleteDiscussionSocialActivities(
			String className, List<MBMessage> messages)
		throws PortalException, SystemException {

		if (messages.size() == 0) {
			return;
		}

		MBMessage message = messages.get(0);

		MBDiscussion discussion = mbDiscussionPersistence.findByThreadId(
			message.getThreadId());

		long classNameId = PortalUtil.getClassNameId(className);
		long classPK = discussion.getClassPK();

		if (discussion.getClassNameId() != classNameId) {
			return;
		}

		Set<Long> messageIds = new HashSet<Long>();

		for (MBMessage curMessage : messages) {
			messageIds.add(curMessage.getMessageId());
		}

		List<SocialActivity> socialActivities =
			socialActivityLocalService.getActivities(
				0, className, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (SocialActivity socialActivity : socialActivities) {
			if (Validator.isNull(socialActivity.getExtraData())) {
				continue;
			}

			JSONObject extraData = JSONFactoryUtil.createJSONObject(
				socialActivity.getExtraData());

			long extraDataMessageId = extraData.getLong("messageId");

			if (messageIds.contains(extraDataMessageId)) {
				socialActivityLocalService.deleteActivity(
					socialActivity.getActivityId());
			}
		}
	}

	protected void notifySubscribers(
			MBMessage message, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (message.getStatus() != WorkflowConstants.STATUS_APPROVED) {
			return;
		}

		String layoutFullURL = serviceContext.getLayoutFullURL();

		if (Validator.isNull(layoutFullURL) || message.isDiscussion()) {
			return;
		}

		PortletPreferences preferences =
			ServiceContextUtil.getPortletPreferences(serviceContext);

		if (preferences == null) {
			long ownerId = message.getGroupId();
			int ownerType = PortletKeys.PREFS_OWNER_TYPE_GROUP;
			long plid = PortletKeys.PREFS_PLID_SHARED;
			String portletId = PortletKeys.MESSAGE_BOARDS;
			String defaultPreferences = null;

			preferences = portletPreferencesLocalService.getPreferences(
				message.getCompanyId(), ownerId, ownerType, plid, portletId,
				defaultPreferences);
		}

		boolean update = GetterUtil.getBoolean(
			(String)serviceContext.getAttribute("update"));

		if (!update && MBUtil.getEmailMessageAddedEnabled(preferences)) {
		}
		else if (update && MBUtil.getEmailMessageUpdatedEnabled(preferences)) {
		}
		else {
			return;
		}

		Company company = companyPersistence.findByPrimaryKey(
			message.getCompanyId());

		Group group = groupPersistence.findByPrimaryKey(message.getGroupId());

		String emailAddress = StringPool.BLANK;
		String fullName = message.getUserName();

		try {
			User user = userPersistence.findByPrimaryKey(message.getUserId());

			emailAddress = user.getEmailAddress();
			fullName = user.getFullName();
		}
		catch (NoSuchUserException nsue) {
		}

		MBCategory category = message.getCategory();

		if (message.isAnonymous()) {
			emailAddress = StringPool.BLANK;
			fullName = LanguageUtil.get(
				ServiceContextUtil.getLocale(serviceContext), "anonymous");
		}

		List<Long> categoryIds = new ArrayList<Long>();

		categoryIds.add(message.getCategoryId());

		if ((message.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
			(message.getCategoryId() !=
				MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

			categoryIds.addAll(category.getAncestorCategoryIds());
		}

		String messageURL =
			layoutFullURL + Portal.FRIENDLY_URL_SEPARATOR +
				"message_boards/view_message/" + message.getMessageId();

		String portletName = PortalUtil.getPortletTitle(
			PortletKeys.MESSAGE_BOARDS, LocaleUtil.getDefault());

		String fromName = MBUtil.getEmailFromName(preferences);
		String fromAddress = MBUtil.getEmailFromAddress(preferences);

		String mailingListAddress = StringPool.BLANK;

		if (PropsValues.POP_SERVER_NOTIFICATIONS_ENABLED) {
			mailingListAddress = MBUtil.getMailingListAddress(
				message.getGroupId(), message.getCategoryId(),
				message.getMessageId(), company.getMx(), fromAddress);
		}

		String replyToAddress = mailingListAddress;
		String mailId = MBUtil.getMailId(
			company.getMx(), message.getCategoryId(), message.getMessageId());

		fromName = StringUtil.replace(
			fromName,
			new String[] {
				"[$COMPANY_ID$]",
				"[$COMPANY_MX$]",
				"[$COMPANY_NAME$]",
				"[$COMMUNITY_NAME$]",
				"[$MAILING_LIST_ADDRESS$]",
				"[$MESSAGE_USER_ADDRESS$]",
				"[$MESSAGE_USER_NAME$]",
				"[$PORTLET_NAME$]"
			},
			new String[] {
				String.valueOf(company.getCompanyId()),
				company.getMx(),
				company.getName(),
				group.getName(),
				mailingListAddress,
				emailAddress,
				fullName,
				portletName
			});

		fromAddress = StringUtil.replace(
			fromAddress,
			new String[] {
				"[$COMPANY_ID$]",
				"[$COMPANY_MX$]",
				"[$COMPANY_NAME$]",
				"[$COMMUNITY_NAME$]",
				"[$MAILING_LIST_ADDRESS$]",
				"[$MESSAGE_USER_ADDRESS$]",
				"[$MESSAGE_USER_NAME$]",
				"[$PORTLET_NAME$]"
			},
			new String[] {
				String.valueOf(company.getCompanyId()),
				company.getMx(),
				company.getName(),
				group.getName(),
				mailingListAddress,
				emailAddress,
				fullName,
				portletName
			});

		String subjectPrefix = null;
		String body = null;
		String signature = null;
		boolean htmlFormat = MBUtil.getEmailHtmlFormat(preferences);

		if (update) {
			subjectPrefix = MBUtil.getEmailMessageUpdatedSubjectPrefix(
				preferences);
			body = MBUtil.getEmailMessageUpdatedBody(preferences);
			signature = MBUtil.getEmailMessageUpdatedSignature(preferences);
		}
		else {
			subjectPrefix = MBUtil.getEmailMessageAddedSubjectPrefix(
				preferences);
			body = MBUtil.getEmailMessageAddedBody(preferences);
			signature = MBUtil.getEmailMessageAddedSignature(preferences);
		}

		if (Validator.isNotNull(signature)) {
			body +=  "\n--\n" + signature;
		}

		subjectPrefix = StringUtil.replace(
			subjectPrefix,
			new String[] {
				"[$CATEGORY_NAME$]",
				"[$COMPANY_ID$]",
				"[$COMPANY_MX$]",
				"[$COMPANY_NAME$]",
				"[$COMMUNITY_NAME$]",
				"[$FROM_ADDRESS$]",
				"[$FROM_NAME$]",
				"[$MAILING_LIST_ADDRESS$]",
				"[$MESSAGE_BODY$]",
				"[$MESSAGE_ID$]",
				"[$MESSAGE_SUBJECT$]",
				"[$MESSAGE_USER_ADDRESS$]",
				"[$MESSAGE_USER_NAME$]",
				"[$PORTAL_URL$]",
				"[$PORTLET_NAME$]"
			},
			new String[] {
				category.getName(),
				String.valueOf(company.getCompanyId()),
				company.getMx(),
				company.getName(),
				group.getName(),
				fromAddress,
				fromName,
				mailingListAddress,
				message.getBody(),
				String.valueOf(message.getMessageId()),
				message.getSubject(),
				emailAddress,
				fullName,
				company.getVirtualHost(),
				portletName
			});

		body = StringUtil.replace(
			body,
			new String[] {
				"[$CATEGORY_NAME$]",
				"[$COMPANY_ID$]",
				"[$COMPANY_MX$]",
				"[$COMPANY_NAME$]",
				"[$COMMUNITY_NAME$]",
				"[$FROM_ADDRESS$]",
				"[$FROM_NAME$]",
				"[$MAILING_LIST_ADDRESS$]",
				"[$MESSAGE_BODY$]",
				"[$MESSAGE_ID$]",
				"[$MESSAGE_SUBJECT$]",
				"[$MESSAGE_URL$]",
				"[$MESSAGE_USER_ADDRESS$]",
				"[$MESSAGE_USER_NAME$]",
				"[$PORTAL_URL$]",
				"[$PORTLET_NAME$]"
			},
			new String[] {
				category.getName(),
				String.valueOf(company.getCompanyId()),
				company.getMx(),
				company.getName(),
				group.getName(),
				fromAddress,
				fromName,
				mailingListAddress,
				message.getBody(),
				String.valueOf(message.getMessageId()),
				message.getSubject(),
				messageURL,
				emailAddress,
				fullName,
				company.getVirtualHost(),
				portletName
			});

		String subject = message.getSubject();

		if (subject.indexOf(subjectPrefix) == -1) {
			subject = subjectPrefix.trim() + " " + subject.trim();
		}

		String inReplyTo = null;

		if (message.getParentMessageId() !=
				MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {

			inReplyTo = MBUtil.getMailId(
				company.getMx(), message.getCategoryId(),
				message.getParentMessageId());
		}

		com.liferay.portal.kernel.messaging.Message messagingObj =
			new com.liferay.portal.kernel.messaging.Message();

		messagingObj.put("companyId", message.getCompanyId());
		messagingObj.put("userId", message.getUserId());
		messagingObj.put("groupId", message.getGroupId());
		messagingObj.put("categoryIds", StringUtil.merge(categoryIds));
		messagingObj.put("threadId", message.getThreadId());
		messagingObj.put("fromName", fromName);
		messagingObj.put("fromAddress", fromAddress);
		messagingObj.put("subject", subject);
		messagingObj.put("body", body);
		messagingObj.put("replyToAddress", replyToAddress);
		messagingObj.put("mailId", mailId);
		messagingObj.put("inReplyTo", inReplyTo);
		messagingObj.put("htmlFormat", htmlFormat);
		messagingObj.put(
			"sourceMailingList", MailingListThreadLocal.isSourceMailingList());

		MessageBusUtil.sendMessage(
			DestinationNames.MESSAGE_BOARDS, messagingObj);
	}

	protected void pingPingback(
		MBMessage message, ServiceContext serviceContext) {

		if (!PropsValues.BLOGS_PINGBACK_ENABLED ||
			!message.isAllowPingbacks() ||
			(message.getStatus() != WorkflowConstants.STATUS_APPROVED)) {

			return;
		}

		String layoutFullURL = serviceContext.getLayoutFullURL();

		if (Validator.isNull(layoutFullURL)) {
			return;
		}

		String sourceUri =
			layoutFullURL + Portal.FRIENDLY_URL_SEPARATOR +
				"message_boards/view_message/" + message.getMessageId();

		Source source = new Source(message.getBody(true));

		List<StartTag> startTags = source.getAllStartTags("a");

		for (StartTag startTag : startTags) {
			String targetUri = startTag.getAttributeValue("href");

			if (Validator.isNotNull(targetUri)) {
				try {
					LinkbackProducerUtil.sendPingback(sourceUri, targetUri);
				}
				catch (Exception e) {
					_log.error("Error while sending pingback " + targetUri, e);
				}
			}
		}
	}

	protected void sendBlogsCommentsEmail(
			long userId, BlogsEntry entry, MBMessage message,
			ServiceContext serviceContext)
		throws IOException, PortalException, SystemException {

		long companyId = message.getCompanyId();

		if (!PrefsPropsUtil.getBoolean(
				companyId, PropsKeys.BLOGS_EMAIL_COMMENTS_ADDED_ENABLED)) {

			return;
		}

		String layoutFullURL = serviceContext.getLayoutFullURL();

		String blogsEntryURL =
			layoutFullURL + Portal.FRIENDLY_URL_SEPARATOR + "blogs/" +
				entry.getUrlTitle();

		User user = userPersistence.findByPrimaryKey(userId);

		String fromName = PrefsPropsUtil.getString(
			companyId, PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromAddress = PrefsPropsUtil.getString(
			companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		String subject = PrefsPropsUtil.getContent(
			companyId, PropsKeys.BLOGS_EMAIL_COMMENTS_ADDED_SUBJECT);
		String body = PrefsPropsUtil.getContent(
			companyId, PropsKeys.BLOGS_EMAIL_COMMENTS_ADDED_BODY);

		subject = StringUtil.replace(
			subject,
			new String[] {
				"[$BLOGS_COMMENTS_BODY$]",
				"[$BLOGS_COMMENTS_USER_ADDRESS$]",
				"[$BLOGS_COMMENTS_USER_NAME$]",
				"[$BLOGS_ENTRY_URL$]",
				"[$FROM_ADDRESS$]",
				"[$FROM_NAME$]"
			},
			new String[] {
				message.getBody(),
				user.getEmailAddress(),
				user.getFullName(),
				blogsEntryURL,
				fromAddress,
				fromName
			});

		body = StringUtil.replace(
			body,
			new String[] {
				"[$BLOGS_COMMENTS_BODY$]",
				"[$BLOGS_COMMENTS_USER_ADDRESS$]",
				"[$BLOGS_COMMENTS_USER_NAME$]",
				"[$BLOGS_ENTRY_URL$]",
				"[$FROM_ADDRESS$]",
				"[$FROM_NAME$]"
			},
			new String[] {
				message.getBody(),
				user.getEmailAddress(),
				user.getFullName(),
				blogsEntryURL,
				fromAddress,
				fromName
			});

		Set<Long> sent = new HashSet<Long>();

		List<MBMessage> messages = mbMessagePersistence.findByThreadId(
			message.getThreadId());

		for (MBMessage curMessage : messages) {
			long curMessageUserId = curMessage.getUserId();

			if (curMessageUserId == userId) {
				continue;
			}

			if (sent.contains(curMessageUserId)) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Do not send a duplicate email to user " +
							curMessageUserId);
				}

				continue;
			}
			else {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Add user " + curMessageUserId +
							" to the list of users who have received an email");
				}

				sent.add(curMessageUserId);
			}

			User curMessageUser = null;

			try {
				curMessageUser = userLocalService.getUserById(curMessageUserId);
			}
			catch (NoSuchUserException nsue) {
				continue;
			}

			if (!curMessageUser.isActive()) {
				continue;
			}

			InternetAddress from = new InternetAddress(fromAddress, fromName);

			InternetAddress to = new InternetAddress(
				curMessageUser.getEmailAddress(), curMessageUser.getFullName());

			String curSubject = StringUtil.replace(
				subject,
				new String[] {
					"[$TO_ADDRESS$]",
					"[$TO_NAME$]"
				},
				new String[] {
					curMessageUser.getFullName(),
					curMessageUser.getEmailAddress()
				});

			String curBody = StringUtil.replace(
				body,
				new String[] {
					"[$TO_ADDRESS$]",
					"[$TO_NAME$]"
				},
				new String[] {
					curMessageUser.getFullName(),
					curMessageUser.getEmailAddress()
				});

			MailMessage mailMessage = new MailMessage(
				from, to, curSubject, curBody, true);

			mailService.sendEmail(mailMessage);
		}
	}

	protected void updateDiscussionMessageStatus(
			long userId, long messageId, int status, int oldStatus,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		String className = (String)serviceContext.getAttribute("className");
		long classPK = GetterUtil.getLong(
			(String)serviceContext.getAttribute("classPK"));

		MBMessage message = getMessage(messageId);

		if ((oldStatus != WorkflowConstants.STATUS_APPROVED) &&
			(status == WorkflowConstants.STATUS_APPROVED)) {

			// Social

			if (!message.isRoot()) {
				socialEquityLogLocalService.addEquityLogs(
					userId, className, classPK, ActionKeys.ADD_DISCUSSION);
			}

			long parentMessageId = message.getParentMessageId();

			if (className.equals(BlogsEntry.class.getName()) &&
				(parentMessageId !=
					MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID)) {

				// Social

				BlogsEntry entry = blogsEntryPersistence.findByPrimaryKey(
					classPK);

				JSONObject extraData = JSONFactoryUtil.createJSONObject();

				extraData.put("messageId", message.getMessageId());

				socialActivityLocalService.addActivity(
					userId, entry.getGroupId(), BlogsEntry.class.getName(),
					classPK, BlogsActivityKeys.ADD_COMMENT,
					extraData.toString(), entry.getUserId());

				// Email

				try {
					sendBlogsCommentsEmail(
						userId, entry, message, serviceContext);
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
		}
	}

	protected void updatePriorities(long threadId, double priority)
		throws SystemException {

		List<MBMessage> messages = mbMessagePersistence.findByThreadId(
			threadId);

		for (MBMessage message : messages) {
			if (message.getPriority() != priority) {
				message.setPriority(priority);

				mbMessagePersistence.update(message, false);
			}
		}
	}

	protected void validate(String subject, String body)
		throws PortalException {

		if (Validator.isNull(subject)) {
			throw new MessageSubjectException();
		}

		if (Validator.isNull(body)) {
			throw new MessageBodyException();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MBMessageLocalServiceImpl.class);

}