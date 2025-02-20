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

package com.liferay.portal.kernel.bean;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletBeanLocatorUtil {

	public static BeanLocator getBeanLocator(String servletContextName) {
		return _beanLocators.get(servletContextName);
	}

	public static Object locate(String servletContextName, String name)
		throws BeanLocatorException {

		BeanLocator beanLocator = getBeanLocator(servletContextName);

		if (beanLocator == null) {
			_log.error("BeanLocator is null");

			throw new BeanLocatorException("BeanLocator has not been set");
		}
		else {
			return beanLocator.locate(name);
		}
	}

	public static void setBeanLocator(
		String servletContextName, BeanLocator beanLocator) {

		if (_log.isDebugEnabled()) {
			if (beanLocator != null) {
				_log.debug("Setting BeanLocator " + beanLocator.hashCode());
			}
			else {
				_log.debug("Setting BeanLocator null");
			}
		}

		_beanLocators.put(servletContextName, beanLocator);
	}

	private static Log _log = LogFactoryUtil.getLog(
		PortletBeanLocatorUtil.class);

	private static Map<String, BeanLocator> _beanLocators =
		new HashMap<String, BeanLocator>();

}