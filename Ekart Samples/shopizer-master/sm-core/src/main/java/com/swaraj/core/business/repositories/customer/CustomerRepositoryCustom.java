package com.swaraj.core.business.repositories.customer;

import com.swaraj.core.model.customer.CustomerCriteria;
import com.swaraj.core.model.customer.CustomerList;
import com.swaraj.core.model.merchant.MerchantStore;



public interface CustomerRepositoryCustom {

	CustomerList listByStore(MerchantStore store, CustomerCriteria criteria);
	

}
