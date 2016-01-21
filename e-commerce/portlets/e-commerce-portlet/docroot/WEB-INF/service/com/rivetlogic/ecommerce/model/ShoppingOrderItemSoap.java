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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author isaiulate
 * @generated
 */
public class ShoppingOrderItemSoap implements Serializable {
	public static ShoppingOrderItemSoap toSoapModel(ShoppingOrderItem model) {
		ShoppingOrderItemSoap soapModel = new ShoppingOrderItemSoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProductId(model.getProductId());
		soapModel.setOrderId(model.getOrderId());
		soapModel.setQuantity(model.getQuantity());

		return soapModel;
	}

	public static ShoppingOrderItemSoap[] toSoapModels(
		ShoppingOrderItem[] models) {
		ShoppingOrderItemSoap[] soapModels = new ShoppingOrderItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ShoppingOrderItemSoap[][] toSoapModels(
		ShoppingOrderItem[][] models) {
		ShoppingOrderItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ShoppingOrderItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ShoppingOrderItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ShoppingOrderItemSoap[] toSoapModels(
		List<ShoppingOrderItem> models) {
		List<ShoppingOrderItemSoap> soapModels = new ArrayList<ShoppingOrderItemSoap>(models.size());

		for (ShoppingOrderItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ShoppingOrderItemSoap[soapModels.size()]);
	}

	public ShoppingOrderItemSoap() {
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long pk) {
		setItemId(pk);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getProductId() {
		return _productId;
	}

	public void setProductId(String productId) {
		_productId = productId;
	}

	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_orderId = orderId;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	private long _itemId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _productId;
	private long _orderId;
	private int _quantity;
}