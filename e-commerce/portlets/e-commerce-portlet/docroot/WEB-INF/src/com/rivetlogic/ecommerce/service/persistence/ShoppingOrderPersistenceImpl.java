/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.rivetlogic.ecommerce.service.persistence;

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
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.ecommerce.NoSuchShoppingOrderException;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.model.impl.ShoppingOrderImpl;
import com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Shopping Order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author isaiulate
 * @see ShoppingOrderPersistence
 * @see ShoppingOrderUtil
 * @generated
 */
public class ShoppingOrderPersistenceImpl extends BasePersistenceImpl<ShoppingOrder>
	implements ShoppingOrderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ShoppingOrderUtil} to access the Shopping Order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingOrderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrderStatusAndUserId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrderStatusAndUserId",
			new String[] { String.class.getName(), Long.class.getName() },
			ShoppingOrderModelImpl.ORDERSTATUS_COLUMN_BITMASK |
			ShoppingOrderModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORDERSTATUSANDUSERID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrderStatusAndUserId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @return the matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findByOrderStatusAndUserId(String orderStatus,
		long userId) throws SystemException {
		return findByOrderStatusAndUserId(orderStatus, userId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findByOrderStatusAndUserId(String orderStatus,
		long userId, int start, int end) throws SystemException {
		return findByOrderStatusAndUserId(orderStatus, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findByOrderStatusAndUserId(String orderStatus,
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID;
			finderArgs = new Object[] { orderStatus, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID;
			finderArgs = new Object[] {
					orderStatus, userId,
					
					start, end, orderByComparator
				};
		}

		List<ShoppingOrder> list = (List<ShoppingOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ShoppingOrder shoppingOrder : list) {
				if (!Validator.equals(orderStatus,
							shoppingOrder.getOrderStatus()) ||
						(userId != shoppingOrder.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

			boolean bindOrderStatus = false;

			if (orderStatus == null) {
				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_1);
			}
			else if (orderStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_3);
			}
			else {
				bindOrderStatus = true;

				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_2);
			}

			query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOrderStatus) {
					qPos.add(orderStatus);
				}

				qPos.add(userId);

				if (!pagination) {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ShoppingOrder>(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder findByOrderStatusAndUserId_First(String orderStatus,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderException, SystemException {
		ShoppingOrder shoppingOrder = fetchByOrderStatusAndUserId_First(orderStatus,
				userId, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderStatus=");
		msg.append(orderStatus);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder fetchByOrderStatusAndUserId_First(String orderStatus,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ShoppingOrder> list = findByOrderStatusAndUserId(orderStatus,
				userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder findByOrderStatusAndUserId_Last(String orderStatus,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderException, SystemException {
		ShoppingOrder shoppingOrder = fetchByOrderStatusAndUserId_Last(orderStatus,
				userId, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderStatus=");
		msg.append(orderStatus);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder fetchByOrderStatusAndUserId_Last(String orderStatus,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrderStatusAndUserId(orderStatus, userId);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrder> list = findByOrderStatusAndUserId(orderStatus,
				userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Orders before and after the current Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderId the primary key of the current Shopping Order
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder[] findByOrderStatusAndUserId_PrevAndNext(
		long orderId, String orderStatus, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderException, SystemException {
		ShoppingOrder shoppingOrder = findByPrimaryKey(orderId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrder[] array = new ShoppingOrderImpl[3];

			array[0] = getByOrderStatusAndUserId_PrevAndNext(session,
					shoppingOrder, orderStatus, userId, orderByComparator, true);

			array[1] = shoppingOrder;

			array[2] = getByOrderStatusAndUserId_PrevAndNext(session,
					shoppingOrder, orderStatus, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingOrder getByOrderStatusAndUserId_PrevAndNext(
		Session session, ShoppingOrder shoppingOrder, String orderStatus,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

		boolean bindOrderStatus = false;

		if (orderStatus == null) {
			query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_1);
		}
		else if (orderStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_3);
		}
		else {
			bindOrderStatus = true;

			query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_2);
		}

		query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
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

			String[] orderByFields = orderByComparator.getOrderByFields();

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
			query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOrderStatus) {
			qPos.add(orderStatus);
		}

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Orders where orderStatus = &#63; and userId = &#63; from the database.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrderStatusAndUserId(String orderStatus, long userId)
		throws SystemException {
		for (ShoppingOrder shoppingOrder : findByOrderStatusAndUserId(
				orderStatus, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders where orderStatus = &#63; and userId = &#63;.
	 *
	 * @param orderStatus the order status
	 * @param userId the user ID
	 * @return the number of matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrderStatusAndUserId(String orderStatus, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORDERSTATUSANDUSERID;

		Object[] finderArgs = new Object[] { orderStatus, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

			boolean bindOrderStatus = false;

			if (orderStatus == null) {
				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_1);
			}
			else if (orderStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_3);
			}
			else {
				bindOrderStatus = true;

				query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_2);
			}

			query.append(_FINDER_COLUMN_ORDERSTATUSANDUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOrderStatus) {
					qPos.add(orderStatus);
				}

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_1 =
		"shoppingOrder.orderStatus IS NULL AND ";
	private static final String _FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_2 =
		"shoppingOrder.orderStatus = ? AND ";
	private static final String _FINDER_COLUMN_ORDERSTATUSANDUSERID_ORDERSTATUS_3 =
		"(shoppingOrder.orderStatus IS NULL OR shoppingOrder.orderStatus = '') AND ";
	private static final String _FINDER_COLUMN_ORDERSTATUSANDUSERID_USERID_2 = "shoppingOrder.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			ShoppingOrderModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the Shopping Orders where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ShoppingOrder> list = (List<ShoppingOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ShoppingOrder shoppingOrder : list) {
				if ((groupId != shoppingOrder.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ShoppingOrder>(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first Shopping Order in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderException, SystemException {
		ShoppingOrder shoppingOrder = fetchByGroupId_First(groupId,
				orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ShoppingOrder> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderException, SystemException {
		ShoppingOrder shoppingOrder = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrder> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Orders before and after the current Shopping Order in the ordered set where groupId = &#63;.
	 *
	 * @param orderId the primary key of the current Shopping Order
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder[] findByGroupId_PrevAndNext(long orderId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderException, SystemException {
		ShoppingOrder shoppingOrder = findByPrimaryKey(orderId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrder[] array = new ShoppingOrderImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, shoppingOrder,
					groupId, orderByComparator, true);

			array[1] = shoppingOrder;

			array[2] = getByGroupId_PrevAndNext(session, shoppingOrder,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingOrder getByGroupId_PrevAndNext(Session session,
		ShoppingOrder shoppingOrder, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
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

			String[] orderByFields = orderByComparator.getOrderByFields();

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
			query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Orders where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ShoppingOrder shoppingOrder : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "shoppingOrder.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdAndOrderStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS =
		new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndOrderStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			ShoppingOrderModelImpl.GROUPID_COLUMN_BITMASK |
			ShoppingOrderModelImpl.ORDERSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDORDERSTATUS = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndOrderStatus",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @return the matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId,
		String orderStatus) throws SystemException {
		return findByGroupIdAndOrderStatus(groupId, orderStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId,
		String orderStatus, int start, int end) throws SystemException {
		return findByGroupIdAndOrderStatus(groupId, orderStatus, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId,
		String orderStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS;
			finderArgs = new Object[] { groupId, orderStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS;
			finderArgs = new Object[] {
					groupId, orderStatus,
					
					start, end, orderByComparator
				};
		}

		List<ShoppingOrder> list = (List<ShoppingOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ShoppingOrder shoppingOrder : list) {
				if ((groupId != shoppingOrder.getGroupId()) ||
						!Validator.equals(orderStatus,
							shoppingOrder.getOrderStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_GROUPID_2);

			boolean bindOrderStatus = false;

			if (orderStatus == null) {
				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_1);
			}
			else if (orderStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_3);
			}
			else {
				bindOrderStatus = true;

				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindOrderStatus) {
					qPos.add(orderStatus);
				}

				if (!pagination) {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ShoppingOrder>(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder findByGroupIdAndOrderStatus_First(long groupId,
		String orderStatus, OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderException, SystemException {
		ShoppingOrder shoppingOrder = fetchByGroupIdAndOrderStatus_First(groupId,
				orderStatus, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", orderStatus=");
		msg.append(orderStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder fetchByGroupIdAndOrderStatus_First(long groupId,
		String orderStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<ShoppingOrder> list = findByGroupIdAndOrderStatus(groupId,
				orderStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder findByGroupIdAndOrderStatus_Last(long groupId,
		String orderStatus, OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderException, SystemException {
		ShoppingOrder shoppingOrder = fetchByGroupIdAndOrderStatus_Last(groupId,
				orderStatus, orderByComparator);

		if (shoppingOrder != null) {
			return shoppingOrder;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", orderStatus=");
		msg.append(orderStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder fetchByGroupIdAndOrderStatus_Last(long groupId,
		String orderStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdAndOrderStatus(groupId, orderStatus);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrder> list = findByGroupIdAndOrderStatus(groupId,
				orderStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Orders before and after the current Shopping Order in the ordered set where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param orderId the primary key of the current Shopping Order
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder[] findByGroupIdAndOrderStatus_PrevAndNext(
		long orderId, long groupId, String orderStatus,
		OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderException, SystemException {
		ShoppingOrder shoppingOrder = findByPrimaryKey(orderId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrder[] array = new ShoppingOrderImpl[3];

			array[0] = getByGroupIdAndOrderStatus_PrevAndNext(session,
					shoppingOrder, groupId, orderStatus, orderByComparator, true);

			array[1] = shoppingOrder;

			array[2] = getByGroupIdAndOrderStatus_PrevAndNext(session,
					shoppingOrder, groupId, orderStatus, orderByComparator,
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

	protected ShoppingOrder getByGroupIdAndOrderStatus_PrevAndNext(
		Session session, ShoppingOrder shoppingOrder, long groupId,
		String orderStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_GROUPID_2);

		boolean bindOrderStatus = false;

		if (orderStatus == null) {
			query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_1);
		}
		else if (orderStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_3);
		}
		else {
			bindOrderStatus = true;

			query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
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

			String[] orderByFields = orderByComparator.getOrderByFields();

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
			query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindOrderStatus) {
			qPos.add(orderStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Orders where groupId = &#63; and orderStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdAndOrderStatus(long groupId, String orderStatus)
		throws SystemException {
		for (ShoppingOrder shoppingOrder : findByGroupIdAndOrderStatus(
				groupId, orderStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders where groupId = &#63; and orderStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderStatus the order status
	 * @return the number of matching Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdAndOrderStatus(long groupId, String orderStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDORDERSTATUS;

		Object[] finderArgs = new Object[] { groupId, orderStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_GROUPID_2);

			boolean bindOrderStatus = false;

			if (orderStatus == null) {
				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_1);
			}
			else if (orderStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_3);
			}
			else {
				bindOrderStatus = true;

				query.append(_FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindOrderStatus) {
					qPos.add(orderStatus);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPIDANDORDERSTATUS_GROUPID_2 = "shoppingOrder.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_1 =
		"shoppingOrder.orderStatus IS NULL";
	private static final String _FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_2 =
		"shoppingOrder.orderStatus = ?";
	private static final String _FINDER_COLUMN_GROUPIDANDORDERSTATUS_ORDERSTATUS_3 =
		"(shoppingOrder.orderStatus IS NULL OR shoppingOrder.orderStatus = '')";

	public ShoppingOrderPersistenceImpl() {
		setModelClass(ShoppingOrder.class);
	}

	/**
	 * Caches the Shopping Order in the entity cache if it is enabled.
	 *
	 * @param shoppingOrder the Shopping Order
	 */
	@Override
	public void cacheResult(ShoppingOrder shoppingOrder) {
		EntityCacheUtil.putResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey(),
			shoppingOrder);

		shoppingOrder.resetOriginalValues();
	}

	/**
	 * Caches the Shopping Orders in the entity cache if it is enabled.
	 *
	 * @param shoppingOrders the Shopping Orders
	 */
	@Override
	public void cacheResult(List<ShoppingOrder> shoppingOrders) {
		for (ShoppingOrder shoppingOrder : shoppingOrders) {
			if (EntityCacheUtil.getResult(
						ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey()) == null) {
				cacheResult(shoppingOrder);
			}
			else {
				shoppingOrder.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Shopping Orders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ShoppingOrderImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ShoppingOrderImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Shopping Order.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ShoppingOrder shoppingOrder) {
		EntityCacheUtil.removeResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ShoppingOrder> shoppingOrders) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ShoppingOrder shoppingOrder : shoppingOrders) {
			EntityCacheUtil.removeResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Shopping Order with the primary key. Does not add the Shopping Order to the database.
	 *
	 * @param orderId the primary key for the new Shopping Order
	 * @return the new Shopping Order
	 */
	@Override
	public ShoppingOrder create(long orderId) {
		ShoppingOrder shoppingOrder = new ShoppingOrderImpl();

		shoppingOrder.setNew(true);
		shoppingOrder.setPrimaryKey(orderId);

		return shoppingOrder;
	}

	/**
	 * Removes the Shopping Order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orderId the primary key of the Shopping Order
	 * @return the Shopping Order that was removed
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder remove(long orderId)
		throws NoSuchShoppingOrderException, SystemException {
		return remove((Serializable)orderId);
	}

	/**
	 * Removes the Shopping Order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Shopping Order
	 * @return the Shopping Order that was removed
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder remove(Serializable primaryKey)
		throws NoSuchShoppingOrderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ShoppingOrder shoppingOrder = (ShoppingOrder)session.get(ShoppingOrderImpl.class,
					primaryKey);

			if (shoppingOrder == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShoppingOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(shoppingOrder);
		}
		catch (NoSuchShoppingOrderException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ShoppingOrder removeImpl(ShoppingOrder shoppingOrder)
		throws SystemException {
		shoppingOrder = toUnwrappedModel(shoppingOrder);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(shoppingOrder)) {
				shoppingOrder = (ShoppingOrder)session.get(ShoppingOrderImpl.class,
						shoppingOrder.getPrimaryKeyObj());
			}

			if (shoppingOrder != null) {
				session.delete(shoppingOrder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (shoppingOrder != null) {
			clearCache(shoppingOrder);
		}

		return shoppingOrder;
	}

	@Override
	public ShoppingOrder updateImpl(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder)
		throws SystemException {
		shoppingOrder = toUnwrappedModel(shoppingOrder);

		boolean isNew = shoppingOrder.isNew();

		ShoppingOrderModelImpl shoppingOrderModelImpl = (ShoppingOrderModelImpl)shoppingOrder;

		Session session = null;

		try {
			session = openSession();

			if (shoppingOrder.isNew()) {
				session.save(shoppingOrder);

				shoppingOrder.setNew(false);
			}
			else {
				session.merge(shoppingOrder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ShoppingOrderModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((shoppingOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderModelImpl.getOriginalOrderStatus(),
						shoppingOrderModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORDERSTATUSANDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID,
					args);

				args = new Object[] {
						shoppingOrderModelImpl.getOrderStatus(),
						shoppingOrderModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORDERSTATUSANDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERSTATUSANDUSERID,
					args);
			}

			if ((shoppingOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { shoppingOrderModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((shoppingOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderModelImpl.getOriginalGroupId(),
						shoppingOrderModelImpl.getOriginalOrderStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDORDERSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS,
					args);

				args = new Object[] {
						shoppingOrderModelImpl.getGroupId(),
						shoppingOrderModelImpl.getOrderStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDORDERSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDORDERSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey(),
			shoppingOrder);

		return shoppingOrder;
	}

	protected ShoppingOrder toUnwrappedModel(ShoppingOrder shoppingOrder) {
		if (shoppingOrder instanceof ShoppingOrderImpl) {
			return shoppingOrder;
		}

		ShoppingOrderImpl shoppingOrderImpl = new ShoppingOrderImpl();

		shoppingOrderImpl.setNew(shoppingOrder.isNew());
		shoppingOrderImpl.setPrimaryKey(shoppingOrder.getPrimaryKey());

		shoppingOrderImpl.setOrderId(shoppingOrder.getOrderId());
		shoppingOrderImpl.setGroupId(shoppingOrder.getGroupId());
		shoppingOrderImpl.setCompanyId(shoppingOrder.getCompanyId());
		shoppingOrderImpl.setUserId(shoppingOrder.getUserId());
		shoppingOrderImpl.setUserName(shoppingOrder.getUserName());
		shoppingOrderImpl.setCreateDate(shoppingOrder.getCreateDate());
		shoppingOrderImpl.setModifiedDate(shoppingOrder.getModifiedDate());
		shoppingOrderImpl.setOrderStatus(shoppingOrder.getOrderStatus());
		shoppingOrderImpl.setCustomerEmail(shoppingOrder.getCustomerEmail());
		shoppingOrderImpl.setCustomerName(shoppingOrder.getCustomerName());
		shoppingOrderImpl.setCustomerPhone(shoppingOrder.getCustomerPhone());
		shoppingOrderImpl.setShippingAddress1(shoppingOrder.getShippingAddress1());
		shoppingOrderImpl.setShippingAddress2(shoppingOrder.getShippingAddress2());
		shoppingOrderImpl.setShippingCity(shoppingOrder.getShippingCity());
		shoppingOrderImpl.setShippingPostalCode(shoppingOrder.getShippingPostalCode());
		shoppingOrderImpl.setShippingStateProvince(shoppingOrder.getShippingStateProvince());
		shoppingOrderImpl.setShippingCountry(shoppingOrder.getShippingCountry());
		shoppingOrderImpl.setTotal(shoppingOrder.getTotal());
		shoppingOrderImpl.setNotes(shoppingOrder.getNotes());

		return shoppingOrderImpl;
	}

	/**
	 * Returns the Shopping Order with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Shopping Order
	 * @return the Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShoppingOrderException, SystemException {
		ShoppingOrder shoppingOrder = fetchByPrimaryKey(primaryKey);

		if (shoppingOrder == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShoppingOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return shoppingOrder;
	}

	/**
	 * Returns the Shopping Order with the primary key or throws a {@link com.rivetlogic.ecommerce.NoSuchShoppingOrderException} if it could not be found.
	 *
	 * @param orderId the primary key of the Shopping Order
	 * @return the Shopping Order
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder findByPrimaryKey(long orderId)
		throws NoSuchShoppingOrderException, SystemException {
		return findByPrimaryKey((Serializable)orderId);
	}

	/**
	 * Returns the Shopping Order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Shopping Order
	 * @return the Shopping Order, or <code>null</code> if a Shopping Order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ShoppingOrder shoppingOrder = (ShoppingOrder)EntityCacheUtil.getResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingOrderImpl.class, primaryKey);

		if (shoppingOrder == _nullShoppingOrder) {
			return null;
		}

		if (shoppingOrder == null) {
			Session session = null;

			try {
				session = openSession();

				shoppingOrder = (ShoppingOrder)session.get(ShoppingOrderImpl.class,
						primaryKey);

				if (shoppingOrder != null) {
					cacheResult(shoppingOrder);
				}
				else {
					EntityCacheUtil.putResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingOrderImpl.class, primaryKey, _nullShoppingOrder);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
					ShoppingOrderImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return shoppingOrder;
	}

	/**
	 * Returns the Shopping Order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orderId the primary key of the Shopping Order
	 * @return the Shopping Order, or <code>null</code> if a Shopping Order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrder fetchByPrimaryKey(long orderId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)orderId);
	}

	/**
	 * Returns all the Shopping Orders.
	 *
	 * @return the Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @return the range of Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Orders
	 * @param end the upper bound of the range of Shopping Orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrder> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ShoppingOrder> list = (List<ShoppingOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHOPPINGORDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGORDER;

				if (pagination) {
					sql = sql.concat(ShoppingOrderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ShoppingOrder>(list);
				}
				else {
					list = (List<ShoppingOrder>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the Shopping Orders from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ShoppingOrder shoppingOrder : findAll()) {
			remove(shoppingOrder);
		}
	}

	/**
	 * Returns the number of Shopping Orders.
	 *
	 * @return the number of Shopping Orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGORDER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the Shopping Order persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.ecommerce.model.ShoppingOrder")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ShoppingOrder>> listenersList = new ArrayList<ModelListener<ShoppingOrder>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ShoppingOrder>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ShoppingOrderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SHOPPINGORDER = "SELECT shoppingOrder FROM ShoppingOrder shoppingOrder";
	private static final String _SQL_SELECT_SHOPPINGORDER_WHERE = "SELECT shoppingOrder FROM ShoppingOrder shoppingOrder WHERE ";
	private static final String _SQL_COUNT_SHOPPINGORDER = "SELECT COUNT(shoppingOrder) FROM ShoppingOrder shoppingOrder";
	private static final String _SQL_COUNT_SHOPPINGORDER_WHERE = "SELECT COUNT(shoppingOrder) FROM ShoppingOrder shoppingOrder WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingOrder.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingOrder exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingOrder exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ShoppingOrderPersistenceImpl.class);
	private static ShoppingOrder _nullShoppingOrder = new ShoppingOrderImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ShoppingOrder> toCacheModel() {
				return _nullShoppingOrderCacheModel;
			}
		};

	private static CacheModel<ShoppingOrder> _nullShoppingOrderCacheModel = new CacheModel<ShoppingOrder>() {
			@Override
			public ShoppingOrder toEntityModel() {
				return _nullShoppingOrder;
			}
		};
}