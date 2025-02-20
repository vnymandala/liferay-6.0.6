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

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

/**
 * Stores and retrieves localized strings from XML, and provides utility methods
 * for updating localizations from JSON, portlet requests, and maps. Used for
 * adding localization to strings, most often for model properties.
 *
 * <p>
 * Caching of the localized values is done in this class rather than in the
 * value object since value objects get flushed from cache fairly quickly.
 * Though lookups performed on a key based on an XML file is slower than lookups
 * done at the value object level in general, the value object will get flushed
 * at a rate which works against the performance gain. The cache is a soft hash
 * map which prevents memory leaks within the system while enabling the cache to
 * live longer than in a weak hash map.
 * </p>
 *
 * @author Alexander Chow
 * @author Jorge Ferrer
 * @author Mauro Mariuzzo
 * @author Julio Camarero
 * @author Brian Wing Shun Chan
 */
public interface Localization {

	/**
	 * Deserializes the JSON object into a map of locales and localized strings.
	 *
	 * @param  jsonObject the JSON object to deserialize
	 * @return the locales and localized strings
	 */
	public Object deserialize(JSONObject jsonObject);

	/**
	 * Gets the available locales from the localizations XML
	 *
	 * @param  xml the localizations XML to get the available locales from
	 * @return the language ids of the available locales
	 */
	public String[] getAvailableLocales(String xml);

	/**
	 * Gets the default locale from the localizations XML.
	 *
	 * @param  xml the localizations XML to get the default locale from
	 * @return the language id of the default locale, or the system default
	 *		   locale if the default locale cannot be retrieved from the XML
	 */
	public String getDefaultLocale(String xml);

	/**
	 * Gets the localized string from the localizations XML. Uses the default
	 * language if no localization exists for the requested language.
	 *
	 * @param  xml the localizations XML to get the localized string from
	 * @param  requestedLanguageId the id of the language to get the
	 *		   localization for
	 * @return the localized string
	 */
	public String getLocalization(String xml, String requestedLanguageId);

	/**
	 * Gets the localized string from the localizations XML, optionally using
	 * the default language if the no localization exists for the requested
	 * language.
	 *
	 * @param  xml the localizations XML to get the localized string from
	 * @param  requestedLanguageId the id of the language to get the
	 *		   localization for
	 * @param  useDefault whether to use the default language if no localization
	 *		   exists for the requested language
	 * @return the localized string. If <code>useDefault</code> is
	 *		   <code>false</code> and no localization exists for the requested
	 *		   language, an empty string will be returned.
	 */
	public String getLocalization(
		String xml, String requestedLanguageId, boolean useDefault);

	/**
	 * Gets a map of locales and localized strings for the parameter in the
	 * portlet request.
	 *
	 * @param  portletRequest the portlet request to get the locales and
	 *		   localized strings from
	 * @param  parameter the prefix of the parameters containing the localized
	 *		   strings. Each localization will be loaded from a parameter with
	 *		   this prefix, followed by an underscore, and the language id.
	 * @return the locales and localized strings
	 */
	public Map<Locale, String> getLocalizationMap(
		PortletRequest portletRequest, String parameter);

	/**
	 * Gets a map of locales and localized strings from the localizations XML.
	 *
	 * @param  xml the localizations XML to get the locales and localized
	 *		   strings from
	 * @return the locales and localized strings
	 */
	public Map<Locale, String> getLocalizationMap(String xml);

	/**
	 * Gets an xml of locales and localized strings for the parameter in the
	 * portlet request.
	 *
	 * @param  preferences the preferences container to get the localized value
	 *		   from
	 * @param  portletRequest the portlet request to get the locales and
	 *		   localized strings from
	 * @param  parameter the prefix of the parameters containing the localized
	 *		   strings. Each localization will be loaded from a parameter with
	 *		   this prefix, followed by an underscore, and the language id.
	 * @return the locales and localized strings
	 */
	public String getLocalizationXmlFromPreferences(
		PortletPreferences preferences, PortletRequest portletRequest,
		String parameter);

	/**
	 * @deprecated use {@link #getLocalizationMap(PortletRequest, String)}
	 *			   instead.
	 */
	public Map<Locale, String> getLocalizedParameter(
		PortletRequest portletRequest, String parameter);

