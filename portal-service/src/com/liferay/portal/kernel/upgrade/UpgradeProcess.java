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

package com.liferay.portal.kernel.upgrade;

import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public abstract class UpgradeProcess {

	public UpgradeProcess() {
	}

	public int getThreshold() {

		// This upgrade process will only run if the build number is larger than
		// the returned threshold value. Return 0 to always run this upgrade
		// process.

		return 0;
	}

	public long increment() throws SystemException {
		DB db = DBFactoryUtil.getDB();

		return db.increment();
	}

	public boolean isSupportsAlterColumnName() {
		DB db = DBFactoryUtil.getDB();

		return db.isSupportsAlterColumnName();
	}

	public boolean isSupportsAlterColumnType() {
		DB db = DBFactoryUtil.getDB();

		return db.isSupportsAlterColumnType();
	}

	public boolean isSupportsStringCaseSensitiveQuery() {
		DB db = DBFactoryUtil.getDB();

		return db.isSupportsStringCaseSensitiveQuery();
	}

	public boolean isSupportsUpdateWithInnerJoin() {
		DB db = DBFactoryUtil.getDB();

		return db.isSupportsUpdateWithInnerJoin();
	}

	public void runSQL(String template) throws IOException, SQLException {
		DB db = DBFactoryUtil.getDB();

		db.runSQL(template);
	}

	public void runSQL(String[] templates) throws IOException, SQLException {
		DB db = DBFactoryUtil.getDB();

		db.runSQL(templates);
	}

	public void runSQLTemplate(String path)
		throws IOException, NamingException, SQLException {

		DB db = DBFactoryUtil.getDB();

		db.runSQLTemplate(path);
	}

	public void runSQLTemplate(String path, boolean failOnError)
		throws IOException, NamingException, SQLException {

		DB db = DBFactoryUtil.getDB();

		db.runSQLTemplate(path, failOnError);
	}

	public void upgrade() throws UpgradeException {
		try {
			if (_log.isInfoEnabled()) {
				_log.info("Upgrading " + getClass().getName());
			}

			doUpgrade();
		}
		catch (Exception e) {
			throw new UpgradeException(e);
		}
	}

	public void upgrade(Class<?> upgradeProcessClass)
		throws UpgradeException {

		UpgradeProcess upgradeProcess = null;

		try {
			upgradeProcess = (UpgradeProcess)upgradeProcessClass.newInstance();
		}
		catch (Exception e) {
			throw new UpgradeException(e);
		}

		upgradeProcess.upgrade();
	}

	public void upgrade(UpgradeProcess upgradeProcess)
		throws UpgradeException {

		upgradeProcess.upgrade();
	}

	protected void doUpgrade() throws Exception {
	}

	private static Log _log = LogFactoryUtil.getLog(UpgradeProcess.class);

}