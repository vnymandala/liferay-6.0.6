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
import com.liferay.portal.model.ResourcePermission;

import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class ResourcePermissionJSONSerializer {
	public static JSONObject toJSONObject(ResourcePermission model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("resourcePermissionId", model.getResourcePermissionId());
		jsonObj.put("companyId", model.getCompanyId());
		jsonObj.put("name", model.getName());
		jsonObj.put("scope", model.getScope());
		jsonObj.put("primKey", model.getPrimKey());
		jsonObj.put("roleId", model.getRoleId());
		jsonObj.put("actionIds", model.getActionIds());

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.ResourcePermission[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ResourcePermission model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portal.model.ResourcePermission[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ResourcePermission[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portal.model.ResourcePermission> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ResourcePermission model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}