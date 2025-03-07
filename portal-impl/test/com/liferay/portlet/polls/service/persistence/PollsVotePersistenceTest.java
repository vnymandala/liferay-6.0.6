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

package com.liferay.portlet.polls.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.polls.NoSuchVoteException;
import com.liferay.portlet.polls.model.PollsVote;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class PollsVotePersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (PollsVotePersistence)PortalBeanLocatorUtil.locate(PollsVotePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		PollsVote pollsVote = _persistence.create(pk);

		assertNotNull(pollsVote);

		assertEquals(pollsVote.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		PollsVote newPollsVote = addPollsVote();

		_persistence.remove(newPollsVote);

		PollsVote existingPollsVote = _persistence.fetchByPrimaryKey(newPollsVote.getPrimaryKey());

		assertNull(existingPollsVote);
	}

	public void testUpdateNew() throws Exception {
		addPollsVote();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		PollsVote newPollsVote = _persistence.create(pk);

		newPollsVote.setUserId(nextLong());
		newPollsVote.setQuestionId(nextLong());
		newPollsVote.setChoiceId(nextLong());
		newPollsVote.setVoteDate(nextDate());

		_persistence.update(newPollsVote, false);

		PollsVote existingPollsVote = _persistence.findByPrimaryKey(newPollsVote.getPrimaryKey());

		assertEquals(existingPollsVote.getVoteId(), newPollsVote.getVoteId());
		assertEquals(existingPollsVote.getUserId(), newPollsVote.getUserId());
		assertEquals(existingPollsVote.getQuestionId(),
			newPollsVote.getQuestionId());
		assertEquals(existingPollsVote.getChoiceId(), newPollsVote.getChoiceId());
		assertEquals(Time.getShortTimestamp(existingPollsVote.getVoteDate()),
			Time.getShortTimestamp(newPollsVote.getVoteDate()));
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		PollsVote newPollsVote = addPollsVote();

		PollsVote existingPollsVote = _persistence.findByPrimaryKey(newPollsVote.getPrimaryKey());

		assertEquals(existingPollsVote, newPollsVote);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchVoteException");
		}
		catch (NoSuchVoteException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		PollsVote newPollsVote = addPollsVote();

		PollsVote existingPollsVote = _persistence.fetchByPrimaryKey(newPollsVote.getPrimaryKey());

		assertEquals(existingPollsVote, newPollsVote);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		PollsVote missingPollsVote = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingPollsVote);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		PollsVote newPollsVote = addPollsVote();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PollsVote.class,
				PollsVote.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("voteId",
				newPollsVote.getVoteId()));

		List<PollsVote> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		PollsVote existingPollsVote = result.get(0);

		assertEquals(existingPollsVote, newPollsVote);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PollsVote.class,
				PollsVote.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("voteId", nextLong()));

		List<PollsVote> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected PollsVote addPollsVote() throws Exception {
		long pk = nextLong();

		PollsVote pollsVote = _persistence.create(pk);

		pollsVote.setUserId(nextLong());
		pollsVote.setQuestionId(nextLong());
		pollsVote.setChoiceId(nextLong());
		pollsVote.setVoteDate(nextDate());

		_persistence.update(pollsVote, false);

		return pollsVote;
	}

	private PollsVotePersistence _persistence;
}