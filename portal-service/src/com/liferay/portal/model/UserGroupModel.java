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
 * The base model interface for the UserGroup service. Represents a row in the &quot;UserGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.UserGroupModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.UserGroupImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a user group model instance should use the {@link UserGroup} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroup
 * @see com.liferay.portal.model.impl.UserGroupImpl
 * @see com.liferay.portal.model.impl.UserGroupModelImpl
 * @generated
 */
public interface UserGroupModel extends BaseModel<UserGroup> {
	/**
	 * Gets the primary key of this user group.
	 *
	 * @return the primary key of this user group
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user group
	 *
	 * @param pk the primary key of this user group
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the user group id of this user group.
	 *
	 * @return the user group id of this user group
	 */
	public long getUserGroupId();

	/**
	 * Sets the user group id of this user group.
	 *
	 * @param userGroupId the user group id of this user group
	 */
	public void setUserGroupId(long userGroupId);

	/**
	 * Gets the company id of this user group.
	 *
	 * @return the company id of this user group
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this user group.
	 *
	 * @param companyId the company id of this user group
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the parent user group id of this user group.
	 *
	 * @return the parent user group id of this user group
	 */
	public long getParentUserGroupId();

	/**
	 * Sets the parent user group id of this user group.
	 *
	 * @param parentUserGroupId the parent user group id of this user group
	 */
	public void setParentUserGroupId(long parentUserGroupId);

	/**
	 * Gets the name of this user group.
	 *
	 * @return the name of this user group
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this user group.
	 *
	 * @param name the name of this user group
	 */
	public void setName(String name);

	/**
	 * Gets the description of this user group.
	 *
	 * @return the description of this user group
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this user group.
	 *
	 * @param description the description of this user group
	 */
	public void setDescription(String description);

	/**
	 * Gets a copy of this user group as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public UserGroup toEscapedModel();

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

	public int compareTo(UserGroup userGroup);

	public int hashCode();

	public String toString();

	public String toXmlString();
}