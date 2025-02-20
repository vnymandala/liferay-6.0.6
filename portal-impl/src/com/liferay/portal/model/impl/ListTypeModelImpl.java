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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ListTypeModel;
import com.liferay.portal.model.ListTypeSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the ListType service. Represents a row in the &quot;ListType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.ListTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ListTypeImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a list type model instance should use the {@link com.liferay.portal.model.ListType} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ListTypeImpl
 * @see com.liferay.portal.model.ListType
 * @see com.liferay.portal.model.ListTypeModel
 * @generated
 */
public class ListTypeModelImpl extends BaseModelImpl<ListType>
	implements ListTypeModel {
	public static final String TABLE_NAME = "ListType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "listTypeId", new Integer(Types.INTEGER) },
			{ "name", new Integer(Types.VARCHAR) },
			{ "type_", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table ListType (listTypeId INTEGER not null primary key,name VARCHAR(75) null,type_ VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ListType";
	public static final String ORDER_BY_JPQL = " ORDER BY listType.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ListType.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.ListType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.ListType"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ListType toModel(ListTypeSoap soapModel) {
		ListType model = new ListTypeImpl();

		model.setListTypeId(soapModel.getListTypeId());
		model.setName(soapModel.getName());
		model.setType(soapModel.getType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ListType> toModels(ListTypeSoap[] soapModels) {
		List<ListType> models = new ArrayList<ListType>(soapModels.length);

		for (ListTypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.ListType"));

	public ListTypeModelImpl() {
	}

	public int getPrimaryKey() {
		return _listTypeId;
	}

	public void setPrimaryKey(int pk) {
		setListTypeId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_listTypeId);
	}

	public int getListTypeId() {
		return _listTypeId;
	}

	public void setListTypeId(int listTypeId) {
		_listTypeId = listTypeId;
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	public void setType(String type) {
		_type = type;
	}

	public ListType toEscapedModel() {
		if (isEscapedModel()) {
			return (ListType)this;
		}
		else {
			return (ListType)Proxy.newProxyInstance(ListType.class.getClassLoader(),
				new Class[] { ListType.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ListTypeImpl listTypeImpl = new ListTypeImpl();

		listTypeImpl.setListTypeId(getListTypeId());

		listTypeImpl.setName(getName());

		listTypeImpl.setType(getType());

		return listTypeImpl;
	}

	public int compareTo(ListType listType) {
		int value = 0;

		value = getName().toLowerCase()
					.compareTo(listType.getName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ListType listType = null;

		try {
			listType = (ListType)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int pk = listType.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{listTypeId=");
		sb.append(getListTypeId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.ListType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>listTypeId</column-name><column-value><![CDATA[");
		sb.append(getListTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _listTypeId;
	private String _name;
	private String _type;
}