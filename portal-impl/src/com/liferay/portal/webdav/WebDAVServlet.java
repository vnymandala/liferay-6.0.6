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

package com.liferay.portal.webdav;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.kernel.webdav.WebDAVRequest;
import com.liferay.portal.kernel.webdav.WebDAVStorage;
import com.liferay.portal.kernel.webdav.WebDAVUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.webdav.methods.Method;
import com.liferay.portal.webdav.methods.MethodFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class WebDAVServlet extends HttpServlet {

	public void service(
		HttpServletRequest request, HttpServletResponse response) {

		int status = HttpServletResponse.SC_PRECONDITION_FAILED;

		String userAgent = request.getHeader(HttpHeaders.USER_AGENT);

		if (_log.isDebugEnabled()) {
			_log.debug("User agent " + userAgent);
		}

		try {
			if (isIgnoredResource(request)) {
				status = HttpServletResponse.SC_NOT_FOUND;

				return;
			}

			WebDAVStorage storage = getStorage(request);

			if (storage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug("Invalid WebDAV path " + request.getPathInfo());
				}

				return;
			}

			// Set the path only if it has not already been set. This works
			// if and only if the servlet is not mapped to more than one URL.

			if (storage.getRootPath() == null) {
				storage.setRootPath(getRootPath(request));
			}

			PermissionChecker permissionChecker = null;

			String remoteUser = request.getRemoteUser();

			if (remoteUser != null) {
				PrincipalThreadLocal.setName(remoteUser);

				long userId = GetterUtil.getLong(remoteUser);

				User user = UserLocalServiceUtil.getUserById(userId);

				permissionChecker = PermissionCheckerFactoryUtil.create(
					user, true);

				PermissionThreadLocal.setPermissionChecker(permissionChecker);
			}

			// Get the method instance

			Method method = MethodFactory.create(request);

			// Process the method

			try {
				WebDAVRequest webDavRequest = new WebDAVRequestImpl(
					storage, request, response, userAgent, permissionChecker);

				status = method.process(webDavRequest);
			}
			catch (WebDAVException wde) {
				if (_log.isWarnEnabled()) {
					_log.warn(wde, wde);
				}

				status = HttpServletResponse.SC_PRECONDITION_FAILED;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
		finally {
			response.setStatus(status);

			if (_log.isInfoEnabled()) {
				String xLitmus = GetterUtil.getString(
					request.getHeader("X-Litmus"));

				if (Validator.isNotNull(xLitmus)) {
					xLitmus += " ";
				}

				_log.info(
					xLitmus + request.getMethod() + " " +
						request.getRequestURI() + " " + status);
			}
		}
	}

	protected String getRootPath(HttpServletRequest request) {
		String contextPath = HttpUtil.fixPath(
			request.getContextPath(), false, true);
		String ServletPath = HttpUtil.fixPath(
			request.getServletPath(), false, true);

		return contextPath.concat(ServletPath);
	}

	protected WebDAVStorage getStorage(HttpServletRequest request) {
		String[] pathArray = WebDAVUtil.getPathArray(
			request.getPathInfo(), true);

		WebDAVStorage storage = null;

		if (pathArray.length == 0) {
			storage = (WebDAVStorage)InstancePool.get(
				CompanyWebDAVStorageImpl.class.getName());
		}
		else if (pathArray.length == 1) {
			storage = (WebDAVStorage)InstancePool.get(
				GroupWebDAVStorageImpl.class.getName());
		}
		else if (pathArray.length >= 2) {
			storage = WebDAVUtil.getStorage(pathArray[1]);
		}

		return storage;
	}

	protected boolean isIgnoredResource(HttpServletRequest request) {
		String[] pathArray = WebDAVUtil.getPathArray(
			request.getPathInfo(), true);

		if ((pathArray == null) || (pathArray.length == 0)) {
			return false;
		}

		String resourceName = pathArray[pathArray.length - 1];

		for (String ignore : PropsValues.WEBDAV_IGNORE) {
			if (ignore.equals(resourceName)) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Skipping over " + request.getMethod() + " " +
							request.getPathInfo());
				}

				return true;
			}
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(WebDAVServlet.class);

}