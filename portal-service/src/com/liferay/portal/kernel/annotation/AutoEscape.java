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

package com.liferay.portal.kernel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Enables HTML auto escaping of strings returned by annotated methods when a
 * bean is wrapped with {@link
 * com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
 *
 * <p>
 * For a usage example, see {@link com.liferay.portal.model.UserModel}.
 * </p>
 *
 * @author Shuyang Zhou
 * @see	   com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AutoEscape {
}