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

package com.liferay.portal.model;

import com.liferay.portal.ModelListenerException;

/**
 * @author Brian Wing Shun Chan
 */
public class BaseModelListener<T extends BaseModel<T>>
	implements ModelListener<T> {

	/**
	 * @throws ModelListenerException
	 */
	public void onAfterAddAssociation(
			Object classPK, String associationClassName,
			Object associationClassPK)
		throws ModelListenerException {
	}

	/**
	 * @throws ModelListenerException
	 */
	public void onAfterCreate(T model) throws ModelListenerException {
	}

	/**
	 * @throws ModelListenerException
	 */
	public void onAfterRemove(T model) throws ModelListenerException {
	}

	/**
	 * @throws ModelListenerException
	 */
	public void onAfterRemoveAssociation(
			Object classPK, String associationClassName,
			Object associationClassPK)
		throws ModelListenerException {
	}

	/**
	 * @throws ModelListenerException
	 */
	public void onAfterUpdate(T model) throws ModelListenerException {
	}

	/**
	 * @throws ModelListenerException
	 */
	public void onBeforeAddAssociation(
			Object classPK, String associationClassName,
			Object associationClassPK)
		throws ModelListenerException {
	}

	/**
	 * @throws ModelListenerException
	 */
	public void onBeforeCreate(T model) throws ModelListenerException {
	}

	/**
	 * @throws ModelListenerException
	 */
	public void onBeforeRemove(T model) throws ModelListenerException {
	}

	/**
	 * @throws ModelListenerException
	 */
	public void onBeforeRemoveAssociation(
			Object classPK, String associationClassName,
			Object associationClassPK)
		throws ModelListenerException {
	}

	/**
	 * @throws ModelListenerException
	 */
	public void onBeforeUpdate(T model) throws ModelListenerException {
	}

}