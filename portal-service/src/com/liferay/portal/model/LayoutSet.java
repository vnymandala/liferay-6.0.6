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
 * The model interface for the LayoutSet service. Represents a row in the &quot;LayoutSet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portal.model.impl.LayoutSetImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a layout set model instance should use the {@link LayoutSet} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetModel
 * @see com.liferay.portal.model.impl.LayoutSetImpl
 * @see com.liferay.portal.model.impl.LayoutSetModelImpl
 * @generated
 */
public interface LayoutSet extends LayoutSetModel {
	public com.liferay.portal.model.Theme getTheme()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.ColorScheme getColorScheme()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Group getGroup()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getSettings();

	public com.liferay.portal.kernel.util.UnicodeProperties getSettingsProperties();

	public java.lang.String getSettingsProperty(java.lang.String key);

	public com.liferay.portal.model.Theme getWapTheme()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.ColorScheme getWapColorScheme()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void setSettings(java.lang.String settings);

	public void setSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties settingsProperties);
}