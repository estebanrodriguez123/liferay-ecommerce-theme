<%@ include file="/html/init.jsp" %>

<%
	long groupId = themeDisplay.getScopeGroupId();
%>

<%-- <aui:container>
	<aui:form>
		<aui:select name="statusFilter">
			<aui:option>Placed</aui:option>
			<aui:option>Completed</aui:option>
			<aui:option>Shipped</aui:option>
		</aui:select>
	</aui:form>
</aui:container> --%>

<liferay-ui:search-container emptyResultsMessage="no-orders-found">
	<liferay-ui:search-container-results 
		results="<%= ShoppingOrderLocalServiceUtil.findByGroupId(groupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ShoppingOrderLocalServiceUtil.countByGroupId(groupId) %>" />
	<liferay-ui:search-container-row className="com.rivetlogic.ecommerce.model.ShoppingOrder" modelVar="order">
		<liferay-ui:search-container-column-text name="order-id" property="orderId" />
		<liferay-ui:search-container-column-text name="order-status" property="orderStatus" />
		<liferay-ui:search-container-column-date name="order-last-updated" property="modifiedDate" />
		<liferay-ui:search-container-column-text name="order-customer-name" property="customerName" />
		<liferay-ui:search-container-column-text name="order-customer-email" property="customerEmail" />
		<liferay-ui:search-container-column-jsp  name="order-actions" path="/html/orders/actions.jsp" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
