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
 * The base model interface for the LayoutSet service. Represents a row in the &quot;LayoutSet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.LayoutSetModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.LayoutSetImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a layout set model instance should use the {@link LayoutSet} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSet
 * @see com.liferay.portal.model.impl.LayoutSetImpl
 * @see com.liferay.portal.model.impl.LayoutSetModelImpl
 * @generated
 */
public interface LayoutSetModel extends BaseModel<LayoutSet> {
	/**
	 * Gets the primary key of this layout set.
	 *
	 * @return the primary key of this layout set
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this layout set
	 *
	 * @param pk the primary key of this layout set
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the layout set id of this layout set.
	 *
	 * @return the layout set id of this layout set
	 */
	public long getLayoutSetId();

	/**
	 * Sets the layout set id of this layout set.
	 *
	 * @param layoutSetId the layout set id of this layout set
	 */
	public void setLayoutSetId(long layoutSetId);

	/**
	 * Gets the group id of this layout set.
	 *
	 * @return the group id of this layout set
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this layout set.
	 *
	 * @param groupId the group id of this layout set
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this layout set.
	 *
	 * @return the company id of this layout set
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this layout set.
	 *
	 * @param companyId the company id of this layout set
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the private layout of this layout set.
	 *
	 * @return the private layout of this layout set
	 */
	public boolean getPrivateLayout();

	/**
	 * Determines if this layout set is private layout.
	 *
	 * @return <code>true</code> if this layout set is private layout; <code>false</code> otherwise
	 */
	public boolean isPrivateLayout();

	/**
	 * Sets whether this {$entity.humanName} is private layout.
	 *
	 * @param privateLayout the private layout of this layout set
	 */
	public void setPrivateLayout(boolean privateLayout);

	/**
	 * Gets the logo of this layout set.
	 *
	 * @return the logo of this layout set
	 */
	public boolean getLogo();

	/**
	 * Determines if this layout set is logo.
	 *
	 * @return <code>true</code> if this layout set is logo; <code>false</code> otherwise
	 */
	public boolean isLogo();

	/**
	 * Sets whether this {$entity.humanName} is logo.
	 *
	 * @param logo the logo of this layout set
	 */
	public void setLogo(boolean logo);

	/**
	 * Gets the logo id of this layout set.
	 *
	 * @return the logo id of this layout set
	 */
	public long getLogoId();

	/**
	 * Sets the logo id of this layout set.
	 *
	 * @param logoId the logo id of this layout set
	 */
	public void setLogoId(long logoId);

	/**
	 * Gets the theme id of this layout set.
	 *
	 * @return the theme id of this layout set
	 */
	@AutoEscape
	public String getThemeId();

	/**
	 * Sets the theme id of this layout set.
	 *
	 * @param themeId the theme id of this layout set
	 */
	public void setThemeId(String themeId);

	/**
	 * Gets the color scheme id of this layout set.
	 *
	 * @return the color scheme id of this layout set
	 */
	@AutoEscape
	public String getColorSchemeId();

	/**
	 * Sets the color scheme id of this layout set.
	 *
	 * @param colorSchemeId the color scheme id of this layout set
	 */
	public void setColorSchemeId(String colorSchemeId);

	/**
	 * Gets the wap theme id of this layout set.
	 *
	 * @return the wap theme id of this layout set
	 */
	@AutoEscape
	public String getWapThemeId();

	/**
	 * Sets the wap theme id of this layout set.
	 *
	 * @param wapThemeId the wap theme id of this layout set
	 */
	public void setWapThemeId(String wapThemeId);

	/**
	 * Gets the wap color scheme id of this layout set.
	 *
	 * @return the wap color scheme id of this layout set
	 */
	@AutoEscape
	public String getWapColorSchemeId();

	/**
	 * Sets the wap color scheme id of this layout set.
	 *
	 * @param wapColorSchemeId the wap color scheme id of this layout set
	 */
	public void setWapColorSchemeId(String wapColorSchemeId);

	/**
	 * Gets the css of this layout set.
	 *
	 * @return the css of this layout set
	 */
	@AutoEscape
	public String getCss();

	/**
	 * Sets the css of this layout set.
	 *
	 * @param css the css of this layout set
	 */
	public void setCss(String css);

	/**
	 * Gets the page count of this layout set.
	 *
	 * @return the page count of this layout set
	 */
	public int getPageCount();

	/**
	 * Sets the page count of this layout set.
	 *
	 * @param pageCount the page count of this layout set
	 */
	public void setPageCount(int pageCount);

	/**
	 * Gets the virtual host of this layout set.
	 *
	 * @return the virtual host of this layout set
	 */
	@AutoEscape
	public String getVirtualHost();

	/**
	 * Sets the virtual host of this layout set.
	 *
	 * @param virtualHost the virtual host of this layout set
	 */
	public void setVirtualHost(String virtualHost);

	/**
	 * Gets the settings of this layout set.
	 *
	 * @return the settings of this layout set
	 */
	@AutoEscape
	public String getSettings();

	/**
	 * Sets the settings of this layout set.
	 *
	 * @param settings the settings of this layout set
	 */
	public void setSettings(String settings);

	/**
	 * Gets the layout set prototype id of this layout set.
	 *
	 * @return the layout set prototype id of this layout set
	 */
	public long getLayoutSetPrototypeId();

	/**
	 * Sets the layout set prototype id of this layout set.
	 *
	 * @param layoutSetPrototypeId the layout set prototype id of this layout set
	 */
	public void setLayoutSetPrototypeId(long layoutSetPrototypeId);

	/**
	 * Gets a copy of this layout set as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public LayoutSet toEscapedModel();

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

	public int compareTo(LayoutSet layoutSet);

	public int hashCode();

	public String toString();

	public String toXmlString();
}