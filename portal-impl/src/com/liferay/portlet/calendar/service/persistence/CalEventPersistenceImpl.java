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

package com.liferay.portlet.calendar.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.PortletPreferencesPersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetTagPersistence;
import com.liferay.portlet.calendar.NoSuchEventException;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.model.impl.CalEventImpl;
import com.liferay.portlet.calendar.model.impl.CalEventModelImpl;
import com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cal event service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link CalEventUtil} to access the cal event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CalEventPersistence
 * @see CalEventUtil
 * @generated
 */
public class CalEventPersistenceImpl extends BasePersistenceImpl<CalEvent>
	implements CalEventPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CalEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUuid", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByCompanyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NOTREMINDBY = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByNotRemindBy",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NOTREMINDBY = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByNotRemindBy", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_T = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_T = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_T",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_R = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_R",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_R = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_R",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the cal event in the entity cache if it is enabled.
	 *
	 * @param calEvent the cal event to cache
	 */
	public void cacheResult(CalEvent calEvent) {
		EntityCacheUtil.putResult(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventImpl.class, calEvent.getPrimaryKey(), calEvent);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { calEvent.getUuid(), new Long(calEvent.getGroupId()) },
			calEvent);
	}

	/**
	 * Caches the cal events in the entity cache if it is enabled.
	 *
	 * @param calEvents the cal events to cache
	 */
	public void cacheResult(List<CalEvent> calEvents) {
		for (CalEvent calEvent : calEvents) {
			if (EntityCacheUtil.getResult(
						CalEventModelImpl.ENTITY_CACHE_ENABLED,
						CalEventImpl.class, calEvent.getPrimaryKey(), this) == null) {
				cacheResult(calEvent);
			}
		}
	}

	/**
	 * Clears the cache for all cal events.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(CalEventImpl.class.getName());
		EntityCacheUtil.clearCache(CalEventImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the cal event.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(CalEvent calEvent) {
		EntityCacheUtil.removeResult(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventImpl.class, calEvent.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { calEvent.getUuid(), new Long(calEvent.getGroupId()) });
	}

	/**
	 * Creates a new cal event with the primary key. Does not add the cal event to the database.
	 *
	 * @param eventId the primary key for the new cal event
	 * @return the new cal event
	 */
	public CalEvent create(long eventId) {
		CalEvent calEvent = new CalEventImpl();

		calEvent.setNew(true);
		calEvent.setPrimaryKey(eventId);

		String uuid = PortalUUIDUtil.generate();

		calEvent.setUuid(uuid);

		return calEvent;
	}

	/**
	 * Removes the cal event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cal event to remove
	 * @return the cal event that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the cal event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the cal event to remove
	 * @return the cal event that was removed
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent remove(long eventId)
		throws NoSuchEventException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CalEvent calEvent = (CalEvent)session.get(CalEventImpl.class,
					new Long(eventId));

			if (calEvent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + eventId);
				}

				throw new NoSuchEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					eventId);
			}

			return remove(calEvent);
		}
		catch (NoSuchEventException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalEvent removeImpl(CalEvent calEvent) throws SystemException {
		calEvent = toUnwrappedModel(calEvent);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, calEvent);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		CalEventModelImpl calEventModelImpl = (CalEventModelImpl)calEvent;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				calEventModelImpl.getUuid(),
				new Long(calEventModelImpl.getGroupId())
			});

		EntityCacheUtil.removeResult(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventImpl.class, calEvent.getPrimaryKey());

		return calEvent;
	}

	public CalEvent updateImpl(
		com.liferay.portlet.calendar.model.CalEvent calEvent, boolean merge)
		throws SystemException {
		calEvent = toUnwrappedModel(calEvent);

		boolean isNew = calEvent.isNew();

		CalEventModelImpl calEventModelImpl = (CalEventModelImpl)calEvent;

		if (Validator.isNull(calEvent.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			calEvent.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, calEvent, merge);

			calEvent.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CalEventModelImpl.ENTITY_CACHE_ENABLED,
			CalEventImpl.class, calEvent.getPrimaryKey(), calEvent);

		if (!isNew &&
				(!Validator.equals(calEvent.getUuid(),
					calEventModelImpl.getOriginalUuid()) ||
				(calEvent.getGroupId() != calEventModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					calEventModelImpl.getOriginalUuid(),
					new Long(calEventModelImpl.getOriginalGroupId())
				});
		}

		if (isNew ||
				(!Validator.equals(calEvent.getUuid(),
					calEventModelImpl.getOriginalUuid()) ||
				(calEvent.getGroupId() != calEventModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] { calEvent.getUuid(), new Long(
						calEvent.getGroupId()) }, calEvent);
		}

		return calEvent;
	}

	protected CalEvent toUnwrappedModel(CalEvent calEvent) {
		if (calEvent instanceof CalEventImpl) {
			return calEvent;
		}

		CalEventImpl calEventImpl = new CalEventImpl();

		calEventImpl.setNew(calEvent.isNew());
		calEventImpl.setPrimaryKey(calEvent.getPrimaryKey());

		calEventImpl.setUuid(calEvent.getUuid());
		calEventImpl.setEventId(calEvent.getEventId());
		calEventImpl.setGroupId(calEvent.getGroupId());
		calEventImpl.setCompanyId(calEvent.getCompanyId());
		calEventImpl.setUserId(calEvent.getUserId());
		calEventImpl.setUserName(calEvent.getUserName());
		calEventImpl.setCreateDate(calEvent.getCreateDate());
		calEventImpl.setModifiedDate(calEvent.getModifiedDate());
		calEventImpl.setTitle(calEvent.getTitle());
		calEventImpl.setDescription(calEvent.getDescription());
		calEventImpl.setStartDate(calEvent.getStartDate());
		calEventImpl.setEndDate(calEvent.getEndDate());
		calEventImpl.setDurationHour(calEvent.getDurationHour());
		calEventImpl.setDurationMinute(calEvent.getDurationMinute());
		calEventImpl.setAllDay(calEvent.isAllDay());
		calEventImpl.setTimeZoneSensitive(calEvent.isTimeZoneSensitive());
		calEventImpl.setType(calEvent.getType());
		calEventImpl.setRepeating(calEvent.isRepeating());
		calEventImpl.setRecurrence(calEvent.getRecurrence());
		calEventImpl.setRemindBy(calEvent.getRemindBy());
		calEventImpl.setFirstReminder(calEvent.getFirstReminder());
		calEventImpl.setSecondReminder(calEvent.getSecondReminder());

		return calEventImpl;
	}

	/**
	 * Finds the cal event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cal event to find
	 * @return the cal event
	 * @throws com.liferay.portal.NoSuchModelException if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the cal event with the primary key or throws a {@link com.liferay.portlet.calendar.NoSuchEventException} if it could not be found.
	 *
	 * @param eventId the primary key of the cal event to find
	 * @return the cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByPrimaryKey(long eventId)
		throws NoSuchEventException, SystemException {
		CalEvent calEvent = fetchByPrimaryKey(eventId);

		if (calEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + eventId);
			}

			throw new NoSuchEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				eventId);
		}

		return calEvent;
	}

	/**
	 * Finds the cal event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cal event to find
	 * @return the cal event, or <code>null</code> if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the cal event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cal event to find
	 * @return the cal event, or <code>null</code> if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent fetchByPrimaryKey(long eventId) throws SystemException {
		CalEvent calEvent = (CalEvent)EntityCacheUtil.getResult(CalEventModelImpl.ENTITY_CACHE_ENABLED,
				CalEventImpl.class, eventId, this);

		if (calEvent == null) {
			Session session = null;

			try {
				session = openSession();

				calEvent = (CalEvent)session.get(CalEventImpl.class,
						new Long(eventId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (calEvent != null) {
					cacheResult(calEvent);
				}

				closeSession(session);
			}
		}

		return calEvent;
	}

	/**
	 * Finds all the cal events where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the cal events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @return the range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Finds an ordered range of all the cal events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CalEvent> list = (List<CalEvent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CALEVENT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CalEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<CalEvent>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first cal event in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		List<CalEvent> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last cal event in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		int count = countByUuid(uuid);

		List<CalEvent> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the cal events before and after the current cal event in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param eventId the primary key of the current cal event
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent[] findByUuid_PrevAndNext(long eventId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		CalEvent calEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CalEvent[] array = new CalEventImpl[3];

			array[0] = getByUuid_PrevAndNext(session, calEvent, uuid,
					orderByComparator, true);

			array[1] = calEvent;

			array[2] = getByUuid_PrevAndNext(session, calEvent, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalEvent getByUuid_PrevAndNext(Session session,
		CalEvent calEvent, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CALEVENT_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(CalEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(calEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CalEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the cal event where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portlet.calendar.NoSuchEventException} if it could not be found.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByUUID_G(String uuid, long groupId)
		throws NoSuchEventException, SystemException {
		CalEvent calEvent = fetchByUUID_G(uuid, groupId);

		if (calEvent == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEventException(msg.toString());
		}

		return calEvent;
	}

	/**
	 * Finds the cal event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching cal event, or <code>null</code> if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Finds the cal event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching cal event, or <code>null</code> if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CALEVENT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(CalEventModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<CalEvent> list = q.list();

				result = list;

				CalEvent calEvent = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					calEvent = list.get(0);

					cacheResult(calEvent);

					if ((calEvent.getUuid() == null) ||
							!calEvent.getUuid().equals(uuid) ||
							(calEvent.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, calEvent);
					}
				}

				return calEvent;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (CalEvent)result;
			}
		}
	}

	/**
	 * Finds all the cal events where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the cal events where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @return the range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the cal events where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CalEvent> list = (List<CalEvent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CALEVENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CalEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<CalEvent>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first cal event in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		List<CalEvent> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last cal event in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		int count = countByCompanyId(companyId);

		List<CalEvent> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the cal events before and after the current cal event in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param eventId the primary key of the current cal event
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent[] findByCompanyId_PrevAndNext(long eventId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		CalEvent calEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CalEvent[] array = new CalEventImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, calEvent, companyId,
					orderByComparator, true);

			array[1] = calEvent;

			array[2] = getByCompanyId_PrevAndNext(session, calEvent, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalEvent getByCompanyId_PrevAndNext(Session session,
		CalEvent calEvent, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CALEVENT_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(CalEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(calEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CalEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the cal events where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the cal events where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @return the range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the cal events where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CalEvent> list = (List<CalEvent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CALEVENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CalEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<CalEvent>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first cal event in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		List<CalEvent> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last cal event in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		int count = countByGroupId(groupId);

		List<CalEvent> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the cal events before and after the current cal event in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param eventId the primary key of the current cal event
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent[] findByGroupId_PrevAndNext(long eventId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		CalEvent calEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CalEvent[] array = new CalEventImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, calEvent, groupId,
					orderByComparator, true);

			array[1] = calEvent;

			array[2] = getByGroupId_PrevAndNext(session, calEvent, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalEvent getByGroupId_PrevAndNext(Session session,
		CalEvent calEvent, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CALEVENT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(CalEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(calEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CalEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the cal events where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the cal events where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @return the range of matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the cal events where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CALEVENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CALEVENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CALEVENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CalEventModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CalEventModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CalEvent.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CalEventImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CalEventImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<CalEvent>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the cal events where remindBy &ne; &#63;.
	 *
	 * @param remindBy the remind by to search with
	 * @return the matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByNotRemindBy(int remindBy)
		throws SystemException {
		return findByNotRemindBy(remindBy, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the cal events where remindBy &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param remindBy the remind by to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @return the range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByNotRemindBy(int remindBy, int start, int end)
		throws SystemException {
		return findByNotRemindBy(remindBy, start, end, null);
	}

	/**
	 * Finds an ordered range of all the cal events where remindBy &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param remindBy the remind by to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByNotRemindBy(int remindBy, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				remindBy,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CalEvent> list = (List<CalEvent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NOTREMINDBY,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CALEVENT_WHERE);

			query.append(_FINDER_COLUMN_NOTREMINDBY_REMINDBY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CalEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(remindBy);

				list = (List<CalEvent>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_NOTREMINDBY,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NOTREMINDBY,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first cal event in the ordered set where remindBy &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param remindBy the remind by to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByNotRemindBy_First(int remindBy,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		List<CalEvent> list = findByNotRemindBy(remindBy, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("remindBy=");
			msg.append(remindBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last cal event in the ordered set where remindBy &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param remindBy the remind by to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByNotRemindBy_Last(int remindBy,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		int count = countByNotRemindBy(remindBy);

		List<CalEvent> list = findByNotRemindBy(remindBy, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("remindBy=");
			msg.append(remindBy);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the cal events before and after the current cal event in the ordered set where remindBy &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param eventId the primary key of the current cal event
	 * @param remindBy the remind by to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent[] findByNotRemindBy_PrevAndNext(long eventId, int remindBy,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		CalEvent calEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CalEvent[] array = new CalEventImpl[3];

			array[0] = getByNotRemindBy_PrevAndNext(session, calEvent,
					remindBy, orderByComparator, true);

			array[1] = calEvent;

			array[2] = getByNotRemindBy_PrevAndNext(session, calEvent,
					remindBy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalEvent getByNotRemindBy_PrevAndNext(Session session,
		CalEvent calEvent, int remindBy, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CALEVENT_WHERE);

		query.append(_FINDER_COLUMN_NOTREMINDBY_REMINDBY_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(CalEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(remindBy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(calEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CalEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the cal events where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @return the matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByG_T(long groupId, String type)
		throws SystemException {
		return findByG_T(groupId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the cal events where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @return the range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByG_T(long groupId, String type, int start,
		int end) throws SystemException {
		return findByG_T(groupId, type, start, end, null);
	}

	/**
	 * Finds an ordered range of all the cal events where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByG_T(long groupId, String type, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, type,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CalEvent> list = (List<CalEvent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_T,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CALEVENT_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			if (type == null) {
				query.append(_FINDER_COLUMN_G_T_TYPE_1);
			}
			else {
				if (type.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_T_TYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_T_TYPE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CalEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (type != null) {
					qPos.add(type);
				}

				list = (List<CalEvent>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_T,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_T,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first cal event in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByG_T_First(long groupId, String type,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		List<CalEvent> list = findByG_T(groupId, type, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last cal event in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByG_T_Last(long groupId, String type,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		int count = countByG_T(groupId, type);

		List<CalEvent> list = findByG_T(groupId, type, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the cal events before and after the current cal event in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param eventId the primary key of the current cal event
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent[] findByG_T_PrevAndNext(long eventId, long groupId,
		String type, OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		CalEvent calEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CalEvent[] array = new CalEventImpl[3];

			array[0] = getByG_T_PrevAndNext(session, calEvent, groupId, type,
					orderByComparator, true);

			array[1] = calEvent;

			array[2] = getByG_T_PrevAndNext(session, calEvent, groupId, type,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalEvent getByG_T_PrevAndNext(Session session, CalEvent calEvent,
		long groupId, String type, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CALEVENT_WHERE);

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		if (type == null) {
			query.append(_FINDER_COLUMN_G_T_TYPE_1);
		}
		else {
			if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_T_TYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_T_TYPE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(CalEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (type != null) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(calEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CalEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the cal events where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @return the matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> filterFindByG_T(long groupId, String type)
		throws SystemException {
		return filterFindByG_T(groupId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the cal events where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @return the range of matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> filterFindByG_T(long groupId, String type, int start,
		int end) throws SystemException {
		return filterFindByG_T(groupId, type, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the cal events where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> filterFindByG_T(long groupId, String type, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_T(groupId, type, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CALEVENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CALEVENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		if (type == null) {
			query.append(_FINDER_COLUMN_G_T_TYPE_1);
		}
		else {
			if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_T_TYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_T_TYPE_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CALEVENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CalEventModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CalEventModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CalEvent.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CalEventImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CalEventImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (type != null) {
				qPos.add(type);
			}

			return (List<CalEvent>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the cal events where groupId = &#63; and repeating = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @return the matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByG_R(long groupId, boolean repeating)
		throws SystemException {
		return findByG_R(groupId, repeating, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the cal events where groupId = &#63; and repeating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @return the range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByG_R(long groupId, boolean repeating, int start,
		int end) throws SystemException {
		return findByG_R(groupId, repeating, start, end, null);
	}

	/**
	 * Finds an ordered range of all the cal events where groupId = &#63; and repeating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findByG_R(long groupId, boolean repeating, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, repeating,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CalEvent> list = (List<CalEvent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_R,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CALEVENT_WHERE);

			query.append(_FINDER_COLUMN_G_R_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_REPEATING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CalEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(repeating);

				list = (List<CalEvent>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_R,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_R,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first cal event in the ordered set where groupId = &#63; and repeating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByG_R_First(long groupId, boolean repeating,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		List<CalEvent> list = findByG_R(groupId, repeating, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", repeating=");
			msg.append(repeating);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last cal event in the ordered set where groupId = &#63; and repeating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a matching cal event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent findByG_R_Last(long groupId, boolean repeating,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		int count = countByG_R(groupId, repeating);

		List<CalEvent> list = findByG_R(groupId, repeating, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", repeating=");
			msg.append(repeating);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEventException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the cal events before and after the current cal event in the ordered set where groupId = &#63; and repeating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param eventId the primary key of the current cal event
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next cal event
	 * @throws com.liferay.portlet.calendar.NoSuchEventException if a cal event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalEvent[] findByG_R_PrevAndNext(long eventId, long groupId,
		boolean repeating, OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		CalEvent calEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CalEvent[] array = new CalEventImpl[3];

			array[0] = getByG_R_PrevAndNext(session, calEvent, groupId,
					repeating, orderByComparator, true);

			array[1] = calEvent;

			array[2] = getByG_R_PrevAndNext(session, calEvent, groupId,
					repeating, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalEvent getByG_R_PrevAndNext(Session session, CalEvent calEvent,
		long groupId, boolean repeating, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CALEVENT_WHERE);

		query.append(_FINDER_COLUMN_G_R_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_REPEATING_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(CalEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(repeating);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(calEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CalEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the cal events where groupId = &#63; and repeating = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @return the matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> filterFindByG_R(long groupId, boolean repeating)
		throws SystemException {
		return filterFindByG_R(groupId, repeating, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the cal events where groupId = &#63; and repeating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @return the range of matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> filterFindByG_R(long groupId, boolean repeating,
		int start, int end) throws SystemException {
		return filterFindByG_R(groupId, repeating, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the cal events where groupId = &#63; and repeating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> filterFindByG_R(long groupId, boolean repeating,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_R(groupId, repeating, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CALEVENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CALEVENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_R_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_REPEATING_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CALEVENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CalEventModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CalEventModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CalEvent.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CalEventImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CalEventImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(repeating);

			return (List<CalEvent>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the cal events.
	 *
	 * @return the cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the cal events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @return the range of cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the cal events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cal events to return
	 * @param end the upper bound of the range of cal events to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of cal events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalEvent> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CalEvent> list = (List<CalEvent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CALEVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CALEVENT.concat(CalEventModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CalEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CalEvent>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cal events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (CalEvent calEvent : findByUuid(uuid)) {
			remove(calEvent);
		}
	}

	/**
	 * Removes the cal event where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventException, SystemException {
		CalEvent calEvent = findByUUID_G(uuid, groupId);

		remove(calEvent);
	}

	/**
	 * Removes all the cal events where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (CalEvent calEvent : findByCompanyId(companyId)) {
			remove(calEvent);
		}
	}

	/**
	 * Removes all the cal events where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (CalEvent calEvent : findByGroupId(groupId)) {
			remove(calEvent);
		}
	}

	/**
	 * Removes all the cal events where remindBy &ne; &#63; from the database.
	 *
	 * @param remindBy the remind by to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNotRemindBy(int remindBy) throws SystemException {
		for (CalEvent calEvent : findByNotRemindBy(remindBy)) {
			remove(calEvent);
		}
	}

	/**
	 * Removes all the cal events where groupId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_T(long groupId, String type)
		throws SystemException {
		for (CalEvent calEvent : findByG_T(groupId, type)) {
			remove(calEvent);
		}
	}

	/**
	 * Removes all the cal events where groupId = &#63; and repeating = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_R(long groupId, boolean repeating)
		throws SystemException {
		for (CalEvent calEvent : findByG_R(groupId, repeating)) {
			remove(calEvent);
		}
	}

	/**
	 * Removes all the cal events from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CalEvent calEvent : findAll()) {
			remove(calEvent);
		}
	}

	/**
	 * Counts all the cal events where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CALEVENT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the cal events where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the number of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CALEVENT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the cal events where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CALEVENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the cal events where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CALEVENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the cal events where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CALEVENT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CalEvent.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the cal events where remindBy &ne; &#63;.
	 *
	 * @param remindBy the remind by to search with
	 * @return the number of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNotRemindBy(int remindBy) throws SystemException {
		Object[] finderArgs = new Object[] { remindBy };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NOTREMINDBY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CALEVENT_WHERE);

			query.append(_FINDER_COLUMN_NOTREMINDBY_REMINDBY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(remindBy);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOTREMINDBY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the cal events where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @return the number of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_T(long groupId, String type) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, type };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CALEVENT_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			if (type == null) {
				query.append(_FINDER_COLUMN_G_T_TYPE_1);
			}
			else {
				if (type.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_T_TYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_T_TYPE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (type != null) {
					qPos.add(type);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_T, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the cal events where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param type the type to search with
	 * @return the number of matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_T(long groupId, String type)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_T(groupId, type);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CALEVENT_WHERE);

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		if (type == null) {
			query.append(_FINDER_COLUMN_G_T_TYPE_1);
		}
		else {
			if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_T_TYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_T_TYPE_2);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CalEvent.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (type != null) {
				qPos.add(type);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the cal events where groupId = &#63; and repeating = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @return the number of matching cal events
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_R(long groupId, boolean repeating)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, repeating };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_R,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CALEVENT_WHERE);

			query.append(_FINDER_COLUMN_G_R_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_REPEATING_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(repeating);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_R, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the cal events where groupId = &#63; and repeating = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param repeating the repeating to search with
	 * @return the number of matching cal events that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_R(long groupId, boolean repeating)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_R(groupId, repeating);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CALEVENT_WHERE);

		query.append(_FINDER_COLUMN_G_R_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_REPEATING_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CalEvent.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(repeating);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the cal events.
	 *
	 * @return the number of cal events
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CALEVENT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the cal event persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portlet.calendar.model.CalEvent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CalEvent>> listenersList = new ArrayList<ModelListener<CalEvent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CalEvent>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CalEventImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = CalEventPersistence.class)
	protected CalEventPersistence calEventPersistence;
	@BeanReference(type = CompanyPersistence.class)
	protected CompanyPersistence companyPersistence;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = PortletPreferencesPersistence.class)
	protected PortletPreferencesPersistence portletPreferencesPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
	@BeanReference(type = ExpandoValuePersistence.class)
	protected ExpandoValuePersistence expandoValuePersistence;
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	private static final String _SQL_SELECT_CALEVENT = "SELECT calEvent FROM CalEvent calEvent";
	private static final String _SQL_SELECT_CALEVENT_WHERE = "SELECT calEvent FROM CalEvent calEvent WHERE ";
	private static final String _SQL_COUNT_CALEVENT = "SELECT COUNT(calEvent) FROM CalEvent calEvent";
	private static final String _SQL_COUNT_CALEVENT_WHERE = "SELECT COUNT(calEvent) FROM CalEvent calEvent WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "calEvent.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "calEvent.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(calEvent.uuid IS NULL OR calEvent.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "calEvent.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "calEvent.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(calEvent.uuid IS NULL OR calEvent.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "calEvent.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "calEvent.companyId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "calEvent.groupId = ?";
	private static final String _FINDER_COLUMN_NOTREMINDBY_REMINDBY_2 = "calEvent.remindBy != ?";
	private static final String _FINDER_COLUMN_G_T_GROUPID_2 = "calEvent.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_T_TYPE_1 = "calEvent.type IS NULL";
	private static final String _FINDER_COLUMN_G_T_TYPE_2 = "calEvent.type = ?";
	private static final String _FINDER_COLUMN_G_T_TYPE_3 = "(calEvent.type IS NULL OR calEvent.type = ?)";
	private static final String _FINDER_COLUMN_G_R_GROUPID_2 = "calEvent.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_R_REPEATING_2 = "calEvent.repeating = ?";
	private static final String _FILTER_SQL_SELECT_CALEVENT_WHERE = "SELECT DISTINCT {calEvent.*} FROM CalEvent calEvent WHERE ";
	private static final String _FILTER_SQL_SELECT_CALEVENT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CalEvent.*} FROM (SELECT DISTINCT calEvent.eventId FROM CalEvent calEvent WHERE ";
	private static final String _FILTER_SQL_SELECT_CALEVENT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CalEvent ON TEMP_TABLE.eventId = CalEvent.eventId";
	private static final String _FILTER_SQL_COUNT_CALEVENT_WHERE = "SELECT COUNT(DISTINCT calEvent.eventId) AS COUNT_VALUE FROM CalEvent calEvent WHERE ";
	private static final String _FILTER_COLUMN_PK = "calEvent.eventId";
	private static final String _FILTER_COLUMN_USERID = "calEvent.userId";
	private static final String _FILTER_ENTITY_ALIAS = "calEvent";
	private static final String _FILTER_ENTITY_TABLE = "CalEvent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "calEvent.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CalEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CalEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CalEvent exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(CalEventPersistenceImpl.class);
}