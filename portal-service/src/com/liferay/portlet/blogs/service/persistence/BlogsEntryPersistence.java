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

package com.liferay.portlet.blogs.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.portlet.blogs.model.BlogsEntry;

/**
 * The persistence interface for the blogs entry service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link BlogsEntryUtil} to access the blogs entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlogsEntryPersistenceImpl
 * @see BlogsEntryUtil
 * @generated
 */
public interface BlogsEntryPersistence extends BasePersistence<BlogsEntry> {
	/**
	* Caches the blogs entry in the entity cache if it is enabled.
	*
	* @param blogsEntry the blogs entry to cache
	*/
	public void cacheResult(
		com.liferay.portlet.blogs.model.BlogsEntry blogsEntry);

	/**
	* Caches the blogs entries in the entity cache if it is enabled.
	*
	* @param blogsEntries the blogs entries to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> blogsEntries);

	/**
	* Creates a new blogs entry with the primary key. Does not add the blogs entry to the database.
	*
	* @param entryId the primary key for the new blogs entry
	* @return the new blogs entry
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry create(long entryId);

	/**
	* Removes the blogs entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the blogs entry to remove
	* @return the blogs entry that was removed
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry remove(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	public com.liferay.portlet.blogs.model.BlogsEntry updateImpl(
		com.liferay.portlet.blogs.model.BlogsEntry blogsEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the blogs entry with the primary key or throws a {@link com.liferay.portlet.blogs.NoSuchEntryException} if it could not be found.
	*
	* @param entryId the primary key of the blogs entry to find
	* @return the blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the blogs entry to find
	* @return the blogs entry, or <code>null</code> if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the blogs entries where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByUuid_PrevAndNext(
		long entryId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entry where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portlet.blogs.NoSuchEntryException} if it could not be found.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching blogs entry, or <code>null</code> if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the blogs entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching blogs entry, or <code>null</code> if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the blogs entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByGroupId_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the blogs entries where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByCompanyId_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds all the blogs entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U(
		long companyId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByC_U_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByC_U_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByC_U_PrevAndNext(
		long entryId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds all the blogs entries where companyId = &#63; and displayDate &lt; &#63;.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD(
		long companyId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where companyId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD(
		long companyId, java.util.Date displayDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD(
		long companyId, java.util.Date displayDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByC_LtD_First(
		long companyId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByC_LtD_Last(
		long companyId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByC_LtD_PrevAndNext(
		long entryId, long companyId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds all the blogs entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_S(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_S(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByC_S_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByC_S_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByC_S_PrevAndNext(
		long entryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entry where groupId = &#63; and urlTitle = &#63; or throws a {@link com.liferay.portlet.blogs.NoSuchEntryException} if it could not be found.
	*
	* @param groupId the group id to search with
	* @param urlTitle the url title to search with
	* @return the matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_UT(long groupId,
		java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group id to search with
	* @param urlTitle the url title to search with
	* @return the matching blogs entry, or <code>null</code> if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry fetchByG_UT(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the blogs entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group id to search with
	* @param urlTitle the url title to search with
	* @return the matching blogs entry, or <code>null</code> if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry fetchByG_UT(
		long groupId, java.lang.String urlTitle, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD(
		long groupId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD(
		long groupId, java.util.Date displayDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD(
		long groupId, java.util.Date displayDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_LtD_First(
		long groupId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_LtD_Last(
		long groupId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByG_LtD_PrevAndNext(
		long entryId, long groupId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD(
		long groupId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD(
		long groupId, java.util.Date displayDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD(
		long groupId, java.util.Date displayDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByG_S_PrevAndNext(
		long entryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the blogs entries where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U_S(
		long companyId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByC_U_S_First(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByC_U_S_Last(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByC_U_S_PrevAndNext(
		long entryId, long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds all the blogs entries where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD_S(
		long companyId, java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD_S(
		long companyId, java.util.Date displayDate, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD_S(
		long companyId, java.util.Date displayDate, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByC_LtD_S_First(
		long companyId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByC_LtD_S_Last(
		long companyId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByC_LtD_S_PrevAndNext(
		long entryId, long companyId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_U_LtD_First(
		long groupId, long userId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_U_LtD_Last(
		long groupId, long userId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByG_U_LtD_PrevAndNext(
		long entryId, long groupId, long userId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_S(
		long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByG_U_S_PrevAndNext(
		long entryId, long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_S(
		long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD_S(
		long groupId, java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD_S(
		long groupId, java.util.Date displayDate, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD_S(
		long groupId, java.util.Date displayDate, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_LtD_S_First(
		long groupId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_LtD_S_Last(
		long groupId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByG_LtD_S_PrevAndNext(
		long entryId, long groupId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD_S(
		long groupId, java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD_S(
		long groupId, java.util.Date displayDate, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD_S(
		long groupId, java.util.Date displayDate, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_U_LtD_S_First(
		long groupId, long userId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry findByG_U_LtD_S_Last(
		long groupId, long userId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.blogs.model.BlogsEntry[] findByG_U_LtD_S_PrevAndNext(
		long entryId, long groupId, long userId, java.util.Date displayDate,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the blogs entries.
	*
	* @return the blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the blogs entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the blogs entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the blogs entry where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Removes all the blogs entries where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_U(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where companyId = &#63; and displayDate &lt; &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_LtD(long companyId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_S(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the blogs entry where groupId = &#63; and urlTitle = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param urlTitle the url title to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_UT(long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException;

	/**
	* Removes all the blogs entries where groupId = &#63; and displayDate &lt; &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_LtD(long groupId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_U_S(long companyId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where companyId = &#63; and displayDate &lt; &#63; and status = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_LtD_S(long companyId, java.util.Date displayDate,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U_LtD(long groupId, long userId,
		java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U_S(long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_LtD_S(long groupId, java.util.Date displayDate,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U_LtD_S(long groupId, long userId,
		java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the blogs entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_U(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where companyId = &#63; and displayDate &lt; &#63;.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_LtD(long companyId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_S(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group id to search with
	* @param urlTitle the url title to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_UT(long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_LtD(long groupId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_LtD(long groupId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_U_S(long companyId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_LtD_S(long companyId, java.util.Date displayDate,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U_LtD(long groupId, long userId,
		java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_U_LtD(long groupId, long userId,
		java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U_S(long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_U_S(long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_LtD_S(long groupId, java.util.Date displayDate,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_LtD_S(long groupId, java.util.Date displayDate,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U_LtD_S(long groupId, long userId,
		java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_U_LtD_S(long groupId, long userId,
		java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the blogs entries.
	*
	* @return the number of blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}