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
import com.liferay.portal.model.UserGroupGroupRole;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user group group role service. This utility wraps {@link UserGroupGroupRolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see UserGroupGroupRolePersistence
 * @see UserGroupGroupRolePersistenceImpl
 * @generated
 */
public class UserGroupGroupRoleUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserGroupGroupRole userGroupGroupRole) {
		getPersistence().clearCache(userGroupGroupRole);
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
	public static List<UserGroupGroupRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserGroupGroupRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserGroupGroupRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static UserGroupGroupRole remove(
		UserGroupGroupRole userGroupGroupRole) throws SystemException {
		return getPersistence().remove(userGroupGroupRole);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserGroupGroupRole update(
		UserGroupGroupRole userGroupGroupRole, boolean merge)
		throws SystemException {
		return getPersistence().update(userGroupGroupRole, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserGroupGroupRole update(
		UserGroupGroupRole userGroupGroupRole, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userGroupGroupRole, merge, serviceContext);
	}

	/**
	* Caches the user group group role in the entity cache if it is enabled.
	*
	* @param userGroupGroupRole the user group group role to cache
	*/
	public static void cacheResult(
		com.liferay.portal.model.UserGroupGroupRole userGroupGroupRole) {
		getPersistence().cacheResult(userGroupGroupRole);
	}

	/**
	* Caches the user group group roles in the entity cache if it is enabled.
	*
	* @param userGroupGroupRoles the user group group roles to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.UserGroupGroupRole> userGroupGroupRoles) {
		getPersistence().cacheResult(userGroupGroupRoles);
	}

	/**
	* Creates a new user group group role with the primary key. Does not add the user group group role to the database.
	*
	* @param userGroupGroupRolePK the primary key for the new user group group role
	* @return the new user group group role
	*/
	public static com.liferay.portal.model.UserGroupGroupRole create(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK) {
		return getPersistence().create(userGroupGroupRolePK);
	}

	/**
	* Removes the user group group role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupGroupRolePK the primary key of the user group group role to remove
	* @return the user group group role that was removed
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a user group group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole remove(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userGroupGroupRolePK);
	}

	public static com.liferay.portal.model.UserGroupGroupRole updateImpl(
		com.liferay.portal.model.UserGroupGroupRole userGroupGroupRole,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userGroupGroupRole, merge);
	}

	/**
	* Finds the user group group role with the primary key or throws a {@link com.liferay.portal.NoSuchUserGroupGroupRoleException} if it could not be found.
	*
	* @param userGroupGroupRolePK the primary key of the user group group role to find
	* @return the user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a user group group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByPrimaryKey(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userGroupGroupRolePK);
	}

	/**
	* Finds the user group group role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userGroupGroupRolePK the primary key of the user group group role to find
	* @return the user group group role, or <code>null</code> if a user group group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole fetchByPrimaryKey(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userGroupGroupRolePK);
	}

	/**
	* Finds all the user group group roles where userGroupId = &#63;.
	*
	* @param userGroupId the user group id to search with
	* @return the matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByUserGroupId(
		long userGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserGroupId(userGroupId);
	}

	/**
	* Finds a range of all the user group group roles where userGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupId the user group id to search with
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @return the range of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByUserGroupId(
		long userGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserGroupId(userGroupId, start, end);
	}

	/**
	* Finds an ordered range of all the user group group roles where userGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupId the user group id to search with
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByUserGroupId(
		long userGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserGroupId(userGroupId, start, end, orderByComparator);
	}

	/**
	* Finds the first user group group role in the ordered set where userGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupId the user group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a matching user group group role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByUserGroupId_First(
		long userGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserGroupId_First(userGroupId, orderByComparator);
	}

	/**
	* Finds the last user group group role in the ordered set where userGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupId the user group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a matching user group group role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByUserGroupId_Last(
		long userGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserGroupId_Last(userGroupId, orderByComparator);
	}

	/**
	* Finds the user group group roles before and after the current user group group role in the ordered set where userGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupGroupRolePK the primary key of the current user group group role
	* @param userGroupId the user group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a user group group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole[] findByUserGroupId_PrevAndNext(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK,
		long userGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserGroupId_PrevAndNext(userGroupGroupRolePK,
			userGroupId, orderByComparator);
	}

	/**
	* Finds all the user group group roles where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Finds a range of all the user group group roles where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @return the range of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Finds an ordered range of all the user group group roles where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds the first user group group role in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a matching user group group role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Finds the last user group group role in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a matching user group group role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Finds the user group group roles before and after the current user group group role in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupGroupRolePK the primary key of the current user group group role
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a user group group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole[] findByGroupId_PrevAndNext(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(userGroupGroupRolePK, groupId,
			orderByComparator);
	}

	/**
	* Finds all the user group group roles where roleId = &#63;.
	*
	* @param roleId the role id to search with
	* @return the matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByRoleId(
		long roleId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoleId(roleId);
	}

	/**
	* Finds a range of all the user group group roles where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roleId the role id to search with
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @return the range of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByRoleId(
		long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoleId(roleId, start, end);
	}

	/**
	* Finds an ordered range of all the user group group roles where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roleId the role id to search with
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByRoleId(
		long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoleId(roleId, start, end, orderByComparator);
	}

	/**
	* Finds the first user group group role in the ordered set where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roleId the role id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a matching user group group role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByRoleId_First(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoleId_First(roleId, orderByComparator);
	}

	/**
	* Finds the last user group group role in the ordered set where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roleId the role id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a matching user group group role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByRoleId_Last(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoleId_Last(roleId, orderByComparator);
	}

	/**
	* Finds the user group group roles before and after the current user group group role in the ordered set where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupGroupRolePK the primary key of the current user group group role
	* @param roleId the role id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a user group group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole[] findByRoleId_PrevAndNext(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK,
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoleId_PrevAndNext(userGroupGroupRolePK, roleId,
			orderByComparator);
	}

	/**
	* Finds all the user group group roles where userGroupId = &#63; and groupId = &#63;.
	*
	* @param userGroupId the user group id to search with
	* @param groupId the group id to search with
	* @return the matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByU_G(
		long userGroupId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_G(userGroupId, groupId);
	}

	/**
	* Finds a range of all the user group group roles where userGroupId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupId the user group id to search with
	* @param groupId the group id to search with
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @return the range of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByU_G(
		long userGroupId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_G(userGroupId, groupId, start, end);
	}

	/**
	* Finds an ordered range of all the user group group roles where userGroupId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupId the user group id to search with
	* @param groupId the group id to search with
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByU_G(
		long userGroupId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_G(userGroupId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Finds the first user group group role in the ordered set where userGroupId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupId the user group id to search with
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a matching user group group role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByU_G_First(
		long userGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_G_First(userGroupId, groupId, orderByComparator);
	}

	/**
	* Finds the last user group group role in the ordered set where userGroupId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupId the user group id to search with
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a matching user group group role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByU_G_Last(
		long userGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_G_Last(userGroupId, groupId, orderByComparator);
	}

	/**
	* Finds the user group group roles before and after the current user group group role in the ordered set where userGroupId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupGroupRolePK the primary key of the current user group group role
	* @param userGroupId the user group id to search with
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a user group group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole[] findByU_G_PrevAndNext(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK,
		long userGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_G_PrevAndNext(userGroupGroupRolePK, userGroupId,
			groupId, orderByComparator);
	}

	/**
	* Finds all the user group group roles where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group id to search with
	* @param roleId the role id to search with
	* @return the matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByG_R(
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_R(groupId, roleId);
	}

	/**
	* Finds a range of all the user group group roles where groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roleId the role id to search with
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @return the range of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByG_R(
		long groupId, long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_R(groupId, roleId, start, end);
	}

	/**
	* Finds an ordered range of all the user group group roles where groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roleId the role id to search with
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findByG_R(
		long groupId, long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R(groupId, roleId, start, end, orderByComparator);
	}

	/**
	* Finds the first user group group role in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roleId the role id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a matching user group group role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByG_R_First(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R_First(groupId, roleId, orderByComparator);
	}

	/**
	* Finds the last user group group role in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roleId the role id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a matching user group group role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole findByG_R_Last(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R_Last(groupId, roleId, orderByComparator);
	}

	/**
	* Finds the user group group roles before and after the current user group group role in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userGroupGroupRolePK the primary key of the current user group group role
	* @param groupId the group id to search with
	* @param roleId the role id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user group group role
	* @throws com.liferay.portal.NoSuchUserGroupGroupRoleException if a user group group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole[] findByG_R_PrevAndNext(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK,
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserGroupGroupRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R_PrevAndNext(userGroupGroupRolePK, groupId,
			roleId, orderByComparator);
	}

	/**
	* Finds all the user group group roles.
	*
	* @return the user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the user group group roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @return the range of user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the user group group roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user group group roles where userGroupId = &#63; from the database.
	*
	* @param userGroupId the user group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserGroupId(long userGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserGroupId(userGroupId);
	}

	/**
	* Removes all the user group group roles where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the user group group roles where roleId = &#63; from the database.
	*
	* @param roleId the role id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRoleId(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRoleId(roleId);
	}

	/**
	* Removes all the user group group roles where userGroupId = &#63; and groupId = &#63; from the database.
	*
	* @param userGroupId the user group id to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_G(long userGroupId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_G(userGroupId, groupId);
	}

	/**
	* Removes all the user group group roles where groupId = &#63; and roleId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param roleId the role id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_R(long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_R(groupId, roleId);
	}

	/**
	* Removes all the user group group roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the user group group roles where userGroupId = &#63;.
	*
	* @param userGroupId the user group id to search with
	* @return the number of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserGroupId(long userGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserGroupId(userGroupId);
	}

	/**
	* Counts all the user group group roles where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Counts all the user group group roles where roleId = &#63;.
	*
	* @param roleId the role id to search with
	* @return the number of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoleId(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRoleId(roleId);
	}

	/**
	* Counts all the user group group roles where userGroupId = &#63; and groupId = &#63;.
	*
	* @param userGroupId the user group id to search with
	* @param groupId the group id to search with
	* @return the number of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_G(long userGroupId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_G(userGroupId, groupId);
	}

	/**
	* Counts all the user group group roles where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group id to search with
	* @param roleId the role id to search with
	* @return the number of matching user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_R(long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_R(groupId, roleId);
	}

	/**
	* Counts all the user group group roles.
	*
	* @return the number of user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserGroupGroupRolePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserGroupGroupRolePersistence)PortalBeanLocatorUtil.locate(UserGroupGroupRolePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(UserGroupGroupRolePersistence persistence) {
		_persistence = persistence;
	}

	private static UserGroupGroupRolePersistence _persistence;
}