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

package com.liferay.portlet.social.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SocialEquityHistory service. Represents a row in the &quot;SocialEquityHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.social.model.impl.SocialEquityHistoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.social.model.impl.SocialEquityHistoryImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a social equity history model instance should use the {@link SocialEquityHistory} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialEquityHistory
 * @see com.liferay.portlet.social.model.impl.SocialEquityHistoryImpl
 * @see com.liferay.portlet.social.model.impl.SocialEquityHistoryModelImpl
 * @generated
 */
public interface SocialEquityHistoryModel extends BaseModel<SocialEquityHistory> {
	/**
	 * Gets the primary key of this social equity history.
	 *
	 * @return the primary key of this social equity history
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this social equity history
	 *
	 * @param pk the primary key of this social equity history
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the equity history id of this social equity history.
	 *
	 * @return the equity history id of this social equity history
	 */
	public long getEquityHistoryId();

	/**
	 * Sets the equity history id of this social equity history.
	 *
	 * @param equityHistoryId the equity history id of this social equity history
	 */
	public void setEquityHistoryId(long equityHistoryId);

	/**
	 * Gets the group id of this social equity history.
	 *
	 * @return the group id of this social equity history
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this social equity history.
	 *
	 * @param groupId the group id of this social equity history
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this social equity history.
	 *
	 * @return the company id of this social equity history
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this social equity history.
	 *
	 * @param companyId the company id of this social equity history
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this social equity history.
	 *
	 * @return the user id of this social equity history
	 */
	public long getUserId();

	/**
	 * Sets the user id of this social equity history.
	 *
	 * @param userId the user id of this social equity history
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this social equity history.
	 *
	 * @return the user uuid of this social equity history
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this social equity history.
	 *
	 * @param userUuid the user uuid of this social equity history
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the create date of this social equity history.
	 *
	 * @return the create date of this social equity history
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this social equity history.
	 *
	 * @param createDate the create date of this social equity history
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the personal equity of this social equity history.
	 *
	 * @return the personal equity of this social equity history
	 */
	public int getPersonalEquity();

	/**
	 * Sets the personal equity of this social equity history.
	 *
	 * @param personalEquity the personal equity of this social equity history
	 */
	public void setPersonalEquity(int personalEquity);

	/**
	 * Gets a copy of this social equity history as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public SocialEquityHistory toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(SocialEquityHistory socialEquityHistory);

	public int hashCode();

	public String toString();

	public String toXmlString();
}