package com.swaraj.shop.store.controller.product.facade;

import java.util.List;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.catalog.product.attribute.optionset.PersistableProductOptionSet;
import com.swaraj.shop.model.catalog.product.attribute.optionset.ReadableProductOptionSet;

public interface ProductOptionSetFacade {
	
	
	ReadableProductOptionSet get(Long id, MerchantStore store, Language language);
	boolean exists(String code, MerchantStore store);
	List<ReadableProductOptionSet> list(MerchantStore store, Language language);
	List<ReadableProductOptionSet> list(MerchantStore store, Language language, String type);
	void create(PersistableProductOptionSet optionSet, MerchantStore store, Language language);
	void update(Long id, PersistableProductOptionSet optionSet, MerchantStore store, Language language);
	void delete(Long id, MerchantStore store);
	
	
	

}
