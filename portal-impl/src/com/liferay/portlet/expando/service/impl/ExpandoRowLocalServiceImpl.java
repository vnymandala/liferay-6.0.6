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

package com.liferay.portlet.expando.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.base.ExpandoRowLocalServiceBaseImpl;

import java.util.Collections;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Wesley Gong
 */
public class ExpandoRowLocalServiceImpl extends ExpandoRowLocalServiceBaseImpl {

	public ExpandoRow addRow(long tableId, long classPK)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTablePersistence.findByPrimaryKey(tableId);

		long rowId = counterLocalService.increment();

		ExpandoRow row = expandoRowPersistence.create(rowId);

		row.setCompanyId(table.getCompanyId());
		row.setTableId(tableId);
		row.setClassPK(classPK);

		expandoRowPersistence.update(row, false);

		return row;
	}

	public void deleteRow(long rowId)
		throws PortalException, SystemException {

		// Row

		expandoRowPersistence.remove(rowId);

		// Values

		expandoValueLocalService.deleteRowValues(rowId);
	}

	public void deleteRow(long tableId, long classPK)
		throws PortalException, SystemException {

		ExpandoRow row = expandoRowPersistence.findByT_C(tableId, classPK);

		deleteRow(row.getRowId());
	}

	public void deleteRow(
			long companyId, long classNameId, String tableName, long classPK)
		throws PortalException, SystemException {

		ExpandoTable table = expandoTableLocalService.getTable(
			companyId, classNameId, tableName);

		deleteRow(table.getTableId(), classPK);
	}

	public void deleteRow(
			long companyId, String className, String tableName, long classPK)
		throws PortalException, SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		deleteRow(companyId, classNameId, tableName, classPK);
	}

	public List<ExpandoRow> getDefaultTableRows(
			long companyId, long classNameId, int start, int end)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, ExpandoTableConstants.DEFAULT_TABLE_NAME);

		if (table == null) {
			return Collections.EMPTY_LIST;
		}

		return expandoRowPersistence.findByTableId(
			table.getTableId(), start, end);
	}

	public List<ExpandoRow> getDefaultTableRows(
			long companyId, String className, int start, int end)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getDefaultTableRows(companyId, classNameId, start, end);
	}

	public int getDefaultTableRowsCount(long companyId, long classNameId)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, ExpandoTableConstants.DEFAULT_TABLE_NAME);

		if (table == null) {
			return 0;
		}

		return expandoRowPersistence.countByTableId(table.getTableId());
	}

	public int getDefaultTableRowsCount(long companyId, String className)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getDefaultTableRowsCount(companyId, classNameId);
	}

	public ExpandoRow getRow(long rowId)
		throws PortalException, SystemException {

		return expandoRowPersistence.findByPrimaryKey(rowId);
	}

	public ExpandoRow getRow(long tableId, long classPK)
		throws PortalException, SystemException {

		return expandoRowPersistence.findByT_C(tableId, classPK);
	}

	public ExpandoRow getRow(
			long companyId, long classNameId, String tableName, long classPK)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return null;
		}

		return expandoRowPersistence.fetchByT_C(table.getTableId(), classPK);
	}

	public ExpandoRow getRow(
			long companyId, String className, String tableName, long classPK)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getRow(companyId, classNameId, tableName, classPK);
	}

	public List<ExpandoRow> getRows(long tableId, int start, int end)
		throws SystemException {

		return expandoRowPersistence.findByTableId(tableId, start, end);
	}

	public List<ExpandoRow> getRows(
			long companyId, long classNameId, String tableName, int start,
			int end)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return Collections.EMPTY_LIST;
		}

		return expandoRowPersistence.findByTableId(
			table.getTableId(), start, end);
	}

	public List<ExpandoRow> getRows(
			long companyId, String className, String tableName, int start,
			int end)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getRows(companyId, classNameId, tableName, start, end);
	}

	/**
	 * @deprecated {@link #getRows(long, String, String, int, int)}
	 */
	public List<ExpandoRow> getRows(
			String className, String tableName, int start, int end)
		throws SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getRows(companyId, className, tableName, start, end);
	}

	public int getRowsCount(long tableId) throws SystemException {
		return expandoRowPersistence.countByTableId(tableId);
	}

	public int getRowsCount(long companyId, long classNameId, String tableName)
		throws SystemException {

		ExpandoTable table = expandoTablePersistence.fetchByC_C_N(
			companyId, classNameId, tableName);

		if (table == null) {
			return 0;
		}

		return expandoRowPersistence.countByTableId(table.getTableId());
	}

	public int getRowsCount(long companyId, String className, String tableName)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getRowsCount(companyId, classNameId, tableName);
	}

	/**
	 * @deprecated {@link #getRowsCount(long, String, String)}
	 */
	public int getRowsCount(String className, String tableName)
		throws SystemException {

		long companyId = CompanyThreadLocal.getCompanyId();

		return getRowsCount(companyId, className, tableName);
	}

}