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
<%@page import="com.rivetlogic.ecommerce.beans.ShoppingCartPrefsBean" %>
<portlet:defineObjects />

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<%
ShoppingCartPrefsBean shoppingCartPrefsBean = (ShoppingCartPrefsBean)request.getAttribute("portletConfig");
%>
<div class="alert alert-danger <%= (shoppingCartPrefsBean.isCartPrefsValid() ? "hidden" : StringPool.BLANK) %>" id="error-message">
  <strong>All</strong> configuration fields are required. Looks like you did not enter all of them!
</div>

<liferay-ui:tabs names="Store Email,Customer Email,Messages" refresh="false" tabsValues="Store Email,Customer Email,Messages" type="pills">
	<aui:form action="<%= configurationURL %>" method="post" name="fm">
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	    <liferay-ui:section>
			    <aui:input name="preferences--storeEmail--" label="email-label" type="text" value="<%= shoppingCartPrefsBean.getStoreEmail() %>"  required="true"/>
			    <aui:input name="preferences--storeName--" label="name-label" type="text" value="<%= shoppingCartPrefsBean.getStoreName() %>" required="true"/>
				<aui:input name="preferences--storeEmailSubject--" label="email-subject-label" type="text" value="<%= shoppingCartPrefsBean.getStoreNotifSubjectTemplate() %>" required="true"/>
				<liferay-ui:input-editor name="storeEmailEditor" initMethod="initStoreEmailEditor" editorImpl="liferay"/>
				<aui:input name="preferences--storeEmailContent--" id="store-email-content" type="hidden" value="<%= shoppingCartPrefsBean.getStoreNotifBodyTemplate() %>" required="true"/>
	    </liferay-ui:section>
	    <liferay-ui:section>
			<aui:input name="preferences--customerEmailSubject--" label="email-subject-label" type="text" value="<%= shoppingCartPrefsBean.getCustomerNotifSubjectTemplate() %>" required="true"/>
			<liferay-ui:input-editor name="customerEmailEditor" initMethod="initCustomerEmailEditor"/>
			<aui:input name="preferences--customerEmailContent--" id="customer-email-content" type="hidden" value="<%= shoppingCartPrefsBean.getCustomerNotifBodyTemplate() %>" required="true"/>
	    </liferay-ui:section>
	    <liferay-ui:section>
			<aui:input name="preferences--checkoutSuccessMessage--" label="checkout-success-label" type="text" value="<%= shoppingCartPrefsBean.getCheckoutSuccessMessage() %>" required="true"/>
			<aui:input name="preferences--checkoutErrorMessage--" label="checkout-error-label" type="text" value="<%= shoppingCartPrefsBean.getCheckoutErrorMessage() %>" required="true"/>
			<aui:input name="preferences--cartEmptyMessage--" label="empty-cart-message-label" type="text" value="<%= shoppingCartPrefsBean.getCartIsEmptyMessage() %>" required="true"/>
	    </liferay-ui:section>
 		<aui:button-row>
		   	<aui:button type="submit" onclick="getEmailsText()"/>
		</aui:button-row>
    </aui:form>
</liferay-ui:tabs>

<script type="text/javascript">

function <portlet:namespace />initStoreEmailEditor() {
	return '<%=UnicodeFormatter.toString(shoppingCartPrefsBean.getStoreNotifBodyTemplate())%>';
}

function <portlet:namespace />initCustomerEmailEditor() {
	return '<%=UnicodeFormatter.toString(shoppingCartPrefsBean.getCustomerNotifBodyTemplate())%>';
}

function getEmailsText() {
	var pns = '<portlet:namespace />';
	document.getElementById(pns + 'customer-email-content').value = window[pns+'customerEmailEditor'].getHTML();
	document.getElementById(pns + 'store-email-content').value = window[pns+'storeEmailEditor'].getHTML();
	var invalidFiels = document.getElementsByClassName('error-field'); 
	if(invalidFiels && invalidFiels.length > 0){
		document.getElementById('error-message').className = 'alert alert-danger'; 
	}
}

</script>