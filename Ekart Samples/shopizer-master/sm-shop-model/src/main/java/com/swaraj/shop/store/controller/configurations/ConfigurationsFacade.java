package com.swaraj.shop.store.controller.configurations;

import java.util.List;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.shop.model.configuration.PersistableConfiguration;
import com.swaraj.shop.model.configuration.ReadableConfiguration;

public interface ConfigurationsFacade {
	
	List<ReadableConfiguration> configurations(MerchantStore store);
	
	ReadableConfiguration configuration(String module, MerchantStore store);
	
	void saveConfiguration(PersistableConfiguration configuration, MerchantStore store);
	
	void deleteConfiguration(String module, MerchantStore store);

}
