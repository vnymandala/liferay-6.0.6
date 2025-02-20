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

package com.liferay.portal.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.NoSuchServiceComponentException;
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
import com.liferay.portal.model.ServiceComponent;
import com.liferay.portal.model.impl.ServiceComponentImpl;
import com.liferay.portal.model.impl.ServiceComponentModelImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the service component service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ServiceComponentUtil} to access the service component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceComponentPersistence
 * @see ServiceComponentUtil
 * @generated
 */
public class ServiceComponentPersistenceImpl extends BasePersistenceImpl<ServiceComponent>
	implements ServiceComponentPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ServiceComponentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_BUILDNAMESPACE = new FinderPath(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByBuildNamespace",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_BUILDNAMESPACE = new FinderPath(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByBuildNamespace",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_BNS_BNU = new FinderPath(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByBNS_BNU",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_BNS_BNU = new FinderPath(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByBNS_BNU",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the service component in the entity cache if it is enabled.
	 *
	 * @param serviceComponent the service component to cache
	 */
	public void cacheResult(ServiceComponent serviceComponent) {
		EntityCacheUtil.putResult(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentImpl.class, serviceComponent.getPrimaryKey(),
			serviceComponent);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BNS_BNU,
			new Object[] {
				serviceComponent.getBuildNamespace(),
				new Long(serviceComponent.getBuildNumber())
			}, serviceComponent);
	}

	/**
	 * Caches the service components in the entity cache if it is enabled.
	 *
	 * @param serviceComponents the service components to cache
	 */
	public void cacheResult(List<ServiceComponent> serviceComponents) {
		for (ServiceComponent serviceComponent : serviceComponents) {
			if (EntityCacheUtil.getResult(
						ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
						ServiceComponentImpl.class,
						serviceComponent.getPrimaryKey(), this) == null) {
				cacheResult(serviceComponent);
			}
		}
	}

	/**
	 * Clears the cache for all service components.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ServiceComponentImpl.class.getName());
		EntityCacheUtil.clearCache(ServiceComponentImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the service component.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ServiceComponent serviceComponent) {
		EntityCacheUtil.removeResult(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentImpl.class, serviceComponent.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BNS_BNU,
			new Object[] {
				serviceComponent.getBuildNamespace(),
				new Long(serviceComponent.getBuildNumber())
			});
	}

	/**
	 * Creates a new service component with the primary key. Does not add the service component to the database.
	 *
	 * @param serviceComponentId the primary key for the new service component
	 * @return the new service component
	 */
	public ServiceComponent create(long serviceComponentId) {
		ServiceComponent serviceComponent = new ServiceComponentImpl();

		serviceComponent.setNew(true);
		serviceComponent.setPrimaryKey(serviceComponentId);

		return serviceComponent;
	}

	/**
	 * Removes the service component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service component to remove
	 * @return the service component that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a service component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the service component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceComponentId the primary key of the service component to remove
	 * @return the service component that was removed
	 * @throws com.liferay.portal.NoSuchServiceComponentException if a service component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent remove(long serviceComponentId)
		throws NoSuchServiceComponentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServiceComponent serviceComponent = (ServiceComponent)session.get(ServiceComponentImpl.class,
					new Long(serviceComponentId));

			if (serviceComponent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						serviceComponentId);
				}

				throw new NoSuchServiceComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					serviceComponentId);
			}

			return remove(serviceComponent);
		}
		catch (NoSuchServiceComponentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceComponent removeImpl(ServiceComponent serviceComponent)
		throws SystemException {
		serviceComponent = toUnwrappedModel(serviceComponent);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, serviceComponent);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		ServiceComponentModelImpl serviceComponentModelImpl = (ServiceComponentModelImpl)serviceComponent;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BNS_BNU,
			new Object[] {
				serviceComponentModelImpl.getBuildNamespace(),
				new Long(serviceComponentModelImpl.getBuildNumber())
			});

		EntityCacheUtil.removeResult(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentImpl.class, serviceComponent.getPrimaryKey());

		return serviceComponent;
	}

	public ServiceComponent updateImpl(
		com.liferay.portal.model.ServiceComponent serviceComponent,
		boolean merge) throws SystemException {
		serviceComponent = toUnwrappedModel(serviceComponent);

		boolean isNew = serviceComponent.isNew();

		ServiceComponentModelImpl serviceComponentModelImpl = (ServiceComponentModelImpl)serviceComponent;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, serviceComponent, merge);

			serviceComponent.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentImpl.class, serviceComponent.getPrimaryKey(),
			serviceComponent);

		if (!isNew &&
				(!Validator.equals(serviceComponent.getBuildNamespace(),
					serviceComponentModelImpl.getOriginalBuildNamespace()) ||
				(serviceComponent.getBuildNumber() != serviceComponentModelImpl.getOriginalBuildNumber()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BNS_BNU,
				new Object[] {
					serviceComponentModelImpl.getOriginalBuildNamespace(),
					new Long(serviceComponentModelImpl.getOriginalBuildNumber())
				});
		}

		if (isNew ||
				(!Validator.equals(serviceComponent.getBuildNamespace(),
					serviceComponentModelImpl.getOriginalBuildNamespace()) ||
				(serviceComponent.getBuildNumber() != serviceComponentModelImpl.getOriginalBuildNumber()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BNS_BNU,
				new Object[] {
					serviceComponent.getBuildNamespace(),
					new Long(serviceComponent.getBuildNumber())
				}, serviceComponent);
		}

		return serviceComponent;
	}

	protected ServiceComponent toUnwrappedModel(
		ServiceComponent serviceComponent) {
		if (serviceComponent instanceof ServiceComponentImpl) {
			return serviceComponent;
		}

		ServiceComponentImpl serviceComponentImpl = new ServiceComponentImpl();

		serviceComponentImpl.setNew(serviceComponent.isNew());
		serviceComponentImpl.setPrimaryKey(serviceComponent.getPrimaryKey());

		serviceComponentImpl.setServiceComponentId(serviceComponent.getServiceComponentId());
		serviceComponentImpl.setBuildNamespace(serviceComponent.getBuildNamespace());
		serviceComponentImpl.setBuildNumber(serviceComponent.getBuildNumber());
		serviceComponentImpl.setBuildDate(serviceComponent.getBuildDate());
		serviceComponentImpl.setData(serviceComponent.getData());

		return serviceComponentImpl;
	}

	/**
	 * Finds the service component with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service component to find
	 * @return the service component
	 * @throws com.liferay.portal.NoSuchModelException if a service component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the service component with the primary key or throws a {@link com.liferay.portal.NoSuchServiceComponentException} if it could not be found.
	 *
	 * @param serviceComponentId the primary key of the service component to find
	 * @return the service component
	 * @throws com.liferay.portal.NoSuchServiceComponentException if a service component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent findByPrimaryKey(long serviceComponentId)
		throws NoSuchServiceComponentException, SystemException {
		ServiceComponent serviceComponent = fetchByPrimaryKey(serviceComponentId);

		if (serviceComponent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					serviceComponentId);
			}

			throw new NoSuchServiceComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				serviceComponentId);
		}

		return serviceComponent;
	}

	/**
	 * Finds the service component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service component to find
	 * @return the service component, or <code>null</code> if a service component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the service component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceComponentId the primary key of the service component to find
	 * @return the service component, or <code>null</code> if a service component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent fetchByPrimaryKey(long serviceComponentId)
		throws SystemException {
		ServiceComponent serviceComponent = (ServiceComponent)EntityCacheUtil.getResult(ServiceComponentModelImpl.ENTITY_CACHE_ENABLED,
				ServiceComponentImpl.class, serviceComponentId, this);

		if (serviceComponent == null) {
			Session session = null;

			try {
				session = openSession();

				serviceComponent = (ServiceComponent)session.get(ServiceComponentImpl.class,
						new Long(serviceComponentId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (serviceComponent != null) {
					cacheResult(serviceComponent);
				}

				closeSession(session);
			}
		}

		return serviceComponent;
	}

	/**
	 * Finds all the service components where buildNamespace = &#63;.
	 *
	 * @param buildNamespace the build namespace to search with
	 * @return the matching service components
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceComponent> findByBuildNamespace(String buildNamespace)
		throws SystemException {
		return findByBuildNamespace(buildNamespace, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the service components where buildNamespace = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param buildNamespace the build namespace to search with
	 * @param start the lower bound of the range of service components to return
	 * @param end the upper bound of the range of service components to return (not inclusive)
	 * @return the range of matching service components
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceComponent> findByBuildNamespace(String buildNamespace,
		int start, int end) throws SystemException {
		return findByBuildNamespace(buildNamespace, start, end, null);
	}

	/**
	 * Finds an ordered range of all the service components where buildNamespace = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param buildNamespace the build namespace to search with
	 * @param start the lower bound of the range of service components to return
	 * @param end the upper bound of the range of service components to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching service components
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceComponent> findByBuildNamespace(String buildNamespace,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				buildNamespace,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ServiceComponent> list = (List<ServiceComponent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_BUILDNAMESPACE,
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

			query.append(_SQL_SELECT_SERVICECOMPONENT_WHERE);

			if (buildNamespace == null) {
				query.append(_FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_1);
			}
			else {
				if (buildNamespace.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_3);
				}
				else {
					query.append(_FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ServiceComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (buildNamespace != null) {
					qPos.add(buildNamespace);
				}

				list = (List<ServiceComponent>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_BUILDNAMESPACE,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_BUILDNAMESPACE,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first service component in the ordered set where buildNamespace = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param buildNamespace the build namespace to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching service component
	 * @throws com.liferay.portal.NoSuchServiceComponentException if a matching service component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent findByBuildNamespace_First(String buildNamespace,
		OrderByComparator orderByComparator)
		throws NoSuchServiceComponentException, SystemException {
		List<ServiceComponent> list = findByBuildNamespace(buildNamespace, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("buildNamespace=");
			msg.append(buildNamespace);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceComponentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last service component in the ordered set where buildNamespace = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param buildNamespace the build namespace to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching service component
	 * @throws com.liferay.portal.NoSuchServiceComponentException if a matching service component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent findByBuildNamespace_Last(String buildNamespace,
		OrderByComparator orderByComparator)
		throws NoSuchServiceComponentException, SystemException {
		int count = countByBuildNamespace(buildNamespace);

		List<ServiceComponent> list = findByBuildNamespace(buildNamespace,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("buildNamespace=");
			msg.append(buildNamespace);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceComponentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the service components before and after the current service component in the ordered set where buildNamespace = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param serviceComponentId the primary key of the current service component
	 * @param buildNamespace the build namespace to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next service component
	 * @throws com.liferay.portal.NoSuchServiceComponentException if a service component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent[] findByBuildNamespace_PrevAndNext(
		long serviceComponentId, String buildNamespace,
		OrderByComparator orderByComparator)
		throws NoSuchServiceComponentException, SystemException {
		ServiceComponent serviceComponent = findByPrimaryKey(serviceComponentId);

		Session session = null;

		try {
			session = openSession();

			ServiceComponent[] array = new ServiceComponentImpl[3];

			array[0] = getByBuildNamespace_PrevAndNext(session,
					serviceComponent, buildNamespace, orderByComparator, true);

			array[1] = serviceComponent;

			array[2] = getByBuildNamespace_PrevAndNext(session,
					serviceComponent, buildNamespace, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceComponent getByBuildNamespace_PrevAndNext(
		Session session, ServiceComponent serviceComponent,
		String buildNamespace, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICECOMPONENT_WHERE);

		if (buildNamespace == null) {
			query.append(_FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_1);
		}
		else {
			if (buildNamespace.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_3);
			}
			else {
				query.append(_FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_2);
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
			query.append(ServiceComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (buildNamespace != null) {
			qPos.add(buildNamespace);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(serviceComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the service component where buildNamespace = &#63; and buildNumber = &#63; or throws a {@link com.liferay.portal.NoSuchServiceComponentException} if it could not be found.
	 *
	 * @param buildNamespace the build namespace to search with
	 * @param buildNumber the build number to search with
	 * @return the matching service component
	 * @throws com.liferay.portal.NoSuchServiceComponentException if a matching service component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent findByBNS_BNU(String buildNamespace,
		long buildNumber)
		throws NoSuchServiceComponentException, SystemException {
		ServiceComponent serviceComponent = fetchByBNS_BNU(buildNamespace,
				buildNumber);

		if (serviceComponent == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("buildNamespace=");
			msg.append(buildNamespace);

			msg.append(", buildNumber=");
			msg.append(buildNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchServiceComponentException(msg.toString());
		}

		return serviceComponent;
	}

	/**
	 * Finds the service component where buildNamespace = &#63; and buildNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param buildNamespace the build namespace to search with
	 * @param buildNumber the build number to search with
	 * @return the matching service component, or <code>null</code> if a matching service component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent fetchByBNS_BNU(String buildNamespace,
		long buildNumber) throws SystemException {
		return fetchByBNS_BNU(buildNamespace, buildNumber, true);
	}

	/**
	 * Finds the service component where buildNamespace = &#63; and buildNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param buildNamespace the build namespace to search with
	 * @param buildNumber the build number to search with
	 * @return the matching service component, or <code>null</code> if a matching service component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceComponent fetchByBNS_BNU(String buildNamespace,
		long buildNumber, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { buildNamespace, buildNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BNS_BNU,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SERVICECOMPONENT_WHERE);

			if (buildNamespace == null) {
				query.append(_FINDER_COLUMN_BNS_BNU_BUILDNAMESPACE_1);
			}
			else {
				if (buildNamespace.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BNS_BNU_BUILDNAMESPACE_3);
				}
				else {
					query.append(_FINDER_COLUMN_BNS_BNU_BUILDNAMESPACE_2);
				}
			}

			query.append(_FINDER_COLUMN_BNS_BNU_BUILDNUMBER_2);

			query.append(ServiceComponentModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (buildNamespace != null) {
					qPos.add(buildNamespace);
				}

				qPos.add(buildNumber);

				List<ServiceComponent> list = q.list();

				result = list;

				ServiceComponent serviceComponent = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BNS_BNU,
						finderArgs, list);
				}
				else {
					serviceComponent = list.get(0);

					cacheResult(serviceComponent);

					if ((serviceComponent.getBuildNamespace() == null) ||
							!serviceComponent.getBuildNamespace()
												 .equals(buildNamespace) ||
							(serviceComponent.getBuildNumber() != buildNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BNS_BNU,
							finderArgs, serviceComponent);
					}
				}

				return serviceComponent;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BNS_BNU,
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
				return (ServiceComponent)result;
			}
		}
	}

	/**
	 * Finds all the service components.
	 *
	 * @return the service components
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceComponent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the service components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of service components to return
	 * @param end the upper bound of the range of service components to return (not inclusive)
	 * @return the range of service components
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceComponent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the service components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of service components to return
	 * @param end the upper bound of the range of service components to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of service components
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceComponent> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ServiceComponent> list = (List<ServiceComponent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICECOMPONENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICECOMPONENT.concat(ServiceComponentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ServiceComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ServiceComponent>)QueryUtil.list(q,
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
	 * Removes all the service components where buildNamespace = &#63; from the database.
	 *
	 * @param buildNamespace the build namespace to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBuildNamespace(String buildNamespace)
		throws SystemException {
		for (ServiceComponent serviceComponent : findByBuildNamespace(
				buildNamespace)) {
			remove(serviceComponent);
		}
	}

	/**
	 * Removes the service component where buildNamespace = &#63; and buildNumber = &#63; from the database.
	 *
	 * @param buildNamespace the build namespace to search with
	 * @param buildNumber the build number to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBNS_BNU(String buildNamespace, long buildNumber)
		throws NoSuchServiceComponentException, SystemException {
		ServiceComponent serviceComponent = findByBNS_BNU(buildNamespace,
				buildNumber);

		remove(serviceComponent);
	}

	/**
	 * Removes all the service components from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ServiceComponent serviceComponent : findAll()) {
			remove(serviceComponent);
		}
	}

	/**
	 * Counts all the service components where buildNamespace = &#63;.
	 *
	 * @param buildNamespace the build namespace to search with
	 * @return the number of matching service components
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBuildNamespace(String buildNamespace)
		throws SystemException {
		Object[] finderArgs = new Object[] { buildNamespace };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BUILDNAMESPACE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICECOMPONENT_WHERE);

			if (buildNamespace == null) {
				query.append(_FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_1);
			}
			else {
				if (buildNamespace.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_3);
				}
				else {
					query.append(_FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (buildNamespace != null) {
					qPos.add(buildNamespace);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BUILDNAMESPACE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the service components where buildNamespace = &#63; and buildNumber = &#63;.
	 *
	 * @param buildNamespace the build namespace to search with
	 * @param buildNumber the build number to search with
	 * @return the number of matching service components
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBNS_BNU(String buildNamespace, long buildNumber)
		throws SystemException {
		Object[] finderArgs = new Object[] { buildNamespace, buildNumber };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BNS_BNU,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SERVICECOMPONENT_WHERE);

			if (buildNamespace == null) {
				query.append(_FINDER_COLUMN_BNS_BNU_BUILDNAMESPACE_1);
			}
			else {
				if (buildNamespace.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BNS_BNU_BUILDNAMESPACE_3);
				}
				else {
					query.append(_FINDER_COLUMN_BNS_BNU_BUILDNAMESPACE_2);
				}
			}

			query.append(_FINDER_COLUMN_BNS_BNU_BUILDNUMBER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (buildNamespace != null) {
					qPos.add(buildNamespace);
				}

				qPos.add(buildNumber);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BNS_BNU,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the service components.
	 *
	 * @return the number of service components
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

				Query q = session.createQuery(_SQL_COUNT_SERVICECOMPONENT);

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
	 * Initializes the service component persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portal.model.ServiceComponent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServiceComponent>> listenersList = new ArrayList<ModelListener<ServiceComponent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServiceComponent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServiceComponentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = AccountPersistence.class)
	protected AccountPersistence accountPersistence;
	@BeanReference(type = AddressPersistence.class)
	protected AddressPersistence addressPersistence;
	@BeanReference(type = BrowserTrackerPersistence.class)
	protected BrowserTrackerPersistence browserTrackerPersistence;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = ClusterGroupPersistence.class)
	protected ClusterGroupPersistence clusterGroupPersistence;
	@BeanReference(type = CompanyPersistence.class)
	protected CompanyPersistence companyPersistence;
	@BeanReference(type = ContactPersistence.class)
	protected ContactPersistence contactPersistence;
	@BeanReference(type = CountryPersistence.class)
	protected CountryPersistence countryPersistence;
	@BeanReference(type = EmailAddressPersistence.class)
	protected EmailAddressPersistence emailAddressPersistence;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = ImagePersistence.class)
	protected ImagePersistence imagePersistence;
	@BeanReference(type = LayoutPersistence.class)
	protected LayoutPersistence layoutPersistence;
	@BeanReference(type = LayoutPrototypePersistence.class)
	protected LayoutPrototypePersistence layoutPrototypePersistence;
	@BeanReference(type = LayoutSetPersistence.class)
	protected LayoutSetPersistence layoutSetPersistence;
	@BeanReference(type = LayoutSetPrototypePersistence.class)
	protected LayoutSetPrototypePersistence layoutSetPrototypePersistence;
	@BeanReference(type = ListTypePersistence.class)
	protected ListTypePersistence listTypePersistence;
	@BeanReference(type = LockPersistence.class)
	protected LockPersistence lockPersistence;
	@BeanReference(type = MembershipRequestPersistence.class)
	protected MembershipRequestPersistence membershipRequestPersistence;
	@BeanReference(type = OrganizationPersistence.class)
	protected OrganizationPersistence organizationPersistence;
	@BeanReference(type = OrgGroupPermissionPersistence.class)
	protected OrgGroupPermissionPersistence orgGroupPermissionPersistence;
	@BeanReference(type = OrgGroupRolePersistence.class)
	protected OrgGroupRolePersistence orgGroupRolePersistence;
	@BeanReference(type = OrgLaborPersistence.class)
	protected OrgLaborPersistence orgLaborPersistence;
	@BeanReference(type = PasswordPolicyPersistence.class)
	protected PasswordPolicyPersistence passwordPolicyPersistence;
	@BeanReference(type = PasswordPolicyRelPersistence.class)
	protected PasswordPolicyRelPersistence passwordPolicyRelPersistence;
	@BeanReference(type = PasswordTrackerPersistence.class)
	protected PasswordTrackerPersistence passwordTrackerPersistence;
	@BeanReference(type = PermissionPersistence.class)
	protected PermissionPersistence permissionPersistence;
	@BeanReference(type = PhonePersistence.class)
	protected PhonePersistence phonePersistence;
	@BeanReference(type = PluginSettingPersistence.class)
	protected PluginSettingPersistence pluginSettingPersistence;
	@BeanReference(type = PortletPersistence.class)
	protected PortletPersistence portletPersistence;
	@BeanReference(type = PortletItemPersistence.class)
	protected PortletItemPersistence portletItemPersistence;
	@BeanReference(type = PortletPreferencesPersistence.class)
	protected PortletPreferencesPersistence portletPreferencesPersistence;
	@BeanReference(type = RegionPersistence.class)
	protected RegionPersistence regionPersistence;
	@BeanReference(type = ReleasePersistence.class)
	protected ReleasePersistence releasePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceActionPersistence.class)
	protected ResourceActionPersistence resourceActionPersistence;
	@BeanReference(type = ResourceCodePersistence.class)
	protected ResourceCodePersistence resourceCodePersistence;
	@BeanReference(type = ResourcePermissionPersistence.class)
	protected ResourcePermissionPersistence resourcePermissionPersistence;
	@BeanReference(type = RolePersistence.class)
	protected RolePersistence rolePersistence;
	@BeanReference(type = ServiceComponentPersistence.class)
	protected ServiceComponentPersistence serviceComponentPersistence;
	@BeanReference(type = ShardPersistence.class)
	protected ShardPersistence shardPersistence;
	@BeanReference(type = SubscriptionPersistence.class)
	protected SubscriptionPersistence subscriptionPersistence;
	@BeanReference(type = TicketPersistence.class)
	protected TicketPersistence ticketPersistence;
	@BeanReference(type = TeamPersistence.class)
	protected TeamPersistence teamPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserGroupPersistence.class)
	protected UserGroupPersistence userGroupPersistence;
	@BeanReference(type = UserGroupGroupRolePersistence.class)
	protected UserGroupGroupRolePersistence userGroupGroupRolePersistence;
	@BeanReference(type = UserGroupRolePersistence.class)
	protected UserGroupRolePersistence userGroupRolePersistence;
	@BeanReference(type = UserIdMapperPersistence.class)
	protected UserIdMapperPersistence userIdMapperPersistence;
	@BeanReference(type = UserTrackerPersistence.class)
	protected UserTrackerPersistence userTrackerPersistence;
	@BeanReference(type = UserTrackerPathPersistence.class)
	protected UserTrackerPathPersistence userTrackerPathPersistence;
	@BeanReference(type = WebDAVPropsPersistence.class)
	protected WebDAVPropsPersistence webDAVPropsPersistence;
	@BeanReference(type = WebsitePersistence.class)
	protected WebsitePersistence websitePersistence;
	@BeanReference(type = WorkflowDefinitionLinkPersistence.class)
	protected WorkflowDefinitionLinkPersistence workflowDefinitionLinkPersistence;
	@BeanReference(type = WorkflowInstanceLinkPersistence.class)
	protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
	private static final String _SQL_SELECT_SERVICECOMPONENT = "SELECT serviceComponent FROM ServiceComponent serviceComponent";
	private static final String _SQL_SELECT_SERVICECOMPONENT_WHERE = "SELECT serviceComponent FROM ServiceComponent serviceComponent WHERE ";
	private static final String _SQL_COUNT_SERVICECOMPONENT = "SELECT COUNT(serviceComponent) FROM ServiceComponent serviceComponent";
	private static final String _SQL_COUNT_SERVICECOMPONENT_WHERE = "SELECT COUNT(serviceComponent) FROM ServiceComponent serviceComponent WHERE ";
	private static final String _FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_1 = "serviceComponent.buildNamespace IS NULL";
	private static final String _FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_2 = "serviceComponent.buildNamespace = ?";
	private static final String _FINDER_COLUMN_BUILDNAMESPACE_BUILDNAMESPACE_3 = "(serviceComponent.buildNamespace IS NULL OR serviceComponent.buildNamespace = ?)";
	private static final String _FINDER_COLUMN_BNS_BNU_BUILDNAMESPACE_1 = "serviceComponent.buildNamespace IS NULL AND ";
	private static final String _FINDER_COLUMN_BNS_BNU_BUILDNAMESPACE_2 = "serviceComponent.buildNamespace = ? AND ";
	private static final String _FINDER_COLUMN_BNS_BNU_BUILDNAMESPACE_3 = "(serviceComponent.buildNamespace IS NULL OR serviceComponent.buildNamespace = ?) AND ";
	private static final String _FINDER_COLUMN_BNS_BNU_BUILDNUMBER_2 = "serviceComponent.buildNumber = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceComponent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServiceComponent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServiceComponent exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ServiceComponentPersistenceImpl.class);
}