	/**
	 * Gets the localized preferences value for the key. Uses the default
	 * language if no localization exists for the requested language.
	 *
	 * @param  preferences the preferences container to get the localized value
	 *		   from
	 * @param  key the preferences key to get the localized value for
	 * @param  languageId the id of the language to get the localization for
	 * @return the localized preferences value
	 */
	public String getPreferencesValue(
		PortletPreferences preferences, String key, String languageId);

	/**
	 * Gets the localized preferences value for the key, optionally using the
	 * default language if the no localization exists for the requested
	 * language.
	 *
	 * @param  preferences the preferences container to get the localized value
	 *		   from
	 * @param  key the preferences key to get the localized value for
	 * @param  languageId the id of the language to get the localization for
	 * @param  useDefault whether to use the default language if no localization
	 *		   exists for the requested language
	 * @return the localized preferences value. If <code>useDefault</code> is
	 *		   <code>false</code> and no localization exists for the requested
	 *		   language, an empty string will be returned.
	 */
	public String getPreferencesValue(
		PortletPreferences preferences, String key, String languageId,
		boolean useDefault);

	/**
	 * Gets the localized preferences values for the key. Uses the default
	 * language if no localization exists for the requested language.
	 *
	 * @param  preferences the preferences container to get the localized values
	 *		   from
	 * @param  key the preferences key to get localized values for
	 * @param  languageId the id of the language to get the localizations for
	 * @return the localized preferences values
	 */
	public String[] getPreferencesValues(
		PortletPreferences preferences, String key, String languageId);

	/**
	 * Gets the localized preferences values for the key, optionally using the
	 * default language if the no localization exists for the requested
	 * language.
	 *
	 * @param  preferences the preferences container to get the localized values
	 *		   from
	 * @param  key the preferences key to get localized values for
	 * @param  languageId the id of the language to get the localizations for
	 * @param  useDefault whether to use the default language if no localization
	 *		   exists for the requested language
	 * @return the localized preferences values. If <code>useDefault</code> is
	 *		   <code>false</code> and no localization exists for the requested
	 *		   language, an empty array will be returned.
	 */
	public String[] getPreferencesValues(
		PortletPreferences preferences, String key, String languageId,
		boolean useDefault);

	/**
	 * Removes the localization for the language from the localizations XML.
	 * Stores the localized strings as characters in the XML.
	 *
	 * @param  xml the localizations XML to remove the localization for the
	 *		   language from
	 * @param  key the name of the localized string, such as &quot;Title&quot;
	 * @param  requestedLanguageId the id of the language to remove from the
	 *		   localizations XML
	 * @return the localizations XML with the language removed
	 */
	public String removeLocalization(
		String xml, String key, String requestedLanguageId);

	/**
	 * Removes the localization for the language from the localizations XML,
	 * optionally storing the localized strings as CDATA in the XML.
	 *
	 * @param  xml the localizations XML to remove the localization for the
	 *		   language from
	 * @param  key the name of the localized string, such as &quot;Title&quot;
	 * @param  requestedLanguageId the id of the language to remove from the
	 *		   localizations XML
	 * @param  cdata whether to store localized strings as CDATA in the XML
	 * @return the localizations XML with the language removed
	 */
	public String removeLocalization(
		String xml, String key, String requestedLanguageId, boolean cdata);

	/**
	 * Removes the localization for the language from the localizations XML,
	 * optionally storing the localized strings as CDATA in the XML.
	 *
	 * @param  xml the localizations XML to remove the localization for the
	 *         language from
	 * @param  key the name of the localized string, such as &quot;Title&quot;
	 * @param  requestedLanguageId the ID of the language to remove from the
	 *         localizations XML
	 * @param  cdata whether to store localized strings as CDATA in the XML
	 * @param  localized whether there is a localized field
	 * @return the localizations XML with the language removed
	 */
	public String removeLocalization(
		String xml, String key, String requestedLanguageId, boolean cdata,
		boolean localized);

