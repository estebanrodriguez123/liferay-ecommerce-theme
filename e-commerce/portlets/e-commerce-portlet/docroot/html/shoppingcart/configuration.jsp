<%--
/** 
* Copyright (C) 2016 Rivet Logic Corporation. 
* 
* This program is free software; you can redistribute it and/or 
* modify it under the terms of the GNU General Public License 
* as published by the Free Software Foundation; version 3 
* of the License. 
* 
* This program is distributed in the hope that it will be useful, 
* but WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
* GNU General Public License for more details. 
* 
* You should have received a copy of the GNU General Public License 
* along with this program; ff not, see <http://www.gnu.org/licenses/>. 
*/
--%>

<%@include file="/html/init.jsp" %>
<portlet:defineObjects />

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<%

String storeEmailAddress = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.STORE_EMAIL, StringPool.BLANK));
String storeName = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.STORE_NAME, StringPool.BLANK));
String storeEmailSubject = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.STORE_NOTIF_SUBJECT_TEMPLATE, StringPool.BLANK));
String storeEmailContent = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.STORE_NOTIF_BODY_TEMPLATE, StringPool.BLANK));

String customerEmailSubject = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.CUSTOMER_NOTIF_SUBJECT_TEMPLATE, StringPool.BLANK));
String customerEmailContent = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.CUSTOMER_NOTIF_BODY_TEMPLATE, StringPool.BLANK));

String checkoutSuccessMessage = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.CHECKOUT_SUCCESS_MESSAGE, StringPool.BLANK));
String checkoutErrorMessage = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.CHECKOUT_ERROR_MESSAGE, StringPool.BLANK));
String cartIsEmptyMessage = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.CART_EMPTY_MESSAGE, StringPool.BLANK));
%>

<liferay-ui:tabs names="Store Email,Customer Email,Messages" refresh="false" tabsValues="Store Email,Customer Email,Messages" type="pills">
    <liferay-ui:section>
		<aui:form action="<%= configurationURL %>" method="post" name="<portlet:namespace />fm">
		    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		    <aui:input name="preferences--storeEmail--" label="email-label" type="text" value="<%= storeEmailAddress %>" />
		    <aui:input name="preferences--storeName--" label="name-label" type="text" value="<%= storeName %>" />
			<aui:input name="preferences--storeEmailSubject--" label="email-subject-label" type="text" value="<%= storeEmailSubject %>" />
			<liferay-ui:input-editor name="storeEmailEditor" initMethod="initStoreEmailEditor" editorImpl="liferay"/>
			<aui:input name="preferences--storeEmailContent--" id="store-email-content" type="hidden" value="<%= storeEmailContent %>" />
		    <aui:button-row>
		        <aui:button type="submit" onclick="getStoreEmailText()"/>
		    </aui:button-row>
		</aui:form>
    </liferay-ui:section>
    <liferay-ui:section>
		<aui:form action="<%= configurationURL %>" method="post" name="<portlet:namespace />fm">
		    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:input name="preferences--customerEmailSubject--" label="email-subject-label" type="text" value="<%= customerEmailSubject %>" />
			<liferay-ui:input-editor name="customerEmailEditor" initMethod="initCustomerEmailEditor"/>
			<aui:input name="preferences--customerEmailContent--" id="customer-email-content" type="hidden" value="<%= customerEmailContent %>" />
		    <aui:button-row>
		        <aui:button type="submit" onclick="getCustomerEmailText()"/>
		    </aui:button-row>
		</aui:form>
    </liferay-ui:section>
    <liferay-ui:section>
		<aui:form action="<%= configurationURL %>" method="post" name="<portlet:namespace />fm">
		    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:input name="preferences--checkoutSuccessMessage--" label="checkout-success-label" type="text" value="<%= checkoutSuccessMessage %>" />
			<aui:input name="preferences--checkoutErrorMessage--" label="checkout-error-label" type="text" value="<%= checkoutErrorMessage %>" />
			<aui:input name="preferences--cartEmptyMessage--" label="empty-cart-message-label" type="text" value="<%= cartIsEmptyMessage %>" />
		    <aui:button-row>
		        <aui:button type="submit"/>
		    </aui:button-row>
		</aui:form>
    </liferay-ui:section>
</liferay-ui:tabs>


<script type="text/javascript">

function <portlet:namespace />initStoreEmailEditor() {
	return '<%=UnicodeFormatter.toString(storeEmailContent)%>';
}

function <portlet:namespace />initCustomerEmailEditor() {
	return '<%=UnicodeFormatter.toString(customerEmailContent)%>';
}

function getStoreEmailText() {
	var pns = '<portlet:namespace />';
	document.getElementById(pns + 'store-email-content').value = window[pns+'storeEmailEditor'].getHTML();
}

function getCustomerEmailText() {
	var pns = '<portlet:namespace />';
	document.getElementById(pns + 'customer-email-content').value = window[pns+'customerEmailEditor'].getHTML();
}

</script>