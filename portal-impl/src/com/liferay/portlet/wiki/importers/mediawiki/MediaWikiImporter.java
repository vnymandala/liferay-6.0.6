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

package com.liferay.portlet.wiki.importers.mediawiki;

import com.liferay.documentlibrary.service.DLLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.ProgressTracker;
import com.liferay.portal.kernel.util.ProgressTrackerThreadLocal;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.zip.ZipReader;
import com.liferay.portal.kernel.zip.ZipReaderFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.asset.NoSuchTagException;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagPropertyLocalServiceUtil;
import com.liferay.portlet.asset.util.AssetUtil;
import com.liferay.portlet.wiki.ImportFilesException;
import com.liferay.portlet.wiki.NoSuchPageException;
import com.liferay.portlet.wiki.importers.WikiImporter;
import com.liferay.portlet.wiki.importers.WikiImporterKeys;
import com.liferay.portlet.wiki.model.WikiNode;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.model.WikiPageConstants;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;
import com.liferay.portlet.wiki.translators.MediaWikiToCreoleTranslator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alvaro del Castillo
 * @author Jorge Ferrer
 */
public class MediaWikiImporter implements WikiImporter {

	public static final String SHARED_IMAGES_CONTENT = "See attachments";

	public static final String SHARED_IMAGES_TITLE = "SharedImages";

	public void importPages(
			long userId, WikiNode node, File[] files,
			Map<String, String[]> options)
		throws PortalException {

		if ((files.length < 1) || (files[0] == null) || (!files[0].exists())) {
			throw new PortalException("The pages file is mandatory");
		}

		File pagesFile = files[0];
		File usersFile = files[1];
		File imagesFile = files[2];

		try {
			Document doc = SAXReaderUtil.read(pagesFile);

			Map<String, String> usersMap = readUsersFile(usersFile);

			Element root = doc.getRootElement();

			List<String> specialNamespaces = readSpecialNamespaces(root);

			processSpecialPages(userId, node, root, specialNamespaces);
			processRegularPages(
				userId, node, root, specialNamespaces, usersMap, imagesFile,
				options);
			processImages(userId, node, imagesFile);

			moveFrontPage(userId, node, options);
		}
		catch (DocumentException de) {
			throw new ImportFilesException("Invalid XML file provided");
		}
		catch (IOException de) {
			throw new ImportFilesException("Error reading the files provided");
		}
		catch (PortalException e) {
			throw e;
		}
		catch (Exception e) {
			throw new PortalException(e);
		}
	}

	protected long getUserId(
			long userId, WikiNode node, String author,
			Map<String, String> usersMap)
		throws PortalException, SystemException {

		User user = null;

		String emailAddress = usersMap.get(author);

		try {
			if (Validator.isNull(emailAddress)) {
				user = UserLocalServiceUtil.getUserByScreenName(
					node.getCompanyId(), author.toLowerCase());
			}
			else {
				user = UserLocalServiceUtil.getUserByEmailAddress(
					node.getCompanyId(), emailAddress);
			}
		}
		catch (NoSuchUserException nsue) {
			user = UserLocalServiceUtil.getUserById(userId);
		}

		return user.getUserId();
	}

	protected void importPage(
			long userId, String author, WikiNode node, String title,
			String content, String summary, Map<String, String> usersMap)
		throws PortalException {

		try {
			long authorUserId = getUserId(userId, node, author, usersMap);
			String parentTitle = readParentTitle(content);
			String redirectTitle = readRedirectTitle(content);

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAddCommunityPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			serviceContext.setAssetTagNames(
				readAssetTagNames(userId, node, content));

			if (Validator.isNull(redirectTitle)) {
				content = _translator.translate(content);
			}
			else {
				content =
					StringPool.DOUBLE_OPEN_BRACKET + redirectTitle +
						StringPool.DOUBLE_CLOSE_BRACKET;
			}

			WikiPage page = null;

			try {
				page = WikiPageLocalServiceUtil.getPage(
					node.getNodeId(), title);
			}
			catch (NoSuchPageException nspe) {
				page = WikiPageLocalServiceUtil.addPage(
					authorUserId, node.getNodeId(), title,
					WikiPageConstants.NEW, null, true, serviceContext);
			}

			WikiPageLocalServiceUtil.updatePage(
				authorUserId, node.getNodeId(), title, page.getVersion(),
				content, summary, true, "creole", parentTitle, redirectTitle,
				serviceContext);
		}
		catch (Exception e) {
			throw new PortalException("Error importing page " + title, e);
		}
	}

