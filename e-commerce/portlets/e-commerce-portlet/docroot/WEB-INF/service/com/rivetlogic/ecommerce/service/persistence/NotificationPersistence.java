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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.ecommerce.model.Notification;

/**
 * The persistence interface for the notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author isaiulate
 * @see NotificationPersistenceImpl
 * @see NotificationUtil
 * @generated
 */
public interface NotificationPersistence extends BasePersistence<Notification> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificationUtil} to access the notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the notifications where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the matching notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.ecommerce.model.Notification> findByOrderId(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notifications where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @return the range of matching notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.ecommerce.model.Notification> findByOrderId(
		long orderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notifications where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.ecommerce.model.Notification> findByOrderId(
		long orderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification
	* @throws com.rivetlogic.ecommerce.NoSuchNotificationException if a matching notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.Notification findByOrderId_First(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchNotificationException;

	/**
	* Returns the first notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification, or <code>null</code> if a matching notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.Notification fetchByOrderId_First(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification
	* @throws com.rivetlogic.ecommerce.NoSuchNotificationException if a matching notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.Notification findByOrderId_Last(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchNotificationException;

	/**
	* Returns the last notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification, or <code>null</code> if a matching notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.Notification fetchByOrderId_Last(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notifications before and after the current notification in the ordered set where orderId = &#63;.
	*
	* @param notificationPK the primary key of the current notification
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification
	* @throws com.rivetlogic.ecommerce.NoSuchNotificationException if a notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.Notification[] findByOrderId_PrevAndNext(
		com.rivetlogic.ecommerce.service.persistence.NotificationPK notificationPK,
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchNotificationException;

	/**
	* Removes all the notifications where orderId = &#63; from the database.
	*
	* @param orderId the order ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notifications where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the number of matching notifications
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the notification in the entity cache if it is enabled.
	*
	* @param notification the notification
	*/
	public void cacheResult(
		com.rivetlogic.ecommerce.model.Notification notification);

	/**
	* Caches the notifications in the entity cache if it is enabled.
	*
	* @param notifications the notifications
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.ecommerce.model.Notification> notifications);

	/**
	* Creates a new notification with the primary key. Does not add the notification to the database.
	*
	* @param notificationPK the primary key for the new notification
	* @return the new notification
	*/
	public com.rivetlogic.ecommerce.model.Notification create(
		com.rivetlogic.ecommerce.service.persistence.NotificationPK notificationPK);

	/**
	* Removes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationPK the primary key of the notification
	* @return the notification that was removed
	* @throws com.rivetlogic.ecommerce.NoSuchNotificationException if a notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.Notification remove(
		com.rivetlogic.ecommerce.service.persistence.NotificationPK notificationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchNotificationException;

	public com.rivetlogic.ecommerce.model.Notification updateImpl(
		com.rivetlogic.ecommerce.model.Notification notification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notification with the primary key or throws a {@link com.rivetlogic.ecommerce.NoSuchNotificationException} if it could not be found.
	*
	* @param notificationPK the primary key of the notification
	* @return the notification
	* @throws com.rivetlogic.ecommerce.NoSuchNotificationException if a notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.Notification findByPrimaryKey(
		com.rivetlogic.ecommerce.service.persistence.NotificationPK notificationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.ecommerce.NoSuchNotificationException;

	/**
	* Returns the notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificationPK the primary key of the notification
	* @return the notification, or <code>null</code> if a notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.ecommerce.model.Notification fetchByPrimaryKey(
		com.rivetlogic.ecommerce.service.persistence.NotificationPK notificationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the notifications.
	*
	* @return the notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.ecommerce.model.Notification> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @return the range of notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.ecommerce.model.Notification> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.ecommerce.model.impl.NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.ecommerce.model.Notification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the notifications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notifications.
	*
	* @return the number of notifications
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}