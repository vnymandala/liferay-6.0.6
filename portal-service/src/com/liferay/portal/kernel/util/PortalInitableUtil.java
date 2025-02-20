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

import java.util.List;
import java.util.Vector;

/**
 * @author	   Brian Wing Shun Chan
 * @deprecated {@link PortalLifecycleUtil}
 */
public class PortalInitableUtil {

	public static synchronized void flushInitables() {
		if (_portalInitables != null) {
			for (PortalInitable portalInitable : _portalInitables) {
				portalInitable.portalInit();
			}

			_portalInitables = null;
		}
	}

	public static synchronized void init(PortalInitable portalInitable) {
		if (_portalInitables == null) {
			portalInitable.portalInit();
		}
		else {
			_portalInitables.add(portalInitable);
		}
	}

	private static List<PortalInitable> _portalInitables =
		new Vector<PortalInitable>();

}