package com.swaraj.core.business.modules.integration.shipping.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.Validate;

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
import com.swaraj.core.modules.integration.shipping.model.ShippingQuoteModule;
import com.swaraj.core.modules.integration.shipping.model.ShippingQuotePrePostProcessModule;
import com.swaraj.core.business.services.system.MerchantConfigurationService;
import com.swaraj.core.business.utils.ProductPriceUtils;


/**
 * Store pick up shipping module
 * 
 * Requires a configuration of a message note to be printed to the client
 * and a price for calculation (should be configured to 0)
 * 
 * Calculates a ShippingQuote with a price set to the price configured
 * @author carlsamson
 *
 */
public class StorePickupShippingQuote implements ShippingQuoteModule, ShippingQuotePrePostProcessModule {
	
	
	public final static String MODULE_CODE = "storePickUp";

	@Inject
	private MerchantConfigurationService merchantConfigurationService;
	
	@Inject
	private ProductPriceUtils productPriceUtils;


	@Override
	public void validateModuleConfiguration(
			IntegrationConfiguration integrationConfiguration,
			MerchantStore store) throws IntegrationException {
		
		
		
		
		List<String> errorFields = null;
		
		//validate integrationKeys['account']
		Map<String,String> keys = integrationConfiguration.getIntegrationKeys();
		//if(keys==null || StringUtils.isBlank(keys.get("price"))) {
		if(keys==null) {
			errorFields = new ArrayList<String>();
			errorFields.add("price");
		} else {
			//validate it can be parsed to BigDecimal
			try {
				BigDecimal price = new BigDecimal(keys.get("price"));
			} catch(Exception e) {
				errorFields = new ArrayList<String>();
				errorFields.add("price");
			}
		}
		
		//if(keys==null || StringUtils.isBlank(keys.get("note"))) {
		if(keys==null) {
			errorFields = new ArrayList<String>();
			errorFields.add("note");
		}


		
		if(errorFields!=null) {
			IntegrationException ex = new IntegrationException(IntegrationException.ERROR_VALIDATION_SAVE);
			ex.setErrorFields(errorFields);
			throw ex;
			
		}

	}

	@Override
	public List<ShippingOption> getShippingQuotes(
			ShippingQuote shippingQuote,
			List<PackageDetails> packages, BigDecimal orderTotal,
			Delivery delivery, ShippingOrigin origin, MerchantStore store,
			IntegrationConfiguration configuration, IntegrationModule module,
			ShippingConfiguration shippingConfiguration, Locale locale)
			throws IntegrationException {

		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public CustomIntegrationConfiguration getCustomModuleConfiguration(
			MerchantStore store) throws IntegrationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prePostProcessShippingQuotes(ShippingQuote quote,
			List<PackageDetails> packages, BigDecimal orderTotal,
			Delivery delivery, ShippingOrigin origin, MerchantStore store,
			IntegrationConfiguration globalShippingConfiguration,
			IntegrationModule currentModule,
			ShippingConfiguration shippingConfiguration,
			List<IntegrationModule> allModules, Locale locale)
			throws IntegrationException {
		
		Validate.notNull(globalShippingConfiguration, "IntegrationConfiguration must not be null for StorePickUp");
		
		
		try {
			
			if(!globalShippingConfiguration.isActive())
				return;

			String region = null;
			
			String price = globalShippingConfiguration.getIntegrationKeys().get("price");
	
	
			if(delivery.getZone()!=null) {
				region = delivery.getZone().getCode();
			} else {
				region = delivery.getState();
			}
			
			ShippingOption shippingOption = new ShippingOption();
			shippingOption.setShippingModuleCode(MODULE_CODE);
			shippingOption.setOptionCode(MODULE_CODE);
			shippingOption.setOptionId(new StringBuilder().append(MODULE_CODE).append("_").append(region).toString());
			
			shippingOption.setOptionPrice(productPriceUtils.getAmount(price));
	
			shippingOption.setOptionPriceText(productPriceUtils.getStoreFormatedAmountWithCurrency(store, productPriceUtils.getAmount(price)));
	
			List<ShippingOption> options = quote.getShippingOptions();
			
			if(options == null) {
				options = new ArrayList<ShippingOption>();
				quote.setShippingOptions(options);
			}

			options.add(shippingOption);
			
			if(quote.getSelectedShippingOption()==null) {
				quote.setSelectedShippingOption(shippingOption);
			}

		
		} catch (Exception e) {
			throw new IntegrationException(e);
		}
	
		
		
	}

	@Override
	public String getModuleCode() {
		// TODO Auto-generated method stub
		return MODULE_CODE;
	}



}
