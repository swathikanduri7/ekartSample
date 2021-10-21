package com.swaraj.core.business.services.catalog.catalog;

import org.springframework.data.domain.Page;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.catalog.catalog.Catalog;
import com.swaraj.core.model.catalog.catalog.CatalogCategoryEntry;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;

public interface CatalogEntryService extends SalesManagerEntityService<Long, CatalogCategoryEntry> {
	
	
	void add (CatalogCategoryEntry entry, Catalog catalog);
	
	void remove (CatalogCategoryEntry catalogEntry) throws ServiceException;
	
	Page<CatalogCategoryEntry> list(Catalog catalog, MerchantStore store, Language language, String name, int page, int count);

}
