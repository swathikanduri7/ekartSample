package com.swaraj.shop.store.controller.shoppingCart.facade.v1;

import java.util.Optional;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.shoppingcart.ReadableShoppingCart;

public interface ShoppingCartFacade {
	
	ReadableShoppingCart get(Optional<String> cart, Long customerId, MerchantStore store, Language language);

}
