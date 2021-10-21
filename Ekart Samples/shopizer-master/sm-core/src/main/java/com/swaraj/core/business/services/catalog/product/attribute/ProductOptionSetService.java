package com.swaraj.core.business.services.catalog.product.attribute;

import java.util.List;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.catalog.product.attribute.ProductOptionSet;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;

public interface ProductOptionSetService extends SalesManagerEntityService<Long, ProductOptionSet> {

	List<ProductOptionSet> listByStore(MerchantStore store, Language language)
			throws ServiceException;


	ProductOptionSet getById(MerchantStore store, Long optionId, Language lang);
	ProductOptionSet getCode(MerchantStore store, String code);
	List<ProductOptionSet> getByProductType (Long productTypeId, MerchantStore store, Language lang);


}
