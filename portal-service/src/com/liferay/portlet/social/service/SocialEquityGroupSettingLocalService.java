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

package com.liferay.portlet.social.service;

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the social equity group setting local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link SocialEquityGroupSettingLocalServiceUtil} to access the social equity group setting local service. Add custom service methods to {@link com.liferay.portlet.social.service.impl.SocialEquityGroupSettingLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialEquityGroupSettingLocalServiceUtil
 * @see com.liferay.portlet.social.service.base.SocialEquityGroupSettingLocalServiceBaseImpl
 * @see com.liferay.portlet.social.service.impl.SocialEquityGroupSettingLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SocialEquityGroupSettingLocalService {
	/**
	* Adds the social equity group setting to the database. Also notifies the appropriate model listeners.
	*
	* @param socialEquityGroupSetting the social equity group setting to add
	* @return the social equity group setting that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityGroupSetting addSocialEquityGroupSetting(
		com.liferay.portlet.social.model.SocialEquityGroupSetting socialEquityGroupSetting)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new social equity group setting with the primary key. Does not add the social equity group setting to the database.
	*
	* @param equityGroupSettingId the primary key for the new social equity group setting
	* @return the new social equity group setting
	*/
	public com.liferay.portlet.social.model.SocialEquityGroupSetting createSocialEquityGroupSetting(
		long equityGroupSettingId);

	/**
	* Deletes the social equity group setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param equityGroupSettingId the primary key of the social equity group setting to delete
	* @throws PortalException if a social equity group setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSocialEquityGroupSetting(long equityGroupSettingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the social equity group setting from the database. Also notifies the appropriate model listeners.
	*
	* @param socialEquityGroupSetting the social equity group setting to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSocialEquityGroupSetting(
		com.liferay.portlet.social.model.SocialEquityGroupSetting socialEquityGroupSetting)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the social equity group setting with the primary key.
	*
	* @param equityGroupSettingId the primary key of the social equity group setting to get
	* @return the social equity group setting
	* @throws PortalException if a social equity group setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portlet.social.model.SocialEquityGroupSetting getSocialEquityGroupSetting(
		long equityGroupSettingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the social equity group settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of social equity group settings to return
	* @param end the upper bound of the range of social equity group settings to return (not inclusive)
	* @return the range of social equity group settings
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portlet.social.model.SocialEquityGroupSetting> getSocialEquityGroupSettings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of social equity group settings.
	*
	* @return the number of social equity group settings
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSocialEquityGroupSettingsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the social equity group setting in the database. Also notifies the appropriate model listeners.
	*
	* @param socialEquityGroupSetting the social equity group setting to update
	* @return the social equity group setting that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityGroupSetting updateSocialEquityGroupSetting(
		com.liferay.portlet.social.model.SocialEquityGroupSetting socialEquityGroupSetting)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the social equity group setting in the database. Also notifies the appropriate model listeners.
	*
	* @param socialEquityGroupSetting the social equity group setting to update
	* @param merge whether to merge the social equity group setting with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the social equity group setting that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityGroupSetting updateSocialEquityGroupSetting(
		com.liferay.portlet.social.model.SocialEquityGroupSetting socialEquityGroupSetting,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isEnabled(long groupId, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isEnabled(long groupId, java.lang.String className, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateEquityGroupSetting(long groupId,
		java.lang.String className, int type, boolean value)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}