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

package com.liferay.portal.deploy;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.util.SystemProperties;
import com.liferay.util.ant.DeleteTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Brian Wing Shun Chan
 */
public class DeployUtil {

	public static String getAutoDeployDestDir() throws Exception {
		String destDir = PrefsPropsUtil.getString(
			PropsKeys.AUTO_DEPLOY_DEST_DIR, PropsValues.AUTO_DEPLOY_DEST_DIR);

		if (Validator.isNull(destDir)) {
			destDir = getAutoDeployServerDestDir();
		}

		return destDir;
	}

	public static String getAutoDeployServerDestDir() throws Exception {
		String destDir = null;

		String serverId = GetterUtil.getString(ServerDetector.getServerId());

		if (serverId.equals(ServerDetector.TOMCAT_ID)) {
			destDir = PrefsPropsUtil.getString(
				PropsKeys.AUTO_DEPLOY_TOMCAT_DEST_DIR,
				PropsValues.AUTO_DEPLOY_TOMCAT_DEST_DIR);
		}
		else {
			destDir = PrefsPropsUtil.getString(
				"auto.deploy." + serverId + ".dest.dir");
		}

		if (Validator.isNull(destDir)) {
			destDir = PrefsPropsUtil.getString(
				PropsKeys.AUTO_DEPLOY_DEFAULT_DEST_DIR,
				PropsValues.AUTO_DEPLOY_DEFAULT_DEST_DIR);
		}

		destDir = StringUtil.replace(
			destDir, StringPool.BACK_SLASH, StringPool.SLASH);

		return destDir;
	}

	public static String getResourcePath(String resource)
		throws Exception {

		return _instance._getResourcePath(resource);
	}

	public static void undeploy(String appServerType, File deployDir)
		throws Exception {

		boolean undeployEnabled = PrefsPropsUtil.getBoolean(
			PropsKeys.HOT_UNDEPLOY_ENABLED, PropsValues.HOT_UNDEPLOY_ENABLED);

		if (!undeployEnabled) {
			return;
		}

		if (!appServerType.startsWith(ServerDetector.JBOSS_ID) &&
			!appServerType.equals(ServerDetector.TOMCAT_ID)) {

			return;
		}

		File webXml = new File(deployDir + "/WEB-INF/web.xml");

		if (!webXml.exists()) {
			return;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Undeploy " + deployDir);
		}

		FileUtil.delete(deployDir + "/WEB-INF/web.xml");

		DeleteTask.deleteDirectory(deployDir);

		int undeployInterval = PrefsPropsUtil.getInteger(
			PropsKeys.HOT_UNDEPLOY_INTERVAL,
			PropsValues.HOT_UNDEPLOY_INTERVAL);

		if (_log.isInfoEnabled()) {
			_log.info(
				"Wait " + undeployInterval +
					" ms to allow the plugin time to fully undeploy");
		}

		if (undeployInterval > 0) {
			Thread.sleep(undeployInterval);
		}
	}

	private DeployUtil() {
	}

	private String _getResourcePath(String resource) throws IOException {
		InputStream is = getClass().getResourceAsStream(
			"dependencies/" + resource);

		if (is == null) {
			return null;
		}

		String tmpDir = SystemProperties.get(SystemProperties.TMP_DIR);

		File file = new File(
			tmpDir + "/liferay/com/liferay/portal/deploy/dependencies/" +
				resource);

		//if (!file.exists() || resource.startsWith("ext-")) {
			File parentFile = file.getParentFile();

			if (parentFile != null) {
				parentFile.mkdirs();
			}

			StreamUtil.transfer(is, new FileOutputStream(file));
		//}

		return FileUtil.getAbsolutePath(file);
	}

	private static Log _log = LogFactoryUtil.getLog(DeployUtil.class);

	private static DeployUtil _instance = new DeployUtil();

}