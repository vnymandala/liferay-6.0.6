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
 * This class is a wrapper for {@link LayoutSetPrototypeLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LayoutSetPrototypeLocalService
 * @generated
 */
public class LayoutSetPrototypeLocalServiceWrapper
	implements LayoutSetPrototypeLocalService {
	public LayoutSetPrototypeLocalServiceWrapper(
		LayoutSetPrototypeLocalService layoutSetPrototypeLocalService) {
		_layoutSetPrototypeLocalService = layoutSetPrototypeLocalService;
	}

	/**
	* Adds the layout set prototype to the database. Also notifies the appropriate model listeners.
	*
	* @param layoutSetPrototype the layout set prototype to add
	* @return the layout set prototype that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype addLayoutSetPrototype(
		com.liferay.portal.model.LayoutSetPrototype layoutSetPrototype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetPrototypeLocalService.addLayoutSetPrototype(layoutSetPrototype);
	}

	/**
	* Creates a new layout set prototype with the primary key. Does not add the layout set prototype to the database.
	*
	* @param layoutSetPrototypeId the primary key for the new layout set prototype
	* @return the new layout set prototype
	*/
	public com.liferay.portal.model.LayoutSetPrototype createLayoutSetPrototype(
		long layoutSetPrototypeId) {
		return _layoutSetPrototypeLocalService.createLayoutSetPrototype(layoutSetPrototypeId);
	}

	/**
	* Deletes the layout set prototype with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param layoutSetPrototypeId the primary key of the layout set prototype to delete
	* @throws PortalException if a layout set prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLayoutSetPrototype(long layoutSetPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutSetPrototypeLocalService.deleteLayoutSetPrototype(layoutSetPrototypeId);
	}

	/**
	* Deletes the layout set prototype from the database. Also notifies the appropriate model listeners.
	*
	* @param layoutSetPrototype the layout set prototype to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLayoutSetPrototype(
		com.liferay.portal.model.LayoutSetPrototype layoutSetPrototype)
		throws com.liferay.portal.kernel.exception.SystemException {
		_layoutSetPrototypeLocalService.deleteLayoutSetPrototype(layoutSetPrototype);
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
		return _layoutSetPrototypeLocalService.dynamicQuery(dynamicQuery);
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
		return _layoutSetPrototypeLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _layoutSetPrototypeLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _layoutSetPrototypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the layout set prototype with the primary key.
	*
	* @param layoutSetPrototypeId the primary key of the layout set prototype to get
	* @return the layout set prototype
	* @throws PortalException if a layout set prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype getLayoutSetPrototype(
		long layoutSetPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetPrototypeLocalService.getLayoutSetPrototype(layoutSetPrototypeId);
	}

	/**
	* Gets a range of all the layout set prototypes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of layout set prototypes to return
	* @param end the upper bound of the range of layout set prototypes to return (not inclusive)
	* @return the range of layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> getLayoutSetPrototypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetPrototypeLocalService.getLayoutSetPrototypes(start, end);
	}

	/**
	* Gets the number of layout set prototypes.
	*
	* @return the number of layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public int getLayoutSetPrototypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetPrototypeLocalService.getLayoutSetPrototypesCount();
	}

	/**
	* Updates the layout set prototype in the database. Also notifies the appropriate model listeners.
	*
	* @param layoutSetPrototype the layout set prototype to update
	* @return the layout set prototype that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype updateLayoutSetPrototype(
		com.liferay.portal.model.LayoutSetPrototype layoutSetPrototype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetPrototypeLocalService.updateLayoutSetPrototype(layoutSetPrototype);
	}

	/**
	* Updates the layout set prototype in the database. Also notifies the appropriate model listeners.
	*
	* @param layoutSetPrototype the layout set prototype to update
	* @param merge whether to merge the layout set prototype with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the layout set prototype that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype updateLayoutSetPrototype(
		com.liferay.portal.model.LayoutSetPrototype layoutSetPrototype,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetPrototypeLocalService.updateLayoutSetPrototype(layoutSetPrototype,
			merge);
	}

	public com.liferay.portal.model.LayoutSetPrototype addLayoutSetPrototype(
		long userId, long companyId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.lang.String description, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetPrototypeLocalService.addLayoutSetPrototype(userId,
			companyId, nameMap, description, active);
	}

	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> search(
		long companyId, java.lang.Boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetPrototypeLocalService.search(companyId, active, start,
			end, obc);
	}

	public int searchCount(long companyId, java.lang.Boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetPrototypeLocalService.searchCount(companyId, active);
	}

	public com.liferay.portal.model.LayoutSetPrototype updateLayoutSetPrototype(
		long layoutSetPrototypeId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.lang.String description, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetPrototypeLocalService.updateLayoutSetPrototype(layoutSetPrototypeId,
			nameMap, description, active);
	}

	public LayoutSetPrototypeLocalService getWrappedLayoutSetPrototypeLocalService() {
		return _layoutSetPrototypeLocalService;
	}

	private LayoutSetPrototypeLocalService _layoutSetPrototypeLocalService;
}