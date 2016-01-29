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
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.DateUtil;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.notification.util.EmailNotificationUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;
import com.rivetlogic.ecommerce.service.base.ShoppingOrderLocalServiceBaseImpl;
import com.rivetlogic.ecommerce.service.persistence.ShoppingOrderUtil;
import com.rivetlogic.ecommerce.util.OrderStatusEnum;

import java.util.List;

/**
 * The implementation of the Shopping Order local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.ecommerce.service.ShoppingOrderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author isaiulate
 * @see com.rivetlogic.ecommerce.service.base.ShoppingOrderLocalServiceBaseImpl
 * @see com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil
 */
public class ShoppingOrderLocalServiceImpl
	extends ShoppingOrderLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil} to access the Shopping Order local service.
	 */
	
	public List<ShoppingOrder> findByOrderStatusAndUserId(String orderStatus, long userId) throws SystemException {
		return ShoppingOrderUtil.findByOrderStatusAndUserId(orderStatus, userId);
	}
	
	public ShoppingOrder getUserActiveOrder(long userId, long groupId, long companyId, boolean createIfNotFound) throws SystemException{
		List<ShoppingOrder> activeOrders = findByOrderStatusAndUserId(OrderStatusEnum.ACTIVE.toString(), userId);
		ShoppingOrder activeShoppingOrder = null;
		if(null != activeOrders && !activeOrders.isEmpty()){
			activeShoppingOrder = activeOrders.get(0);
		}else
			if(createIfNotFound){
				activeShoppingOrder = ShoppingOrderLocalServiceUtil.createShoppingOrder(CounterLocalServiceUtil.increment(ShoppingOrder.class.getName()));
				activeShoppingOrder.setOrderStatus(OrderStatusEnum.ACTIVE.toString());
				activeShoppingOrder.setUserId(userId);
				activeShoppingOrder.setGroupId(groupId);
				activeShoppingOrder.setCompanyId(companyId);
				activeShoppingOrder.setCreateDate(DateUtil.newDate());
				activeShoppingOrder.setModifiedDate(DateUtil.newDate());
				ShoppingOrderLocalServiceUtil.addShoppingOrder(activeShoppingOrder);
			}

		return activeShoppingOrder;
	}
	
	public ShoppingOrder updateOrder(ShoppingOrder shoppingOrder) throws SystemException{
		shoppingOrder.setModifiedDate(DateUtil.newDate());
		return updateShoppingOrder(shoppingOrder);
	}
	
	public void placeOrder(ShoppingOrder shoppingOrder, Message notifMessages[], List<String>orderItemsProductIdsList) throws SystemException{
		shoppingOrder.setOrderStatus(OrderStatusEnum.PLACED.toString());
		updateOrder(shoppingOrder);
		ShoppingOrderItemLocalServiceUtil.saveOrderItemsByProductId(orderItemsProductIdsList, shoppingOrder);
		if(null != notifMessages)
			for(Message message : notifMessages){
				EmailNotificationUtil.sendEmailNotification(message);
			}
	}
	
	public ShoppingOrder createOrder(long orderId){
		ShoppingOrder shoppingOrder = createShoppingOrder(orderId); 
		shoppingOrder.setCreateDate(DateUtil.newDate());
		return shoppingOrder;
	}

}