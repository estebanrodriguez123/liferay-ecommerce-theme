<%@ include file="/html/init.jsp" %>

<%
	long groupId = themeDisplay.getScopeGroupId();
	String field = ParamUtil.getString(request, "orderByCol", "modifiedDate");
	String ordering = ParamUtil.getString(request, "orderByType", "desc");
	OrderByComparator comparator = OrderByComparatorFactoryUtil
	        .create(ShoppingCartPortletConstants.ORDER_TABLE_NAME, field, ordering.equals("asc"));
	ordering = ordering.equals("asc")? "desc" : "asc";
%>

<liferay-ui:success key="success" message="order-status-update-success" />

<liferay-ui:search-container emptyResultsMessage="no-orders-found" orderByType="<%= ordering %>">
	<liferay-ui:search-container-results 
		results="<%= ShoppingOrderLocalServiceUtil.findByGroupId(groupId, searchContainer.getStart(), searchContainer.getEnd(), comparator) %>"
		total="<%= ShoppingOrderLocalServiceUtil.countByGroupId(groupId) %>" />
	<liferay-ui:search-container-row className="com.rivetlogic.ecommerce.model.ShoppingOrder" modelVar="order">
		<liferay-ui:search-container-column-text name="order-id" property="orderId" />
		<liferay-ui:search-container-column-text name="order-status" orderable="true" orderableProperty="orderStatus" >
			<liferay-ui:icon-help message="help-status-${ order.orderStatus.toLowerCase() }">
				<liferay-ui:message key="order-status-${ order.orderStatus.toLowerCase() }"/>
			</liferay-ui:icon-help>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-date name="order-last-updated" property="modifiedDate" orderable="true" orderableProperty="modifiedDate" />
		<liferay-ui:search-container-column-text name="order-customer-name" property="customerName" />
		<liferay-ui:search-container-column-text name="order-customer-email" property="customerEmail" />
		<liferay-ui:search-container-column-jsp  name="order-actions" path="/html/orders/actions.jsp" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
