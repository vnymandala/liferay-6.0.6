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

package com.liferay.portlet.messageboards.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the message boards ban local service. This utility wraps {@link com.liferay.portlet.messageboards.service.impl.MBBanLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.messageboards.service.impl.MBBanLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBBanLocalService
 * @see com.liferay.portlet.messageboards.service.base.MBBanLocalServiceBaseImpl
 * @see com.liferay.portlet.messageboards.service.impl.MBBanLocalServiceImpl
 * @generated
 */
public class MBBanLocalServiceUtil {
	/**
	* Adds the message boards ban to the database. Also notifies the appropriate model listeners.
	*
	* @param mbBan the message boards ban to add
	* @return the message boards ban that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan addMBBan(
		com.liferay.portlet.messageboards.model.MBBan mbBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMBBan(mbBan);
	}

	/**
	* Creates a new message boards ban with the primary key. Does not add the message boards ban to the database.
	*
	* @param banId the primary key for the new message boards ban
	* @return the new message boards ban
	*/
	public static com.liferay.portlet.messageboards.model.MBBan createMBBan(
		long banId) {
		return getService().createMBBan(banId);
	}

	/**
	* Deletes the message boards ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param banId the primary key of the message boards ban to delete
	* @throws PortalException if a message boards ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMBBan(long banId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMBBan(banId);
	}

	/**
	* Deletes the message boards ban from the database. Also notifies the appropriate model listeners.
	*
	* @param mbBan the message boards ban to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMBBan(
		com.liferay.portlet.messageboards.model.MBBan mbBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMBBan(mbBan);
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
	* Gets the message boards ban with the primary key.
	*
	* @param banId the primary key of the message boards ban to get
	* @return the message boards ban
	* @throws PortalException if a message boards ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan getMBBan(
		long banId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMBBan(banId);
	}

	/**
	* Gets a range of all the message boards bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of message boards bans to return
	* @param end the upper bound of the range of message boards bans to return (not inclusive)
	* @return the range of message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> getMBBans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMBBans(start, end);
	}

	/**
	* Gets the number of message boards bans.
	*
	* @return the number of message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static int getMBBansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMBBansCount();
	}

	/**
	* Updates the message boards ban in the database. Also notifies the appropriate model listeners.
	*
	* @param mbBan the message boards ban to update
	* @return the message boards ban that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan updateMBBan(
		com.liferay.portlet.messageboards.model.MBBan mbBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMBBan(mbBan);
	}

	/**
	* Updates the message boards ban in the database. Also notifies the appropriate model listeners.
	*
	* @param mbBan the message boards ban to update
	* @param merge whether to merge the message boards ban with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the message boards ban that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan updateMBBan(
		com.liferay.portlet.messageboards.model.MBBan mbBan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMBBan(mbBan, merge);
	}

	public static com.liferay.portlet.messageboards.model.MBBan addBan(
		long userId, long banUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addBan(userId, banUserId, serviceContext);
	}

	public static void checkBan(long groupId, long banUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().checkBan(groupId, banUserId);
	}

	public static void deleteBan(long banUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBan(banUserId, serviceContext);
	}

	public static void deleteBansByBanUserId(long banUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBansByBanUserId(banUserId);
	}

	public static void deleteBansByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBansByGroupId(groupId);
	}

	public static void expireBans()
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().expireBans();
	}

	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> getBans(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBans(groupId, start, end);
	}

	public static int getBansCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBansCount(groupId);
	}

	public static boolean hasBan(long groupId, long banUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasBan(groupId, banUserId);
	}

	public static MBBanLocalService getService() {
		if (_service == null) {
			_service = (MBBanLocalService)PortalBeanLocatorUtil.locate(MBBanLocalService.class.getName());
		}

		return _service;
	}

	public void setService(MBBanLocalService service) {
		_service = service;
	}

	private static MBBanLocalService _service;
}