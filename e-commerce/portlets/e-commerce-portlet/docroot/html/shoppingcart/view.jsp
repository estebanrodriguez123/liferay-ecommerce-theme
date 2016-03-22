
<%--
/**
 * Copyright (C) 2005-2016 Rivet Logic Corporation.
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
 * this program; if not, write to the Free Software Foundation, Inc., 51
 */
--%>

<%@page import="com.rivetlogic.ecommerce.beans.ShoppingCartPrefsBean"%>
<%@page import="java.util.logging.Logger"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/init.jsp" %>
<portlet:defineObjects />

<% 
List<ShoppingCartItem>cartItemsIdsList = (List<ShoppingCartItem>) request.getAttribute(ShoppingCartPortletConstants.CURRENT_ORDER_ITEMS);
String checkoutSuccessMessage = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.CHECKOUT_SUCCESS_MESSAGE, StringPool.BLANK));
String checkoutErrorMessage = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.CHECKOUT_ERROR_MESSAGE, StringPool.BLANK));
String cartIsEmptyMessage = GetterUtil.getString(portletPreferences.getValue(PreferencesKeys.CART_EMPTY_MESSAGE, StringPool.BLANK));
DecimalFormat decimalFormat = new DecimalFormat(ShoppingCartPortletConstants.DECIMAL_FORMAT);
ShoppingCartPrefsBean prefs = (ShoppingCartPrefsBean) request.getAttribute("prefs");
%>

	<portlet:actionURL name="checkout" var="checkoutURL">
		<portlet:param name="REDIRECT" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
	
	<portlet:actionURL name="checkout" var="paypalCheckoutURL">
		<portlet:param name="paypalCheckout" value="true"/>
		<portlet:param name="REDIRECT" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>

<liferay-ui:success key="success-message-checkout" message="<%=checkoutSuccessMessage %>" />
<liferay-ui:error key="error-message-checkout" message="<%=checkoutErrorMessage %>" />

<div class="row-fluid">
      	<div class="span12">
      		<div class="block">
                <div class="navbar navbar-inner block-header">
                    <div class="muted pull-left">My Cart</div>
                </div>
                <div class="block-content collapse in">
                    <div class="span12">
                    	<div class="alert alert-warning <%= (null != cartItemsIdsList && !cartItemsIdsList.isEmpty() ? "hidden" : StringPool.BLANK)%>"id="cart-empty-msg">
                    		<%=cartIsEmptyMessage %>
                    	</div>
                    	<% if(null != cartItemsIdsList && !cartItemsIdsList.isEmpty()){ %>
                        <table class="table table-striped table-hover cart-items-details">
                        	<tbody><tr>
                        		<th>Image</th>
                        		<th>Title</th>
                        		<th>Price</th>
                        		<th>Quantity</th>
                        		<th>Total</th>
                        	</tr>
                        	<% Double cartTotalPrice = 0d; %>
							<%
								for(ShoppingCartItem orderItem : cartItemsIdsList){		
							%>
                        	<tr class="item-data-row">
                        		<td class="span1"><a href="<%=orderItem.getItemLink()%>"><img src="<%= orderItem.getItemImage() %>"></a></td>
                        		<td class="span5">
                        			<a href="<%=orderItem.getItemLink()%>"><%= orderItem.getItemTitle() %></a>
                        		</td>
                        		<td class="span2">$<%= orderItem.getPrice()%></td>
                        		<td class="span2">
                        			<div class="row-fluid">
                        				<div class="span7">
											<portlet:resourceURL var="updateCartItemURL">
												<portlet:param name="<%=ShoppingCartPortletConstants.CMD%>" value="<%= ShoppingCartPortletConstants.ACTION_UPDATE_CART_ITEM %>"/>
												<portlet:param name="<%=ShoppingCartPortletConstants.WEB_CONTENT_ITEM_ID%>" value="<%= orderItem.getItemId() != 0l ? String.valueOf(orderItem.getItemId()): orderItem.getProductId()%>"/>
												<portlet:param name="<%=ShoppingCartPortletConstants.WEB_CONTENT_ITEM_COUNT%>" value=""/>
											</portlet:resourceURL>
                        					<input type="number" value="<%= orderItem.getCount()%>" min="1" data-old-value="<%= orderItem.getCount()%>" placeholder="Qnt." class="input-mini quantity-input" data-url="${updateCartItemURL}">
                        				</div>
                        				<div class="span5">
											<portlet:resourceURL var="removeCartItemURL">
												<portlet:param name="<%=ShoppingCartPortletConstants.CMD%>" value="<%= ShoppingCartPortletConstants.ACTION_REMOVE_ITEM_FROM_CART %>"/>
												<portlet:param name="<%=ShoppingCartPortletConstants.WEB_CONTENT_ITEM_ID%>" value="<%= orderItem.getItemId() != 0l ? String.valueOf(orderItem.getItemId()): orderItem.getProductId()%>"/>
											</portlet:resourceURL>
                        					<button type="submit" class="btn btn-danger btn-mini btn-delete" data-url="${removeCartItemURL}"><i class="icon-remove icon-white"></i></button>
                        				</div>
                        			</div>
                        		</td>
                        		<td class="span1 item-total-price">$<%= decimalFormat.format(orderItem.getTotalPrice())  %></td>
                        		<% cartTotalPrice += orderItem.getTotalPrice(); %>
                        	</tr>
						<%
								}
						%>
						<tr>
							<th colspan="4"></th>
							<th id="cart-total-price">$<%= decimalFormat.format(cartTotalPrice) %></th>
						</tr>
                        </tbody></table>
                        <% } %>
                    </div>
                </div>
            </div>
      	</div>
      </div>
      
