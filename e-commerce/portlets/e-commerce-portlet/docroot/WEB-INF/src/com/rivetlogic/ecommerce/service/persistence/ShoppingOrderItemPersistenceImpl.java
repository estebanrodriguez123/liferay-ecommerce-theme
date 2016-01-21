/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
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

import com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException;
import com.rivetlogic.ecommerce.model.ShoppingOrderItem;
import com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemImpl;
import com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Shopping Order Item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author isaiulate
 * @see ShoppingOrderItemPersistence
 * @see ShoppingOrderItemUtil
 * @generated
 */
public class ShoppingOrderItemPersistenceImpl extends BasePersistenceImpl<ShoppingOrderItem>
	implements ShoppingOrderItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ShoppingOrderItemUtil} to access the Shopping Order Item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingOrderItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrderId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID =
		new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrderId",
			new String[] { Long.class.getName() },
			ShoppingOrderItemModelImpl.ORDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORDERID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrderId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the Shopping Order Items where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the matching Shopping Order Items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrderItem> findByOrderId(long orderId)
		throws SystemException {
		return findByOrderId(orderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Order Items where orderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orderId the order ID
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @return the range of matching Shopping Order Items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrderItem> findByOrderId(long orderId, int start,
		int end) throws SystemException {
		return findByOrderId(orderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Order Items where orderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orderId the order ID
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Shopping Order Items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrderItem> findByOrderId(long orderId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID;
			finderArgs = new Object[] { orderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERID;
			finderArgs = new Object[] { orderId, start, end, orderByComparator };
		}

		List<ShoppingOrderItem> list = (List<ShoppingOrderItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ShoppingOrderItem shoppingOrderItem : list) {
				if ((orderId != shoppingOrderItem.getOrderId())) {
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

			query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

			query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				if (!pagination) {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ShoppingOrderItem>(list);
				}
				else {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order Item
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem findByOrderId_First(long orderId,
		OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderItemException, SystemException {
		ShoppingOrderItem shoppingOrderItem = fetchByOrderId_First(orderId,
				orderByComparator);

		if (shoppingOrderItem != null) {
			return shoppingOrderItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderId=");
		msg.append(orderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderItemException(msg.toString());
	}

	/**
	 * Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem fetchByOrderId_First(long orderId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ShoppingOrderItem> list = findByOrderId(orderId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order Item
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem findByOrderId_Last(long orderId,
		OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderItemException, SystemException {
		ShoppingOrderItem shoppingOrderItem = fetchByOrderId_Last(orderId,
				orderByComparator);

		if (shoppingOrderItem != null) {
			return shoppingOrderItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderId=");
		msg.append(orderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShoppingOrderItemException(msg.toString());
	}

	/**
	 * Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem fetchByOrderId_Last(long orderId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrderId(orderId);

		if (count == 0) {
			return null;
		}

		List<ShoppingOrderItem> list = findByOrderId(orderId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Shopping Order Items before and after the current Shopping Order Item in the ordered set where orderId = &#63;.
	 *
	 * @param itemId the primary key of the current Shopping Order Item
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Shopping Order Item
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem[] findByOrderId_PrevAndNext(long itemId,
		long orderId, OrderByComparator orderByComparator)
		throws NoSuchShoppingOrderItemException, SystemException {
		ShoppingOrderItem shoppingOrderItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			ShoppingOrderItem[] array = new ShoppingOrderItemImpl[3];

			array[0] = getByOrderId_PrevAndNext(session, shoppingOrderItem,
					orderId, orderByComparator, true);

			array[1] = shoppingOrderItem;

			array[2] = getByOrderId_PrevAndNext(session, shoppingOrderItem,
					orderId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingOrderItem getByOrderId_PrevAndNext(Session session,
		ShoppingOrderItem shoppingOrderItem, long orderId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

		query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

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
			query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(orderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrderItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingOrderItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Shopping Order Items where orderId = &#63; from the database.
	 *
	 * @param orderId the order ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrderId(long orderId) throws SystemException {
		for (ShoppingOrderItem shoppingOrderItem : findByOrderId(orderId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shoppingOrderItem);
		}
	}

	/**
	 * Returns the number of Shopping Order Items where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the number of matching Shopping Order Items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrderId(long orderId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORDERID;

		Object[] finderArgs = new Object[] { orderId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGORDERITEM_WHERE);

			query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

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

	private static final String _FINDER_COLUMN_ORDERID_ORDERID_2 = "shoppingOrderItem.orderId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
			ShoppingOrderItemImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByOrderAndProductId",
			new String[] { Long.class.getName(), String.class.getName() },
			ShoppingOrderItemModelImpl.ORDERID_COLUMN_BITMASK |
			ShoppingOrderItemModelImpl.PRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrderAndProductId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or throws a {@link com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException} if it could not be found.
	 *
	 * @param orderId the order ID
	 * @param productId the product ID
	 * @return the matching Shopping Order Item
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem findByOrderAndProductId(long orderId,
		String productId)
		throws NoSuchShoppingOrderItemException, SystemException {
		ShoppingOrderItem shoppingOrderItem = fetchByOrderAndProductId(orderId,
				productId);

		if (shoppingOrderItem == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("orderId=");
			msg.append(orderId);

			msg.append(", productId=");
			msg.append(productId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchShoppingOrderItemException(msg.toString());
		}

		return shoppingOrderItem;
	}

	/**
	 * Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param orderId the order ID
	 * @param productId the product ID
	 * @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem fetchByOrderAndProductId(long orderId,
		String productId) throws SystemException {
		return fetchByOrderAndProductId(orderId, productId, true);
	}

	/**
	 * Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param orderId the order ID
	 * @param productId the product ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem fetchByOrderAndProductId(long orderId,
		String productId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { orderId, productId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
					finderArgs, this);
		}

		if (result instanceof ShoppingOrderItem) {
			ShoppingOrderItem shoppingOrderItem = (ShoppingOrderItem)result;

			if ((orderId != shoppingOrderItem.getOrderId()) ||
					!Validator.equals(productId,
						shoppingOrderItem.getProductId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

			query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_ORDERID_2);

			boolean bindProductId = false;

			if (productId == null) {
				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_1);
			}
			else if (productId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_3);
			}
			else {
				bindProductId = true;

				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				if (bindProductId) {
					qPos.add(productId);
				}

				List<ShoppingOrderItem> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ShoppingOrderItemPersistenceImpl.fetchByOrderAndProductId(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ShoppingOrderItem shoppingOrderItem = list.get(0);

					result = shoppingOrderItem;

					cacheResult(shoppingOrderItem);

					if ((shoppingOrderItem.getOrderId() != orderId) ||
							(shoppingOrderItem.getProductId() == null) ||
							!shoppingOrderItem.getProductId().equals(productId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
							finderArgs, shoppingOrderItem);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ShoppingOrderItem)result;
		}
	}

	/**
	 * Removes the Shopping Order Item where orderId = &#63; and productId = &#63; from the database.
	 *
	 * @param orderId the order ID
	 * @param productId the product ID
	 * @return the Shopping Order Item that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem removeByOrderAndProductId(long orderId,
		String productId)
		throws NoSuchShoppingOrderItemException, SystemException {
		ShoppingOrderItem shoppingOrderItem = findByOrderAndProductId(orderId,
				productId);

		return remove(shoppingOrderItem);
	}

	/**
	 * Returns the number of Shopping Order Items where orderId = &#63; and productId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param productId the product ID
	 * @return the number of matching Shopping Order Items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrderAndProductId(long orderId, String productId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID;

		Object[] finderArgs = new Object[] { orderId, productId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHOPPINGORDERITEM_WHERE);

			query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_ORDERID_2);

			boolean bindProductId = false;

			if (productId == null) {
				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_1);
			}
			else if (productId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_3);
			}
			else {
				bindProductId = true;

				query.append(_FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				if (bindProductId) {
					qPos.add(productId);
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

	private static final String _FINDER_COLUMN_ORDERANDPRODUCTID_ORDERID_2 = "shoppingOrderItem.orderId = ? AND ";
	private static final String _FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_1 = "shoppingOrderItem.productId IS NULL";
	private static final String _FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_2 = "shoppingOrderItem.productId = ?";
	private static final String _FINDER_COLUMN_ORDERANDPRODUCTID_PRODUCTID_3 = "(shoppingOrderItem.productId IS NULL OR shoppingOrderItem.productId = '')";

	public ShoppingOrderItemPersistenceImpl() {
		setModelClass(ShoppingOrderItem.class);
	}

	/**
	 * Caches the Shopping Order Item in the entity cache if it is enabled.
	 *
	 * @param shoppingOrderItem the Shopping Order Item
	 */
	@Override
	public void cacheResult(ShoppingOrderItem shoppingOrderItem) {
		EntityCacheUtil.putResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey(),
			shoppingOrderItem);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
			new Object[] {
				shoppingOrderItem.getOrderId(), shoppingOrderItem.getProductId()
			}, shoppingOrderItem);

		shoppingOrderItem.resetOriginalValues();
	}

	/**
	 * Caches the Shopping Order Items in the entity cache if it is enabled.
	 *
	 * @param shoppingOrderItems the Shopping Order Items
	 */
	@Override
	public void cacheResult(List<ShoppingOrderItem> shoppingOrderItems) {
		for (ShoppingOrderItem shoppingOrderItem : shoppingOrderItems) {
			if (EntityCacheUtil.getResult(
						ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingOrderItemImpl.class,
						shoppingOrderItem.getPrimaryKey()) == null) {
				cacheResult(shoppingOrderItem);
			}
			else {
				shoppingOrderItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Shopping Order Items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ShoppingOrderItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ShoppingOrderItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Shopping Order Item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ShoppingOrderItem shoppingOrderItem) {
		EntityCacheUtil.removeResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(shoppingOrderItem);
	}

	@Override
	public void clearCache(List<ShoppingOrderItem> shoppingOrderItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ShoppingOrderItem shoppingOrderItem : shoppingOrderItems) {
			EntityCacheUtil.removeResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey());

			clearUniqueFindersCache(shoppingOrderItem);
		}
	}

	protected void cacheUniqueFindersCache(ShoppingOrderItem shoppingOrderItem) {
		if (shoppingOrderItem.isNew()) {
			Object[] args = new Object[] {
					shoppingOrderItem.getOrderId(),
					shoppingOrderItem.getProductId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
				args, shoppingOrderItem);
		}
		else {
			ShoppingOrderItemModelImpl shoppingOrderItemModelImpl = (ShoppingOrderItemModelImpl)shoppingOrderItem;

			if ((shoppingOrderItemModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderItem.getOrderId(),
						shoppingOrderItem.getProductId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
					args, shoppingOrderItem);
			}
		}
	}

	protected void clearUniqueFindersCache(ShoppingOrderItem shoppingOrderItem) {
		ShoppingOrderItemModelImpl shoppingOrderItemModelImpl = (ShoppingOrderItemModelImpl)shoppingOrderItem;

		Object[] args = new Object[] {
				shoppingOrderItem.getOrderId(), shoppingOrderItem.getProductId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
			args);

		if ((shoppingOrderItemModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					shoppingOrderItemModelImpl.getOriginalOrderId(),
					shoppingOrderItemModelImpl.getOriginalProductId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORDERANDPRODUCTID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORDERANDPRODUCTID,
				args);
		}
	}

	/**
	 * Creates a new Shopping Order Item with the primary key. Does not add the Shopping Order Item to the database.
	 *
	 * @param itemId the primary key for the new Shopping Order Item
	 * @return the new Shopping Order Item
	 */
	@Override
	public ShoppingOrderItem create(long itemId) {
		ShoppingOrderItem shoppingOrderItem = new ShoppingOrderItemImpl();

		shoppingOrderItem.setNew(true);
		shoppingOrderItem.setPrimaryKey(itemId);

		return shoppingOrderItem;
	}

	/**
	 * Removes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemId the primary key of the Shopping Order Item
	 * @return the Shopping Order Item that was removed
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem remove(long itemId)
		throws NoSuchShoppingOrderItemException, SystemException {
		return remove((Serializable)itemId);
	}

	/**
	 * Removes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Shopping Order Item
	 * @return the Shopping Order Item that was removed
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem remove(Serializable primaryKey)
		throws NoSuchShoppingOrderItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ShoppingOrderItem shoppingOrderItem = (ShoppingOrderItem)session.get(ShoppingOrderItemImpl.class,
					primaryKey);

			if (shoppingOrderItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShoppingOrderItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(shoppingOrderItem);
		}
		catch (NoSuchShoppingOrderItemException nsee) {
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
	protected ShoppingOrderItem removeImpl(ShoppingOrderItem shoppingOrderItem)
		throws SystemException {
		shoppingOrderItem = toUnwrappedModel(shoppingOrderItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(shoppingOrderItem)) {
				shoppingOrderItem = (ShoppingOrderItem)session.get(ShoppingOrderItemImpl.class,
						shoppingOrderItem.getPrimaryKeyObj());
			}

			if (shoppingOrderItem != null) {
				session.delete(shoppingOrderItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (shoppingOrderItem != null) {
			clearCache(shoppingOrderItem);
		}

		return shoppingOrderItem;
	}

	@Override
	public ShoppingOrderItem updateImpl(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem)
		throws SystemException {
		shoppingOrderItem = toUnwrappedModel(shoppingOrderItem);

		boolean isNew = shoppingOrderItem.isNew();

		ShoppingOrderItemModelImpl shoppingOrderItemModelImpl = (ShoppingOrderItemModelImpl)shoppingOrderItem;

		Session session = null;

		try {
			session = openSession();

			if (shoppingOrderItem.isNew()) {
				session.save(shoppingOrderItem);

				shoppingOrderItem.setNew(false);
			}
			else {
				session.merge(shoppingOrderItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ShoppingOrderItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((shoppingOrderItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shoppingOrderItemModelImpl.getOriginalOrderId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORDERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID,
					args);

				args = new Object[] { shoppingOrderItemModelImpl.getOrderId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORDERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey(),
			shoppingOrderItem);

		clearUniqueFindersCache(shoppingOrderItem);
		cacheUniqueFindersCache(shoppingOrderItem);

		return shoppingOrderItem;
	}

	protected ShoppingOrderItem toUnwrappedModel(
		ShoppingOrderItem shoppingOrderItem) {
		if (shoppingOrderItem instanceof ShoppingOrderItemImpl) {
			return shoppingOrderItem;
		}

		ShoppingOrderItemImpl shoppingOrderItemImpl = new ShoppingOrderItemImpl();

		shoppingOrderItemImpl.setNew(shoppingOrderItem.isNew());
		shoppingOrderItemImpl.setPrimaryKey(shoppingOrderItem.getPrimaryKey());

		shoppingOrderItemImpl.setItemId(shoppingOrderItem.getItemId());
		shoppingOrderItemImpl.setCreateDate(shoppingOrderItem.getCreateDate());
		shoppingOrderItemImpl.setModifiedDate(shoppingOrderItem.getModifiedDate());
		shoppingOrderItemImpl.setProductId(shoppingOrderItem.getProductId());
		shoppingOrderItemImpl.setOrderId(shoppingOrderItem.getOrderId());
		shoppingOrderItemImpl.setQuantity(shoppingOrderItem.getQuantity());

		return shoppingOrderItemImpl;
	}

	/**
	 * Returns the Shopping Order Item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Shopping Order Item
	 * @return the Shopping Order Item
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShoppingOrderItemException, SystemException {
		ShoppingOrderItem shoppingOrderItem = fetchByPrimaryKey(primaryKey);

		if (shoppingOrderItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShoppingOrderItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return shoppingOrderItem;
	}

	/**
	 * Returns the Shopping Order Item with the primary key or throws a {@link com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException} if it could not be found.
	 *
	 * @param itemId the primary key of the Shopping Order Item
	 * @return the Shopping Order Item
	 * @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem findByPrimaryKey(long itemId)
		throws NoSuchShoppingOrderItemException, SystemException {
		return findByPrimaryKey((Serializable)itemId);
	}

	/**
	 * Returns the Shopping Order Item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Shopping Order Item
	 * @return the Shopping Order Item, or <code>null</code> if a Shopping Order Item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ShoppingOrderItem shoppingOrderItem = (ShoppingOrderItem)EntityCacheUtil.getResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingOrderItemImpl.class, primaryKey);

		if (shoppingOrderItem == _nullShoppingOrderItem) {
			return null;
		}

		if (shoppingOrderItem == null) {
			Session session = null;

			try {
				session = openSession();

				shoppingOrderItem = (ShoppingOrderItem)session.get(ShoppingOrderItemImpl.class,
						primaryKey);

				if (shoppingOrderItem != null) {
					cacheResult(shoppingOrderItem);
				}
				else {
					EntityCacheUtil.putResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingOrderItemImpl.class, primaryKey,
						_nullShoppingOrderItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
					ShoppingOrderItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return shoppingOrderItem;
	}

	/**
	 * Returns the Shopping Order Item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemId the primary key of the Shopping Order Item
	 * @return the Shopping Order Item, or <code>null</code> if a Shopping Order Item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShoppingOrderItem fetchByPrimaryKey(long itemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)itemId);
	}

	/**
	 * Returns all the Shopping Order Items.
	 *
	 * @return the Shopping Order Items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrderItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Shopping Order Items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @return the range of Shopping Order Items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrderItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Shopping Order Items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Shopping Order Items
	 * @param end the upper bound of the range of Shopping Order Items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Shopping Order Items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShoppingOrderItem> findAll(int start, int end,
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

		List<ShoppingOrderItem> list = (List<ShoppingOrderItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHOPPINGORDERITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGORDERITEM;

				if (pagination) {
					sql = sql.concat(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ShoppingOrderItem>(list);
				}
				else {
					list = (List<ShoppingOrderItem>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the Shopping Order Items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ShoppingOrderItem shoppingOrderItem : findAll()) {
			remove(shoppingOrderItem);
		}
	}

	/**
	 * Returns the number of Shopping Order Items.
	 *
	 * @return the number of Shopping Order Items
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

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGORDERITEM);

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
	 * Initializes the Shopping Order Item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.ecommerce.model.ShoppingOrderItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ShoppingOrderItem>> listenersList = new ArrayList<ModelListener<ShoppingOrderItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ShoppingOrderItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ShoppingOrderItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SHOPPINGORDERITEM = "SELECT shoppingOrderItem FROM ShoppingOrderItem shoppingOrderItem";
	private static final String _SQL_SELECT_SHOPPINGORDERITEM_WHERE = "SELECT shoppingOrderItem FROM ShoppingOrderItem shoppingOrderItem WHERE ";
	private static final String _SQL_COUNT_SHOPPINGORDERITEM = "SELECT COUNT(shoppingOrderItem) FROM ShoppingOrderItem shoppingOrderItem";
	private static final String _SQL_COUNT_SHOPPINGORDERITEM_WHERE = "SELECT COUNT(shoppingOrderItem) FROM ShoppingOrderItem shoppingOrderItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingOrderItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingOrderItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingOrderItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ShoppingOrderItemPersistenceImpl.class);
	private static ShoppingOrderItem _nullShoppingOrderItem = new ShoppingOrderItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ShoppingOrderItem> toCacheModel() {
				return _nullShoppingOrderItemCacheModel;
			}
		};

	private static CacheModel<ShoppingOrderItem> _nullShoppingOrderItemCacheModel =
		new CacheModel<ShoppingOrderItem>() {
			@Override
			public ShoppingOrderItem toEntityModel() {
				return _nullShoppingOrderItem;
			}
		};
}