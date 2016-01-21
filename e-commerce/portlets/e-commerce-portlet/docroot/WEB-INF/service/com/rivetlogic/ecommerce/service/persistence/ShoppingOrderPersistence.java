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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.ecommerce.model.ShoppingOrder;

/**
 * The persistence interface for the Shopping Order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author isaiulate
 * @see ShoppingOrderPersistenceImpl
 * @see ShoppingOrderUtil
 * @generated
 */
public interface ShoppingOrderPersistence extends BasePersistence<ShoppingOrder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShoppingOrderUtil} to access the Shopping Order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the Shopping Orders where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @return the matching Shopping Orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.ecommerce.model.ShoppingOrder findByOrderStatusAndUserId_First(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderException;

	/**
	* Returns the first Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrder fetchByOrderStatusAndUserId_First(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.ecommerce.model.ShoppingOrder findByOrderStatusAndUserId_Last(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderException;

	/**
	* Returns the last Shopping Order in the ordered set where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order, or <code>null</code> if a matching Shopping Order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrder fetchByOrderStatusAndUserId_Last(
		java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.ecommerce.model.ShoppingOrder[] findByOrderStatusAndUserId_PrevAndNext(
		long orderId, java.lang.String orderStatus, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderException;

	/**
	* Removes all the Shopping Orders where orderStatus = &#63; and userId = &#63; from the database.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrderStatusAndUserId(java.lang.String orderStatus,
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Shopping Orders where orderStatus = &#63; and userId = &#63;.
	*
	* @param orderStatus the order status
	* @param userId the user ID
	* @return the number of matching Shopping Orders
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrderStatusAndUserId(java.lang.String orderStatus,
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the Shopping Order in the entity cache if it is enabled.
	*
	* @param shoppingOrder the Shopping Order
	*/
	public void cacheResult(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder);

	/**
	* Caches the Shopping Orders in the entity cache if it is enabled.
	*
	* @param shoppingOrders the Shopping Orders
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> shoppingOrders);

	/**
	* Creates a new Shopping Order with the primary key. Does not add the Shopping Order to the database.
	*
	* @param orderId the primary key for the new Shopping Order
	* @return the new Shopping Order
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrder create(long orderId);

	/**
	* Removes the Shopping Order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order that was removed
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrder remove(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderException;

	public com.rivetlogic.ecommerce.model.ShoppingOrder updateImpl(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Shopping Order with the primary key or throws a {@link com.rivetlogic.ecommerce.NoSuchShoppingOrderException} if it could not be found.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderException if a Shopping Order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrder findByPrimaryKey(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderException;

	/**
	* Returns the Shopping Order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order, or <code>null</code> if a Shopping Order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrder fetchByPrimaryKey(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Shopping Orders.
	*
	* @return the Shopping Orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Shopping Orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Shopping Orders.
	*
	* @return the number of Shopping Orders
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}