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

package com.liferay.portal.upgrade.v4_3_0.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class MBMessageFlagTable {

	public static String TABLE_NAME = "MBMessageFlag";

	public static Object[][] TABLE_COLUMNS = {
		{"messageFlagId", new Integer(Types.BIGINT)},
		{"userId", new Integer(Types.BIGINT)},
		{"messageId", new Integer(Types.BIGINT)},
		{"flag", new Integer(Types.INTEGER)}
	};

	public static String TABLE_SQL_CREATE = "create table MBMessageFlag (messageFlagId LONG not null primary key,userId LONG,messageId LONG,flag INTEGER)";

	public static String TABLE_SQL_DROP = "drop table MBMessageFlag";

}