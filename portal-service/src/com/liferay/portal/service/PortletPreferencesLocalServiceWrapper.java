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
 * This class is a wrapper for {@link PortletPreferencesLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PortletPreferencesLocalService
 * @generated
 */
public class PortletPreferencesLocalServiceWrapper
	implements PortletPreferencesLocalService {
	public PortletPreferencesLocalServiceWrapper(
		PortletPreferencesLocalService portletPreferencesLocalService) {
		_portletPreferencesLocalService = portletPreferencesLocalService;
	}

	/**
	* Adds the portlet preferences to the database. Also notifies the appropriate model listeners.
	*
	* @param portletPreferences the portlet preferences to add
	* @return the portlet preferences that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.PortletPreferences addPortletPreferences(
		com.liferay.portal.model.PortletPreferences portletPreferences)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.addPortletPreferences(portletPreferences);
	}

	/**
	* Creates a new portlet preferences with the primary key. Does not add the portlet preferences to the database.
	*
	* @param portletPreferencesId the primary key for the new portlet preferences
	* @return the new portlet preferences
	*/
	public com.liferay.portal.model.PortletPreferences createPortletPreferences(
		long portletPreferencesId) {
		return _portletPreferencesLocalService.createPortletPreferences(portletPreferencesId);
	}

	/**
	* Deletes the portlet preferences with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portletPreferencesId the primary key of the portlet preferences to delete
	* @throws PortalException if a portlet preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePortletPreferences(long portletPreferencesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_portletPreferencesLocalService.deletePortletPreferences(portletPreferencesId);
	}

	/**
	* Deletes the portlet preferences from the database. Also notifies the appropriate model listeners.
	*
	* @param portletPreferences the portlet preferences to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deletePortletPreferences(
		com.liferay.portal.model.PortletPreferences portletPreferences)
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletPreferencesLocalService.deletePortletPreferences(portletPreferences);
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
		return _portletPreferencesLocalService.dynamicQuery(dynamicQuery);
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
		return _portletPreferencesLocalService.dynamicQuery(dynamicQuery,
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
		return _portletPreferencesLocalService.dynamicQuery(dynamicQuery,
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
		return _portletPreferencesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the portlet preferences with the primary key.
	*
	* @param portletPreferencesId the primary key of the portlet preferences to get
	* @return the portlet preferences
	* @throws PortalException if a portlet preferences with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.PortletPreferences getPortletPreferences(
		long portletPreferencesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPortletPreferences(portletPreferencesId);
	}

	/**
	* Gets a range of all the portlet preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet preferenceses to return
	* @param end the upper bound of the range of portlet preferenceses to return (not inclusive)
	* @return the range of portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.PortletPreferences> getPortletPreferenceses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPortletPreferenceses(start,
			end);
	}

	/**
	* Gets the number of portlet preferenceses.
	*
	* @return the number of portlet preferenceses
	* @throws SystemException if a system exception occurred
	*/
	public int getPortletPreferencesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPortletPreferencesesCount();
	}

	/**
	* Updates the portlet preferences in the database. Also notifies the appropriate model listeners.
	*
	* @param portletPreferences the portlet preferences to update
	* @return the portlet preferences that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.PortletPreferences updatePortletPreferences(
		com.liferay.portal.model.PortletPreferences portletPreferences)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.updatePortletPreferences(portletPreferences);
	}

	/**
	* Updates the portlet preferences in the database. Also notifies the appropriate model listeners.
	*
	* @param portletPreferences the portlet preferences to update
	* @param merge whether to merge the portlet preferences with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the portlet preferences that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.PortletPreferences updatePortletPreferences(
		com.liferay.portal.model.PortletPreferences portletPreferences,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.updatePortletPreferences(portletPreferences,
			merge);
	}

	public com.liferay.portal.model.PortletPreferences addPortletPreferences(
		long companyId, long ownerId, int ownerType, long plid,
		java.lang.String portletId, com.liferay.portal.model.Portlet portlet,
		java.lang.String defaultPreferences)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.addPortletPreferences(companyId,
			ownerId, ownerType, plid, portletId, portlet, defaultPreferences);
	}

	public void deletePortletPreferences(long ownerId, int ownerType, long plid)
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletPreferencesLocalService.deletePortletPreferences(ownerId,
			ownerType, plid);
	}

	public void deletePortletPreferences(long ownerId, int ownerType,
		long plid, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_portletPreferencesLocalService.deletePortletPreferences(ownerId,
			ownerType, plid, portletId);
	}

	public javax.portlet.PortletPreferences getDefaultPreferences(
		long companyId, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getDefaultPreferences(companyId,
			portletId);
	}

	public java.util.List<com.liferay.portal.model.PortletPreferences> getPortletPreferences()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPortletPreferences();
	}

	public java.util.List<com.liferay.portal.model.PortletPreferences> getPortletPreferences(
		long plid, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPortletPreferences(plid,
			portletId);
	}

	public java.util.List<com.liferay.portal.model.PortletPreferences> getPortletPreferences(
		long ownerId, int ownerType, long plid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPortletPreferences(ownerId,
			ownerType, plid);
	}

	public com.liferay.portal.model.PortletPreferences getPortletPreferences(
		long ownerId, int ownerType, long plid, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPortletPreferences(ownerId,
			ownerType, plid, portletId);
	}

	public java.util.List<com.liferay.portal.model.PortletPreferences> getPortletPreferencesByPlid(
		long plid) throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPortletPreferencesByPlid(plid);
	}

	public javax.portlet.PortletPreferences getPreferences(
		com.liferay.portal.model.PortletPreferencesIds portletPreferencesIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPreferences(portletPreferencesIds);
	}

	public javax.portlet.PortletPreferences getPreferences(long companyId,
		long ownerId, int ownerType, long plid, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPreferences(companyId,
			ownerId, ownerType, plid, portletId);
	}

	public javax.portlet.PortletPreferences getPreferences(long companyId,
		long ownerId, int ownerType, long plid, java.lang.String portletId,
		java.lang.String defaultPreferences)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.getPreferences(companyId,
			ownerId, ownerType, plid, portletId, defaultPreferences);
	}

	public com.liferay.portal.model.PortletPreferences updatePreferences(
		long ownerId, int ownerType, long plid, java.lang.String portletId,
		javax.portlet.PortletPreferences preferences)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.updatePreferences(ownerId,
			ownerType, plid, portletId, preferences);
	}

	public com.liferay.portal.model.PortletPreferences updatePreferences(
		long ownerId, int ownerType, long plid, java.lang.String portletId,
		java.lang.String xml)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletPreferencesLocalService.updatePreferences(ownerId,
			ownerType, plid, portletId, xml);
	}

	public PortletPreferencesLocalService getWrappedPortletPreferencesLocalService() {
		return _portletPreferencesLocalService;
	}

	private PortletPreferencesLocalService _portletPreferencesLocalService;
}