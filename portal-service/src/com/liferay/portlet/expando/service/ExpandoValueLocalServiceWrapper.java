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

package com.liferay.portlet.expando.service;

/**
 * <p>
 * This class is a wrapper for {@link ExpandoValueLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ExpandoValueLocalService
 * @generated
 */
public class ExpandoValueLocalServiceWrapper implements ExpandoValueLocalService {
	public ExpandoValueLocalServiceWrapper(
		ExpandoValueLocalService expandoValueLocalService) {
		_expandoValueLocalService = expandoValueLocalService;
	}

	/**
	* Adds the expando value to the database. Also notifies the appropriate model listeners.
	*
	* @param expandoValue the expando value to add
	* @return the expando value that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addExpandoValue(
		com.liferay.portlet.expando.model.ExpandoValue expandoValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addExpandoValue(expandoValue);
	}

	/**
	* Creates a new expando value with the primary key. Does not add the expando value to the database.
	*
	* @param valueId the primary key for the new expando value
	* @return the new expando value
	*/
	public com.liferay.portlet.expando.model.ExpandoValue createExpandoValue(
		long valueId) {
		return _expandoValueLocalService.createExpandoValue(valueId);
	}

	/**
	* Deletes the expando value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param valueId the primary key of the expando value to delete
	* @throws PortalException if a expando value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteExpandoValue(long valueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteExpandoValue(valueId);
	}

	/**
	* Deletes the expando value from the database. Also notifies the appropriate model listeners.
	*
	* @param expandoValue the expando value to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteExpandoValue(
		com.liferay.portlet.expando.model.ExpandoValue expandoValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteExpandoValue(expandoValue);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the expando value with the primary key.
	*
	* @param valueId the primary key of the expando value to get
	* @return the expando value
	* @throws PortalException if a expando value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.expando.model.ExpandoValue getExpandoValue(
		long valueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getExpandoValue(valueId);
	}

	/**
	* Gets a range of all the expando values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of expando values to return
	* @param end the upper bound of the range of expando values to return (not inclusive)
	* @return the range of expando values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getExpandoValues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getExpandoValues(start, end);
	}

	/**
	* Gets the number of expando values.
	*
	* @return the number of expando values
	* @throws SystemException if a system exception occurred
	*/
	public int getExpandoValuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getExpandoValuesCount();
	}

	/**
	* Updates the expando value in the database. Also notifies the appropriate model listeners.
	*
	* @param expandoValue the expando value to update
	* @return the expando value that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.expando.model.ExpandoValue updateExpandoValue(
		com.liferay.portlet.expando.model.ExpandoValue expandoValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.updateExpandoValue(expandoValue);
	}

	/**
	* Updates the expando value in the database. Also notifies the appropriate model listeners.
	*
	* @param expandoValue the expando value to update
	* @param merge whether to merge the expando value with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the expando value that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.expando.model.ExpandoValue updateExpandoValue(
		com.liferay.portlet.expando.model.ExpandoValue expandoValue,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.updateExpandoValue(expandoValue, merge);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long classNameId, long tableId, long columnId, long classPK,
		java.lang.String data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(classNameId, tableId,
			columnId, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, boolean data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, boolean[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.util.Date data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.util.Date[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, double data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, double[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, float data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, float[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, int data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, int[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, long data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, long[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.lang.Object data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, short data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, short[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.lang.String data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.lang.String[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(companyId, className,
			tableName, columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long,
	boolean[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, boolean data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long,
	boolean[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, boolean[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long, Date[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.util.Date data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long, Date[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.util.Date[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long,
	double[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, double data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long,
	double[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, double[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long,
	float[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, float data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long,
	float[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, float[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long, int[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, int data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long, int[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, int[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long, long[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, long data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long, long[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, long[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long, Object)}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.lang.Object data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long,
	short[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, short data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long,
	short[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, short[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long,
	String[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.lang.String data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	/**
	* @deprecated {@link #addValue(long, String, String, String, long,
	String[])}
	*/
	public com.liferay.portlet.expando.model.ExpandoValue addValue(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, java.lang.String[] data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.addValue(className, tableName,
			columnName, classPK, data);
	}

	public void addValues(long classNameId, long tableId,
		java.util.List<com.liferay.portlet.expando.model.ExpandoColumn> columns,
		long classPK, java.util.Map<java.lang.String, java.lang.String> data)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.addValues(classNameId, tableId, columns,
			classPK, data);
	}

	public void deleteColumnValues(long columnId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteColumnValues(columnId);
	}

	public void deleteRowValues(long rowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteRowValues(rowId);
	}

	public void deleteTableValues(long tableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteTableValues(tableId);
	}

	public void deleteValue(long valueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteValue(valueId);
	}

	public void deleteValue(long columnId, long rowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteValue(columnId, rowId);
	}

	public void deleteValue(long companyId, long classNameId,
		java.lang.String tableName, java.lang.String columnName, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteValue(companyId, classNameId,
			tableName, columnName, classPK);
	}

	public void deleteValue(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteValue(companyId, className, tableName,
			columnName, classPK);
	}

	public void deleteValues(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteValues(classNameId, classPK);
	}

	public void deleteValues(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		_expandoValueLocalService.deleteValues(className, classPK);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getColumnValues(
		long columnId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getColumnValues(columnId, start, end);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getColumnValues(
		long companyId, long classNameId, java.lang.String tableName,
		java.lang.String columnName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getColumnValues(companyId,
			classNameId, tableName, columnName, start, end);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getColumnValues(
		long companyId, long classNameId, java.lang.String tableName,
		java.lang.String columnName, java.lang.String data, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getColumnValues(companyId,
			classNameId, tableName, columnName, data, start, end);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getColumnValues(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getColumnValues(companyId, className,
			tableName, columnName, start, end);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getColumnValues(
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, java.lang.String data, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getColumnValues(className, tableName,
			columnName, data, start, end);
	}

	public int getColumnValuesCount(long columnId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getColumnValuesCount(columnId);
	}

	public int getColumnValuesCount(long companyId, long classNameId,
		java.lang.String tableName, java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getColumnValuesCount(companyId,
			classNameId, tableName, columnName);
	}

	public int getColumnValuesCount(long companyId, long classNameId,
		java.lang.String tableName, java.lang.String columnName,
		java.lang.String data)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getColumnValuesCount(companyId,
			classNameId, tableName, columnName, data);
	}

	public int getColumnValuesCount(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getColumnValuesCount(companyId,
			className, tableName, columnName);
	}

	public int getColumnValuesCount(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName,
		java.lang.String data)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getColumnValuesCount(className,
			tableName, columnName, data);
	}

	public java.io.Serializable getData(long companyId,
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK);
	}

	public boolean getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		boolean defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public boolean[] getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		boolean[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public java.util.Date getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		java.util.Date defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public java.util.Date[] getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		java.util.Date[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public double getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		double defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public double[] getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		double[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public float getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		float defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public float[] getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		float[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public int getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		int defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public int[] getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		int[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public long getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		long defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public long[] getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		long[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public short getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		short defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public short[] getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		short[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public java.lang.String getData(long companyId, java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		java.lang.String defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	public java.lang.String[] getData(long companyId,
		java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK,
		java.lang.String[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(companyId, className,
			tableName, columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long)}
	*/
	public java.io.Serializable getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long,
	boolean[])}
	*/
	public boolean getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		boolean defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long,
	boolean[])}
	*/
	public boolean[] getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		boolean[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long, Date[])}
	*/
	public java.util.Date getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		java.util.Date defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long, Date[])}
	*/
	public java.util.Date[] getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		java.util.Date[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long,
	double[])}
	*/
	public double getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		double defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long,
	double[])}
	*/
	public double[] getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		double[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long, float[])}
	*/
	public float getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		float defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long, float[])}
	*/
	public float[] getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		float[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long, int[])}
	*/
	public int getData(java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, int defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long, int[])}
	*/
	public int[] getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		int[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long, long[])}
	*/
	public long getData(java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK, long defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long, long[])}
	*/
	public long[] getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		long[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long, short[])}
	*/
	public short getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		short defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long, short[])}
	*/
	public short[] getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		short[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long,
	String[])}
	*/
	public java.lang.String getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		java.lang.String defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	/**
	* @deprecated {@link #getData(long, String, String, String, long,
	String[])}
	*/
	public java.lang.String[] getData(java.lang.String className,
		java.lang.String tableName, java.lang.String columnName, long classPK,
		java.lang.String[] defaultData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getData(className, tableName,
			columnName, classPK, defaultData);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getDefaultTableColumnValues(
		long companyId, long classNameId, java.lang.String columnName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getDefaultTableColumnValues(companyId,
			classNameId, columnName, start, end);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getDefaultTableColumnValues(
		long companyId, java.lang.String className,
		java.lang.String columnName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getDefaultTableColumnValues(companyId,
			className, columnName, start, end);
	}

	public int getDefaultTableColumnValuesCount(long companyId,
		long classNameId, java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getDefaultTableColumnValuesCount(companyId,
			classNameId, columnName);
	}

	public int getDefaultTableColumnValuesCount(long companyId,
		java.lang.String className, java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getDefaultTableColumnValuesCount(companyId,
			className, columnName);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getRowValues(
		long rowId) throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getRowValues(rowId);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getRowValues(
		long rowId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getRowValues(rowId, start, end);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getRowValues(
		long companyId, long classNameId, java.lang.String tableName,
		long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getRowValues(companyId, classNameId,
			tableName, classPK, start, end);
	}

	public java.util.List<com.liferay.portlet.expando.model.ExpandoValue> getRowValues(
		long companyId, java.lang.String className, java.lang.String tableName,
		long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getRowValues(companyId, className,
			tableName, classPK, start, end);
	}

	public int getRowValuesCount(long rowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getRowValuesCount(rowId);
	}

	public int getRowValuesCount(long companyId, long classNameId,
		java.lang.String tableName, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getRowValuesCount(companyId,
			classNameId, tableName, classPK);
	}

	public int getRowValuesCount(long companyId, java.lang.String className,
		java.lang.String tableName, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getRowValuesCount(companyId,
			className, tableName, classPK);
	}

	public com.liferay.portlet.expando.model.ExpandoValue getValue(long valueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getValue(valueId);
	}

	public com.liferay.portlet.expando.model.ExpandoValue getValue(
		long columnId, long rowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getValue(columnId, rowId);
	}

	public com.liferay.portlet.expando.model.ExpandoValue getValue(
		long tableId, long columnId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getValue(tableId, columnId, classPK);
	}

	public com.liferay.portlet.expando.model.ExpandoValue getValue(
		long companyId, long classNameId, java.lang.String tableName,
		java.lang.String columnName, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getValue(companyId, classNameId,
			tableName, columnName, classPK);
	}

	public com.liferay.portlet.expando.model.ExpandoValue getValue(
		long companyId, java.lang.String className, java.lang.String tableName,
		java.lang.String columnName, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expandoValueLocalService.getValue(companyId, className,
			tableName, columnName, classPK);
	}

	public ExpandoValueLocalService getWrappedExpandoValueLocalService() {
		return _expandoValueLocalService;
	}

	private ExpandoValueLocalService _expandoValueLocalService;
}