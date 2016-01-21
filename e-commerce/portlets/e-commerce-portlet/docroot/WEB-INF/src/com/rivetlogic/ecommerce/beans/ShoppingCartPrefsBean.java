/**
 * Copyright (C) 2016 Rivet Logic Corporation.
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
 * this program; if not, see <http://www.gnu.org/licenses/>.
 */

package com.rivetlogic.ecommerce.beans;

import com.liferay.portal.kernel.util.StringPool;
import com.rivetlogic.ecommerce.util.PreferencesKeys;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

/**
 * @author isaiulate
 */

public class ShoppingCartPrefsBean {

	private String senderEmail;
	private String senderName;
	private String customerNotifSubjectTemplate;
	private String customerNotifBodyTemplate;
	private String storeNotifSubjectTemplate;
	private String storeNotifBodyTemplate;
	private String storeEmail;
	private String storeName;
	
    public ShoppingCartPrefsBean(PortletRequest request) {
        PortletPreferences preferences = request.getPreferences();
        setFields(preferences);
    }
    
    private void setFields(PortletPreferences portletPreferences){
    	setSenderEmail(portletPreferences.getValue(PreferencesKeys.SENDER_EMAIL, StringPool.BLANK));
    	setSenderName(portletPreferences.getValue(PreferencesKeys.SENDER_NAME, StringPool.BLANK));
    	setStoreNotifSubjectTemplate(portletPreferences.getValue(PreferencesKeys.STORE_NOTIF_SUBJECT_TEMPLATE, StringPool.BLANK));
    	setStoreNotifBodyTemplate(portletPreferences.getValue(PreferencesKeys.STORE_NOTIF_BODY_TEMPLATE, StringPool.BLANK));
    	setCustomerNotifSubjectTemplate(portletPreferences.getValue(PreferencesKeys.CUSTOMER_NOTIF_SUBJECT_TEMPLATE, StringPool.BLANK));
    	setCustomerNotifBodyTemplate(portletPreferences.getValue(PreferencesKeys.CUSTOMER_NOTIF_BODY_TEMPLATE, StringPool.BLANK));
    	setStoreEmail(portletPreferences.getValue(PreferencesKeys.STORE_EMAIL, StringPool.BLANK));
    	setStoreName(portletPreferences.getValue(PreferencesKeys.STORE_NAME, StringPool.BLANK));
    }
    
	public String getStoreEmail() {
		return storeEmail;
	}

	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getCustomerNotifSubjectTemplate() {
		return customerNotifSubjectTemplate;
	}

	public void setCustomerNotifSubjectTemplate(String customerNotifSubjectTemplate) {
		this.customerNotifSubjectTemplate = customerNotifSubjectTemplate;
	}

	public String getCustomerNotifBodyTemplate() {
		return customerNotifBodyTemplate;
	}

	public void setCustomerNotifBodyTemplate(String customerNotifBodyTemplate) {
		this.customerNotifBodyTemplate = customerNotifBodyTemplate;
	}

	public String getStoreNotifSubjectTemplate() {
		return storeNotifSubjectTemplate;
	}

	public void setStoreNotifSubjectTemplate(String storeNotifSubjectTemplate) {
		this.storeNotifSubjectTemplate = storeNotifSubjectTemplate;
	}

	public String getStoreNotifBodyTemplate() {
		return storeNotifBodyTemplate;
	}

	public void setStoreNotifBodyTemplate(String storeNotifBodyTemplate) {
		this.storeNotifBodyTemplate = storeNotifBodyTemplate;
	}
    
}
