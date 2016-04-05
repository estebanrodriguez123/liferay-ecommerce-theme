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

import com.rivetlogic.ecommerce.service.persistence.NotificationPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author isaiulate
 * @generated
 */
public class NotificationSoap implements Serializable {
	public static NotificationSoap toSoapModel(Notification model) {
		NotificationSoap soapModel = new NotificationSoap();

		soapModel.setOrderId(model.getOrderId());
		soapModel.setSubject(model.getSubject());
		soapModel.setBody(model.getBody());
		soapModel.setSender(model.getSender());
		soapModel.setRecipients(model.getRecipients());

		return soapModel;
	}

	public static NotificationSoap[] toSoapModels(Notification[] models) {
		NotificationSoap[] soapModels = new NotificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NotificationSoap[][] toSoapModels(Notification[][] models) {
		NotificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NotificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NotificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NotificationSoap[] toSoapModels(List<Notification> models) {
		List<NotificationSoap> soapModels = new ArrayList<NotificationSoap>(models.size());

		for (Notification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NotificationSoap[soapModels.size()]);
	}

	public NotificationSoap() {
	}

	public NotificationPK getPrimaryKey() {
		return new NotificationPK(_orderId, _recipients);
	}

	public void setPrimaryKey(NotificationPK pk) {
		setOrderId(pk.orderId);
		setRecipients(pk.recipients);
	}

	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_orderId = orderId;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getBody() {
		return _body;
	}

	public void setBody(String body) {
		_body = body;
	}

	public String getSender() {
		return _sender;
	}

	public void setSender(String sender) {
		_sender = sender;
	}

	public String getRecipients() {
		return _recipients;
	}

	public void setRecipients(String recipients) {
		_recipients = recipients;
	}

	private long _orderId;
	private String _subject;
	private String _body;
	private String _sender;
	private String _recipients;
}