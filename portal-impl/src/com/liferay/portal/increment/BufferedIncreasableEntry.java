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

package com.liferay.portal.increment;

import com.liferay.portal.kernel.concurrent.IncreasableEntry;
import com.liferay.portal.kernel.increment.Increment;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Zsolt Berentey
 */
public class BufferedIncreasableEntry<K, T>
	extends IncreasableEntry<K, Increment<T>> {

	public BufferedIncreasableEntry(
		MethodInterceptor nextInterceptor, MethodInvocation methodInvocation,
		K key, Increment<T> value) {

		super(key, value);

		_methodInvocation = methodInvocation;
		_nextInterceptor = nextInterceptor;
	}

	public Increment<T> doIncrease(
		Increment<T> originalValue, Increment<T> deltaValue) {

		return originalValue.increaseForNew(deltaValue.getValue());
	}

	public void proceed() throws Throwable {
		Object[] arguments = _methodInvocation.getArguments();

		arguments[arguments.length - 1] = getValue().getValue();

		_nextInterceptor.invoke(_methodInvocation);
	}

	private MethodInvocation _methodInvocation;
	private MethodInterceptor _nextInterceptor;

}