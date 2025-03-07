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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link LayoutLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LayoutLocalService
 * @generated
 */
public class LayoutLocalServiceWrapper implements LayoutLocalService {
	public LayoutLocalServiceWrapper(LayoutLocalService layoutLocalService) {
		_layoutLocalService = layoutLocalService;
	}

	/**
	* Adds the layout to the database. Also notifies the appropriate model listeners.
	*
	* @param layout the layout to add
	* @return the layout that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Layout addLayout(
		com.liferay.portal.model.Layout layout)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.addLayout(layout);
	}

	/**
	* Creates a new layout with the primary key. Does not add the layout to the database.
	*
	* @param plid the primary key for the new layout
	* @return the new layout
	*/
	public com.liferay.portal.model.Layout createLayout(long plid) {
		return _layoutLocalService.createLayout(plid);
	}

	/**
	* Deletes the layout with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param plid the primary key of the layout to delete
	* @throws PortalException if a layout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLayout(long plid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.deleteLayout(plid);
	}

	/**
	* Deletes the layout from the database. Also notifies the appropriate model listeners.
	*
	* @param layout the layout to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLayout(com.liferay.portal.model.Layout layout)
		throws com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.deleteLayout(layout);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the layout with the primary key.
	*
	* @param plid the primary key of the layout to get
	* @return the layout
	* @throws PortalException if a layout with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Layout getLayout(long plid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayout(plid);
	}

	/**
	* Gets the layout with the UUID and group id.
	*
	* @param uuid the UUID of layout to get
	* @param groupId the group id of the layout to get
	* @return the layout
	* @throws PortalException if a layout with the UUID and group id could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Layout getLayoutByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayoutByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Gets a range of all the layouts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of layouts to return
	* @param end the upper bound of the range of layouts to return (not inclusive)
	* @return the range of layouts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Layout> getLayouts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayouts(start, end);
	}

	/**
	* Gets the number of layouts.
	*
	* @return the number of layouts
	* @throws SystemException if a system exception occurred
	*/
	public int getLayoutsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayoutsCount();
	}

	/**
	* Updates the layout in the database. Also notifies the appropriate model listeners.
	*
	* @param layout the layout to update
	* @return the layout that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Layout updateLayout(
		com.liferay.portal.model.Layout layout)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateLayout(layout);
	}

	/**
	* Updates the layout in the database. Also notifies the appropriate model listeners.
	*
	* @param layout the layout to update
	* @param merge whether to merge the layout with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the layout that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Layout updateLayout(
		com.liferay.portal.model.Layout layout, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateLayout(layout, merge);
	}

	public com.liferay.portal.model.Layout addLayout(long userId, long groupId,
		boolean privateLayout, long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.lang.String description, java.lang.String type, boolean hidden,
		java.lang.String friendlyURL, long dlFolderId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.addLayout(userId, groupId, privateLayout,
			parentLayoutId, localeNamesMap, localeTitlesMap, description, type,
			hidden, friendlyURL, dlFolderId, serviceContext);
	}

	public com.liferay.portal.model.Layout addLayout(long userId, long groupId,
		boolean privateLayout, long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.lang.String description, java.lang.String type, boolean hidden,
		java.lang.String friendlyURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.addLayout(userId, groupId, privateLayout,
			parentLayoutId, localeNamesMap, localeTitlesMap, description, type,
			hidden, friendlyURL, serviceContext);
	}

	public com.liferay.portal.model.Layout addLayout(long userId, long groupId,
		boolean privateLayout, long parentLayoutId, java.lang.String name,
		java.lang.String title, java.lang.String description,
		java.lang.String type, boolean hidden, java.lang.String friendlyURL,
		long dlFolderId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.addLayout(userId, groupId, privateLayout,
			parentLayoutId, name, title, description, type, hidden,
			friendlyURL, dlFolderId, serviceContext);
	}

	public com.liferay.portal.model.Layout addLayout(long userId, long groupId,
		boolean privateLayout, long parentLayoutId, java.lang.String name,
		java.lang.String title, java.lang.String description,
		java.lang.String type, boolean hidden, java.lang.String friendlyURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.addLayout(userId, groupId, privateLayout,
			parentLayoutId, name, title, description, type, hidden,
			friendlyURL, serviceContext);
	}

	public void deleteLayout(com.liferay.portal.model.Layout layout,
		boolean updateLayoutSet)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.deleteLayout(layout, updateLayoutSet);
	}

	public void deleteLayout(long groupId, boolean privateLayout, long layoutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.deleteLayout(groupId, privateLayout, layoutId);
	}

	public void deleteLayouts(long groupId, boolean privateLayout)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.deleteLayouts(groupId, privateLayout);
	}

	public byte[] exportLayouts(long groupId, boolean privateLayout,
		long[] layoutIds,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.exportLayouts(groupId, privateLayout,
			layoutIds, parameterMap, startDate, endDate);
	}

	public byte[] exportLayouts(long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.exportLayouts(groupId, privateLayout,
			parameterMap, startDate, endDate);
	}

	public java.io.File exportLayoutsAsFile(long groupId,
		boolean privateLayout, long[] layoutIds,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.exportLayoutsAsFile(groupId, privateLayout,
			layoutIds, parameterMap, startDate, endDate);
	}

	public byte[] exportPortletInfo(long plid, long groupId,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.exportPortletInfo(plid, groupId, portletId,
			parameterMap, startDate, endDate);
	}

	public java.io.File exportPortletInfoAsFile(long plid, long groupId,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.exportPortletInfoAsFile(plid, groupId,
			portletId, parameterMap, startDate, endDate);
	}

	public long getDefaultPlid(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getDefaultPlid(groupId);
	}

	public long getDefaultPlid(long groupId, boolean privateLayout)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getDefaultPlid(groupId, privateLayout);
	}

	public long getDefaultPlid(long groupId, boolean privateLayout,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getDefaultPlid(groupId, privateLayout,
			portletId);
	}

	public com.liferay.portal.model.Layout getDLFolderLayout(long dlFolderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getDLFolderLayout(dlFolderId);
	}

	public com.liferay.portal.model.Layout getFriendlyURLLayout(long groupId,
		boolean privateLayout, java.lang.String friendlyURL)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getFriendlyURLLayout(groupId, privateLayout,
			friendlyURL);
	}

	public com.liferay.portal.model.Layout getLayout(long groupId,
		boolean privateLayout, long layoutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayout(groupId, privateLayout, layoutId);
	}

	public com.liferay.portal.model.Layout getLayoutByIconImageId(
		long iconImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayoutByIconImageId(iconImageId);
	}

	public java.util.List<com.liferay.portal.model.Layout> getLayouts(
		long groupId, boolean privateLayout)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayouts(groupId, privateLayout);
	}

	public java.util.List<com.liferay.portal.model.Layout> getLayouts(
		long groupId, boolean privateLayout, long parentLayoutId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayouts(groupId, privateLayout,
			parentLayoutId);
	}

	public java.util.List<com.liferay.portal.model.Layout> getLayouts(
		long groupId, boolean privateLayout, long parentLayoutId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayouts(groupId, privateLayout,
			parentLayoutId, start, end);
	}

	public java.util.List<com.liferay.portal.model.Layout> getLayouts(
		long groupId, boolean privateLayout, long[] layoutIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayouts(groupId, privateLayout, layoutIds);
	}

	public java.util.List<com.liferay.portal.model.Layout> getLayouts(
		long groupId, boolean privateLayout, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayouts(groupId, privateLayout, type);
	}

	public com.liferay.portal.model.LayoutReference[] getLayouts(
		long companyId, java.lang.String portletId,
		java.lang.String preferencesKey, java.lang.String preferencesValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getLayouts(companyId, portletId,
			preferencesKey, preferencesValue);
	}

	public long getNextLayoutId(long groupId, boolean privateLayout)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getNextLayoutId(groupId, privateLayout);
	}

	public java.util.List<com.liferay.portal.model.Layout> getNullFriendlyURLLayouts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.getNullFriendlyURLLayouts();
	}

	public boolean hasLayouts(long groupId, boolean privateLayout,
		long parentLayoutId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.hasLayouts(groupId, privateLayout,
			parentLayoutId);
	}

	public void importLayouts(long userId, long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		byte[] bytes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.importLayouts(userId, groupId, privateLayout,
			parameterMap, bytes);
	}

	public void importLayouts(long userId, long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.importLayouts(userId, groupId, privateLayout,
			parameterMap, file);
	}

	public void importLayouts(long userId, long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream is)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.importLayouts(userId, groupId, privateLayout,
			parameterMap, is);
	}

	public void importPortletInfo(long userId, long plid, long groupId,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.importPortletInfo(userId, plid, groupId, portletId,
			parameterMap, file);
	}

	public void importPortletInfo(long userId, long plid, long groupId,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream is)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.importPortletInfo(userId, plid, groupId, portletId,
			parameterMap, is);
	}

	public void setLayouts(long groupId, boolean privateLayout,
		long parentLayoutId, long[] layoutIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutLocalService.setLayouts(groupId, privateLayout, parentLayoutId,
			layoutIds);
	}

	public com.liferay.portal.model.Layout updateFriendlyURL(long plid,
		java.lang.String friendlyURL)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateFriendlyURL(plid, friendlyURL);
	}

	public com.liferay.portal.model.Layout updateLayout(long groupId,
		boolean privateLayout, long layoutId, long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.lang.String description, java.lang.String type, boolean hidden,
		java.lang.String friendlyURL, java.lang.Boolean iconImage,
		byte[] iconBytes,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateLayout(groupId, privateLayout,
			layoutId, parentLayoutId, localeNamesMap, localeTitlesMap,
			description, type, hidden, friendlyURL, iconImage, iconBytes,
			serviceContext);
	}

	public com.liferay.portal.model.Layout updateLayout(long groupId,
		boolean privateLayout, long layoutId, long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.lang.String description, java.lang.String type, boolean hidden,
		java.lang.String friendlyURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateLayout(groupId, privateLayout,
			layoutId, parentLayoutId, localeNamesMap, localeTitlesMap,
			description, type, hidden, friendlyURL, serviceContext);
	}

	public com.liferay.portal.model.Layout updateLayout(long groupId,
		boolean privateLayout, long layoutId, java.lang.String typeSettings)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateLayout(groupId, privateLayout,
			layoutId, typeSettings);
	}

	public com.liferay.portal.model.Layout updateLookAndFeel(long groupId,
		boolean privateLayout, long layoutId, java.lang.String themeId,
		java.lang.String colorSchemeId, java.lang.String css, boolean wapTheme)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateLookAndFeel(groupId, privateLayout,
			layoutId, themeId, colorSchemeId, css, wapTheme);
	}

	public com.liferay.portal.model.Layout updateName(
		com.liferay.portal.model.Layout layout, java.lang.String name,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateName(layout, name, languageId);
	}

	public com.liferay.portal.model.Layout updateName(long groupId,
		boolean privateLayout, long layoutId, java.lang.String name,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateName(groupId, privateLayout, layoutId,
			name, languageId);
	}

	public com.liferay.portal.model.Layout updateName(long plid,
		java.lang.String name, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateName(plid, name, languageId);
	}

	public com.liferay.portal.model.Layout updateParentLayoutId(long groupId,
		boolean privateLayout, long layoutId, long parentLayoutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateParentLayoutId(groupId, privateLayout,
			layoutId, parentLayoutId);
	}

	public com.liferay.portal.model.Layout updateParentLayoutId(long plid,
		long parentPlid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updateParentLayoutId(plid, parentPlid);
	}

	public com.liferay.portal.model.Layout updatePriority(
		com.liferay.portal.model.Layout layout, int priority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updatePriority(layout, priority);
	}

	public com.liferay.portal.model.Layout updatePriority(long groupId,
		boolean privateLayout, long layoutId, int priority)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updatePriority(groupId, privateLayout,
			layoutId, priority);
	}

	public com.liferay.portal.model.Layout updatePriority(long plid,
		int priority)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutLocalService.updatePriority(plid, priority);
	}

	public LayoutLocalService getWrappedLayoutLocalService() {
		return _layoutLocalService;
	}

	private LayoutLocalService _layoutLocalService;
}