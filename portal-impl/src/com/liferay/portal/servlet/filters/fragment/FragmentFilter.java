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

package com.liferay.portal.servlet.filters.fragment;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.StringServletResponse;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.util.servlet.ServletResponseUtil;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class FragmentFilter extends BasePortalFilter {

	public static final String SKIP_FILTER =
		FragmentFilter.class.getName() + "SKIP_FILTER";

	protected String getContent(HttpServletRequest request, String content) {
		String fragmentId = ParamUtil.getString(request, "p_f_id");

		int x = content.indexOf("<!-- Begin fragment " + fragmentId + " -->");
		int y = content.indexOf("<!-- End fragment " + fragmentId + " -->");

		if ((x == -1) || (y == -1)) {
			return content;
		}

		x = content.indexOf(">", x);

		return content.substring(x + 1, y);
	}

	protected boolean isAlreadyFiltered(HttpServletRequest request) {
		if (request.getAttribute(SKIP_FILTER) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	protected boolean isFragment(
		HttpServletRequest request, HttpServletResponse response) {

		String fragmentId = ParamUtil.getString(request, "p_f_id");

		if (Validator.isNotNull(fragmentId)) {
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

		if (isFragment(request, response) && !isAlreadyFiltered(request)) {
			request.setAttribute(SKIP_FILTER, Boolean.TRUE);

			if (_log.isDebugEnabled()) {
				String completeURL = HttpUtil.getCompleteURL(request);

				_log.debug("Fragmenting " + completeURL);
			}

			StringServletResponse stringServerResponse =
				new StringServletResponse(response);

			processFilter(
				FragmentFilter.class, request, stringServerResponse,
				filterChain);

			String content = getContent(
				request, stringServerResponse.getString());

			ServletResponseUtil.write(response, content);
		}
		else {
			if (_log.isDebugEnabled()) {
				String completeURL = HttpUtil.getCompleteURL(request);

				_log.debug("Not fragmenting " + completeURL);
			}

			processFilter(FragmentFilter.class, request, response, filterChain);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FragmentFilter.class);

}