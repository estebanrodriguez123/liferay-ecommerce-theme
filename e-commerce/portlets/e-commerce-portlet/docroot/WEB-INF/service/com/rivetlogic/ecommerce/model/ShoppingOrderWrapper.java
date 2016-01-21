/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.rivetlogic.ecommerce.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingOrder}.
 * </p>
 *
 * @author isaiulate
 * @see ShoppingOrder
 * @generated
 */
public class ShoppingOrderWrapper implements ShoppingOrder,
	ModelWrapper<ShoppingOrder> {
	public ShoppingOrderWrapper(ShoppingOrder shoppingOrder) {
		_shoppingOrder = shoppingOrder;
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
	}

	/**
	* Returns the primary key of this Shopping Order.
	*
	* @return the primary key of this Shopping Order
	*/
	@Override
	public long getPrimaryKey() {
		return _shoppingOrder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Shopping Order.
	*
	* @param primaryKey the primary key of this Shopping Order
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_shoppingOrder.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the order ID of this Shopping Order.
	*
	* @return the order ID of this Shopping Order
	*/
	@Override
	public long getOrderId() {
		return _shoppingOrder.getOrderId();
	}

	/**
	* Sets the order ID of this Shopping Order.
	*
	* @param orderId the order ID of this Shopping Order
	*/
	@Override
	public void setOrderId(long orderId) {
		_shoppingOrder.setOrderId(orderId);
	}

	/**
	* Returns the group ID of this Shopping Order.
	*
	* @return the group ID of this Shopping Order
	*/
	@Override
	public long getGroupId() {
		return _shoppingOrder.getGroupId();
	}

	/**
	* Sets the group ID of this Shopping Order.
	*
	* @param groupId the group ID of this Shopping Order
	*/
	@Override
	public void setGroupId(long groupId) {
		_shoppingOrder.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this Shopping Order.
	*
	* @return the company ID of this Shopping Order
	*/
	@Override
	public long getCompanyId() {
		return _shoppingOrder.getCompanyId();
	}

	/**
	* Sets the company ID of this Shopping Order.
	*
	* @param companyId the company ID of this Shopping Order
	*/
	@Override
	public void setCompanyId(long companyId) {
		_shoppingOrder.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this Shopping Order.
	*
	* @return the user ID of this Shopping Order
	*/
	@Override
	public long getUserId() {
		return _shoppingOrder.getUserId();
	}

	/**
	* Sets the user ID of this Shopping Order.
	*
	* @param userId the user ID of this Shopping Order
	*/
	@Override
	public void setUserId(long userId) {
		_shoppingOrder.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Shopping Order.
	*
	* @return the user uuid of this Shopping Order
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrder.getUserUuid();
	}

	/**
	* Sets the user uuid of this Shopping Order.
	*
	* @param userUuid the user uuid of this Shopping Order
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_shoppingOrder.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this Shopping Order.
	*
	* @return the user name of this Shopping Order
	*/
	@Override
	public java.lang.String getUserName() {
		return _shoppingOrder.getUserName();
	}

	/**
	* Sets the user name of this Shopping Order.
	*
	* @param userName the user name of this Shopping Order
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_shoppingOrder.setUserName(userName);
	}

	/**
	* Returns the create date of this Shopping Order.
	*
	* @return the create date of this Shopping Order
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _shoppingOrder.getCreateDate();
	}

	/**
	* Sets the create date of this Shopping Order.
	*
	* @param createDate the create date of this Shopping Order
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_shoppingOrder.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this Shopping Order.
	*
	* @return the modified date of this Shopping Order
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _shoppingOrder.getModifiedDate();
	}

	/**
	* Sets the modified date of this Shopping Order.
	*
	* @param modifiedDate the modified date of this Shopping Order
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_shoppingOrder.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the order status of this Shopping Order.
	*
	* @return the order status of this Shopping Order
	*/
	@Override
	public java.lang.String getOrderStatus() {
		return _shoppingOrder.getOrderStatus();
	}

	/**
	* Sets the order status of this Shopping Order.
	*
	* @param orderStatus the order status of this Shopping Order
	*/
	@Override
	public void setOrderStatus(java.lang.String orderStatus) {
		_shoppingOrder.setOrderStatus(orderStatus);
	}

	/**
	* Returns the customer email of this Shopping Order.
	*
	* @return the customer email of this Shopping Order
	*/
	@Override
	public java.lang.String getCustomerEmail() {
		return _shoppingOrder.getCustomerEmail();
	}

	/**
	* Sets the customer email of this Shopping Order.
	*
	* @param customerEmail the customer email of this Shopping Order
	*/
	@Override
	public void setCustomerEmail(java.lang.String customerEmail) {
		_shoppingOrder.setCustomerEmail(customerEmail);
	}

	/**
	* Returns the customer name of this Shopping Order.
	*
	* @return the customer name of this Shopping Order
	*/
	@Override
	public java.lang.String getCustomerName() {
		return _shoppingOrder.getCustomerName();
	}

	/**
	* Sets the customer name of this Shopping Order.
	*
	* @param customerName the customer name of this Shopping Order
	*/
	@Override
	public void setCustomerName(java.lang.String customerName) {
		_shoppingOrder.setCustomerName(customerName);
	}

	/**
	* Returns the customer phone of this Shopping Order.
	*
	* @return the customer phone of this Shopping Order
	*/
	@Override
	public java.lang.String getCustomerPhone() {
		return _shoppingOrder.getCustomerPhone();
	}

	/**
	* Sets the customer phone of this Shopping Order.
	*
	* @param customerPhone the customer phone of this Shopping Order
	*/
	@Override
	public void setCustomerPhone(java.lang.String customerPhone) {
		_shoppingOrder.setCustomerPhone(customerPhone);
	}

	/**
	* Returns the shipping address1 of this Shopping Order.
	*
	* @return the shipping address1 of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingAddress1() {
		return _shoppingOrder.getShippingAddress1();
	}

	/**
	* Sets the shipping address1 of this Shopping Order.
	*
	* @param shippingAddress1 the shipping address1 of this Shopping Order
	*/
	@Override
	public void setShippingAddress1(java.lang.String shippingAddress1) {
		_shoppingOrder.setShippingAddress1(shippingAddress1);
	}

	/**
	* Returns the shipping address2 of this Shopping Order.
	*
	* @return the shipping address2 of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingAddress2() {
		return _shoppingOrder.getShippingAddress2();
	}

	/**
	* Sets the shipping address2 of this Shopping Order.
	*
	* @param shippingAddress2 the shipping address2 of this Shopping Order
	*/
	@Override
	public void setShippingAddress2(java.lang.String shippingAddress2) {
		_shoppingOrder.setShippingAddress2(shippingAddress2);
	}

	/**
	* Returns the shipping city of this Shopping Order.
	*
	* @return the shipping city of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingCity() {
		return _shoppingOrder.getShippingCity();
	}

	/**
	* Sets the shipping city of this Shopping Order.
	*
	* @param shippingCity the shipping city of this Shopping Order
	*/
	@Override
	public void setShippingCity(java.lang.String shippingCity) {
		_shoppingOrder.setShippingCity(shippingCity);
	}

	/**
	* Returns the shipping postal code of this Shopping Order.
	*
	* @return the shipping postal code of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingPostalCode() {
		return _shoppingOrder.getShippingPostalCode();
	}

	/**
	* Sets the shipping postal code of this Shopping Order.
	*
	* @param shippingPostalCode the shipping postal code of this Shopping Order
	*/
	@Override
	public void setShippingPostalCode(java.lang.String shippingPostalCode) {
		_shoppingOrder.setShippingPostalCode(shippingPostalCode);
	}

	/**
	* Returns the shipping state province of this Shopping Order.
	*
	* @return the shipping state province of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingStateProvince() {
		return _shoppingOrder.getShippingStateProvince();
	}

	/**
	* Sets the shipping state province of this Shopping Order.
	*
	* @param shippingStateProvince the shipping state province of this Shopping Order
	*/
	@Override
	public void setShippingStateProvince(java.lang.String shippingStateProvince) {
		_shoppingOrder.setShippingStateProvince(shippingStateProvince);
	}

	/**
	* Returns the shipping country of this Shopping Order.
	*
	* @return the shipping country of this Shopping Order
	*/
	@Override
	public java.lang.String getShippingCountry() {
		return _shoppingOrder.getShippingCountry();
	}

	/**
	* Sets the shipping country of this Shopping Order.
	*
	* @param shippingCountry the shipping country of this Shopping Order
	*/
	@Override
	public void setShippingCountry(java.lang.String shippingCountry) {
		_shoppingOrder.setShippingCountry(shippingCountry);
	}

	@Override
	public boolean isNew() {
		return _shoppingOrder.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_shoppingOrder.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _shoppingOrder.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_shoppingOrder.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _shoppingOrder.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingOrder.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shoppingOrder.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingOrder.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_shoppingOrder.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_shoppingOrder.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingOrder.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShoppingOrderWrapper((ShoppingOrder)_shoppingOrder.clone());
	}

	@Override
	public int compareTo(
		com.rivetlogic.ecommerce.model.ShoppingOrder shoppingOrder) {
		return _shoppingOrder.compareTo(shoppingOrder);
	}

	@Override
	public int hashCode() {
		return _shoppingOrder.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.ecommerce.model.ShoppingOrder> toCacheModel() {
		return _shoppingOrder.toCacheModel();
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder toEscapedModel() {
		return new ShoppingOrderWrapper(_shoppingOrder.toEscapedModel());
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrder toUnescapedModel() {
		return new ShoppingOrderWrapper(_shoppingOrder.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shoppingOrder.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _shoppingOrder.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingOrder.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingOrderWrapper)) {
			return false;
		}

		ShoppingOrderWrapper shoppingOrderWrapper = (ShoppingOrderWrapper)obj;

		if (Validator.equals(_shoppingOrder, shoppingOrderWrapper._shoppingOrder)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ShoppingOrder getWrappedShoppingOrder() {
		return _shoppingOrder;
	}

	@Override
	public ShoppingOrder getWrappedModel() {
		return _shoppingOrder;
	}

	@Override
	public void resetOriginalValues() {
		_shoppingOrder.resetOriginalValues();
	}

	private ShoppingOrder _shoppingOrder;
}