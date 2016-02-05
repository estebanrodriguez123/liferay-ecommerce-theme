/**
 * Copyright (C) 2016 Rivet Logic Corporation. All rights reserved.
 */

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

package com.rivetlogic.ecommerce.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.model.ShoppingOrderItem;
import com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil;
import com.rivetlogic.ecommerce.service.base.ShoppingOrderItemLocalServiceBaseImpl;
import com.rivetlogic.ecommerce.service.persistence.ShoppingOrderItemUtil;

import java.util.List;

/**
 * The implementation of the Shopping Order Item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author isaiulate
 * @see com.rivetlogic.ecommerce.service.base.ShoppingOrderItemLocalServiceBaseImpl
 * @see com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil
 */
public class ShoppingOrderItemLocalServiceImpl
	extends ShoppingOrderItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil} to access the Shopping Order Item local service.
	 */
	
	public List<ShoppingOrderItem> findByOrderId(long orderId) throws SystemException {
		return ShoppingOrderItemUtil.findByOrderId(orderId);
	}
	
	public ShoppingOrderItem findByOrderAndProductId (long orderId, String productId) throws SystemException{
		try {
			return ShoppingOrderItemUtil.findByOrderAndProductId(orderId, productId);
		} catch (NoSuchShoppingOrderItemException e) {
			return null;
		}
	}
	
	public ShoppingOrderItem createOrderItem(long orderId){
		ShoppingOrderItem shoppingOrderItem = createShoppingOrderItem(orderId);
		shoppingOrderItem.setCreateDate(DateUtil.newDate());
		return shoppingOrderItem;
	}
	
	public ShoppingOrderItem updateOrderItem(ShoppingOrderItem shoppingOrderItem) throws SystemException{
		shoppingOrderItem.setModifiedDate(DateUtil.newDate());
		return updateShoppingOrderItem(shoppingOrderItem);
	}
	
	private void saveOrderItem(String productId, long orderId) throws SystemException {
		ShoppingOrderItem shoppingOrderItem = ShoppingOrderItemLocalServiceUtil
				.createOrderItem(CounterLocalServiceUtil
						.increment(ShoppingOrderItem.class.getName()));
		shoppingOrderItem.setOrderId(orderId);
		shoppingOrderItem.setQuantity(1);
		shoppingOrderItem.setProductId(productId);
		shoppingOrderItem.setCreateDate(DateUtil.newDate());
		shoppingOrderItem.setModifiedDate(DateUtil.newDate());
		ShoppingOrderItemLocalServiceUtil.updateOrderItem(shoppingOrderItem);
	}

	public void saveOrderItemsByProductId(List<String> productIdsList,
			ShoppingOrder shoppingOrder) throws SystemException {
		if(null == productIdsList)
			return;
		for (String itemToAdd : productIdsList) {
			try {
				ShoppingOrderItem shoppingOrderItem = ShoppingOrderItemLocalServiceUtil
						.findByOrderAndProductId(shoppingOrder.getOrderId(),
								itemToAdd);
				if (null == shoppingOrderItem) {
					// meaning that there is db record for that item
					saveOrderItem(itemToAdd, shoppingOrder.getOrderId());
				} else {
					// increase the count for that item and updates it
					shoppingOrderItem.setQuantity(shoppingOrderItem
							.getQuantity() + 1);
					ShoppingOrderItemLocalServiceUtil
							.updateShoppingOrderItem(shoppingOrderItem);
				}
			} catch (SystemException e) {
				throw new SystemException(String.format(ERROR_SAVING_ORDER_ITEM, itemToAdd,
						e.getMessage()));
			}
		}
	}
	
	private static final String ERROR_SAVING_ORDER_ITEM = "Error while saving order item with productId: %S. %S";
	
}