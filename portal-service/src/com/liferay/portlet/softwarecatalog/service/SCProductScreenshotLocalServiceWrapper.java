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

package com.liferay.portlet.softwarecatalog.service;

/**
 * <p>
 * This class is a wrapper for {@link SCProductScreenshotLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SCProductScreenshotLocalService
 * @generated
 */
public class SCProductScreenshotLocalServiceWrapper
	implements SCProductScreenshotLocalService {
	public SCProductScreenshotLocalServiceWrapper(
		SCProductScreenshotLocalService scProductScreenshotLocalService) {
		_scProductScreenshotLocalService = scProductScreenshotLocalService;
	}

	/**
	* Adds the s c product screenshot to the database. Also notifies the appropriate model listeners.
	*
	* @param scProductScreenshot the s c product screenshot to add
	* @return the s c product screenshot that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductScreenshot addSCProductScreenshot(
		com.liferay.portlet.softwarecatalog.model.SCProductScreenshot scProductScreenshot)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scProductScreenshotLocalService.addSCProductScreenshot(scProductScreenshot);
	}

	/**
	* Creates a new s c product screenshot with the primary key. Does not add the s c product screenshot to the database.
	*
	* @param productScreenshotId the primary key for the new s c product screenshot
	* @return the new s c product screenshot
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductScreenshot createSCProductScreenshot(
		long productScreenshotId) {
		return _scProductScreenshotLocalService.createSCProductScreenshot(productScreenshotId);
	}

	/**
	* Deletes the s c product screenshot with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productScreenshotId the primary key of the s c product screenshot to delete
	* @throws PortalException if a s c product screenshot with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSCProductScreenshot(long productScreenshotId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_scProductScreenshotLocalService.deleteSCProductScreenshot(productScreenshotId);
	}

	/**
	* Deletes the s c product screenshot from the database. Also notifies the appropriate model listeners.
	*
	* @param scProductScreenshot the s c product screenshot to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSCProductScreenshot(
		com.liferay.portlet.softwarecatalog.model.SCProductScreenshot scProductScreenshot)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scProductScreenshotLocalService.deleteSCProductScreenshot(scProductScreenshot);
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
		return _scProductScreenshotLocalService.dynamicQuery(dynamicQuery);
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
		return _scProductScreenshotLocalService.dynamicQuery(dynamicQuery,
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
		return _scProductScreenshotLocalService.dynamicQuery(dynamicQuery,
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
		return _scProductScreenshotLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the s c product screenshot with the primary key.
	*
	* @param productScreenshotId the primary key of the s c product screenshot to get
	* @return the s c product screenshot
	* @throws PortalException if a s c product screenshot with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductScreenshot getSCProductScreenshot(
		long productScreenshotId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scProductScreenshotLocalService.getSCProductScreenshot(productScreenshotId);
	}

	/**
	* Gets a range of all the s c product screenshots.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s c product screenshots to return
	* @param end the upper bound of the range of s c product screenshots to return (not inclusive)
	* @return the range of s c product screenshots
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductScreenshot> getSCProductScreenshots(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scProductScreenshotLocalService.getSCProductScreenshots(start,
			end);
	}

	/**
	* Gets the number of s c product screenshots.
	*
	* @return the number of s c product screenshots
	* @throws SystemException if a system exception occurred
	*/
	public int getSCProductScreenshotsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scProductScreenshotLocalService.getSCProductScreenshotsCount();
	}

	/**
	* Updates the s c product screenshot in the database. Also notifies the appropriate model listeners.
	*
	* @param scProductScreenshot the s c product screenshot to update
	* @return the s c product screenshot that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductScreenshot updateSCProductScreenshot(
		com.liferay.portlet.softwarecatalog.model.SCProductScreenshot scProductScreenshot)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scProductScreenshotLocalService.updateSCProductScreenshot(scProductScreenshot);
	}

	/**
	* Updates the s c product screenshot in the database. Also notifies the appropriate model listeners.
	*
	* @param scProductScreenshot the s c product screenshot to update
	* @param merge whether to merge the s c product screenshot with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the s c product screenshot that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductScreenshot updateSCProductScreenshot(
		com.liferay.portlet.softwarecatalog.model.SCProductScreenshot scProductScreenshot,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scProductScreenshotLocalService.updateSCProductScreenshot(scProductScreenshot,
			merge);
	}

	public void deleteProductScreenshot(
		com.liferay.portlet.softwarecatalog.model.SCProductScreenshot productScreenshot)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_scProductScreenshotLocalService.deleteProductScreenshot(productScreenshot);
	}

	public void deleteProductScreenshots(long productEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_scProductScreenshotLocalService.deleteProductScreenshots(productEntryId);
	}

	public com.liferay.portlet.softwarecatalog.model.SCProductScreenshot getProductScreenshot(
		long productEntryId, int priority)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scProductScreenshotLocalService.getProductScreenshot(productEntryId,
			priority);
	}

	public com.liferay.portlet.softwarecatalog.model.SCProductScreenshot getProductScreenshotByFullImageId(
		long fullImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scProductScreenshotLocalService.getProductScreenshotByFullImageId(fullImageId);
	}

	public com.liferay.portlet.softwarecatalog.model.SCProductScreenshot getProductScreenshotByThumbnailId(
		long thumbnailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scProductScreenshotLocalService.getProductScreenshotByThumbnailId(thumbnailId);
	}

	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductScreenshot> getProductScreenshots(
		long productEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scProductScreenshotLocalService.getProductScreenshots(productEntryId);
	}

	public SCProductScreenshotLocalService getWrappedSCProductScreenshotLocalService() {
		return _scProductScreenshotLocalService;
	}

	private SCProductScreenshotLocalService _scProductScreenshotLocalService;
}