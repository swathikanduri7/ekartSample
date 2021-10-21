package com.swaraj.core.modules.integration.shipping.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import com.swaraj.core.model.common.Delivery;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.shipping.PackageDetails;
import com.swaraj.core.model.shipping.ShippingConfiguration;
import com.swaraj.core.model.shipping.ShippingOption;
import com.swaraj.core.model.shipping.ShippingOrigin;
import com.swaraj.core.model.shipping.ShippingQuote;
import com.swaraj.core.model.system.CustomIntegrationConfiguration;
import com.swaraj.core.model.system.IntegrationConfiguration;
import com.swaraj.core.model.system.IntegrationModule;
import com.swaraj.core.modules.integration.IntegrationException;

public interface ShippingQuoteModule {
	
	public void validateModuleConfiguration(IntegrationConfiguration integrationConfiguration, MerchantStore store) throws IntegrationException;
	public CustomIntegrationConfiguration getCustomModuleConfiguration(MerchantStore store) throws IntegrationException;
	
	public List<ShippingOption> getShippingQuotes(ShippingQuote quote, List<PackageDetails> packages, BigDecimal orderTotal, Delivery delivery, ShippingOrigin origin, MerchantStore store, IntegrationConfiguration configuration, IntegrationModule module, ShippingConfiguration shippingConfiguration, Locale locale) throws IntegrationException;

}
