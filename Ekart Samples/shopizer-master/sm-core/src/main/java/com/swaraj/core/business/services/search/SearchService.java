package com.swaraj.core.business.services.search;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.catalog.product.Product;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.search.SearchKeywords;
import com.swaraj.core.model.search.SearchResponse;

public interface SearchService {
	
	/**
	 * The indexing service for products. The index service must be invoked when a product is
	 * created or updated
	 * @param store
	 * @param product
	 * @throws ServiceException
	 */
	void index(MerchantStore store, Product product) throws ServiceException;

	/**
	 * Deletes an index in the appropriate language. Must be invoked when a product is deleted
	 * @param store
	 * @param product
	 * @throws ServiceException
	 */
	void deleteIndex(MerchantStore store, Product product)
			throws ServiceException;

	/**
	 * Similar keywords based on a a series of characters. Used in the auto-complete
	 * functionality
	 * @param collectionName
	 * @param jsonString
	 * @param entriesCount
	 * @return
	 * @throws ServiceException
	 */
	SearchKeywords searchForKeywords(String collectionName,
			String jsonString, int entriesCount) throws ServiceException;

	/**
	 * Search products based on user entry
	 * @param store
	 * @param languageCode
	 * @param jsonString
	 * @param entriesCount
	 * @param startIndex
	 * @throws ServiceException
	 */
	SearchResponse search(MerchantStore store, String languageCode, String jsonString,
			int entriesCount, int startIndex) throws ServiceException;

	/**
	 * Initializes search service in order to avoid lazy initialization
	 */
	void initService();

}
