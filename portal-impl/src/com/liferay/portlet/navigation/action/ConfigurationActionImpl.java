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

package com.liferay.portlet.navigation.action;

import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurationActionImpl extends BaseConfigurationAction {

	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		String displayStyle = ParamUtil.getString(
			actionRequest, "displayStyle");
		String bulletStyle = ParamUtil.getString(actionRequest, "bulletStyle");
		String headerType = ParamUtil.getString(actionRequest, "headerType");
		String rootLayoutType = ParamUtil.getString(
			actionRequest, "rootLayoutType");
		int rootLayoutLevel = ParamUtil.getInteger(
			actionRequest, "rootLayoutLevel");
		String includedLayouts = ParamUtil.getString(
			actionRequest, "includedLayouts");
		boolean nestedChildren = ParamUtil.getBoolean(
			actionRequest, "nestedChildren");

		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		preferences.setValue("display-style", displayStyle);
		preferences.setValue("bullet-style", bulletStyle);

		if (displayStyle.equals("[custom]")) {
			preferences.setValue("header-type", headerType);
			preferences.setValue("root-layout-type", rootLayoutType);
			preferences.setValue(
				"root-layout-level", String.valueOf(rootLayoutLevel));
			preferences.setValue("included-layouts", includedLayouts);
			preferences.setValue(
				"nested-children", String.valueOf(nestedChildren));
		}

		preferences.store();

		SessionMessages.add(
			actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}

	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		return "/html/portlet/navigation/configuration.jsp";
	}

}