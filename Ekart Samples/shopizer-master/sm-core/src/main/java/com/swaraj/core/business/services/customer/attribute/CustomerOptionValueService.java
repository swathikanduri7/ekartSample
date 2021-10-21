package com.swaraj.core.business.services.customer.attribute;

import java.util.List;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.customer.attribute.CustomerOptionValue;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;


public interface CustomerOptionValueService extends SalesManagerEntityService<Long, CustomerOptionValue> {



	List<CustomerOptionValue> listByStore(MerchantStore store, Language language)
			throws ServiceException;

	void saveOrUpdate(CustomerOptionValue entity) throws ServiceException;

	CustomerOptionValue getByCode(MerchantStore store, String optionValueCode);



}
