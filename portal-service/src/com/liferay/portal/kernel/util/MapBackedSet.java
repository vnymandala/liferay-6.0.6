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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Shuyang Zhou
 */
public class MapBackedSet<E> extends AbstractSet<E> implements Serializable {

	public MapBackedSet(Map<E, Boolean> backedMap) {
		if (!backedMap.isEmpty()) {
			throw new IllegalArgumentException("Map is not empty");
		}

		_backedMap = backedMap;
		_backedMapKeySet = backedMap.keySet();
	}

	public boolean add(E element) {
		if (_backedMap.put(element, Boolean.TRUE) == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void clear() {
		_backedMap.clear();
	}

	public boolean contains(Object obj) {
		return _backedMap.containsKey(obj);
	}

	public boolean containsAll(Collection<?> collection) {
		return _backedMapKeySet.containsAll(collection);
	}

	public boolean equals(Object obj) {
		if ((obj == this) || _backedMapKeySet.equals(obj)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return _backedMapKeySet.hashCode();
	}

	public boolean isEmpty() {
		return _backedMap.isEmpty();
	}

	public Iterator<E> iterator() {
		return _backedMapKeySet.iterator();
	}

	public boolean remove(Object obj) {
		if (_backedMap.remove(obj) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean removeAll(Collection<?> collection) {
		return _backedMapKeySet.removeAll(collection);
	}

	public boolean retainAll(Collection<?> collection) {
		return _backedMapKeySet.retainAll(collection);
	}

	public int size() {
		return _backedMap.size();
	}

	public Object[] toArray() {
		return _backedMapKeySet.toArray();
	}

	public <T> T[] toArray(T[] array) {
		return _backedMapKeySet.toArray(array);
	}

	public String toString() {
		return _backedMapKeySet.toString();
	}

	private void readObject(ObjectInputStream objectInputStream)
		throws ClassNotFoundException, IOException {

		objectInputStream.defaultReadObject();

		_backedMapKeySet = _backedMap.keySet();
	}

	private final Map<E, Boolean> _backedMap;
	private transient Set<E> _backedMapKeySet;

}