<% if(null != cartItemsIdsList && !cartItemsIdsList.isEmpty()){ %>   
<div class="row-fluid" id="checkout-panel">
  <div class="span12">
    <div class="block">
      <div class="navbar navbar-inner block-header">
        <div class="muted pull-left">Shipping Information</div>
      </div>
      <div class="block-content collapse in">
        <div class="span12">
          <div class="alert alert-info"><span class="text-error">*</span> indicates required field</div>
          <liferay-ui:error key="error-information-required" message="checkout-information-required-not-found" />
          <form id="form-checkout" class="form-horizontal" method="post">
            <div class="row-fluid">
              <div class="control-group span6">
                <label for="email">Email Address <span class="text-error">*</span></label>
                <input type="text" id="email" value="jdross17-buyer@gmail.com" name="<portlet:namespace />email" placeholder="Email Address" required>
              </div>  
              <div class="control-group span6">
                <label for="name">Name <span class="text-error">*</span></label>
                <input type="text" id="name" value="Jose Ross" name="<portlet:namespace />name" placeholder="Full Name" required>
              </div>
            </div>
            <div class="row-fluid">
              <div class="control-group span6">
                <label for="street">Address line 1 <span class="text-error">*</span></label>
                <input type="text" id="street1" value="San Jose" name="<portlet:namespace />address1" placeholder="Street Address" required>
              </div>
              <div class="control-group span6">
                <label for="street">Address line 2 </label>
                <input type="text" id="street2" value="San Jose" name="<portlet:namespace />address2" placeholder="Building/Apt/Suite">
              </div>
            </div>
            <div class="row-fluid">
              <div class="control-group span6">
                <label for="city">City <span class="text-error">*</span></label>
                <input type="text" id="city" value="San Jose" name="<portlet:namespace />city" placeholder="City" required>
              </div> 
              <div class="control-group span6">
                <label for="State">State/Province <span class="text-error">*</span></label>
                <input type="text" id="State" value="San Jose" name="<portlet:namespace />stateProvince" placeholder="State" required>
              </div>  
            </div>
            <div class="row-fluid">
              <div class="control-group span6">
                <label for="postal">Postal Code</label>
                <input type="text" id="postal" value="00000" name="<portlet:namespace />postalCode" placeholder="Postal Code">
              </div> 
              <div class="control-group span6">
                <label for="country">Country <span class="text-error">*</span></label>
                <select id="country" name="<portlet:namespace />country" required>
                  <option value="" disabled selected>Select your option</option>
                  <option value="AF">Afghanistan</option>
                  <option value="AX">Åland Islands</option>
                  <option value="AL">Albania</option>
                  <option value="DZ">Algeria</option>
                  <option value="AS">American Samoa</option>
                  <option value="AD">Andorra</option>
                  <option value="AO">Angola</option>
                  <option value="AI">Anguilla</option>
                  <option value="AQ">Antarctica</option>
                  <option value="AG">Antigua and Barbuda</option>
                  <option value="AR">Argentina</option>
                  <option value="AM">Armenia</option>
                  <option value="AW">Aruba</option>
                  <option value="AU">Australia</option>
                  <option value="AT">Austria</option>
                  <option value="AZ">Azerbaijan</option>
                  <option value="BS">Bahamas</option>
                  <option value="BH">Bahrain</option>
                  <option value="BD">Bangladesh</option>
                  <option value="BB">Barbados</option>
                  <option value="BY">Belarus</option>
                  <option value="BE">Belgium</option>
                  <option value="BZ">Belize</option>
                  <option value="BJ">Benin</option>
                  <option value="BM">Bermuda</option>
                  <option value="BT">Bhutan</option>
                  <option value="BO">Bolivia, Plurinational State of</option>
                  <option value="BQ">Bonaire, Sint Eustatius and Saba</option>
                  <option value="BA">Bosnia and Herzegovina</option>
                  <option value="BW">Botswana</option>
                  <option value="BV">Bouvet Island</option>
                  <option value="BR">Brazil</option>
                  <option value="IO">British Indian Ocean Territory</option>
                  <option value="BN">Brunei Darussalam</option>
                  <option value="BG">Bulgaria</option>
                  <option value="BF">Burkina Faso</option>
                  <option value="BI">Burundi</option>
                  <option value="KH">Cambodia</option>
                  <option value="CM">Cameroon</option>
                  <option value="CA">Canada</option>
                  <option value="CV">Cape Verde</option>
                  <option value="KY">Cayman Islands</option>
                  <option value="CF">Central African Republic</option>
                  <option value="TD">Chad</option>
                  <option value="CL">Chile</option>
                  <option value="CN">China</option>
                  <option value="CX">Christmas Island</option>
                  <option value="CC">Cocos (Keeling) Islands</option>
                  <option value="CO">Colombia</option>
                  <option value="KM">Comoros</option>
                  <option value="CG">Congo</option>
                  <option value="CD">Congo, the Democratic Republic of the</option>
                  <option value="CK">Cook Islands</option>
                  <option value="CR" selected>Costa Rica</option>
                  <option value="CI">Côte d'Ivoire</option>
                  <option value="HR">Croatia</option>
                  <option value="CU">Cuba</option>
                  <option value="CW">Curaçao</option>
                  <option value="CY">Cyprus</option>
                  <option value="CZ">Czech Republic</option>
                  <option value="DK">Denmark</option>
                  <option value="DJ">Djibouti</option>
                  <option value="DM">Dominica</option>
                  <option value="DO">Dominican Republic</option>
                  <option value="EC">Ecuador</option>
                  <option value="EG">Egypt</option>
                  <option value="SV">El Salvador</option>
                  <option value="GQ">Equatorial Guinea</option>
                  <option value="ER">Eritrea</option>
                  <option value="EE">Estonia</option>
                  <option value="ET">Ethiopia</option>
                  <option value="FK">Falkland Islands (Malvinas)</option>
                  <option value="FO">Faroe Islands</option>
                  <option value="FJ">Fiji</option>
                  <option value="FI">Finland</option>
                  <option value="FR">France</option>
                  <option value="GF">French Guiana</option>
                  <option value="PF">French Polynesia</option>
                  <option value="TF">French Southern Territories</option>
                  <option value="GA">Gabon</option>
                  <option value="GM">Gambia</option>
                  <option value="GE">Georgia</option>
                  <option value="DE">Germany</option>
                  <option value="GH">Ghana</option>
                  <option value="GI">Gibraltar</option>
                  <option value="GR">Greece</option>
                  <option value="GL">Greenland</option>
                  <option value="GD">Grenada</option>
                  <option value="GP">Guadeloupe</option>
                  <option value="GU">Guam</option>
                  <option value="GT">Guatemala</option>
                  <option value="GG">Guernsey</option>
                  <option value="GN">Guinea</option>
                  <option value="GW">Guinea-Bissau</option>
                  <option value="GY">Guyana</option>
                  <option value="HT">Haiti</option>
                  <option value="HM">Heard Island and McDonald Islands</option>
                  <option value="VA">Holy See (Vatican City State)</option>
                  <option value="HN">Honduras</option>
                  <option value="HK">Hong Kong</option>
                  <option value="HU">Hungary</option>
                  <option value="IS">Iceland</option>
                  <option value="IN">India</option>
                  <option value="ID">Indonesia</option>
                  <option value="IR">Iran, Islamic Republic of</option>
                  <option value="IQ">Iraq</option>
                  <option value="IE">Ireland</option>
                  <option value="IM">Isle of Man</option>
                  <option value="IL">Israel</option>
                  <option value="IT">Italy</option>
                  <option value="JM">Jamaica</option>
                  <option value="JP">Japan</option>
                  <option value="JE">Jersey</option>
                  <option value="JO">Jordan</option>
                  <option value="KZ">Kazakhstan</option>
                  <option value="KE">Kenya</option>
                  <option value="KI">Kiribati</option>
                  <option value="KP">Korea, Democratic People's Republic of</option>
                  <option value="KR">Korea, Republic of</option>
                  <option value="KW">Kuwait</option>
                  <option value="KG">Kyrgyzstan</option>
                  <option value="LA">Lao People's Democratic Republic</option>
                  <option value="LV">Latvia</option>
                  <option value="LB">Lebanon</option>
                  <option value="LS">Lesotho</option>
                  <option value="LR">Liberia</option>
                  <option value="LY">Libya</option>
                  <option value="LI">Liechtenstein</option>
                  <option value="LT">Lithuania</option>
                  <option value="LU">Luxembourg</option>
                  <option value="MO">Macao</option>
                  <option value="MK">Macedonia, the former Yugoslav Republic of</option>
                  <option value="MG">Madagascar</option>
                  <option value="MW">Malawi</option>
                  <option value="MY">Malaysia</option>
                  <option value="MV">Maldives</option>
                  <option value="ML">Mali</option>
                  <option value="MT">Malta</option>
                  <option value="MH">Marshall Islands</option>
                  <option value="MQ">Martinique</option>
                  <option value="MR">Mauritania</option>
                  <option value="MU">Mauritius</option>
                  <option value="YT">Mayotte</option>
                  <option value="MX">Mexico</option>
                  <option value="FM">Micronesia, Federated States of</option>
                  <option value="MD">Moldova, Republic of</option>
                  <option value="MC">Monaco</option>
                  <option value="MN">Mongolia</option>
                  <option value="ME">Montenegro</option>
                  <option value="MS">Montserrat</option>
                  <option value="MA">Morocco</option>
                  <option value="MZ">Mozambique</option>
                  <option value="MM">Myanmar</option>
                  <option value="NA">Namibia</option>
                  <option value="NR">Nauru</option>
                  <option value="NP">Nepal</option>
                  <option value="NL">Netherlands</option>
                  <option value="NC">New Caledonia</option>
                  <option value="NZ">New Zealand</option>
                  <option value="NI">Nicaragua</option>
                  <option value="NE">Niger</option>
                  <option value="NG">Nigeria</option>
                  <option value="NU">Niue</option>
                  <option value="NF">Norfolk Island</option>
                  <option value="MP">Northern Mariana Islands</option>
                  <option value="NO">Norway</option>
                  <option value="OM">Oman</option>
                  <option value="PK">Pakistan</option>
                  <option value="PW">Palau</option>
                  <option value="PS">Palestinian Territory, Occupied</option>
                  <option value="PA">Panama</option>
                  <option value="PG">Papua New Guinea</option>
                  <option value="PY">Paraguay</option>
                  <option value="PE">Peru</option>
                  <option value="PH">Philippines</option>
                  <option value="PN">Pitcairn</option>
                  <option value="PL">Poland</option>
                  <option value="PT">Portugal</option>
                  <option value="PR">Puerto Rico</option>
                  <option value="QA">Qatar</option>
                  <option value="RE">Réunion</option>
                  <option value="RO">Romania</option>
                  <option value="RU">Russian Federation</option>
                  <option value="RW">Rwanda</option>
                  <option value="BL">Saint Barthélemy</option>
                  <option value="SH">Saint Helena, Ascension and Tristan da Cunha</option>
                  <option value="KN">Saint Kitts and Nevis</option>
                  <option value="LC">Saint Lucia</option>
                  <option value="MF">Saint Martin (French part)</option>
                  <option value="PM">Saint Pierre and Miquelon</option>
                  <option value="VC">Saint Vincent and the Grenadines</option>
                  <option value="WS">Samoa</option>
                  <option value="SM">San Marino</option>
                  <option value="ST">Sao Tome and Principe</option>
                  <option value="SA">Saudi Arabia</option>
                  <option value="SN">Senegal</option>
                  <option value="RS">Serbia</option>
                  <option value="SC">Seychelles</option>
                  <option value="SL">Sierra Leone</option>
                  <option value="SG">Singapore</option>
                  <option value="SX">Sint Maarten (Dutch part)</option>
                  <option value="SK">Slovakia</option>
                  <option value="SI">Slovenia</option>
                  <option value="SB">Solomon Islands</option>
                  <option value="SO">Somalia</option>
                  <option value="ZA">South Africa</option>
                  <option value="GS">South Georgia and the South Sandwich Islands</option>
                  <option value="SS">South Sudan</option>
                  <option value="ES">Spain</option>
                  <option value="LK">Sri Lanka</option>
                  <option value="SD">Sudan</option>
                  <option value="SR">Suriname</option>
                  <option value="SJ">Svalbard and Jan Mayen</option>
                  <option value="SZ">Swaziland</option>
                  <option value="SE">Sweden</option>
                  <option value="CH">Switzerland</option>
                  <option value="SY">Syrian Arab Republic</option>
                  <option value="TW">Taiwan, Province of China</option>
                  <option value="TJ">Tajikistan</option>
                  <option value="TZ">Tanzania, United Republic of</option>
                  <option value="TH">Thailand</option>
                  <option value="TL">Timor-Leste</option>
                  <option value="TG">Togo</option>
                  <option value="TK">Tokelau</option>
                  <option value="TO">Tonga</option>
                  <option value="TT">Trinidad and Tobago</option>
                  <option value="TN">Tunisia</option>
                  <option value="TR">Turkey</option>
                  <option value="TM">Turkmenistan</option>
                  <option value="TC">Turks and Caicos Islands</option>
                  <option value="TV">Tuvalu</option>
                  <option value="UG">Uganda</option>
                  <option value="UA">Ukraine</option>
                  <option value="AE">United Arab Emirates</option>
                  <option value="GB">United Kingdom</option>
                  <option value="US">United States</option>
                  <option value="UM">United States Minor Outlying Islands</option>
                  <option value="UY">Uruguay</option>
                  <option value="UZ">Uzbekistan</option>
                  <option value="VU">Vanuatu</option>
                  <option value="VE">Venezuela, Bolivarian Republic of</option>
                  <option value="VN">Viet Nam</option>
                  <option value="VG">Virgin Islands, British</option>
                  <option value="VI">Virgin Islands, U.S.</option>
                  <option value="WF">Wallis and Futuna</option>
                  <option value="EH">Western Sahara</option>
                  <option value="YE">Yemen</option>
                  <option value="ZM">Zambia</option>
                  <option value="ZW">Zimbabwe</option>
                </select>
              </div>  
            </div>
            <div class="row-fluid">
              <div class="control-group span6">
                <label for="phone">Phone</label>
                <input type="text" id="phone" value="22222222" name="<portlet:namespace />phone" placeholder="Phone">
              </div> 
            </div>
            <div class="row-fluid">
              <div class="control-group span12">
                <div class="controls">
                  <button type="button" class="btn btn-primary pull-right" id="btn-checkout">Checkout</button>
                  <c:if test="${prefs.isPaypalEnabled()}">
                  	<button type="button" class="btn btn-primary pull-right" id="btn-paypal-checkout">Paypal Checkout</button>
                  </c:if>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<% } %>

<aui:script use="shopping-cart">
    A.ShoppingCart.setPortletNamespace('${pns}');
    A.all('.btn-delete').on('click', function(event){
    	A.ShoppingCart.removeCartItem(event.currentTarget);
    });
    A.all('.quantity-input').on('change', function(event){
    	A.ShoppingCart.updateCartItem(event.currentTarget);
    });
    A.one('#btn-checkout').on('click', function(event){
    	A.ShoppingCart.doCheckout('${checkoutURL}');
    });
    <c:if test="${prefs.isPaypalEnabled()}">
    A.one('#btn-paypal-checkout').on('click', function(event){
    	A.ShoppingCart.doCheckout('${paypalCheckoutURL}');
    });
    </c:if>
</aui:script>