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

package com.liferay.portlet.login.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthException;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.CookieKeys;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletURLImpl;
import com.liferay.util.Encryptor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 * @author Scott Lee
 */
public class LoginUtil {

	public static String getLogin(
			HttpServletRequest request, String paramName, Company company)
		throws SystemException {

		String login = request.getParameter(paramName);

		if ((login == null) || (login.equals(StringPool.NULL))) {
			login = GetterUtil.getString(
				CookieKeys.getCookie(request, CookieKeys.LOGIN));

			if (PropsValues.COMPANY_LOGIN_PREPOPULATE_DOMAIN &&
				Validator.isNull(login) &&
				company.getAuthType().equals(CompanyConstants.AUTH_TYPE_EA)) {

				login = "@" + company.getMx();
			}
		}

		return login;
	}

	public static PortletURL getLoginURL(
			HttpServletRequest request, long plid)
		throws PortletModeException, WindowStateException {

		PortletURL portletURL = new PortletURLImpl(
			request, PortletKeys.LOGIN, plid, PortletRequest.RENDER_PHASE);

		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setPortletMode(PortletMode.VIEW);

		portletURL.setParameter("saveLastPath", "0");
		portletURL.setParameter("struts_action", "/login/login");

		return portletURL;
	}

	public static void login(
			HttpServletRequest request, HttpServletResponse response,
			String login, String password, boolean rememberMe, String authType)
		throws Exception {

		CookieKeys.validateSupportCookie(request);

		HttpSession session = request.getSession();

		long userId = GetterUtil.getLong(login);

		int authResult = Authenticator.FAILURE;

		Company company = PortalUtil.getCompany(request);

		Map<String, String[]> headerMap = new HashMap<String, String[]>();

		Enumeration<String> enu1 = request.getHeaderNames();

		while (enu1.hasMoreElements()) {
			String name = enu1.nextElement();

			Enumeration<String> enu2 = request.getHeaders(name);

			List<String> headers = new ArrayList<String>();

			while (enu2.hasMoreElements()) {
				String value = enu2.nextElement();

				headers.add(value);
			}

			headerMap.put(name, headers.toArray(new String[headers.size()]));
		}

		Map<String, String[]> parameterMap = request.getParameterMap();

		if (Validator.isNull(authType)) {
			authType = company.getAuthType();
		}

		if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
			authResult = UserLocalServiceUtil.authenticateByEmailAddress(
				company.getCompanyId(), login, password, headerMap,
				parameterMap);

			userId = UserLocalServiceUtil.getUserIdByEmailAddress(
				company.getCompanyId(), login);
		}
		else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
			authResult = UserLocalServiceUtil.authenticateByScreenName(
				company.getCompanyId(), login, password, headerMap,
				parameterMap);

