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

package com.liferay.portal.servlet.filters.themepreview;

import com.liferay.portal.kernel.servlet.StringServletResponse;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.portal.servlet.filters.strip.StripFilter;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;
import com.liferay.util.servlet.ServletResponseUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ganesh Ram
 */
public class ThemePreviewFilter extends BasePortalFilter {

	protected String getContent(HttpServletRequest request, String content) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Pattern cssPattern = Pattern.compile(
			themeDisplay.getPathThemeCss());

		Matcher cssMatcher = cssPattern.matcher(content);

		content = cssMatcher.replaceAll("css");

		Pattern imagePattern = Pattern.compile(
			themeDisplay.getPathThemeImages());

		Matcher imageMatcher = imagePattern.matcher(content);

		content = imageMatcher.replaceAll("images");

		return content;
	}

	protected boolean isThemePreview(HttpServletRequest request) {
		if (ParamUtil.getBoolean(request, _THEME_PREVIEW)) {
			return true;
		}
		else {
			return false;
		}
	}

	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		if (isThemePreview(request)) {
			request.setAttribute(StripFilter.SKIP_FILTER, Boolean.TRUE);

			StringServletResponse stringServerResponse =
				new StringServletResponse(response);

			processFilter(
				ThemePreviewFilter.class, request, stringServerResponse,
				filterChain);

			String content = getContent(
				request, stringServerResponse.getString());

			ServletResponseUtil.write(response, content);
		}
		else {
			processFilter(
				ThemePreviewFilter.class, request, response, filterChain);
		}
	}

	private static final String _THEME_PREVIEW = "themePreview";

}