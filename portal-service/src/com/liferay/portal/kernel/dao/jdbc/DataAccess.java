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

package com.liferay.portal.kernel.dao.jdbc;

import com.liferay.portal.kernel.jndi.JNDIUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

/**
 * @author Brian Wing Shun Chan
 */
public class DataAccess {

	public static Connection getConnection() throws SQLException {
		DataSource ds = InfrastructureUtil.getDataSource();

		return ds.getConnection();
	}

	public static Connection getConnection(String location)
		throws NamingException, SQLException {

		InitialContext ctx = new InitialContext();

		DataSource ds = (DataSource)JNDIUtil.lookup(ctx, location);

		return ds.getConnection();
	}

	public static void cleanUp(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		}
		catch (SQLException sqle) {
			if (_log.isWarnEnabled()) {
				_log.warn(sqle.getMessage());
			}
		}
	}

	public static void cleanUp(Connection connection, Statement statement) {
		cleanUp(statement);
		cleanUp(connection);
	}

	public static void cleanUp(
		Connection connection, Statement statement, ResultSet resultSet) {

		cleanUp(resultSet);
		cleanUp(statement);
		cleanUp(connection);
	}

	public static void cleanUp(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		}
		catch (SQLException sqle) {
			if (_log.isWarnEnabled()) {
				_log.warn(sqle.getMessage());
			}
		}
	}

	public static void cleanUp(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		}
		catch (SQLException sqle) {
			if (_log.isWarnEnabled()) {
				_log.warn(sqle.getMessage());
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DataAccess.class);

}