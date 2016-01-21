
function initCart(link){
	$.post(link+"?p_p_id=shoppingcart_WAR_ecommerceportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&_shoppingcart_WAR_ecommerceportlet_cmd=getCartInfo")
	.done(function( data ) {
		var result = JSON.parse(data); 
    	var items= result.cartDetails.quantity;
		if(items==0){
			var badge = $("#cart_badge");
			badge.html("");
			badge.hide();
		}else{
			var badge = $("#cart_badge");
			badge.html(items);
			badge.show();
		}
 	});
}

function createSuccessMessage(element){
	var div = document.createElement("div");
	div.className = "added_message alert alert-success";
	var p =  document.createElement("p"); 
	var message = document.createTextNode("Item successfully added.");
	p.appendChild(message);  
	div.appendChild(p); 
	element.append(div); 
	$(div).fadeOut(1000);
}


function addToCart(id,product,price,link,that){
	$.post(link+"?p_p_id=shoppingcart_WAR_ecommerceportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-2&p_p_col_count=2&_shoppingcart_WAR_ecommerceportlet_itemName="+product+"&_shoppingcart_WAR_ecommerceportlet_cmd=addCartItem&_shoppingcart_WAR_ecommerceportlet_itemId="+id)
		.done(function( data ) {
			var result = JSON.parse(data); 
	    	var items= result.cartDetails.quantity;
			if(items==0){
				var badge = $("#cart_badge");
				badge.html("");
				badge.hide();
			}else{
				var badge = $("#cart_badge");
				badge.html(items);
				badge.show();
			}
				createSuccessMessage($(that).parent());
	 	});
}
