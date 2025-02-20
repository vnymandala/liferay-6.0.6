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

package com.liferay.portlet.tasks.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageService;
import com.liferay.portlet.messageboards.service.persistence.MBMessageFinder;
import com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence;
import com.liferay.portlet.social.service.SocialActivityLocalService;
import com.liferay.portlet.social.service.persistence.SocialActivityFinder;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;
import com.liferay.portlet.tasks.model.TasksProposal;
import com.liferay.portlet.tasks.service.TasksProposalLocalService;
import com.liferay.portlet.tasks.service.TasksProposalService;
import com.liferay.portlet.tasks.service.TasksReviewLocalService;
import com.liferay.portlet.tasks.service.TasksReviewService;
import com.liferay.portlet.tasks.service.persistence.TasksProposalFinder;
import com.liferay.portlet.tasks.service.persistence.TasksProposalPersistence;
import com.liferay.portlet.tasks.service.persistence.TasksReviewPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the tasks proposal local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.tasks.service.impl.TasksProposalLocalServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.tasks.service.TasksProposalLocalServiceUtil} to access the tasks proposal local service.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.tasks.service.impl.TasksProposalLocalServiceImpl
 * @see com.liferay.portlet.tasks.service.TasksProposalLocalServiceUtil
 * @generated
 */
