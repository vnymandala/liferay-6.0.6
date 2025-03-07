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

package com.liferay.portlet.documentlibrary.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.documentlibrary.NoSuchFileShortcutException;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileShortcutPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (DLFileShortcutPersistence)PortalBeanLocatorUtil.locate(DLFileShortcutPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		DLFileShortcut dlFileShortcut = _persistence.create(pk);

		assertNotNull(dlFileShortcut);

		assertEquals(dlFileShortcut.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		DLFileShortcut newDLFileShortcut = addDLFileShortcut();

		_persistence.remove(newDLFileShortcut);

		DLFileShortcut existingDLFileShortcut = _persistence.fetchByPrimaryKey(newDLFileShortcut.getPrimaryKey());

		assertNull(existingDLFileShortcut);
	}

	public void testUpdateNew() throws Exception {
		addDLFileShortcut();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		DLFileShortcut newDLFileShortcut = _persistence.create(pk);

		newDLFileShortcut.setUuid(randomString());
		newDLFileShortcut.setGroupId(nextLong());
		newDLFileShortcut.setCompanyId(nextLong());
		newDLFileShortcut.setUserId(nextLong());
		newDLFileShortcut.setUserName(randomString());
		newDLFileShortcut.setCreateDate(nextDate());
		newDLFileShortcut.setModifiedDate(nextDate());
		newDLFileShortcut.setFolderId(nextLong());
		newDLFileShortcut.setToFolderId(nextLong());
		newDLFileShortcut.setToName(randomString());
		newDLFileShortcut.setStatus(nextInt());
		newDLFileShortcut.setStatusByUserId(nextLong());
		newDLFileShortcut.setStatusByUserName(randomString());
		newDLFileShortcut.setStatusDate(nextDate());

		_persistence.update(newDLFileShortcut, false);

		DLFileShortcut existingDLFileShortcut = _persistence.findByPrimaryKey(newDLFileShortcut.getPrimaryKey());

		assertEquals(existingDLFileShortcut.getUuid(),
			newDLFileShortcut.getUuid());
		assertEquals(existingDLFileShortcut.getFileShortcutId(),
			newDLFileShortcut.getFileShortcutId());
		assertEquals(existingDLFileShortcut.getGroupId(),
			newDLFileShortcut.getGroupId());
		assertEquals(existingDLFileShortcut.getCompanyId(),
			newDLFileShortcut.getCompanyId());
		assertEquals(existingDLFileShortcut.getUserId(),
			newDLFileShortcut.getUserId());
		assertEquals(existingDLFileShortcut.getUserName(),
			newDLFileShortcut.getUserName());
		assertEquals(Time.getShortTimestamp(
				existingDLFileShortcut.getCreateDate()),
			Time.getShortTimestamp(newDLFileShortcut.getCreateDate()));
		assertEquals(Time.getShortTimestamp(
				existingDLFileShortcut.getModifiedDate()),
			Time.getShortTimestamp(newDLFileShortcut.getModifiedDate()));
		assertEquals(existingDLFileShortcut.getFolderId(),
			newDLFileShortcut.getFolderId());
		assertEquals(existingDLFileShortcut.getToFolderId(),
			newDLFileShortcut.getToFolderId());
		assertEquals(existingDLFileShortcut.getToName(),
			newDLFileShortcut.getToName());
		assertEquals(existingDLFileShortcut.getStatus(),
			newDLFileShortcut.getStatus());
		assertEquals(existingDLFileShortcut.getStatusByUserId(),
			newDLFileShortcut.getStatusByUserId());
		assertEquals(existingDLFileShortcut.getStatusByUserName(),
			newDLFileShortcut.getStatusByUserName());
		assertEquals(Time.getShortTimestamp(
				existingDLFileShortcut.getStatusDate()),
			Time.getShortTimestamp(newDLFileShortcut.getStatusDate()));
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		DLFileShortcut newDLFileShortcut = addDLFileShortcut();

		DLFileShortcut existingDLFileShortcut = _persistence.findByPrimaryKey(newDLFileShortcut.getPrimaryKey());

		assertEquals(existingDLFileShortcut, newDLFileShortcut);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchFileShortcutException");
		}
		catch (NoSuchFileShortcutException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		DLFileShortcut newDLFileShortcut = addDLFileShortcut();

		DLFileShortcut existingDLFileShortcut = _persistence.fetchByPrimaryKey(newDLFileShortcut.getPrimaryKey());

		assertEquals(existingDLFileShortcut, newDLFileShortcut);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		DLFileShortcut missingDLFileShortcut = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingDLFileShortcut);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		DLFileShortcut newDLFileShortcut = addDLFileShortcut();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileShortcut.class,
				DLFileShortcut.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileShortcutId",
				newDLFileShortcut.getFileShortcutId()));

		List<DLFileShortcut> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		DLFileShortcut existingDLFileShortcut = result.get(0);

		assertEquals(existingDLFileShortcut, newDLFileShortcut);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileShortcut.class,
				DLFileShortcut.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileShortcutId", nextLong()));

		List<DLFileShortcut> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected DLFileShortcut addDLFileShortcut() throws Exception {
		long pk = nextLong();

		DLFileShortcut dlFileShortcut = _persistence.create(pk);

		dlFileShortcut.setUuid(randomString());
		dlFileShortcut.setGroupId(nextLong());
		dlFileShortcut.setCompanyId(nextLong());
		dlFileShortcut.setUserId(nextLong());
		dlFileShortcut.setUserName(randomString());
		dlFileShortcut.setCreateDate(nextDate());
		dlFileShortcut.setModifiedDate(nextDate());
		dlFileShortcut.setFolderId(nextLong());
		dlFileShortcut.setToFolderId(nextLong());
		dlFileShortcut.setToName(randomString());
		dlFileShortcut.setStatus(nextInt());
		dlFileShortcut.setStatusByUserId(nextLong());
		dlFileShortcut.setStatusByUserName(randomString());
		dlFileShortcut.setStatusDate(nextDate());

		_persistence.update(dlFileShortcut, false);

		return dlFileShortcut;
	}

	private DLFileShortcutPersistence _persistence;
}