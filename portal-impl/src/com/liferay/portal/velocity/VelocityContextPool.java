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

package com.liferay.portal.velocity;

import com.liferay.portal.kernel.servlet.ServletContextPool;

import javax.servlet.ServletContext;

/**
 * @author	   Brian Wing Shun Chan
 * @deprecated This class has been renamed to {@link ServletContextPool}.
 */
public class VelocityContextPool {

	public static boolean containsKey(String servletContextName) {
		return ServletContextPool.containsKey(servletContextName);
	}

	public static ServletContext get(String servletContextName) {
		return ServletContextPool.get(servletContextName);
	}

	public static void put(
		String servletContextName, ServletContext servletContext) {

		ServletContextPool.put(servletContextName, servletContext);
	}

	public static ServletContext remove(String servletContextName) {
		return ServletContextPool.remove(servletContextName);
	}

}