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

package com.liferay.portlet.asset.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AssetTagProperty service. Represents a row in the &quot;AssetTagProperty&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.asset.model.impl.AssetTagPropertyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.asset.model.impl.AssetTagPropertyImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a asset tag property model instance should use the {@link AssetTagProperty} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTagProperty
 * @see com.liferay.portlet.asset.model.impl.AssetTagPropertyImpl
 * @see com.liferay.portlet.asset.model.impl.AssetTagPropertyModelImpl
 * @generated
 */
public interface AssetTagPropertyModel extends BaseModel<AssetTagProperty> {
	/**
	 * Gets the primary key of this asset tag property.
	 *
	 * @return the primary key of this asset tag property
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this asset tag property
	 *
	 * @param pk the primary key of this asset tag property
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the tag property id of this asset tag property.
	 *
	 * @return the tag property id of this asset tag property
	 */
	public long getTagPropertyId();

	/**
	 * Sets the tag property id of this asset tag property.
	 *
	 * @param tagPropertyId the tag property id of this asset tag property
	 */
	public void setTagPropertyId(long tagPropertyId);

	/**
	 * Gets the company id of this asset tag property.
	 *
	 * @return the company id of this asset tag property
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this asset tag property.
	 *
	 * @param companyId the company id of this asset tag property
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this asset tag property.
	 *
	 * @return the user id of this asset tag property
	 */
	public long getUserId();

	/**
	 * Sets the user id of this asset tag property.
	 *
	 * @param userId the user id of this asset tag property
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this asset tag property.
	 *
	 * @return the user uuid of this asset tag property
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this asset tag property.
	 *
	 * @param userUuid the user uuid of this asset tag property
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this asset tag property.
	 *
	 * @return the user name of this asset tag property
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this asset tag property.
	 *
	 * @param userName the user name of this asset tag property
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this asset tag property.
	 *
	 * @return the create date of this asset tag property
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this asset tag property.
	 *
	 * @param createDate the create date of this asset tag property
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this asset tag property.
	 *
	 * @return the modified date of this asset tag property
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this asset tag property.
	 *
	 * @param modifiedDate the modified date of this asset tag property
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the tag id of this asset tag property.
	 *
	 * @return the tag id of this asset tag property
	 */
	public long getTagId();

	/**
	 * Sets the tag id of this asset tag property.
	 *
	 * @param tagId the tag id of this asset tag property
	 */
	public void setTagId(long tagId);

	/**
	 * Gets the key of this asset tag property.
	 *
	 * @return the key of this asset tag property
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this asset tag property.
	 *
	 * @param key the key of this asset tag property
	 */
	public void setKey(String key);

	/**
	 * Gets the value of this asset tag property.
	 *
	 * @return the value of this asset tag property
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this asset tag property.
	 *
	 * @param value the value of this asset tag property
	 */
	public void setValue(String value);

	/**
	 * Gets a copy of this asset tag property as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public AssetTagProperty toEscapedModel();

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

	public int compareTo(AssetTagProperty assetTagProperty);

	public int hashCode();

	public String toString();

	public String toXmlString();
}