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

package com.liferay.portlet.bookmarks.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class BookmarksEntryFinderUtil {
	public static java.util.List<com.liferay.portlet.bookmarks.model.BookmarksEntry> findByNoAssets()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByNoAssets();
	}

	public static BookmarksEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (BookmarksEntryFinder)PortalBeanLocatorUtil.locate(BookmarksEntryFinder.class.getName());
		}

		return _finder;
	}

	public void setFinder(BookmarksEntryFinder finder) {
		_finder = finder;
	}

	private static BookmarksEntryFinder _finder;
}