			userId = UserLocalServiceUtil.getUserIdByScreenName(
				company.getCompanyId(), login);
		}
		else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
			authResult = UserLocalServiceUtil.authenticateByUserId(
				company.getCompanyId(), userId, password, headerMap,
				parameterMap);
		}

		if (authResult == Authenticator.SUCCESS) {
			if (PropsValues.SESSION_ENABLE_PHISHING_PROTECTION) {

				// Invalidate the previous session to prevent phishing

				String[] protectedAttributeNames =
					PropsValues.SESSION_PHISHING_PROTECTED_ATTRIBUTES;

				Map<String, Object> protectedAttributes =
					new HashMap<String, Object>();

				for (String protectedAttributeName : protectedAttributeNames) {
					Object protectedAttributeValue = session.getAttribute(
						protectedAttributeName);

					if (protectedAttributeValue == null) {
						continue;
					}

					protectedAttributes.put(
						protectedAttributeName, protectedAttributeValue);
				}

				try {
					session.invalidate();
				}
				catch (IllegalStateException ise) {

					// This only happens in Geronimo

					if (_log.isWarnEnabled()) {
						_log.warn(ise.getMessage());
					}
				}

				session = request.getSession(true);

				for (String protectedAttributeName : protectedAttributeNames) {
					Object protectedAttributeValue = protectedAttributes.get(
						protectedAttributeName);

					if (protectedAttributeValue == null) {
						continue;
					}

					session.setAttribute(
						protectedAttributeName, protectedAttributeValue);
				}
			}

			// Set cookies

			String domain = CookieKeys.getDomain(request);

			User user = UserLocalServiceUtil.getUserById(userId);

			String userIdString = String.valueOf(userId);

			session.setAttribute("j_username", userIdString);
			session.setAttribute("j_password", user.getPassword());
			session.setAttribute("j_remoteuser", userIdString);

			if (PropsValues.SESSION_STORE_PASSWORD) {
				session.setAttribute(WebKeys.USER_PASSWORD, password);
			}

			Cookie companyIdCookie = new Cookie(
				CookieKeys.COMPANY_ID, String.valueOf(company.getCompanyId()));

			if (Validator.isNotNull(domain)) {
				companyIdCookie.setDomain(domain);
			}

			companyIdCookie.setPath(StringPool.SLASH);

			Cookie idCookie = new Cookie(
				CookieKeys.ID,
				UserLocalServiceUtil.encryptUserId(userIdString));

			if (Validator.isNotNull(domain)) {
				idCookie.setDomain(domain);
			}

			idCookie.setPath(StringPool.SLASH);

			Cookie passwordCookie = new Cookie(
				CookieKeys.PASSWORD,
				Encryptor.encrypt(company.getKeyObj(), password));

			if (Validator.isNotNull(domain)) {
				passwordCookie.setDomain(domain);
			}

			passwordCookie.setPath(StringPool.SLASH);

			Cookie rememberMeCookie = new Cookie(
				CookieKeys.REMEMBER_ME, Boolean.TRUE.toString());

			if (Validator.isNotNull(domain)) {
				rememberMeCookie.setDomain(domain);
			}

			rememberMeCookie.setPath(StringPool.SLASH);

			int loginMaxAge = PropsValues.COMPANY_SECURITY_AUTO_LOGIN_MAX_AGE;

			if (PropsValues.SESSION_DISABLED) {
				rememberMe = true;
			}

			if (rememberMe) {
				companyIdCookie.setMaxAge(loginMaxAge);
				idCookie.setMaxAge(loginMaxAge);
				passwordCookie.setMaxAge(loginMaxAge);
				rememberMeCookie.setMaxAge(loginMaxAge);
			}
			else {

				// This was explicitly changed from 0 to -1 so that the cookie
				// lasts as long as the browser. This allows an external servlet
				// wrapped in AutoLoginFilter to work throughout the client
				// connection. The cookies ARE removed on an actual logout, so
				// there is no security issue. See LEP-4678 and LEP-5177.

				companyIdCookie.setMaxAge(-1);
				idCookie.setMaxAge(-1);
				passwordCookie.setMaxAge(-1);
				rememberMeCookie.setMaxAge(0);
			}

			Cookie loginCookie = new Cookie(CookieKeys.LOGIN, login);

			if (Validator.isNotNull(domain)) {
				loginCookie.setDomain(domain);
			}

			loginCookie.setMaxAge(loginMaxAge);
			loginCookie.setPath(StringPool.SLASH);

			Cookie screenNameCookie = new Cookie(
				CookieKeys.SCREEN_NAME,
				Encryptor.encrypt(company.getKeyObj(), user.getScreenName()));

			if (Validator.isNotNull(domain)) {
				screenNameCookie.setDomain(domain);
			}

			screenNameCookie.setMaxAge(loginMaxAge);
			screenNameCookie.setPath(StringPool.SLASH);

			boolean secure = request.isSecure();

			if (secure) {
				Boolean httpsInitial = (Boolean)session.getAttribute(
					WebKeys.HTTPS_INITIAL);

				if ((httpsInitial == null) || !httpsInitial.booleanValue()) {
					secure = false;
				}
			}

			CookieKeys.addCookie(request, response, companyIdCookie, secure);
			CookieKeys.addCookie(request, response, idCookie, secure);
			CookieKeys.addCookie(request, response, passwordCookie, secure);
			CookieKeys.addCookie(request, response, rememberMeCookie, secure);
			CookieKeys.addCookie(request, response, loginCookie, secure);
			CookieKeys.addCookie(request, response, screenNameCookie, secure);
		}
		else {
			throw new AuthException();
		}
	}

	public static void sendPassword(ActionRequest actionRequest)
		throws Exception {

		String toAddress = ParamUtil.getString(actionRequest, "emailAddress");

		sendPassword(actionRequest, null, null, toAddress, null, null);
	}

	public static void sendPassword(
			ActionRequest actionRequest, String fromName, String fromAddress,
			String toAddress, String subject, String body)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Company company = themeDisplay.getCompany();

		if (!company.isSendPassword()) {
			return;
		}

		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		String userAgent = request.getHeader(HttpHeaders.USER_AGENT);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			User.class.getName(), actionRequest);

		UserLocalServiceUtil.sendPassword(
			company.getCompanyId(), toAddress, remoteAddr, remoteHost,
			userAgent, fromName, fromAddress, subject, body, serviceContext);

		SessionMessages.add(actionRequest, "request_processed", toAddress);
	}

	private static Log _log = LogFactoryUtil.getLog(LoginUtil.class);

}