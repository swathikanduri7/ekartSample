package com.swaraj.shop.mapper.catalog;

import org.jsoup.helper.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swaraj.core.business.services.catalog.product.attribute.ProductOptionService;
import com.swaraj.core.business.services.catalog.product.attribute.ProductOptionValueService;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.catalog.product.variation.PersistableProductVariation;
import com.swaraj.shop.store.api.exception.ConversionRuntimeException;
import com.swaraj.core.model.catalog.product.attribute.ProductOption;
import com.swaraj.core.model.catalog.product.attribute.ProductOptionValue;
import com.swaraj.core.model.catalog.product.variation.ProductVariation;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;

@Component
public class PersistableProductVariationMapper implements Mapper<PersistableProductVariation, ProductVariation> {

	@Autowired
	private ProductOptionService productOptionService;
	
	@Autowired
	private ProductOptionValueService productOptionValueService;
	
	@Override
	public ProductVariation convert(PersistableProductVariation source, MerchantStore store, Language language) {
		
		ProductVariation variation = new ProductVariation();
		return this.merge(source, variation, store, language);

	}

	@Override
	public ProductVariation merge(PersistableProductVariation source, ProductVariation destination, MerchantStore store,
			Language language) {
		Validate.notNull(destination, "ProductVariation cannot be null");
		
		destination.setId(source.getId());
		destination.setCode(source.getCode());
		destination.setMerchantStore(store);
		
		ProductOption option = productOptionService.getById(store, source.getOption());
		if(option == null) {
			throw new ConversionRuntimeException("ProductOption [" + source.getOption() + "] does not exists");
		}
		destination.setOption(option);
		
		ProductOptionValue optionValue = productOptionValueService.getById(store, source.getOptionValue());
		if(optionValue == null) {
			throw new ConversionRuntimeException("ProductOptionValue [" + source.getOptionValue() + "] does not exists");
		}
		destination.setProductOptionValue(optionValue);
				
		
		return destination;
		
		
	}

}
