package com.swaraj.shop.store.controller.marketplace.facade;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.system.optin.OptinType;
import com.swaraj.shop.model.marketplace.ReadableMarketPlace;
import com.swaraj.shop.model.system.ReadableOptin;

/**
 * Builds market places objects for shop and REST api
 * @author c.samson
 *
 */
public interface MarketPlaceFacade {
	
	
	/**
	 * Get a MarketPlace from store code
	 * @param store
	 * @param lang
	 * @return
	 * @throws Exception
	 */
	ReadableMarketPlace get(String store, Language lang) ;
	
	/**
	 * Finds an optin by merchant and type
	 * @param store
	 * @param type
	 * @return
	 * @throws Exception
	 */
	ReadableOptin findByMerchantAndType(MerchantStore store, OptinType type);

}
