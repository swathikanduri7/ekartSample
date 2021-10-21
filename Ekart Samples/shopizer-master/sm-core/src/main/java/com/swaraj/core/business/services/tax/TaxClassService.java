package com.swaraj.core.business.services.tax;

import java.util.List;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.tax.taxclass.TaxClass;

public interface TaxClassService extends SalesManagerEntityService<Long, TaxClass> {

	List<TaxClass> listByStore(MerchantStore store) throws ServiceException;

	TaxClass getByCode(String code) throws ServiceException;

	TaxClass getByCode(String code, MerchantStore store)
			throws ServiceException;
	
	boolean exists(String code, MerchantStore store) throws ServiceException;
	
	TaxClass saveOrUpdate(TaxClass taxClass) throws ServiceException;
	

}
