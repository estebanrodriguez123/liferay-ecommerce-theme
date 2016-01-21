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

import com.rivetlogic.ecommerce.model.ShoppingOrderItem;

import java.util.List;

/**
 * The persistence utility for the Shopping Order Item service. This utility wraps {@link ShoppingOrderItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author isaiulate
 * @see ShoppingOrderItemPersistence
 * @see ShoppingOrderItemPersistenceImpl
 * @generated
 */
public class ShoppingOrderItemUtil {
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
	public static void clearCache(ShoppingOrderItem shoppingOrderItem) {
		getPersistence().clearCache(shoppingOrderItem);
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
	public static List<ShoppingOrderItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ShoppingOrderItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ShoppingOrderItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ShoppingOrderItem update(ShoppingOrderItem shoppingOrderItem)
		throws SystemException {
		return getPersistence().update(shoppingOrderItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ShoppingOrderItem update(
		ShoppingOrderItem shoppingOrderItem, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(shoppingOrderItem, serviceContext);
	}

	/**
	* Returns all the Shopping Order Items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the matching Shopping Order Items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findByOrderId(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrderId(orderId);
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
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findByOrderId(
		long orderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrderId(orderId, start, end);
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
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findByOrderId(
		long orderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrderId(orderId, start, end, orderByComparator);
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
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem findByOrderId_First(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException {
		return getPersistence().findByOrderId_First(orderId, orderByComparator);
	}

	/**
	* Returns the first Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchByOrderId_First(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOrderId_First(orderId, orderByComparator);
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
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem findByOrderId_Last(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException {
		return getPersistence().findByOrderId_Last(orderId, orderByComparator);
	}

	/**
	* Returns the last Shopping Order Item in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchByOrderId_Last(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOrderId_Last(orderId, orderByComparator);
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
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem[] findByOrderId_PrevAndNext(
		long itemId, long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException {
		return getPersistence()
				   .findByOrderId_PrevAndNext(itemId, orderId, orderByComparator);
	}

	/**
	* Removes all the Shopping Order Items where orderId = &#63; from the database.
	*
	* @param orderId the order ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrderId(orderId);
	}

	/**
	* Returns the number of Shopping Order Items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the number of matching Shopping Order Items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrderId(orderId);
	}

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or throws a {@link com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException} if it could not be found.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the matching Shopping Order Item
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem findByOrderAndProductId(
		long orderId, java.lang.String productId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException {
		return getPersistence().findByOrderAndProductId(orderId, productId);
	}

	/**
	* Returns the Shopping Order Item where orderId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the matching Shopping Order Item, or <code>null</code> if a matching Shopping Order Item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchByOrderAndProductId(
		long orderId, java.lang.String productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOrderAndProductId(orderId, productId);
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
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchByOrderAndProductId(
		long orderId, java.lang.String productId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrderAndProductId(orderId, productId,
			retrieveFromCache);
	}

	/**
	* Removes the Shopping Order Item where orderId = &#63; and productId = &#63; from the database.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the Shopping Order Item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem removeByOrderAndProductId(
		long orderId, java.lang.String productId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException {
		return getPersistence().removeByOrderAndProductId(orderId, productId);
	}

	/**
	* Returns the number of Shopping Order Items where orderId = &#63; and productId = &#63;.
	*
	* @param orderId the order ID
	* @param productId the product ID
	* @return the number of matching Shopping Order Items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrderAndProductId(long orderId,
		java.lang.String productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrderAndProductId(orderId, productId);
	}

	/**
	* Caches the Shopping Order Item in the entity cache if it is enabled.
	*
	* @param shoppingOrderItem the Shopping Order Item
	*/
	public static void cacheResult(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem) {
		getPersistence().cacheResult(shoppingOrderItem);
	}

	/**
	* Caches the Shopping Order Items in the entity cache if it is enabled.
	*
	* @param shoppingOrderItems the Shopping Order Items
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> shoppingOrderItems) {
		getPersistence().cacheResult(shoppingOrderItems);
	}

	/**
	* Creates a new Shopping Order Item with the primary key. Does not add the Shopping Order Item to the database.
	*
	* @param itemId the primary key for the new Shopping Order Item
	* @return the new Shopping Order Item
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem create(
		long itemId) {
		return getPersistence().create(itemId);
	}

	/**
	* Removes the Shopping Order Item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item that was removed
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem remove(
		long itemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException {
		return getPersistence().remove(itemId);
	}

	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem updateImpl(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(shoppingOrderItem);
	}

	/**
	* Returns the Shopping Order Item with the primary key or throws a {@link com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException} if it could not be found.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item
	* @throws com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException if a Shopping Order Item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem findByPrimaryKey(
		long itemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException {
		return getPersistence().findByPrimaryKey(itemId);
	}

	/**
	* Returns the Shopping Order Item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the Shopping Order Item
	* @return the Shopping Order Item, or <code>null</code> if a Shopping Order Item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.ecommerce.model.ShoppingOrderItem fetchByPrimaryKey(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemId);
	}

	/**
	* Returns all the Shopping Order Items.
	*
	* @return the Shopping Order Items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrderItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Shopping Order Items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Shopping Order Items.
	*
	* @return the number of Shopping Order Items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ShoppingOrderItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShoppingOrderItemPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.ecommerce.service.ClpSerializer.getServletContextName(),
					ShoppingOrderItemPersistence.class.getName());

			ReferenceRegistry.registerReference(ShoppingOrderItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ShoppingOrderItemPersistence persistence) {
	}

	private static ShoppingOrderItemPersistence _persistence;
}