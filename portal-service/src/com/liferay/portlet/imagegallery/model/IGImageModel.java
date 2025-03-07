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

package com.liferay.portlet.imagegallery.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the IGImage service. Represents a row in the &quot;IGImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.imagegallery.model.impl.IGImageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.imagegallery.model.impl.IGImageImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a i g image model instance should use the {@link IGImage} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IGImage
 * @see com.liferay.portlet.imagegallery.model.impl.IGImageImpl
 * @see com.liferay.portlet.imagegallery.model.impl.IGImageModelImpl
 * @generated
 */
public interface IGImageModel extends BaseModel<IGImage> {
	/**
	 * Gets the primary key of this i g image.
	 *
	 * @return the primary key of this i g image
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this i g image
	 *
	 * @param pk the primary key of this i g image
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this i g image.
	 *
	 * @return the uuid of this i g image
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this i g image.
	 *
	 * @param uuid the uuid of this i g image
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the image id of this i g image.
	 *
	 * @return the image id of this i g image
	 */
	public long getImageId();

	/**
	 * Sets the image id of this i g image.
	 *
	 * @param imageId the image id of this i g image
	 */
	public void setImageId(long imageId);

	/**
	 * Gets the group id of this i g image.
	 *
	 * @return the group id of this i g image
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this i g image.
	 *
	 * @param groupId the group id of this i g image
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this i g image.
	 *
	 * @return the company id of this i g image
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this i g image.
	 *
	 * @param companyId the company id of this i g image
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this i g image.
	 *
	 * @return the user id of this i g image
	 */
	public long getUserId();

	/**
	 * Sets the user id of this i g image.
	 *
	 * @param userId the user id of this i g image
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this i g image.
	 *
	 * @return the user uuid of this i g image
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this i g image.
	 *
	 * @param userUuid the user uuid of this i g image
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the create date of this i g image.
	 *
	 * @return the create date of this i g image
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this i g image.
	 *
	 * @param createDate the create date of this i g image
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this i g image.
	 *
	 * @return the modified date of this i g image
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this i g image.
	 *
	 * @param modifiedDate the modified date of this i g image
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the folder id of this i g image.
	 *
	 * @return the folder id of this i g image
	 */
	public long getFolderId();

	/**
	 * Sets the folder id of this i g image.
	 *
	 * @param folderId the folder id of this i g image
	 */
	public void setFolderId(long folderId);

	/**
	 * Gets the name of this i g image.
	 *
	 * @return the name of this i g image
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this i g image.
	 *
	 * @param name the name of this i g image
	 */
	public void setName(String name);

	/**
	 * Gets the description of this i g image.
	 *
	 * @return the description of this i g image
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this i g image.
	 *
	 * @param description the description of this i g image
	 */
	public void setDescription(String description);

	/**
	 * Gets the small image id of this i g image.
	 *
	 * @return the small image id of this i g image
	 */
	public long getSmallImageId();

	/**
	 * Sets the small image id of this i g image.
	 *
	 * @param smallImageId the small image id of this i g image
	 */
	public void setSmallImageId(long smallImageId);

	/**
	 * Gets the large image id of this i g image.
	 *
	 * @return the large image id of this i g image
	 */
	public long getLargeImageId();

	/**
	 * Sets the large image id of this i g image.
	 *
	 * @param largeImageId the large image id of this i g image
	 */
	public void setLargeImageId(long largeImageId);

	/**
	 * Gets the custom1 image id of this i g image.
	 *
	 * @return the custom1 image id of this i g image
	 */
	public long getCustom1ImageId();

	/**
	 * Sets the custom1 image id of this i g image.
	 *
	 * @param custom1ImageId the custom1 image id of this i g image
	 */
	public void setCustom1ImageId(long custom1ImageId);

	/**
	 * Gets the custom2 image id of this i g image.
	 *
	 * @return the custom2 image id of this i g image
	 */
	public long getCustom2ImageId();

	/**
	 * Sets the custom2 image id of this i g image.
	 *
	 * @param custom2ImageId the custom2 image id of this i g image
	 */
	public void setCustom2ImageId(long custom2ImageId);

	/**
	 * Gets a copy of this i g image as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public IGImage toEscapedModel();

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

	public int compareTo(IGImage igImage);

	public int hashCode();

	public String toString();

	public String toXmlString();
}