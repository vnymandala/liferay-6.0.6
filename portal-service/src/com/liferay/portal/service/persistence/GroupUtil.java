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
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the group service. This utility wraps {@link GroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see GroupPersistence
 * @see GroupPersistenceImpl
 * @generated
 */
public class GroupUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Group group) {
		getPersistence().clearCache(group);
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
	public static List<Group> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Group> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Group> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Group remove(Group group) throws SystemException {
		return getPersistence().remove(group);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Group update(Group group, boolean merge)
		throws SystemException {
		return getPersistence().update(group, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Group update(Group group, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(group, merge, serviceContext);
	}

	/**
	* Caches the group in the entity cache if it is enabled.
	*
	* @param group the group to cache
	*/
	public static void cacheResult(com.liferay.portal.model.Group group) {
		getPersistence().cacheResult(group);
	}

	/**
	* Caches the groups in the entity cache if it is enabled.
	*
	* @param groups the groups to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.Group> groups) {
		getPersistence().cacheResult(groups);
	}

	/**
	* Creates a new group with the primary key. Does not add the group to the database.
	*
	* @param groupId the primary key for the new group
	* @return the new group
	*/
	public static com.liferay.portal.model.Group create(long groupId) {
		return getPersistence().create(groupId);
	}

	/**
	* Removes the group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the group to remove
	* @return the group that was removed
	* @throws com.liferay.portal.NoSuchGroupException if a group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group remove(long groupId)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(groupId);
	}

	public static com.liferay.portal.model.Group updateImpl(
		com.liferay.portal.model.Group group, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(group, merge);
	}

	/**
	* Finds the group with the primary key or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param groupId the primary key of the group to find
	* @return the group
	* @throws com.liferay.portal.NoSuchGroupException if a group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByPrimaryKey(long groupId)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(groupId);
	}

	/**
	* Finds the group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupId the primary key of the group to find
	* @return the group, or <code>null</code> if a group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByPrimaryKey(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(groupId);
	}

	/**
	* Finds all the groups where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Group> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Finds a range of all the groups where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Group> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Finds an ordered range of all the groups where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Group> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Finds the first group in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Finds the last group in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Finds the groups before and after the current group in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the primary key of the current group
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next group
	* @throws com.liferay.portal.NoSuchGroupException if a group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group[] findByCompanyId_PrevAndNext(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(groupId, companyId,
			orderByComparator);
	}

	/**
	* Finds the group where liveGroupId = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param liveGroupId the live group id to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByLiveGroupId(
		long liveGroupId)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLiveGroupId(liveGroupId);
	}

	/**
	* Finds the group where liveGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param liveGroupId the live group id to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByLiveGroupId(
		long liveGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLiveGroupId(liveGroupId);
	}

	/**
	* Finds the group where liveGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param liveGroupId the live group id to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByLiveGroupId(
		long liveGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLiveGroupId(liveGroupId, retrieveFromCache);
	}

	/**
	* Finds the group where companyId = &#63; and name = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param name the name to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByC_N(long companyId,
		java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_N(companyId, name);
	}

	/**
	* Finds the group where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByC_N(long companyId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_N(companyId, name);
	}

	/**
	* Finds the group where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByC_N(long companyId,
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_N(companyId, name, retrieveFromCache);
	}

	/**
	* Finds the group where companyId = &#63; and friendlyURL = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param friendlyURL the friendly u r l to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByC_F(long companyId,
		java.lang.String friendlyURL)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_F(companyId, friendlyURL);
	}

	/**
	* Finds the group where companyId = &#63; and friendlyURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param friendlyURL the friendly u r l to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByC_F(long companyId,
		java.lang.String friendlyURL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_F(companyId, friendlyURL);
	}

	/**
	* Finds the group where companyId = &#63; and friendlyURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param friendlyURL the friendly u r l to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByC_F(long companyId,
		java.lang.String friendlyURL, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_F(companyId, friendlyURL, retrieveFromCache);
	}

	/**
	* Finds all the groups where type = &#63; and active = &#63;.
	*
	* @param type the type to search with
	* @param active the active to search with
	* @return the matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Group> findByT_A(
		int type, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_A(type, active);
	}

	/**
	* Finds a range of all the groups where type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param type the type to search with
	* @param active the active to search with
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Group> findByT_A(
		int type, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_A(type, active, start, end);
	}

	/**
	* Finds an ordered range of all the groups where type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param type the type to search with
	* @param active the active to search with
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Group> findByT_A(
		int type, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_A(type, active, start, end, orderByComparator);
	}

	/**
	* Finds the first group in the ordered set where type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param type the type to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByT_A_First(int type,
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_A_First(type, active, orderByComparator);
	}

	/**
	* Finds the last group in the ordered set where type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param type the type to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByT_A_Last(int type,
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_A_Last(type, active, orderByComparator);
	}

	/**
	* Finds the groups before and after the current group in the ordered set where type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the primary key of the current group
	* @param type the type to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next group
	* @throws com.liferay.portal.NoSuchGroupException if a group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group[] findByT_A_PrevAndNext(
		long groupId, int type, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_A_PrevAndNext(groupId, type, active,
			orderByComparator);
	}

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByC_C_C(long companyId,
		long classNameId, long classPK)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByC_C_C(long companyId,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByC_C_C(long companyId,
		long classNameId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C(companyId, classNameId, classPK,
			retrieveFromCache);
	}

	/**
	* Finds the group where companyId = &#63; and liveGroupId = &#63; and name = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByC_L_N(long companyId,
		long liveGroupId, java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_L_N(companyId, liveGroupId, name);
	}

	/**
	* Finds the group where companyId = &#63; and liveGroupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByC_L_N(long companyId,
		long liveGroupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_L_N(companyId, liveGroupId, name);
	}

	/**
	* Finds the group where companyId = &#63; and liveGroupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByC_L_N(long companyId,
		long liveGroupId, java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_L_N(companyId, liveGroupId, name, retrieveFromCache);
	}

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and liveGroupId = &#63; and name = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group findByC_C_L_N(long companyId,
		long classNameId, long liveGroupId, java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_L_N(companyId, classNameId, liveGroupId, name);
	}

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and liveGroupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByC_C_L_N(
		long companyId, long classNameId, long liveGroupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_L_N(companyId, classNameId, liveGroupId, name);
	}

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and liveGroupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Group fetchByC_C_L_N(
		long companyId, long classNameId, long liveGroupId,
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_L_N(companyId, classNameId, liveGroupId, name,
			retrieveFromCache);
	}

	/**
	* Finds all the groups.
	*
	* @return the groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Group> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Group> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Group> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the groups where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes the group where liveGroupId = &#63; from the database.
	*
	* @param liveGroupId the live group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLiveGroupId(long liveGroupId)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLiveGroupId(liveGroupId);
	}

	/**
	* Removes the group where companyId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_N(long companyId, java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_N(companyId, name);
	}

	/**
	* Removes the group where companyId = &#63; and friendlyURL = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param friendlyURL the friendly u r l to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_F(long companyId, java.lang.String friendlyURL)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_F(companyId, friendlyURL);
	}

	/**
	* Removes all the groups where type = &#63; and active = &#63; from the database.
	*
	* @param type the type to search with
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_A(int type, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByT_A(type, active);
	}

	/**
	* Removes the group where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C_C(long companyId, long classNameId,
		long classPK)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Removes the group where companyId = &#63; and liveGroupId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_L_N(long companyId, long liveGroupId,
		java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_L_N(companyId, liveGroupId, name);
	}

	/**
	* Removes the group where companyId = &#63; and classNameId = &#63; and liveGroupId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C_L_N(long companyId, long classNameId,
		long liveGroupId, java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByC_C_L_N(companyId, classNameId, liveGroupId, name);
	}

	/**
	* Removes all the groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the groups where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Counts all the groups where liveGroupId = &#63;.
	*
	* @param liveGroupId the live group id to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLiveGroupId(long liveGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLiveGroupId(liveGroupId);
	}

	/**
	* Counts all the groups where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company id to search with
	* @param name the name to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_N(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_N(companyId, name);
	}

	/**
	* Counts all the groups where companyId = &#63; and friendlyURL = &#63;.
	*
	* @param companyId the company id to search with
	* @param friendlyURL the friendly u r l to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_F(long companyId, java.lang.String friendlyURL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_F(companyId, friendlyURL);
	}

	/**
	* Counts all the groups where type = &#63; and active = &#63;.
	*
	* @param type the type to search with
	* @param active the active to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_A(int type, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_A(type, active);
	}

	/**
	* Counts all the groups where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_C(long companyId, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Counts all the groups where companyId = &#63; and liveGroupId = &#63; and name = &#63;.
	*
	* @param companyId the company id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_L_N(long companyId, long liveGroupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_L_N(companyId, liveGroupId, name);
	}

	/**
	* Counts all the groups where companyId = &#63; and classNameId = &#63; and liveGroupId = &#63; and name = &#63;.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_L_N(long companyId, long classNameId,
		long liveGroupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_C_L_N(companyId, classNameId, liveGroupId, name);
	}

	/**
	* Counts all the groups.
	*
	* @return the number of groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Gets all the organizations associated with the group.
	*
	* @param pk the primary key of the group to get the associated organizations for
	* @return the organizations associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Organization> getOrganizations(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrganizations(pk);
	}

	/**
	* Gets a range of all the organizations associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated organizations for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of organizations associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Organization> getOrganizations(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrganizations(pk, start, end);
	}

	/**
	* Gets an ordered range of all the organizations associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated organizations for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of organizations associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Organization> getOrganizations(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getOrganizations(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of organizations associated with the group.
	*
	* @param pk the primary key of the group to get the number of associated organizations for
	* @return the number of organizations associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static int getOrganizationsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrganizationsSize(pk);
	}

	/**
	* Determines if the organization is associated with the group.
	*
	* @param pk the primary key of the group
	* @param organizationPK the primary key of the organization
	* @return <code>true</code> if the organization is associated with the group; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsOrganization(long pk, long organizationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsOrganization(pk, organizationPK);
	}

	/**
	* Determines if the group has any organizations associated with it.
	*
	* @param pk the primary key of the group to check for associations with organizations
	* @return <code>true</code> if the group has any organizations associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsOrganizations(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsOrganizations(pk);
	}

	/**
	* Adds an association between the group and the organization. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizationPK the primary key of the organization
	* @throws SystemException if a system exception occurred
	*/
	public static void addOrganization(long pk, long organizationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addOrganization(pk, organizationPK);
	}

	/**
	* Adds an association between the group and the organization. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organization the organization
	* @throws SystemException if a system exception occurred
	*/
	public static void addOrganization(long pk,
		com.liferay.portal.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addOrganization(pk, organization);
	}

	/**
	* Adds an association between the group and the organizations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizationPKs the primary keys of the organizations
	* @throws SystemException if a system exception occurred
	*/
	public static void addOrganizations(long pk, long[] organizationPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addOrganizations(pk, organizationPKs);
	}

	/**
	* Adds an association between the group and the organizations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizations the organizations
	* @throws SystemException if a system exception occurred
	*/
	public static void addOrganizations(long pk,
		java.util.List<com.liferay.portal.model.Organization> organizations)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addOrganizations(pk, organizations);
	}

	/**
	* Clears all associations between the group and its organizations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to clear the associated organizations from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearOrganizations(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearOrganizations(pk);
	}

	/**
	* Removes the association between the group and the organization. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizationPK the primary key of the organization
	* @throws SystemException if a system exception occurred
	*/
	public static void removeOrganization(long pk, long organizationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeOrganization(pk, organizationPK);
	}

	/**
	* Removes the association between the group and the organization. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organization the organization
	* @throws SystemException if a system exception occurred
	*/
	public static void removeOrganization(long pk,
		com.liferay.portal.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeOrganization(pk, organization);
	}

	/**
	* Removes the association between the group and the organizations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizationPKs the primary keys of the organizations
	* @throws SystemException if a system exception occurred
	*/
	public static void removeOrganizations(long pk, long[] organizationPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeOrganizations(pk, organizationPKs);
	}

	/**
	* Removes the association between the group and the organizations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizations the organizations
	* @throws SystemException if a system exception occurred
	*/
	public static void removeOrganizations(long pk,
		java.util.List<com.liferay.portal.model.Organization> organizations)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeOrganizations(pk, organizations);
	}

	/**
	* Sets the organizations associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param organizationPKs the primary keys of the organizations to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static void setOrganizations(long pk, long[] organizationPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setOrganizations(pk, organizationPKs);
	}

	/**
	* Sets the organizations associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param organizations the organizations to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static void setOrganizations(long pk,
		java.util.List<com.liferay.portal.model.Organization> organizations)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setOrganizations(pk, organizations);
	}

	/**
	* Gets all the permissions associated with the group.
	*
	* @param pk the primary key of the group to get the associated permissions for
	* @return the permissions associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Permission> getPermissions(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPermissions(pk);
	}

	/**
	* Gets a range of all the permissions associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated permissions for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of permissions associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Permission> getPermissions(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPermissions(pk, start, end);
	}

	/**
	* Gets an ordered range of all the permissions associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated permissions for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of permissions associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Permission> getPermissions(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPermissions(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of permissions associated with the group.
	*
	* @param pk the primary key of the group to get the number of associated permissions for
	* @return the number of permissions associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static int getPermissionsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPermissionsSize(pk);
	}

	/**
	* Determines if the permission is associated with the group.
	*
	* @param pk the primary key of the group
	* @param permissionPK the primary key of the permission
	* @return <code>true</code> if the permission is associated with the group; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsPermission(long pk, long permissionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsPermission(pk, permissionPK);
	}

	/**
	* Determines if the group has any permissions associated with it.
	*
	* @param pk the primary key of the group to check for associations with permissions
	* @return <code>true</code> if the group has any permissions associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsPermissions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsPermissions(pk);
	}

	/**
	* Adds an association between the group and the permission. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissionPK the primary key of the permission
	* @throws SystemException if a system exception occurred
	*/
	public static void addPermission(long pk, long permissionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addPermission(pk, permissionPK);
	}

	/**
	* Adds an association between the group and the permission. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permission the permission
	* @throws SystemException if a system exception occurred
	*/
	public static void addPermission(long pk,
		com.liferay.portal.model.Permission permission)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addPermission(pk, permission);
	}

