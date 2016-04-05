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

package com.rivetlogic.ecommerce.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.ecommerce.model.Notification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Notification in entity cache.
 *
 * @author isaiulate
 * @see Notification
 * @generated
 */
public class NotificationCacheModel implements CacheModel<Notification>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{orderId=");
		sb.append(orderId);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", body=");
		sb.append(body);
		sb.append(", sender=");
		sb.append(sender);
		sb.append(", recipients=");
		sb.append(recipients);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Notification toEntityModel() {
		NotificationImpl notificationImpl = new NotificationImpl();

		notificationImpl.setOrderId(orderId);

		if (subject == null) {
			notificationImpl.setSubject(StringPool.BLANK);
		}
		else {
			notificationImpl.setSubject(subject);
		}

		if (body == null) {
			notificationImpl.setBody(StringPool.BLANK);
		}
		else {
			notificationImpl.setBody(body);
		}

		if (sender == null) {
			notificationImpl.setSender(StringPool.BLANK);
		}
		else {
			notificationImpl.setSender(sender);
		}

		if (recipients == null) {
			notificationImpl.setRecipients(StringPool.BLANK);
		}
		else {
			notificationImpl.setRecipients(recipients);
		}

		notificationImpl.resetOriginalValues();

		return notificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		orderId = objectInput.readLong();
		subject = objectInput.readUTF();
		body = objectInput.readUTF();
		sender = objectInput.readUTF();
		recipients = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(orderId);

		if (subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (body == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(body);
		}

		if (sender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sender);
		}

		if (recipients == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(recipients);
		}
	}

	public long orderId;
	public String subject;
	public String body;
	public String sender;
	public String recipients;
}