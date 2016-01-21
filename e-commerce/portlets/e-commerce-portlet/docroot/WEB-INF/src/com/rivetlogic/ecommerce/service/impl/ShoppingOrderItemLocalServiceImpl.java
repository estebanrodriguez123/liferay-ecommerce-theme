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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.rivetlogic.ecommerce.NoSuchShoppingOrderItemException;
import com.rivetlogic.ecommerce.model.ShoppingOrderItem;
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
	
}