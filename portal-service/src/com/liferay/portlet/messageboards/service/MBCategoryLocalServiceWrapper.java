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

package com.liferay.portlet.messageboards.service;

/**
 * <p>
 * This class is a wrapper for {@link MBCategoryLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBCategoryLocalService
 * @generated
 */
public class MBCategoryLocalServiceWrapper implements MBCategoryLocalService {
	public MBCategoryLocalServiceWrapper(
		MBCategoryLocalService mbCategoryLocalService) {
		_mbCategoryLocalService = mbCategoryLocalService;
	}

	/**
	* Adds the message boards category to the database. Also notifies the appropriate model listeners.
	*
	* @param mbCategory the message boards category to add
	* @return the message boards category that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBCategory addMBCategory(
		com.liferay.portlet.messageboards.model.MBCategory mbCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.addMBCategory(mbCategory);
	}

	/**
	* Creates a new message boards category with the primary key. Does not add the message boards category to the database.
	*
	* @param categoryId the primary key for the new message boards category
	* @return the new message boards category
	*/
	public com.liferay.portlet.messageboards.model.MBCategory createMBCategory(
		long categoryId) {
		return _mbCategoryLocalService.createMBCategory(categoryId);
	}

	/**
	* Deletes the message boards category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the message boards category to delete
	* @throws PortalException if a message boards category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMBCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.deleteMBCategory(categoryId);
	}

	/**
	* Deletes the message boards category from the database. Also notifies the appropriate model listeners.
	*
	* @param mbCategory the message boards category to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMBCategory(
		com.liferay.portlet.messageboards.model.MBCategory mbCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.deleteMBCategory(mbCategory);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the message boards category with the primary key.
	*
	* @param categoryId the primary key of the message boards category to get
	* @return the message boards category
	* @throws PortalException if a message boards category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBCategory getMBCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getMBCategory(categoryId);
	}

	/**
	* Gets the message boards category with the UUID and group id.
	*
	* @param uuid the UUID of message boards category to get
	* @param groupId the group id of the message boards category to get
	* @return the message boards category
	* @throws PortalException if a message boards category with the UUID and group id could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBCategory getMBCategoryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getMBCategoryByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Gets a range of all the message boards categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of message boards categories to return
	* @param end the upper bound of the range of message boards categories to return (not inclusive)
	* @return the range of message boards categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getMBCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getMBCategories(start, end);
	}

	/**
	* Gets the number of message boards categories.
	*
	* @return the number of message boards categories
	* @throws SystemException if a system exception occurred
	*/
	public int getMBCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getMBCategoriesCount();
	}

	/**
	* Updates the message boards category in the database. Also notifies the appropriate model listeners.
	*
	* @param mbCategory the message boards category to update
	* @return the message boards category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBCategory updateMBCategory(
		com.liferay.portlet.messageboards.model.MBCategory mbCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.updateMBCategory(mbCategory);
	}

	/**
	* Updates the message boards category in the database. Also notifies the appropriate model listeners.
	*
	* @param mbCategory the message boards category to update
	* @param merge whether to merge the message boards category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the message boards category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBCategory updateMBCategory(
		com.liferay.portlet.messageboards.model.MBCategory mbCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.updateMBCategory(mbCategory, merge);
	}

	public com.liferay.portlet.messageboards.model.MBCategory addCategory(
		long userId, long parentCategoryId, java.lang.String name,
		java.lang.String description, java.lang.String emailAddress,
		java.lang.String inProtocol, java.lang.String inServerName,
		int inServerPort, boolean inUseSSL, java.lang.String inUserName,
		java.lang.String inPassword, int inReadInterval,
		java.lang.String outEmailAddress, boolean outCustom,
		java.lang.String outServerName, int outServerPort, boolean outUseSSL,
		java.lang.String outUserName, java.lang.String outPassword,
		boolean mailingListActive,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.addCategory(userId, parentCategoryId,
			name, description, emailAddress, inProtocol, inServerName,
			inServerPort, inUseSSL, inUserName, inPassword, inReadInterval,
			outEmailAddress, outCustom, outServerName, outServerPort,
			outUseSSL, outUserName, outPassword, mailingListActive,
			serviceContext);
	}

	public void addCategoryResources(long categoryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.addCategoryResources(categoryId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addCategoryResources(long categoryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.addCategoryResources(categoryId,
			communityPermissions, guestPermissions);
	}

	public void addCategoryResources(
		com.liferay.portlet.messageboards.model.MBCategory category,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.addCategoryResources(category,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addCategoryResources(
		com.liferay.portlet.messageboards.model.MBCategory category,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.addCategoryResources(category,
			communityPermissions, guestPermissions);
	}

	public void deleteCategories(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.deleteCategories(groupId);
	}

	public void deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.deleteCategory(categoryId);
	}

	public void deleteCategory(
		com.liferay.portlet.messageboards.model.MBCategory category)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.deleteCategory(category);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCategories(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getCategories(groupId);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCategories(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getCategories(groupId, parentCategoryId,
			start, end);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCategories(
		long groupId, long[] parentCategoryIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getCategories(groupId,
			parentCategoryIds, start, end);
	}

	public int getCategoriesCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getCategoriesCount(groupId);
	}

	public int getCategoriesCount(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getCategoriesCount(groupId,
			parentCategoryId);
	}

	public int getCategoriesCount(long groupId, long[] parentCategoryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getCategoriesCount(groupId,
			parentCategoryIds);
	}

	public com.liferay.portlet.messageboards.model.MBCategory getCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getCategory(categoryId);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCompanyCategories(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getCompanyCategories(companyId, start,
			end);
	}

	public int getCompanyCategoriesCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getCompanyCategoriesCount(companyId);
	}

	public java.util.List<java.lang.Long> getSubcategoryIds(
		java.util.List<java.lang.Long> categoryIds, long groupId,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getSubcategoryIds(categoryIds, groupId,
			categoryId);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getSubscribedCategories(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getSubscribedCategories(groupId, userId,
			start, end);
	}

	public int getSubscribedCategoriesCount(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.getSubscribedCategoriesCount(groupId,
			userId);
	}

	public void subscribeCategory(long userId, long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.subscribeCategory(userId, groupId, categoryId);
	}

	public void unsubscribeCategory(long userId, long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbCategoryLocalService.unsubscribeCategory(userId, groupId, categoryId);
	}

	public com.liferay.portlet.messageboards.model.MBCategory updateCategory(
		long categoryId, long parentCategoryId, java.lang.String name,
		java.lang.String description, java.lang.String emailAddress,
		java.lang.String inProtocol, java.lang.String inServerName,
		int inServerPort, boolean inUseSSL, java.lang.String inUserName,
		java.lang.String inPassword, int inReadInterval,
		java.lang.String outEmailAddress, boolean outCustom,
		java.lang.String outServerName, int outServerPort, boolean outUseSSL,
		java.lang.String outUserName, java.lang.String outPassword,
		boolean mailingListActive, boolean mergeWithParentCategory,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbCategoryLocalService.updateCategory(categoryId,
			parentCategoryId, name, description, emailAddress, inProtocol,
			inServerName, inServerPort, inUseSSL, inUserName, inPassword,
			inReadInterval, outEmailAddress, outCustom, outServerName,
			outServerPort, outUseSSL, outUserName, outPassword,
			mailingListActive, mergeWithParentCategory, serviceContext);
	}

	public MBCategoryLocalService getWrappedMBCategoryLocalService() {
		return _mbCategoryLocalService;
	}

	private MBCategoryLocalService _mbCategoryLocalService;
}