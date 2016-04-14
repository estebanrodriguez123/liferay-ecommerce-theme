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

package com.rivetlogic.ecommerce.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.ecommerce.beans.ShoppingCartPrefsBean;
import com.rivetlogic.ecommerce.cart.ShoppingCartItem;
import com.rivetlogic.ecommerce.cart.ShoppingCartItemUtil;
import com.rivetlogic.ecommerce.configuration.PortletConfiguration;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.model.ShoppingOrderItem;
import com.rivetlogic.ecommerce.notification.constants.NotificationConstants;
import com.rivetlogic.ecommerce.notification.util.EmailNotificationUtil;
import com.rivetlogic.ecommerce.paypal.PaypalUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;
import javax.servlet.http.HttpServletResponse;

/**
 * @author isaiulate
 */

public class ShoppingCartPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		try {
			PortletConfiguration.checkPorletConfiguration(request);
		} catch (ReadOnlyException e) {
			logger.error(String.format(ERROR_CHECKING_PORTLET_CONFIG, e.getMessage()));
			throw e;
		} catch (ValidatorException e) {
			logger.error(String.format(ERROR_CHECKING_PORTLET_CONFIG, e.getMessage()));
			throw e;
		} catch (IOException e) {
			logger.error(String.format(ERROR_CHECKING_PORTLET_CONFIG, e.getMessage()));
			throw e;
		}
		super.render(request, response);
	}
	
	@Override
	public void doView(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
        request.setAttribute("prefs", new ShoppingCartPrefsBean(request));
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			try {
				ShoppingOrder activeShoppingOrder = ShoppingOrderLocalServiceUtil.getUserActiveOrder(
						themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getCompanyId(),
						Boolean.FALSE);
				if (null != activeShoppingOrder) {
					List<ShoppingCartItem> cartItems = ShoppingCartItemUtil.getCartItems(activeShoppingOrder.getOrderId(), themeDisplay);
					if (null != cartItems && !cartItems.isEmpty()) {
						request.setAttribute(ShoppingCartPortletConstants.CURRENT_ORDER_ITEMS, cartItems);
					}
				}
			} catch (SystemException e) {
				logger.error(e.getMessage());
			}
		} else {
			List<String> orderItems = getOrderItemsIdsFromSession(request);
			if (null != orderItems) {
				Map<String, ShoppingCartItem> orderItemsMap = new HashMap<String, ShoppingCartItem>();
				for (String orderItemId : orderItems) {
					if (null == orderItemsMap.get(orderItemId)) {
						ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
						shoppingCartItem.setProductId(orderItemId);
						ShoppingCartItemUtil.setCartItemDetails(orderItemId, themeDisplay, shoppingCartItem);
						orderItemsMap.put(orderItemId, shoppingCartItem);
					} else {
						orderItemsMap.get(orderItemId).setCount(orderItemsMap.get(orderItemId).getCount() + 1);
					}
				}
				List<ShoppingCartItem> list = new ArrayList<>();
				list.addAll(orderItemsMap.values());
				request.setAttribute(ShoppingCartPortletConstants.CURRENT_ORDER_ITEMS, list);
			}
		}
		super.doView(request, response);
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {

		String cmd = ParamUtil.getString(request,
				ShoppingCartPortletConstants.CMD);
		if (null != cmd && !cmd.isEmpty()) {
			switch (cmd) {
			case ShoppingCartPortletConstants.ACTION_ADD_ITEM_TO_CART:
				addItemToCart(request, response);
				break;
			case ShoppingCartPortletConstants.ACTION_REMOVE_ITEM_FROM_CART:
				removeCartItem(request, response);
				break;
			case ShoppingCartPortletConstants.ACTION_UPDATE_CART_ITEM:
				updateCartItem(request, response);
				break;
			case ShoppingCartPortletConstants.ACTION_GET_CART_INFO:
				try {
					addCartDetailsOnResponse(request, response, null);
				} catch (Exception e) {
					printJsonResponse(
							String.format(ERROR_SERVING_RESOURCE, cmd,
									e.getMessage()),
							String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
							response);
					logger.error(
							String.format(ERROR_SERVING_RESOURCE, cmd,
									e.getMessage()), e);
				}
				break;
			}
		} else {
			printJsonResponse(String.format(ERROR_BAD_PARAMETER_VALUE, cmd),
					String.valueOf(HttpServletResponse.SC_BAD_REQUEST),
					response);
		}
	}
	
	public void checkout(ActionRequest request, ActionResponse response)
			throws IOException {
		
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		
		String redirect = ParamUtil.getString(request, WebKeys.REDIRECT);
		boolean isPaypal = ParamUtil.getBoolean(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_PAYPAL);
		
		if(!validateCheckoutInfo(request)){
			SessionErrors.add(request, ShoppingCartPortletConstants.MESSAGE_MISSING_REQUIRED_CHECKOUT_INFO);
		} else if(!(new ShoppingCartPrefsBean(request).isCartPrefsValidForCheckout(isPaypal))){
			SessionErrors.add(request, ShoppingCartPortletConstants.ERROR_MESSAGE_CHECKOUT);
			logger.error(ERROR_CHECKOUT_MISSING_PORTLET_CONFIG);
		} else {
		    try {
	            String value = doCheckout(request, response, isPaypal);
	            if(value != null) {
	                redirect = value;
	            }
	        } catch (Exception e) {
	            SessionErrors.add(request, ShoppingCartPortletConstants.ERROR_MESSAGE_CHECKOUT);
	            logger.error(e);
	        }
		}
		
		response.sendRedirect(redirect);
	}
	
	private String doCheckout(ActionRequest request, ActionResponse response, boolean isPaypal) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ShoppingOrder activeShoppingOrder = null;
		List<String> orderItemsIdsList = null;
		Map<String, Float> prices = null;
		if (themeDisplay.isSignedIn()) {
			activeShoppingOrder = ShoppingOrderLocalServiceUtil.getUserActiveOrder(
					themeDisplay.getUserId(),
					themeDisplay.getScopeGroupId(),
					themeDisplay.getCompanyId(),
					Boolean.TRUE);
			List<ShoppingOrderItem> orderItemsList = ShoppingOrderItemLocalServiceUtil.findByOrderId(activeShoppingOrder.getOrderId());
			if (null == orderItemsList || orderItemsList.isEmpty())
				return null;
		} else {
			orderItemsIdsList = getOrderItemsIdsFromSession(request);
			prices = getSessionOrderItemPrices(request);
			if (null != orderItemsIdsList) {
				activeShoppingOrder = ShoppingOrderLocalServiceUtil.createOrder(CounterLocalServiceUtil.increment(ShoppingOrderItem.class.getName()));
				activeShoppingOrder.setGroupId(themeDisplay.getScopeGroupId());
				activeShoppingOrder.setUserId(-1l);
				activeShoppingOrder.setUserName(RoleConstants.GUEST);
			}
		}
		
		List<ShoppingCartItem> shoppingCartItems = 
                (themeDisplay.isSignedIn() ? ShoppingCartItemUtil.getCartItems(activeShoppingOrder.getOrderId(), themeDisplay) : ShoppingCartItemUtil.getCartItemsByProductId(orderItemsIdsList, themeDisplay));
        if (null != shoppingCartItems) {
            double orderTotal = 0l;
            for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
                orderTotal += Float.valueOf(shoppingCartItem.getPrice())
                        * (float) shoppingCartItem.getCount();
            }
            activeShoppingOrder.setTotal(orderTotal);
        }
		
		activeShoppingOrder.setCustomerName(ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_NAME));
		activeShoppingOrder.setCustomerEmail(ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_EMAIL));
		activeShoppingOrder.setShippingAddress1(ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_ADDRESS_1));
		activeShoppingOrder.setShippingAddress2(ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_ADDRESS_2));
		activeShoppingOrder.setShippingCity(ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_CITY));
		activeShoppingOrder.setShippingStateProvince(ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_STATE_PROVINCE));
		activeShoppingOrder.setShippingPostalCode(ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_POSTAL_CODE));
		activeShoppingOrder.setShippingCountry(ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_COUNTRY));
		activeShoppingOrder.setCustomerPhone(ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_PHONE));
		ShoppingCartPrefsBean cartPrefsBean = new ShoppingCartPrefsBean(request);
		Message customerMessage = EmailNotificationUtil.getNotificationMessage(themeDisplay, activeShoppingOrder, orderItemsIdsList, cartPrefsBean, NotificationConstants.CUSTOMER_NOTIFICATION);
		Message storeMessage = EmailNotificationUtil.getNotificationMessage(themeDisplay, activeShoppingOrder, orderItemsIdsList, cartPrefsBean, NotificationConstants.STORE_NOTIFICATION);
		
		ShoppingOrderLocalServiceUtil.placeOrder(activeShoppingOrder, new Message[]{customerMessage, storeMessage}, orderItemsIdsList, prices, isPaypal);
		removeOrderItemsIdsFromSession(request);
		
		if(isPaypal) {
		    EmailNotificationUtil.storeEmailNotification(activeShoppingOrder.getOrderId(), customerMessage);
		    EmailNotificationUtil.storeEmailNotification(activeShoppingOrder.getOrderId(), storeMessage);
		    return PaypalUtil.getPaypalRedirect(request, response, activeShoppingOrder);
		} else {
		    SessionMessages.add(request, ShoppingCartPortletConstants.SUCCESS_MESSAGE_CHECKOUT);
		    return null;
		}
	}
	
	private boolean validateCheckoutInfo(ActionRequest request){
		boolean valid = true;
		String name = ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_NAME);
		String email = ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_EMAIL);
		String address1 = ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_ADDRESS_1);
		String city = ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_CITY);
		String stateProvince = ParamUtil.getString(request, ShoppingCartPortletConstants.CHECKOUT_PARAMETER_STATE_PROVINCE);
		if ((name == null || name.isEmpty())
				|| (email == null || email.isEmpty())
				|| (address1 == null || address1.isEmpty())
				|| (city == null || city.isEmpty())
				|| (stateProvince == null || stateProvince.isEmpty())) {
			valid = false;
		}
		return valid;
	}

	private void updateCartItem(ResourceRequest request, ResourceResponse response) {
		String itemId = null;
		try {
			itemId = ParamUtil.getString(request, ShoppingCartPortletConstants.WEB_CONTENT_ITEM_ID);
			Integer count = ParamUtil.getInteger(request, ShoppingCartPortletConstants.WEB_CONTENT_ITEM_COUNT);
			if ((null == itemId || itemId.isEmpty()) || (null == count || count <= 0)) {
				printJsonResponse(ERROR_MISSING_ITEM_ID_MESSAGE, String.valueOf(HttpServletResponse.SC_BAD_REQUEST), response);
				return;
			}
			doUpdateCartItem(request, response);
			addCartDetailsOnResponse(request, response, itemId);
		} catch (Exception e) {
			logger.error(String.format(ERROR_UPDATING_CART_ITEM_LOG, itemId, e.getMessage()));
			printJsonResponse(ERROR_UPDATING_CART_ITEM_MESSAGE, String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR), response);
		}
	}

	private void doUpdateCartItem(ResourceRequest request,
			ResourceResponse response) throws SystemException {
		String itemId = ParamUtil.getString(request, ShoppingCartPortletConstants.WEB_CONTENT_ITEM_ID);
		Integer count = ParamUtil.getInteger(request, ShoppingCartPortletConstants.WEB_CONTENT_ITEM_COUNT);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (!themeDisplay.isSignedIn()) {
			List<String>currentCartItems = getOrderItemsIdsFromSession(request);
			if (null != currentCartItems && currentCartItems.contains(itemId)) {
				List<String> newCartItems = new ArrayList<>();
				for (String cartItemId : currentCartItems) {
					if (!cartItemId.equals(itemId))
						newCartItems.add(cartItemId);
				}
				for (int i = 0; i < count; i++) {
					newCartItems.add(itemId);
				}
				setSessionOrderItemsIds(request, ListUtil.toString(newCartItems, StringPool.BLANK, StringPool.COMMA));
			}
		} else {
			Long cartItemId = Long.valueOf(itemId);
			ShoppingOrderItem shoppingOrderItem = ShoppingOrderItemLocalServiceUtil.fetchShoppingOrderItem(cartItemId);
			shoppingOrderItem.setQuantity(count);
			ShoppingOrderItemLocalServiceUtil.updateShoppingOrderItem(shoppingOrderItem);
		}
	}

	private void removeCartItem(ResourceRequest request,
			ResourceResponse response) {
		String itemId = null;
		try {
			itemId = ParamUtil.getString(request,
					ShoppingCartPortletConstants.WEB_CONTENT_ITEM_ID);
			if (null == itemId || itemId.isEmpty()) {
				printJsonResponse(ERROR_MISSING_ITEM_ID_MESSAGE,
						String.valueOf(HttpServletResponse.SC_BAD_REQUEST),
						response);
				return;
			}
			doRemoveCartItem(request, response);
			addCartDetailsOnResponse(request, response, null);
		} catch (Exception e) {
			logger.error(String.format(ERROR_REMOVING_ITEM_FROM_CART_LOG,
					itemId, e.getMessage()));
			printJsonResponse(
					ERROR_REMOVING_ITEM_FROM_CART_MESSAGE,
					String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
					response);
		}
	}

	private void doRemoveCartItem(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException {
		String itemId = ParamUtil.getString(request, ShoppingCartPortletConstants.WEB_CONTENT_ITEM_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (!themeDisplay.isSignedIn()) {
			List<String> currentCartItems = getOrderItemsIdsFromSession(request);
			if(null != currentCartItems){
				List<String> newCartItems = new ArrayList<>();
				for (String cartItemId : currentCartItems) {
					if (!cartItemId.equals(itemId))
						newCartItems.add(cartItemId);
				}
				setSessionOrderItemsIds(request, ListUtil.toString(newCartItems, StringPool.BLANK, StringPool.COMMA));
			}
		}  else {
			Long cartItemId = Long.valueOf(itemId);
			ShoppingOrderItemLocalServiceUtil.deleteShoppingOrderItem(cartItemId);
		}
	}

	private void addItemToCart(ResourceRequest request,
			ResourceResponse response) {
		String itemId = null;
		try {
			itemId = ParamUtil.getString(request,
					ShoppingCartPortletConstants.WEB_CONTENT_ITEM_ID);
			if (null == itemId || itemId.isEmpty()) {
				printJsonResponse(ERROR_MISSING_ITEM_ID_MESSAGE,
						String.valueOf(HttpServletResponse.SC_BAD_REQUEST),
						response);
				return;
			}
			doAddItemToCart(request, response);
			addCartDetailsOnResponse(request, response, itemId);
		} catch (Exception e) {
			logger.error(String
					.format(ERROR_ADDING_ITEM_TO_CART_LOG, itemId, e));
			printJsonResponse(
					ERROR_ADDING_ITEM_TO_CART_MESSAGE,
					String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
					response);
		}
	}

	private void doAddItemToCart(ResourceRequest request, ResourceResponse response) throws SystemException {
		String itemId = ParamUtil.getString(request, ShoppingCartPortletConstants.WEB_CONTENT_ITEM_ID);
		int count = ParamUtil.getInteger(request, ShoppingCartPortletConstants.WEB_CONTENT_ITEM_COUNT, 1);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		float price = getItemPrice(itemId, themeDisplay.getScopeGroupId());
		
		if (isValidItemId(themeDisplay.getScopeGroupId(), itemId)) {
			List<String> itemsIdsList = new ArrayList<String>();
			for (int i = 0; i < count; i++) {
				itemsIdsList.add(itemId);
			}
			if (!themeDisplay.isSignedIn()) {
				if(null != getOrderItemsIdsFromSession(request))
					itemsIdsList.addAll(getOrderItemsIdsFromSession(request));
				setSessionOrderItemsIds(request, ListUtil.toString(itemsIdsList, StringPool.BLANK, StringPool.COMMA));
				setSessionOrderItemPrice(request, itemId, price);
			} else {
				ShoppingOrder activeShoppingOrder = ShoppingOrderLocalServiceUtil.getUserActiveOrder(
						themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getCompanyId(),
						Boolean.TRUE);
				ShoppingOrderItemLocalServiceUtil.saveOrderItemByProductId(itemId, activeShoppingOrder, price);
			}
		} else {
			logger.warn(String.format(ERROR_ITEM_ID_NOT_VALID_LOG, itemId,
					StringPool.BLANK));
			printJsonResponse(ERROR_ITEM_ID_NOT_VALID_MESSAGE,
					String.valueOf(HttpServletResponse.SC_NOT_FOUND), response);
		}
	}

	private void addCartDetailsOnResponse(ResourceRequest request, ResourceResponse response, String itemId) throws SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, Integer> cartItemsCountMap = new HashMap<String, Integer>();
		String itemToDetailProductId = itemId;
		boolean returnItemDetails = (null != itemId && !itemId.isEmpty());

		if (!themeDisplay.isSignedIn()) {
			List<String> itemsProductIdsList = getOrderItemsIdsFromSession(request);
			if (itemsProductIdsList == null && returnItemDetails) {
				itemsProductIdsList = new ArrayList<String>();
				itemsProductIdsList.add(itemId);
			}
			if (null != itemsProductIdsList) {
				for (String productId : itemsProductIdsList) {
					if (!cartItemsCountMap.containsKey(productId)) {
						cartItemsCountMap.put(productId, 1);
					} else {
						cartItemsCountMap.put(productId,
								cartItemsCountMap.get(productId) + 1);
					}
				}
			}
		} else {
			ShoppingOrder activeShoppingOrder = ShoppingOrderLocalServiceUtil.getUserActiveOrder(
					themeDisplay.getUserId(),
					themeDisplay.getScopeGroupId(),
					themeDisplay.getCompanyId(),
					Boolean.FALSE);
			if (null != activeShoppingOrder) {
				List<ShoppingOrderItem> orderItemsList = ShoppingOrderItemLocalServiceUtil
						.findByOrderId(activeShoppingOrder.getOrderId());
				if (null != orderItemsList) {
					for (ShoppingOrderItem shoppingOrderItem : orderItemsList) {
						cartItemsCountMap.put(shoppingOrderItem.getProductId(),
								shoppingOrderItem.getQuantity());
						if (returnItemDetails
								&& itemId
										.equals(String
												.valueOf(shoppingOrderItem
														.getItemId()))) {
							itemToDetailProductId = shoppingOrderItem
									.getProductId();
						}
					}
				}
			}
		}
		double total = 0;
		float itemTotal = 0;
		int quantity = 0, itemQuantity = 0;
		for (Entry<String, Integer> mapEntry : cartItemsCountMap.entrySet()) {
			Document document = ShoppingCartItemUtil.getItemContent(mapEntry.getKey(),
					themeDisplay.getScopeGroupId());
			if (null != document) {
				Node itemListPriceNode = document
						.selectSingleNode(ShoppingCartItem.LIST_PRICE);
				Node itemSalePriceNode = document
						.selectSingleNode(ShoppingCartItem.SALE_PRICE);
				Float salePrice = !itemSalePriceNode.getStringValue().isEmpty() ? Float
						.valueOf(itemSalePriceNode.getStringValue()) : 0;
				Float listPrice = !itemListPriceNode.getStringValue().isEmpty() ? Float
						.valueOf(itemListPriceNode.getStringValue()) : 0;
				total += (salePrice != 0 ? salePrice
						* (float) mapEntry.getValue() : listPrice
						* (float) mapEntry.getValue());
				quantity += mapEntry.getValue();
				if (returnItemDetails
						&& itemToDetailProductId.equals(mapEntry.getKey())) {
					itemQuantity = mapEntry.getValue();
					itemTotal = (salePrice != 0 ? salePrice
							* (float) mapEntry.getValue() : listPrice
							* (float) mapEntry.getValue());
				}
			}
		}
		DecimalFormat totalFormat = new DecimalFormat(ShoppingCartPortletConstants.DECIMAL_FORMAT);
		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONObject cartDetailsJson = JSONFactoryUtil.createJSONObject();
		cartDetailsJson.put(ShoppingCartPortletConstants.CART_DETAILS_TOTAL,
				totalFormat.format(total));
		cartDetailsJson.put(ShoppingCartPortletConstants.CART_DETAILS_QUANTITY,
				quantity);
		jsonResponse.put(ShoppingCartPortletConstants.CART_DETAILS,
				cartDetailsJson);
		if (returnItemDetails) {
			JSONObject itemDetailsJson = JSONFactoryUtil.createJSONObject();
			itemDetailsJson.put(
					ShoppingCartPortletConstants.CART_DETAILS_TOTAL, totalFormat.format(itemTotal));
			itemDetailsJson.put(
					ShoppingCartPortletConstants.CART_DETAILS_QUANTITY,
					itemQuantity);
			jsonResponse.put(ShoppingCartPortletConstants.ITEM_DETAILS,
					itemDetailsJson);
		}
		printJsonResponse(jsonResponse.toString(), null, response);
	}
	
	/*
     * 
     *
     * */
	
	
	
	private float getItemPrice(String productId, long groupId) {
	    Document document = ShoppingCartItemUtil.getItemContent(productId, groupId);
	    if(document != null) {
	        Node itemListPriceNode = document
                    .selectSingleNode(ShoppingCartItem.LIST_PRICE);
            Node itemSalePriceNode = document
                    .selectSingleNode(ShoppingCartItem.SALE_PRICE);
            Float salePrice = !itemSalePriceNode.getStringValue().isEmpty() ? Float
                    .valueOf(itemSalePriceNode.getStringValue()) : 0;
            Float listPrice = !itemListPriceNode.getStringValue().isEmpty() ? Float
                    .valueOf(itemListPriceNode.getStringValue()) : 0;
            return salePrice != 0? salePrice : listPrice;
	    }
	    return 0;
	}

	private List<String> getOrderItemsIdsFromSession(PortletRequest request) {
		List<String> orderItemsIdsList = null;
		PortletSession portletSession = request.getPortletSession();
		if(null != portletSession){
			String cartItemsStrVal = (String)portletSession.getAttribute(ShoppingCartPortletConstants.COOKIE_SHOPPING_CART_ITEMS);
			if (null != cartItemsStrVal && !cartItemsStrVal.isEmpty()) {
				orderItemsIdsList = (Arrays.asList(StringUtil.split(cartItemsStrVal, StringPool.COMMA)));
			}
		}
		return orderItemsIdsList;
	}

	private void removeOrderItemsIdsFromSession(PortletRequest request){
		PortletSession portletSession = request.getPortletSession();
		portletSession.setAttribute(ShoppingCartPortletConstants.COOKIE_SHOPPING_CART_ITEMS, StringPool.BLANK);
	}
	
	private void setSessionOrderItemsIds(PortletRequest request, String value){
		PortletSession portletSession = request.getPortletSession();
		portletSession.setAttribute(ShoppingCartPortletConstants.COOKIE_SHOPPING_CART_ITEMS, value);
	}
	
	private void setSessionOrderItemPrice(PortletRequest request, String itemId, float price) {
	    PortletSession portletSession = request.getPortletSession();
	    String value = "";
	    if(portletSession != null) {
	        Object current = portletSession.getAttribute(ShoppingCartPortletConstants.COOKIE_SHOPPING_CART_PRICES);
	        if(current != null) {
	            value = (String) current;
	            value += ",";
	        }
	    }
	    value += String.format("%s=%s", itemId, price);
	    portletSession.setAttribute(ShoppingCartPortletConstants.COOKIE_SHOPPING_CART_PRICES, value);
	}
	
	private Map<String,Float> getSessionOrderItemPrices(PortletRequest request) {
	    PortletSession portletSession = request.getPortletSession();
	    if(portletSession != null) {
	        Map<String, Float> map = new HashMap<String,Float>();
	        String values = (String) portletSession.getAttribute(ShoppingCartPortletConstants.COOKIE_SHOPPING_CART_PRICES);
	        String[] prices = values.split(",");
	        for(String price : prices) {
	            String[] item = price.split("=");
	            map.put(item[0], Float.parseFloat(item[1]));
	        }
	        return map;
	    } else {
	        return null;
	    }
	}
	
	private boolean isValidItemId(long groupId, String itemId) {
		boolean valid = false;
		try {
			JournalArticleLocalServiceUtil.getArticle(groupId, itemId);
			valid = true;
		} catch (PortalException e) {
			logger.equals(e);
		} catch (SystemException e) {
			logger.error(e);
		}
		return valid;
	}
	
	private void printJsonResponse(String jsonStr, String statusCode,
			ResourceResponse response) {
		if (null == statusCode)
			statusCode = String.valueOf(HttpServletResponse.SC_OK);
		response.setProperty(ResourceResponse.HTTP_STATUS_CODE, statusCode);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			logger.error(e);
		}
		if (null != out && !out.checkError()) {
			response.setContentType(ContentTypes.APPLICATION_JSON);
			out.print(jsonStr);
			out.flush();
			out.close();
		}
	}

	private static final Log logger = LogFactoryUtil.getLog(ShoppingCartPortlet.class);
	
	// Error response messages
	private static final String ERROR_MISSING_ITEM_ID_MESSAGE = "The item id must be specified.";
	private static final String ERROR_ADDING_ITEM_TO_CART_MESSAGE = "Error while adding the item to the cart.";
	private static final String ERROR_REMOVING_ITEM_FROM_CART_MESSAGE = "Error while removing the item from the cart.";
	private static final String ERROR_UPDATING_CART_ITEM_MESSAGE = "Error while updating the cart item.";
	private static final String ERROR_ITEM_ID_NOT_VALID_MESSAGE = "The specified itemId is not valid.";
	private static final String ERROR_BAD_PARAMETER_VALUE = "Bad value for parameter: %S.";
	private static final String ERROR_SERVING_RESOURCE = "Error while serving resource. Command: %S. %S";
	// Log messages
	private static final String ERROR_ADDING_ITEM_TO_CART_LOG = "Error while adding an item with id %S. %S";
	private static final String ERROR_REMOVING_ITEM_FROM_CART_LOG = "Error while removing cart item with id: %S. %S";
	private static final String ERROR_UPDATING_CART_ITEM_LOG = "Error while updating cart item with id: %S. %S";
	private static final String ERROR_ITEM_ID_NOT_VALID_LOG = "The item id with id %S was not found.";
	private static final String ERROR_CHECKING_PORTLET_CONFIG = "Error while checking the portlet configuration. %S";
	private static final String ERROR_CHECKOUT_MISSING_PORTLET_CONFIG = "\n PORTLET CONFIGURATION IS NOT COMPLETE. Some information in the portlet configuration is missing. \n";
	
	
}
