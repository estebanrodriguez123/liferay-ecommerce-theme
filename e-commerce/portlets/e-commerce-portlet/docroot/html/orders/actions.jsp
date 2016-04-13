<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);	
	ShoppingOrder order = (ShoppingOrder) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:choose>
		<c:when test="<%= order.getOrderStatus().equals(OrderStatusEnum.PLACED.toString()) %>">
			<portlet:actionURL name="updateOrderStatus" var="updatePayedURL">
				<portlet:param name="orderId" value="<%= Long.toString(order.getOrderId()) %>" />
				<portlet:param name="newStatus" value="<%= OrderStatusEnum.PAID.toString() %>" />
			</portlet:actionURL>
			<liferay-ui:icon image="check" message="set-order-payed" url="<%= updatePayedURL %>"  />
		</c:when>
		<c:when test="<%= order.getOrderStatus().equals(OrderStatusEnum.PAID.toString()) %>">
			<portlet:actionURL name="updateOrderStatus" var="updateProcessingURL">
				<portlet:param name="orderId" value="<%= Long.toString(order.getOrderId()) %>" />
				<portlet:param name="newStatus" value="<%= OrderStatusEnum.PROCESSING.toString() %>" />
			</portlet:actionURL>
			<liferay-ui:icon image="check" message="set-order-processing" url="<%= updateProcessingURL %>"  />
			<portlet:actionURL name="updateOrderStatus" var="updateShippedURL">
				<portlet:param name="orderId" value="<%= Long.toString(order.getOrderId()) %>" />
				<portlet:param name="newStatus" value="<%= OrderStatusEnum.SHIPPED.toString() %>" />
			</portlet:actionURL>
			<liferay-ui:icon image="check" message="set-order-shipped" url="<%= updateShippedURL %>"  />
		</c:when>
		<c:when test="<%= order.getOrderStatus().equals(OrderStatusEnum.PROCESSING.toString()) %>">
			<portlet:actionURL name="updateOrderStatus" var="updateProcessingURL">
				<portlet:param name="orderId" value="<%= Long.toString(order.getOrderId()) %>" />
				<portlet:param name="newStatus" value="<%= OrderStatusEnum.SHIPPED.toString() %>" />
			</portlet:actionURL>
			<liferay-ui:icon image="check" message="set-order-shipped" url="<%= updateProcessingURL %>"  />
		</c:when>
	</c:choose>
</liferay-ui:icon-menu>