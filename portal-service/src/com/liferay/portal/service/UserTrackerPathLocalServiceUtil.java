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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the user tracker path local service. This utility wraps {@link com.liferay.portal.service.impl.UserTrackerPathLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.UserTrackerPathLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTrackerPathLocalService
 * @see com.liferay.portal.service.base.UserTrackerPathLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.UserTrackerPathLocalServiceImpl
 * @generated
 */
public class UserTrackerPathLocalServiceUtil {
	/**
	* Adds the user tracker path to the database. Also notifies the appropriate model listeners.
	*
	* @param userTrackerPath the user tracker path to add
	* @return the user tracker path that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTrackerPath addUserTrackerPath(
		com.liferay.portal.model.UserTrackerPath userTrackerPath)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserTrackerPath(userTrackerPath);
	}

	/**
	* Creates a new user tracker path with the primary key. Does not add the user tracker path to the database.
	*
	* @param userTrackerPathId the primary key for the new user tracker path
	* @return the new user tracker path
	*/
	public static com.liferay.portal.model.UserTrackerPath createUserTrackerPath(
		long userTrackerPathId) {
		return getService().createUserTrackerPath(userTrackerPathId);
	}

	/**
	* Deletes the user tracker path with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userTrackerPathId the primary key of the user tracker path to delete
	* @throws PortalException if a user tracker path with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserTrackerPath(long userTrackerPathId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserTrackerPath(userTrackerPathId);
	}

	/**
	* Deletes the user tracker path from the database. Also notifies the appropriate model listeners.
	*
	* @param userTrackerPath the user tracker path to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserTrackerPath(
		com.liferay.portal.model.UserTrackerPath userTrackerPath)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserTrackerPath(userTrackerPath);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the user tracker path with the primary key.
	*
	* @param userTrackerPathId the primary key of the user tracker path to get
	* @return the user tracker path
	* @throws PortalException if a user tracker path with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTrackerPath getUserTrackerPath(
		long userTrackerPathId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTrackerPath(userTrackerPathId);
	}

	/**
	* Gets a range of all the user tracker paths.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user tracker paths to return
	* @param end the upper bound of the range of user tracker paths to return (not inclusive)
	* @return the range of user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTrackerPath> getUserTrackerPaths(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTrackerPaths(start, end);
	}

	/**
	* Gets the number of user tracker paths.
	*
	* @return the number of user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserTrackerPathsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTrackerPathsCount();
	}

	/**
	* Updates the user tracker path in the database. Also notifies the appropriate model listeners.
	*
	* @param userTrackerPath the user tracker path to update
	* @return the user tracker path that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTrackerPath updateUserTrackerPath(
		com.liferay.portal.model.UserTrackerPath userTrackerPath)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserTrackerPath(userTrackerPath);
	}

	/**
	* Updates the user tracker path in the database. Also notifies the appropriate model listeners.
	*
	* @param userTrackerPath the user tracker path to update
	* @param merge whether to merge the user tracker path with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user tracker path that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTrackerPath updateUserTrackerPath(
		com.liferay.portal.model.UserTrackerPath userTrackerPath, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserTrackerPath(userTrackerPath, merge);
	}

	public static java.util.List<com.liferay.portal.model.UserTrackerPath> getUserTrackerPaths(
		long userTrackerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTrackerPaths(userTrackerId, start, end);
	}

	public static UserTrackerPathLocalService getService() {
		if (_service == null) {
			_service = (UserTrackerPathLocalService)PortalBeanLocatorUtil.locate(UserTrackerPathLocalService.class.getName());
		}

		return _service;
	}

	public void setService(UserTrackerPathLocalService service) {
		_service = service;
	}

	private static UserTrackerPathLocalService _service;
}