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

package com.liferay.taglib.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletModeFactory;
import com.liferay.portal.kernel.portlet.WindowStateFactory;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.util.PortalUtil;
import com.liferay.taglib.util.ParamAndPropertyAncestorTagImpl;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

/**
 * @author Brian Wing Shun Chan
 */
public class ActionURLTag extends ParamAndPropertyAncestorTagImpl {

	public static void doTag(
			String lifecycle, String windowState, String portletMode,
			String var, String varImpl, Boolean secure,
			Boolean copyCurrentRenderParameters, Boolean escapeXml, String name,
			String resourceID, String cacheability, long plid,
			String portletName, Boolean anchor, Boolean encrypt,
			long doAsUserId, Boolean portletConfiguration,
			Map<String, String[]> params, PageContext pageContext)
		throws Exception {

		HttpServletRequest request =
			(HttpServletRequest)pageContext.getRequest();

		if (portletName == null) {
			portletName = _getPortletName(request);
		}

		LiferayPortletURL liferayPortletURL = _getLiferayPortletURL(
			request, plid, portletName, lifecycle);

		if (liferayPortletURL == null) {
			_log.error(
				"Render response is null because this tag is not being " +
					"called within the context of a portlet");

			return;
		}

		if (Validator.isNotNull(windowState)) {
			liferayPortletURL.setWindowState(
				WindowStateFactory.getWindowState(windowState));
		}

		if (Validator.isNotNull(portletMode)) {
			liferayPortletURL.setPortletMode(
				PortletModeFactory.getPortletMode(portletMode));
		}

		if (secure != null) {
			liferayPortletURL.setSecure(secure.booleanValue());
		}
		else {
			liferayPortletURL.setSecure(request.isSecure());
		}

		if (copyCurrentRenderParameters != null) {
			liferayPortletURL.setCopyCurrentRenderParameters(
				copyCurrentRenderParameters.booleanValue());
		}

		if (escapeXml != null) {
			liferayPortletURL.setEscapeXml(escapeXml.booleanValue());
		}

		if (lifecycle.equals(PortletRequest.ACTION_PHASE) &&
			Validator.isNotNull(name)) {

			liferayPortletURL.setParameter(ActionRequest.ACTION_NAME, name);
		}

		if (resourceID != null) {
			liferayPortletURL.setResourceID(resourceID);
		}

		if (cacheability != null) {
			liferayPortletURL.setCacheability(cacheability);
		}

		if (anchor != null) {
			liferayPortletURL.setAnchor(anchor.booleanValue());
		}

		if (encrypt != null) {
			liferayPortletURL.setEncrypt(encrypt.booleanValue());
		}

		if (doAsUserId > 0) {
			liferayPortletURL.setDoAsUserId(doAsUserId);
		}

		if ((portletConfiguration != null) &&
			portletConfiguration.booleanValue()) {

			String returnToFullPageURL = ParamUtil.getString(
				request, "returnToFullPageURL");
			String portletResource = ParamUtil.getString(
				request, "portletResource");
			String previewWidth = ParamUtil.getString(request, "previewWidth");

			liferayPortletURL.setParameter(
				"struts_action", "/portlet_configuration/edit_configuration");
			liferayPortletURL.setParameter(
				"returnToFullPageURL", returnToFullPageURL);
			liferayPortletURL.setParameter("portletResource", portletResource);
			liferayPortletURL.setParameter("previewWidth", previewWidth);
		}

		if (params != null) {
			MapUtil.merge(liferayPortletURL.getParameterMap(), params);

			liferayPortletURL.setParameters(params);
		}

		String portletURLToString = liferayPortletURL.toString();

		if (Validator.isNotNull(var)) {
			pageContext.setAttribute(var, portletURLToString);
		}
		else if (Validator.isNotNull(varImpl)) {
			pageContext.setAttribute(varImpl, liferayPortletURL);
		}
		else {
			pageContext.getOut().print(portletURLToString);
		}
	}

