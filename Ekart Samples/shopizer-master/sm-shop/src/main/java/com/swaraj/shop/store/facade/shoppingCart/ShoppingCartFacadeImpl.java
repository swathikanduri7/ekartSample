package com.swaraj.shop.store.facade.shoppingCart;

import java.util.Optional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swaraj.core.business.services.customer.CustomerService;
import com.swaraj.shop.model.shoppingcart.ReadableShoppingCart;
import com.swaraj.shop.store.api.exception.ResourceNotFoundException;
import com.swaraj.shop.store.api.exception.ServiceRuntimeException;
import com.swaraj.shop.store.controller.shoppingCart.facade.v1.ShoppingCartFacade;
import com.swaraj.core.business.services.shoppingcart.ShoppingCartService;
import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.shoppingcart.ShoppingCart;

@Service("shoppingCartFacadev1")
public class ShoppingCartFacadeImpl implements ShoppingCartFacade {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private com.swaraj.shop.store.controller.customer.facade.CustomerFacade customerFacade;

	@Autowired
	private com.swaraj.shop.store.controller.shoppingCart.facade.ShoppingCartFacade shoppingCartFacade; // legacy
																												// facade

	@Override
	public ReadableShoppingCart get(Optional<String> cart, Long customerId, MerchantStore store, Language language) {

		Validate.notNull(customerId, "Customer id cannot be null");
		Validate.notNull(store, "MerchantStore cannot be null");
		
		try {

			// lookup customer
			Customer customer = customerService.getById(customerId);

			if (customer == null) {
				throw new ResourceNotFoundException("No Customer found for id [" + customerId + "]");
			}
			
			ShoppingCart cartModel = shoppingCartService.getShoppingCart(customer);
			
			if(cart.isPresent()) {
				cartModel = customerFacade.mergeCart(customer, cart.get(), store, language);
			}
			
			if(cartModel == null) {
				return null;
			}
			
		   ReadableShoppingCart readableCart = shoppingCartFacade.readableCart(cartModel, store, language);
		   
		   return readableCart;

		} catch (Exception e) {
			
			throw new ServiceRuntimeException(e);

		}

	}

}
