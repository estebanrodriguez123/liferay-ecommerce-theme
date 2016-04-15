package com.rivetlogic.ecommerce.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

/**
 * Portlet implementation class OrdersPortlet
 */
public class OrdersPortlet extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(OrdersPortlet.class);

    public void updateOrderStatus(ActionRequest request, ActionResponse response) throws IOException, PortletException {
        long orderId = ParamUtil.getLong(request, ShoppingCartPortletConstants.ORDER_ID);
        String newStatus = ParamUtil.getString(request, ShoppingCartPortletConstants.STATUS_UPDATE);
        String redirect = ParamUtil.getString(request, "redirect");
        LOG.debug(String.format("Updating order %s with status %s", orderId, newStatus));
        
        try {
            ShoppingOrder order = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(orderId);
            order.setOrderStatus(newStatus);
            ShoppingOrderLocalServiceUtil.updateOrder(order);
            SessionMessages.add(request, "success");
        } catch(SystemException e) {
            LOG.error(e);
        }
        response.sendRedirect(redirect);
    }
    
    public void updateOrderNotes(ActionRequest request, ActionResponse response) throws IOException, PortletException {
        long orderId = ParamUtil.getLong(request, ShoppingCartPortletConstants.ORDER_ID);
        String notes = ParamUtil.getString(request, ShoppingCartPortletConstants.NOTES_UPDATE);
        String redirect = ParamUtil.getString(request, "redirect");
        LOG.debug(String.format("Updating notes for order %s", orderId));
        try {
            ShoppingOrder order = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(orderId);
            order.setNotes(notes);
            ShoppingOrderLocalServiceUtil.updateOrder(order);
            SessionMessages.add(request, "success");
        } catch(SystemException e) {
            LOG.error(e);
        }
        response.sendRedirect(redirect);
    }
    
}
