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

package com.liferay.portlet.journal.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the journal article image local service. This utility wraps {@link com.liferay.portlet.journal.service.impl.JournalArticleImageLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.journal.service.impl.JournalArticleImageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleImageLocalService
 * @see com.liferay.portlet.journal.service.base.JournalArticleImageLocalServiceBaseImpl
 * @see com.liferay.portlet.journal.service.impl.JournalArticleImageLocalServiceImpl
 * @generated
 */
public class JournalArticleImageLocalServiceUtil {
	/**
	* Adds the journal article image to the database. Also notifies the appropriate model listeners.
	*
	* @param journalArticleImage the journal article image to add
	* @return the journal article image that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.journal.model.JournalArticleImage addJournalArticleImage(
		com.liferay.portlet.journal.model.JournalArticleImage journalArticleImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addJournalArticleImage(journalArticleImage);
	}

	/**
	* Creates a new journal article image with the primary key. Does not add the journal article image to the database.
	*
	* @param articleImageId the primary key for the new journal article image
	* @return the new journal article image
	*/
	public static com.liferay.portlet.journal.model.JournalArticleImage createJournalArticleImage(
		long articleImageId) {
		return getService().createJournalArticleImage(articleImageId);
	}

	/**
	* Deletes the journal article image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articleImageId the primary key of the journal article image to delete
	* @throws PortalException if a journal article image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJournalArticleImage(long articleImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteJournalArticleImage(articleImageId);
	}

	/**
	* Deletes the journal article image from the database. Also notifies the appropriate model listeners.
	*
	* @param journalArticleImage the journal article image to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJournalArticleImage(
		com.liferay.portlet.journal.model.JournalArticleImage journalArticleImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteJournalArticleImage(journalArticleImage);
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
	* Gets the journal article image with the primary key.
	*
	* @param articleImageId the primary key of the journal article image to get
	* @return the journal article image
	* @throws PortalException if a journal article image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.journal.model.JournalArticleImage getJournalArticleImage(
		long articleImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJournalArticleImage(articleImageId);
	}

	/**
	* Gets a range of all the journal article images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of journal article images to return
	* @param end the upper bound of the range of journal article images to return (not inclusive)
	* @return the range of journal article images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.journal.model.JournalArticleImage> getJournalArticleImages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJournalArticleImages(start, end);
	}

	/**
	* Gets the number of journal article images.
	*
	* @return the number of journal article images
	* @throws SystemException if a system exception occurred
	*/
	public static int getJournalArticleImagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJournalArticleImagesCount();
	}

	/**
	* Updates the journal article image in the database. Also notifies the appropriate model listeners.
	*
	* @param journalArticleImage the journal article image to update
	* @return the journal article image that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.journal.model.JournalArticleImage updateJournalArticleImage(
		com.liferay.portlet.journal.model.JournalArticleImage journalArticleImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateJournalArticleImage(journalArticleImage);
	}

	/**
	* Updates the journal article image in the database. Also notifies the appropriate model listeners.
	*
	* @param journalArticleImage the journal article image to update
	* @param merge whether to merge the journal article image with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the journal article image that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.journal.model.JournalArticleImage updateJournalArticleImage(
		com.liferay.portlet.journal.model.JournalArticleImage journalArticleImage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateJournalArticleImage(journalArticleImage, merge);
	}

	public static void addArticleImageId(long articleImageId, long groupId,
		java.lang.String articleId, double version,
		java.lang.String elInstanceId, java.lang.String elName,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addArticleImageId(articleImageId, groupId, articleId, version,
			elInstanceId, elName, languageId);
	}

	public static void deleteArticleImage(long articleImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteArticleImage(articleImageId);
	}

	public static void deleteArticleImage(
		com.liferay.portlet.journal.model.JournalArticleImage articleImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteArticleImage(articleImage);
	}

	public static void deleteArticleImage(long groupId,
		java.lang.String articleId, double version,
		java.lang.String elInstanceId, java.lang.String elName,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteArticleImage(groupId, articleId, version, elInstanceId,
			elName, languageId);
	}

	public static void deleteImages(long groupId, java.lang.String articleId,
		double version)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteImages(groupId, articleId, version);
	}

	public static com.liferay.portlet.journal.model.JournalArticleImage getArticleImage(
		long articleImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticleImage(articleImageId);
	}

	public static long getArticleImageId(long groupId,
		java.lang.String articleId, double version,
		java.lang.String elInstanceId, java.lang.String elName,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getArticleImageId(groupId, articleId, version,
			elInstanceId, elName, languageId);
	}

	public static long getArticleImageId(long groupId,
		java.lang.String articleId, double version,
		java.lang.String elInstanceId, java.lang.String elName,
		java.lang.String languageId, boolean tempImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getArticleImageId(groupId, articleId, version,
			elInstanceId, elName, languageId, tempImage);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalArticleImage> getArticleImages(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticleImages(groupId);
	}

	public static JournalArticleImageLocalService getService() {
		if (_service == null) {
			_service = (JournalArticleImageLocalService)PortalBeanLocatorUtil.locate(JournalArticleImageLocalService.class.getName());
		}

		return _service;
	}

	public void setService(JournalArticleImageLocalService service) {
		_service = service;
	}

	private static JournalArticleImageLocalService _service;
}