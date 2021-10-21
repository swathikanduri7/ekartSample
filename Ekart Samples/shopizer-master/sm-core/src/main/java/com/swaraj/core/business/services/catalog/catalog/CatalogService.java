package com.swaraj.core.business.services.catalog.catalog;

import org.springframework.data.domain.Page;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.catalog.catalog.Catalog;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;

import java.util.Optional;

public interface CatalogService extends SalesManagerEntityService<Long, Catalog> {
	
	
	/**
	 * Creates a new Catalog
	 * @param store
	 * @return Catalog
	 * @throws ServiceException
	 */
	Catalog saveOrUpdate(Catalog catalog, MerchantStore store);

	Optional<Catalog> getById(Long catalogId, MerchantStore store);

	Optional<Catalog> getByCode(String code, MerchantStore store);
	
	/**
	 * Get a list of Catalog associated with a MarketPlace
	 * @param marketPlace
	 * @return List<Catalog>
	 * @throws ServiceException
	 */
	Page<Catalog> getCatalogs(MerchantStore store, Language language, String name, int page, int count);
	
	/**
	 * Delete a Catalog and related objects
	 */
	void delete(Catalog catalog) throws ServiceException;
	
	boolean existByCode(String code, MerchantStore store);

}
