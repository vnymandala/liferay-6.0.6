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

package com.liferay.portal.kernel.messaging;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 * @author Michael C. Han
 */
public class Message implements Serializable {

	public Object get(String key) {
		if (_values == null) {
			return null;
		}
		else {
			return _values.get(key);
		}
	}

	public boolean getBoolean(String key) {
		boolean value;

		Object object = get(key);

		if (object instanceof Boolean) {
			value = ((Boolean)object).booleanValue();
		}
		else {
			value = GetterUtil.getBoolean((String)object);
		}

		return value;
	}

	public String getDestinationName() {
		return _destinationName;
	}

	public double getDouble(String key) {
		double value;

		Object object = get(key);

		if (object instanceof Number) {
			value = ((Number)object).doubleValue();
		}
		else {
			value = GetterUtil.getDouble((String)object);
		}

		return value;
	}

	public int getInteger(String key) {
		int value;

		Object object = get(key);

		if (object instanceof Number) {
			value = ((Number)object).intValue();
		}
		else {
			value = GetterUtil.getInteger((String)object);
		}

		return value;
	}

	public long getLong(String key) {
		long value;

		Object object = get(key);

		if (object instanceof Number) {
			value = ((Number)object).longValue();
		}
		else {
			value = GetterUtil.getLong((String)object);
		}

		return value;
	}

	public Object getPayload() {
		return _payload;
	}

	public String getResponseDestinationName() {
		return _responseDestinationName;
	}

	public String getResponseId() {
		return _responseId;
	}

	public String getString(String key) {
		return GetterUtil.getString(String.valueOf(get(key)));
	}

	public void put(String key, Object value) {
		if (_values == null) {
			 _values = new HashMap<String, Object>();
		}

		_values.put(key, value);
	}

	public void setDestinationName(String destinationName) {
		_destinationName = destinationName;
	}

	public void setPayload(Object payload) {
		_payload = payload;
	}

	public void setResponseDestinationName(String responseDestinationName) {
		_responseDestinationName = responseDestinationName;
	}

	public void setResponseId(String responseId) {
		_responseId = responseId;
	}

	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{destinationName=");
		sb.append(_destinationName);
		sb.append(", responseDestinationName=");
		sb.append(_responseDestinationName);
		sb.append(", responseId=");
		sb.append(_responseId);
		sb.append(", payload=");
		sb.append(_payload);
		sb.append(", values=");
		sb.append(_values);
		sb.append("}");

		return sb.toString();
	}

	private String _destinationName;
	private Object _payload;
	private String _responseDestinationName;
	private String _responseId;
	private Map<String, Object> _values;

}