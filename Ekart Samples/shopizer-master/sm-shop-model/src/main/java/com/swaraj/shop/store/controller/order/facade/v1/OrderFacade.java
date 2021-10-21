package com.swaraj.shop.store.controller.order.facade.v1;

import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.order.Order;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.order.v1.ReadableOrderConfirmation;

public interface OrderFacade {
	
	ReadableOrderConfirmation orderConfirmation(Order order, Customer customer, MerchantStore store, Language language);

}
