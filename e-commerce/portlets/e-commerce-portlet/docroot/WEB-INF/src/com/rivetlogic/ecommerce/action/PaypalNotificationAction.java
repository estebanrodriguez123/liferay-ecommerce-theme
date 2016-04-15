/**
 * Copyright (C) 2005-2016 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package com.rivetlogic.ecommerce.action;

import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.model.ShoppingOrderItem;
import com.rivetlogic.ecommerce.notification.util.EmailNotificationUtil;
import com.rivetlogic.ecommerce.paypal.PaypalConstants;
import com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;
import com.rivetlogic.ecommerce.util.OrderStatusEnum;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author joseross
 *
 */
public class PaypalNotificationAction extends BaseStrutsAction {

    private static final Log LOG = LogFactoryUtil.getLog(PaypalNotificationAction.class);
    
    private static final String LOG_NOTIFICATION = "Paypal Notification for order %s, status: %s";
    private static final String LOG_UNKNOWN_ORDER = "Unknown order received: %s";
    private static final String LOG_DEBUG_PARAM = "Param %s = %s";
    private static final String LOG_DEBUG_QUERY = "Paypal Query: %s";
    private static final String LOG_STATUS_RESPONSE = "Paypal Status Response: %s";
    private static final String LOG_TRX_VERIFIED = "Transaction Verified, sending emails...";
    private static final String LOG_TRX_ERROR = "Error on Paypal Notification";
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        long orderId = ParamUtil.getLong(request, PaypalConstants.PARAM_INVOICE);
        String status = ParamUtil.getString(request, PaypalConstants.PAYMENT_STATUS);
        
        LOG.info(String.format(LOG_NOTIFICATION, orderId, status));
                
        ShoppingOrder order = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(orderId);
        List<ShoppingOrderItem> items = ShoppingOrderItemLocalServiceUtil.findByOrderId(orderId);
        
        if(items.isEmpty()) {
            LOG.error(String.format(LOG_UNKNOWN_ORDER, orderId));
            return null;
        }
        
        List<String> itemsIds = new ArrayList<String>();
        for(ShoppingOrderItem item : items) {
            itemsIds.add(Long.toString(item.getItemId()));
        }
        
        String query = PaypalConstants.PARAM_CMD + "=" + PaypalConstants.CMD_VALIDATE;
        
        Enumeration<String> enu = request.getParameterNames();
        
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
            String value = request.getParameter(name);
            if(LOG.isDebugEnabled())
                LOG.debug(String.format(LOG_DEBUG_PARAM, name, value));
            query = query + "&" + name + "=" + HttpUtil.encodeURL(value);
        }
        
        if(LOG.isDebugEnabled())
            LOG.debug(String.format(LOG_DEBUG_QUERY, query));
        
        URL url = new URL(PaypalConstants.PAYPAL_ENDPOINT);
        
        URLConnection urlc = url.openConnection();

        urlc.setDoOutput(true);
        urlc.setRequestProperty(
            "Content-Type","application/x-www-form-urlencoded");

        PrintWriter pw = UnsyncPrintWriterPool.borrow(
            urlc.getOutputStream());

        pw.println(query);

        pw.close();

        UnsyncBufferedReader unsyncBufferedReader =
            new UnsyncBufferedReader(
                new InputStreamReader(urlc.getInputStream()));

        String payPalStatus = unsyncBufferedReader.readLine();

        unsyncBufferedReader.close();
        
        LOG.info(String.format(LOG_STATUS_RESPONSE, payPalStatus));
        
        if (payPalStatus.equals(PaypalConstants.TRANSACTION_VERIFIED) && status.equals(PaypalConstants.PAYMENT_COMPLETE)) {
            
            LOG.info(LOG_TRX_VERIFIED);
            
            order.setOrderStatus(OrderStatusEnum.PAID.toString());
            ShoppingOrderLocalServiceUtil.updateOrder(order);
            
            EmailNotificationUtil.sendEmailNotification(orderId);
                
        } else {
            LOG.error(LOG_TRX_ERROR);
        }
        
        return "/portal/paypal.jsp";
    }
    
    
}
