package com.swaraj.shop.populator.catalog;

import org.apache.commons.lang3.Validate;

import com.swaraj.core.business.services.catalog.product.PricingService;
import com.swaraj.shop.model.catalog.product.ReadableProductPrice;
import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.utils.AbstractDataPopulator;
import com.swaraj.core.model.catalog.product.price.FinalPrice;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;

public class ReadableFinalPricePopulator extends
		AbstractDataPopulator<FinalPrice, ReadableProductPrice> {
	
	
	private PricingService pricingService;

	public PricingService getPricingService() {
		return pricingService;
	}

	public void setPricingService(PricingService pricingService) {
		this.pricingService = pricingService;
	}

	@Override
	public ReadableProductPrice populate(FinalPrice source,
			ReadableProductPrice target, MerchantStore store, Language language)
			throws ConversionException {
		Validate.notNull(pricingService,"pricingService must be set");
		
		try {
			
			target.setOriginalPrice(pricingService.getDisplayAmount(source.getOriginalPrice(), store));
			if(source.isDiscounted()) {
				target.setDiscounted(true);
				target.setFinalPrice(pricingService.getDisplayAmount(source.getDiscountedPrice(), store));
			} else {
				target.setFinalPrice(pricingService.getDisplayAmount(source.getFinalPrice(), store));
			}
			
		} catch(Exception e) {
			throw new ConversionException("Exception while converting to ReadableProductPrice",e);
		}
		
		
		
		return target;
	}

	@Override
	protected ReadableProductPrice createTarget() {
		// TODO Auto-generated method stub
		return null;
	}

}
