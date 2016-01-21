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

package com.rivetlogic.ecommerce.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.ecommerce.model.ShoppingOrderItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingOrderItem in entity cache.
 *
 * @author isaiulate
 * @see ShoppingOrderItem
 * @generated
 */
public class ShoppingOrderItemCacheModel implements CacheModel<ShoppingOrderItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{itemId=");
		sb.append(itemId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", orderId=");
		sb.append(orderId);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ShoppingOrderItem toEntityModel() {
		ShoppingOrderItemImpl shoppingOrderItemImpl = new ShoppingOrderItemImpl();

		shoppingOrderItemImpl.setItemId(itemId);

		if (createDate == Long.MIN_VALUE) {
			shoppingOrderItemImpl.setCreateDate(null);
		}
		else {
			shoppingOrderItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			shoppingOrderItemImpl.setModifiedDate(null);
		}
		else {
			shoppingOrderItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (productId == null) {
			shoppingOrderItemImpl.setProductId(StringPool.BLANK);
		}
		else {
			shoppingOrderItemImpl.setProductId(productId);
		}

		shoppingOrderItemImpl.setOrderId(orderId);
		shoppingOrderItemImpl.setQuantity(quantity);

		shoppingOrderItemImpl.resetOriginalValues();

		return shoppingOrderItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		productId = objectInput.readUTF();
		orderId = objectInput.readLong();
		quantity = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (productId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productId);
		}

		objectOutput.writeLong(orderId);
		objectOutput.writeInt(quantity);
	}

	public long itemId;
	public long createDate;
	public long modifiedDate;
	public String productId;
	public long orderId;
	public int quantity;
}