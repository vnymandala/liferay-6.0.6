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

package com.liferay.portal.image;

import com.liferay.documentlibrary.NoSuchFileException;
import com.liferay.documentlibrary.service.DLLocalServiceUtil;
import com.liferay.documentlibrary.service.DLServiceUtil;
import com.liferay.portal.NoSuchImageException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortletKeys;

import java.io.IOException;
import java.io.InputStream;

import java.util.Date;

/**
 * @author Jorge Ferrer
 */
public class DLHook extends BaseHook {

	public void deleteImage(Image image)
		throws PortalException, SystemException {

		String fileName = getFileName(image.getImageId(), image.getType());

		try {
			DLServiceUtil.deleteFile(
				_COMPANY_ID, _PORTLET_ID, _REPOSITORY_ID, fileName);
		}
		catch (NoSuchFileException nsfe) {
			throw new NoSuchImageException(nsfe);
		}
	}

	public byte[] getImageAsBytes(Image image)
		throws PortalException, SystemException {

		String fileName = getFileName(image.getImageId(), image.getType());

		InputStream is = DLLocalServiceUtil.getFileAsStream(
			_COMPANY_ID, _REPOSITORY_ID, fileName);

		byte[] bytes = null;

		try {
			bytes = FileUtil.getBytes(is);
		}
		catch (IOException ioe) {
			throw new SystemException(ioe);
		}

		return bytes;
	}

	public InputStream getImageAsStream(Image image)
		throws PortalException, SystemException {

		String fileName = getFileName(image.getImageId(), image.getType());

		return DLLocalServiceUtil.getFileAsStream(
			_COMPANY_ID, _REPOSITORY_ID, fileName);
	}

	public void updateImage(Image image, String type, byte[] bytes)
		throws PortalException, SystemException {

		String fileName = getFileName(image.getImageId(), image.getType());
		Date now = new Date();
		InputStream is = new UnsyncByteArrayInputStream(bytes);

		if (DLLocalServiceUtil.hasFile(
			_COMPANY_ID, _REPOSITORY_ID, fileName, _VERSION_NUMBER)) {

			DLServiceUtil.deleteFile(
				_COMPANY_ID, _PORTLET_ID, _REPOSITORY_ID, fileName);
		}

		DLLocalServiceUtil.addFile(
			_COMPANY_ID, _PORTLET_ID, _GROUP_ID, _REPOSITORY_ID, fileName, true,
			_FILE_ENTRY_ID, _PROPERTIES, now, new ServiceContext(), is);
	}

	protected String getFileName(long imageId, String type) {
		return imageId + StringPool.PERIOD + type;
	}

	private static final long _COMPANY_ID = 0;
	private static final long _FILE_ENTRY_ID = 0;
	private static final long _GROUP_ID = 0;
	private static final String _PORTLET_ID = PortletKeys.PORTAL;
	private static final String _PROPERTIES = StringPool.BLANK;
	private static final long _REPOSITORY_ID = 0;
	private static final String _VERSION_NUMBER = "1.0";

}