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

package com.rivetlogic.ecommerce.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShoppingOrderLocalService}.
 *
 * @author isaiulate
 * @see ShoppingOrderLocalService
 * @generated
 */
public class ShoppingOrderLocalServiceWrapper
	implements ShoppingOrderLocalService,
		ServiceWrapper<ShoppingOrderLocalService> {
	public ShoppingOrderLocalServiceWrapper(
		ShoppingOrderLocalService shoppingOrderLocalService) {
		_shoppingOrderLocalService = shoppingOrderLocalService;
	}

	/**
	* Adds the Shopping Order to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the Shopping Order
	* @return the Shopping Order that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder addShoppingOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.addShoppingOrder(shoppingOrder);
	}

	/**
	* Creates a new Shopping Order with the primary key. Does not add the Shopping Order to the database.
	*
	* @param orderId the primary key for the new Shopping Order
	* @return the new Shopping Order
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder createShoppingOrder(
		long orderId) {
		return _shoppingOrderLocalService.createShoppingOrder(orderId);
	}

	/**
	* Deletes the Shopping Order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order that was removed
	* @throws PortalException if a Shopping Order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder deleteShoppingOrder(
		long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.deleteShoppingOrder(orderId);
	}

	/**
	* Deletes the Shopping Order from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the Shopping Order
	* @return the Shopping Order that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder deleteShoppingOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.deleteShoppingOrder(shoppingOrder);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _shoppingOrderLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder fetchShoppingOrder(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.fetchShoppingOrder(orderId);
	}

	/**
	* Returns the Shopping Order with the primary key.
	*
	* @param orderId the primary key of the Shopping Order
	* @return the Shopping Order
	* @throws PortalException if a Shopping Order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder getShoppingOrder(
		long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.getShoppingOrder(orderId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> getShoppingOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.getShoppingOrders(start, end);
	}

	/**
	* Returns the number of Shopping Orders.
	*
	* @return the number of Shopping Orders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getShoppingOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.getShoppingOrdersCount();
	}

	/**
	* Updates the Shopping Order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the Shopping Order
	* @return the Shopping Order that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder updateShoppingOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.updateShoppingOrder(shoppingOrder);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _shoppingOrderLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_shoppingOrderLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _shoppingOrderLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rivetlogic.ecommerce.model.ShoppingOrder> findByOrderStatusAndUserId(
		java.lang.String orderStatus, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.findByOrderStatusAndUserId(orderStatus,
			userId);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder getUserActiveOrder(
		long userId, long groupId, long companyId, boolean createIfNotFound)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.getUserActiveOrder(userId, groupId,
			companyId, createIfNotFound);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder updateOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrderLocalService.updateOrder(shoppingOrder);
	}

	@Override
	public void placeOrder(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder,
		com.liferay.portal.kernel.messaging.Message[] notifMessages,
		java.util.List<java.lang.String> orderItemsProductIdsList)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingOrderLocalService.placeOrder(shoppingOrder, notifMessages,
			orderItemsProductIdsList);
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder createOrder(
		long orderId) {
		return _shoppingOrderLocalService.createOrder(orderId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ShoppingOrderLocalService getWrappedShoppingOrderLocalService() {
		return _shoppingOrderLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedShoppingOrderLocalService(
		ShoppingOrderLocalService shoppingOrderLocalService) {
		_shoppingOrderLocalService = shoppingOrderLocalService;
	}

	@Override
	public ShoppingOrderLocalService getWrappedService() {
		return _shoppingOrderLocalService;
	}

	@Override
	public void setWrappedService(
		ShoppingOrderLocalService shoppingOrderLocalService) {
		_shoppingOrderLocalService = shoppingOrderLocalService;
	}

	private ShoppingOrderLocalService _shoppingOrderLocalService;
}