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

package com.liferay.portlet.ratings.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.ratings.model.RatingsStats;

import java.util.List;

/**
 * The persistence utility for the ratings stats service. This utility wraps {@link RatingsStatsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see RatingsStatsPersistence
 * @see RatingsStatsPersistenceImpl
 * @generated
 */
public class RatingsStatsUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(RatingsStats ratingsStats) {
		getPersistence().clearCache(ratingsStats);
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
	public static List<RatingsStats> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RatingsStats> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RatingsStats> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static RatingsStats remove(RatingsStats ratingsStats)
		throws SystemException {
		return getPersistence().remove(ratingsStats);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static RatingsStats update(RatingsStats ratingsStats, boolean merge)
		throws SystemException {
		return getPersistence().update(ratingsStats, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static RatingsStats update(RatingsStats ratingsStats, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ratingsStats, merge, serviceContext);
	}

	/**
	* Caches the ratings stats in the entity cache if it is enabled.
	*
	* @param ratingsStats the ratings stats to cache
	*/
	public static void cacheResult(
		com.liferay.portlet.ratings.model.RatingsStats ratingsStats) {
		getPersistence().cacheResult(ratingsStats);
	}

	/**
	* Caches the ratings statses in the entity cache if it is enabled.
	*
	* @param ratingsStatses the ratings statses to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.ratings.model.RatingsStats> ratingsStatses) {
		getPersistence().cacheResult(ratingsStatses);
	}

	/**
	* Creates a new ratings stats with the primary key. Does not add the ratings stats to the database.
	*
	* @param statsId the primary key for the new ratings stats
	* @return the new ratings stats
	*/
	public static com.liferay.portlet.ratings.model.RatingsStats create(
		long statsId) {
		return getPersistence().create(statsId);
	}

	/**
	* Removes the ratings stats with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statsId the primary key of the ratings stats to remove
	* @return the ratings stats that was removed
	* @throws com.liferay.portlet.ratings.NoSuchStatsException if a ratings stats with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.ratings.model.RatingsStats remove(
		long statsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.ratings.NoSuchStatsException {
		return getPersistence().remove(statsId);
	}

	public static com.liferay.portlet.ratings.model.RatingsStats updateImpl(
		com.liferay.portlet.ratings.model.RatingsStats ratingsStats,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ratingsStats, merge);
	}

	/**
	* Finds the ratings stats with the primary key or throws a {@link com.liferay.portlet.ratings.NoSuchStatsException} if it could not be found.
	*
	* @param statsId the primary key of the ratings stats to find
	* @return the ratings stats
	* @throws com.liferay.portlet.ratings.NoSuchStatsException if a ratings stats with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.ratings.model.RatingsStats findByPrimaryKey(
		long statsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.ratings.NoSuchStatsException {
		return getPersistence().findByPrimaryKey(statsId);
	}

	/**
	* Finds the ratings stats with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param statsId the primary key of the ratings stats to find
	* @return the ratings stats, or <code>null</code> if a ratings stats with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.ratings.model.RatingsStats fetchByPrimaryKey(
		long statsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(statsId);
	}

	/**
	* Finds the ratings stats where classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.portlet.ratings.NoSuchStatsException} if it could not be found.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching ratings stats
	* @throws com.liferay.portlet.ratings.NoSuchStatsException if a matching ratings stats could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.ratings.model.RatingsStats findByC_C(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.ratings.NoSuchStatsException {
		return getPersistence().findByC_C(classNameId, classPK);
	}

	/**
	* Finds the ratings stats where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching ratings stats, or <code>null</code> if a matching ratings stats could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.ratings.model.RatingsStats fetchByC_C(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_C(classNameId, classPK);
	}

	/**
	* Finds the ratings stats where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching ratings stats, or <code>null</code> if a matching ratings stats could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.ratings.model.RatingsStats fetchByC_C(
		long classNameId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C(classNameId, classPK, retrieveFromCache);
	}

	/**
	* Finds all the ratings statses.
	*
	* @return the ratings statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.ratings.model.RatingsStats> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the ratings statses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ratings statses to return
	* @param end the upper bound of the range of ratings statses to return (not inclusive)
	* @return the range of ratings statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.ratings.model.RatingsStats> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the ratings statses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ratings statses to return
	* @param end the upper bound of the range of ratings statses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of ratings statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.ratings.model.RatingsStats> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the ratings stats where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.ratings.NoSuchStatsException {
		getPersistence().removeByC_C(classNameId, classPK);
	}

	/**
	* Removes all the ratings statses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the ratings statses where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the number of matching ratings statses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C(classNameId, classPK);
	}

	/**
	* Counts all the ratings statses.
	*
	* @return the number of ratings statses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RatingsStatsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RatingsStatsPersistence)PortalBeanLocatorUtil.locate(RatingsStatsPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(RatingsStatsPersistence persistence) {
		_persistence = persistence;
	}

	private static RatingsStatsPersistence _persistence;
}