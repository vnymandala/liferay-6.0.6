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
 * The utility for the layout set remote service. This utility wraps {@link com.liferay.portal.service.impl.LayoutSetServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.LayoutSetServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetService
 * @see com.liferay.portal.service.base.LayoutSetServiceBaseImpl
 * @see com.liferay.portal.service.impl.LayoutSetServiceImpl
 * @generated
 */
public class LayoutSetServiceUtil {
	public static void updateLogo(long groupId, boolean privateLayout,
		boolean logo, java.io.File file)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateLogo(groupId, privateLayout, logo, file);
	}

	public static com.liferay.portal.model.LayoutSet updateLookAndFeel(
		long groupId, boolean privateLayout, java.lang.String themeId,
		java.lang.String colorSchemeId, java.lang.String css, boolean wapTheme)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLookAndFeel(groupId, privateLayout, themeId,
			colorSchemeId, css, wapTheme);
	}

	public static com.liferay.portal.model.LayoutSet updateSettings(
		long groupId, boolean privateLayout, java.lang.String settings)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSettings(groupId, privateLayout, settings);
	}

	public static com.liferay.portal.model.LayoutSet updateVirtualHost(
		long groupId, boolean privateLayout, java.lang.String virtualHost)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVirtualHost(groupId, privateLayout, virtualHost);
	}

	public static LayoutSetService getService() {
		if (_service == null) {
			_service = (LayoutSetService)PortalBeanLocatorUtil.locate(LayoutSetService.class.getName());
		}

		return _service;
	}

	public void setService(LayoutSetService service) {
		_service = service;
	}

	private static LayoutSetService _service;
}