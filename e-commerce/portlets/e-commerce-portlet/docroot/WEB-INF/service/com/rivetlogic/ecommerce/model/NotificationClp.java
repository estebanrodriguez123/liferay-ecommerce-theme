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

import com.rivetlogic.ecommerce.service.ClpSerializer;
import com.rivetlogic.ecommerce.service.NotificationLocalServiceUtil;
import com.rivetlogic.ecommerce.service.persistence.NotificationPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author isaiulate
 */
public class NotificationClp extends BaseModelImpl<Notification>
	implements Notification {
	public NotificationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Notification.class;
	}

	@Override
	public String getModelClassName() {
		return Notification.class.getName();
	}

	@Override
	public NotificationPK getPrimaryKey() {
		return new NotificationPK(_orderId, _recipients);
	}

	@Override
	public void setPrimaryKey(NotificationPK primaryKey) {
		setOrderId(primaryKey.orderId);
		setRecipients(primaryKey.recipients);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new NotificationPK(_orderId, _recipients);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((NotificationPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orderId", getOrderId());
		attributes.put("subject", getSubject());
		attributes.put("body", getBody());
		attributes.put("sender", getSender());
		attributes.put("recipients", getRecipients());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		String sender = (String)attributes.get("sender");

		if (sender != null) {
			setSender(sender);
		}

		String recipients = (String)attributes.get("recipients");

		if (recipients != null) {
			setRecipients(recipients);
		}
	}

	@Override
	public long getOrderId() {
		return _orderId;
	}

	@Override
	public void setOrderId(long orderId) {
		_orderId = orderId;

		if (_notificationRemoteModel != null) {
			try {
				Class<?> clazz = _notificationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderId", long.class);

				method.invoke(_notificationRemoteModel, orderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubject() {
		return _subject;
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;

		if (_notificationRemoteModel != null) {
			try {
				Class<?> clazz = _notificationRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_notificationRemoteModel, subject);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBody() {
		return _body;
	}

	@Override
	public void setBody(String body) {
		_body = body;

		if (_notificationRemoteModel != null) {
			try {
				Class<?> clazz = _notificationRemoteModel.getClass();

				Method method = clazz.getMethod("setBody", String.class);

				method.invoke(_notificationRemoteModel, body);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSender() {
		return _sender;
	}

	@Override
	public void setSender(String sender) {
		_sender = sender;

		if (_notificationRemoteModel != null) {
			try {
				Class<?> clazz = _notificationRemoteModel.getClass();

				Method method = clazz.getMethod("setSender", String.class);

				method.invoke(_notificationRemoteModel, sender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRecipients() {
		return _recipients;
	}

	@Override
	public void setRecipients(String recipients) {
		_recipients = recipients;

		if (_notificationRemoteModel != null) {
			try {
				Class<?> clazz = _notificationRemoteModel.getClass();

				Method method = clazz.getMethod("setRecipients", String.class);

				method.invoke(_notificationRemoteModel, recipients);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNotificationRemoteModel() {
		return _notificationRemoteModel;
	}

	public void setNotificationRemoteModel(BaseModel<?> notificationRemoteModel) {
		_notificationRemoteModel = notificationRemoteModel;
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

		Class<?> remoteModelClass = _notificationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_notificationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NotificationLocalServiceUtil.addNotification(this);
		}
		else {
			NotificationLocalServiceUtil.updateNotification(this);
		}
	}

	@Override
	public Notification toEscapedModel() {
		return (Notification)ProxyUtil.newProxyInstance(Notification.class.getClassLoader(),
			new Class[] { Notification.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NotificationClp clone = new NotificationClp();

		clone.setOrderId(getOrderId());
		clone.setSubject(getSubject());
		clone.setBody(getBody());
		clone.setSender(getSender());
		clone.setRecipients(getRecipients());

		return clone;
	}

	@Override
	public int compareTo(Notification notification) {
		NotificationPK primaryKey = notification.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationClp)) {
			return false;
		}

		NotificationClp notification = (NotificationClp)obj;

		NotificationPK primaryKey = notification.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{orderId=");
		sb.append(getOrderId());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", body=");
		sb.append(getBody());
		sb.append(", sender=");
		sb.append(getSender());
		sb.append(", recipients=");
		sb.append(getRecipients());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.ecommerce.model.Notification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orderId</column-name><column-value><![CDATA[");
		sb.append(getOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sender</column-name><column-value><![CDATA[");
		sb.append(getSender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recipients</column-name><column-value><![CDATA[");
		sb.append(getRecipients());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orderId;
	private String _subject;
	private String _body;
	private String _sender;
	private String _recipients;
	private BaseModel<?> _notificationRemoteModel;
	private Class<?> _clpSerializerClass = com.rivetlogic.ecommerce.service.ClpSerializer.class;
}