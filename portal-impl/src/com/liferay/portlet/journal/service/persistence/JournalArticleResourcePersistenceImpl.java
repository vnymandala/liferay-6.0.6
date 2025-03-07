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

package com.liferay.portlet.journal.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.journal.NoSuchArticleResourceException;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.model.impl.JournalArticleResourceImpl;
import com.liferay.portlet.journal.model.impl.JournalArticleResourceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the journal article resource service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link JournalArticleResourceUtil} to access the journal article resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleResourcePersistence
 * @see JournalArticleResourceUtil
 * @generated
 */
public class JournalArticleResourcePersistenceImpl extends BasePersistenceImpl<JournalArticleResource>
	implements JournalArticleResourcePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = JournalArticleResourceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_G_A = new FinderPath(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_A",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_G_A = new FinderPath(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_A",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the journal article resource in the entity cache if it is enabled.
	 *
	 * @param journalArticleResource the journal article resource to cache
	 */
	public void cacheResult(JournalArticleResource journalArticleResource) {
		EntityCacheUtil.putResult(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceImpl.class,
			journalArticleResource.getPrimaryKey(), journalArticleResource);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				journalArticleResource.getUuid(),
				new Long(journalArticleResource.getGroupId())
			}, journalArticleResource);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_A,
			new Object[] {
				new Long(journalArticleResource.getGroupId()),
				
			journalArticleResource.getArticleId()
			}, journalArticleResource);
	}

	/**
	 * Caches the journal article resources in the entity cache if it is enabled.
	 *
	 * @param journalArticleResources the journal article resources to cache
	 */
	public void cacheResult(
		List<JournalArticleResource> journalArticleResources) {
		for (JournalArticleResource journalArticleResource : journalArticleResources) {
			if (EntityCacheUtil.getResult(
						JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
						JournalArticleResourceImpl.class,
						journalArticleResource.getPrimaryKey(), this) == null) {
				cacheResult(journalArticleResource);
			}
		}
	}

	/**
	 * Clears the cache for all journal article resources.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(JournalArticleResourceImpl.class.getName());
		EntityCacheUtil.clearCache(JournalArticleResourceImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the journal article resource.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(JournalArticleResource journalArticleResource) {
		EntityCacheUtil.removeResult(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceImpl.class,
			journalArticleResource.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				journalArticleResource.getUuid(),
				new Long(journalArticleResource.getGroupId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_A,
			new Object[] {
				new Long(journalArticleResource.getGroupId()),
				
			journalArticleResource.getArticleId()
			});
	}

	/**
	 * Creates a new journal article resource with the primary key. Does not add the journal article resource to the database.
	 *
	 * @param resourcePrimKey the primary key for the new journal article resource
	 * @return the new journal article resource
	 */
	public JournalArticleResource create(long resourcePrimKey) {
		JournalArticleResource journalArticleResource = new JournalArticleResourceImpl();

		journalArticleResource.setNew(true);
		journalArticleResource.setPrimaryKey(resourcePrimKey);

		String uuid = PortalUUIDUtil.generate();

		journalArticleResource.setUuid(uuid);

		return journalArticleResource;
	}

	/**
	 * Removes the journal article resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the journal article resource to remove
	 * @return the journal article resource that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a journal article resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the journal article resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourcePrimKey the primary key of the journal article resource to remove
	 * @return the journal article resource that was removed
	 * @throws com.liferay.portlet.journal.NoSuchArticleResourceException if a journal article resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource remove(long resourcePrimKey)
		throws NoSuchArticleResourceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JournalArticleResource journalArticleResource = (JournalArticleResource)session.get(JournalArticleResourceImpl.class,
					new Long(resourcePrimKey));

			if (journalArticleResource == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						resourcePrimKey);
				}

				throw new NoSuchArticleResourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					resourcePrimKey);
			}

			return remove(journalArticleResource);
		}
		catch (NoSuchArticleResourceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JournalArticleResource removeImpl(
		JournalArticleResource journalArticleResource)
		throws SystemException {
		journalArticleResource = toUnwrappedModel(journalArticleResource);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, journalArticleResource);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		JournalArticleResourceModelImpl journalArticleResourceModelImpl = (JournalArticleResourceModelImpl)journalArticleResource;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				journalArticleResourceModelImpl.getUuid(),
				new Long(journalArticleResourceModelImpl.getGroupId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_A,
			new Object[] {
				new Long(journalArticleResourceModelImpl.getGroupId()),
				
			journalArticleResourceModelImpl.getArticleId()
			});

		EntityCacheUtil.removeResult(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceImpl.class,
			journalArticleResource.getPrimaryKey());

		return journalArticleResource;
	}

	public JournalArticleResource updateImpl(
		com.liferay.portlet.journal.model.JournalArticleResource journalArticleResource,
		boolean merge) throws SystemException {
		journalArticleResource = toUnwrappedModel(journalArticleResource);

		boolean isNew = journalArticleResource.isNew();

		JournalArticleResourceModelImpl journalArticleResourceModelImpl = (JournalArticleResourceModelImpl)journalArticleResource;

		if (Validator.isNull(journalArticleResource.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			journalArticleResource.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, journalArticleResource, merge);

			journalArticleResource.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
			JournalArticleResourceImpl.class,
			journalArticleResource.getPrimaryKey(), journalArticleResource);

		if (!isNew &&
				(!Validator.equals(journalArticleResource.getUuid(),
					journalArticleResourceModelImpl.getOriginalUuid()) ||
				(journalArticleResource.getGroupId() != journalArticleResourceModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					journalArticleResourceModelImpl.getOriginalUuid(),
					new Long(journalArticleResourceModelImpl.getOriginalGroupId())
				});
		}

		if (isNew ||
				(!Validator.equals(journalArticleResource.getUuid(),
					journalArticleResourceModelImpl.getOriginalUuid()) ||
				(journalArticleResource.getGroupId() != journalArticleResourceModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					journalArticleResource.getUuid(),
					new Long(journalArticleResource.getGroupId())
				}, journalArticleResource);
		}

		if (!isNew &&
				((journalArticleResource.getGroupId() != journalArticleResourceModelImpl.getOriginalGroupId()) ||
				!Validator.equals(journalArticleResource.getArticleId(),
					journalArticleResourceModelImpl.getOriginalArticleId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_A,
				new Object[] {
					new Long(journalArticleResourceModelImpl.getOriginalGroupId()),
					
				journalArticleResourceModelImpl.getOriginalArticleId()
				});
		}

		if (isNew ||
				((journalArticleResource.getGroupId() != journalArticleResourceModelImpl.getOriginalGroupId()) ||
				!Validator.equals(journalArticleResource.getArticleId(),
					journalArticleResourceModelImpl.getOriginalArticleId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_A,
				new Object[] {
					new Long(journalArticleResource.getGroupId()),
					
				journalArticleResource.getArticleId()
				}, journalArticleResource);
		}

		return journalArticleResource;
	}

	protected JournalArticleResource toUnwrappedModel(
		JournalArticleResource journalArticleResource) {
		if (journalArticleResource instanceof JournalArticleResourceImpl) {
			return journalArticleResource;
		}

		JournalArticleResourceImpl journalArticleResourceImpl = new JournalArticleResourceImpl();

		journalArticleResourceImpl.setNew(journalArticleResource.isNew());
		journalArticleResourceImpl.setPrimaryKey(journalArticleResource.getPrimaryKey());

		journalArticleResourceImpl.setUuid(journalArticleResource.getUuid());
		journalArticleResourceImpl.setResourcePrimKey(journalArticleResource.getResourcePrimKey());
		journalArticleResourceImpl.setGroupId(journalArticleResource.getGroupId());
		journalArticleResourceImpl.setArticleId(journalArticleResource.getArticleId());

		return journalArticleResourceImpl;
	}

	/**
	 * Finds the journal article resource with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the journal article resource to find
	 * @return the journal article resource
	 * @throws com.liferay.portal.NoSuchModelException if a journal article resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the journal article resource with the primary key or throws a {@link com.liferay.portlet.journal.NoSuchArticleResourceException} if it could not be found.
	 *
	 * @param resourcePrimKey the primary key of the journal article resource to find
	 * @return the journal article resource
	 * @throws com.liferay.portlet.journal.NoSuchArticleResourceException if a journal article resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource findByPrimaryKey(long resourcePrimKey)
		throws NoSuchArticleResourceException, SystemException {
		JournalArticleResource journalArticleResource = fetchByPrimaryKey(resourcePrimKey);

		if (journalArticleResource == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + resourcePrimKey);
			}

			throw new NoSuchArticleResourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				resourcePrimKey);
		}

		return journalArticleResource;
	}

	/**
	 * Finds the journal article resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the journal article resource to find
	 * @return the journal article resource, or <code>null</code> if a journal article resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the journal article resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourcePrimKey the primary key of the journal article resource to find
	 * @return the journal article resource, or <code>null</code> if a journal article resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource fetchByPrimaryKey(long resourcePrimKey)
		throws SystemException {
		JournalArticleResource journalArticleResource = (JournalArticleResource)EntityCacheUtil.getResult(JournalArticleResourceModelImpl.ENTITY_CACHE_ENABLED,
				JournalArticleResourceImpl.class, resourcePrimKey, this);

		if (journalArticleResource == null) {
			Session session = null;

			try {
				session = openSession();

				journalArticleResource = (JournalArticleResource)session.get(JournalArticleResourceImpl.class,
						new Long(resourcePrimKey));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (journalArticleResource != null) {
					cacheResult(journalArticleResource);
				}

				closeSession(session);
			}
		}

		return journalArticleResource;
	}

	/**
	 * Finds all the journal article resources where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public List<JournalArticleResource> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the journal article resources where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of journal article resources to return
	 * @param end the upper bound of the range of journal article resources to return (not inclusive)
	 * @return the range of matching journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public List<JournalArticleResource> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Finds an ordered range of all the journal article resources where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of journal article resources to return
	 * @param end the upper bound of the range of journal article resources to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public List<JournalArticleResource> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<JournalArticleResource> list = (List<JournalArticleResource>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_JOURNALARTICLERESOURCE_WHERE);

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

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<JournalArticleResource>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Finds the first journal article resource in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching journal article resource
	 * @throws com.liferay.portlet.journal.NoSuchArticleResourceException if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchArticleResourceException, SystemException {
		List<JournalArticleResource> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchArticleResourceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last journal article resource in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching journal article resource
	 * @throws com.liferay.portlet.journal.NoSuchArticleResourceException if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchArticleResourceException, SystemException {
		int count = countByUuid(uuid);

		List<JournalArticleResource> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchArticleResourceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the journal article resources before and after the current journal article resource in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param resourcePrimKey the primary key of the current journal article resource
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next journal article resource
	 * @throws com.liferay.portlet.journal.NoSuchArticleResourceException if a journal article resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource[] findByUuid_PrevAndNext(
		long resourcePrimKey, String uuid, OrderByComparator orderByComparator)
		throws NoSuchArticleResourceException, SystemException {
		JournalArticleResource journalArticleResource = findByPrimaryKey(resourcePrimKey);

		Session session = null;

		try {
			session = openSession();

			JournalArticleResource[] array = new JournalArticleResourceImpl[3];

			array[0] = getByUuid_PrevAndNext(session, journalArticleResource,
					uuid, orderByComparator, true);

			array[1] = journalArticleResource;

			array[2] = getByUuid_PrevAndNext(session, journalArticleResource,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JournalArticleResource getByUuid_PrevAndNext(Session session,
		JournalArticleResource journalArticleResource, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOURNALARTICLERESOURCE_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(journalArticleResource);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JournalArticleResource> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the journal article resource where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portlet.journal.NoSuchArticleResourceException} if it could not be found.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching journal article resource
	 * @throws com.liferay.portlet.journal.NoSuchArticleResourceException if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource findByUUID_G(String uuid, long groupId)
		throws NoSuchArticleResourceException, SystemException {
		JournalArticleResource journalArticleResource = fetchByUUID_G(uuid,
				groupId);

		if (journalArticleResource == null) {
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

			throw new NoSuchArticleResourceException(msg.toString());
		}

		return journalArticleResource;
	}

	/**
	 * Finds the journal article resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching journal article resource, or <code>null</code> if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Finds the journal article resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching journal article resource, or <code>null</code> if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JOURNALARTICLERESOURCE_WHERE);

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

				List<JournalArticleResource> list = q.list();

				result = list;

				JournalArticleResource journalArticleResource = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					journalArticleResource = list.get(0);

					cacheResult(journalArticleResource);

					if ((journalArticleResource.getUuid() == null) ||
							!journalArticleResource.getUuid().equals(uuid) ||
							(journalArticleResource.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, journalArticleResource);
					}
				}

				return journalArticleResource;
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
				return (JournalArticleResource)result;
			}
		}
	}

	/**
	 * Finds all the journal article resources where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public List<JournalArticleResource> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the journal article resources where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of journal article resources to return
	 * @param end the upper bound of the range of journal article resources to return (not inclusive)
	 * @return the range of matching journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public List<JournalArticleResource> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the journal article resources where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of journal article resources to return
	 * @param end the upper bound of the range of journal article resources to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public List<JournalArticleResource> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<JournalArticleResource> list = (List<JournalArticleResource>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_JOURNALARTICLERESOURCE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<JournalArticleResource>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Finds the first journal article resource in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching journal article resource
	 * @throws com.liferay.portlet.journal.NoSuchArticleResourceException if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleResourceException, SystemException {
		List<JournalArticleResource> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchArticleResourceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last journal article resource in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching journal article resource
	 * @throws com.liferay.portlet.journal.NoSuchArticleResourceException if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleResourceException, SystemException {
		int count = countByGroupId(groupId);

		List<JournalArticleResource> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchArticleResourceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the journal article resources before and after the current journal article resource in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param resourcePrimKey the primary key of the current journal article resource
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next journal article resource
	 * @throws com.liferay.portlet.journal.NoSuchArticleResourceException if a journal article resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource[] findByGroupId_PrevAndNext(
		long resourcePrimKey, long groupId, OrderByComparator orderByComparator)
		throws NoSuchArticleResourceException, SystemException {
		JournalArticleResource journalArticleResource = findByPrimaryKey(resourcePrimKey);

		Session session = null;

		try {
			session = openSession();

			JournalArticleResource[] array = new JournalArticleResourceImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					journalArticleResource, groupId, orderByComparator, true);

			array[1] = journalArticleResource;

			array[2] = getByGroupId_PrevAndNext(session,
					journalArticleResource, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JournalArticleResource getByGroupId_PrevAndNext(Session session,
		JournalArticleResource journalArticleResource, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOURNALARTICLERESOURCE_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(journalArticleResource);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JournalArticleResource> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the journal article resource where groupId = &#63; and articleId = &#63; or throws a {@link com.liferay.portlet.journal.NoSuchArticleResourceException} if it could not be found.
	 *
	 * @param groupId the group id to search with
	 * @param articleId the article id to search with
	 * @return the matching journal article resource
	 * @throws com.liferay.portlet.journal.NoSuchArticleResourceException if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource findByG_A(long groupId, String articleId)
		throws NoSuchArticleResourceException, SystemException {
		JournalArticleResource journalArticleResource = fetchByG_A(groupId,
				articleId);

		if (journalArticleResource == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchArticleResourceException(msg.toString());
		}

		return journalArticleResource;
	}

	/**
	 * Finds the journal article resource where groupId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group id to search with
	 * @param articleId the article id to search with
	 * @return the matching journal article resource, or <code>null</code> if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource fetchByG_A(long groupId, String articleId)
		throws SystemException {
		return fetchByG_A(groupId, articleId, true);
	}

	/**
	 * Finds the journal article resource where groupId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group id to search with
	 * @param articleId the article id to search with
	 * @return the matching journal article resource, or <code>null</code> if a matching journal article resource could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JournalArticleResource fetchByG_A(long groupId, String articleId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, articleId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_A,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JOURNALARTICLERESOURCE_WHERE);

			query.append(_FINDER_COLUMN_G_A_GROUPID_2);

			if (articleId == null) {
				query.append(_FINDER_COLUMN_G_A_ARTICLEID_1);
			}
			else {
				if (articleId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_A_ARTICLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_A_ARTICLEID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (articleId != null) {
					qPos.add(articleId);
				}

				List<JournalArticleResource> list = q.list();

				result = list;

				JournalArticleResource journalArticleResource = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_A,
						finderArgs, list);
				}
				else {
					journalArticleResource = list.get(0);

					cacheResult(journalArticleResource);

					if ((journalArticleResource.getGroupId() != groupId) ||
							(journalArticleResource.getArticleId() == null) ||
							!journalArticleResource.getArticleId()
													   .equals(articleId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_A,
							finderArgs, journalArticleResource);
					}
				}

				return journalArticleResource;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_A,
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
				return (JournalArticleResource)result;
			}
		}
	}

	/**
	 * Finds all the journal article resources.
	 *
	 * @return the journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public List<JournalArticleResource> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the journal article resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of journal article resources to return
	 * @param end the upper bound of the range of journal article resources to return (not inclusive)
	 * @return the range of journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public List<JournalArticleResource> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the journal article resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of journal article resources to return
	 * @param end the upper bound of the range of journal article resources to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public List<JournalArticleResource> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<JournalArticleResource> list = (List<JournalArticleResource>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JOURNALARTICLERESOURCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOURNALARTICLERESOURCE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<JournalArticleResource>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<JournalArticleResource>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the journal article resources where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (JournalArticleResource journalArticleResource : findByUuid(uuid)) {
			remove(journalArticleResource);
		}
	}

	/**
	 * Removes the journal article resource where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchArticleResourceException, SystemException {
		JournalArticleResource journalArticleResource = findByUUID_G(uuid,
				groupId);

		remove(journalArticleResource);
	}

	/**
	 * Removes all the journal article resources where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (JournalArticleResource journalArticleResource : findByGroupId(
				groupId)) {
			remove(journalArticleResource);
		}
	}

	/**
	 * Removes the journal article resource where groupId = &#63; and articleId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param articleId the article id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_A(long groupId, String articleId)
		throws NoSuchArticleResourceException, SystemException {
		JournalArticleResource journalArticleResource = findByG_A(groupId,
				articleId);

		remove(journalArticleResource);
	}

	/**
	 * Removes all the journal article resources from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (JournalArticleResource journalArticleResource : findAll()) {
			remove(journalArticleResource);
		}
	}

	/**
	 * Counts all the journal article resources where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOURNALARTICLERESOURCE_WHERE);

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
	 * Counts all the journal article resources where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the number of matching journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOURNALARTICLERESOURCE_WHERE);

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
	 * Counts all the journal article resources where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOURNALARTICLERESOURCE_WHERE);

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
	 * Counts all the journal article resources where groupId = &#63; and articleId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param articleId the article id to search with
	 * @return the number of matching journal article resources
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_A(long groupId, String articleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, articleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOURNALARTICLERESOURCE_WHERE);

			query.append(_FINDER_COLUMN_G_A_GROUPID_2);

			if (articleId == null) {
				query.append(_FINDER_COLUMN_G_A_ARTICLEID_1);
			}
			else {
				if (articleId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_A_ARTICLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_A_ARTICLEID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (articleId != null) {
					qPos.add(articleId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_A, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the journal article resources.
	 *
	 * @return the number of journal article resources
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

				Query q = session.createQuery(_SQL_COUNT_JOURNALARTICLERESOURCE);

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
	 * Initializes the journal article resource persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portlet.journal.model.JournalArticleResource")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JournalArticleResource>> listenersList = new ArrayList<ModelListener<JournalArticleResource>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JournalArticleResource>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JournalArticleResourceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = JournalArticlePersistence.class)
	protected JournalArticlePersistence journalArticlePersistence;
	@BeanReference(type = JournalArticleImagePersistence.class)
	protected JournalArticleImagePersistence journalArticleImagePersistence;
	@BeanReference(type = JournalArticleResourcePersistence.class)
	protected JournalArticleResourcePersistence journalArticleResourcePersistence;
	@BeanReference(type = JournalContentSearchPersistence.class)
	protected JournalContentSearchPersistence journalContentSearchPersistence;
	@BeanReference(type = JournalFeedPersistence.class)
	protected JournalFeedPersistence journalFeedPersistence;
	@BeanReference(type = JournalStructurePersistence.class)
	protected JournalStructurePersistence journalStructurePersistence;
	@BeanReference(type = JournalTemplatePersistence.class)
	protected JournalTemplatePersistence journalTemplatePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_JOURNALARTICLERESOURCE = "SELECT journalArticleResource FROM JournalArticleResource journalArticleResource";
	private static final String _SQL_SELECT_JOURNALARTICLERESOURCE_WHERE = "SELECT journalArticleResource FROM JournalArticleResource journalArticleResource WHERE ";
	private static final String _SQL_COUNT_JOURNALARTICLERESOURCE = "SELECT COUNT(journalArticleResource) FROM JournalArticleResource journalArticleResource";
	private static final String _SQL_COUNT_JOURNALARTICLERESOURCE_WHERE = "SELECT COUNT(journalArticleResource) FROM JournalArticleResource journalArticleResource WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "journalArticleResource.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "journalArticleResource.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(journalArticleResource.uuid IS NULL OR journalArticleResource.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "journalArticleResource.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "journalArticleResource.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(journalArticleResource.uuid IS NULL OR journalArticleResource.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "journalArticleResource.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "journalArticleResource.groupId = ?";
	private static final String _FINDER_COLUMN_G_A_GROUPID_2 = "journalArticleResource.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_A_ARTICLEID_1 = "journalArticleResource.articleId IS NULL";
	private static final String _FINDER_COLUMN_G_A_ARTICLEID_2 = "journalArticleResource.articleId = ?";
	private static final String _FINDER_COLUMN_G_A_ARTICLEID_3 = "(journalArticleResource.articleId IS NULL OR journalArticleResource.articleId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "journalArticleResource.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JournalArticleResource exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JournalArticleResource exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(JournalArticleResourcePersistenceImpl.class);
}