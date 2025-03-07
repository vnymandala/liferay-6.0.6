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

package com.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class UserFinderUtil {
	public static int countByUser(long userId,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByUser(userId, params);
	}

	public static int countByKeywords(long companyId,
		java.lang.String keywords, java.lang.Boolean active,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByKeywords(companyId, keywords, active, params);
	}

	public static int countByC_FN_MN_LN_SN_EA_A(long companyId,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String screenName,
		java.lang.String emailAddress, java.lang.Boolean active,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_FN_MN_LN_SN_EA_A(companyId, firstName, middleName,
			lastName, screenName, emailAddress, active, params, andOperator);
	}

	public static int countByC_FN_MN_LN_SN_EA_A(long companyId,
		java.lang.String[] firstNames, java.lang.String[] middleNames,
		java.lang.String[] lastNames, java.lang.String[] screenNames,
		java.lang.String[] emailAddresses, java.lang.Boolean active,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_FN_MN_LN_SN_EA_A(companyId, firstNames,
			middleNames, lastNames, screenNames, emailAddresses, active,
			params, andOperator);
	}

	public static java.util.List<com.liferay.portal.model.User> findByKeywords(
		long companyId, java.lang.String keywords, java.lang.Boolean active,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByKeywords(companyId, keywords, active, params, start,
			end, obc);
	}

	public static java.util.List<com.liferay.portal.model.User> findByNoAnnouncementsDeliveries(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByNoAnnouncementsDeliveries(type);
	}

	public static java.util.List<com.liferay.portal.model.User> findByNoContacts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByNoContacts();
	}

	public static java.util.List<com.liferay.portal.model.User> findByNoGroups()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByNoGroups();
	}

	public static java.util.List<com.liferay.portal.model.User> findByC_FN_MN_LN_SN_EA_A(
		long companyId, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String screenName, java.lang.String emailAddress,
		java.lang.Boolean active,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_FN_MN_LN_SN_EA_A(companyId, firstName, middleName,
			lastName, screenName, emailAddress, active, params, andOperator,
			start, end, obc);
	}

	public static java.util.List<com.liferay.portal.model.User> findByC_FN_MN_LN_SN_EA_A(
		long companyId, java.lang.String[] firstNames,
		java.lang.String[] middleNames, java.lang.String[] lastNames,
		java.lang.String[] screenNames, java.lang.String[] emailAddresses,
		java.lang.Boolean active,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_FN_MN_LN_SN_EA_A(companyId, firstNames,
			middleNames, lastNames, screenNames, emailAddresses, active,
			params, andOperator, start, end, obc);
	}

	public static UserFinder getFinder() {
		if (_finder == null) {
			_finder = (UserFinder)PortalBeanLocatorUtil.locate(UserFinder.class.getName());
		}

		return _finder;
	}

	public void setFinder(UserFinder finder) {
		_finder = finder;
	}

	private static UserFinder _finder;
}