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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Ticket service. Represents a row in the &quot;Ticket&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.TicketModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.TicketImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a ticket model instance should use the {@link Ticket} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ticket
 * @see com.liferay.portal.model.impl.TicketImpl
 * @see com.liferay.portal.model.impl.TicketModelImpl
 * @generated
 */
public interface TicketModel extends BaseModel<Ticket> {
	/**
	 * Gets the primary key of this ticket.
	 *
	 * @return the primary key of this ticket
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ticket
	 *
	 * @param pk the primary key of this ticket
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the ticket id of this ticket.
	 *
	 * @return the ticket id of this ticket
	 */
	public long getTicketId();

	/**
	 * Sets the ticket id of this ticket.
	 *
	 * @param ticketId the ticket id of this ticket
	 */
	public void setTicketId(long ticketId);

	/**
	 * Gets the company id of this ticket.
	 *
	 * @return the company id of this ticket
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this ticket.
	 *
	 * @param companyId the company id of this ticket
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the create date of this ticket.
	 *
	 * @return the create date of this ticket
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this ticket.
	 *
	 * @param createDate the create date of this ticket
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the class name of the model instance this ticket is polymorphically associated with.
	 *
	 * @return the class name of the model instance this ticket is polymorphically associated with
	 */
	public String getClassName();

	/**
	 * Gets the class name id of this ticket.
	 *
	 * @return the class name id of this ticket
	 */
	public long getClassNameId();

	/**
	 * Sets the class name id of this ticket.
	 *
	 * @param classNameId the class name id of this ticket
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Gets the class p k of this ticket.
	 *
	 * @return the class p k of this ticket
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this ticket.
	 *
	 * @param classPK the class p k of this ticket
	 */
	public void setClassPK(long classPK);

	/**
	 * Gets the key of this ticket.
	 *
	 * @return the key of this ticket
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this ticket.
	 *
	 * @param key the key of this ticket
	 */
	public void setKey(String key);

	/**
	 * Gets the expiration date of this ticket.
	 *
	 * @return the expiration date of this ticket
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this ticket.
	 *
	 * @param expirationDate the expiration date of this ticket
	 */
	public void setExpirationDate(Date expirationDate);

	/**
	 * Gets a copy of this ticket as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Ticket toEscapedModel();

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

	public int compareTo(Ticket ticket);

	public int hashCode();

	public String toString();

	public String toXmlString();
}