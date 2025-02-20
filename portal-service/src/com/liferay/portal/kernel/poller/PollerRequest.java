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

package com.liferay.portal.kernel.poller;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class PollerRequest {

	public PollerRequest(
		PollerHeader pollerHeader, String portletId,
		Map<String, String> parameterMap, String chunkId,
		boolean receiveRequest) {

		_pollerHeader = pollerHeader;
		_portletId = portletId;
		_parameterMap = parameterMap;
		_chunkId = chunkId;
		_receiveRequest = receiveRequest;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PollerRequest)) {
			return false;
		}

		PollerRequest portletRequest = (PollerRequest)obj;

		if (Validator.equals(_portletId, portletRequest._portletId)) {
			return true;
		}

		return false;
	}

	public long getBrowserKey() {
		return _pollerHeader.getBrowserKey();
	}

	public String getChunkId() {
		return _chunkId;
	}

	public long getCompanyId() {
		return _pollerHeader.getCompanyId();
	}

	public Map<String, String> getParameterMap() {
		return _parameterMap;
	}

	public PollerHeader getPollerHeader() {
		return _pollerHeader;
	}

	public String getPortletId() {
		return _portletId;
	}

	public String[] getPortletIds() {
		return _pollerHeader.getPortletIds();
	}

	public long getTimestamp() {
		return _pollerHeader.getTimestamp();
	}

	public long getUserId() {
		return _pollerHeader.getUserId();
	}

	public int hashCode() {
		if (_portletId != null) {
			return _portletId.hashCode();
		}
		else {
			return 0;
		}
	}

	public boolean isInitialRequest() {
		return _pollerHeader.isInitialRequest();
	}

	public boolean isReceiveRequest() {
		return _receiveRequest;
	}

	public boolean isStartPolling() {
		return _pollerHeader.isStartPolling();
	}

	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{chunkId=");
		sb.append(_chunkId);
		sb.append(", parameterMap=");
		sb.append(_parameterMap);
		sb.append(", pollerHeader=");
		sb.append(_pollerHeader);
		sb.append(", portletId=");
		sb.append(_portletId);
		sb.append(", receiveRequest=");
		sb.append(_receiveRequest);
		sb.append("}");

		return sb.toString();
	}

	private String _chunkId;
	private Map<String, String> _parameterMap;
	private PollerHeader _pollerHeader;
	private String _portletId;
	private boolean _receiveRequest;

}