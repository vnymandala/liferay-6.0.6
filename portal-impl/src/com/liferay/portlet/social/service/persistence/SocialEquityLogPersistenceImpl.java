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

package com.liferay.portlet.social.service.persistence;

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
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.social.NoSuchEquityLogException;
import com.liferay.portlet.social.model.SocialEquityLog;
import com.liferay.portlet.social.model.impl.SocialEquityLogImpl;
import com.liferay.portlet.social.model.impl.SocialEquityLogModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the social equity log service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link SocialEquityLogUtil} to access the social equity log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialEquityLogPersistence
 * @see SocialEquityLogUtil
 * @generated
 */
public class SocialEquityLogPersistenceImpl extends BasePersistenceImpl<SocialEquityLog>
	implements SocialEquityLogPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = SocialEquityLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_AEI_T_A = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAEI_T_A",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_AEI_T_A = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAEI_T_A",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_U_AID_A_T = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByU_AID_A_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_U_AID_A_T = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByU_AID_A_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(), Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_AEI_AID_A_T = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAEI_AID_A_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_AEI_AID_A_T = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAEI_AID_A_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(), Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_U_AID_AD_A_T = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByU_AID_AD_A_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Boolean.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_U_AID_AD_A_T = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByU_AID_AD_A_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Boolean.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_AEI_AID_AD_A_T = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAEI_AID_AD_A_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Boolean.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_AEI_AID_AD_A_T = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAEI_AID_AD_A_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Boolean.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_U_AEI_AID_AD_A_T = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByU_AEI_AID_AD_A_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_U_AEI_AID_AD_A_T = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByU_AEI_AID_AD_A_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the social equity log in the entity cache if it is enabled.
	 *
	 * @param socialEquityLog the social equity log to cache
	 */
	public void cacheResult(SocialEquityLog socialEquityLog) {
		EntityCacheUtil.putResult(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogImpl.class, socialEquityLog.getPrimaryKey(),
			socialEquityLog);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_AEI_AID_AD_A_T,
			new Object[] {
				new Long(socialEquityLog.getUserId()),
				new Long(socialEquityLog.getAssetEntryId()),
				
			socialEquityLog.getActionId(),
				new Integer(socialEquityLog.getActionDate()),
				Boolean.valueOf(socialEquityLog.getActive()),
				new Integer(socialEquityLog.getType())
			}, socialEquityLog);
	}

	/**
	 * Caches the social equity logs in the entity cache if it is enabled.
	 *
	 * @param socialEquityLogs the social equity logs to cache
	 */
	public void cacheResult(List<SocialEquityLog> socialEquityLogs) {
		for (SocialEquityLog socialEquityLog : socialEquityLogs) {
			if (EntityCacheUtil.getResult(
						SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
						SocialEquityLogImpl.class,
						socialEquityLog.getPrimaryKey(), this) == null) {
				cacheResult(socialEquityLog);
			}
		}
	}

	/**
	 * Clears the cache for all social equity logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(SocialEquityLogImpl.class.getName());
		EntityCacheUtil.clearCache(SocialEquityLogImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the social equity log.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(SocialEquityLog socialEquityLog) {
		EntityCacheUtil.removeResult(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogImpl.class, socialEquityLog.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_AEI_AID_AD_A_T,
			new Object[] {
				new Long(socialEquityLog.getUserId()),
				new Long(socialEquityLog.getAssetEntryId()),
				
			socialEquityLog.getActionId(),
				new Integer(socialEquityLog.getActionDate()),
				Boolean.valueOf(socialEquityLog.getActive()),
				new Integer(socialEquityLog.getType())
			});
	}

	/**
	 * Creates a new social equity log with the primary key. Does not add the social equity log to the database.
	 *
	 * @param equityLogId the primary key for the new social equity log
	 * @return the new social equity log
	 */
	public SocialEquityLog create(long equityLogId) {
		SocialEquityLog socialEquityLog = new SocialEquityLogImpl();

		socialEquityLog.setNew(true);
		socialEquityLog.setPrimaryKey(equityLogId);

		return socialEquityLog;
	}

	/**
	 * Removes the social equity log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social equity log to remove
	 * @return the social equity log that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the social equity log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param equityLogId the primary key of the social equity log to remove
	 * @return the social equity log that was removed
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog remove(long equityLogId)
		throws NoSuchEquityLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SocialEquityLog socialEquityLog = (SocialEquityLog)session.get(SocialEquityLogImpl.class,
					new Long(equityLogId));

			if (socialEquityLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + equityLogId);
				}

				throw new NoSuchEquityLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					equityLogId);
			}

			return remove(socialEquityLog);
		}
		catch (NoSuchEquityLogException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialEquityLog removeImpl(SocialEquityLog socialEquityLog)
		throws SystemException {
		socialEquityLog = toUnwrappedModel(socialEquityLog);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, socialEquityLog);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		SocialEquityLogModelImpl socialEquityLogModelImpl = (SocialEquityLogModelImpl)socialEquityLog;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_AEI_AID_AD_A_T,
			new Object[] {
				new Long(socialEquityLogModelImpl.getUserId()),
				new Long(socialEquityLogModelImpl.getAssetEntryId()),
				
			socialEquityLogModelImpl.getActionId(),
				new Integer(socialEquityLogModelImpl.getActionDate()),
				Boolean.valueOf(socialEquityLogModelImpl.getActive()),
				new Integer(socialEquityLogModelImpl.getType())
			});

		EntityCacheUtil.removeResult(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogImpl.class, socialEquityLog.getPrimaryKey());

		return socialEquityLog;
	}

	public SocialEquityLog updateImpl(
		com.liferay.portlet.social.model.SocialEquityLog socialEquityLog,
		boolean merge) throws SystemException {
		socialEquityLog = toUnwrappedModel(socialEquityLog);

		boolean isNew = socialEquityLog.isNew();

		SocialEquityLogModelImpl socialEquityLogModelImpl = (SocialEquityLogModelImpl)socialEquityLog;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, socialEquityLog, merge);

			socialEquityLog.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
			SocialEquityLogImpl.class, socialEquityLog.getPrimaryKey(),
			socialEquityLog);

		if (!isNew &&
				((socialEquityLog.getUserId() != socialEquityLogModelImpl.getOriginalUserId()) ||
				(socialEquityLog.getAssetEntryId() != socialEquityLogModelImpl.getOriginalAssetEntryId()) ||
				!Validator.equals(socialEquityLog.getActionId(),
					socialEquityLogModelImpl.getOriginalActionId()) ||
				(socialEquityLog.getActionDate() != socialEquityLogModelImpl.getOriginalActionDate()) ||
				(socialEquityLog.getActive() != socialEquityLogModelImpl.getOriginalActive()) ||
				(socialEquityLog.getType() != socialEquityLogModelImpl.getOriginalType()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_AEI_AID_AD_A_T,
				new Object[] {
					new Long(socialEquityLogModelImpl.getOriginalUserId()),
					new Long(socialEquityLogModelImpl.getOriginalAssetEntryId()),
					
				socialEquityLogModelImpl.getOriginalActionId(),
					new Integer(socialEquityLogModelImpl.getOriginalActionDate()),
					Boolean.valueOf(
						socialEquityLogModelImpl.getOriginalActive()),
					new Integer(socialEquityLogModelImpl.getOriginalType())
				});
		}

		if (isNew ||
				((socialEquityLog.getUserId() != socialEquityLogModelImpl.getOriginalUserId()) ||
				(socialEquityLog.getAssetEntryId() != socialEquityLogModelImpl.getOriginalAssetEntryId()) ||
				!Validator.equals(socialEquityLog.getActionId(),
					socialEquityLogModelImpl.getOriginalActionId()) ||
				(socialEquityLog.getActionDate() != socialEquityLogModelImpl.getOriginalActionDate()) ||
				(socialEquityLog.getActive() != socialEquityLogModelImpl.getOriginalActive()) ||
				(socialEquityLog.getType() != socialEquityLogModelImpl.getOriginalType()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_AEI_AID_AD_A_T,
				new Object[] {
					new Long(socialEquityLog.getUserId()),
					new Long(socialEquityLog.getAssetEntryId()),
					
				socialEquityLog.getActionId(),
					new Integer(socialEquityLog.getActionDate()),
					Boolean.valueOf(socialEquityLog.getActive()),
					new Integer(socialEquityLog.getType())
				}, socialEquityLog);
		}

		return socialEquityLog;
	}

	protected SocialEquityLog toUnwrappedModel(SocialEquityLog socialEquityLog) {
		if (socialEquityLog instanceof SocialEquityLogImpl) {
			return socialEquityLog;
		}

		SocialEquityLogImpl socialEquityLogImpl = new SocialEquityLogImpl();

		socialEquityLogImpl.setNew(socialEquityLog.isNew());
		socialEquityLogImpl.setPrimaryKey(socialEquityLog.getPrimaryKey());

		socialEquityLogImpl.setEquityLogId(socialEquityLog.getEquityLogId());
		socialEquityLogImpl.setGroupId(socialEquityLog.getGroupId());
		socialEquityLogImpl.setCompanyId(socialEquityLog.getCompanyId());
		socialEquityLogImpl.setUserId(socialEquityLog.getUserId());
		socialEquityLogImpl.setAssetEntryId(socialEquityLog.getAssetEntryId());
		socialEquityLogImpl.setActionId(socialEquityLog.getActionId());
		socialEquityLogImpl.setActionDate(socialEquityLog.getActionDate());
		socialEquityLogImpl.setActive(socialEquityLog.isActive());
		socialEquityLogImpl.setExpiration(socialEquityLog.getExpiration());
		socialEquityLogImpl.setType(socialEquityLog.getType());
		socialEquityLogImpl.setValue(socialEquityLog.getValue());

		return socialEquityLogImpl;
	}

	/**
	 * Finds the social equity log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the social equity log to find
	 * @return the social equity log
	 * @throws com.liferay.portal.NoSuchModelException if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the social equity log with the primary key or throws a {@link com.liferay.portlet.social.NoSuchEquityLogException} if it could not be found.
	 *
	 * @param equityLogId the primary key of the social equity log to find
	 * @return the social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByPrimaryKey(long equityLogId)
		throws NoSuchEquityLogException, SystemException {
		SocialEquityLog socialEquityLog = fetchByPrimaryKey(equityLogId);

		if (socialEquityLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + equityLogId);
			}

			throw new NoSuchEquityLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				equityLogId);
		}

		return socialEquityLog;
	}

	/**
	 * Finds the social equity log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social equity log to find
	 * @return the social equity log, or <code>null</code> if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the social equity log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param equityLogId the primary key of the social equity log to find
	 * @return the social equity log, or <code>null</code> if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog fetchByPrimaryKey(long equityLogId)
		throws SystemException {
		SocialEquityLog socialEquityLog = (SocialEquityLog)EntityCacheUtil.getResult(SocialEquityLogModelImpl.ENTITY_CACHE_ENABLED,
				SocialEquityLogImpl.class, equityLogId, this);

		if (socialEquityLog == null) {
			Session session = null;

			try {
				session = openSession();

				socialEquityLog = (SocialEquityLog)session.get(SocialEquityLogImpl.class,
						new Long(equityLogId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (socialEquityLog != null) {
					cacheResult(socialEquityLog);
				}

				closeSession(session);
			}
		}

		return socialEquityLog;
	}

	/**
	 * Finds all the social equity logs where assetEntryId = &#63; and type = &#63; and active = &#63;.
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param type the type to search with
	 * @param active the active to search with
	 * @return the matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByAEI_T_A(long assetEntryId, int type,
		boolean active) throws SystemException {
		return findByAEI_T_A(assetEntryId, type, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the social equity logs where assetEntryId = &#63; and type = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param type the type to search with
	 * @param active the active to search with
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @return the range of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByAEI_T_A(long assetEntryId, int type,
		boolean active, int start, int end) throws SystemException {
		return findByAEI_T_A(assetEntryId, type, active, start, end, null);
	}

	/**
	 * Finds an ordered range of all the social equity logs where assetEntryId = &#63; and type = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param type the type to search with
	 * @param active the active to search with
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByAEI_T_A(long assetEntryId, int type,
		boolean active, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				assetEntryId, type, active,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SocialEquityLog> list = (List<SocialEquityLog>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_AEI_T_A,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_AEI_T_A_ASSETENTRYID_2);

			query.append(_FINDER_COLUMN_AEI_T_A_TYPE_2);

			query.append(_FINDER_COLUMN_AEI_T_A_ACTIVE_2);

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

				qPos.add(assetEntryId);

				qPos.add(type);

				qPos.add(active);

				list = (List<SocialEquityLog>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_AEI_T_A,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_AEI_T_A,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first social equity log in the ordered set where assetEntryId = &#63; and type = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param type the type to search with
	 * @param active the active to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByAEI_T_A_First(long assetEntryId, int type,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		List<SocialEquityLog> list = findByAEI_T_A(assetEntryId, type, active,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assetEntryId=");
			msg.append(assetEntryId);

			msg.append(", type=");
			msg.append(type);

			msg.append(", active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEquityLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last social equity log in the ordered set where assetEntryId = &#63; and type = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param type the type to search with
	 * @param active the active to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByAEI_T_A_Last(long assetEntryId, int type,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		int count = countByAEI_T_A(assetEntryId, type, active);

		List<SocialEquityLog> list = findByAEI_T_A(assetEntryId, type, active,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assetEntryId=");
			msg.append(assetEntryId);

			msg.append(", type=");
			msg.append(type);

			msg.append(", active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEquityLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the social equity logs before and after the current social equity log in the ordered set where assetEntryId = &#63; and type = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param equityLogId the primary key of the current social equity log
	 * @param assetEntryId the asset entry id to search with
	 * @param type the type to search with
	 * @param active the active to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog[] findByAEI_T_A_PrevAndNext(long equityLogId,
		long assetEntryId, int type, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		SocialEquityLog socialEquityLog = findByPrimaryKey(equityLogId);

		Session session = null;

		try {
			session = openSession();

			SocialEquityLog[] array = new SocialEquityLogImpl[3];

			array[0] = getByAEI_T_A_PrevAndNext(session, socialEquityLog,
					assetEntryId, type, active, orderByComparator, true);

			array[1] = socialEquityLog;

			array[2] = getByAEI_T_A_PrevAndNext(session, socialEquityLog,
					assetEntryId, type, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialEquityLog getByAEI_T_A_PrevAndNext(Session session,
		SocialEquityLog socialEquityLog, long assetEntryId, int type,
		boolean active, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

		query.append(_FINDER_COLUMN_AEI_T_A_ASSETENTRYID_2);

		query.append(_FINDER_COLUMN_AEI_T_A_TYPE_2);

		query.append(_FINDER_COLUMN_AEI_T_A_ACTIVE_2);

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

		qPos.add(assetEntryId);

		qPos.add(type);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(socialEquityLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialEquityLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the social equity logs where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByU_AID_A_T(long userId, String actionId,
		boolean active, int type) throws SystemException {
		return findByU_AID_A_T(userId, actionId, active, type,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the social equity logs where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @return the range of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByU_AID_A_T(long userId, String actionId,
		boolean active, int type, int start, int end) throws SystemException {
		return findByU_AID_A_T(userId, actionId, active, type, start, end, null);
	}

	/**
	 * Finds an ordered range of all the social equity logs where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByU_AID_A_T(long userId, String actionId,
		boolean active, int type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				userId, actionId, active, type,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SocialEquityLog> list = (List<SocialEquityLog>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_U_AID_A_T,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_U_AID_A_T_USERID_2);

			if (actionId == null) {
				query.append(_FINDER_COLUMN_U_AID_A_T_ACTIONID_1);
			}
			else {
				if (actionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_AID_A_T_ACTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_AID_A_T_ACTIONID_2);
				}
			}

			query.append(_FINDER_COLUMN_U_AID_A_T_ACTIVE_2);

			query.append(_FINDER_COLUMN_U_AID_A_T_TYPE_2);

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

				qPos.add(userId);

				if (actionId != null) {
					qPos.add(actionId);
				}

				qPos.add(active);

				qPos.add(type);

				list = (List<SocialEquityLog>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_U_AID_A_T,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_U_AID_A_T,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first social equity log in the ordered set where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByU_AID_A_T_First(long userId, String actionId,
		boolean active, int type, OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		List<SocialEquityLog> list = findByU_AID_A_T(userId, actionId, active,
				type, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", actionId=");
			msg.append(actionId);

			msg.append(", active=");
			msg.append(active);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEquityLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last social equity log in the ordered set where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByU_AID_A_T_Last(long userId, String actionId,
		boolean active, int type, OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		int count = countByU_AID_A_T(userId, actionId, active, type);

		List<SocialEquityLog> list = findByU_AID_A_T(userId, actionId, active,
				type, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", actionId=");
			msg.append(actionId);

			msg.append(", active=");
			msg.append(active);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEquityLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the social equity logs before and after the current social equity log in the ordered set where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param equityLogId the primary key of the current social equity log
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog[] findByU_AID_A_T_PrevAndNext(long equityLogId,
		long userId, String actionId, boolean active, int type,
		OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		SocialEquityLog socialEquityLog = findByPrimaryKey(equityLogId);

		Session session = null;

		try {
			session = openSession();

			SocialEquityLog[] array = new SocialEquityLogImpl[3];

			array[0] = getByU_AID_A_T_PrevAndNext(session, socialEquityLog,
					userId, actionId, active, type, orderByComparator, true);

			array[1] = socialEquityLog;

			array[2] = getByU_AID_A_T_PrevAndNext(session, socialEquityLog,
					userId, actionId, active, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialEquityLog getByU_AID_A_T_PrevAndNext(Session session,
		SocialEquityLog socialEquityLog, long userId, String actionId,
		boolean active, int type, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

		query.append(_FINDER_COLUMN_U_AID_A_T_USERID_2);

		if (actionId == null) {
			query.append(_FINDER_COLUMN_U_AID_A_T_ACTIONID_1);
		}
		else {
			if (actionId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_U_AID_A_T_ACTIONID_3);
			}
			else {
				query.append(_FINDER_COLUMN_U_AID_A_T_ACTIONID_2);
			}
		}

		query.append(_FINDER_COLUMN_U_AID_A_T_ACTIVE_2);

		query.append(_FINDER_COLUMN_U_AID_A_T_TYPE_2);

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

		qPos.add(userId);

		if (actionId != null) {
			qPos.add(actionId);
		}

		qPos.add(active);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(socialEquityLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialEquityLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the social equity logs where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByAEI_AID_A_T(long assetEntryId,
		String actionId, boolean active, int type) throws SystemException {
		return findByAEI_AID_A_T(assetEntryId, actionId, active, type,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the social equity logs where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @return the range of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByAEI_AID_A_T(long assetEntryId,
		String actionId, boolean active, int type, int start, int end)
		throws SystemException {
		return findByAEI_AID_A_T(assetEntryId, actionId, active, type, start,
			end, null);
	}

	/**
	 * Finds an ordered range of all the social equity logs where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByAEI_AID_A_T(long assetEntryId,
		String actionId, boolean active, int type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				assetEntryId, actionId, active, type,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SocialEquityLog> list = (List<SocialEquityLog>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_AEI_AID_A_T,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_AEI_AID_A_T_ASSETENTRYID_2);

			if (actionId == null) {
				query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIONID_1);
			}
			else {
				if (actionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIONID_2);
				}
			}

			query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIVE_2);

			query.append(_FINDER_COLUMN_AEI_AID_A_T_TYPE_2);

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

				qPos.add(assetEntryId);

				if (actionId != null) {
					qPos.add(actionId);
				}

				qPos.add(active);

				qPos.add(type);

				list = (List<SocialEquityLog>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_AEI_AID_A_T,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_AEI_AID_A_T,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByAEI_AID_A_T_First(long assetEntryId,
		String actionId, boolean active, int type,
		OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		List<SocialEquityLog> list = findByAEI_AID_A_T(assetEntryId, actionId,
				active, type, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assetEntryId=");
			msg.append(assetEntryId);

			msg.append(", actionId=");
			msg.append(actionId);

			msg.append(", active=");
			msg.append(active);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEquityLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByAEI_AID_A_T_Last(long assetEntryId,
		String actionId, boolean active, int type,
		OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		int count = countByAEI_AID_A_T(assetEntryId, actionId, active, type);

		List<SocialEquityLog> list = findByAEI_AID_A_T(assetEntryId, actionId,
				active, type, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assetEntryId=");
			msg.append(assetEntryId);

			msg.append(", actionId=");
			msg.append(actionId);

			msg.append(", active=");
			msg.append(active);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEquityLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the social equity logs before and after the current social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param equityLogId the primary key of the current social equity log
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog[] findByAEI_AID_A_T_PrevAndNext(long equityLogId,
		long assetEntryId, String actionId, boolean active, int type,
		OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		SocialEquityLog socialEquityLog = findByPrimaryKey(equityLogId);

		Session session = null;

		try {
			session = openSession();

			SocialEquityLog[] array = new SocialEquityLogImpl[3];

			array[0] = getByAEI_AID_A_T_PrevAndNext(session, socialEquityLog,
					assetEntryId, actionId, active, type, orderByComparator,
					true);

			array[1] = socialEquityLog;

			array[2] = getByAEI_AID_A_T_PrevAndNext(session, socialEquityLog,
					assetEntryId, actionId, active, type, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialEquityLog getByAEI_AID_A_T_PrevAndNext(Session session,
		SocialEquityLog socialEquityLog, long assetEntryId, String actionId,
		boolean active, int type, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

		query.append(_FINDER_COLUMN_AEI_AID_A_T_ASSETENTRYID_2);

		if (actionId == null) {
			query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIONID_1);
		}
		else {
			if (actionId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIONID_3);
			}
			else {
				query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIONID_2);
			}
		}

		query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIVE_2);

		query.append(_FINDER_COLUMN_AEI_AID_A_T_TYPE_2);

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

		qPos.add(assetEntryId);

		if (actionId != null) {
			qPos.add(actionId);
		}

		qPos.add(active);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(socialEquityLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialEquityLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the social equity logs where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByU_AID_AD_A_T(long userId,
		String actionId, int actionDate, boolean active, int type)
		throws SystemException {
		return findByU_AID_AD_A_T(userId, actionId, actionDate, active, type,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the social equity logs where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @return the range of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByU_AID_AD_A_T(long userId,
		String actionId, int actionDate, boolean active, int type, int start,
		int end) throws SystemException {
		return findByU_AID_AD_A_T(userId, actionId, actionDate, active, type,
			start, end, null);
	}

	/**
	 * Finds an ordered range of all the social equity logs where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByU_AID_AD_A_T(long userId,
		String actionId, int actionDate, boolean active, int type, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				userId, actionId, actionDate, active, type,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SocialEquityLog> list = (List<SocialEquityLog>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_U_AID_AD_A_T,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_U_AID_AD_A_T_USERID_2);

			if (actionId == null) {
				query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_1);
			}
			else {
				if (actionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_2);
				}
			}

			query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONDATE_2);

			query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIVE_2);

			query.append(_FINDER_COLUMN_U_AID_AD_A_T_TYPE_2);

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

				qPos.add(userId);

				if (actionId != null) {
					qPos.add(actionId);
				}

				qPos.add(actionDate);

				qPos.add(active);

				qPos.add(type);

				list = (List<SocialEquityLog>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_U_AID_AD_A_T,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_U_AID_AD_A_T,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first social equity log in the ordered set where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByU_AID_AD_A_T_First(long userId,
		String actionId, int actionDate, boolean active, int type,
		OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		List<SocialEquityLog> list = findByU_AID_AD_A_T(userId, actionId,
				actionDate, active, type, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", actionId=");
			msg.append(actionId);

			msg.append(", actionDate=");
			msg.append(actionDate);

			msg.append(", active=");
			msg.append(active);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEquityLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last social equity log in the ordered set where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByU_AID_AD_A_T_Last(long userId,
		String actionId, int actionDate, boolean active, int type,
		OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		int count = countByU_AID_AD_A_T(userId, actionId, actionDate, active,
				type);

		List<SocialEquityLog> list = findByU_AID_AD_A_T(userId, actionId,
				actionDate, active, type, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", actionId=");
			msg.append(actionId);

			msg.append(", actionDate=");
			msg.append(actionDate);

			msg.append(", active=");
			msg.append(active);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEquityLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the social equity logs before and after the current social equity log in the ordered set where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param equityLogId the primary key of the current social equity log
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog[] findByU_AID_AD_A_T_PrevAndNext(long equityLogId,
		long userId, String actionId, int actionDate, boolean active, int type,
		OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		SocialEquityLog socialEquityLog = findByPrimaryKey(equityLogId);

		Session session = null;

		try {
			session = openSession();

			SocialEquityLog[] array = new SocialEquityLogImpl[3];

			array[0] = getByU_AID_AD_A_T_PrevAndNext(session, socialEquityLog,
					userId, actionId, actionDate, active, type,
					orderByComparator, true);

			array[1] = socialEquityLog;

			array[2] = getByU_AID_AD_A_T_PrevAndNext(session, socialEquityLog,
					userId, actionId, actionDate, active, type,
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

	protected SocialEquityLog getByU_AID_AD_A_T_PrevAndNext(Session session,
		SocialEquityLog socialEquityLog, long userId, String actionId,
		int actionDate, boolean active, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

		query.append(_FINDER_COLUMN_U_AID_AD_A_T_USERID_2);

		if (actionId == null) {
			query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_1);
		}
		else {
			if (actionId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_3);
			}
			else {
				query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_2);
			}
		}

		query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONDATE_2);

		query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIVE_2);

		query.append(_FINDER_COLUMN_U_AID_AD_A_T_TYPE_2);

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

		qPos.add(userId);

		if (actionId != null) {
			qPos.add(actionId);
		}

		qPos.add(actionDate);

		qPos.add(active);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(socialEquityLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialEquityLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the social equity logs where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByAEI_AID_AD_A_T(long assetEntryId,
		String actionId, int actionDate, boolean active, int type)
		throws SystemException {
		return findByAEI_AID_AD_A_T(assetEntryId, actionId, actionDate, active,
			type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the social equity logs where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @return the range of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByAEI_AID_AD_A_T(long assetEntryId,
		String actionId, int actionDate, boolean active, int type, int start,
		int end) throws SystemException {
		return findByAEI_AID_AD_A_T(assetEntryId, actionId, actionDate, active,
			type, start, end, null);
	}

	/**
	 * Finds an ordered range of all the social equity logs where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findByAEI_AID_AD_A_T(long assetEntryId,
		String actionId, int actionDate, boolean active, int type, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				assetEntryId, actionId, actionDate, active, type,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SocialEquityLog> list = (List<SocialEquityLog>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_AEI_AID_AD_A_T,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ASSETENTRYID_2);

			if (actionId == null) {
				query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_1);
			}
			else {
				if (actionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_2);
				}
			}

			query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONDATE_2);

			query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIVE_2);

			query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_TYPE_2);

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

				qPos.add(assetEntryId);

				if (actionId != null) {
					qPos.add(actionId);
				}

				qPos.add(actionDate);

				qPos.add(active);

				qPos.add(type);

				list = (List<SocialEquityLog>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_AEI_AID_AD_A_T,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_AEI_AID_AD_A_T,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByAEI_AID_AD_A_T_First(long assetEntryId,
		String actionId, int actionDate, boolean active, int type,
		OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		List<SocialEquityLog> list = findByAEI_AID_AD_A_T(assetEntryId,
				actionId, actionDate, active, type, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assetEntryId=");
			msg.append(assetEntryId);

			msg.append(", actionId=");
			msg.append(actionId);

			msg.append(", actionDate=");
			msg.append(actionDate);

			msg.append(", active=");
			msg.append(active);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEquityLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByAEI_AID_AD_A_T_Last(long assetEntryId,
		String actionId, int actionDate, boolean active, int type,
		OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		int count = countByAEI_AID_AD_A_T(assetEntryId, actionId, actionDate,
				active, type);

		List<SocialEquityLog> list = findByAEI_AID_AD_A_T(assetEntryId,
				actionId, actionDate, active, type, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assetEntryId=");
			msg.append(assetEntryId);

			msg.append(", actionId=");
			msg.append(actionId);

			msg.append(", actionDate=");
			msg.append(actionDate);

			msg.append(", active=");
			msg.append(active);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEquityLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the social equity logs before and after the current social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param equityLogId the primary key of the current social equity log
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog[] findByAEI_AID_AD_A_T_PrevAndNext(
		long equityLogId, long assetEntryId, String actionId, int actionDate,
		boolean active, int type, OrderByComparator orderByComparator)
		throws NoSuchEquityLogException, SystemException {
		SocialEquityLog socialEquityLog = findByPrimaryKey(equityLogId);

		Session session = null;

		try {
			session = openSession();

			SocialEquityLog[] array = new SocialEquityLogImpl[3];

			array[0] = getByAEI_AID_AD_A_T_PrevAndNext(session,
					socialEquityLog, assetEntryId, actionId, actionDate,
					active, type, orderByComparator, true);

			array[1] = socialEquityLog;

			array[2] = getByAEI_AID_AD_A_T_PrevAndNext(session,
					socialEquityLog, assetEntryId, actionId, actionDate,
					active, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialEquityLog getByAEI_AID_AD_A_T_PrevAndNext(Session session,
		SocialEquityLog socialEquityLog, long assetEntryId, String actionId,
		int actionDate, boolean active, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

		query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ASSETENTRYID_2);

		if (actionId == null) {
			query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_1);
		}
		else {
			if (actionId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_3);
			}
			else {
				query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_2);
			}
		}

		query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONDATE_2);

		query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIVE_2);

		query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_TYPE_2);

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

		qPos.add(assetEntryId);

		if (actionId != null) {
			qPos.add(actionId);
		}

		qPos.add(actionDate);

		qPos.add(active);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(socialEquityLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialEquityLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the social equity log where userId = &#63; and assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; or throws a {@link com.liferay.portlet.social.NoSuchEquityLogException} if it could not be found.
	 *
	 * @param userId the user id to search with
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the matching social equity log
	 * @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog findByU_AEI_AID_AD_A_T(long userId,
		long assetEntryId, String actionId, int actionDate, boolean active,
		int type) throws NoSuchEquityLogException, SystemException {
		SocialEquityLog socialEquityLog = fetchByU_AEI_AID_AD_A_T(userId,
				assetEntryId, actionId, actionDate, active, type);

		if (socialEquityLog == null) {
			StringBundler msg = new StringBundler(14);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", assetEntryId=");
			msg.append(assetEntryId);

			msg.append(", actionId=");
			msg.append(actionId);

			msg.append(", actionDate=");
			msg.append(actionDate);

			msg.append(", active=");
			msg.append(active);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEquityLogException(msg.toString());
		}

		return socialEquityLog;
	}

	/**
	 * Finds the social equity log where userId = &#63; and assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user id to search with
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the matching social equity log, or <code>null</code> if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog fetchByU_AEI_AID_AD_A_T(long userId,
		long assetEntryId, String actionId, int actionDate, boolean active,
		int type) throws SystemException {
		return fetchByU_AEI_AID_AD_A_T(userId, assetEntryId, actionId,
			actionDate, active, type, true);
	}

	/**
	 * Finds the social equity log where userId = &#63; and assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user id to search with
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the matching social equity log, or <code>null</code> if a matching social equity log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SocialEquityLog fetchByU_AEI_AID_AD_A_T(long userId,
		long assetEntryId, String actionId, int actionDate, boolean active,
		int type, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				userId, assetEntryId, actionId, actionDate, active, type
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_U_AEI_AID_AD_A_T,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_USERID_2);

			query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ASSETENTRYID_2);

			if (actionId == null) {
				query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONID_1);
			}
			else {
				if (actionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONID_2);
				}
			}

			query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONDATE_2);

			query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIVE_2);

			query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(assetEntryId);

				if (actionId != null) {
					qPos.add(actionId);
				}

				qPos.add(actionDate);

				qPos.add(active);

				qPos.add(type);

				List<SocialEquityLog> list = q.list();

				result = list;

				SocialEquityLog socialEquityLog = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_AEI_AID_AD_A_T,
						finderArgs, list);
				}
				else {
					socialEquityLog = list.get(0);

					cacheResult(socialEquityLog);

					if ((socialEquityLog.getUserId() != userId) ||
							(socialEquityLog.getAssetEntryId() != assetEntryId) ||
							(socialEquityLog.getActionId() == null) ||
							!socialEquityLog.getActionId().equals(actionId) ||
							(socialEquityLog.getActionDate() != actionDate) ||
							(socialEquityLog.getActive() != active) ||
							(socialEquityLog.getType() != type)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_AEI_AID_AD_A_T,
							finderArgs, socialEquityLog);
					}
				}

				return socialEquityLog;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_AEI_AID_AD_A_T,
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
				return (SocialEquityLog)result;
			}
		}
	}

	/**
	 * Finds all the social equity logs.
	 *
	 * @return the social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the social equity logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @return the range of social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the social equity logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of social equity logs to return
	 * @param end the upper bound of the range of social equity logs to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SocialEquityLog> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SocialEquityLog> list = (List<SocialEquityLog>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOCIALEQUITYLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALEQUITYLOG;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SocialEquityLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SocialEquityLog>)QueryUtil.list(q,
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
	 * Removes all the social equity logs where assetEntryId = &#63; and type = &#63; and active = &#63; from the database.
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param type the type to search with
	 * @param active the active to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAEI_T_A(long assetEntryId, int type, boolean active)
		throws SystemException {
		for (SocialEquityLog socialEquityLog : findByAEI_T_A(assetEntryId,
				type, active)) {
			remove(socialEquityLog);
		}
	}

	/**
	 * Removes all the social equity logs where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63; from the database.
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_AID_A_T(long userId, String actionId, boolean active,
		int type) throws SystemException {
		for (SocialEquityLog socialEquityLog : findByU_AID_A_T(userId,
				actionId, active, type)) {
			remove(socialEquityLog);
		}
	}

	/**
	 * Removes all the social equity logs where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63; from the database.
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAEI_AID_A_T(long assetEntryId, String actionId,
		boolean active, int type) throws SystemException {
		for (SocialEquityLog socialEquityLog : findByAEI_AID_A_T(assetEntryId,
				actionId, active, type)) {
			remove(socialEquityLog);
		}
	}

	/**
	 * Removes all the social equity logs where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; from the database.
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_AID_AD_A_T(long userId, String actionId,
		int actionDate, boolean active, int type) throws SystemException {
		for (SocialEquityLog socialEquityLog : findByU_AID_AD_A_T(userId,
				actionId, actionDate, active, type)) {
			remove(socialEquityLog);
		}
	}

	/**
	 * Removes all the social equity logs where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; from the database.
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAEI_AID_AD_A_T(long assetEntryId, String actionId,
		int actionDate, boolean active, int type) throws SystemException {
		for (SocialEquityLog socialEquityLog : findByAEI_AID_AD_A_T(
				assetEntryId, actionId, actionDate, active, type)) {
			remove(socialEquityLog);
		}
	}

	/**
	 * Removes the social equity log where userId = &#63; and assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; from the database.
	 *
	 * @param userId the user id to search with
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_AEI_AID_AD_A_T(long userId, long assetEntryId,
		String actionId, int actionDate, boolean active, int type)
		throws NoSuchEquityLogException, SystemException {
		SocialEquityLog socialEquityLog = findByU_AEI_AID_AD_A_T(userId,
				assetEntryId, actionId, actionDate, active, type);

		remove(socialEquityLog);
	}

	/**
	 * Removes all the social equity logs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SocialEquityLog socialEquityLog : findAll()) {
			remove(socialEquityLog);
		}
	}

	/**
	 * Counts all the social equity logs where assetEntryId = &#63; and type = &#63; and active = &#63;.
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param type the type to search with
	 * @param active the active to search with
	 * @return the number of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAEI_T_A(long assetEntryId, int type, boolean active)
		throws SystemException {
		Object[] finderArgs = new Object[] { assetEntryId, type, active };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AEI_T_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_AEI_T_A_ASSETENTRYID_2);

			query.append(_FINDER_COLUMN_AEI_T_A_TYPE_2);

			query.append(_FINDER_COLUMN_AEI_T_A_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assetEntryId);

				qPos.add(type);

				qPos.add(active);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AEI_T_A,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the social equity logs where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the number of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_AID_A_T(long userId, String actionId, boolean active,
		int type) throws SystemException {
		Object[] finderArgs = new Object[] { userId, actionId, active, type };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_AID_A_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_U_AID_A_T_USERID_2);

			if (actionId == null) {
				query.append(_FINDER_COLUMN_U_AID_A_T_ACTIONID_1);
			}
			else {
				if (actionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_AID_A_T_ACTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_AID_A_T_ACTIONID_2);
				}
			}

			query.append(_FINDER_COLUMN_U_AID_A_T_ACTIVE_2);

			query.append(_FINDER_COLUMN_U_AID_A_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (actionId != null) {
					qPos.add(actionId);
				}

				qPos.add(active);

				qPos.add(type);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_AID_A_T,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the social equity logs where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the number of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAEI_AID_A_T(long assetEntryId, String actionId,
		boolean active, int type) throws SystemException {
		Object[] finderArgs = new Object[] { assetEntryId, actionId, active, type };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AEI_AID_A_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_AEI_AID_A_T_ASSETENTRYID_2);

			if (actionId == null) {
				query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIONID_1);
			}
			else {
				if (actionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIONID_2);
				}
			}

			query.append(_FINDER_COLUMN_AEI_AID_A_T_ACTIVE_2);

			query.append(_FINDER_COLUMN_AEI_AID_A_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assetEntryId);

				if (actionId != null) {
					qPos.add(actionId);
				}

				qPos.add(active);

				qPos.add(type);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AEI_AID_A_T,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the social equity logs where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * @param userId the user id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the number of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_AID_AD_A_T(long userId, String actionId,
		int actionDate, boolean active, int type) throws SystemException {
		Object[] finderArgs = new Object[] {
				userId, actionId, actionDate, active, type
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_AID_AD_A_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_U_AID_AD_A_T_USERID_2);

			if (actionId == null) {
				query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_1);
			}
			else {
				if (actionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_2);
				}
			}

			query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIONDATE_2);

			query.append(_FINDER_COLUMN_U_AID_AD_A_T_ACTIVE_2);

			query.append(_FINDER_COLUMN_U_AID_AD_A_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (actionId != null) {
					qPos.add(actionId);
				}

				qPos.add(actionDate);

				qPos.add(active);

				qPos.add(type);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_AID_AD_A_T,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the social equity logs where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the number of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAEI_AID_AD_A_T(long assetEntryId, String actionId,
		int actionDate, boolean active, int type) throws SystemException {
		Object[] finderArgs = new Object[] {
				assetEntryId, actionId, actionDate, active, type
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AEI_AID_AD_A_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ASSETENTRYID_2);

			if (actionId == null) {
				query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_1);
			}
			else {
				if (actionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_2);
				}
			}

			query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONDATE_2);

			query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_ACTIVE_2);

			query.append(_FINDER_COLUMN_AEI_AID_AD_A_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assetEntryId);

				if (actionId != null) {
					qPos.add(actionId);
				}

				qPos.add(actionDate);

				qPos.add(active);

				qPos.add(type);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AEI_AID_AD_A_T,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the social equity logs where userId = &#63; and assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	 *
	 * @param userId the user id to search with
	 * @param assetEntryId the asset entry id to search with
	 * @param actionId the action id to search with
	 * @param actionDate the action date to search with
	 * @param active the active to search with
	 * @param type the type to search with
	 * @return the number of matching social equity logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_AEI_AID_AD_A_T(long userId, long assetEntryId,
		String actionId, int actionDate, boolean active, int type)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				userId, assetEntryId, actionId, actionDate, active, type
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_AEI_AID_AD_A_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_SOCIALEQUITYLOG_WHERE);

			query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_USERID_2);

			query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ASSETENTRYID_2);

			if (actionId == null) {
				query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONID_1);
			}
			else {
				if (actionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONID_2);
				}
			}

			query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONDATE_2);

			query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIVE_2);

			query.append(_FINDER_COLUMN_U_AEI_AID_AD_A_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(assetEntryId);

				if (actionId != null) {
					qPos.add(actionId);
				}

				qPos.add(actionDate);

				qPos.add(active);

				qPos.add(type);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_AEI_AID_AD_A_T,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the social equity logs.
	 *
	 * @return the number of social equity logs
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

				Query q = session.createQuery(_SQL_COUNT_SOCIALEQUITYLOG);

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
	 * Initializes the social equity log persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portlet.social.model.SocialEquityLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SocialEquityLog>> listenersList = new ArrayList<ModelListener<SocialEquityLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SocialEquityLog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SocialEquityLogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	@BeanReference(type = SocialEquityAssetEntryPersistence.class)
	protected SocialEquityAssetEntryPersistence socialEquityAssetEntryPersistence;
	@BeanReference(type = SocialEquityGroupSettingPersistence.class)
	protected SocialEquityGroupSettingPersistence socialEquityGroupSettingPersistence;
	@BeanReference(type = SocialEquityHistoryPersistence.class)
	protected SocialEquityHistoryPersistence socialEquityHistoryPersistence;
	@BeanReference(type = SocialEquityLogPersistence.class)
	protected SocialEquityLogPersistence socialEquityLogPersistence;
	@BeanReference(type = SocialEquitySettingPersistence.class)
	protected SocialEquitySettingPersistence socialEquitySettingPersistence;
	@BeanReference(type = SocialEquityUserPersistence.class)
	protected SocialEquityUserPersistence socialEquityUserPersistence;
	@BeanReference(type = SocialRelationPersistence.class)
	protected SocialRelationPersistence socialRelationPersistence;
	@BeanReference(type = SocialRequestPersistence.class)
	protected SocialRequestPersistence socialRequestPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	private static final String _SQL_SELECT_SOCIALEQUITYLOG = "SELECT socialEquityLog FROM SocialEquityLog socialEquityLog";
	private static final String _SQL_SELECT_SOCIALEQUITYLOG_WHERE = "SELECT socialEquityLog FROM SocialEquityLog socialEquityLog WHERE ";
	private static final String _SQL_COUNT_SOCIALEQUITYLOG = "SELECT COUNT(socialEquityLog) FROM SocialEquityLog socialEquityLog";
	private static final String _SQL_COUNT_SOCIALEQUITYLOG_WHERE = "SELECT COUNT(socialEquityLog) FROM SocialEquityLog socialEquityLog WHERE ";
	private static final String _FINDER_COLUMN_AEI_T_A_ASSETENTRYID_2 = "socialEquityLog.assetEntryId = ? AND ";
	private static final String _FINDER_COLUMN_AEI_T_A_TYPE_2 = "socialEquityLog.type = ? AND ";
	private static final String _FINDER_COLUMN_AEI_T_A_ACTIVE_2 = "socialEquityLog.active = ?";
	private static final String _FINDER_COLUMN_U_AID_A_T_USERID_2 = "socialEquityLog.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_AID_A_T_ACTIONID_1 = "socialEquityLog.actionId IS NULL AND ";
	private static final String _FINDER_COLUMN_U_AID_A_T_ACTIONID_2 = "socialEquityLog.actionId = ? AND ";
	private static final String _FINDER_COLUMN_U_AID_A_T_ACTIONID_3 = "(socialEquityLog.actionId IS NULL OR socialEquityLog.actionId = ?) AND ";
	private static final String _FINDER_COLUMN_U_AID_A_T_ACTIVE_2 = "socialEquityLog.active = ? AND ";
	private static final String _FINDER_COLUMN_U_AID_A_T_TYPE_2 = "socialEquityLog.type = ?";
	private static final String _FINDER_COLUMN_AEI_AID_A_T_ASSETENTRYID_2 = "socialEquityLog.assetEntryId = ? AND ";
	private static final String _FINDER_COLUMN_AEI_AID_A_T_ACTIONID_1 = "socialEquityLog.actionId IS NULL AND ";
	private static final String _FINDER_COLUMN_AEI_AID_A_T_ACTIONID_2 = "socialEquityLog.actionId = ? AND ";
	private static final String _FINDER_COLUMN_AEI_AID_A_T_ACTIONID_3 = "(socialEquityLog.actionId IS NULL OR socialEquityLog.actionId = ?) AND ";
	private static final String _FINDER_COLUMN_AEI_AID_A_T_ACTIVE_2 = "socialEquityLog.active = ? AND ";
	private static final String _FINDER_COLUMN_AEI_AID_A_T_TYPE_2 = "socialEquityLog.type = ?";
	private static final String _FINDER_COLUMN_U_AID_AD_A_T_USERID_2 = "socialEquityLog.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_1 = "socialEquityLog.actionId IS NULL AND ";
	private static final String _FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_2 = "socialEquityLog.actionId = ? AND ";
	private static final String _FINDER_COLUMN_U_AID_AD_A_T_ACTIONID_3 = "(socialEquityLog.actionId IS NULL OR socialEquityLog.actionId = ?) AND ";
	private static final String _FINDER_COLUMN_U_AID_AD_A_T_ACTIONDATE_2 = "socialEquityLog.actionDate = ? AND ";
	private static final String _FINDER_COLUMN_U_AID_AD_A_T_ACTIVE_2 = "socialEquityLog.active = ? AND ";
	private static final String _FINDER_COLUMN_U_AID_AD_A_T_TYPE_2 = "socialEquityLog.type = ?";
	private static final String _FINDER_COLUMN_AEI_AID_AD_A_T_ASSETENTRYID_2 = "socialEquityLog.assetEntryId = ? AND ";
	private static final String _FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_1 = "socialEquityLog.actionId IS NULL AND ";
	private static final String _FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_2 = "socialEquityLog.actionId = ? AND ";
	private static final String _FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONID_3 = "(socialEquityLog.actionId IS NULL OR socialEquityLog.actionId = ?) AND ";
	private static final String _FINDER_COLUMN_AEI_AID_AD_A_T_ACTIONDATE_2 = "socialEquityLog.actionDate = ? AND ";
	private static final String _FINDER_COLUMN_AEI_AID_AD_A_T_ACTIVE_2 = "socialEquityLog.active = ? AND ";
	private static final String _FINDER_COLUMN_AEI_AID_AD_A_T_TYPE_2 = "socialEquityLog.type = ?";
	private static final String _FINDER_COLUMN_U_AEI_AID_AD_A_T_USERID_2 = "socialEquityLog.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_AEI_AID_AD_A_T_ASSETENTRYID_2 = "socialEquityLog.assetEntryId = ? AND ";
	private static final String _FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONID_1 = "socialEquityLog.actionId IS NULL AND ";
	private static final String _FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONID_2 = "socialEquityLog.actionId = ? AND ";
	private static final String _FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONID_3 = "(socialEquityLog.actionId IS NULL OR socialEquityLog.actionId = ?) AND ";
	private static final String _FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIONDATE_2 = "socialEquityLog.actionDate = ? AND ";
	private static final String _FINDER_COLUMN_U_AEI_AID_AD_A_T_ACTIVE_2 = "socialEquityLog.active = ? AND ";
	private static final String _FINDER_COLUMN_U_AEI_AID_AD_A_T_TYPE_2 = "socialEquityLog.type = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "socialEquityLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SocialEquityLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SocialEquityLog exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(SocialEquityLogPersistenceImpl.class);
}