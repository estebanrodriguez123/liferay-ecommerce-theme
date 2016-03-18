/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.ecommerce.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rivetlogic.ecommerce.service.ClpSerializer;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author isaiulate
 */
public class ShoppingOrderClp extends BaseModelImpl<ShoppingOrder>
	implements ShoppingOrder {
	public ShoppingOrderClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ShoppingOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ShoppingOrder.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _orderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOrderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _orderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orderId", getOrderId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("orderStatus", getOrderStatus());
		attributes.put("customerEmail", getCustomerEmail());
		attributes.put("customerName", getCustomerName());
		attributes.put("customerPhone", getCustomerPhone());
		attributes.put("shippingAddress1", getShippingAddress1());
		attributes.put("shippingAddress2", getShippingAddress2());
		attributes.put("shippingCity", getShippingCity());
		attributes.put("shippingPostalCode", getShippingPostalCode());
		attributes.put("shippingStateProvince", getShippingStateProvince());
		attributes.put("shippingCountry", getShippingCountry());
		attributes.put("total", getTotal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String orderStatus = (String)attributes.get("orderStatus");

		if (orderStatus != null) {
			setOrderStatus(orderStatus);
		}

		String customerEmail = (String)attributes.get("customerEmail");

		if (customerEmail != null) {
			setCustomerEmail(customerEmail);
		}

		String customerName = (String)attributes.get("customerName");

		if (customerName != null) {
			setCustomerName(customerName);
		}

		String customerPhone = (String)attributes.get("customerPhone");

		if (customerPhone != null) {
			setCustomerPhone(customerPhone);
		}

		String shippingAddress1 = (String)attributes.get("shippingAddress1");

		if (shippingAddress1 != null) {
			setShippingAddress1(shippingAddress1);
		}

		String shippingAddress2 = (String)attributes.get("shippingAddress2");

		if (shippingAddress2 != null) {
			setShippingAddress2(shippingAddress2);
		}

		String shippingCity = (String)attributes.get("shippingCity");

		if (shippingCity != null) {
			setShippingCity(shippingCity);
		}

		String shippingPostalCode = (String)attributes.get("shippingPostalCode");

		if (shippingPostalCode != null) {
			setShippingPostalCode(shippingPostalCode);
		}

		String shippingStateProvince = (String)attributes.get(
				"shippingStateProvince");

		if (shippingStateProvince != null) {
			setShippingStateProvince(shippingStateProvince);
		}

		String shippingCountry = (String)attributes.get("shippingCountry");

		if (shippingCountry != null) {
			setShippingCountry(shippingCountry);
		}

		Double total = (Double)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}
	}

	@Override
	public long getOrderId() {
		return _orderId;
	}

	@Override
	public void setOrderId(long orderId) {
		_orderId = orderId;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderId", long.class);

				method.invoke(_shoppingOrderRemoteModel, orderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_shoppingOrderRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_shoppingOrderRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_shoppingOrderRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_shoppingOrderRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_shoppingOrderRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_shoppingOrderRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrderStatus() {
		return _orderStatus;
	}

	@Override
	public void setOrderStatus(String orderStatus) {
		_orderStatus = orderStatus;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderStatus", String.class);

				method.invoke(_shoppingOrderRemoteModel, orderStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerEmail() {
		return _customerEmail;
	}

	@Override
	public void setCustomerEmail(String customerEmail) {
		_customerEmail = customerEmail;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerEmail", String.class);

				method.invoke(_shoppingOrderRemoteModel, customerEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerName() {
		return _customerName;
	}

	@Override
	public void setCustomerName(String customerName) {
		_customerName = customerName;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerName", String.class);

				method.invoke(_shoppingOrderRemoteModel, customerName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerPhone() {
		return _customerPhone;
	}

	@Override
	public void setCustomerPhone(String customerPhone) {
		_customerPhone = customerPhone;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerPhone", String.class);

				method.invoke(_shoppingOrderRemoteModel, customerPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingAddress1() {
		return _shippingAddress1;
	}

	@Override
	public void setShippingAddress1(String shippingAddress1) {
		_shippingAddress1 = shippingAddress1;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingAddress1",
						String.class);

				method.invoke(_shoppingOrderRemoteModel, shippingAddress1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingAddress2() {
		return _shippingAddress2;
	}

	@Override
	public void setShippingAddress2(String shippingAddress2) {
		_shippingAddress2 = shippingAddress2;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingAddress2",
						String.class);

				method.invoke(_shoppingOrderRemoteModel, shippingAddress2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingCity() {
		return _shippingCity;
	}

	@Override
	public void setShippingCity(String shippingCity) {
		_shippingCity = shippingCity;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingCity", String.class);

				method.invoke(_shoppingOrderRemoteModel, shippingCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingPostalCode() {
		return _shippingPostalCode;
	}

	@Override
	public void setShippingPostalCode(String shippingPostalCode) {
		_shippingPostalCode = shippingPostalCode;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingPostalCode",
						String.class);

				method.invoke(_shoppingOrderRemoteModel, shippingPostalCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingStateProvince() {
		return _shippingStateProvince;
	}

	@Override
	public void setShippingStateProvince(String shippingStateProvince) {
		_shippingStateProvince = shippingStateProvince;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingStateProvince",
						String.class);

				method.invoke(_shoppingOrderRemoteModel, shippingStateProvince);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingCountry() {
		return _shippingCountry;
	}

	@Override
	public void setShippingCountry(String shippingCountry) {
		_shippingCountry = shippingCountry;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingCountry",
						String.class);

				method.invoke(_shoppingOrderRemoteModel, shippingCountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTotal() {
		return _total;
	}

	@Override
	public void setTotal(double total) {
		_total = total;

		if (_shoppingOrderRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setTotal", double.class);

				method.invoke(_shoppingOrderRemoteModel, total);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getShoppingOrderRemoteModel() {
		return _shoppingOrderRemoteModel;
	}

	public void setShoppingOrderRemoteModel(
		BaseModel<?> shoppingOrderRemoteModel) {
		_shoppingOrderRemoteModel = shoppingOrderRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _shoppingOrderRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_shoppingOrderRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ShoppingOrderLocalServiceUtil.addShoppingOrder(this);
		}
		else {
			ShoppingOrderLocalServiceUtil.updateShoppingOrder(this);
		}
	}

	@Override
	public ShoppingOrder toEscapedModel() {
		return (ShoppingOrder)ProxyUtil.newProxyInstance(ShoppingOrder.class.getClassLoader(),
			new Class[] { ShoppingOrder.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ShoppingOrderClp clone = new ShoppingOrderClp();

		clone.setOrderId(getOrderId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setOrderStatus(getOrderStatus());
		clone.setCustomerEmail(getCustomerEmail());
		clone.setCustomerName(getCustomerName());
		clone.setCustomerPhone(getCustomerPhone());
		clone.setShippingAddress1(getShippingAddress1());
		clone.setShippingAddress2(getShippingAddress2());
		clone.setShippingCity(getShippingCity());
		clone.setShippingPostalCode(getShippingPostalCode());
		clone.setShippingStateProvince(getShippingStateProvince());
		clone.setShippingCountry(getShippingCountry());
		clone.setTotal(getTotal());

		return clone;
	}

	@Override
	public int compareTo(ShoppingOrder shoppingOrder) {
		long primaryKey = shoppingOrder.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingOrderClp)) {
			return false;
		}

		ShoppingOrderClp shoppingOrder = (ShoppingOrderClp)obj;

		long primaryKey = shoppingOrder.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{orderId=");
		sb.append(getOrderId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", orderStatus=");
		sb.append(getOrderStatus());
		sb.append(", customerEmail=");
		sb.append(getCustomerEmail());
		sb.append(", customerName=");
		sb.append(getCustomerName());
		sb.append(", customerPhone=");
		sb.append(getCustomerPhone());
		sb.append(", shippingAddress1=");
		sb.append(getShippingAddress1());
		sb.append(", shippingAddress2=");
		sb.append(getShippingAddress2());
		sb.append(", shippingCity=");
		sb.append(getShippingCity());
		sb.append(", shippingPostalCode=");
		sb.append(getShippingPostalCode());
		sb.append(", shippingStateProvince=");
		sb.append(getShippingStateProvince());
		sb.append(", shippingCountry=");
		sb.append(getShippingCountry());
		sb.append(", total=");
		sb.append(getTotal());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.ecommerce.model.ShoppingOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orderId</column-name><column-value><![CDATA[");
		sb.append(getOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderStatus</column-name><column-value><![CDATA[");
		sb.append(getOrderStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerEmail</column-name><column-value><![CDATA[");
		sb.append(getCustomerEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerName</column-name><column-value><![CDATA[");
		sb.append(getCustomerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerPhone</column-name><column-value><![CDATA[");
		sb.append(getCustomerPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingAddress1</column-name><column-value><![CDATA[");
		sb.append(getShippingAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingAddress2</column-name><column-value><![CDATA[");
		sb.append(getShippingAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingCity</column-name><column-value><![CDATA[");
		sb.append(getShippingCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingPostalCode</column-name><column-value><![CDATA[");
		sb.append(getShippingPostalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingStateProvince</column-name><column-value><![CDATA[");
		sb.append(getShippingStateProvince());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingCountry</column-name><column-value><![CDATA[");
		sb.append(getShippingCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>total</column-name><column-value><![CDATA[");
		sb.append(getTotal());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orderId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _orderStatus;
	private String _customerEmail;
	private String _customerName;
	private String _customerPhone;
	private String _shippingAddress1;
	private String _shippingAddress2;
	private String _shippingCity;
	private String _shippingPostalCode;
	private String _shippingStateProvince;
	private String _shippingCountry;
	private double _total;
	private BaseModel<?> _shoppingOrderRemoteModel;
	private Class<?> _clpSerializerClass = com.rivetlogic.ecommerce.service.ClpSerializer.class;
}