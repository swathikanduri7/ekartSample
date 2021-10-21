/**
 * 
 */
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

/**
 * @author USER
 *
 */
public class ShippingQuoteModuleImpl implements ShippingQuoteModule {

	/**
	 * 
	 */
	public ShippingQuoteModuleImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.swaraj.core.modules.integration.shipping.model.ShippingQuoteModule#validateModuleConfiguration(com.swaraj.core.model.system.IntegrationConfiguration, com.swaraj.core.model.merchant.MerchantStore)
	 */
	@Override
	public void validateModuleConfiguration(IntegrationConfiguration integrationConfiguration, MerchantStore store)
			throws IntegrationException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.swaraj.core.modules.integration.shipping.model.ShippingQuoteModule#getCustomModuleConfiguration(com.swaraj.core.model.merchant.MerchantStore)
	 */
	@Override
	public CustomIntegrationConfiguration getCustomModuleConfiguration(MerchantStore store)
			throws IntegrationException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.swaraj.core.modules.integration.shipping.model.ShippingQuoteModule#getShippingQuotes(com.swaraj.core.model.shipping.ShippingQuote, java.util.List, java.math.BigDecimal, com.swaraj.core.model.common.Delivery, com.swaraj.core.model.shipping.ShippingOrigin, com.swaraj.core.model.merchant.MerchantStore, com.swaraj.core.model.system.IntegrationConfiguration, com.swaraj.core.model.system.IntegrationModule, com.swaraj.core.model.shipping.ShippingConfiguration, java.util.Locale)
	 */
	@Override
	public List<ShippingOption> getShippingQuotes(ShippingQuote quote, List<PackageDetails> packages,
			BigDecimal orderTotal, Delivery delivery, ShippingOrigin origin, MerchantStore store,
			IntegrationConfiguration configuration, IntegrationModule module,
			ShippingConfiguration shippingConfiguration, Locale locale) throws IntegrationException {
		// TODO Auto-generated method stub
		return null;
	}

}
