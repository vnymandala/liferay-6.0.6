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

/**
 * The base model interface for the ResourceAction service. Represents a row in the &quot;ResourceAction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.ResourceActionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.ResourceActionImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a resource action model instance should use the {@link ResourceAction} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceAction
 * @see com.liferay.portal.model.impl.ResourceActionImpl
 * @see com.liferay.portal.model.impl.ResourceActionModelImpl
 * @generated
 */
public interface ResourceActionModel extends BaseModel<ResourceAction> {
	/**
	 * Gets the primary key of this resource action.
	 *
	 * @return the primary key of this resource action
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this resource action
	 *
	 * @param pk the primary key of this resource action
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the resource action id of this resource action.
	 *
	 * @return the resource action id of this resource action
	 */
	public long getResourceActionId();

	/**
	 * Sets the resource action id of this resource action.
	 *
	 * @param resourceActionId the resource action id of this resource action
	 */
	public void setResourceActionId(long resourceActionId);

	/**
	 * Gets the name of this resource action.
	 *
	 * @return the name of this resource action
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this resource action.
	 *
	 * @param name the name of this resource action
	 */
	public void setName(String name);

	/**
	 * Gets the action id of this resource action.
	 *
	 * @return the action id of this resource action
	 */
	@AutoEscape
	public String getActionId();

	/**
	 * Sets the action id of this resource action.
	 *
	 * @param actionId the action id of this resource action
	 */
	public void setActionId(String actionId);

	/**
	 * Gets the bitwise value of this resource action.
	 *
	 * @return the bitwise value of this resource action
	 */
	public long getBitwiseValue();

	/**
	 * Sets the bitwise value of this resource action.
	 *
	 * @param bitwiseValue the bitwise value of this resource action
	 */
	public void setBitwiseValue(long bitwiseValue);

	/**
	 * Gets a copy of this resource action as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public ResourceAction toEscapedModel();

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

	public int compareTo(ResourceAction resourceAction);

	public int hashCode();

	public String toString();

	public String toXmlString();
}