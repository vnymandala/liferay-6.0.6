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

package com.liferay.portal.model;

/**
 * The model interface for the Role service. Represents a row in the &quot;Role_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portal.model.impl.RoleImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a role model instance should use the {@link Role} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleModel
 * @see com.liferay.portal.model.impl.RoleImpl
 * @see com.liferay.portal.model.impl.RoleModelImpl
 * @generated
 */
public interface Role extends RoleModel {
	public java.lang.String getDescriptiveName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getTitle(java.lang.String languageId);

	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault);

	public java.lang.String getTypeLabel();

	public boolean isTeam();
}