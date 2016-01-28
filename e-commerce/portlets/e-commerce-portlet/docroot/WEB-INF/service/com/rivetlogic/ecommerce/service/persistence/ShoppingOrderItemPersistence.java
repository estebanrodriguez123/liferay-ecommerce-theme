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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.ecommerce.model.ShoppingOrderItem;

/**
 * The persistence interface for the Shopping Order Item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author isaiulate
 * @see ShoppingOrderItemPersistenceImpl
 * @see ShoppingOrderItemUtil
 * @generated
 */
public interface ShoppingOrderItemPersistence extends BasePersistence<ShoppingOrderItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShoppingOrderItemUtil} to access the Shopping Order Item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the Shopping Order Items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the matching Shopping Order Items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findByOrderId(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findByOrderId(
		long orderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findByOrderId(
		long orderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem findByOrderId_First(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException;

	/**
	* Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchByOrderId_First(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem findByOrderId_Last(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException;

	/**
	* Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchByOrderId_Last(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem[] findByOrderId_PrevAndNext(
		long itemId, long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException;

	/**
	* Removes all the Shopping Order Items where orderId = &#63; from the database.
	*
	* @param orderId the order ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Shopping Order Items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the number of matching Shopping Order Items
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or throws a {@link com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException} if it could not be found.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the matching Shopping Order Item
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem findByOrderAndProductId(
		long orderId, java.lang.String productId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException;

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchByOrderAndProductId(
		long orderId, java.lang.String productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchByOrderAndProductId(
		long orderId, java.lang.String productId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the Shopping Order Item where orderId = &#63; and productId = &#63; from the database.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the Shopping Order Item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem removeByOrderAndProductId(
		long orderId, java.lang.String productId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException;

	/**
	* Returns the number of Shopping Order Items where orderId = &#63; and productId = &#63;.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the number of matching Shopping Order Items
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrderAndProductId(long orderId, java.lang.String productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the Shopping Order Item in the entity cache if it is enabled.
	*
	* @param shoppingOrderItem the Shopping Order Item
	*/
	public void cacheResult(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem);

	/**
	* Caches the Shopping Order Items in the entity cache if it is enabled.
	*
	* @param shoppingOrderItems the Shopping Order Items
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> shoppingOrderItems);

	/**
	* Creates a new Shopping Order Item with the primary key. Does not add the Shopping Order Item to the database.
	*
	* @param itemId the primary key for the new Shopping Order Item
	* @return the new Shopping Order Item
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem create(long itemId);

	/**
	* Removes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item that was removed
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem remove(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException;

	public com.rivetlogic.ecommerce.model.ShoppingOrderItem updateImpl(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Shopping Order Item with the primary key or throws a {@link com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException} if it could not be found.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem findByPrimaryKey(
		long itemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException;

	/**
	* Returns the Shopping Order Item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item, or <code>null</code> if a Shopping Order Item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchByPrimaryKey(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Shopping Order Items.
	*
	* @return the Shopping Order Items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Shopping Order Items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Shopping Order Items.
	*
	* @return the number of Shopping Order Items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}