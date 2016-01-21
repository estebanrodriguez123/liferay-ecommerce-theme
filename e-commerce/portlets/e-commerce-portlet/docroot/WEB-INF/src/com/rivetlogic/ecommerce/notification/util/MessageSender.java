/**
 * Copyright (C) 2016 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses/>.
 */

package com.rivetlogic.ecommerce.notification.util;

import com.liferay.portal.kernel.util.StringUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * @author isaiulate
 */

public class MessageSender {
	
	private InternetAddress sender;
	private InternetAddress [] recipients;
	private boolean isHTMLFormat;
	private String body;
	private String subject;
	
	
	public void setSender(InternetAddress sender) {
		this.sender = sender;
	}
	
	public void setSender(String sender) throws AddressException {
		this.sender = new InternetAddress(sender);
	}
	
	public void setRecipients(InternetAddress[] recipients) {
		this.recipients = recipients;
	}
	
	public void setRecipients(String recipientsStr) throws AddressException {
		this.recipients = InternetAddress.parse(recipientsStr);
	}
	
	public void setHTMLFormat(boolean isHTMLFormat) {
		this.isHTMLFormat = isHTMLFormat;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public InternetAddress getSender(){
		return sender;
	}
	public InternetAddress[] getRecipients(){
		return recipients;
	}
	public Boolean isHTMLFormat(){
		return isHTMLFormat;
	}
	
	public String getBody(){
		return body;
	}
	public String getSubject(){
		return subject;
	}
	
	public void processBody(String[] oldSubs, String[] newSubs){
		this.body = StringUtil.replace(this.body, oldSubs, newSubs);
	}
	
	public void processSubject(String[] oldSubs, String[] newSubs){
		this.subject = StringUtil.replace(this.subject, oldSubs, newSubs);
	}
}
