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

package com.liferay.portlet.announcements.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the announcements delivery local service. This utility wraps {@link com.liferay.portlet.announcements.service.impl.AnnouncementsDeliveryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.announcements.service.impl.AnnouncementsDeliveryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnnouncementsDeliveryLocalService
 * @see com.liferay.portlet.announcements.service.base.AnnouncementsDeliveryLocalServiceBaseImpl
 * @see com.liferay.portlet.announcements.service.impl.AnnouncementsDeliveryLocalServiceImpl
 * @generated
 */
public class AnnouncementsDeliveryLocalServiceUtil {
	/**
	* Adds the announcements delivery to the database. Also notifies the appropriate model listeners.
	*
	* @param announcementsDelivery the announcements delivery to add
	* @return the announcements delivery that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery addAnnouncementsDelivery(
		com.liferay.portlet.announcements.model.AnnouncementsDelivery announcementsDelivery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAnnouncementsDelivery(announcementsDelivery);
	}

	/**
	* Creates a new announcements delivery with the primary key. Does not add the announcements delivery to the database.
	*
	* @param deliveryId the primary key for the new announcements delivery
	* @return the new announcements delivery
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery createAnnouncementsDelivery(
		long deliveryId) {
		return getService().createAnnouncementsDelivery(deliveryId);
	}

	/**
	* Deletes the announcements delivery with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deliveryId the primary key of the announcements delivery to delete
	* @throws PortalException if a announcements delivery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteAnnouncementsDelivery(long deliveryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAnnouncementsDelivery(deliveryId);
	}

	/**
	* Deletes the announcements delivery from the database. Also notifies the appropriate model listeners.
	*
	* @param announcementsDelivery the announcements delivery to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteAnnouncementsDelivery(
		com.liferay.portlet.announcements.model.AnnouncementsDelivery announcementsDelivery)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAnnouncementsDelivery(announcementsDelivery);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the announcements delivery with the primary key.
	*
	* @param deliveryId the primary key of the announcements delivery to get
	* @return the announcements delivery
	* @throws PortalException if a announcements delivery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery getAnnouncementsDelivery(
		long deliveryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnnouncementsDelivery(deliveryId);
	}

	/**
	* Gets a range of all the announcements deliveries.
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
	public static java.util.List<com.liferay.portlet.announcements.model.AnnouncementsDelivery> getAnnouncementsDeliveries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnnouncementsDeliveries(start, end);
	}

	/**
	* Gets the number of announcements deliveries.
	*
	* @return the number of announcements deliveries
	* @throws SystemException if a system exception occurred
	*/
	public static int getAnnouncementsDeliveriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnnouncementsDeliveriesCount();
	}

	/**
	* Updates the announcements delivery in the database. Also notifies the appropriate model listeners.
	*
	* @param announcementsDelivery the announcements delivery to update
	* @return the announcements delivery that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery updateAnnouncementsDelivery(
		com.liferay.portlet.announcements.model.AnnouncementsDelivery announcementsDelivery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAnnouncementsDelivery(announcementsDelivery);
	}

	/**
	* Updates the announcements delivery in the database. Also notifies the appropriate model listeners.
	*
	* @param announcementsDelivery the announcements delivery to update
	* @param merge whether to merge the announcements delivery with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the announcements delivery that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery updateAnnouncementsDelivery(
		com.liferay.portlet.announcements.model.AnnouncementsDelivery announcementsDelivery,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateAnnouncementsDelivery(announcementsDelivery, merge);
	}

	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery addUserDelivery(
		long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserDelivery(userId, type);
	}

	public static void deleteDeliveries(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDeliveries(userId);
	}

	public static void deleteDelivery(long deliveryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDelivery(deliveryId);
	}

	public static void deleteDelivery(long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDelivery(userId, type);
	}

	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery getDelivery(
		long deliveryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDelivery(deliveryId);
	}

	public static java.util.List<com.liferay.portlet.announcements.model.AnnouncementsDelivery> getUserDeliveries(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserDeliveries(userId);
	}

	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery getUserDelivery(
		long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserDelivery(userId, type);
	}

	public static com.liferay.portlet.announcements.model.AnnouncementsDelivery updateDelivery(
		long userId, java.lang.String type, boolean email, boolean sms,
		boolean website)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDelivery(userId, type, email, sms, website);
	}

	public static AnnouncementsDeliveryLocalService getService() {
		if (_service == null) {
			_service = (AnnouncementsDeliveryLocalService)PortalBeanLocatorUtil.locate(AnnouncementsDeliveryLocalService.class.getName());
		}

		return _service;
	}

	public void setService(AnnouncementsDeliveryLocalService service) {
		_service = service;
	}

	private static AnnouncementsDeliveryLocalService _service;
}