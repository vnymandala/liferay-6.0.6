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

package com.liferay.portlet.journal.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the JournalTemplate service. Represents a row in the &quot;JournalTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.journal.model.impl.JournalTemplateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.journal.model.impl.JournalTemplateImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a journal template model instance should use the {@link JournalTemplate} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalTemplate
 * @see com.liferay.portlet.journal.model.impl.JournalTemplateImpl
 * @see com.liferay.portlet.journal.model.impl.JournalTemplateModelImpl
 * @generated
 */
public interface JournalTemplateModel extends BaseModel<JournalTemplate> {
	/**
	 * Gets the primary key of this journal template.
	 *
	 * @return the primary key of this journal template
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this journal template
	 *
	 * @param pk the primary key of this journal template
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this journal template.
	 *
	 * @return the uuid of this journal template
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this journal template.
	 *
	 * @param uuid the uuid of this journal template
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the id of this journal template.
	 *
	 * @return the id of this journal template
	 */
	public long getId();

	/**
	 * Sets the id of this journal template.
	 *
	 * @param id the id of this journal template
	 */
	public void setId(long id);

	/**
	 * Gets the group id of this journal template.
	 *
	 * @return the group id of this journal template
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this journal template.
	 *
	 * @param groupId the group id of this journal template
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this journal template.
	 *
	 * @return the company id of this journal template
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this journal template.
	 *
	 * @param companyId the company id of this journal template
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this journal template.
	 *
	 * @return the user id of this journal template
	 */
	public long getUserId();

	/**
	 * Sets the user id of this journal template.
	 *
	 * @param userId the user id of this journal template
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this journal template.
	 *
	 * @return the user uuid of this journal template
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this journal template.
	 *
	 * @param userUuid the user uuid of this journal template
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this journal template.
	 *
	 * @return the user name of this journal template
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this journal template.
	 *
	 * @param userName the user name of this journal template
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this journal template.
	 *
	 * @return the create date of this journal template
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this journal template.
	 *
	 * @param createDate the create date of this journal template
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this journal template.
	 *
	 * @return the modified date of this journal template
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this journal template.
	 *
	 * @param modifiedDate the modified date of this journal template
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the template id of this journal template.
	 *
	 * @return the template id of this journal template
	 */
	public String getTemplateId();

	/**
	 * Sets the template id of this journal template.
	 *
	 * @param templateId the template id of this journal template
	 */
	public void setTemplateId(String templateId);

	/**
	 * Gets the structure id of this journal template.
	 *
	 * @return the structure id of this journal template
	 */
	public String getStructureId();

	/**
	 * Sets the structure id of this journal template.
	 *
	 * @param structureId the structure id of this journal template
	 */
	public void setStructureId(String structureId);

	/**
	 * Gets the name of this journal template.
	 *
	 * @return the name of this journal template
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this journal template.
	 *
	 * @param name the name of this journal template
	 */
	public void setName(String name);

	/**
	 * Gets the description of this journal template.
	 *
	 * @return the description of this journal template
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this journal template.
	 *
	 * @param description the description of this journal template
	 */
	public void setDescription(String description);

	/**
	 * Gets the xsl of this journal template.
	 *
	 * @return the xsl of this journal template
	 */
	@AutoEscape
	public String getXsl();

	/**
	 * Sets the xsl of this journal template.
	 *
	 * @param xsl the xsl of this journal template
	 */
	public void setXsl(String xsl);

	/**
	 * Gets the lang type of this journal template.
	 *
	 * @return the lang type of this journal template
	 */
	@AutoEscape
	public String getLangType();

	/**
	 * Sets the lang type of this journal template.
	 *
	 * @param langType the lang type of this journal template
	 */
	public void setLangType(String langType);

	/**
	 * Gets the cacheable of this journal template.
	 *
	 * @return the cacheable of this journal template
	 */
	public boolean getCacheable();

	/**
	 * Determines if this journal template is cacheable.
	 *
	 * @return <code>true</code> if this journal template is cacheable; <code>false</code> otherwise
	 */
	public boolean isCacheable();

	/**
	 * Sets whether this {$entity.humanName} is cacheable.
	 *
	 * @param cacheable the cacheable of this journal template
	 */
	public void setCacheable(boolean cacheable);

	/**
	 * Gets the small image of this journal template.
	 *
	 * @return the small image of this journal template
	 */
	public boolean getSmallImage();

	/**
	 * Determines if this journal template is small image.
	 *
	 * @return <code>true</code> if this journal template is small image; <code>false</code> otherwise
	 */
	public boolean isSmallImage();

	/**
	 * Sets whether this {$entity.humanName} is small image.
	 *
	 * @param smallImage the small image of this journal template
	 */
	public void setSmallImage(boolean smallImage);

	/**
	 * Gets the small image id of this journal template.
	 *
	 * @return the small image id of this journal template
	 */
	public long getSmallImageId();

	/**
	 * Sets the small image id of this journal template.
	 *
	 * @param smallImageId the small image id of this journal template
	 */
	public void setSmallImageId(long smallImageId);

	/**
	 * Gets the small image u r l of this journal template.
	 *
	 * @return the small image u r l of this journal template
	 */
	@AutoEscape
	public String getSmallImageURL();

	/**
	 * Sets the small image u r l of this journal template.
	 *
	 * @param smallImageURL the small image u r l of this journal template
	 */
	public void setSmallImageURL(String smallImageURL);

	/**
	 * Gets a copy of this journal template as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public JournalTemplate toEscapedModel();

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

	public int compareTo(JournalTemplate journalTemplate);

	public int hashCode();

	public String toString();

	public String toXmlString();
}