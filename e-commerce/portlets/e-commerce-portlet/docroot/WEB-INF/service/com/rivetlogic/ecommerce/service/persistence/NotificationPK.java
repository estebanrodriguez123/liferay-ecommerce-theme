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

package com.rivetlogic.ecommerce.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author isaiulate
 * @generated
 */
public class NotificationPK implements Comparable<NotificationPK>, Serializable {
	public long orderId;
	public String recipients;

	public NotificationPK() {
	}

	public NotificationPK(long orderId, String recipients) {
		this.orderId = orderId;
		this.recipients = recipients;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	@Override
	public int compareTo(NotificationPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (orderId < pk.orderId) {
			value = -1;
		}
		else if (orderId > pk.orderId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = recipients.compareTo(pk.recipients);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationPK)) {
			return false;
		}

		NotificationPK pk = (NotificationPK)obj;

		if ((orderId == pk.orderId) && (recipients.equals(pk.recipients))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(orderId) + String.valueOf(recipients)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("orderId");
		sb.append(StringPool.EQUAL);
		sb.append(orderId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("recipients");
		sb.append(StringPool.EQUAL);
		sb.append(recipients);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}