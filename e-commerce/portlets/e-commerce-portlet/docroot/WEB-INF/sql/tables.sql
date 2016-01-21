create table rivetlogic_ecommerce_ShoppingOrder (
	orderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	orderStatus VARCHAR(75) null,
	customerEmail VARCHAR(75) null,
	customerName VARCHAR(75) null,
	customerPhone VARCHAR(75) null,
	shippingAddress1 VARCHAR(75) null,
	shippingAddress2 VARCHAR(75) null,
	shippingCity VARCHAR(75) null,
	shippingPostalCode VARCHAR(75) null,
	shippingStateProvince VARCHAR(75) null,
	shippingCountry VARCHAR(75) null
);

create table rivetlogic_ecommerce_ShoppingOrderItem (
	itemId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	productId VARCHAR(75) null,
	orderId LONG,
	quantity INTEGER
);