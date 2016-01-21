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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.ecommerce.model.ShoppingOrder;

import java.util.List;

/**
 * The persistence utility for the Shopping Order service. This utility wraps {@link ShoppingOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author isaiulate
 * @see ShoppingOrderPersistence
 * @see ShoppingOrderPersistenceImpl
 * @generated
 */
public class ShoppingOrderUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ShoppingOrder shoppingOrder) {
		getPersistence().clearCache(shoppingOrder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ShoppingOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ShoppingOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ShoppingOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ShoppingOrder update(ShoppingOrder shoppingOrder)
		throws SystemException {
		return getPersistence().update(shoppingOrder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ShoppingOrder update(ShoppingOrder shoppingOrder,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(shoppingOrder, serviceContext);
	}

	/**
	* Returns all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @return the matching Shopping Orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrderStatusAndUserId(orderStatus, userId);
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
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrderStatusAndUserId(orderStatus, userId, start, end);
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
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrderStatusAndUserId(orderStatus, userId, start, end,
			orderByComparator);
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
	public static com.rivetlogic.ecommerce.model.ShoppingOrder findByOrderStatusAndUserId_First(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderException {
		return getPersistence()
				   .findByOrderStatusAndUserId_First(orderStatus, userId,
			orderByComparator);
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
	public static com.rivetlogic.ecommerce.model.ShoppingOrder fetchByOrderStatusAndUserId_First(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrderStatusAndUserId_First(orderStatus, userId,
			orderByComparator);
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
	public static com.rivetlogic.ecommerce.model.ShoppingOrder findByOrderStatusAndUserId_Last(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderException {
		return getPersistence()
				   .findByOrderStatusAndUserId_Last(orderStatus, userId,
			orderByComparator);
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
	public static com.rivetlogic.ecommerce.model.ShoppingOrder fetchByOrderStatusAndUserId_Last(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrderStatusAndUserId_Last(orderStatus, userId,
			orderByComparator);
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
	public static com.rivetlogic.ecommerce.model.ShoppingOrder[] findByOrderStatusAndUserId_PrevAndNext(
		long orderId, java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderException {
		return getPersistence()
				   .findByOrderStatusAndUserId_PrevAndNext(orderId,
			orderStatus, userId, orderByComparator);
	}

	/**
	* Removes all the Shopping Orders where orderStatus = &#63; and userId = &#63; from the database.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrderStatusAndUserId(orderStatus, userId);
	}

	/**
	* Returns the number of Shopping Orders where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @return the number of matching Shopping Orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrderStatusAndUserId(orderStatus, userId);
	}

	/**
	* Caches the Shopping Order in the entity cache if it is enabled.
	*
	* @param shoppingOrder the Shopping Order
	*/
	public static void cacheResult(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder) {
		getPersistence().cacheResult(shoppingOrder);
	}

	/**
	* Caches the Shopping Orders in the entity cache if it is enabled.
	*
	* @param shoppingOrders the Shopping Orders
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> shoppingOrders) {
		getPersistence().cacheResult(shoppingOrders);
	}

	/**
	* Creates a new Shopping Order with the primary key. Does not add the Shopping Order to the database.
	*
	* @param orderId the primary key for the new Shopping Order
	* @return the new Shopping Order
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder create(
		long orderId) {
		return getPersistence().create(orderId);
	}

	/**
	* Removes the Shopping Order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order that was removed
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder remove(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderException {
		return getPersistence().remove(orderId);
	}

	public static com.rivetlogic.ecommerce.model.ShoppingOrder updateImpl(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(shoppingOrder);
	}

	/**
	* Returns the Shopping Order with the primary key or throws a {@link com.rivetlogic.ecommerce.NoSuchShoppingOrderException} if it could not be found.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder findByPrimaryKey(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderException {
		return getPersistence().findByPrimaryKey(orderId);
	}

	/**
	* Returns the Shopping Order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order, or <code>null</code> if a Shopping Order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrder fetchByPrimaryKey(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(orderId);
	}

	/**
	* Returns all the Shopping Orders.
	*
	* @return the Shopping Orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Shopping Orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Shopping Orders.
	*
	* @return the number of Shopping Orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ShoppingOrderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShoppingOrderPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.ecommerce.service.ClpSerializer.getServletContextName(),
					ShoppingOrderPersistence.class.getName());

			ReferenceRegistry.registerReference(ShoppingOrderUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ShoppingOrderPersistence persistence) {
	}

	private static ShoppingOrderPersistence _persistence;
}