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

package com.liferay.portal.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.Country;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class CountryJSONSerializer {
	public static JSONObject toJSONObject(Country model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("countryId", model.getCountryId());
		jsonObj.put("name", model.getName());
		jsonObj.put("a2", model.getA2());
		jsonObj.put("a3", model.getA3());
		jsonObj.put("number", model.getNumber());
		jsonObj.put("idd", model.getIdd());
		jsonObj.put("active", model.getActive());

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Country[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Country model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.Country[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Country[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.Country> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Country model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}