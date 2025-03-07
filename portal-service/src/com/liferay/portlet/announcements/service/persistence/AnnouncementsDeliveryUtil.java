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

package com.liferay.portlet.announcements.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.announcements.model.AnnouncementsDelivery;

import java.util.List;

/**
 * The persistence utility for the announcements delivery service. This utility wraps {@link AnnouncementsDeliveryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnnouncementsDeliveryPersistence
 * @see AnnouncementsDeliveryPersistenceImpl
 * @generated
 */
public class AnnouncementsDeliveryUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AnnouncementsDelivery announcementsDelivery) {
		getPersistence().clearCache(announcementsDelivery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AnnouncementsDelivery> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnnouncementsDelivery> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnnouncementsDelivery> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static AnnouncementsDelivery remove(
		AnnouncementsDelivery announcementsDelivery) throws SystemException {
		return getPersistence().remove(announcementsDelivery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AnnouncementsDelivery update(
		AnnouncementsDelivery announcementsDelivery, boolean merge)
		throws SystemException {
		return getPersistence().update(announcementsDelivery, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AnnouncementsDelivery update(
		AnnouncementsDelivery announcementsDelivery, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(announcementsDelivery, merge, serviceContext);
	}

	/**
	* Caches the announcements delivery in the entity cache if it is enabled.
	*
	* @param announcementsDelivery the announcements delivery to cache
	*/
	public static void cacheResult(
		com.liferay.portlet.announcements.model.AnnouncementsDelivery announcementsDelivery) {
		getPersistence().cacheResult(announcementsDelivery);
	}

	/**
	* Caches the announcements deliveries in the entity cache if it is enabled.
	*
	* @param announcementsDeliveries the announcements deliveries to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.announcements.model.AnnouncementsDelivery> announcementsDeliveries) {
		getPersistence().cacheResult(announcementsDeliveries);
	}

	/**
	* Creates a new announcements delivery with the primary key. Does not add the announcements delivery to the database.
	*
	* @param deliveryId the primary key for the new announcements delivery
	* @return the new announcements delivery
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery create(
		long deliveryId) {
		return getPersistence().create(deliveryId);
	}

	/**
	* Removes the announcements delivery with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deliveryId the primary key of the announcements delivery to remove
	* @return the announcements delivery that was removed
	* @throws com.liferay.portlet.announcements.NoSuchDeliveryException if a announcements delivery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery remove(
		long deliveryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchDeliveryException {
		return getPersistence().remove(deliveryId);
	}

	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery updateImpl(
		com.liferay.portlet.announcements.model.AnnouncementsDelivery announcementsDelivery,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(announcementsDelivery, merge);
	}

	/**
	* Finds the announcements delivery with the primary key or throws a {@link com.liferay.portlet.announcements.NoSuchDeliveryException} if it could not be found.
	*
	* @param deliveryId the primary key of the announcements delivery to find
	* @return the announcements delivery
	* @throws com.liferay.portlet.announcements.NoSuchDeliveryException if a announcements delivery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery findByPrimaryKey(
		long deliveryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchDeliveryException {
		return getPersistence().findByPrimaryKey(deliveryId);
	}

	/**
	* Finds the announcements delivery with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param deliveryId the primary key of the announcements delivery to find
	* @return the announcements delivery, or <code>null</code> if a announcements delivery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery fetchByPrimaryKey(
		long deliveryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(deliveryId);
	}

	/**
	* Finds all the announcements deliveries where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the matching announcements deliveries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.announcements.model.AnnouncementsDelivery> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Finds a range of all the announcements deliveries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of announcements deliveries to return
	* @param end the upper bound of the range of announcements deliveries to return (not inclusive)
	* @return the range of matching announcements deliveries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.announcements.model.AnnouncementsDelivery> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Finds an ordered range of all the announcements deliveries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of announcements deliveries to return
	* @param end the upper bound of the range of announcements deliveries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching announcements deliveries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.announcements.model.AnnouncementsDelivery> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Finds the first announcements delivery in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching announcements delivery
	* @throws com.liferay.portlet.announcements.NoSuchDeliveryException if a matching announcements delivery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchDeliveryException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Finds the last announcements delivery in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching announcements delivery
	* @throws com.liferay.portlet.announcements.NoSuchDeliveryException if a matching announcements delivery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchDeliveryException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Finds the announcements deliveries before and after the current announcements delivery in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param deliveryId the primary key of the current announcements delivery
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next announcements delivery
	* @throws com.liferay.portlet.announcements.NoSuchDeliveryException if a announcements delivery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery[] findByUserId_PrevAndNext(
		long deliveryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchDeliveryException {
		return getPersistence()
				   .findByUserId_PrevAndNext(deliveryId, userId,
			orderByComparator);
	}

	/**
	* Finds the announcements delivery where userId = &#63; and type = &#63; or throws a {@link com.liferay.portlet.announcements.NoSuchDeliveryException} if it could not be found.
	*
	* @param userId the user id to search with
	* @param type the type to search with
	* @return the matching announcements delivery
	* @throws com.liferay.portlet.announcements.NoSuchDeliveryException if a matching announcements delivery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery findByU_T(
		long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchDeliveryException {
		return getPersistence().findByU_T(userId, type);
	}

	/**
	* Finds the announcements delivery where userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user id to search with
	* @param type the type to search with
	* @return the matching announcements delivery, or <code>null</code> if a matching announcements delivery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery fetchByU_T(
		long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByU_T(userId, type);
	}

	/**
	* Finds the announcements delivery where userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user id to search with
	* @param type the type to search with
	* @return the matching announcements delivery, or <code>null</code> if a matching announcements delivery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery fetchByU_T(
		long userId, java.lang.String type, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByU_T(userId, type, retrieveFromCache);
	}

	/**
	* Finds all the announcements deliveries.
	*
	* @return the announcements deliveries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.announcements.model.AnnouncementsDelivery> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the announcements deliveries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of announcements deliveries to return
	* @param end the upper bound of the range of announcements deliveries to return (not inclusive)
	* @return the range of announcements deliveries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.announcements.model.AnnouncementsDelivery> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the announcements deliveries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of announcements deliveries to return
	* @param end the upper bound of the range of announcements deliveries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of announcements deliveries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.announcements.model.AnnouncementsDelivery> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the announcements deliveries where userId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes the announcements delivery where userId = &#63; and type = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param type the type to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_T(long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchDeliveryException {
		getPersistence().removeByU_T(userId, type);
	}

	/**
	* Removes all the announcements deliveries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the announcements deliveries where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the number of matching announcements deliveries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Counts all the announcements deliveries where userId = &#63; and type = &#63;.
	*
	* @param userId the user id to search with
	* @param type the type to search with
	* @return the number of matching announcements deliveries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_T(long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_T(userId, type);
	}

	/**
	* Counts all the announcements deliveries.
	*
	* @return the number of announcements deliveries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AnnouncementsDeliveryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AnnouncementsDeliveryPersistence)PortalBeanLocatorUtil.locate(AnnouncementsDeliveryPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(AnnouncementsDeliveryPersistence persistence) {
		_persistence = persistence;
	}

	private static AnnouncementsDeliveryPersistence _persistence;
}