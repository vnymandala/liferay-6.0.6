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

package com.liferay.portlet.wiki.service;

/**
 * <p>
 * This class is a wrapper for {@link WikiPageResourceLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WikiPageResourceLocalService
 * @generated
 */
public class WikiPageResourceLocalServiceWrapper
	implements WikiPageResourceLocalService {
	public WikiPageResourceLocalServiceWrapper(
		WikiPageResourceLocalService wikiPageResourceLocalService) {
		_wikiPageResourceLocalService = wikiPageResourceLocalService;
	}

	/**
	* Adds the wiki page resource to the database. Also notifies the appropriate model listeners.
	*
	* @param wikiPageResource the wiki page resource to add
	* @return the wiki page resource that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPageResource addWikiPageResource(
		com.liferay.portlet.wiki.model.WikiPageResource wikiPageResource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wikiPageResourceLocalService.addWikiPageResource(wikiPageResource);
	}

	/**
	* Creates a new wiki page resource with the primary key. Does not add the wiki page resource to the database.
	*
	* @param resourcePrimKey the primary key for the new wiki page resource
	* @return the new wiki page resource
	*/
	public com.liferay.portlet.wiki.model.WikiPageResource createWikiPageResource(
		long resourcePrimKey) {
		return _wikiPageResourceLocalService.createWikiPageResource(resourcePrimKey);
	}

	/**
	* Deletes the wiki page resource with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resourcePrimKey the primary key of the wiki page resource to delete
	* @throws PortalException if a wiki page resource with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWikiPageResource(long resourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wikiPageResourceLocalService.deleteWikiPageResource(resourcePrimKey);
	}

	/**
	* Deletes the wiki page resource from the database. Also notifies the appropriate model listeners.
	*
	* @param wikiPageResource the wiki page resource to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWikiPageResource(
		com.liferay.portlet.wiki.model.WikiPageResource wikiPageResource)
		throws com.liferay.portal.kernel.exception.SystemException {
		_wikiPageResourceLocalService.deleteWikiPageResource(wikiPageResource);
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
		return _wikiPageResourceLocalService.dynamicQuery(dynamicQuery);
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
		return _wikiPageResourceLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _wikiPageResourceLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _wikiPageResourceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the wiki page resource with the primary key.
	*
	* @param resourcePrimKey the primary key of the wiki page resource to get
	* @return the wiki page resource
	* @throws PortalException if a wiki page resource with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPageResource getWikiPageResource(
		long resourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wikiPageResourceLocalService.getWikiPageResource(resourcePrimKey);
	}

	/**
	* Gets a range of all the wiki page resources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wiki page resources to return
	* @param end the upper bound of the range of wiki page resources to return (not inclusive)
	* @return the range of wiki page resources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPageResource> getWikiPageResources(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wikiPageResourceLocalService.getWikiPageResources(start, end);
	}

	/**
	* Gets the number of wiki page resources.
	*
	* @return the number of wiki page resources
	* @throws SystemException if a system exception occurred
	*/
	public int getWikiPageResourcesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wikiPageResourceLocalService.getWikiPageResourcesCount();
	}

	/**
	* Updates the wiki page resource in the database. Also notifies the appropriate model listeners.
	*
	* @param wikiPageResource the wiki page resource to update
	* @return the wiki page resource that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPageResource updateWikiPageResource(
		com.liferay.portlet.wiki.model.WikiPageResource wikiPageResource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wikiPageResourceLocalService.updateWikiPageResource(wikiPageResource);
	}

	/**
	* Updates the wiki page resource in the database. Also notifies the appropriate model listeners.
	*
	* @param wikiPageResource the wiki page resource to update
	* @param merge whether to merge the wiki page resource with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the wiki page resource that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPageResource updateWikiPageResource(
		com.liferay.portlet.wiki.model.WikiPageResource wikiPageResource,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wikiPageResourceLocalService.updateWikiPageResource(wikiPageResource,
			merge);
	}

	public com.liferay.portlet.wiki.model.WikiPageResource addPageResource(
		long nodeId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wikiPageResourceLocalService.addPageResource(nodeId, title);
	}

	public void deletePageResource(long nodeId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wikiPageResourceLocalService.deletePageResource(nodeId, title);
	}

	public com.liferay.portlet.wiki.model.WikiPageResource getPageResource(
		long pageResourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wikiPageResourceLocalService.getPageResource(pageResourcePrimKey);
	}

	public com.liferay.portlet.wiki.model.WikiPageResource getPageResource(
		long nodeId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wikiPageResourceLocalService.getPageResource(nodeId, title);
	}

	public long getPageResourcePrimKey(long nodeId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wikiPageResourceLocalService.getPageResourcePrimKey(nodeId,
			title);
	}

	public WikiPageResourceLocalService getWrappedWikiPageResourceLocalService() {
		return _wikiPageResourceLocalService;
	}

	private WikiPageResourceLocalService _wikiPageResourceLocalService;
}