	/**
	* Adds an association between the group and the permissions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissionPKs the primary keys of the permissions
	* @throws SystemException if a system exception occurred
	*/
	public static void addPermissions(long pk, long[] permissionPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addPermissions(pk, permissionPKs);
	}

	/**
	* Adds an association between the group and the permissions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissions the permissions
	* @throws SystemException if a system exception occurred
	*/
	public static void addPermissions(long pk,
		java.util.List<com.liferay.portal.model.Permission> permissions)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addPermissions(pk, permissions);
	}

	/**
	* Clears all associations between the group and its permissions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to clear the associated permissions from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearPermissions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearPermissions(pk);
	}

	/**
	* Removes the association between the group and the permission. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissionPK the primary key of the permission
	* @throws SystemException if a system exception occurred
	*/
	public static void removePermission(long pk, long permissionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removePermission(pk, permissionPK);
	}

	/**
	* Removes the association between the group and the permission. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permission the permission
	* @throws SystemException if a system exception occurred
	*/
	public static void removePermission(long pk,
		com.liferay.portal.model.Permission permission)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removePermission(pk, permission);
	}

	/**
	* Removes the association between the group and the permissions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissionPKs the primary keys of the permissions
	* @throws SystemException if a system exception occurred
	*/
	public static void removePermissions(long pk, long[] permissionPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removePermissions(pk, permissionPKs);
	}

	/**
	* Removes the association between the group and the permissions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissions the permissions
	* @throws SystemException if a system exception occurred
	*/
	public static void removePermissions(long pk,
		java.util.List<com.liferay.portal.model.Permission> permissions)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removePermissions(pk, permissions);
	}

	/**
	* Sets the permissions associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param permissionPKs the primary keys of the permissions to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static void setPermissions(long pk, long[] permissionPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setPermissions(pk, permissionPKs);
	}

	/**
	* Sets the permissions associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param permissions the permissions to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static void setPermissions(long pk,
		java.util.List<com.liferay.portal.model.Permission> permissions)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setPermissions(pk, permissions);
	}

	/**
	* Gets all the roles associated with the group.
	*
	* @param pk the primary key of the group to get the associated roles for
	* @return the roles associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Role> getRoles(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getRoles(pk);
	}

	/**
	* Gets a range of all the roles associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated roles for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of roles associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Role> getRoles(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getRoles(pk, start, end);
	}

	/**
	* Gets an ordered range of all the roles associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated roles for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of roles associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Role> getRoles(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getRoles(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of roles associated with the group.
	*
	* @param pk the primary key of the group to get the number of associated roles for
	* @return the number of roles associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static int getRolesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getRolesSize(pk);
	}

	/**
	* Determines if the role is associated with the group.
	*
	* @param pk the primary key of the group
	* @param rolePK the primary key of the role
	* @return <code>true</code> if the role is associated with the group; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsRole(long pk, long rolePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsRole(pk, rolePK);
	}

	/**
	* Determines if the group has any roles associated with it.
	*
	* @param pk the primary key of the group to check for associations with roles
	* @return <code>true</code> if the group has any roles associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsRoles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsRoles(pk);
	}

	/**
	* Adds an association between the group and the role. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param rolePK the primary key of the role
	* @throws SystemException if a system exception occurred
	*/
	public static void addRole(long pk, long rolePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addRole(pk, rolePK);
	}

	/**
	* Adds an association between the group and the role. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param role the role
	* @throws SystemException if a system exception occurred
	*/
	public static void addRole(long pk, com.liferay.portal.model.Role role)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addRole(pk, role);
	}

	/**
	* Adds an association between the group and the roles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param rolePKs the primary keys of the roles
	* @throws SystemException if a system exception occurred
	*/
	public static void addRoles(long pk, long[] rolePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addRoles(pk, rolePKs);
	}

	/**
	* Adds an association between the group and the roles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param roles the roles
	* @throws SystemException if a system exception occurred
	*/
	public static void addRoles(long pk,
		java.util.List<com.liferay.portal.model.Role> roles)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addRoles(pk, roles);
	}

	/**
	* Clears all associations between the group and its roles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to clear the associated roles from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearRoles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearRoles(pk);
	}

	/**
	* Removes the association between the group and the role. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param rolePK the primary key of the role
	* @throws SystemException if a system exception occurred
	*/
	public static void removeRole(long pk, long rolePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeRole(pk, rolePK);
	}

	/**
	* Removes the association between the group and the role. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param role the role
	* @throws SystemException if a system exception occurred
	*/
	public static void removeRole(long pk, com.liferay.portal.model.Role role)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeRole(pk, role);
	}

	/**
	* Removes the association between the group and the roles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param rolePKs the primary keys of the roles
	* @throws SystemException if a system exception occurred
	*/
	public static void removeRoles(long pk, long[] rolePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeRoles(pk, rolePKs);
	}

	/**
	* Removes the association between the group and the roles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param roles the roles
	* @throws SystemException if a system exception occurred
	*/
	public static void removeRoles(long pk,
		java.util.List<com.liferay.portal.model.Role> roles)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeRoles(pk, roles);
	}

	/**
	* Sets the roles associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param rolePKs the primary keys of the roles to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static void setRoles(long pk, long[] rolePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setRoles(pk, rolePKs);
	}

	/**
	* Sets the roles associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param roles the roles to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static void setRoles(long pk,
		java.util.List<com.liferay.portal.model.Role> roles)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setRoles(pk, roles);
	}

	/**
	* Gets all the user groups associated with the group.
	*
	* @param pk the primary key of the group to get the associated user groups for
	* @return the user groups associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroup> getUserGroups(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getUserGroups(pk);
	}

	/**
	* Gets a range of all the user groups associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated user groups for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of user groups associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroup> getUserGroups(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getUserGroups(pk, start, end);
	}

	/**
	* Gets an ordered range of all the user groups associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated user groups for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of user groups associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroup> getUserGroups(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getUserGroups(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of user groups associated with the group.
	*
	* @param pk the primary key of the group to get the number of associated user groups for
	* @return the number of user groups associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserGroupsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getUserGroupsSize(pk);
	}

	/**
	* Determines if the user group is associated with the group.
	*
	* @param pk the primary key of the group
	* @param userGroupPK the primary key of the user group
	* @return <code>true</code> if the user group is associated with the group; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsUserGroup(long pk, long userGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsUserGroup(pk, userGroupPK);
	}

	/**
	* Determines if the group has any user groups associated with it.
	*
	* @param pk the primary key of the group to check for associations with user groups
	* @return <code>true</code> if the group has any user groups associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsUserGroups(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsUserGroups(pk);
	}

	/**
	* Adds an association between the group and the user group. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroupPK the primary key of the user group
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserGroup(long pk, long userGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addUserGroup(pk, userGroupPK);
	}

	/**
	* Adds an association between the group and the user group. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroup the user group
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserGroup(long pk,
		com.liferay.portal.model.UserGroup userGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addUserGroup(pk, userGroup);
	}

	/**
	* Adds an association between the group and the user groups. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroupPKs the primary keys of the user groups
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserGroups(long pk, long[] userGroupPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addUserGroups(pk, userGroupPKs);
	}

	/**
	* Adds an association between the group and the user groups. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroups the user groups
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserGroups(long pk,
		java.util.List<com.liferay.portal.model.UserGroup> userGroups)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addUserGroups(pk, userGroups);
	}

	/**
	* Clears all associations between the group and its user groups. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to clear the associated user groups from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearUserGroups(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearUserGroups(pk);
	}

	/**
	* Removes the association between the group and the user group. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroupPK the primary key of the user group
	* @throws SystemException if a system exception occurred
	*/
	public static void removeUserGroup(long pk, long userGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeUserGroup(pk, userGroupPK);
	}

	/**
	* Removes the association between the group and the user group. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroup the user group
	* @throws SystemException if a system exception occurred
	*/
	public static void removeUserGroup(long pk,
		com.liferay.portal.model.UserGroup userGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeUserGroup(pk, userGroup);
	}

	/**
	* Removes the association between the group and the user groups. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroupPKs the primary keys of the user groups
	* @throws SystemException if a system exception occurred
	*/
	public static void removeUserGroups(long pk, long[] userGroupPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeUserGroups(pk, userGroupPKs);
	}

	/**
	* Removes the association between the group and the user groups. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroups the user groups
	* @throws SystemException if a system exception occurred
	*/
	public static void removeUserGroups(long pk,
		java.util.List<com.liferay.portal.model.UserGroup> userGroups)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeUserGroups(pk, userGroups);
	}

	/**
	* Sets the user groups associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param userGroupPKs the primary keys of the user groups to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static void setUserGroups(long pk, long[] userGroupPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setUserGroups(pk, userGroupPKs);
	}

	/**
	* Sets the user groups associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param userGroups the user groups to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static void setUserGroups(long pk,
		java.util.List<com.liferay.portal.model.UserGroup> userGroups)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setUserGroups(pk, userGroups);
	}

	/**
	* Gets all the users associated with the group.
	*
	* @param pk the primary key of the group to get the associated users for
	* @return the users associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.User> getUsers(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getUsers(pk);
	}

	/**
	* Gets a range of all the users associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated users for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of users associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.User> getUsers(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getUsers(pk, start, end);
	}

	/**
	* Gets an ordered range of all the users associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated users for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of users associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.User> getUsers(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getUsers(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of users associated with the group.
	*
	* @param pk the primary key of the group to get the number of associated users for
	* @return the number of users associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static int getUsersSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getUsersSize(pk);
	}

	/**
	* Determines if the user is associated with the group.
	*
	* @param pk the primary key of the group
	* @param userPK the primary key of the user
	* @return <code>true</code> if the user is associated with the group; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsUser(long pk, long userPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsUser(pk, userPK);
	}

	/**
	* Determines if the group has any users associated with it.
	*
	* @param pk the primary key of the group to check for associations with users
	* @return <code>true</code> if the group has any users associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsUsers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsUsers(pk);
	}

	/**
	* Adds an association between the group and the user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userPK the primary key of the user
	* @throws SystemException if a system exception occurred
	*/
	public static void addUser(long pk, long userPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addUser(pk, userPK);
	}

	/**
	* Adds an association between the group and the user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param user the user
	* @throws SystemException if a system exception occurred
	*/
	public static void addUser(long pk, com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addUser(pk, user);
	}

	/**
	* Adds an association between the group and the users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userPKs the primary keys of the users
	* @throws SystemException if a system exception occurred
	*/
	public static void addUsers(long pk, long[] userPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addUsers(pk, userPKs);
	}

	/**
	* Adds an association between the group and the users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param users the users
	* @throws SystemException if a system exception occurred
	*/
	public static void addUsers(long pk,
		java.util.List<com.liferay.portal.model.User> users)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addUsers(pk, users);
	}

	/**
	* Clears all associations between the group and its users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to clear the associated users from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearUsers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearUsers(pk);
	}

	/**
	* Removes the association between the group and the user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userPK the primary key of the user
	* @throws SystemException if a system exception occurred
	*/
	public static void removeUser(long pk, long userPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeUser(pk, userPK);
	}

	/**
	* Removes the association between the group and the user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param user the user
	* @throws SystemException if a system exception occurred
	*/
	public static void removeUser(long pk, com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeUser(pk, user);
	}

	/**
	* Removes the association between the group and the users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userPKs the primary keys of the users
	* @throws SystemException if a system exception occurred
	*/
	public static void removeUsers(long pk, long[] userPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeUsers(pk, userPKs);
	}

	/**
	* Removes the association between the group and the users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param users the users
	* @throws SystemException if a system exception occurred
	*/
	public static void removeUsers(long pk,
		java.util.List<com.liferay.portal.model.User> users)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeUsers(pk, users);
	}

	/**
	* Sets the users associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param userPKs the primary keys of the users to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static void setUsers(long pk, long[] userPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setUsers(pk, userPKs);
	}

	/**
	* Sets the users associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param users the users to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public static void setUsers(long pk,
		java.util.List<com.liferay.portal.model.User> users)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setUsers(pk, users);
	}

	public static GroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GroupPersistence)PortalBeanLocatorUtil.locate(GroupPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(GroupPersistence persistence) {
		_persistence = persistence;
	}

	private static GroupPersistence _persistence;
}