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

package com.liferay.portlet.documentlibrary.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DLFileRank service. Represents a row in the &quot;DLFileRank&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.documentlibrary.model.impl.DLFileRankModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.documentlibrary.model.impl.DLFileRankImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a d l file rank model instance should use the {@link DLFileRank} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileRank
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFileRankImpl
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFileRankModelImpl
 * @generated
 */
public interface DLFileRankModel extends BaseModel<DLFileRank> {
	/**
	 * Gets the primary key of this d l file rank.
	 *
	 * @return the primary key of this d l file rank
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this d l file rank
	 *
	 * @param pk the primary key of this d l file rank
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the file rank id of this d l file rank.
	 *
	 * @return the file rank id of this d l file rank
	 */
	public long getFileRankId();

	/**
	 * Sets the file rank id of this d l file rank.
	 *
	 * @param fileRankId the file rank id of this d l file rank
	 */
	public void setFileRankId(long fileRankId);

	/**
	 * Gets the group id of this d l file rank.
	 *
	 * @return the group id of this d l file rank
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this d l file rank.
	 *
	 * @param groupId the group id of this d l file rank
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this d l file rank.
	 *
	 * @return the company id of this d l file rank
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this d l file rank.
	 *
	 * @param companyId the company id of this d l file rank
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this d l file rank.
	 *
	 * @return the user id of this d l file rank
	 */
	public long getUserId();

	/**
	 * Sets the user id of this d l file rank.
	 *
	 * @param userId the user id of this d l file rank
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this d l file rank.
	 *
	 * @return the user uuid of this d l file rank
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this d l file rank.
	 *
	 * @param userUuid the user uuid of this d l file rank
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the create date of this d l file rank.
	 *
	 * @return the create date of this d l file rank
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this d l file rank.
	 *
	 * @param createDate the create date of this d l file rank
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the folder id of this d l file rank.
	 *
	 * @return the folder id of this d l file rank
	 */
	public long getFolderId();

	/**
	 * Sets the folder id of this d l file rank.
	 *
	 * @param folderId the folder id of this d l file rank
	 */
	public void setFolderId(long folderId);

	/**
	 * Gets the name of this d l file rank.
	 *
	 * @return the name of this d l file rank
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this d l file rank.
	 *
	 * @param name the name of this d l file rank
	 */
	public void setName(String name);

	/**
	 * Gets a copy of this d l file rank as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public DLFileRank toEscapedModel();

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

	public int compareTo(DLFileRank dlFileRank);

	public int hashCode();

	public String toString();

	public String toXmlString();
}