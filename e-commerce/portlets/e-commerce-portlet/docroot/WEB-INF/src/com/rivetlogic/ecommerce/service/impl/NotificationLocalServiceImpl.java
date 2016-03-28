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

package com.rivetlogic.ecommerce.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.rivetlogic.ecommerce.NoSuchNotificationException;
import com.rivetlogic.ecommerce.model.Notification;
import com.rivetlogic.ecommerce.service.base.NotificationLocalServiceBaseImpl;
import com.rivetlogic.ecommerce.service.persistence.NotificationPK;

import java.util.List;

/**
 * The implementation of the notification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.ecommerce.service.NotificationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author isaiulate
 * @see com.rivetlogic.ecommerce.service.base.NotificationLocalServiceBaseImpl
 * @see com.rivetlogic.ecommerce.service.NotificationLocalServiceUtil
 */
public class NotificationLocalServiceImpl
	extends NotificationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.ecommerce.service.NotificationLocalServiceUtil} to access the notification local service.
	 */
    
    public Notification create(long orderId, String recipients) {
        return notificationPersistence.create(new NotificationPK(orderId, recipients));
    }
    
    public void storeNotification(Notification notification) throws SystemException {
        notificationPersistence.update(notification);
    }
    
    public void removeByOrderId(long orderId) throws SystemException {
        List<Notification> list = findByOrderId(orderId);
        for(Notification n : list) {
            notificationPersistence.remove(n);
        }
    }
    
    public List<Notification> findByOrderId(long orderId) throws SystemException {
        return notificationPersistence.findByOrderId(orderId);
    }
    
}