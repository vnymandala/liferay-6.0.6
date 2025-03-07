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

package com.liferay.portal.service.persistence;

import com.liferay.portal.model.LayoutSetPrototype;

/**
 * The persistence interface for the layout set prototype service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link LayoutSetPrototypeUtil} to access the layout set prototype persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetPrototypePersistenceImpl
 * @see LayoutSetPrototypeUtil
 * @generated
 */
public interface LayoutSetPrototypePersistence extends BasePersistence<LayoutSetPrototype> {
	/**
	* Caches the layout set prototype in the entity cache if it is enabled.
	*
	* @param layoutSetPrototype the layout set prototype to cache
	*/
	public void cacheResult(
		com.liferay.portal.model.LayoutSetPrototype layoutSetPrototype);

	/**
	* Caches the layout set prototypes in the entity cache if it is enabled.
	*
	* @param layoutSetPrototypes the layout set prototypes to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.model.LayoutSetPrototype> layoutSetPrototypes);

	/**
	* Creates a new layout set prototype with the primary key. Does not add the layout set prototype to the database.
	*
	* @param layoutSetPrototypeId the primary key for the new layout set prototype
	* @return the new layout set prototype
	*/
	public com.liferay.portal.model.LayoutSetPrototype create(
		long layoutSetPrototypeId);

	/**
	* Removes the layout set prototype with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param layoutSetPrototypeId the primary key of the layout set prototype to remove
	* @return the layout set prototype that was removed
	* @throws com.liferay.portal.NoSuchLayoutSetPrototypeException if a layout set prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype remove(
		long layoutSetPrototypeId)
		throws com.liferay.portal.NoSuchLayoutSetPrototypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.LayoutSetPrototype updateImpl(
		com.liferay.portal.model.LayoutSetPrototype layoutSetPrototype,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the layout set prototype with the primary key or throws a {@link com.liferay.portal.NoSuchLayoutSetPrototypeException} if it could not be found.
	*
	* @param layoutSetPrototypeId the primary key of the layout set prototype to find
	* @return the layout set prototype
	* @throws com.liferay.portal.NoSuchLayoutSetPrototypeException if a layout set prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype findByPrimaryKey(
		long layoutSetPrototypeId)
		throws com.liferay.portal.NoSuchLayoutSetPrototypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the layout set prototype with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param layoutSetPrototypeId the primary key of the layout set prototype to find
	* @return the layout set prototype, or <code>null</code> if a layout set prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype fetchByPrimaryKey(
		long layoutSetPrototypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the layout set prototypes where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the layout set prototypes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of layout set prototypes to return
	* @param end the upper bound of the range of layout set prototypes to return (not inclusive)
	* @return the range of matching layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the layout set prototypes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of layout set prototypes to return
	* @param end the upper bound of the range of layout set prototypes to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first layout set prototype in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching layout set prototype
	* @throws com.liferay.portal.NoSuchLayoutSetPrototypeException if a matching layout set prototype could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutSetPrototypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last layout set prototype in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching layout set prototype
	* @throws com.liferay.portal.NoSuchLayoutSetPrototypeException if a matching layout set prototype could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutSetPrototypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the layout set prototypes before and after the current layout set prototype in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param layoutSetPrototypeId the primary key of the current layout set prototype
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next layout set prototype
	* @throws com.liferay.portal.NoSuchLayoutSetPrototypeException if a layout set prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype[] findByCompanyId_PrevAndNext(
		long layoutSetPrototypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutSetPrototypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds all the layout set prototypes where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching layout set prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> filterFindByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the layout set prototypes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of layout set prototypes to return
	* @param end the upper bound of the range of layout set prototypes to return (not inclusive)
	* @return the range of matching layout set prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> filterFindByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the layout set prototypes where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of layout set prototypes to return
	* @param end the upper bound of the range of layout set prototypes to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching layout set prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the layout set prototypes where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @return the matching layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> findByC_A(
		long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the layout set prototypes where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of layout set prototypes to return
	* @param end the upper bound of the range of layout set prototypes to return (not inclusive)
	* @return the range of matching layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> findByC_A(
		long companyId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the layout set prototypes where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of layout set prototypes to return
	* @param end the upper bound of the range of layout set prototypes to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> findByC_A(
		long companyId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first layout set prototype in the ordered set where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching layout set prototype
	* @throws com.liferay.portal.NoSuchLayoutSetPrototypeException if a matching layout set prototype could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype findByC_A_First(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutSetPrototypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last layout set prototype in the ordered set where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching layout set prototype
	* @throws com.liferay.portal.NoSuchLayoutSetPrototypeException if a matching layout set prototype could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype findByC_A_Last(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutSetPrototypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the layout set prototypes before and after the current layout set prototype in the ordered set where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param layoutSetPrototypeId the primary key of the current layout set prototype
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next layout set prototype
	* @throws com.liferay.portal.NoSuchLayoutSetPrototypeException if a layout set prototype with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.LayoutSetPrototype[] findByC_A_PrevAndNext(
		long layoutSetPrototypeId, long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLayoutSetPrototypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds all the layout set prototypes where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @return the matching layout set prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> filterFindByC_A(
		long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the layout set prototypes where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of layout set prototypes to return
	* @param end the upper bound of the range of layout set prototypes to return (not inclusive)
	* @return the range of matching layout set prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> filterFindByC_A(
		long companyId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the layout set prototypes where companyId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of layout set prototypes to return
	* @param end the upper bound of the range of layout set prototypes to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching layout set prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> filterFindByC_A(
		long companyId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the layout set prototypes.
	*
	* @return the layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the layout set prototypes.
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
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the layout set prototypes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of layout set prototypes to return
	* @param end the upper bound of the range of layout set prototypes to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.LayoutSetPrototype> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the layout set prototypes where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the layout set prototypes where companyId = &#63; and active = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_A(long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the layout set prototypes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the layout set prototypes where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the layout set prototypes where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching layout set prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the layout set prototypes where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @return the number of matching layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_A(long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the layout set prototypes where companyId = &#63; and active = &#63;.
	*
	* @param companyId the company id to search with
	* @param active the active to search with
	* @return the number of matching layout set prototypes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByC_A(long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the layout set prototypes.
	*
	* @return the number of layout set prototypes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}