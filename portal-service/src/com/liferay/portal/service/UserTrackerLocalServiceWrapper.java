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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link UserTrackerLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       UserTrackerLocalService
 * @generated
 */
public class UserTrackerLocalServiceWrapper implements UserTrackerLocalService {
	public UserTrackerLocalServiceWrapper(
		UserTrackerLocalService userTrackerLocalService) {
		_userTrackerLocalService = userTrackerLocalService;
	}

	/**
	* Adds the user tracker to the database. Also notifies the appropriate model listeners.
	*
	* @param userTracker the user tracker to add
	* @return the user tracker that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserTracker addUserTracker(
		com.liferay.portal.model.UserTracker userTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTrackerLocalService.addUserTracker(userTracker);
	}

	/**
	* Creates a new user tracker with the primary key. Does not add the user tracker to the database.
	*
	* @param userTrackerId the primary key for the new user tracker
	* @return the new user tracker
	*/
	public com.liferay.portal.model.UserTracker createUserTracker(
		long userTrackerId) {
		return _userTrackerLocalService.createUserTracker(userTrackerId);
	}

	/**
	* Deletes the user tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userTrackerId the primary key of the user tracker to delete
	* @throws PortalException if a user tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserTracker(long userTrackerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userTrackerLocalService.deleteUserTracker(userTrackerId);
	}

	/**
	* Deletes the user tracker from the database. Also notifies the appropriate model listeners.
	*
	* @param userTracker the user tracker to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserTracker(
		com.liferay.portal.model.UserTracker userTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userTrackerLocalService.deleteUserTracker(userTracker);
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
		return _userTrackerLocalService.dynamicQuery(dynamicQuery);
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
		return _userTrackerLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _userTrackerLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _userTrackerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the user tracker with the primary key.
	*
	* @param userTrackerId the primary key of the user tracker to get
	* @return the user tracker
	* @throws PortalException if a user tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserTracker getUserTracker(
		long userTrackerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userTrackerLocalService.getUserTracker(userTrackerId);
	}

	/**
	* Gets a range of all the user trackers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user trackers to return
	* @param end the upper bound of the range of user trackers to return (not inclusive)
	* @return the range of user trackers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserTracker> getUserTrackers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTrackerLocalService.getUserTrackers(start, end);
	}

	/**
	* Gets the number of user trackers.
	*
	* @return the number of user trackers
	* @throws SystemException if a system exception occurred
	*/
	public int getUserTrackersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTrackerLocalService.getUserTrackersCount();
	}

	/**
	* Updates the user tracker in the database. Also notifies the appropriate model listeners.
	*
	* @param userTracker the user tracker to update
	* @return the user tracker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserTracker updateUserTracker(
		com.liferay.portal.model.UserTracker userTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTrackerLocalService.updateUserTracker(userTracker);
	}

	/**
	* Updates the user tracker in the database. Also notifies the appropriate model listeners.
	*
	* @param userTracker the user tracker to update
	* @param merge whether to merge the user tracker with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user tracker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserTracker updateUserTracker(
		com.liferay.portal.model.UserTracker userTracker, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTrackerLocalService.updateUserTracker(userTracker, merge);
	}

	public com.liferay.portal.model.UserTracker addUserTracker(long companyId,
		long userId, java.util.Date modifiedDate, java.lang.String sessionId,
		java.lang.String remoteAddr, java.lang.String remoteHost,
		java.lang.String userAgent,
		java.util.List<com.liferay.portal.model.UserTrackerPath> userTrackerPaths)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTrackerLocalService.addUserTracker(companyId, userId,
			modifiedDate, sessionId, remoteAddr, remoteHost, userAgent,
			userTrackerPaths);
	}

	public java.util.List<com.liferay.portal.model.UserTracker> getUserTrackers(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTrackerLocalService.getUserTrackers(companyId, start, end);
	}

	public UserTrackerLocalService getWrappedUserTrackerLocalService() {
		return _userTrackerLocalService;
	}

	private UserTrackerLocalService _userTrackerLocalService;
}