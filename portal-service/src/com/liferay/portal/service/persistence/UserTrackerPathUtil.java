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

package com.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.UserTrackerPath;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user tracker path service. This utility wraps {@link UserTrackerPathPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTrackerPathPersistence
 * @see UserTrackerPathPersistenceImpl
 * @generated
 */
public class UserTrackerPathUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserTrackerPath userTrackerPath) {
		getPersistence().clearCache(userTrackerPath);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserTrackerPath> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserTrackerPath> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserTrackerPath> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static UserTrackerPath remove(UserTrackerPath userTrackerPath)
		throws SystemException {
		return getPersistence().remove(userTrackerPath);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserTrackerPath update(UserTrackerPath userTrackerPath,
		boolean merge) throws SystemException {
		return getPersistence().update(userTrackerPath, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserTrackerPath update(UserTrackerPath userTrackerPath,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userTrackerPath, merge, serviceContext);
	}

	/**
	* Caches the user tracker path in the entity cache if it is enabled.
	*
	* @param userTrackerPath the user tracker path to cache
	*/
	public static void cacheResult(
		com.liferay.portal.model.UserTrackerPath userTrackerPath) {
		getPersistence().cacheResult(userTrackerPath);
	}

	/**
	* Caches the user tracker paths in the entity cache if it is enabled.
	*
	* @param userTrackerPaths the user tracker paths to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.UserTrackerPath> userTrackerPaths) {
		getPersistence().cacheResult(userTrackerPaths);
	}

	/**
	* Creates a new user tracker path with the primary key. Does not add the user tracker path to the database.
	*
	* @param userTrackerPathId the primary key for the new user tracker path
	* @return the new user tracker path
	*/
	public static com.liferay.portal.model.UserTrackerPath create(
		long userTrackerPathId) {
		return getPersistence().create(userTrackerPathId);
	}

	/**
	* Removes the user tracker path with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userTrackerPathId the primary key of the user tracker path to remove
	* @return the user tracker path that was removed
	* @throws com.liferay.portal.NoSuchUserTrackerPathException if a user tracker path with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTrackerPath remove(
		long userTrackerPathId)
		throws com.liferay.portal.NoSuchUserTrackerPathException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userTrackerPathId);
	}

	public static com.liferay.portal.model.UserTrackerPath updateImpl(
		com.liferay.portal.model.UserTrackerPath userTrackerPath, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userTrackerPath, merge);
	}

	/**
	* Finds the user tracker path with the primary key or throws a {@link com.liferay.portal.NoSuchUserTrackerPathException} if it could not be found.
	*
	* @param userTrackerPathId the primary key of the user tracker path to find
	* @return the user tracker path
	* @throws com.liferay.portal.NoSuchUserTrackerPathException if a user tracker path with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTrackerPath findByPrimaryKey(
		long userTrackerPathId)
		throws com.liferay.portal.NoSuchUserTrackerPathException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userTrackerPathId);
	}

	/**
	* Finds the user tracker path with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userTrackerPathId the primary key of the user tracker path to find
	* @return the user tracker path, or <code>null</code> if a user tracker path with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTrackerPath fetchByPrimaryKey(
		long userTrackerPathId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userTrackerPathId);
	}

	/**
	* Finds all the user tracker paths where userTrackerId = &#63;.
	*
	* @param userTrackerId the user tracker id to search with
	* @return the matching user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTrackerPath> findByUserTrackerId(
		long userTrackerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserTrackerId(userTrackerId);
	}

	/**
	* Finds a range of all the user tracker paths where userTrackerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the user tracker id to search with
	* @param start the lower bound of the range of user tracker paths to return
	* @param end the upper bound of the range of user tracker paths to return (not inclusive)
	* @return the range of matching user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTrackerPath> findByUserTrackerId(
		long userTrackerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserTrackerId(userTrackerId, start, end);
	}

	/**
	* Finds an ordered range of all the user tracker paths where userTrackerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the user tracker id to search with
	* @param start the lower bound of the range of user tracker paths to return
	* @param end the upper bound of the range of user tracker paths to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTrackerPath> findByUserTrackerId(
		long userTrackerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTrackerId(userTrackerId, start, end,
			orderByComparator);
	}

	/**
	* Finds the first user tracker path in the ordered set where userTrackerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the user tracker id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user tracker path
	* @throws com.liferay.portal.NoSuchUserTrackerPathException if a matching user tracker path could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTrackerPath findByUserTrackerId_First(
		long userTrackerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerPathException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTrackerId_First(userTrackerId, orderByComparator);
	}

	/**
	* Finds the last user tracker path in the ordered set where userTrackerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the user tracker id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user tracker path
	* @throws com.liferay.portal.NoSuchUserTrackerPathException if a matching user tracker path could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTrackerPath findByUserTrackerId_Last(
		long userTrackerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerPathException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTrackerId_Last(userTrackerId, orderByComparator);
	}

	/**
	* Finds the user tracker paths before and after the current user tracker path in the ordered set where userTrackerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerPathId the primary key of the current user tracker path
	* @param userTrackerId the user tracker id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user tracker path
	* @throws com.liferay.portal.NoSuchUserTrackerPathException if a user tracker path with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTrackerPath[] findByUserTrackerId_PrevAndNext(
		long userTrackerPathId, long userTrackerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerPathException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTrackerId_PrevAndNext(userTrackerPathId,
			userTrackerId, orderByComparator);
	}

	/**
	* Finds all the user tracker paths.
	*
	* @return the user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTrackerPath> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the user tracker paths.
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
	public static java.util.List<com.liferay.portal.model.UserTrackerPath> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the user tracker paths.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user tracker paths to return
	* @param end the upper bound of the range of user tracker paths to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTrackerPath> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user tracker paths where userTrackerId = &#63; from the database.
	*
	* @param userTrackerId the user tracker id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserTrackerId(long userTrackerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserTrackerId(userTrackerId);
	}

	/**
	* Removes all the user tracker paths from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the user tracker paths where userTrackerId = &#63;.
	*
	* @param userTrackerId the user tracker id to search with
	* @return the number of matching user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserTrackerId(long userTrackerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserTrackerId(userTrackerId);
	}

	/**
	* Counts all the user tracker paths.
	*
	* @return the number of user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserTrackerPathPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserTrackerPathPersistence)PortalBeanLocatorUtil.locate(UserTrackerPathPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(UserTrackerPathPersistence persistence) {
		_persistence = persistence;
	}

	private static UserTrackerPathPersistence _persistence;
}