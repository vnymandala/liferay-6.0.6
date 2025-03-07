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
 * The base model interface for the DLFileVersion service. Represents a row in the &quot;DLFileVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.documentlibrary.model.impl.DLFileVersionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.documentlibrary.model.impl.DLFileVersionImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a d l file version model instance should use the {@link DLFileVersion} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileVersion
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFileVersionImpl
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFileVersionModelImpl
 * @generated
 */
public interface DLFileVersionModel extends BaseModel<DLFileVersion> {
	/**
	 * Gets the primary key of this d l file version.
	 *
	 * @return the primary key of this d l file version
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this d l file version
	 *
	 * @param pk the primary key of this d l file version
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the file version id of this d l file version.
	 *
	 * @return the file version id of this d l file version
	 */
	public long getFileVersionId();

	/**
	 * Sets the file version id of this d l file version.
	 *
	 * @param fileVersionId the file version id of this d l file version
	 */
	public void setFileVersionId(long fileVersionId);

	/**
	 * Gets the group id of this d l file version.
	 *
	 * @return the group id of this d l file version
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this d l file version.
	 *
	 * @param groupId the group id of this d l file version
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this d l file version.
	 *
	 * @return the company id of this d l file version
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this d l file version.
	 *
	 * @param companyId the company id of this d l file version
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this d l file version.
	 *
	 * @return the user id of this d l file version
	 */
	public long getUserId();

	/**
	 * Sets the user id of this d l file version.
	 *
	 * @param userId the user id of this d l file version
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this d l file version.
	 *
	 * @return the user uuid of this d l file version
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this d l file version.
	 *
	 * @param userUuid the user uuid of this d l file version
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this d l file version.
	 *
	 * @return the user name of this d l file version
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this d l file version.
	 *
	 * @param userName the user name of this d l file version
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this d l file version.
	 *
	 * @return the create date of this d l file version
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this d l file version.
	 *
	 * @param createDate the create date of this d l file version
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the folder id of this d l file version.
	 *
	 * @return the folder id of this d l file version
	 */
	public long getFolderId();

	/**
	 * Sets the folder id of this d l file version.
	 *
	 * @param folderId the folder id of this d l file version
	 */
	public void setFolderId(long folderId);

	/**
	 * Gets the name of this d l file version.
	 *
	 * @return the name of this d l file version
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this d l file version.
	 *
	 * @param name the name of this d l file version
	 */
	public void setName(String name);

	/**
	 * Gets the extension of this d l file version.
	 *
	 * @return the extension of this d l file version
	 */
	@AutoEscape
	public String getExtension();

	/**
	 * Sets the extension of this d l file version.
	 *
	 * @param extension the extension of this d l file version
	 */
	public void setExtension(String extension);

	/**
	 * Gets the title of this d l file version.
	 *
	 * @return the title of this d l file version
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this d l file version.
	 *
	 * @param title the title of this d l file version
	 */
	public void setTitle(String title);

	/**
	 * Gets the description of this d l file version.
	 *
	 * @return the description of this d l file version
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this d l file version.
	 *
	 * @param description the description of this d l file version
	 */
	public void setDescription(String description);

	/**
	 * Gets the change log of this d l file version.
	 *
	 * @return the change log of this d l file version
	 */
	@AutoEscape
	public String getChangeLog();

	/**
	 * Sets the change log of this d l file version.
	 *
	 * @param changeLog the change log of this d l file version
	 */
	public void setChangeLog(String changeLog);

	/**
	 * Gets the extra settings of this d l file version.
	 *
	 * @return the extra settings of this d l file version
	 */
	@AutoEscape
	public String getExtraSettings();

	/**
	 * Sets the extra settings of this d l file version.
	 *
	 * @param extraSettings the extra settings of this d l file version
	 */
	public void setExtraSettings(String extraSettings);

	/**
	 * Gets the version of this d l file version.
	 *
	 * @return the version of this d l file version
	 */
	@AutoEscape
	public String getVersion();

	/**
	 * Sets the version of this d l file version.
	 *
	 * @param version the version of this d l file version
	 */
	public void setVersion(String version);

	/**
	 * Gets the size of this d l file version.
	 *
	 * @return the size of this d l file version
	 */
	public long getSize();

	/**
	 * Sets the size of this d l file version.
	 *
	 * @param size the size of this d l file version
	 */
	public void setSize(long size);

	/**
	 * Gets the status of this d l file version.
	 *
	 * @return the status of this d l file version
	 */
	public int getStatus();

	/**
	 * Sets the status of this d l file version.
	 *
	 * @param status the status of this d l file version
	 */
	public void setStatus(int status);

	/**
	 * Gets the status by user id of this d l file version.
	 *
	 * @return the status by user id of this d l file version
	 */
	public long getStatusByUserId();

	/**
	 * Sets the status by user id of this d l file version.
	 *
	 * @param statusByUserId the status by user id of this d l file version
	 */
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Gets the status by user uuid of this d l file version.
	 *
	 * @return the status by user uuid of this d l file version
	 * @throws SystemException if a system exception occurred
	 */
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this d l file version.
	 *
	 * @param statusByUserUuid the status by user uuid of this d l file version
	 */
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Gets the status by user name of this d l file version.
	 *
	 * @return the status by user name of this d l file version
	 */
	@AutoEscape
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this d l file version.
	 *
	 * @param statusByUserName the status by user name of this d l file version
	 */
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Gets the status date of this d l file version.
	 *
	 * @return the status date of this d l file version
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this d l file version.
	 *
	 * @param statusDate the status date of this d l file version
	 */
	public void setStatusDate(Date statusDate);

	/**
	 * Determines if this d l file version is approved.
	 *
	 * @return <code>true</code> if this d l file version is approved; <code>false</code> otherwise
	 */
	public boolean isApproved();

	/**
	 * Determines if this d l file version is a draft.
	 *
	 * @return <code>true</code> if this d l file version is a draft; <code>false</code> otherwise
	 */
	public boolean isDraft();

	/**
	 * Determines if this d l file version is expired.
	 *
	 * @return <code>true</code> if this d l file version is expired; <code>false</code> otherwise
	 */
	public boolean isExpired();

	/**
	 * Determines if this d l file version is pending.
	 *
	 * @return <code>true</code> if this d l file version is pending; <code>false</code> otherwise
	 */
	public boolean isPending();

	/**
	 * Gets a copy of this d l file version as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public DLFileVersion toEscapedModel();

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

	public int compareTo(DLFileVersion dlFileVersion);

	public int hashCode();

	public String toString();

	public String toXmlString();
}