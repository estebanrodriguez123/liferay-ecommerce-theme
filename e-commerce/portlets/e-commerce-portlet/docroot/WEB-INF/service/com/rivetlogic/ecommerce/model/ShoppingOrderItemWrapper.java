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
 * This class is a wrapper for {@link ShoppingOrderItem}.
 * </p>
 *
 * @author isaiulate
 * @see ShoppingOrderItem
 * @generated
 */
public class ShoppingOrderItemWrapper implements ShoppingOrderItem,
	ModelWrapper<ShoppingOrderItem> {
	public ShoppingOrderItemWrapper(ShoppingOrderItem shoppingOrderItem) {
		_shoppingOrderItem = shoppingOrderItem;
	}

	@Override
	public Class<?> getModelClass() {
		return ShoppingOrderItem.class;
	}

	@Override
	public String getModelClassName() {
		return ShoppingOrderItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("productId", getProductId());
		attributes.put("orderId", getOrderId());
		attributes.put("quantity", getQuantity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String productId = (String)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}
	}

	/**
	* Returns the primary key of this Shopping Order Item.
	*
	* @return the primary key of this Shopping Order Item
	*/
	@Override
	public long getPrimaryKey() {
		return _shoppingOrderItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Shopping Order Item.
	*
	* @param primaryKey the primary key of this Shopping Order Item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_shoppingOrderItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this Shopping Order Item.
	*
	* @return the item ID of this Shopping Order Item
	*/
	@Override
	public long getItemId() {
		return _shoppingOrderItem.getItemId();
	}

	/**
	* Sets the item ID of this Shopping Order Item.
	*
	* @param itemId the item ID of this Shopping Order Item
	*/
	@Override
	public void setItemId(long itemId) {
		_shoppingOrderItem.setItemId(itemId);
	}

	/**
	* Returns the create date of this Shopping Order Item.
	*
	* @return the create date of this Shopping Order Item
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _shoppingOrderItem.getCreateDate();
	}

	/**
	* Sets the create date of this Shopping Order Item.
	*
	* @param createDate the create date of this Shopping Order Item
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_shoppingOrderItem.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this Shopping Order Item.
	*
	* @return the modified date of this Shopping Order Item
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _shoppingOrderItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this Shopping Order Item.
	*
	* @param modifiedDate the modified date of this Shopping Order Item
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_shoppingOrderItem.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the product ID of this Shopping Order Item.
	*
	* @return the product ID of this Shopping Order Item
	*/
	@Override
	public java.lang.String getProductId() {
		return _shoppingOrderItem.getProductId();
	}

	/**
	* Sets the product ID of this Shopping Order Item.
	*
	* @param productId the product ID of this Shopping Order Item
	*/
	@Override
	public void setProductId(java.lang.String productId) {
		_shoppingOrderItem.setProductId(productId);
	}

	/**
	* Returns the order ID of this Shopping Order Item.
	*
	* @return the order ID of this Shopping Order Item
	*/
	@Override
	public long getOrderId() {
		return _shoppingOrderItem.getOrderId();
	}

	/**
	* Sets the order ID of this Shopping Order Item.
	*
	* @param orderId the order ID of this Shopping Order Item
	*/
	@Override
	public void setOrderId(long orderId) {
		_shoppingOrderItem.setOrderId(orderId);
	}

	/**
	* Returns the quantity of this Shopping Order Item.
	*
	* @return the quantity of this Shopping Order Item
	*/
	@Override
	public int getQuantity() {
		return _shoppingOrderItem.getQuantity();
	}

	/**
	* Sets the quantity of this Shopping Order Item.
	*
	* @param quantity the quantity of this Shopping Order Item
	*/
	@Override
	public void setQuantity(int quantity) {
		_shoppingOrderItem.setQuantity(quantity);
	}

	@Override
	public boolean isNew() {
		return _shoppingOrderItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_shoppingOrderItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _shoppingOrderItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_shoppingOrderItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _shoppingOrderItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingOrderItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shoppingOrderItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingOrderItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_shoppingOrderItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_shoppingOrderItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingOrderItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShoppingOrderItemWrapper((ShoppingOrderItem)_shoppingOrderItem.clone());
	}

	@Override
	public int compareTo(
		com.rivetlogic.ecommerce.model.ShoppingOrderItem shoppingOrderItem) {
		return _shoppingOrderItem.compareTo(shoppingOrderItem);
	}

	@Override
	public int hashCode() {
		return _shoppingOrderItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.ecommerce.model.ShoppingOrderItem> toCacheModel() {
		return _shoppingOrderItem.toCacheModel();
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem toEscapedModel() {
		return new ShoppingOrderItemWrapper(_shoppingOrderItem.toEscapedModel());
	}

	@Override
	public com.rivetlogic.ecommerce.model.ShoppingOrderItem toUnescapedModel() {
		return new ShoppingOrderItemWrapper(_shoppingOrderItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shoppingOrderItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _shoppingOrderItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingOrderItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingOrderItemWrapper)) {
			return false;
		}

		ShoppingOrderItemWrapper shoppingOrderItemWrapper = (ShoppingOrderItemWrapper)obj;

		if (Validator.equals(_shoppingOrderItem,
					shoppingOrderItemWrapper._shoppingOrderItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ShoppingOrderItem getWrappedShoppingOrderItem() {
		return _shoppingOrderItem;
	}

	@Override
	public ShoppingOrderItem getWrappedModel() {
		return _shoppingOrderItem;
	}

	@Override
	public void resetOriginalValues() {
		_shoppingOrderItem.resetOriginalValues();
	}

	private ShoppingOrderItem _shoppingOrderItem;
}