	protected boolean isSpecialMediaWikiPage(
		String title, List<String> specialNamespaces) {

		for (String namespace: specialNamespaces) {
			if (title.startsWith(namespace + StringPool.COLON)) {
				return true;
			}
		}

		return false;
	}

	protected boolean isValidImage(String[] paths, byte[] bytes) {
		if (ArrayUtil.contains(_SPECIAL_MEDIA_WIKI_DIRS, paths[0])) {
			return false;
		}

		if ((paths.length > 1) &&
			(ArrayUtil.contains(_SPECIAL_MEDIA_WIKI_DIRS, paths[1]))) {

			return false;
		}

		String fileName = paths[paths.length - 1];

		try {
			DLLocalServiceUtil.validate(fileName, true, bytes);
		}
		catch (PortalException pe) {
			return false;
		}
		catch (SystemException se) {
			return false;
		}

		return true;
	}

	protected void moveFrontPage(
		long userId, WikiNode node, Map<String, String[]> options) {

		String frontPageTitle = MapUtil.getString(
			options, WikiImporterKeys.OPTIONS_FRONT_PAGE);

		if (Validator.isNotNull(frontPageTitle)) {
			frontPageTitle = normalizeTitle(frontPageTitle);

			try {
				if (WikiPageLocalServiceUtil.getPagesCount(
						node.getNodeId(), frontPageTitle, true) > 0) {

					ServiceContext serviceContext = new ServiceContext();

					serviceContext.setAddCommunityPermissions(true);
					serviceContext.setAddGuestPermissions(true);

					WikiPageLocalServiceUtil.movePage(
						userId, node.getNodeId(), frontPageTitle,
						WikiPageConstants.FRONT_PAGE, false, serviceContext);

				}
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					StringBundler sb = new StringBundler(4);

					sb.append("Could not move ");
					sb.append(WikiPageConstants.FRONT_PAGE);
					sb.append(" to the title provided: ");
					sb.append(frontPageTitle);

					_log.warn(sb.toString(), e);
				}
			}

		}

	}

	protected String normalize(String categoryName, int length) {
		categoryName = AssetUtil.toWord(categoryName.trim());

		return StringUtil.shorten(categoryName, length);
	}

	protected String normalizeDescription(String description) {
		description = description.replaceAll(
			_categoriesPattern.pattern(), StringPool.BLANK);

		return normalize(description, 300);
	}

	protected String normalizeTitle(String title) {
		title = title.replaceAll(
			PropsValues.WIKI_PAGE_TITLES_REMOVE_REGEXP, StringPool.BLANK);

		return StringUtil.shorten(title, 75);
	}

	protected void processImages(long userId, WikiNode node, File imagesFile)
		throws Exception {

		if ((imagesFile == null) || (!imagesFile.exists())) {
			return;
		}

		ProgressTracker progressTracker =
			ProgressTrackerThreadLocal.getProgressTracker();

		int count = 0;

		ZipReader zipReader = ZipReaderFactoryUtil.getZipReader(imagesFile);

		List<String> entries = zipReader.getEntries();

		int total = entries.size();

		if (total > 0) {
			try {
				WikiPageLocalServiceUtil.getPage(
					node.getNodeId(), SHARED_IMAGES_TITLE);
			}
			catch (NoSuchPageException nspe) {
				ServiceContext serviceContext = new ServiceContext();

				serviceContext.setAddCommunityPermissions(true);
				serviceContext.setAddGuestPermissions(true);

				WikiPageLocalServiceUtil.addPage(
					userId, node.getNodeId(), SHARED_IMAGES_TITLE,
					SHARED_IMAGES_CONTENT, null, true, serviceContext);
			}
		}

		List<ObjectValuePair<String, byte[]>> attachments =
			new ArrayList<ObjectValuePair<String, byte[]>>();

		int percentage = 50;

		for (int i = 0; i < entries.size(); i++) {
			String entry = entries.get(i);

			String key = entry;
			byte[] value = zipReader.getEntryAsByteArray(entry);

			String[] paths = StringUtil.split(key, StringPool.SLASH);

			if (!isValidImage(paths, value)) {
				if (_log.isInfoEnabled()) {
					_log.info("Ignoring " + key);
				}

				continue;
			}

			String fileName = paths[paths.length - 1].toLowerCase();

			attachments.add(
				new ObjectValuePair<String, byte[]>(fileName, value));

			count++;

			if ((i % 5) == 0) {
				WikiPageLocalServiceUtil.addPageAttachments(
					node.getNodeId(), SHARED_IMAGES_TITLE, attachments);

				attachments.clear();

				percentage = Math.min(50 + (i * 50) / total, 99);

				progressTracker.updateProgress(percentage);
			}
		}

		if (!attachments.isEmpty()) {
			WikiPageLocalServiceUtil.addPageAttachments(
				node.getNodeId(), SHARED_IMAGES_TITLE, attachments);
		}

		zipReader.close();

		if (_log.isInfoEnabled()) {
			_log.info("Imported " + count + " images into " + node.getName());
		}
	}

	protected void processRegularPages(
		long userId, WikiNode node, Element root,
		List<String> specialNamespaces, Map<String, String> usersMap,
		File imagesFile, Map<String, String[]> options) {

		boolean importLatestVersion = MapUtil.getBoolean(
			options, WikiImporterKeys.OPTIONS_IMPORT_LATEST_VERSION);

		ProgressTracker progressTracker =
			ProgressTrackerThreadLocal.getProgressTracker();

		int count = 0;

		List<Element> pages = root.elements("page");

		int total = pages.size();

		Iterator<Element> itr = root.elements("page").iterator();

		int percentage = 10;
		int maxPercentage = 50;

		if ((imagesFile == null) || (!imagesFile.exists())) {
			maxPercentage = 99;
		}

		int percentageRange = maxPercentage - percentage;

		for (int i = 0; itr.hasNext(); i++) {
			Element pageEl = itr.next();

			String title = pageEl.elementText("title");

			title = normalizeTitle(title);

			percentage = Math.min(
				10 + (i * percentageRange) / total, maxPercentage);

			progressTracker.updateProgress(percentage);

			if (isSpecialMediaWikiPage(title, specialNamespaces)) {
				continue;
			}

			List<Element> revisionEls = pageEl.elements("revision");

			if (importLatestVersion) {
				Element lastRevisionEl = revisionEls.get(
					revisionEls.size() - 1);

				revisionEls = new ArrayList<Element>();

				revisionEls.add(lastRevisionEl);
			}

			for (Element curRevisionEl : revisionEls) {
				String author = curRevisionEl.element(
					"contributor").elementText("username");
				String content = curRevisionEl.elementText("text");
				String summary = curRevisionEl.elementText("comment");

				try {
					importPage(
						userId, author, node, title, content, summary,
						usersMap);
				}
				catch (Exception e) {
					if (_log.isWarnEnabled()) {
						StringBundler sb = new StringBundler(3);

						sb.append("Page with title ");
						sb.append(title);
						sb.append(" could not be imported");

						_log.warn(sb.toString(), e);
					}
				}
			}

			count++;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Imported " + count + " pages into " + node.getName());
		}
	}

	protected void processSpecialPages(
			long userId, WikiNode node, Element root,
			List<String> specialNamespaces)
		throws PortalException {

		ProgressTracker progressTracker =
			ProgressTrackerThreadLocal.getProgressTracker();

		List<Element> pages = root.elements("page");

		int total = pages.size();

		Iterator<Element> itr = pages.iterator();

		for (int i = 0; itr.hasNext(); i++) {
			Element page = itr.next();

			String title = page.elementText("title");

			if (!title.startsWith("Category:")) {
				if (isSpecialMediaWikiPage(title, specialNamespaces)) {
					root.remove(page);
				}

				continue;
			}

			String categoryName = title.substring("Category:".length());

			categoryName = normalize(categoryName, 75);

			String description = page.element("revision").elementText("text");

			description = normalizeDescription(description);

			try {
				AssetTag assetTag = null;

				try {
					assetTag = AssetTagLocalServiceUtil.getTag(
						node.getCompanyId(), categoryName);
				}
				catch (NoSuchTagException nste) {
					ServiceContext serviceContext = new ServiceContext();

					serviceContext.setAddCommunityPermissions(true);
					serviceContext.setAddGuestPermissions(true);
					serviceContext.setScopeGroupId(node.getGroupId());

					assetTag = AssetTagLocalServiceUtil.addTag(
						userId, categoryName, null, serviceContext);
				}

				if (Validator.isNotNull(description)) {
					AssetTagPropertyLocalServiceUtil.addTagProperty(
						userId, assetTag.getTagId(), "description",
						description);
				}
			}
			catch (SystemException se) {
				 _log.error(se, se);
			}

			if ((i % 5) == 0) {
				progressTracker.updateProgress((i * 10) / total);
			}
		}
	}

	protected String[] readAssetTagNames(
			long userId, WikiNode node, String content)
		throws PortalException, SystemException {

		Matcher matcher = _categoriesPattern.matcher(content);

		List<String> assetTagNames = new ArrayList<String>();

		while (matcher.find()) {
			String categoryName = matcher.group(1);

			categoryName = normalize(categoryName, 75);

			AssetTag assetTag = null;

			try {
				assetTag = AssetTagLocalServiceUtil.getTag(
					node.getGroupId(), categoryName);
			}
			catch (NoSuchTagException nste) {
				ServiceContext serviceContext = new ServiceContext();

				serviceContext.setAddCommunityPermissions(true);
				serviceContext.setAddGuestPermissions(true);
				serviceContext.setScopeGroupId(node.getGroupId());

				assetTag = AssetTagLocalServiceUtil.addTag(
					userId, categoryName, null, serviceContext);
			}

			assetTagNames.add(assetTag.getName());
		}

		if (content.indexOf(_WORK_IN_PROGRESS) != -1) {
			assetTagNames.add(_WORK_IN_PROGRESS_TAG);
		}

		return assetTagNames.toArray(new String[assetTagNames.size()]);
	}

	protected String readParentTitle(String content) {
		Matcher matcher = _parentPattern.matcher(content);

		String redirectTitle = StringPool.BLANK;

		if (matcher.find()) {
			redirectTitle = matcher.group(1);

			redirectTitle = normalizeTitle(redirectTitle);

			redirectTitle += " (disambiguation)";
		}

		return redirectTitle;
	}
	protected String readRedirectTitle(String content) {
		Matcher matcher = _redirectPattern.matcher(content);

		String redirectTitle = StringPool.BLANK;

		if (matcher.find()) {
			redirectTitle = matcher.group(1);

			redirectTitle = normalizeTitle(redirectTitle);
		}

		return redirectTitle;
	}
	protected List<String> readSpecialNamespaces(Element root)
		throws ImportFilesException {

		List<String> namespaces = new ArrayList<String>();

		Element siteinfoEl = root.element("siteinfo");

		if (siteinfoEl == null) {
			throw new ImportFilesException("Invalid pages XML file");
		}

		Iterator<Element> itr = siteinfoEl.element(
			"namespaces").elements("namespace").iterator();

		while (itr.hasNext()) {
			Element namespace = itr.next();

			if (!namespace.attribute("key").getData().equals("0")) {
				namespaces.add(namespace.getText());
			}
		}

		return namespaces;
	}

	protected Map<String, String> readUsersFile(File usersFile)
		throws IOException {

		if ((usersFile == null) || (!usersFile.exists())) {
			return Collections.EMPTY_MAP;
		}

		Map<String, String> usersMap = new HashMap<String, String>();

		UnsyncBufferedReader unsyncBufferedReader =
			new UnsyncBufferedReader(new FileReader(usersFile));

		String line = unsyncBufferedReader.readLine();

		while (line != null) {
			String[] array = StringUtil.split(line);

			if ((array.length == 2) && (Validator.isNotNull(array[0])) &&
				(Validator.isNotNull(array[1]))) {

				usersMap.put(array[0], array[1]);
			}
			else {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Ignoring line " + line +
							" because it does not contain exactly 2 columns");
				}
			}

			line = unsyncBufferedReader.readLine();
		}

		return usersMap;
	}

	private static final String[] _SPECIAL_MEDIA_WIKI_DIRS = {
		"thumb", "temp", "archive"
	};

	private static final String _WORK_IN_PROGRESS = "{{Work in progress}}";

	private static final String _WORK_IN_PROGRESS_TAG = "work in progress";

	private static Log _log = LogFactoryUtil.getLog(MediaWikiImporter.class);

	private static Pattern _categoriesPattern = Pattern.compile(
		"\\[\\[[Cc]ategory:([^\\]]*)\\]\\][\\n]*");
	private static Pattern _parentPattern = Pattern.compile(
		"\\{{2}OtherTopics\\|([^\\}]*)\\}{2}");
	private static Pattern _redirectPattern = Pattern.compile(
		"#REDIRECT \\[\\[([^\\]]*)\\]\\]");

	private MediaWikiToCreoleTranslator _translator =
		new MediaWikiToCreoleTranslator();

}