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
 * This class is a wrapper for {@link UserGroupRoleLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       UserGroupRoleLocalService
 * @generated
 */
public class UserGroupRoleLocalServiceWrapper
	implements UserGroupRoleLocalService {
	public UserGroupRoleLocalServiceWrapper(
		UserGroupRoleLocalService userGroupRoleLocalService) {
		_userGroupRoleLocalService = userGroupRoleLocalService;
	}

	/**
	* Adds the user group role to the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRole the user group role to add
	* @return the user group role that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserGroupRole addUserGroupRole(
		com.liferay.portal.model.UserGroupRole userGroupRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.addUserGroupRole(userGroupRole);
	}

	/**
	* Creates a new user group role with the primary key. Does not add the user group role to the database.
	*
	* @param userGroupRolePK the primary key for the new user group role
	* @return the new user group role
	*/
	public com.liferay.portal.model.UserGroupRole createUserGroupRole(
		com.liferay.portal.service.persistence.UserGroupRolePK userGroupRolePK) {
		return _userGroupRoleLocalService.createUserGroupRole(userGroupRolePK);
	}

	/**
	* Deletes the user group role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRolePK the primary key of the user group role to delete
	* @throws PortalException if a user group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserGroupRole(
		com.liferay.portal.service.persistence.UserGroupRolePK userGroupRolePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.deleteUserGroupRole(userGroupRolePK);
	}

	/**
	* Deletes the user group role from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRole the user group role to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserGroupRole(
		com.liferay.portal.model.UserGroupRole userGroupRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.deleteUserGroupRole(userGroupRole);
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
		return _userGroupRoleLocalService.dynamicQuery(dynamicQuery);
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
		return _userGroupRoleLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _userGroupRoleLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _userGroupRoleLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the user group role with the primary key.
	*
	* @param userGroupRolePK the primary key of the user group role to get
	* @return the user group role
	* @throws PortalException if a user group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserGroupRole getUserGroupRole(
		com.liferay.portal.service.persistence.UserGroupRolePK userGroupRolePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.getUserGroupRole(userGroupRolePK);
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
	public java.util.List<com.liferay.portal.model.UserGroupRole> getUserGroupRoles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.getUserGroupRoles(start, end);
	}

	/**
	* Gets the number of user group roles.
	*
	* @return the number of user group roles
	* @throws SystemException if a system exception occurred
	*/
	public int getUserGroupRolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.getUserGroupRolesCount();
	}

	/**
	* Updates the user group role in the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRole the user group role to update
	* @return the user group role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserGroupRole updateUserGroupRole(
		com.liferay.portal.model.UserGroupRole userGroupRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.updateUserGroupRole(userGroupRole);
	}

	/**
	* Updates the user group role in the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRole the user group role to update
	* @param merge whether to merge the user group role with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user group role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserGroupRole updateUserGroupRole(
		com.liferay.portal.model.UserGroupRole userGroupRole, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.updateUserGroupRole(userGroupRole,
			merge);
	}

	public void addUserGroupRoles(long userId, long groupId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.addUserGroupRoles(userId, groupId, roleIds);
	}

	public void addUserGroupRoles(long[] userIds, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.addUserGroupRoles(userIds, groupId, roleId);
	}

	public void deleteUserGroupRoles(long userId, long groupId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.deleteUserGroupRoles(userId, groupId, roleIds);
	}

	public void deleteUserGroupRoles(long userId, long[] groupIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.deleteUserGroupRoles(userId, groupIds);
	}

	public void deleteUserGroupRoles(long[] userIds, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.deleteUserGroupRoles(userIds, groupId);
	}

	public void deleteUserGroupRoles(long[] userIds, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.deleteUserGroupRoles(userIds, groupId, roleId);
	}

	public void deleteUserGroupRolesByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.deleteUserGroupRolesByGroupId(groupId);
	}

	public void deleteUserGroupRolesByRoleId(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.deleteUserGroupRolesByRoleId(roleId);
	}

	public void deleteUserGroupRolesByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleLocalService.deleteUserGroupRolesByUserId(userId);
	}

	public java.util.List<com.liferay.portal.model.UserGroupRole> getUserGroupRoles(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.getUserGroupRoles(userId);
	}

	public java.util.List<com.liferay.portal.model.UserGroupRole> getUserGroupRoles(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.getUserGroupRoles(userId, groupId);
	}

	public java.util.List<com.liferay.portal.model.UserGroupRole> getUserGroupRolesByGroupAndRole(
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.getUserGroupRolesByGroupAndRole(groupId,
			roleId);
	}

	public java.util.List<com.liferay.portal.model.UserGroupRole> getUserGroupRolesByUserUserGroupAndGroup(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.getUserGroupRolesByUserUserGroupAndGroup(userId,
			groupId);
	}

	public boolean hasUserGroupRole(long userId, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.hasUserGroupRole(userId, groupId,
			roleId);
	}

	public boolean hasUserGroupRole(long userId, long groupId, long roleId,
		boolean inherit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.hasUserGroupRole(userId, groupId,
			roleId, inherit);
	}

	public boolean hasUserGroupRole(long userId, long groupId,
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.hasUserGroupRole(userId, groupId,
			roleName);
	}

	public boolean hasUserGroupRole(long userId, long groupId,
		java.lang.String roleName, boolean inherit)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleLocalService.hasUserGroupRole(userId, groupId,
			roleName, inherit);
	}

	public UserGroupRoleLocalService getWrappedUserGroupRoleLocalService() {
		return _userGroupRoleLocalService;
	}

	private UserGroupRoleLocalService _userGroupRoleLocalService;
}