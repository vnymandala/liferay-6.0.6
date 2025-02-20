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

package com.liferay.portlet.documentlibrary.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.base.DLFileVersionServiceBaseImpl;
import com.liferay.portlet.documentlibrary.service.permission.DLFileEntryPermission;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileVersionServiceImpl extends DLFileVersionServiceBaseImpl {

	public DLFileVersion updateDescription(
			long fileVersionId, String description)
		throws PortalException, SystemException {

		DLFileVersion fileVersion = dlFileVersionPersistence.findByPrimaryKey(
			fileVersionId);

		DLFileEntryPermission.check(
			getPermissionChecker(), fileVersion.getGroupId(),
			fileVersion.getFolderId(), fileVersion.getName(),
			ActionKeys.UPDATE);

		return dlFileVersionLocalService.updateDescription(
			fileVersionId, description);
	}

}