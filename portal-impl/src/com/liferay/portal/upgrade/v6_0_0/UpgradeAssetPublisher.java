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

package com.liferay.portal.upgrade.v6_0_0;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.upgrade.BaseUpgradePortletPreferences;
import com.liferay.portlet.PortletPreferencesImpl;
import com.liferay.portlet.PortletPreferencesSerializer;

/**
 * @author Julio Camarero
 */
public class UpgradeAssetPublisher extends BaseUpgradePortletPreferences {

	protected String getUpdatePortletPreferencesWhereClause() {
		return "portletId like '101_INSTANCE_%'";
	}

	protected String upgradePreferences(
			long companyId, long ownerId, int ownerType, long plid,
			String portletId, String xml)
		throws Exception {

		PortletPreferencesImpl preferences =
			PortletPreferencesSerializer.fromXML(
				companyId, ownerId, ownerType, plid, portletId, xml);

		long layoutId = GetterUtil.getLong(
			preferences.getValue("lfr-scope-layout-id", null));

		preferences.reset("lfr-scope-layout-id");

		if (layoutId != 0) {
			preferences.setValues(
				"scope-ids", new String[] {"Layout_" + layoutId});

			preferences.setValue("default-scope", Boolean.FALSE.toString());
		}

		long classNameId = GetterUtil.getLong(
			preferences.getValue("class-name-id", null));

		preferences.reset("class-name-id");

		if (classNameId != 0) {
			preferences.setValues(
				"class-name-ids", new String[] {String.valueOf(classNameId)});

			preferences.setValue("any-asset-type", Boolean.FALSE.toString());
		}

		boolean andOperator = GetterUtil.getBoolean(
			preferences.getValue("and-operator", null));

		preferences.reset("and-operator");

		String[] assetTagNames = preferences.getValues("entries", null);
		String[] notAssetTagNames = preferences.getValues("not-entries", null);

		int i = 0;

		if (assetTagNames != null) {
			preferences.reset("entries");

			preferences.setValue("queryContains" + i, Boolean.TRUE.toString());
			preferences.setValue(
				"queryAndOperator" + i, String.valueOf(andOperator));
			preferences.setValue("queryName" + i, "assetTags");
			preferences.setValues("queryValues" + i, assetTagNames);

			i++;
		}

		if (notAssetTagNames != null) {
			preferences.reset("not-entries");

			preferences.setValue("queryContains" + i, Boolean.FALSE.toString());
			preferences.setValue(
				"queryAndOperator" + i, String.valueOf(andOperator));
			preferences.setValue("queryName" + i, "assetTags");
			preferences.setValues("queryValues" + i, notAssetTagNames);

			i++;
		}

		return PortletPreferencesSerializer.toXML(preferences);
	}

}