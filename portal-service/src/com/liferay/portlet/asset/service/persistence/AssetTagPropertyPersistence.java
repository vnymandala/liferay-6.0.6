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

package com.liferay.portlet.asset.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.portlet.asset.model.AssetTagProperty;

/**
 * The persistence interface for the asset tag property service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link AssetTagPropertyUtil} to access the asset tag property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTagPropertyPersistenceImpl
 * @see AssetTagPropertyUtil
 * @generated
 */
public interface AssetTagPropertyPersistence extends BasePersistence<AssetTagProperty> {
	/**
	* Caches the asset tag property in the entity cache if it is enabled.
	*
	* @param assetTagProperty the asset tag property to cache
	*/
	public void cacheResult(
		com.liferay.portlet.asset.model.AssetTagProperty assetTagProperty);

	/**
	* Caches the asset tag properties in the entity cache if it is enabled.
	*
	* @param assetTagProperties the asset tag properties to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> assetTagProperties);

	/**
	* Creates a new asset tag property with the primary key. Does not add the asset tag property to the database.
	*
	* @param tagPropertyId the primary key for the new asset tag property
	* @return the new asset tag property
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty create(
		long tagPropertyId);

	/**
	* Removes the asset tag property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagPropertyId the primary key of the asset tag property to remove
	* @return the asset tag property that was removed
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a asset tag property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty remove(
		long tagPropertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	public com.liferay.portlet.asset.model.AssetTagProperty updateImpl(
		com.liferay.portlet.asset.model.AssetTagProperty assetTagProperty,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the asset tag property with the primary key or throws a {@link com.liferay.portlet.asset.NoSuchTagPropertyException} if it could not be found.
	*
	* @param tagPropertyId the primary key of the asset tag property to find
	* @return the asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a asset tag property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty findByPrimaryKey(
		long tagPropertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds the asset tag property with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagPropertyId the primary key of the asset tag property to find
	* @return the asset tag property, or <code>null</code> if a asset tag property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty fetchByPrimaryKey(
		long tagPropertyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the asset tag properties where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the asset tag properties where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of asset tag properties to return
	* @param end the upper bound of the range of asset tag properties to return (not inclusive)
	* @return the range of matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the asset tag properties where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of asset tag properties to return
	* @param end the upper bound of the range of asset tag properties to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first asset tag property in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a matching asset tag property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds the last asset tag property in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a matching asset tag property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds the asset tag properties before and after the current asset tag property in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagPropertyId the primary key of the current asset tag property
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a asset tag property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty[] findByCompanyId_PrevAndNext(
		long tagPropertyId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds all the asset tag properties where tagId = &#63;.
	*
	* @param tagId the tag id to search with
	* @return the matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findByTagId(
		long tagId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the asset tag properties where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagId the tag id to search with
	* @param start the lower bound of the range of asset tag properties to return
	* @param end the upper bound of the range of asset tag properties to return (not inclusive)
	* @return the range of matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findByTagId(
		long tagId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the asset tag properties where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagId the tag id to search with
	* @param start the lower bound of the range of asset tag properties to return
	* @param end the upper bound of the range of asset tag properties to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findByTagId(
		long tagId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first asset tag property in the ordered set where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagId the tag id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a matching asset tag property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty findByTagId_First(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds the last asset tag property in the ordered set where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagId the tag id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a matching asset tag property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty findByTagId_Last(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds the asset tag properties before and after the current asset tag property in the ordered set where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagPropertyId the primary key of the current asset tag property
	* @param tagId the tag id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a asset tag property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty[] findByTagId_PrevAndNext(
		long tagPropertyId, long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds all the asset tag properties where companyId = &#63; and key = &#63;.
	*
	* @param companyId the company id to search with
	* @param key the key to search with
	* @return the matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findByC_K(
		long companyId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the asset tag properties where companyId = &#63; and key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param key the key to search with
	* @param start the lower bound of the range of asset tag properties to return
	* @param end the upper bound of the range of asset tag properties to return (not inclusive)
	* @return the range of matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findByC_K(
		long companyId, java.lang.String key, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the asset tag properties where companyId = &#63; and key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param key the key to search with
	* @param start the lower bound of the range of asset tag properties to return
	* @param end the upper bound of the range of asset tag properties to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findByC_K(
		long companyId, java.lang.String key, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first asset tag property in the ordered set where companyId = &#63; and key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param key the key to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a matching asset tag property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty findByC_K_First(
		long companyId, java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds the last asset tag property in the ordered set where companyId = &#63; and key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param key the key to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a matching asset tag property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty findByC_K_Last(
		long companyId, java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds the asset tag properties before and after the current asset tag property in the ordered set where companyId = &#63; and key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagPropertyId the primary key of the current asset tag property
	* @param companyId the company id to search with
	* @param key the key to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a asset tag property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty[] findByC_K_PrevAndNext(
		long tagPropertyId, long companyId, java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds the asset tag property where tagId = &#63; and key = &#63; or throws a {@link com.liferay.portlet.asset.NoSuchTagPropertyException} if it could not be found.
	*
	* @param tagId the tag id to search with
	* @param key the key to search with
	* @return the matching asset tag property
	* @throws com.liferay.portlet.asset.NoSuchTagPropertyException if a matching asset tag property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty findByT_K(
		long tagId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Finds the asset tag property where tagId = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tagId the tag id to search with
	* @param key the key to search with
	* @return the matching asset tag property, or <code>null</code> if a matching asset tag property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty fetchByT_K(
		long tagId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the asset tag property where tagId = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tagId the tag id to search with
	* @param key the key to search with
	* @return the matching asset tag property, or <code>null</code> if a matching asset tag property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.asset.model.AssetTagProperty fetchByT_K(
		long tagId, java.lang.String key, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the asset tag properties.
	*
	* @return the asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the asset tag properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of asset tag properties to return
	* @param end the upper bound of the range of asset tag properties to return (not inclusive)
	* @return the range of asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the asset tag properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of asset tag properties to return
	* @param end the upper bound of the range of asset tag properties to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the asset tag properties where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the asset tag properties where tagId = &#63; from the database.
	*
	* @param tagId the tag id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTagId(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the asset tag properties where companyId = &#63; and key = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param key the key to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_K(long companyId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the asset tag property where tagId = &#63; and key = &#63; from the database.
	*
	* @param tagId the tag id to search with
	* @param key the key to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByT_K(long tagId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagPropertyException;

	/**
	* Removes all the asset tag properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the asset tag properties where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the asset tag properties where tagId = &#63;.
	*
	* @param tagId the tag id to search with
	* @return the number of matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByTagId(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the asset tag properties where companyId = &#63; and key = &#63;.
	*
	* @param companyId the company id to search with
	* @param key the key to search with
	* @return the number of matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_K(long companyId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the asset tag properties where tagId = &#63; and key = &#63;.
	*
	* @param tagId the tag id to search with
	* @param key the key to search with
	* @return the number of matching asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_K(long tagId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the asset tag properties.
	*
	* @return the number of asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}