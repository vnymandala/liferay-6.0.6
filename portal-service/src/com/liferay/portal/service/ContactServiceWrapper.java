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
 * This class is a wrapper for {@link ContactService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ContactService
 * @generated
 */
public class ContactServiceWrapper implements ContactService {
	public ContactServiceWrapper(ContactService contactService) {
		_contactService = contactService;
	}

	public ContactService getWrappedContactService() {
		return _contactService;
	}

	private ContactService _contactService;
}