	/**
	 * Sets the localized preferences values for the parameter in the portlet
	 * request.
	 *
	 * @param  portletRequest the portlet request to get the localized values
	 *		   from
	 * @param  preferences the preferences container to set the localized values
	 *		   in
	 * @param  parameter the prefix of the parameters containing the localized
	 *		   strings. Each localization will be loaded from a parameter with
	 *		   this prefix, followed by an underscore, and the language id.
	 * @throws Exception if an exception occurred
	 */
	public void setLocalizedPreferencesValues (
			PortletRequest portletRequest, PortletPreferences preferences,
			String parameter)
		throws Exception;

	/**
	 * Sets the localized preferences value for the key.
	 *
	 * @param  preferences the preferences container to store the localized
	 *		   value in
	 * @param  key the preferences key to set the localized value for
	 * @param  languageId the id of the language to set the localization for
	 * @param  value the localized value
	 * @throws Exception if an exception occurred
	 */
	public void setPreferencesValue(
			PortletPreferences preferences, String key, String languageId,
			String value)
		throws Exception;

	/**
	 * Sets the localized preferences values for the key.
	 *
	 * @param  preferences the preferences container to store the localized
	 *		   values in
	 * @param  key the preferences key to set the localized values for
	 * @param  languageId the id of the language to set the localizations for
	 * @param  values the localized values
	 * @throws Exception if an exception occurred
	 */
	public void setPreferencesValues(
			PortletPreferences preferences, String key, String languageId,
			String[] values)
		throws Exception;

	/**
	 * Updates the localized string for the system default language in the
	 * localizations XML. Stores the localized strings as characters in the XML.
	 *
	 * @param  xml the localizations XML to update the localized string in
	 * @param  key the name of the localized string, such as &quot;Title&quot;
	 * @param  value the localized string
	 * @return the updated localizations XML
	 */
	public String updateLocalization(String xml, String key, String value);

	/**
	 * Updates the localized string for the language in the localizations XML.
	 * Stores the localized strings as characters in the XML.
	 *
	 * @param  xml the localizations XML to update the localized string in
	 * @param  key the name of the localized string, such as &quot;Title&quot;
	 * @param  value the localized string
	 * @param  requestedLanguageId the id of the language to update the
	 *		   localization for
	 * @return the updated localizations XML
	 */
	public String updateLocalization(
		String xml, String key, String value, String requestedLanguageId);

	/**
	 * Updates the localized string for the language in the localizations XML
	 * and changes the default language. Stores the localized strings as
	 * characters in the XML.
	 *
	 * @param  xml the localizations XML to update the localized string in
	 * @param  key the name of the localized string, such as &quot;Title&quot;
	 * @param  value the localized string
	 * @param  requestedLanguageId the id of the language to update the
	 *		   localization for
	 * @param  defaultLanguageId the id of the default language
	 * @return the updated localizations XML
	 */
	public String updateLocalization(
		String xml, String key, String value, String requestedLanguageId,
		String defaultLanguageId);

	/**
	 * Updates the localized string for the language in the localizations XML
	 * and changes the default language, optionally storing the localized
	 * strings as CDATA in the XML.
	 *
	 * @param  xml the localizations XML to update the localized string in
	 * @param  key the name of the localized string, such as &quot;Title&quot;
	 * @param  value the localized string
	 * @param  requestedLanguageId the id of the language to update the
	 *		   localization for
	 * @param  defaultLanguageId the id of the default language
	 * @param  cdata whether to store localized strings as CDATA in the XML
	 * @return the updated localizations XML
	 */
	public String updateLocalization(
		String xml, String key, String value, String requestedLanguageId,
		String defaultLanguageId, boolean cdata);

	/**
	 * Updates the localized string for the language in the localizations XML
	 * and changes the default language, optionally storing the localized
	 * strings as CDATA in the XML.
	 *
	 * @param  xml the localizations XML to update the localized string in
	 * @param  key the name of the localized string, such as &quot;Title&quot;
	 * @param  value the localized string
	 * @param  requestedLanguageId the ID of the language to update the
	 *         localization for
	 * @param  defaultLanguageId the ID of the default language
	 * @param  cdata whether to store localized strings as CDATA in the XML
	 * @param  localized whether there is a localized field
	 * @return the updated localizations XML
	 */
	public String updateLocalization(
		String xml, String key, String value, String requestedLanguageId,
		String defaultLanguageId, boolean cdata, boolean localized);

}