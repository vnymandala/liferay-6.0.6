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

package com.liferay.portlet.ratings.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.ratings.model.RatingsStats;
import com.liferay.portlet.ratings.model.RatingsStatsModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the RatingsStats service. Represents a row in the &quot;RatingsStats&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.ratings.model.RatingsStatsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RatingsStatsImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a ratings stats model instance should use the {@link com.liferay.portlet.ratings.model.RatingsStats} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RatingsStatsImpl
 * @see com.liferay.portlet.ratings.model.RatingsStats
 * @see com.liferay.portlet.ratings.model.RatingsStatsModel
 * @generated
 */
public class RatingsStatsModelImpl extends BaseModelImpl<RatingsStats>
	implements RatingsStatsModel {
	public static final String TABLE_NAME = "RatingsStats";
	public static final Object[][] TABLE_COLUMNS = {
			{ "statsId", new Integer(Types.BIGINT) },
			{ "classNameId", new Integer(Types.BIGINT) },
			{ "classPK", new Integer(Types.BIGINT) },
			{ "totalEntries", new Integer(Types.INTEGER) },
			{ "totalScore", new Integer(Types.DOUBLE) },
			{ "averageScore", new Integer(Types.DOUBLE) }
		};
	public static final String TABLE_SQL_CREATE = "create table RatingsStats (statsId LONG not null primary key,classNameId LONG,classPK LONG,totalEntries INTEGER,totalScore DOUBLE,averageScore DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table RatingsStats";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.ratings.model.RatingsStats"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.ratings.model.RatingsStats"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.ratings.model.RatingsStats"));

	public RatingsStatsModelImpl() {
	}

	public long getPrimaryKey() {
		return _statsId;
	}

	public void setPrimaryKey(long pk) {
		setStatsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_statsId);
	}

	public long getStatsId() {
		return _statsId;
	}

	public void setStatsId(long statsId) {
		_statsId = statsId;
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

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	public int getTotalEntries() {
		return _totalEntries;
	}

	public void setTotalEntries(int totalEntries) {
		_totalEntries = totalEntries;
	}

	public double getTotalScore() {
		return _totalScore;
	}

	public void setTotalScore(double totalScore) {
		_totalScore = totalScore;
	}

	public double getAverageScore() {
		return _averageScore;
	}

	public void setAverageScore(double averageScore) {
		_averageScore = averageScore;
	}

	public RatingsStats toEscapedModel() {
		if (isEscapedModel()) {
			return (RatingsStats)this;
		}
		else {
			return (RatingsStats)Proxy.newProxyInstance(RatingsStats.class.getClassLoader(),
				new Class[] { RatingsStats.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					RatingsStats.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		RatingsStatsImpl ratingsStatsImpl = new RatingsStatsImpl();

		ratingsStatsImpl.setStatsId(getStatsId());

		ratingsStatsImpl.setClassNameId(getClassNameId());

		RatingsStatsModelImpl ratingsStatsModelImpl = ratingsStatsImpl;

		ratingsStatsModelImpl._originalClassNameId = ratingsStatsModelImpl._classNameId;

		ratingsStatsModelImpl._setOriginalClassNameId = false;
		ratingsStatsImpl.setClassPK(getClassPK());

		ratingsStatsModelImpl._originalClassPK = ratingsStatsModelImpl._classPK;

		ratingsStatsModelImpl._setOriginalClassPK = false;
		ratingsStatsImpl.setTotalEntries(getTotalEntries());

		ratingsStatsImpl.setTotalScore(getTotalScore());

		ratingsStatsImpl.setAverageScore(getAverageScore());

		return ratingsStatsImpl;
	}

	public int compareTo(RatingsStats ratingsStats) {
		long pk = ratingsStats.getPrimaryKey();

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

		RatingsStats ratingsStats = null;

		try {
			ratingsStats = (RatingsStats)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = ratingsStats.getPrimaryKey();

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

		sb.append("{statsId=");
		sb.append(getStatsId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", totalEntries=");
		sb.append(getTotalEntries());
		sb.append(", totalScore=");
		sb.append(getTotalScore());
		sb.append(", averageScore=");
		sb.append(getAverageScore());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.ratings.model.RatingsStats");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>statsId</column-name><column-value><![CDATA[");
		sb.append(getStatsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalEntries</column-name><column-value><![CDATA[");
		sb.append(getTotalEntries());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalScore</column-name><column-value><![CDATA[");
		sb.append(getTotalScore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>averageScore</column-name><column-value><![CDATA[");
		sb.append(getAverageScore());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _statsId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private int _totalEntries;
	private double _totalScore;
	private double _averageScore;
	private transient ExpandoBridge _expandoBridge;
}