	public int doEndTag() throws JspException {
		try {
			doTag(
				getLifecycle(), _windowState, _portletMode, _var, _varImpl,
				_secure, _copyCurrentRenderParameters, _escapeXml, _name,
				_resourceID, _cacheability, _plid, _portletName, _anchor,
				_encrypt, _doAsUserId, _portletConfiguration, getParams(),
				pageContext);

			return EVAL_PAGE;
		}
		catch (Exception e) {
			throw new JspException(e);
		}
		finally {
			clearParams();
			clearProperties();

			_plid = LayoutConstants.DEFAULT_PLID;
		}
	}

	public String getLifecycle() {
		return PortletRequest.ACTION_PHASE;
	}

	public void setWindowState(String windowState) {
		_windowState = windowState;
	}

	public void setPortletMode(String portletMode) {
		_portletMode = portletMode;
	}

	public void setVar(String var) {
		_var = var;
	}

	public void setVarImpl(String varImpl) {
		_varImpl = varImpl;
	}

	public void setSecure(boolean secure) {
		_secure = Boolean.valueOf(secure);
	}

	public void setCopyCurrentRenderParameters(
		boolean copyCurrentRenderParameters) {

		_copyCurrentRenderParameters = Boolean.valueOf(
			copyCurrentRenderParameters);
	}

	public void setEscapeXml(boolean escapeXml) {
		_escapeXml = Boolean.valueOf(escapeXml);
	}

	public void setName(String name) {
		_name = name;
	}

	public void setId(String resourceID) {
		_resourceID = resourceID;
	}

	public void setCacheability(String cacheability) {
		_cacheability = cacheability;
	}

	public void setPlid(long plid) {
		_plid = plid;
	}

	public void setPortletName(String portletName) {
		_portletName = portletName;
	}

	public void setAnchor(boolean anchor) {
		_anchor = Boolean.valueOf(anchor);
	}

	public void setEncrypt(boolean encrypt) {
		_encrypt = Boolean.valueOf(encrypt);
	}

	public void setDoAsUserId(long doAsUserId) {
		_doAsUserId = doAsUserId;
	}

	public void setPortletConfiguration(boolean portletConfiguration) {
		_portletConfiguration = Boolean.valueOf(portletConfiguration);
	}

	private static LiferayPortletURL _getLiferayPortletURL(
		HttpServletRequest request, long plid, String portletName,
		String lifecycle) {

		PortletRequest portletRequest = (PortletRequest)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_REQUEST);

		if (portletRequest == null) {
			return null;
		}

		PortletResponse portletResponse = (PortletResponse)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_RESPONSE);

		LiferayPortletResponse liferayPortletResponse =
			PortalUtil.getLiferayPortletResponse(portletResponse);

		return liferayPortletResponse.createLiferayPortletURL(
			plid, portletName, lifecycle);
	}

	private static String _getPortletName(HttpServletRequest request) {
		PortletRequest portletRequest = (PortletRequest)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_REQUEST);

		if (portletRequest == null) {
			return null;
		}

		LiferayPortletConfig liferayPortletConfig =
			(LiferayPortletConfig)request.getAttribute(
				JavaConstants.JAVAX_PORTLET_CONFIG);

		return liferayPortletConfig.getPortletId();
	}

	private static Log _log = LogFactoryUtil.getLog(ActionURLTag.class);

	private String _windowState;
	private String _portletMode;
	private String _var;
	private String _varImpl;
	private Boolean _secure;
	private Boolean _copyCurrentRenderParameters;
	private Boolean _escapeXml;
	private String  _name;
	private String _resourceID;
	private String _cacheability;
	private long _plid = LayoutConstants.DEFAULT_PLID;
	private String _portletName;
	private Boolean _anchor;
	private Boolean _encrypt;
	private long _doAsUserId;
	private Boolean _portletConfiguration;

}