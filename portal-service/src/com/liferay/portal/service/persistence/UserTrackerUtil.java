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
import com.liferay.portal.model.UserTracker;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user tracker service. This utility wraps {@link UserTrackerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see UserTrackerPersistence
 * @see UserTrackerPersistenceImpl
 * @generated
 */
public class UserTrackerUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserTracker userTracker) {
		getPersistence().clearCache(userTracker);
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
	public static List<UserTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static UserTracker remove(UserTracker userTracker)
		throws SystemException {
		return getPersistence().remove(userTracker);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserTracker update(UserTracker userTracker, boolean merge)
		throws SystemException {
		return getPersistence().update(userTracker, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserTracker update(UserTracker userTracker, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userTracker, merge, serviceContext);
	}

	/**
	* Caches the user tracker in the entity cache if it is enabled.
	*
	* @param userTracker the user tracker to cache
	*/
	public static void cacheResult(
		com.liferay.portal.model.UserTracker userTracker) {
		getPersistence().cacheResult(userTracker);
	}

	/**
	* Caches the user trackers in the entity cache if it is enabled.
	*
	* @param userTrackers the user trackers to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.UserTracker> userTrackers) {
		getPersistence().cacheResult(userTrackers);
	}

	/**
	* Creates a new user tracker with the primary key. Does not add the user tracker to the database.
	*
	* @param userTrackerId the primary key for the new user tracker
	* @return the new user tracker
	*/
	public static com.liferay.portal.model.UserTracker create(
		long userTrackerId) {
		return getPersistence().create(userTrackerId);
	}

	/**
	* Removes the user tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userTrackerId the primary key of the user tracker to remove
	* @return the user tracker that was removed
	* @throws com.liferay.portal.NoSuchUserTrackerException if a user tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker remove(
		long userTrackerId)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userTrackerId);
	}

	public static com.liferay.portal.model.UserTracker updateImpl(
		com.liferay.portal.model.UserTracker userTracker, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userTracker, merge);
	}

	/**
	* Finds the user tracker with the primary key or throws a {@link com.liferay.portal.NoSuchUserTrackerException} if it could not be found.
	*
	* @param userTrackerId the primary key of the user tracker to find
	* @return the user tracker
	* @throws com.liferay.portal.NoSuchUserTrackerException if a user tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker findByPrimaryKey(
		long userTrackerId)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userTrackerId);
	}

	/**
	* Finds the user tracker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userTrackerId the primary key of the user tracker to find
	* @return the user tracker, or <code>null</code> if a user tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker fetchByPrimaryKey(
		long userTrackerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userTrackerId);
	}

	/**
	* Finds all the user trackers where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Finds a range of all the user trackers where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of user trackers to return
	* @param end the upper bound of the range of user trackers to return (not inclusive)
	* @return the range of matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Finds an ordered range of all the user trackers where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of user trackers to return
	* @param end the upper bound of the range of user trackers to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Finds the first user tracker in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user tracker
	* @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Finds the last user tracker in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user tracker
	* @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Finds the user trackers before and after the current user tracker in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the primary key of the current user tracker
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user tracker
	* @throws com.liferay.portal.NoSuchUserTrackerException if a user tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker[] findByCompanyId_PrevAndNext(
		long userTrackerId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(userTrackerId, companyId,
			orderByComparator);
	}

	/**
	* Finds all the user trackers where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Finds a range of all the user trackers where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of user trackers to return
	* @param end the upper bound of the range of user trackers to return (not inclusive)
	* @return the range of matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Finds an ordered range of all the user trackers where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of user trackers to return
	* @param end the upper bound of the range of user trackers to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Finds the first user tracker in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user tracker
	* @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Finds the last user tracker in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user tracker
	* @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Finds the user trackers before and after the current user tracker in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the primary key of the current user tracker
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user tracker
	* @throws com.liferay.portal.NoSuchUserTrackerException if a user tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker[] findByUserId_PrevAndNext(
		long userTrackerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(userTrackerId, userId,
			orderByComparator);
	}

	/**
	* Finds all the user trackers where sessionId = &#63;.
	*
	* @param sessionId the session id to search with
	* @return the matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findBySessionId(
		java.lang.String sessionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySessionId(sessionId);
	}

	/**
	* Finds a range of all the user trackers where sessionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sessionId the session id to search with
	* @param start the lower bound of the range of user trackers to return
	* @param end the upper bound of the range of user trackers to return (not inclusive)
	* @return the range of matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findBySessionId(
		java.lang.String sessionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySessionId(sessionId, start, end);
	}

	/**
	* Finds an ordered range of all the user trackers where sessionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sessionId the session id to search with
	* @param start the lower bound of the range of user trackers to return
	* @param end the upper bound of the range of user trackers to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findBySessionId(
		java.lang.String sessionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySessionId(sessionId, start, end, orderByComparator);
	}

	/**
	* Finds the first user tracker in the ordered set where sessionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sessionId the session id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user tracker
	* @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker findBySessionId_First(
		java.lang.String sessionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySessionId_First(sessionId, orderByComparator);
	}

	/**
	* Finds the last user tracker in the ordered set where sessionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sessionId the session id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user tracker
	* @throws com.liferay.portal.NoSuchUserTrackerException if a matching user tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker findBySessionId_Last(
		java.lang.String sessionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySessionId_Last(sessionId, orderByComparator);
	}

	/**
	* Finds the user trackers before and after the current user tracker in the ordered set where sessionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the primary key of the current user tracker
	* @param sessionId the session id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user tracker
	* @throws com.liferay.portal.NoSuchUserTrackerException if a user tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker[] findBySessionId_PrevAndNext(
		long userTrackerId, java.lang.String sessionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySessionId_PrevAndNext(userTrackerId, sessionId,
			orderByComparator);
	}

	/**
	* Finds all the user trackers.
	*
	* @return the user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the user trackers.
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
	public static java.util.List<com.liferay.portal.model.UserTracker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the user trackers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user trackers to return
	* @param end the upper bound of the range of user trackers to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user trackers where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the user trackers where userId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the user trackers where sessionId = &#63; from the database.
	*
	* @param sessionId the session id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySessionId(java.lang.String sessionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySessionId(sessionId);
	}

	/**
	* Removes all the user trackers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the user trackers where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Counts all the user trackers where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the number of matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Counts all the user trackers where sessionId = &#63;.
	*
	* @param sessionId the session id to search with
	* @return the number of matching user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySessionId(java.lang.String sessionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySessionId(sessionId);
	}

	/**
	* Counts all the user trackers.
	*
	* @return the number of user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserTrackerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserTrackerPersistence)PortalBeanLocatorUtil.locate(UserTrackerPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(UserTrackerPersistence persistence) {
		_persistence = persistence;
	}

	private static UserTrackerPersistence _persistence;
}