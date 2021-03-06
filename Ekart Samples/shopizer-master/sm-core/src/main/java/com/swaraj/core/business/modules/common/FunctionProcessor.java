package com.swaraj.core.business.modules.common;

import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.merchant.MerchantStore;

public interface FunctionProcessor<K> {
	
	void process(String event, K entity, MerchantStore store);
	void process(String event, K entity, Customer customer, MerchantStore store);

}
 