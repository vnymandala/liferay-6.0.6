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

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClassLoaderProxy {

	/**
	 * @deprecated
	 */
	public ClassLoaderProxy(Object obj, ClassLoader classLoader) {
		this(obj, obj.getClass().getName(), classLoader);
	}

	public ClassLoaderProxy(
		Object obj, String className, ClassLoader classLoader) {

		_obj = obj;
		_className = className;
		_classLoader = classLoader;
	}

	public ClassLoader getClassLoader() {
		return _classLoader;
	}

	public String getClassName() {
		return _className;
	}

	public Object invoke(MethodHandler methodHandler) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			return methodHandler.invoke(_obj);
		}
		catch (InvocationTargetException ite) {
			throw translateThrowable(ite.getCause(), contextClassLoader);
		}
		catch (Throwable t) {
			_log.error(t, t);

			throw t;
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	/**
	 * @deprecated
	 */
	public Object invoke(String methodName, Object[] args) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			Class<?> classObj = Class.forName(_className, true, _classLoader);

			List<Class<?>> parameterTypes = new ArrayList<Class<?>>();

			for (int i = 0; i < args.length; i++) {
				Object arg = args[i];

				Class<?> argClass = Class.forName(
					arg.getClass().getName(), true, _classLoader);

				if (ClassUtil.isSubclass(argClass, PrimitiveWrapper.class)) {
					MethodKey methodKey = new MethodKey(
						argClass.getName(), "getValue");

					Method method = MethodCache.get(methodKey);

					args[i] = method.invoke(arg, (Object[])null);

					argClass = (Class<?>)argClass.getField("TYPE").get(arg);
				}

				if (ClassUtil.isSubclass(argClass, NullWrapper.class)) {
					NullWrapper nullWrapper = (NullWrapper)arg;

					argClass = Class.forName(
						nullWrapper.getClassName(), true, _classLoader);

					args[i] = null;
				}

				parameterTypes.add(argClass);
			}

			Method method = null;

			try {
				method = classObj.getMethod(
					methodName,
					parameterTypes.toArray(new Class[parameterTypes.size()]));
			}
			catch (NoSuchMethodException nsme) {
				Method[] methods = ((Class<?>)classObj).getMethods();

				for (int i = 0; i < methods.length; i++) {
					Class<?>[] methodParameterTypes =
						methods[i].getParameterTypes();

					if (methods[i].getName().equals(methodName) &&
						methodParameterTypes.length == parameterTypes.size()) {

						boolean correctParams = true;

						for (int j = 0; j < parameterTypes.size(); j++) {
							Class<?> a = parameterTypes.get(j);
							Class<?> b = methodParameterTypes[j];

							if (!ClassUtil.isSubclass(a, b)) {
								correctParams = false;

								break;
							}
						}

						if (correctParams) {
							method = methods[i];

							break;
						}
					}
				}

				if (method == null) {
					throw nsme;
				}
			}

			return method.invoke(_obj, args);
		}
		catch (InvocationTargetException ite) {
			throw translateThrowable(ite.getCause(), contextClassLoader);
		}
		catch (Throwable t) {
			_log.error(t, t);

			throw t;
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	protected Throwable translateThrowable(
		Throwable t1, ClassLoader contextClassLoader) {

		try {
			UnsyncByteArrayOutputStream ubaos =
				new UnsyncByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(ubaos);

			oos.writeObject(t1);

			oos.flush();
			oos.close();

			UnsyncByteArrayInputStream bais = new UnsyncByteArrayInputStream(
				ubaos.unsafeGetByteArray(), 0, ubaos.size());
			ObjectInputStream ois = new ClassLoaderObjectInputStream(
				bais, contextClassLoader);

			t1 = (Throwable)ois.readObject();

			ois.close();

			return t1;
		}
		catch (Throwable t2) {
			_log.error(t2, t2);

			return t2;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClassLoaderProxy.class);

	private Object _obj;
	private ClassLoader _classLoader;
	private String _className;

}