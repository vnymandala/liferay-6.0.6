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

package com.liferay.portlet.social.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.social.model.SocialEquityGroupSetting;
import com.liferay.portlet.social.model.SocialEquityGroupSettingModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the SocialEquityGroupSetting service. Represents a row in the &quot;SocialEquityGroupSetting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.social.model.SocialEquityGroupSettingModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SocialEquityGroupSettingImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a social equity group setting model instance should use the {@link com.liferay.portlet.social.model.SocialEquityGroupSetting} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialEquityGroupSettingImpl
 * @see com.liferay.portlet.social.model.SocialEquityGroupSetting
 * @see com.liferay.portlet.social.model.SocialEquityGroupSettingModel
 * @generated
 */
public class SocialEquityGroupSettingModelImpl extends BaseModelImpl<SocialEquityGroupSetting>
	implements SocialEquityGroupSettingModel {
	public static final String TABLE_NAME = "SocialEquityGroupSetting";
	public static final Object[][] TABLE_COLUMNS = {
			{ "equityGroupSettingId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "classNameId", new Integer(Types.BIGINT) },
			{ "type_", new Integer(Types.INTEGER) },
			{ "enabled", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table SocialEquityGroupSetting (equityGroupSettingId LONG not null primary key,groupId LONG,companyId LONG,classNameId LONG,type_ INTEGER,enabled BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table SocialEquityGroupSetting";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.social.model.SocialEquityGroupSetting"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.social.model.SocialEquityGroupSetting"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.social.model.SocialEquityGroupSetting"));

	public SocialEquityGroupSettingModelImpl() {
	}

	public long getPrimaryKey() {
		return _equityGroupSettingId;
	}

	public void setPrimaryKey(long pk) {
		setEquityGroupSettingId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_equityGroupSettingId);
	}

	public long getEquityGroupSettingId() {
		return _equityGroupSettingId;
	}

	public void setEquityGroupSettingId(long equityGroupSettingId) {
		_equityGroupSettingId = equityGroupSettingId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = _type;
		}

		_type = type;
	}

	public int getOriginalType() {
		return _originalType;
	}

	public boolean getEnabled() {
		return _enabled;
	}

	public boolean isEnabled() {
		return _enabled;
	}

	public void setEnabled(boolean enabled) {
		_enabled = enabled;
	}

	public SocialEquityGroupSetting toEscapedModel() {
		if (isEscapedModel()) {
			return (SocialEquityGroupSetting)this;
		}
		else {
			return (SocialEquityGroupSetting)Proxy.newProxyInstance(SocialEquityGroupSetting.class.getClassLoader(),
				new Class[] { SocialEquityGroupSetting.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					SocialEquityGroupSetting.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		SocialEquityGroupSettingImpl socialEquityGroupSettingImpl = new SocialEquityGroupSettingImpl();

		socialEquityGroupSettingImpl.setEquityGroupSettingId(getEquityGroupSettingId());

		socialEquityGroupSettingImpl.setGroupId(getGroupId());

		SocialEquityGroupSettingModelImpl socialEquityGroupSettingModelImpl = socialEquityGroupSettingImpl;

		socialEquityGroupSettingModelImpl._originalGroupId = socialEquityGroupSettingModelImpl._groupId;

		socialEquityGroupSettingModelImpl._setOriginalGroupId = false;
		socialEquityGroupSettingImpl.setCompanyId(getCompanyId());

		socialEquityGroupSettingImpl.setClassNameId(getClassNameId());

		socialEquityGroupSettingModelImpl._originalClassNameId = socialEquityGroupSettingModelImpl._classNameId;

		socialEquityGroupSettingModelImpl._setOriginalClassNameId = false;
		socialEquityGroupSettingImpl.setType(getType());

		socialEquityGroupSettingModelImpl._originalType = socialEquityGroupSettingModelImpl._type;

		socialEquityGroupSettingModelImpl._setOriginalType = false;
		socialEquityGroupSettingImpl.setEnabled(getEnabled());

		return socialEquityGroupSettingImpl;
	}

	public int compareTo(SocialEquityGroupSetting socialEquityGroupSetting) {
		long pk = socialEquityGroupSetting.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SocialEquityGroupSetting socialEquityGroupSetting = null;

		try {
			socialEquityGroupSetting = (SocialEquityGroupSetting)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = socialEquityGroupSetting.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{equityGroupSettingId=");
		sb.append(getEquityGroupSettingId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", enabled=");
		sb.append(getEnabled());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.social.model.SocialEquityGroupSetting");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>equityGroupSettingId</column-name><column-value><![CDATA[");
		sb.append(getEquityGroupSettingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enabled</column-name><column-value><![CDATA[");
		sb.append(getEnabled());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _equityGroupSettingId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private int _type;
	private int _originalType;
	private boolean _setOriginalType;
	private boolean _enabled;
	private transient ExpandoBridge _expandoBridge;
}