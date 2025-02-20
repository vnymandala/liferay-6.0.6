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

package com.liferay.util.servlet;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.nio.charset.CharsetEncoderUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.servlet.ByteBufferServletResponse;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.StringServletResponse;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.SocketException;

import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class ServletResponseUtil {

	public static void sendFile(
			HttpServletRequest request, HttpServletResponse response,
			String fileName, byte[] bytes)
		throws IOException {

		sendFile(request, response, fileName, bytes, null);
	}

	public static void sendFile(
			HttpServletRequest request, HttpServletResponse response,
			String fileName, byte[] bytes, String contentType)
		throws IOException {

		setHeaders(request, response, fileName, contentType);

		write(response, bytes);
	}

	public static void sendFile(
			HttpServletRequest request, HttpServletResponse response,
			String fileName, InputStream is)
		throws IOException {

		sendFile(request, response, fileName, is, null);
	}

	public static void sendFile(
			HttpServletRequest request, HttpServletResponse response,
			String fileName, InputStream is, int contentLength,
			String contentType)
		throws IOException {

		setHeaders(request, response, fileName, contentType);

		write(response, is, contentLength);
	}

	public static void sendFile(
			HttpServletRequest request, HttpServletResponse response,
			String fileName, InputStream is, String contentType)
		throws IOException {

		sendFile(request, response, fileName, is, 0, contentType);
	}

	/**
	 * @deprecated
	 */
	public static void sendFile(
			HttpServletResponse response, String fileName, byte[] bytes)
		throws IOException {

		sendFile(null, response, fileName, bytes);
	}

	/**
	 * @deprecated
	 */
	public static void sendFile(
			HttpServletResponse response, String fileName, byte[] bytes,
			String contentType)
		throws IOException {

		sendFile(null, response, fileName, bytes, contentType);
	}

	/**
	 * @deprecated
	 */
	public static void sendFile(
			HttpServletResponse response, String fileName, InputStream is)
		throws IOException {

		sendFile(null, response, fileName, is);
	}

	/**
	 * @deprecated
	 */
	public static void sendFile(
			HttpServletResponse response, String fileName, InputStream is,
			int contentLength, String contentType)
		throws IOException {

		sendFile(null, response, fileName, is, contentLength, contentType);
	}

	/**
	 * @deprecated
	 */
	public static void sendFile(
			HttpServletResponse response, String fileName, InputStream is,
			String contentType)
		throws IOException {

		sendFile(null, response, fileName, is, contentType);
	}

	public static void write(HttpServletResponse response, byte[] bytes)
		throws IOException {

		write(response, bytes, 0, 0);
	}

	public static void write(
			HttpServletResponse response, byte[] bytes, int offset,
			int contentLength)
		throws IOException {

		try {

			// LEP-3122

			if (!response.isCommitted()) {

				// LEP-536

				if (contentLength == 0) {
					contentLength = bytes.length;
				}

				response.setContentLength(contentLength);

				if (response instanceof ByteBufferServletResponse) {
					ByteBufferServletResponse byteBufferResponse =
						(ByteBufferServletResponse)response;

					byteBufferResponse.setByteBuffer(
						ByteBuffer.wrap(bytes, offset, contentLength));
				}
				else {
					ServletOutputStream servletOutputStream =
						response.getOutputStream();

					servletOutputStream.write(bytes, offset, contentLength);
				}
			}
		}
		catch (IOException ioe) {
			if (ioe instanceof SocketException ||
				ioe.getClass().getName().equals(_CLIENT_ABORT_EXCEPTION)) {

				if (_log.isWarnEnabled()) {
					_log.warn(ioe);
				}
			}
			else {
				throw ioe;
			}
		}
	}

	public static void write(HttpServletResponse response, byte[][] bytesArray)
		throws IOException {

		try {

			// LEP-3122

			if (!response.isCommitted()) {
				int contentLength = 0;

				for (byte[] bytes : bytesArray) {
					contentLength += bytes.length;
				}

				response.setContentLength(contentLength);

				ServletOutputStream servletOutputStream =
					response.getOutputStream();

				for (byte[] bytes : bytesArray) {
					servletOutputStream.write(bytes);
				}
			}
		}
		catch (IOException ioe) {
			if (ioe instanceof SocketException ||
				ioe.getClass().getName().equals(_CLIENT_ABORT_EXCEPTION)) {

				if (_log.isWarnEnabled()) {
					_log.warn(ioe);
				}
			}
			else {
				throw ioe;
			}
		}
	}

	public static void write(
			HttpServletResponse response, ByteBuffer byteBuffer)
		throws IOException {

		if (response instanceof ByteBufferServletResponse) {
			ByteBufferServletResponse byteBufferResponse =
				(ByteBufferServletResponse)response;

			byteBufferResponse.setByteBuffer(byteBuffer);
		}
		else {
			write(
				response, byteBuffer.array(), byteBuffer.position(),
				byteBuffer.limit());
		}
	}

	public static void write(HttpServletResponse response, File file)
		throws IOException {

		if (response instanceof ByteBufferServletResponse) {
			ByteBufferServletResponse byteBufferResponse =
				(ByteBufferServletResponse)response;

			ByteBuffer byteBuffer = ByteBuffer.wrap(FileUtil.getBytes(file));

			byteBufferResponse.setByteBuffer(byteBuffer);
		}
		else if (response instanceof StringServletResponse) {
			StringServletResponse stringResponse =
				(StringServletResponse)response;

			String s = FileUtil.read(file);

			stringResponse.setString(s);
		}
		else {
			FileInputStream fileInputStream = new FileInputStream(file);

			FileChannel fileChannel = fileInputStream.getChannel();

			try {
				int contentLength = (int)fileChannel.size();

				response.setContentLength(contentLength);

				fileChannel.transferTo(
					0, contentLength,
					Channels.newChannel(response.getOutputStream()));
			}
			finally {
				fileChannel.close();
			}
		}
	}

	public static void write(HttpServletResponse response, InputStream is)
		throws IOException {

		write(response, is, 0);
	}

	public static void write(
			HttpServletResponse response, InputStream is, int contentLength)
		throws IOException {

		if (response.isCommitted()) {
			return;
		}

		if (contentLength > 0) {
			response.setContentLength(contentLength);
		}

		StreamUtil.transfer(is, response.getOutputStream());
	}

	public static void write(HttpServletResponse response, String s)
		throws IOException {

		if (response instanceof StringServletResponse) {
			StringServletResponse stringResponse =
				(StringServletResponse)response;

			stringResponse.setString(s);
		}
		else {
			ByteBuffer byteBuffer = CharsetEncoderUtil.encode(
				StringPool.UTF8, s);

			write(response, byteBuffer);
		}
	}

	public static void write(
			HttpServletResponse response, StringServletResponse stringResponse)
		throws IOException {

		if (stringResponse.isCalledGetOutputStream()) {
			UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
				stringResponse.getUnsyncByteArrayOutputStream();

			ByteBuffer byteBuffer =
				unsyncByteArrayOutputStream.unsafeGetByteBuffer();

			write(response, byteBuffer);
		}
		else {
			write(response, stringResponse.getString());
		}
	}

	protected static void setHeaders(
		HttpServletRequest request, HttpServletResponse response,
		String fileName, String contentType) {

		if (_log.isDebugEnabled()) {
			_log.debug("Sending file of type " + contentType);
		}

		// LEP-2201

		if (Validator.isNotNull(contentType)) {
			response.setContentType(contentType);
		}

		response.setHeader(
			HttpHeaders.CACHE_CONTROL, HttpHeaders.CACHE_CONTROL_PUBLIC_VALUE);
		response.setHeader(HttpHeaders.PRAGMA, HttpHeaders.PRAGMA_PUBLIC_VALUE);

		if (Validator.isNotNull(fileName)) {
			String contentDisposition =
				"attachment; filename=\"" + fileName + "\"";

			// If necessary for non-ASCII characters, encode based on RFC 2184.
			// However, not all browsers support RFC 2184. See LEP-3127.

			boolean ascii = true;

			for (int i = 0; i < fileName.length(); i++) {
				if (!Validator.isAscii(fileName.charAt(i))) {
					ascii = false;

					break;
				}
			}

			try {
				if (!ascii) {
					String encodedFileName = HttpUtil.encodeURL(fileName, true);

					if (BrowserSnifferUtil.isIe(request)) {
						contentDisposition =
							"attachment; filename=\"" + encodedFileName + "\"";
					}
					else {
						contentDisposition =
							"attachment; filename*=UTF-8''" + encodedFileName;
					}
				}
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(e);
				}
			}

			String extension = GetterUtil.getString(
				FileUtil.getExtension(fileName)).toLowerCase();

			String[] mimeTypesContentDispositionInline = null;

			try {
				mimeTypesContentDispositionInline = PropsUtil.getArray(
					"mime.types.content.disposition.inline");
			}
			catch (Exception e) {
				mimeTypesContentDispositionInline = new String[0];
			}

			if (ArrayUtil.contains(
					mimeTypesContentDispositionInline, extension)) {

				contentDisposition = StringUtil.replace(
					contentDisposition, "attachment; ", "inline; ");
			}

			response.setHeader(
				HttpHeaders.CONTENT_DISPOSITION, contentDisposition);
		}
	}

	private static final String _CLIENT_ABORT_EXCEPTION =
		"org.apache.catalina.connector.ClientAbortException";

	private static Log _log = LogFactoryUtil.getLog(ServletResponseUtil.class);

}