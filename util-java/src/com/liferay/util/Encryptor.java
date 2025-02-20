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

package com.liferay.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.Digester;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ServerDetector;

import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * @author Brian Wing Shun Chan
 */
public class Encryptor {

	public static final String ENCODING = Digester.ENCODING;

	public static final String KEY_ALGORITHM = "DES";

	public static final String SUN_PROVIDER_CLASS =
		"com.sun.crypto.provider.SunJCE";

	public static final String IBM_PROVIDER_CLASS =
		"com.ibm.crypto.provider.IBMJCE";

	public static final String PROVIDER_CLASS = GetterUtil.getString(
		SystemProperties.get(Encryptor.class.getName() + ".provider.class"),
		SUN_PROVIDER_CLASS);

	public static Key generateKey() throws EncryptorException {
		return generateKey(KEY_ALGORITHM);
	}

	public static Key generateKey(String algorithm) throws EncryptorException {
		try {
			Security.addProvider(getProvider());

			KeyGenerator generator = KeyGenerator.getInstance(algorithm);
			generator.init(56, new SecureRandom());

			Key key = generator.generateKey();

			return key;
		}
		catch (Exception e) {
			throw new EncryptorException(e);
		}
	}

	public static Provider getProvider()
		throws ClassNotFoundException, IllegalAccessException,
			   InstantiationException {

		Class<?> providerClass = null;

		try {
			providerClass = Class.forName(PROVIDER_CLASS);
		}
		catch (ClassNotFoundException cnfe) {
			if ((ServerDetector.isWebSphere()) &&
				(PROVIDER_CLASS.equals(SUN_PROVIDER_CLASS))) {

				if (_log.isWarnEnabled()) {
					_log.warn(
						"WebSphere does not have " + SUN_PROVIDER_CLASS +
							", using " + IBM_PROVIDER_CLASS + " instead");
				}

				providerClass = Class.forName(IBM_PROVIDER_CLASS);
			}
			else if (System.getProperty("java.vm.vendor").equals(
						"IBM Corporation")) {

				if (_log.isWarnEnabled()) {
					_log.warn(
						"IBM JVM does not have " + SUN_PROVIDER_CLASS +
							", using " + IBM_PROVIDER_CLASS + " instead");
				}

				providerClass = Class.forName(IBM_PROVIDER_CLASS);
			}
			else {
				throw cnfe;
			}
		}

		return (Provider)providerClass.newInstance();
	}

	public static String decrypt(Key key, String encryptedString)
		throws EncryptorException {

		byte[] encryptedBytes = Base64.decode(encryptedString);

		return decryptUnencodedAsString(key, encryptedBytes);
	}

	public static byte[] decryptUnencodedAsBytes(Key key, byte[] encryptedBytes)
		throws EncryptorException {

		try {
			Security.addProvider(getProvider());

			Cipher cipher = Cipher.getInstance(key.getAlgorithm());

			cipher.init(Cipher.DECRYPT_MODE, key);

			return cipher.doFinal(encryptedBytes);
		}
		catch (Exception e) {
			throw new EncryptorException(e);
		}
	}

	public static String decryptUnencodedAsString(
			Key key, byte[] encryptedBytes)
		throws EncryptorException {

		try {
			byte[] decryptedBytes = decryptUnencodedAsBytes(
				key, encryptedBytes);

			return new String(decryptedBytes, ENCODING);
		}
		catch (Exception e) {
			throw new EncryptorException(e);
		}
	}

	public static String digest(String text) {
		return DigesterUtil.digest(text);
	}

	public static String digest(String algorithm, String text) {
		return DigesterUtil.digest(algorithm, text);
	}

	public static String encrypt(Key key, String plainText)
		throws EncryptorException {

		byte[] encryptedBytes = encryptUnencoded(key, plainText);

		return Base64.encode(encryptedBytes);
	}

	public static byte[] encryptUnencoded(Key key, byte[] plainBytes)
		throws EncryptorException {

		try {
			Security.addProvider(getProvider());

			Cipher cipher = Cipher.getInstance(key.getAlgorithm());

			cipher.init(Cipher.ENCRYPT_MODE, key);

			return cipher.doFinal(plainBytes);
		}
		catch (Exception e) {
			throw new EncryptorException(e);
		}
	}

	public static byte[] encryptUnencoded(Key key, String plainText)
		throws EncryptorException {

		try {
			byte[] decryptedBytes = plainText.getBytes(ENCODING);

			return encryptUnencoded(key, decryptedBytes);
		}
		catch (Exception e) {
			throw new EncryptorException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(Encryptor.class);

}