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

package com.liferay.portal.language;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.tools.LangBuilder;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import java.net.URL;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Shuyang Zhou
 */
public class LanguageResources {

	public static String fixValue(String value) {
		try {
			value = new String(
				value.getBytes(StringPool.ISO_8859_1), StringPool.UTF8);
		}
		catch (UnsupportedEncodingException uee) {
			_log.error(uee, uee);
		}

		if (value.endsWith(LangBuilder.AUTOMATIC_COPY)) {
			value = value.substring(
				0, value.length() - LangBuilder.AUTOMATIC_COPY.length());
		}

		if (value.endsWith(LangBuilder.AUTOMATIC_TRANSLATION)) {
			value = value.substring(
				0,
				value.length() - LangBuilder.AUTOMATIC_TRANSLATION.length());
		}

		return value;
	}

	public static String getMessage(Locale locale, String key) {
		if (locale == null) {
			return null;
		}

		Map<String, String> languageMap = _languageMaps.get(locale);

		if (languageMap == null) {
			languageMap = _loadLocale(locale);
		}

		String value = languageMap.get(key);

		if (value == null) {
			return getMessage(_getSuperLocale(locale), key);
		}
		else {
			return value;
		}
	}

	public static Map<String, String> putLanguageMap(
		Locale locale, Map<String, String> languageMap) {

		Map<String, String> oldLanguageMap = _languageMaps.get(locale);

		if (oldLanguageMap == null) {
			_loadLocale(locale);
			oldLanguageMap = _languageMaps.get(locale);
		}

		Map<String, String> newLanguageMap = new HashMap<String, String>();

		if (oldLanguageMap != null) {
			newLanguageMap.putAll(oldLanguageMap);
		}

		newLanguageMap.putAll(languageMap);

		_languageMaps.put(locale, newLanguageMap);

		return oldLanguageMap;
	}

	public void setConfig(String config) {
		_config = config;
	}

	private static Locale _getSuperLocale(Locale locale) {
		if (Validator.isNotNull(locale.getVariant())) {
			return new Locale(locale.getLanguage(), locale.getCountry());
		}

		if (Validator.isNotNull(locale.getCountry())) {
			if (LanguageUtil.isDuplicateLanguageCode(locale.getLanguage())) {
				Locale priorityLocale = LanguageUtil.getLocale(
					locale.getLanguage());

				if (!locale.equals(priorityLocale)) {
					return new Locale(
						priorityLocale.getLanguage(),
						priorityLocale.getCountry());
				}
			}

			return new Locale(locale.getLanguage());
		}

		if (Validator.isNotNull(locale.getLanguage())) {
			return new Locale(StringPool.BLANK);
		}

		return null;
	}

	private static Map<String, String> _loadLocale(Locale locale) {
		String[] names = StringUtil.split(
			_config.replace(StringPool.PERIOD, StringPool.SLASH));

		Map<String, String> languageMap = null;

		if (names.length > 0) {
			String localeName = locale.toString();

			languageMap = new HashMap<String, String>();

			for (String name : names) {
				StringBundler sb = new StringBundler(4);

				sb.append(name);

				if (localeName.length() > 0) {
					sb.append(StringPool.UNDERLINE);
					sb.append(localeName);
				}

				sb.append(".properties");

				Properties properties = _loadProperties(sb.toString());

				for (Map.Entry<Object, Object> entry : properties.entrySet()) {
					String key = (String)entry.getKey();
					String value = (String)entry.getValue();

					value = fixValue(value);

					languageMap.put(key, value);
				}
			}
		}
		else {
			languageMap = Collections.EMPTY_MAP;
		}

		_languageMaps.put(locale, languageMap);

		return languageMap;
	}

	private static Properties _loadProperties(String name) {
		Properties properties = new Properties();

		try {
			ClassLoader classLoader = LanguageResources.class.getClassLoader();

			URL url = classLoader.getResource(name);

			if (_log.isInfoEnabled()) {
				_log.info("Attempting to load " + name);
			}

			if (url != null) {
				InputStream inputStream = url.openStream();

				properties.load(inputStream);

				inputStream.close();

				if (_log.isInfoEnabled()) {
					_log.info(
						"Loading " + url + " with " + properties.size() +
							" values");
				}
			}
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(e, e);
			}
		}

		return properties;
	}

	private static Log _log = LogFactoryUtil.getLog(LanguageResources.class);

	private static String _config;
	private static Map<Locale, Map<String, String>> _languageMaps =
		new ConcurrentHashMap<Locale, Map<String, String>>(64);

}