package com.rivetlogic.ecommerce.action;

import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.rivetlogic.ecommerce.beans.ShoppingCartPrefsBean;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.model.ShoppingOrderItem;
import com.rivetlogic.ecommerce.notification.constants.NotificationConstants;
import com.rivetlogic.ecommerce.notification.util.EmailNotificationUtil;
import com.rivetlogic.ecommerce.paypal.PaypalConstants;
import com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;

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
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String query = "cmd=_notify-validate";

        long orderId = ParamUtil.getLong(request, PaypalConstants.PARAM_INVOICE);
        String status = ParamUtil.getString(request, PaypalConstants.PAYMENT_STATUS);
        
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        // Get PortletPreferences for the cart ...
        PortletPreferences portletPreferences = null;
        List<PortletPreferences> preferences = PortletPreferencesLocalServiceUtil.getPortletPreferences();
        for(PortletPreferences p : preferences) {
            if(p.getPortletId().equals("shoppingcart_WAR_ecommerceportlet")) {
                portletPreferences = p;
            }
        }
        ShoppingCartPrefsBean cartPrefsBean = new ShoppingCartPrefsBean(PortletPreferencesLocalServiceUtil.getPreferences(
                themeDisplay.getCompanyId(), portletPreferences.getOwnerId(), portletPreferences.getOwnerType(), 
                portletPreferences.getPlid(), portletPreferences.getPortletId()));
        
        ShoppingOrder shoppingOrder = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(orderId);
        List<ShoppingOrderItem> items = ShoppingOrderItemLocalServiceUtil.findByOrderId(orderId);
        List<String> itemsIds = new ArrayList<String>();
        for(ShoppingOrderItem item : items) {
            itemsIds.add(Long.toString(item.getItemId()));
        }
        
        
        //if(LOG.isDebugEnabled())
            LOG.error(String.format("Paypal Notification for order %s, status: %s", orderId, status));
        
        Enumeration<String> enu = request.getParameterNames();

        while (enu.hasMoreElements()) {
            String name = enu.nextElement();

            String value = request.getParameter(name);

            query = query + "&" + name + "=" + HttpUtil.encodeURL(value);
        }
        
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
        
        if(LOG.isDebugEnabled())
            LOG.debug("Paypal Status Response: " + payPalStatus);
        if (payPalStatus.equals(PaypalConstants.TRANSACTION_VERIFIED) && status.equals(PaypalConstants.PAYMENT_COMPLETE)) {
            
            if(LOG.isDebugEnabled())
                LOG.debug("Transaction Verified, sending email...");
            
            Message customerMessage = EmailNotificationUtil.getNotificationMessage(themeDisplay, shoppingOrder, itemsIds, cartPrefsBean, NotificationConstants.CUSTOMER_NOTIFICATION);
            Message storeMessage = EmailNotificationUtil.getNotificationMessage(themeDisplay, shoppingOrder, itemsIds, cartPrefsBean, NotificationConstants.STORE_NOTIFICATION);
            
            //TODO: send messages...
            
        } else {
            LOG.error("Error on Paypal Notification");
        }
        
        return "/portal/paypal.jsp";
    }
    
    
}
