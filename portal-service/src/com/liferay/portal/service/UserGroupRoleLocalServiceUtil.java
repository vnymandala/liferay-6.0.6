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
 * The utility for the user group role local service. This utility wraps {@link com.liferay.portal.service.impl.UserGroupRoleLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.UserGroupRoleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupRoleLocalService
 * @see com.liferay.portal.service.base.UserGroupRoleLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.UserGroupRoleLocalServiceImpl
 * @generated
 */
public class UserGroupRoleLocalServiceUtil {
	/**
	* Adds the user group role to the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRole the user group role to add
	* @return the user group role that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupRole addUserGroupRole(
		com.liferay.portal.model.UserGroupRole userGroupRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserGroupRole(userGroupRole);
	}

	/**
	* Creates a new user group role with the primary key. Does not add the user group role to the database.
	*
	* @param userGroupRolePK the primary key for the new user group role
	* @return the new user group role
	*/
	public static com.liferay.portal.model.UserGroupRole createUserGroupRole(
		com.liferay.portal.service.persistence.UserGroupRolePK userGroupRolePK) {
		return getService().createUserGroupRole(userGroupRolePK);
	}

	/**
	* Deletes the user group role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRolePK the primary key of the user group role to delete
	* @throws PortalException if a user group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserGroupRole(
		com.liferay.portal.service.persistence.UserGroupRolePK userGroupRolePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRole(userGroupRolePK);
	}

	/**
	* Deletes the user group role from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRole the user group role to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserGroupRole(
		com.liferay.portal.model.UserGroupRole userGroupRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRole(userGroupRole);
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
	* Gets the user group role with the primary key.
	*
	* @param userGroupRolePK the primary key of the user group role to get
	* @return the user group role
	* @throws PortalException if a user group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupRole getUserGroupRole(
		com.liferay.portal.service.persistence.UserGroupRolePK userGroupRolePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupRole(userGroupRolePK);
	}

	/**
	* Gets a range of all the user group roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user group roles to return
	* @param end the upper bound of the range of user group roles to return (not inclusive)
	* @return the range of user group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupRole> getUserGroupRoles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupRoles(start, end);
	}

	/**
	* Gets the number of user group roles.
	*
	* @return the number of user group roles
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserGroupRolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupRolesCount();
	}

	/**
	* Updates the user group role in the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRole the user group role to update
	* @return the user group role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupRole updateUserGroupRole(
		com.liferay.portal.model.UserGroupRole userGroupRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserGroupRole(userGroupRole);
	}

	/**
	* Updates the user group role in the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRole the user group role to update
	* @param merge whether to merge the user group role with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user group role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupRole updateUserGroupRole(
		com.liferay.portal.model.UserGroupRole userGroupRole, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserGroupRole(userGroupRole, merge);
	}

	public static void addUserGroupRoles(long userId, long groupId,
		long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addUserGroupRoles(userId, groupId, roleIds);
	}

	public static void addUserGroupRoles(long[] userIds, long groupId,
		long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addUserGroupRoles(userIds, groupId, roleId);
	}

	public static void deleteUserGroupRoles(long userId, long groupId,
		long[] roleIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRoles(userId, groupId, roleIds);
	}

	public static void deleteUserGroupRoles(long userId, long[] groupIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRoles(userId, groupIds);
	}

	public static void deleteUserGroupRoles(long[] userIds, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRoles(userIds, groupId);
	}

	public static void deleteUserGroupRoles(long[] userIds, long groupId,
		long roleId) throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRoles(userIds, groupId, roleId);
	}

	public static void deleteUserGroupRolesByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRolesByGroupId(groupId);
	}

	public static void deleteUserGroupRolesByRoleId(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRolesByRoleId(roleId);
	}

	public static void deleteUserGroupRolesByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupRolesByUserId(userId);
	}

	public static java.util.List<com.liferay.portal.model.UserGroupRole> getUserGroupRoles(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupRoles(userId);
	}

	public static java.util.List<com.liferay.portal.model.UserGroupRole> getUserGroupRoles(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupRoles(userId, groupId);
	}

	public static java.util.List<com.liferay.portal.model.UserGroupRole> getUserGroupRolesByGroupAndRole(
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupRolesByGroupAndRole(groupId, roleId);
	}

	public static java.util.List<com.liferay.portal.model.UserGroupRole> getUserGroupRolesByUserUserGroupAndGroup(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUserGroupRolesByUserUserGroupAndGroup(userId, groupId);
	}

	public static boolean hasUserGroupRole(long userId, long groupId,
		long roleId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserGroupRole(userId, groupId, roleId);
	}

	public static boolean hasUserGroupRole(long userId, long groupId,
		long roleId, boolean inherit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserGroupRole(userId, groupId, roleId, inherit);
	}

	public static boolean hasUserGroupRole(long userId, long groupId,
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserGroupRole(userId, groupId, roleName);
	}

	public static boolean hasUserGroupRole(long userId, long groupId,
		java.lang.String roleName, boolean inherit)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserGroupRole(userId, groupId, roleName, inherit);
	}

	public static UserGroupRoleLocalService getService() {
		if (_service == null) {
			_service = (UserGroupRoleLocalService)PortalBeanLocatorUtil.locate(UserGroupRoleLocalService.class.getName());
		}

		return _service;
	}

	public void setService(UserGroupRoleLocalService service) {
		_service = service;
	}

	private static UserGroupRoleLocalService _service;
}