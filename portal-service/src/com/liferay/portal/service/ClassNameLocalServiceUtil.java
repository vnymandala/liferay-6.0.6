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

package com.liferay.portal.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the class name local service. This utility wraps {@link com.liferay.portal.service.impl.ClassNameLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.ClassNameLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClassNameLocalService
 * @see com.liferay.portal.service.base.ClassNameLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.ClassNameLocalServiceImpl
 * @generated
 */
public class ClassNameLocalServiceUtil {
	/**
	* Adds the class name to the database. Also notifies the appropriate model listeners.
	*
	* @param className the class name to add
	* @return the class name that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.ClassName addClassName(
		com.liferay.portal.model.ClassName className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addClassName(className);
	}

	/**
	* Creates a new class name with the primary key. Does not add the class name to the database.
	*
	* @param classNameId the primary key for the new class name
	* @return the new class name
	*/
	public static com.liferay.portal.model.ClassName createClassName(
		long classNameId) {
		return getService().createClassName(classNameId);
	}

	/**
	* Deletes the class name with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param classNameId the primary key of the class name to delete
	* @throws PortalException if a class name with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteClassName(long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteClassName(classNameId);
	}

	/**
	* Deletes the class name from the database. Also notifies the appropriate model listeners.
	*
	* @param className the class name to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteClassName(
		com.liferay.portal.model.ClassName className)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteClassName(className);
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
	* Gets the class name with the primary key.
	*
	* @param classNameId the primary key of the class name to get
	* @return the class name
	* @throws PortalException if a class name with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.ClassName getClassName(
		long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassName(classNameId);
	}

	/**
	* Gets a range of all the class names.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of class names to return
	* @param end the upper bound of the range of class names to return (not inclusive)
	* @return the range of class names
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.ClassName> getClassNames(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassNames(start, end);
	}

	/**
	* Gets the number of class names.
	*
	* @return the number of class names
	* @throws SystemException if a system exception occurred
	*/
	public static int getClassNamesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassNamesCount();
	}

	/**
	* Updates the class name in the database. Also notifies the appropriate model listeners.
	*
	* @param className the class name to update
	* @return the class name that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.ClassName updateClassName(
		com.liferay.portal.model.ClassName className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateClassName(className);
	}

	/**
	* Updates the class name in the database. Also notifies the appropriate model listeners.
	*
	* @param className the class name to update
	* @param merge whether to merge the class name with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the class name that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.ClassName updateClassName(
		com.liferay.portal.model.ClassName className, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateClassName(className, merge);
	}

	public static com.liferay.portal.model.ClassName addClassName(
		java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addClassName(value);
	}

	public static void checkClassNames()
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().checkClassNames();
	}

	public static com.liferay.portal.model.ClassName getClassName(
		java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassName(value);
	}

	public static long getClassNameId(java.lang.Class<?> classObj) {
		return getService().getClassNameId(classObj);
	}

	public static long getClassNameId(java.lang.String value) {
		return getService().getClassNameId(value);
	}

	public static ClassNameLocalService getService() {
		if (_service == null) {
			_service = (ClassNameLocalService)PortalBeanLocatorUtil.locate(ClassNameLocalService.class.getName());
		}

		return _service;
	}

	public void setService(ClassNameLocalService service) {
		_service = service;
	}

	private static ClassNameLocalService _service;
}