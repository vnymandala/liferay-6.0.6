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

package com.liferay.mail.service;

import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Alexander Chow
 */
@Transactional(rollbackFor = {PortalException.class, SystemException.class})
public interface CyrusService {

	public void addUser(long userId, String emailAddress, String password)
		throws SystemException;

	public void deleteEmailAddress(long companyId, long userId)
		throws SystemException;

	public void deleteUser(long userId) throws SystemException;

	public void updateEmailAddress(
			long companyId, long userId, String emailAddress)
		throws SystemException;

	public void updatePassword(long companyId, long userId, String password)
		throws SystemException;

}