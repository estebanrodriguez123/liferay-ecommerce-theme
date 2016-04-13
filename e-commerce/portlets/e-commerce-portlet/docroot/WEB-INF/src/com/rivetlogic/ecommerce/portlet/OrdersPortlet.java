package com.rivetlogic.ecommerce.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class OrdersPortlet
 */
public class OrdersPortlet extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(OrdersPortlet.class);

    public void updateOrderStatus(ActionRequest request, ActionResponse response) {
        long orderId = ParamUtil.getLong(request, "orderId");
        String newStatus = ParamUtil.getString(request, "newStatus");
        LOG.debug(String.format("Updating order %s status %s", orderId, newStatus));
        
        try {
            ShoppingOrder order = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(orderId);
            order.setOrderStatus(newStatus);
            ShoppingOrderLocalServiceUtil.updateOrder(order);
        } catch(SystemException e) {
            LOG.error(e);
        }
    }
    
}