public abstract class TasksProposalLocalServiceBaseImpl
	implements TasksProposalLocalService {
	/**
	 * Adds the tasks proposal to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tasksProposal the tasks proposal to add
	 * @return the tasks proposal that was added
	 * @throws SystemException if a system exception occurred
	 */
	public TasksProposal addTasksProposal(TasksProposal tasksProposal)
		throws SystemException {
		tasksProposal.setNew(true);

		return tasksProposalPersistence.update(tasksProposal, false);
	}

	/**
	 * Creates a new tasks proposal with the primary key. Does not add the tasks proposal to the database.
	 *
	 * @param proposalId the primary key for the new tasks proposal
	 * @return the new tasks proposal
	 */
	public TasksProposal createTasksProposal(long proposalId) {
		return tasksProposalPersistence.create(proposalId);
	}

	/**
	 * Deletes the tasks proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proposalId the primary key of the tasks proposal to delete
	 * @throws PortalException if a tasks proposal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteTasksProposal(long proposalId)
		throws PortalException, SystemException {
		tasksProposalPersistence.remove(proposalId);
	}

	/**
	 * Deletes the tasks proposal from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tasksProposal the tasks proposal to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteTasksProposal(TasksProposal tasksProposal)
		throws SystemException {
		tasksProposalPersistence.remove(tasksProposal);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return tasksProposalPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return tasksProposalPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return tasksProposalPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return tasksProposalPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the tasks proposal with the primary key.
	 *
	 * @param proposalId the primary key of the tasks proposal to get
	 * @return the tasks proposal
	 * @throws PortalException if a tasks proposal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TasksProposal getTasksProposal(long proposalId)
		throws PortalException, SystemException {
		return tasksProposalPersistence.findByPrimaryKey(proposalId);
	}

	/**
	 * Gets a range of all the tasks proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks proposals to return
	 * @param end the upper bound of the range of tasks proposals to return (not inclusive)
	 * @return the range of tasks proposals
	 * @throws SystemException if a system exception occurred
	 */
	public List<TasksProposal> getTasksProposals(int start, int end)
		throws SystemException {
		return tasksProposalPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of tasks proposals.
	 *
	 * @return the number of tasks proposals
	 * @throws SystemException if a system exception occurred
	 */
	public int getTasksProposalsCount() throws SystemException {
		return tasksProposalPersistence.countAll();
	}

	/**
	 * Updates the tasks proposal in the database. Also notifies the appropriate model listeners.
	 *
	 * @param tasksProposal the tasks proposal to update
	 * @return the tasks proposal that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public TasksProposal updateTasksProposal(TasksProposal tasksProposal)
		throws SystemException {
		tasksProposal.setNew(false);

		return tasksProposalPersistence.update(tasksProposal, true);
	}

	/**
	 * Updates the tasks proposal in the database. Also notifies the appropriate model listeners.
	 *
	 * @param tasksProposal the tasks proposal to update
	 * @param merge whether to merge the tasks proposal with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the tasks proposal that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public TasksProposal updateTasksProposal(TasksProposal tasksProposal,
		boolean merge) throws SystemException {
		tasksProposal.setNew(false);

		return tasksProposalPersistence.update(tasksProposal, merge);
	}

	/**
	 * Gets the tasks proposal local service.
	 *
	 * @return the tasks proposal local service
	 */
	public TasksProposalLocalService getTasksProposalLocalService() {
		return tasksProposalLocalService;
	}

	/**
	 * Sets the tasks proposal local service.
	 *
	 * @param tasksProposalLocalService the tasks proposal local service
	 */
	public void setTasksProposalLocalService(
		TasksProposalLocalService tasksProposalLocalService) {
		this.tasksProposalLocalService = tasksProposalLocalService;
	}

	/**
	 * Gets the tasks proposal remote service.
	 *
	 * @return the tasks proposal remote service
	 */
	public TasksProposalService getTasksProposalService() {
		return tasksProposalService;
	}

	/**
	 * Sets the tasks proposal remote service.
	 *
	 * @param tasksProposalService the tasks proposal remote service
	 */
	public void setTasksProposalService(
		TasksProposalService tasksProposalService) {
		this.tasksProposalService = tasksProposalService;
	}

	/**
	 * Gets the tasks proposal persistence.
	 *
	 * @return the tasks proposal persistence
	 */
	public TasksProposalPersistence getTasksProposalPersistence() {
		return tasksProposalPersistence;
	}

	/**
	 * Sets the tasks proposal persistence.
	 *
	 * @param tasksProposalPersistence the tasks proposal persistence
	 */
	public void setTasksProposalPersistence(
		TasksProposalPersistence tasksProposalPersistence) {
		this.tasksProposalPersistence = tasksProposalPersistence;
	}

	/**
	 * Gets the tasks proposal finder.
	 *
	 * @return the tasks proposal finder
	 */
	public TasksProposalFinder getTasksProposalFinder() {
		return tasksProposalFinder;
	}

	/**
	 * Sets the tasks proposal finder.
	 *
	 * @param tasksProposalFinder the tasks proposal finder
	 */
	public void setTasksProposalFinder(TasksProposalFinder tasksProposalFinder) {
		this.tasksProposalFinder = tasksProposalFinder;
	}

	/**
	 * Gets the tasks review local service.
	 *
	 * @return the tasks review local service
	 */
	public TasksReviewLocalService getTasksReviewLocalService() {
		return tasksReviewLocalService;
	}

	/**
	 * Sets the tasks review local service.
	 *
	 * @param tasksReviewLocalService the tasks review local service
	 */
	public void setTasksReviewLocalService(
		TasksReviewLocalService tasksReviewLocalService) {
		this.tasksReviewLocalService = tasksReviewLocalService;
	}

	/**
	 * Gets the tasks review remote service.
	 *
	 * @return the tasks review remote service
	 */
	public TasksReviewService getTasksReviewService() {
		return tasksReviewService;
	}

	/**
	 * Sets the tasks review remote service.
	 *
	 * @param tasksReviewService the tasks review remote service
	 */
	public void setTasksReviewService(TasksReviewService tasksReviewService) {
		this.tasksReviewService = tasksReviewService;
	}

	/**
	 * Gets the tasks review persistence.
	 *
	 * @return the tasks review persistence
	 */
	public TasksReviewPersistence getTasksReviewPersistence() {
		return tasksReviewPersistence;
	}

	/**
	 * Sets the tasks review persistence.
	 *
	 * @param tasksReviewPersistence the tasks review persistence
	 */
	public void setTasksReviewPersistence(
		TasksReviewPersistence tasksReviewPersistence) {
		this.tasksReviewPersistence = tasksReviewPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the resource finder.
	 *
	 * @return the resource finder
	 */
	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	/**
	 * Sets the resource finder.
	 *
	 * @param resourceFinder the resource finder
	 */
	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the user finder.
	 *
	 * @return the user finder
	 */
	public UserFinder getUserFinder() {
		return userFinder;
	}

	/**
	 * Sets the user finder.
	 *
	 * @param userFinder the user finder
	 */
	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	/**
	 * Gets the message-boards message local service.
	 *
	 * @return the message-boards message local service
	 */
	public MBMessageLocalService getMBMessageLocalService() {
		return mbMessageLocalService;
	}

	/**
	 * Sets the message-boards message local service.
	 *
	 * @param mbMessageLocalService the message-boards message local service
	 */
	public void setMBMessageLocalService(
		MBMessageLocalService mbMessageLocalService) {
		this.mbMessageLocalService = mbMessageLocalService;
	}

	/**
	 * Gets the message-boards message remote service.
	 *
	 * @return the message-boards message remote service
	 */
	public MBMessageService getMBMessageService() {
		return mbMessageService;
	}

	/**
	 * Sets the message-boards message remote service.
	 *
	 * @param mbMessageService the message-boards message remote service
	 */
	public void setMBMessageService(MBMessageService mbMessageService) {
		this.mbMessageService = mbMessageService;
	}

	/**
	 * Gets the message-boards message persistence.
	 *
	 * @return the message-boards message persistence
	 */
	public MBMessagePersistence getMBMessagePersistence() {
		return mbMessagePersistence;
	}

	/**
	 * Sets the message-boards message persistence.
	 *
	 * @param mbMessagePersistence the message-boards message persistence
	 */
	public void setMBMessagePersistence(
		MBMessagePersistence mbMessagePersistence) {
		this.mbMessagePersistence = mbMessagePersistence;
	}

	/**
	 * Gets the message-boards message finder.
	 *
	 * @return the message-boards message finder
	 */
	public MBMessageFinder getMBMessageFinder() {
		return mbMessageFinder;
	}

	/**
	 * Sets the message-boards message finder.
	 *
	 * @param mbMessageFinder the message-boards message finder
	 */
	public void setMBMessageFinder(MBMessageFinder mbMessageFinder) {
		this.mbMessageFinder = mbMessageFinder;
	}

	/**
	 * Gets the social activity local service.
	 *
	 * @return the social activity local service
	 */
	public SocialActivityLocalService getSocialActivityLocalService() {
		return socialActivityLocalService;
	}

	/**
	 * Sets the social activity local service.
	 *
	 * @param socialActivityLocalService the social activity local service
	 */
	public void setSocialActivityLocalService(
		SocialActivityLocalService socialActivityLocalService) {
		this.socialActivityLocalService = socialActivityLocalService;
	}

	/**
	 * Gets the social activity persistence.
	 *
	 * @return the social activity persistence
	 */
	public SocialActivityPersistence getSocialActivityPersistence() {
		return socialActivityPersistence;
	}

	/**
	 * Sets the social activity persistence.
	 *
	 * @param socialActivityPersistence the social activity persistence
	 */
	public void setSocialActivityPersistence(
		SocialActivityPersistence socialActivityPersistence) {
		this.socialActivityPersistence = socialActivityPersistence;
	}

	/**
	 * Gets the social activity finder.
	 *
	 * @return the social activity finder
	 */
	public SocialActivityFinder getSocialActivityFinder() {
		return socialActivityFinder;
	}

	/**
	 * Sets the social activity finder.
	 *
	 * @param socialActivityFinder the social activity finder
	 */
	public void setSocialActivityFinder(
		SocialActivityFinder socialActivityFinder) {
		this.socialActivityFinder = socialActivityFinder;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tasksProposalPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = TasksProposalLocalService.class)
	protected TasksProposalLocalService tasksProposalLocalService;
	@BeanReference(type = TasksProposalService.class)
	protected TasksProposalService tasksProposalService;
	@BeanReference(type = TasksProposalPersistence.class)
	protected TasksProposalPersistence tasksProposalPersistence;
	@BeanReference(type = TasksProposalFinder.class)
	protected TasksProposalFinder tasksProposalFinder;
	@BeanReference(type = TasksReviewLocalService.class)
	protected TasksReviewLocalService tasksReviewLocalService;
	@BeanReference(type = TasksReviewService.class)
	protected TasksReviewService tasksReviewService;
	@BeanReference(type = TasksReviewPersistence.class)
	protected TasksReviewPersistence tasksReviewPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceFinder.class)
	protected ResourceFinder resourceFinder;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserFinder.class)
	protected UserFinder userFinder;
	@BeanReference(type = MBMessageLocalService.class)
	protected MBMessageLocalService mbMessageLocalService;
	@BeanReference(type = MBMessageService.class)
	protected MBMessageService mbMessageService;
	@BeanReference(type = MBMessagePersistence.class)
	protected MBMessagePersistence mbMessagePersistence;
	@BeanReference(type = MBMessageFinder.class)
	protected MBMessageFinder mbMessageFinder;
	@BeanReference(type = SocialActivityLocalService.class)
	protected SocialActivityLocalService socialActivityLocalService;
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	@BeanReference(type = SocialActivityFinder.class)
	protected SocialActivityFinder socialActivityFinder;
}