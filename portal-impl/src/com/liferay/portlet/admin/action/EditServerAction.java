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

package com.liferay.portlet.admin.action;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.captcha.CaptchaImpl;
import com.liferay.portal.captcha.recaptcha.ReCaptchaImpl;
import com.liferay.portal.captcha.simplecaptcha.SimpleCaptchaImpl;
import com.liferay.portal.convert.ConvertProcess;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.captcha.Captcha;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.Account;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.scripting.ScriptingException;
import com.liferay.portal.kernel.scripting.ScriptingUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.search.lucene.LuceneIndexer;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.ServiceComponentLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.MaintenanceUtil;
import com.liferay.portal.util.PortalInstances;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.ShutdownUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.ActionResponseImpl;
import com.liferay.util.log4j.Log4JUtil;

import java.util.Enumeration;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 */
public class EditServerAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		if (!permissionChecker.isOmniadmin()) {
			SessionErrors.add(
				actionRequest, PrincipalException.class.getName());

			setForward(actionRequest, "portlet.admin.error");

			return;
		}

		PortletPreferences preferences = PrefsPropsUtil.getPreferences();

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		String redirect = null;

		if (cmd.equals("addLogLevel")) {
			addLogLevel(actionRequest);
		}
		else if (cmd.equals("cacheDb")) {
			cacheDb();
		}
		else if (cmd.equals("cacheMulti")) {
			cacheMulti();
		}
		else if (cmd.equals("cacheSingle")) {
			cacheSingle();
		}
		else if (cmd.startsWith("convertProcess.")) {
			redirect = convertProcess(actionRequest, actionResponse, cmd);
		}
		else if (cmd.equals("gc")) {
			gc();
		}
		else if (cmd.equals("reindex")) {
			reindex(actionRequest);
		}
		else if (cmd.equals("runScript")) {
			runScript(portletConfig, actionRequest, actionResponse);
		}
		else if (cmd.equals("shutdown")) {
			shutdown(actionRequest);
		}
		else if (cmd.equals("threadDump")) {
			threadDump();
		}
		else if (cmd.equals("updateCaptcha")) {
			updateCaptcha(actionRequest, preferences);
		}
		else if (cmd.equals("updateFileUploads")) {
			updateFileUploads(actionRequest, preferences);
		}
		else if (cmd.equals("updateLogLevels")) {
			updateLogLevels(actionRequest);
		}
		else if (cmd.equals("updateMail")) {
			updateMail(actionRequest, preferences);
		}
		else if (cmd.equals("updateOpenOffice")) {
			updateOpenOffice(actionRequest, preferences);
		}
		else if (cmd.equals("verifyPluginTables")) {
			verifyPluginTables();
		}

		sendRedirect(actionRequest, actionResponse, redirect);
	}

	protected void addLogLevel(ActionRequest actionRequest) throws Exception {
		String loggerName = ParamUtil.getString(actionRequest, "loggerName");
		String priority = ParamUtil.getString(actionRequest, "priority");

		Logger logger = Logger.getLogger(loggerName);

		logger.setLevel(Level.toLevel(priority));
	}

	protected void cacheDb() throws Exception {
		CacheRegistryUtil.clear();
	}

	protected void cacheMulti() throws Exception {
		MultiVMPoolUtil.clear();
	}

	protected void cacheSingle() throws Exception {
		WebCachePoolUtil.clear();
	}

	protected String convertProcess(
			ActionRequest actionRequest, ActionResponse actionResponse,
			String cmd)
		throws Exception {

		ActionResponseImpl actionResponseImpl =
			(ActionResponseImpl)actionResponse;

		PortletSession portletSession = actionRequest.getPortletSession();

		String className = StringUtil.replaceFirst(
			cmd, "convertProcess.", StringPool.BLANK);

		ConvertProcess convertProcess = (ConvertProcess)InstancePool.get(
			className);

		String[] parameters = convertProcess.getParameterNames();

		if (parameters != null) {
			String[] values = new String[parameters.length];

			for (int i = 0; i < parameters.length; i++) {
				String parameter =
					className + StringPool.PERIOD + parameters[i];

				if (parameters[i].contains(StringPool.EQUAL)) {
					String[] parameterPair = StringUtil.split(
						parameters[i], StringPool.EQUAL);

					parameter =
						className + StringPool.PERIOD + parameterPair[0];
				}

				values[i] = ParamUtil.getString(actionRequest, parameter);
			}

			convertProcess.setParameterValues(values);
		}

		String path = convertProcess.getPath();

		if (path != null) {
			PortletURL portletURL = actionResponseImpl.createRenderURL();

			portletURL.setWindowState(WindowState.MAXIMIZED);

			portletURL.setParameter("struts_action", path);

			return portletURL.toString();
		}
		else {
			MaintenanceUtil.maintain(portletSession.getId(), className);

			MessageBusUtil.sendMessage(
				DestinationNames.CONVERT_PROCESS, className);

			return null;
		}
	}

	protected void gc() throws Exception {
		Runtime.getRuntime().gc();
	}

	protected String getFileExtensions(
		ActionRequest actionRequest, String name) {

		String value = ParamUtil.getString(actionRequest, name);

		return value.replace(", .", ",.");
	}

	protected void reindex(ActionRequest actionRequest) throws Exception {
		String portletId = ParamUtil.getString(actionRequest, "portletId");

		long[] companyIds = PortalInstances.getCompanyIds();

		if (Validator.isNull(portletId)) {
			for (long companyId : companyIds) {
				try {
					LuceneIndexer indexer = new LuceneIndexer(companyId);

					indexer.reindex();
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
		}
		else {
			Portlet portlet = PortletLocalServiceUtil.getPortletById(
				companyIds[0], portletId);

			if (portlet == null) {
				return;
			}

			Indexer indexer = portlet.getIndexerInstance();

			if (indexer == null) {
				return;
			}

			for (long companyId : companyIds) {
				try {
					SearchEngineUtil.deletePortletDocuments(
						companyId, portletId);

					indexer.reindex(new String[] {String.valueOf(companyId)});
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
		}
	}

	protected void runScript(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String language = ParamUtil.getString(actionRequest, "language");
		String script = ParamUtil.getString(actionRequest, "script");

		PortletContext portletContext = portletConfig.getPortletContext();

		Map<String, Object> portletObjects = ScriptingUtil.getPortletObjects(
			portletConfig, portletContext, actionRequest, actionResponse);

		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream();

		portletObjects.put("out", unsyncByteArrayOutputStream);

		try {
			ScriptingUtil.exec(null, portletObjects, language, script);

			SessionMessages.add(
				actionRequest, "script_output",
				unsyncByteArrayOutputStream.toString());
		}
		catch (ScriptingException se) {
			SessionErrors.add(
				actionRequest, ScriptingException.class.getName(), se);

			_log.error(se.getMessage());
		}
	}

	protected void shutdown(ActionRequest actionRequest) throws Exception {
		long minutes =
			ParamUtil.getInteger(actionRequest, "minutes") * Time.MINUTE;
		String message = ParamUtil.getString(actionRequest, "message");

		if (minutes <= 0) {
			ShutdownUtil.cancel();
		}
		else {
			ShutdownUtil.shutdown(minutes, message);
		}
	}

	protected void threadDump() throws Exception {
		String jvm =
			System.getProperty("java.vm.name") + " " +
				System.getProperty("java.vm.version");

		StringBundler sb = new StringBundler(
			"Full thread dump " + jvm + "\n\n");

		Map<Thread, StackTraceElement[]> stackTraces =
			Thread.getAllStackTraces();

		for (Map.Entry<Thread, StackTraceElement[]> entry :
				stackTraces.entrySet()) {

			Thread thread = entry.getKey();
			StackTraceElement[] elements = entry.getValue();

			sb.append(StringPool.QUOTE);
			sb.append(thread.getName());
			sb.append(StringPool.QUOTE);

			if (thread.getThreadGroup() != null) {
				sb.append(StringPool.SPACE);
				sb.append(StringPool.OPEN_PARENTHESIS);
				sb.append(thread.getThreadGroup().getName());
				sb.append(StringPool.CLOSE_PARENTHESIS);
			}

			sb.append(", priority=");
			sb.append(thread.getPriority());
			sb.append(", id=");
			sb.append(thread.getId());
			sb.append(", state=");
			sb.append(thread.getState());
			sb.append("\n");

			for (int i = 0; i < elements.length; i++) {
				sb.append("\t");
				sb.append(elements[i]);
				sb.append("\n");
			}

			sb.append("\n");
		}

		if (_log.isInfoEnabled()) {
			_log.info(sb.toString());
		}
		else {
			_log.error(
				"Thread dumps require the log level to be at least INFO for " +
					getClass().getName());
		}
	}

	protected void updateCaptcha(
			ActionRequest actionRequest, PortletPreferences preferences)
		throws Exception {

		boolean reCaptchaEnabled = ParamUtil.getBoolean(
			actionRequest, "reCaptchaEnabled");
		String reCaptchaPrivateKey = ParamUtil.getString(
			actionRequest, "reCaptchaPrivateKey");
		String reCaptchaPublicKey = ParamUtil.getString(
			actionRequest, "reCaptchaPublicKey");

		Captcha captcha = null;

		if (reCaptchaEnabled) {
			captcha = new ReCaptchaImpl();
		}
		else {
			captcha = new SimpleCaptchaImpl();
		}

		preferences.setValue(
			PropsKeys.CAPTCHA_ENGINE_IMPL, captcha.getClass().getName());
		preferences.setValue(
			PropsKeys.CAPTCHA_ENGINE_RECAPTCHA_KEY_PRIVATE,
			reCaptchaPrivateKey);
		preferences.setValue(
			PropsKeys.CAPTCHA_ENGINE_RECAPTCHA_KEY_PUBLIC, reCaptchaPublicKey);

		preferences.store();

		CaptchaImpl captchaImpl = (CaptchaImpl)CaptchaUtil.getCaptcha();

		captchaImpl.setCaptcha(captcha);
	}

	protected void updateFileUploads(
			ActionRequest actionRequest, PortletPreferences preferences)
		throws Exception {

		String dlFileExtensions = getFileExtensions(
			actionRequest, "dlFileExtensions");
		long dlFileMaxSize = ParamUtil.getLong(actionRequest, "dlFileMaxSize");
		String igImageExtensions = getFileExtensions(
			actionRequest, "igImageExtensions");
		long igImageMaxSize = ParamUtil.getLong(
			actionRequest, "igImageMaxSize");
		long igThumbnailMaxDimension = ParamUtil.getLong(
			actionRequest, "igImageThumbnailMaxDimensions");
		String journalImageExtensions = getFileExtensions(
			actionRequest, "journalImageExtensions");
		long journalImageSmallMaxSize = ParamUtil.getLong(
			actionRequest, "journalImageSmallMaxSize");
		String shoppingImageExtensions = getFileExtensions(
			actionRequest, "shoppingImageExtensions");
		long scImageMaxSize = ParamUtil.getLong(
			actionRequest, "scImageMaxSize");
		long scImageThumbnailMaxHeight = ParamUtil.getLong(
			actionRequest, "scImageThumbnailMaxHeight");
		long scImageThumbnailMaxWidth = ParamUtil.getLong(
			actionRequest, "scImageThumbnailMaxWidth");
		long shoppingImageLargeMaxSize = ParamUtil.getLong(
			actionRequest, "shoppingImageLargeMaxSize");
		long shoppingImageMediumMaxSize = ParamUtil.getLong(
			actionRequest, "shoppingImageMediumMaxSize");
		long shoppingImageSmallMaxSize = ParamUtil.getLong(
			actionRequest, "shoppingImageSmallMaxSize");
		long uploadServletRequestImplMaxSize = ParamUtil.getLong(
			actionRequest, "uploadServletRequestImplMaxSize");
		String uploadServletRequestImplTempDir = ParamUtil.getString(
			actionRequest, "uploadServletRequestImplTempDir");
		long usersImageMaxSize = ParamUtil.getLong(
			actionRequest, "usersImageMaxSize");

		preferences.setValue(
			PropsKeys.DL_FILE_EXTENSIONS, dlFileExtensions);
		preferences.setValue(
			PropsKeys.DL_FILE_MAX_SIZE, String.valueOf(dlFileMaxSize));
		preferences.setValue(
			PropsKeys.IG_IMAGE_EXTENSIONS, igImageExtensions);
		preferences.setValue(
			PropsKeys.IG_IMAGE_MAX_SIZE, String.valueOf(igImageMaxSize));
		preferences.setValue(
			PropsKeys.IG_IMAGE_THUMBNAIL_MAX_DIMENSION,
			String.valueOf(igThumbnailMaxDimension));
		preferences.setValue(
			PropsKeys.JOURNAL_IMAGE_EXTENSIONS, journalImageExtensions);
		preferences.setValue(
			PropsKeys.JOURNAL_IMAGE_SMALL_MAX_SIZE,
			String.valueOf(journalImageSmallMaxSize));
		preferences.setValue(
			PropsKeys.SHOPPING_IMAGE_EXTENSIONS, shoppingImageExtensions);
		preferences.setValue(
			PropsKeys.SHOPPING_IMAGE_LARGE_MAX_SIZE,
			String.valueOf(shoppingImageLargeMaxSize));
		preferences.setValue(
			PropsKeys.SHOPPING_IMAGE_MEDIUM_MAX_SIZE,
			String.valueOf(shoppingImageMediumMaxSize));
		preferences.setValue(
			PropsKeys.SHOPPING_IMAGE_SMALL_MAX_SIZE,
			String.valueOf(shoppingImageSmallMaxSize));
		preferences.setValue(
			PropsKeys.SC_IMAGE_MAX_SIZE, String.valueOf(scImageMaxSize));
		preferences.setValue(
			PropsKeys.SC_IMAGE_THUMBNAIL_MAX_HEIGHT,
			String.valueOf(scImageThumbnailMaxHeight));
		preferences.setValue(
			PropsKeys.SC_IMAGE_THUMBNAIL_MAX_WIDTH,
			String.valueOf(scImageThumbnailMaxWidth));
		preferences.setValue(
			PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE,
			String.valueOf(uploadServletRequestImplMaxSize));

		if (Validator.isNotNull(uploadServletRequestImplTempDir)) {
			preferences.setValue(
				PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_TEMP_DIR,
				uploadServletRequestImplTempDir);
		}

		preferences.setValue(
			PropsKeys.USERS_IMAGE_MAX_SIZE, String.valueOf(usersImageMaxSize));

		preferences.store();
	}

	protected void updateLogLevels(ActionRequest actionRequest)
		throws Exception {

		Enumeration<String> enu = actionRequest.getParameterNames();

		while (enu.hasMoreElements()) {
			String name = enu.nextElement();

			if (name.startsWith("logLevel")) {
				String loggerName = name.substring(8, name.length());

				String priority = ParamUtil.getString(
					actionRequest, name, Level.INFO.toString());

				Log4JUtil.setLevel(loggerName, priority);
			}
		}
	}

	protected void updateMail(
			ActionRequest actionRequest, PortletPreferences preferences)
		throws Exception {

		String advancedProperties = ParamUtil.getString(
			actionRequest, "advancedProperties");
		String pop3Host = ParamUtil.getString(actionRequest, "pop3Host");
		String pop3Password = ParamUtil.getString(
			actionRequest, "pop3Password");
		int pop3Port = ParamUtil.getInteger(actionRequest, "pop3Port");
		boolean pop3Secure = ParamUtil.getBoolean(actionRequest, "pop3Secure");
		String pop3User = ParamUtil.getString(actionRequest, "pop3User");
		String smtpHost = ParamUtil.getString(actionRequest, "smtpHost");
		String smtpPassword = ParamUtil.getString(
			actionRequest, "smtpPassword");
		int smtpPort = ParamUtil.getInteger(actionRequest, "smtpPort");
		boolean smtpSecure = ParamUtil.getBoolean(actionRequest, "smtpSecure");
		String smtpUser = ParamUtil.getString(actionRequest, "smtpUser");

		String storeProtocol = Account.PROTOCOL_POP;

		if (pop3Secure) {
			storeProtocol = Account.PROTOCOL_POPS;
		}

		String transportProtocol = Account.PROTOCOL_SMTP;

		if (smtpSecure) {
			transportProtocol = Account.PROTOCOL_SMTPS;
		}

		preferences.setValue(PropsKeys.MAIL_SESSION_MAIL, "true");
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_ADVANCED_PROPERTIES,
			advancedProperties);
		preferences.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_HOST, pop3Host);
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_POP3_PASSWORD, pop3Password);
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_POP3_PORT, String.valueOf(pop3Port));
		preferences.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_USER, pop3User);
		preferences.setValue(PropsKeys.MAIL_SESSION_MAIL_SMTP_HOST, smtpHost);
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_PASSWORD, smtpPassword);
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_PORT, String.valueOf(smtpPort));
		preferences.setValue(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER, smtpUser);
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_STORE_PROTOCOL, storeProtocol);
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_TRANSPORT_PROTOCOL, transportProtocol);

		preferences.store();

		MailServiceUtil.clearSession();
	}

	protected void updateOpenOffice(
			ActionRequest actionRequest, PortletPreferences preferences)
		throws Exception {

		boolean enabled = ParamUtil.getBoolean(actionRequest, "enabled");
		int port = ParamUtil.getInteger(actionRequest, "port");

		preferences.setValue(
			PropsKeys.OPENOFFICE_SERVER_ENABLED, String.valueOf(enabled));
		preferences.setValue(
			PropsKeys.OPENOFFICE_SERVER_PORT, String.valueOf(port));

		preferences.store();
	}

	protected void verifyPluginTables() throws Exception {
		ServiceComponentLocalServiceUtil.verifyDB();
	}

	private static Log _log = LogFactoryUtil.getLog(EditServerAction.class);

}