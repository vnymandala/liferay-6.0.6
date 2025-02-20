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

package com.liferay.portal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portal.service.http.UserGroupServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.service.http.UserGroupServiceSoap
 * @generated
 */
public class UserGroupSoap implements Serializable {
	public static UserGroupSoap toSoapModel(UserGroup model) {
		UserGroupSoap soapModel = new UserGroupSoap();

		soapModel.setUserGroupId(model.getUserGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setParentUserGroupId(model.getParentUserGroupId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static UserGroupSoap[] toSoapModels(UserGroup[] models) {
		UserGroupSoap[] soapModels = new UserGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserGroupSoap[][] toSoapModels(UserGroup[][] models) {
		UserGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserGroupSoap[] toSoapModels(List<UserGroup> models) {
		List<UserGroupSoap> soapModels = new ArrayList<UserGroupSoap>(models.size());

		for (UserGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserGroupSoap[soapModels.size()]);
	}

	public UserGroupSoap() {
	}

	public long getPrimaryKey() {
		return _userGroupId;
	}

	public void setPrimaryKey(long pk) {
		setUserGroupId(pk);
	}

	public long getUserGroupId() {
		return _userGroupId;
	}

	public void setUserGroupId(long userGroupId) {
		_userGroupId = userGroupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getParentUserGroupId() {
		return _parentUserGroupId;
	}

	public void setParentUserGroupId(long parentUserGroupId) {
		_parentUserGroupId = parentUserGroupId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _userGroupId;
	private long _companyId;
	private long _parentUserGroupId;
	private String _name;
	private String _description;
}