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

package com.liferay.portlet.asset.service;

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the asset tag stats local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link AssetTagStatsLocalServiceUtil} to access the asset tag stats local service. Add custom service methods to {@link com.liferay.portlet.asset.service.impl.AssetTagStatsLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTagStatsLocalServiceUtil
 * @see com.liferay.portlet.asset.service.base.AssetTagStatsLocalServiceBaseImpl
 * @see com.liferay.portlet.asset.service.impl.AssetTagStatsLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AssetTagStatsLocalService {
	/**
	* Adds the asset tag stats to the database. Also notifies the appropriate model listeners.
	*
	* @param assetTagStats the asset tag stats to add
	* @return the asset tag stats that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagStats addAssetTagStats(
		com.liferay.portlet.asset.model.AssetTagStats assetTagStats)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new asset tag stats with the primary key. Does not add the asset tag stats to the database.
	*
	* @param tagStatsId the primary key for the new asset tag stats
	* @return the new asset tag stats
	*/
	public com.liferay.portlet.asset.model.AssetTagStats createAssetTagStats(
		long tagStatsId);

	/**
	* Deletes the asset tag stats with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagStatsId the primary key of the asset tag stats to delete
	* @throws PortalException if a asset tag stats with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAssetTagStats(long tagStatsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the asset tag stats from the database. Also notifies the appropriate model listeners.
	*
	* @param assetTagStats the asset tag stats to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAssetTagStats(
		com.liferay.portlet.asset.model.AssetTagStats assetTagStats)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the asset tag stats with the primary key.
	*
	* @param tagStatsId the primary key of the asset tag stats to get
	* @return the asset tag stats
	* @throws PortalException if a asset tag stats with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portlet.asset.model.AssetTagStats getAssetTagStats(
		long tagStatsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the asset tag statses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of asset tag statses to return
	* @param end the upper bound of the range of asset tag statses to return (not inclusive)
	* @return the range of asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portlet.asset.model.AssetTagStats> getAssetTagStatses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of asset tag statses.
	*
	* @return the number of asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAssetTagStatsesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the asset tag stats in the database. Also notifies the appropriate model listeners.
	*
	* @param assetTagStats the asset tag stats to update
	* @return the asset tag stats that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagStats updateAssetTagStats(
		com.liferay.portlet.asset.model.AssetTagStats assetTagStats)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the asset tag stats in the database. Also notifies the appropriate model listeners.
	*
	* @param assetTagStats the asset tag stats to update
	* @param merge whether to merge the asset tag stats with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the asset tag stats that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagStats updateAssetTagStats(
		com.liferay.portlet.asset.model.AssetTagStats assetTagStats,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.asset.model.AssetTagStats addTagStats(
		long tagId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteTagStatsByClassNameId(long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteTagStatsByTagId(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portlet.asset.model.AssetTagStats getTagStats(
		long tagId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.asset.model.AssetTagStats updateTagStats(
		long tagId, long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}