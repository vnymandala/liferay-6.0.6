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

package com.liferay.portlet.journal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Image;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.journal.DuplicateTemplateIdException;
import com.liferay.portlet.journal.NoSuchTemplateException;
import com.liferay.portlet.journal.RequiredTemplateException;
import com.liferay.portlet.journal.TemplateDescriptionException;
import com.liferay.portlet.journal.TemplateIdException;
import com.liferay.portlet.journal.TemplateNameException;
import com.liferay.portlet.journal.TemplateSmallImageNameException;
import com.liferay.portlet.journal.TemplateSmallImageSizeException;
import com.liferay.portlet.journal.TemplateXslException;
import com.liferay.portlet.journal.model.JournalTemplate;
import com.liferay.portlet.journal.model.JournalTemplateConstants;
import com.liferay.portlet.journal.service.base.JournalTemplateLocalServiceBaseImpl;
import com.liferay.portlet.journal.util.JournalUtil;

import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class JournalTemplateLocalServiceImpl
	extends JournalTemplateLocalServiceBaseImpl {

	public JournalTemplate addTemplate(
			long userId, long groupId, String templateId,
			boolean autoTemplateId, String structureId, String name,
			String description, String xsl, boolean formatXsl, String langType,
			boolean cacheable, boolean smallImage, String smallImageURL,
			File smallFile, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Template

		User user = userPersistence.findByPrimaryKey(userId);
		templateId = templateId.trim().toUpperCase();
		Date now = new Date();

		try {
			if (formatXsl) {
				if (langType.equals(JournalTemplateConstants.LANG_TYPE_VM)) {
					xsl = JournalUtil.formatVM(xsl);
				}
				else {
					xsl = JournalUtil.formatXML(xsl);
				}
			}
		}
		catch (Exception e) {
			throw new TemplateXslException();
		}

		byte[] smallBytes = null;

		try {
			smallBytes = FileUtil.getBytes(smallFile);
		}
		catch (IOException ioe) {
		}

		validate(
			groupId, templateId, autoTemplateId, name, description, xsl,
			smallImage, smallImageURL, smallFile, smallBytes);

		if (autoTemplateId) {
			templateId = String.valueOf(counterLocalService.increment());
		}

		long id = counterLocalService.increment();

		JournalTemplate template = journalTemplatePersistence.create(id);

		template.setUuid(serviceContext.getUuid());
		template.setGroupId(groupId);
		template.setCompanyId(user.getCompanyId());
		template.setUserId(user.getUserId());
		template.setUserName(user.getFullName());
		template.setCreateDate(serviceContext.getCreateDate(now));
		template.setModifiedDate(serviceContext.getModifiedDate(now));
		template.setTemplateId(templateId);
		template.setStructureId(structureId);
		template.setName(name);
		template.setDescription(description);
		template.setXsl(xsl);
		template.setLangType(langType);
		template.setCacheable(cacheable);
		template.setSmallImage(smallImage);
		template.setSmallImageId(counterLocalService.increment());
		template.setSmallImageURL(smallImageURL);

		journalTemplatePersistence.update(template, false);

		// Resources

		if (serviceContext.getAddCommunityPermissions() ||
			serviceContext.getAddGuestPermissions()) {

			addTemplateResources(
				template, serviceContext.getAddCommunityPermissions(),
				serviceContext.getAddGuestPermissions());
		}
		else {
			addTemplateResources(
				template, serviceContext.getCommunityPermissions(),
				serviceContext.getGuestPermissions());
		}

		// Expando

		ExpandoBridge expandoBridge = template.getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);

		// Small image

		saveImages(
			smallImage, template.getSmallImageId(), smallFile, smallBytes);

		return template;
	}

	public void addTemplateResources(
			long groupId, String templateId, boolean addCommunityPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		JournalTemplate template = journalTemplatePersistence.findByG_T(
			groupId, templateId);

		addTemplateResources(
			template, addCommunityPermissions, addGuestPermissions);
	}

	public void addTemplateResources(
			JournalTemplate template, boolean addCommunityPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			template.getCompanyId(), template.getGroupId(),
			template.getUserId(), JournalTemplate.class.getName(),
			template.getId(), false, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addTemplateResources(
			long groupId, String templateId, String[] communityPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		JournalTemplate template = journalTemplatePersistence.findByG_T(
			groupId, templateId);

		addTemplateResources(template, communityPermissions, guestPermissions);
	}

	public void addTemplateResources(
			JournalTemplate template, String[] communityPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			template.getCompanyId(), template.getGroupId(),
			template.getUserId(), JournalTemplate.class.getName(),
			template.getId(), communityPermissions, guestPermissions);
	}

	public void checkNewLine(long groupId, String templateId)
		throws PortalException, SystemException {

		JournalTemplate template = journalTemplatePersistence.findByG_T(
			groupId, templateId);

		String xsl = template.getXsl();

		if ((xsl != null) && (xsl.indexOf("\\n") != -1)) {
			xsl = StringUtil.replace(
				xsl,
				new String[] {"\\n", "\\r"},
				new String[] {"\n", "\r"});

			template.setXsl(xsl);

			journalTemplatePersistence.update(template, false);
		}
	}

	public JournalTemplate copyTemplate(
			long userId, long groupId, String oldTemplateId,
			String newTemplateId, boolean autoTemplateId)
		throws PortalException, SystemException {

		// Template

		User user = userPersistence.findByPrimaryKey(userId);
		oldTemplateId = oldTemplateId.trim().toUpperCase();
		newTemplateId = newTemplateId.trim().toUpperCase();
		Date now = new Date();

		JournalTemplate oldTemplate = journalTemplatePersistence.findByG_T(
			groupId, oldTemplateId);

		if (autoTemplateId) {
			newTemplateId = String.valueOf(counterLocalService.increment());
		}
		else {
			validate(newTemplateId);

			JournalTemplate newTemplate = journalTemplatePersistence.fetchByG_T(
				groupId, newTemplateId);

			if (newTemplate != null) {
				throw new DuplicateTemplateIdException();
			}
		}

		long id = counterLocalService.increment();

		JournalTemplate newTemplate = journalTemplatePersistence.create(id);

		newTemplate.setGroupId(groupId);
		newTemplate.setCompanyId(user.getCompanyId());
		newTemplate.setUserId(user.getUserId());
		newTemplate.setUserName(user.getFullName());
		newTemplate.setCreateDate(now);
		newTemplate.setModifiedDate(now);
		newTemplate.setTemplateId(newTemplateId);
		newTemplate.setStructureId(oldTemplate.getStructureId());
		newTemplate.setName(oldTemplate.getName());
		newTemplate.setDescription(oldTemplate.getDescription());
		newTemplate.setXsl(oldTemplate.getXsl());
		newTemplate.setLangType(oldTemplate.getLangType());
		newTemplate.setCacheable(oldTemplate.isCacheable());
		newTemplate.setSmallImage(oldTemplate.isSmallImage());
		newTemplate.setSmallImageId(counterLocalService.increment());
		newTemplate.setSmallImageURL(oldTemplate.getSmallImageURL());

		journalTemplatePersistence.update(newTemplate, false);

		// Small image

		if (oldTemplate.getSmallImage()) {
			Image image = imageLocalService.getImage(
				oldTemplate.getSmallImageId());

			byte[] smallBytes = image.getTextObj();

			imageLocalService.updateImage(
				newTemplate.getSmallImageId(), smallBytes);
		}

		// Resources

		addTemplateResources(newTemplate, true, true);

		return newTemplate;
	}

	public void deleteTemplate(long groupId, String templateId)
		throws PortalException, SystemException {

		templateId = templateId.trim().toUpperCase();

		JournalTemplate template = journalTemplatePersistence.findByG_T(
			groupId, templateId);

		deleteTemplate(template);
	}

	public void deleteTemplate(JournalTemplate template)
		throws PortalException, SystemException {

		if (journalArticlePersistence.countByG_T(
				template.getGroupId(), template.getTemplateId()) > 0) {

			throw new RequiredTemplateException();
		}

		// WebDAVProps

		webDAVPropsLocalService.deleteWebDAVProps(
			JournalTemplate.class.getName(), template.getId());

		// Small image

		imageLocalService.deleteImage(template.getSmallImageId());

		// Expando

		expandoValueLocalService.deleteValues(
			JournalTemplate.class.getName(), template.getId());

		// Resources

		resourceLocalService.deleteResource(
			template.getCompanyId(), JournalTemplate.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, template.getId());

		// Template

		journalTemplatePersistence.remove(template);
	}

	public void deleteTemplates(long groupId)
		throws PortalException, SystemException {

		for (JournalTemplate template :
				journalTemplatePersistence.findByGroupId(groupId)) {

			deleteTemplate(template);
		}
	}

	public List<JournalTemplate> getStructureTemplates(
			long groupId, String structureId)
		throws SystemException {

		return journalTemplatePersistence.findByG_S(groupId, structureId);
	}

	public List<JournalTemplate> getStructureTemplates(
			long groupId, String structureId, int start, int end)
		throws SystemException {

		return journalTemplatePersistence.findByG_S(
			groupId, structureId, start, end);
	}

	public int getStructureTemplatesCount(long groupId, String structureId)
		throws SystemException {

		return journalTemplatePersistence.countByG_S(groupId, structureId);
	}

	public JournalTemplate getTemplate(long id)
		throws PortalException, SystemException {

		return journalTemplatePersistence.findByPrimaryKey(id);
	}

	public JournalTemplate getTemplate(long groupId, String templateId)
		throws PortalException, SystemException {

		templateId = GetterUtil.getString(templateId).toUpperCase();

		if (groupId == 0) {
			_log.error(
				"No group id was passed for " + templateId + ". Group id is " +
					"required since 4.2.0. Please update all custom code and " +
						"data that references templates without a group id.");

			List<JournalTemplate> templates =
				journalTemplatePersistence.findByTemplateId(
					templateId);

			if (templates.size() == 0) {
				throw new NoSuchTemplateException(
					"No JournalTemplate exists with the template id " +
						templateId);
			}
			else {
				return templates.get(0);
			}
		}
		else {
			return journalTemplatePersistence.findByG_T(groupId, templateId);
		}
	}

	public JournalTemplate getTemplateBySmallImageId(long smallImageId)
		throws PortalException, SystemException {

		return journalTemplatePersistence.findBySmallImageId(smallImageId);
	}

	public List<JournalTemplate> getTemplates() throws SystemException {
		return journalTemplatePersistence.findAll();
	}

	public List<JournalTemplate> getTemplates(long groupId)
		throws SystemException {

		return journalTemplatePersistence.findByGroupId(groupId);
	}

	public List<JournalTemplate> getTemplates(long groupId, int start, int end)
		throws SystemException {

		return journalTemplatePersistence.findByGroupId(groupId, start, end);
	}

	public int getTemplatesCount(long groupId) throws SystemException {
		return journalTemplatePersistence.countByGroupId(groupId);
	}

	public boolean hasTemplate(long groupId, String templateId)
		throws SystemException {

		try {
			getTemplate(groupId, templateId);

			return true;
		}
		catch (PortalException pe) {
			return false;
		}
	}

	public List<JournalTemplate> search(
			long companyId, long groupId, String keywords, String structureId,
			String structureIdComparator, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		return journalTemplateFinder.findByKeywords(
			companyId, groupId, keywords, structureId, structureIdComparator,
			start, end, obc);
	}

	public List<JournalTemplate> search(
			long companyId, long groupId, String templateId, String structureId,
			String structureIdComparator, String name, String description,
			boolean andOperator, int start, int end, OrderByComparator obc)
		throws SystemException {

		return journalTemplateFinder.findByC_G_T_S_N_D(
			companyId, groupId, templateId, structureId, structureIdComparator,
			name, description, andOperator, start, end, obc);
	}

	public int searchCount(
			long companyId, long groupId, String keywords, String structureId,
			String structureIdComparator)
		throws SystemException {

		return journalTemplateFinder.countByKeywords(
			companyId, groupId, keywords, structureId, structureIdComparator);
	}

	public int searchCount(
			long companyId, long groupId, String templateId, String structureId,
			String structureIdComparator, String name, String description,
			boolean andOperator)
		throws SystemException {

		return journalTemplateFinder.countByC_G_T_S_N_D(
			companyId, groupId, templateId, structureId, structureIdComparator,
			name, description, andOperator);
	}

	public JournalTemplate updateTemplate(
			long groupId, String templateId, String structureId, String name,
			String description, String xsl, boolean formatXsl, String langType,
			boolean cacheable, boolean smallImage, String smallImageURL,
			File smallFile, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Template

		templateId = templateId.trim().toUpperCase();

		try {
			if (formatXsl) {
				if (langType.equals(JournalTemplateConstants.LANG_TYPE_VM)) {
					xsl = JournalUtil.formatVM(xsl);
				}
				else {
					xsl = JournalUtil.formatXML(xsl);
				}
			}
		}
		catch (Exception e) {
			throw new TemplateXslException();
		}

		byte[] smallBytes = null;

		try {
			smallBytes = FileUtil.getBytes(smallFile);
		}
		catch (IOException ioe) {
		}

		validate(
			name, description, xsl, smallImage, smallImageURL, smallFile,
			smallBytes);

		JournalTemplate template = journalTemplatePersistence.findByG_T(
			groupId, templateId);

		template.setModifiedDate(new Date());

		if (Validator.isNull(template.getStructureId()) &&
			Validator.isNotNull(structureId)) {

			// Allow users to set the structure if and only if it currently
			// does not have one. Otherwise, you can have bad data because there
			// may be an existing article that has chosen to use a structure and
			// template combination that no longer exists.

			template.setStructureId(structureId);
		}

		template.setName(name);
		template.setDescription(description);
		template.setXsl(xsl);
		template.setLangType(langType);
		template.setCacheable(cacheable);
		template.setSmallImage(smallImage);
		template.setSmallImageURL(smallImageURL);
		template.setModifiedDate(serviceContext.getModifiedDate(null));

		journalTemplatePersistence.update(template, false);

		// Expando

		ExpandoBridge expandoBridge = template.getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);

		// Small image

		saveImages(
			smallImage, template.getSmallImageId(), smallFile, smallBytes);

		return template;
	}

	protected void saveImages(
			boolean smallImage, long smallImageId, File smallFile,
			byte[] smallBytes)
		throws PortalException, SystemException {

		if (smallImage) {
			if ((smallFile != null) && (smallBytes != null)) {
				imageLocalService.updateImage(smallImageId, smallBytes);
			}
		}
		else {
			imageLocalService.deleteImage(smallImageId);
		}
	}

	protected void validate(String templateId) throws PortalException {
		if ((Validator.isNull(templateId)) ||
			(Validator.isNumber(templateId)) ||
			(templateId.indexOf(CharPool.SPACE) != -1)) {

			throw new TemplateIdException();
		}
	}

	protected void validate(
			long groupId, String templateId, boolean autoTemplateId,
			String name, String description, String xsl, boolean smallImage,
			String smallImageURL, File smallFile, byte[] smallBytes)
		throws PortalException, SystemException {

		if (!autoTemplateId) {
			validate(templateId);

			JournalTemplate template = journalTemplatePersistence.fetchByG_T(
				groupId, templateId);

			if (template != null) {
				throw new DuplicateTemplateIdException();
			}
		}

		validate(
			name, description, xsl, smallImage, smallImageURL, smallFile,
			smallBytes);
	}

	protected void validate(
			String name, String description, String xsl, boolean smallImage,
			String smallImageURL, File smallFile, byte[] smallBytes)
		throws PortalException, SystemException {

		if (Validator.isNull(name)) {
			throw new TemplateNameException();
		}
		else if (Validator.isNull(description)) {
			throw new TemplateDescriptionException();
		}
		else if (Validator.isNull(xsl)) {
			throw new TemplateXslException();
		}

		String[] imageExtensions = PrefsPropsUtil.getStringArray(
			PropsKeys.JOURNAL_IMAGE_EXTENSIONS, StringPool.COMMA);

		if (smallImage && Validator.isNull(smallImageURL) &&
			smallFile != null && smallBytes != null) {

			String smallImageName = smallFile.getName();

			if (smallImageName != null) {
				boolean validSmallImageExtension = false;

				for (int i = 0; i < imageExtensions.length; i++) {
					if (StringPool.STAR.equals(imageExtensions[i]) ||
						StringUtil.endsWith(
							smallImageName, imageExtensions[i])) {

						validSmallImageExtension = true;

						break;
					}
				}

				if (!validSmallImageExtension) {
					throw new TemplateSmallImageNameException(smallImageName);
				}
			}

			long smallImageMaxSize = PrefsPropsUtil.getLong(
				PropsKeys.JOURNAL_IMAGE_SMALL_MAX_SIZE);

			if ((smallImageMaxSize > 0) &&
				((smallBytes == null) ||
					(smallBytes.length > smallImageMaxSize))) {

				throw new TemplateSmallImageSizeException();
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		JournalTemplateLocalServiceImpl.class);

}