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

package com.liferay.portlet.announcements.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the AnnouncementsDelivery service. Represents a row in the &quot;AnnouncementsDelivery&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.announcements.model.impl.AnnouncementsDeliveryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.announcements.model.impl.AnnouncementsDeliveryImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a announcements delivery model instance should use the {@link AnnouncementsDelivery} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnnouncementsDelivery
 * @see com.liferay.portlet.announcements.model.impl.AnnouncementsDeliveryImpl
 * @see com.liferay.portlet.announcements.model.impl.AnnouncementsDeliveryModelImpl
 * @generated
 */
public interface AnnouncementsDeliveryModel extends BaseModel<AnnouncementsDelivery> {
	/**
	 * Gets the primary key of this announcements delivery.
	 *
	 * @return the primary key of this announcements delivery
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this announcements delivery
	 *
	 * @param pk the primary key of this announcements delivery
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the delivery id of this announcements delivery.
	 *
	 * @return the delivery id of this announcements delivery
	 */
	public long getDeliveryId();

	/**
	 * Sets the delivery id of this announcements delivery.
	 *
	 * @param deliveryId the delivery id of this announcements delivery
	 */
	public void setDeliveryId(long deliveryId);

	/**
	 * Gets the company id of this announcements delivery.
	 *
	 * @return the company id of this announcements delivery
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this announcements delivery.
	 *
	 * @param companyId the company id of this announcements delivery
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this announcements delivery.
	 *
	 * @return the user id of this announcements delivery
	 */
	public long getUserId();

	/**
	 * Sets the user id of this announcements delivery.
	 *
	 * @param userId the user id of this announcements delivery
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this announcements delivery.
	 *
	 * @return the user uuid of this announcements delivery
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this announcements delivery.
	 *
	 * @param userUuid the user uuid of this announcements delivery
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the type of this announcements delivery.
	 *
	 * @return the type of this announcements delivery
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this announcements delivery.
	 *
	 * @param type the type of this announcements delivery
	 */
	public void setType(String type);

	/**
	 * Gets the email of this announcements delivery.
	 *
	 * @return the email of this announcements delivery
	 */
	public boolean getEmail();

	/**
	 * Determines if this announcements delivery is email.
	 *
	 * @return <code>true</code> if this announcements delivery is email; <code>false</code> otherwise
	 */
	public boolean isEmail();

	/**
	 * Sets whether this {$entity.humanName} is email.
	 *
	 * @param email the email of this announcements delivery
	 */
	public void setEmail(boolean email);

	/**
	 * Gets the sms of this announcements delivery.
	 *
	 * @return the sms of this announcements delivery
	 */
	public boolean getSms();

	/**
	 * Determines if this announcements delivery is sms.
	 *
	 * @return <code>true</code> if this announcements delivery is sms; <code>false</code> otherwise
	 */
	public boolean isSms();

	/**
	 * Sets whether this {$entity.humanName} is sms.
	 *
	 * @param sms the sms of this announcements delivery
	 */
	public void setSms(boolean sms);

	/**
	 * Gets the website of this announcements delivery.
	 *
	 * @return the website of this announcements delivery
	 */
	public boolean getWebsite();

	/**
	 * Determines if this announcements delivery is website.
	 *
	 * @return <code>true</code> if this announcements delivery is website; <code>false</code> otherwise
	 */
	public boolean isWebsite();

	/**
	 * Sets whether this {$entity.humanName} is website.
	 *
	 * @param website the website of this announcements delivery
	 */
	public void setWebsite(boolean website);

	/**
	 * Gets a copy of this announcements delivery as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public AnnouncementsDelivery toEscapedModel();

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

	public int compareTo(AnnouncementsDelivery announcementsDelivery);

	public int hashCode();

	public String toString();

	public String toXmlString();
}