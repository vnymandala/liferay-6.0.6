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

package com.liferay.portlet.softwarecatalog.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.portlet.softwarecatalog.model.SCProductEntry;

/**
 * The persistence interface for the s c product entry service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link SCProductEntryUtil} to access the s c product entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SCProductEntryPersistenceImpl
 * @see SCProductEntryUtil
 * @generated
 */
public interface SCProductEntryPersistence extends BasePersistence<SCProductEntry> {
	/**
	* Caches the s c product entry in the entity cache if it is enabled.
	*
	* @param scProductEntry the s c product entry to cache
	*/
	public void cacheResult(
		com.liferay.portlet.softwarecatalog.model.SCProductEntry scProductEntry);

	/**
	* Caches the s c product entries in the entity cache if it is enabled.
	*
	* @param scProductEntries the s c product entries to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> scProductEntries);

	/**
	* Creates a new s c product entry with the primary key. Does not add the s c product entry to the database.
	*
	* @param productEntryId the primary key for the new s c product entry
	* @return the new s c product entry
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry create(
		long productEntryId);

	/**
	* Removes the s c product entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productEntryId the primary key of the s c product entry to remove
	* @return the s c product entry that was removed
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a s c product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry remove(
		long productEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	public com.liferay.portlet.softwarecatalog.model.SCProductEntry updateImpl(
		com.liferay.portlet.softwarecatalog.model.SCProductEntry scProductEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the s c product entry with the primary key or throws a {@link com.liferay.portlet.softwarecatalog.NoSuchProductEntryException} if it could not be found.
	*
	* @param productEntryId the primary key of the s c product entry to find
	* @return the s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a s c product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry findByPrimaryKey(
		long productEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Finds the s c product entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param productEntryId the primary key of the s c product entry to find
	* @return the s c product entry, or <code>null</code> if a s c product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry fetchByPrimaryKey(
		long productEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the s c product entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the s c product entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @return the range of matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the s c product entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first s c product entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a matching s c product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Finds the last s c product entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a matching s c product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Finds the s c product entries before and after the current s c product entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productEntryId the primary key of the current s c product entry
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a s c product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry[] findByGroupId_PrevAndNext(
		long productEntryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Filters by the user's permissions and finds all the s c product entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching s c product entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the s c product entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @return the range of matching s c product entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the s c product entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching s c product entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the s c product entries where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the s c product entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @return the range of matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the s c product entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first s c product entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a matching s c product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Finds the last s c product entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a matching s c product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Finds the s c product entries before and after the current s c product entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productEntryId the primary key of the current s c product entry
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a s c product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry[] findByCompanyId_PrevAndNext(
		long productEntryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Finds all the s c product entries where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the s c product entries where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @return the range of matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the s c product entries where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first s c product entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a matching s c product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry findByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Finds the last s c product entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a matching s c product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry findByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Finds the s c product entries before and after the current s c product entry in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productEntryId the primary key of the current s c product entry
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a s c product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry[] findByG_U_PrevAndNext(
		long productEntryId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Filters by the user's permissions and finds all the s c product entries where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the matching s c product entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> filterFindByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the s c product entries where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @return the range of matching s c product entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> filterFindByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the s c product entries where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching s c product entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the s c product entry where repoGroupId = &#63; and repoArtifactId = &#63; or throws a {@link com.liferay.portlet.softwarecatalog.NoSuchProductEntryException} if it could not be found.
	*
	* @param repoGroupId the repo group id to search with
	* @param repoArtifactId the repo artifact id to search with
	* @return the matching s c product entry
	* @throws com.liferay.portlet.softwarecatalog.NoSuchProductEntryException if a matching s c product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry findByRG_RA(
		java.lang.String repoGroupId, java.lang.String repoArtifactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Finds the s c product entry where repoGroupId = &#63; and repoArtifactId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param repoGroupId the repo group id to search with
	* @param repoArtifactId the repo artifact id to search with
	* @return the matching s c product entry, or <code>null</code> if a matching s c product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry fetchByRG_RA(
		java.lang.String repoGroupId, java.lang.String repoArtifactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the s c product entry where repoGroupId = &#63; and repoArtifactId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param repoGroupId the repo group id to search with
	* @param repoArtifactId the repo artifact id to search with
	* @return the matching s c product entry, or <code>null</code> if a matching s c product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.softwarecatalog.model.SCProductEntry fetchByRG_RA(
		java.lang.String repoGroupId, java.lang.String repoArtifactId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the s c product entries.
	*
	* @return the s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the s c product entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @return the range of s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the s c product entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCProductEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s c product entries where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s c product entries where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s c product entries where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s c product entry where repoGroupId = &#63; and repoArtifactId = &#63; from the database.
	*
	* @param repoGroupId the repo group id to search with
	* @param repoArtifactId the repo artifact id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRG_RA(java.lang.String repoGroupId,
		java.lang.String repoArtifactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.softwarecatalog.NoSuchProductEntryException;

	/**
	* Removes all the s c product entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the s c product entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the s c product entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching s c product entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the s c product entries where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the s c product entries where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the number of matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the s c product entries where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the number of matching s c product entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the s c product entries where repoGroupId = &#63; and repoArtifactId = &#63;.
	*
	* @param repoGroupId the repo group id to search with
	* @param repoArtifactId the repo artifact id to search with
	* @return the number of matching s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByRG_RA(java.lang.String repoGroupId,
		java.lang.String repoArtifactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the s c product entries.
	*
	* @return the number of s c product entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the s c licenses associated with the s c product entry.
	*
	* @param pk the primary key of the s c product entry to get the associated s c licenses for
	* @return the s c licenses associated with the s c product entry
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCLicense> getSCLicenses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the s c licenses associated with the s c product entry.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the s c product entry to get the associated s c licenses for
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @return the range of s c licenses associated with the s c product entry
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCLicense> getSCLicenses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the s c licenses associated with the s c product entry.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the s c product entry to get the associated s c licenses for
	* @param start the lower bound of the range of s c product entries to return
	* @param end the upper bound of the range of s c product entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of s c licenses associated with the s c product entry
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCLicense> getSCLicenses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of s c licenses associated with the s c product entry.
	*
	* @param pk the primary key of the s c product entry to get the number of associated s c licenses for
	* @return the number of s c licenses associated with the s c product entry
	* @throws SystemException if a system exception occurred
	*/
	public int getSCLicensesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the s c license is associated with the s c product entry.
	*
	* @param pk the primary key of the s c product entry
	* @param scLicensePK the primary key of the s c license
	* @return <code>true</code> if the s c license is associated with the s c product entry; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSCLicense(long pk, long scLicensePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the s c product entry has any s c licenses associated with it.
	*
	* @param pk the primary key of the s c product entry to check for associations with s c licenses
	* @return <code>true</code> if the s c product entry has any s c licenses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSCLicenses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the s c product entry and the s c license. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry
	* @param scLicensePK the primary key of the s c license
	* @throws SystemException if a system exception occurred
	*/
	public void addSCLicense(long pk, long scLicensePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the s c product entry and the s c license. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry
	* @param scLicense the s c license
	* @throws SystemException if a system exception occurred
	*/
	public void addSCLicense(long pk,
		com.liferay.portlet.softwarecatalog.model.SCLicense scLicense)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the s c product entry and the s c licenses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry
	* @param scLicensePKs the primary keys of the s c licenses
	* @throws SystemException if a system exception occurred
	*/
	public void addSCLicenses(long pk, long[] scLicensePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the s c product entry and the s c licenses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry
	* @param scLicenses the s c licenses
	* @throws SystemException if a system exception occurred
	*/
	public void addSCLicenses(long pk,
		java.util.List<com.liferay.portlet.softwarecatalog.model.SCLicense> scLicenses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the s c product entry and its s c licenses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry to clear the associated s c licenses from
	* @throws SystemException if a system exception occurred
	*/
	public void clearSCLicenses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the s c product entry and the s c license. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry
	* @param scLicensePK the primary key of the s c license
	* @throws SystemException if a system exception occurred
	*/
	public void removeSCLicense(long pk, long scLicensePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the s c product entry and the s c license. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry
	* @param scLicense the s c license
	* @throws SystemException if a system exception occurred
	*/
	public void removeSCLicense(long pk,
		com.liferay.portlet.softwarecatalog.model.SCLicense scLicense)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the s c product entry and the s c licenses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry
	* @param scLicensePKs the primary keys of the s c licenses
	* @throws SystemException if a system exception occurred
	*/
	public void removeSCLicenses(long pk, long[] scLicensePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the s c product entry and the s c licenses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry
	* @param scLicenses the s c licenses
	* @throws SystemException if a system exception occurred
	*/
	public void removeSCLicenses(long pk,
		java.util.List<com.liferay.portlet.softwarecatalog.model.SCLicense> scLicenses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the s c licenses associated with the s c product entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry to set the associations for
	* @param scLicensePKs the primary keys of the s c licenses to be associated with the s c product entry
	* @throws SystemException if a system exception occurred
	*/
	public void setSCLicenses(long pk, long[] scLicensePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the s c licenses associated with the s c product entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the s c product entry to set the associations for
	* @param scLicenses the s c licenses to be associated with the s c product entry
	* @throws SystemException if a system exception occurred
	*/
	public void setSCLicenses(long pk,
		java.util.List<com.liferay.portlet.softwarecatalog.model.SCLicense> scLicenses)
		throws com.liferay.portal.kernel.exception.SystemException;
}