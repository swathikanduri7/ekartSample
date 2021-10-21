package com.swaraj.shop.mapper.catalog;

import org.springframework.stereotype.Component;

import com.swaraj.core.model.catalog.catalog.Catalog;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.catalog.catalog.PersistableCatalog;

@Component
public class PersistableCatalogMapper implements Mapper<PersistableCatalog, Catalog> {

	@Override
	public Catalog convert(PersistableCatalog source, MerchantStore store, Language language) {
		Catalog c = new Catalog();
		return this.merge(source, c, store, language);
	}

	@Override
	public Catalog merge(PersistableCatalog source, Catalog destination, MerchantStore store, Language language) {
		
		
		destination.setCode(source.getCode());
		destination.setDefaultCatalog(source.isDefaultCatalog());
		destination.setId(source.getId());
		destination.setMerchantStore(store);
		destination.setVisible(source.isVisible());
		
		return destination;
	}

}
