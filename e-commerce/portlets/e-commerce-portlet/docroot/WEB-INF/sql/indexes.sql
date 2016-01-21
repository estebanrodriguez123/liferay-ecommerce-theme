create index IX_95618E52 on rivetlogic_ecommerce_ShoppingOrder (orderStatus);
create index IX_419C748C on rivetlogic_ecommerce_ShoppingOrder (orderStatus, userId);

create index IX_5D3DEB28 on rivetlogic_ecommerce_ShoppingOrderItem (orderId);
create index IX_D4121772 on rivetlogic_ecommerce_ShoppingOrderItem (orderId, productId);