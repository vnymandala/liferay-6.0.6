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

package com.liferay.portlet.enterpriseadmin.search;

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.GroupLocalServiceUtil;

import javax.portlet.RenderResponse;

/**
 * @author Charles May
 */
public class UserGroupRoleChecker extends RowChecker {

	public UserGroupRoleChecker(RenderResponse renderResponse, Role role) {
		super(renderResponse);

		_role = role;
	}

	public boolean isChecked(Object obj) {
		UserGroup userGroup = (UserGroup)obj;

		try {
			return GroupLocalServiceUtil.hasRoleGroup(
				_role.getRoleId(), userGroup.getGroup().getGroupId());
		}
		catch (Exception e) {
			_log.error(e);

			return false;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UserGroupRoleChecker.class);

	private Role _role;

}