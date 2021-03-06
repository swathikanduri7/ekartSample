package com.swaraj.shop.mapper.catalog;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swaraj.core.business.services.catalog.product.attribute.ProductOptionService;
import com.swaraj.core.business.services.catalog.product.attribute.ProductOptionValueService;
import com.swaraj.core.business.services.catalog.product.type.ProductTypeService;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.catalog.product.attribute.optionset.PersistableProductOptionSet;
import com.swaraj.shop.store.api.exception.ConversionRuntimeException;
import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.catalog.product.attribute.ProductOption;
import com.swaraj.core.model.catalog.product.attribute.ProductOptionSet;
import com.swaraj.core.model.catalog.product.attribute.ProductOptionValue;
import com.swaraj.core.model.catalog.product.type.ProductType;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;

@Component
public class PersistableProductOptionSetMapper implements Mapper<PersistableProductOptionSet, ProductOptionSet> {

	@Autowired
	private ProductOptionService productOptionService;
	
	@Autowired
	private ProductOptionValueService productOptionValueService;
	
	@Autowired
	private ProductTypeService productTypeService;

	@Override
	public ProductOptionSet convert(PersistableProductOptionSet source, MerchantStore store, Language language) {
		
		
		ProductOptionSet optionSet = new ProductOptionSet();
		return this.merge(source, optionSet, store, language);

	}

	private ProductOptionValue value(Long productOptionValue, MerchantStore store) {
		return productOptionValueService.getById(store, productOptionValue);
	}
	
	@Override
	public ProductOptionSet merge(PersistableProductOptionSet source, ProductOptionSet destination,
								  MerchantStore store, Language language) {
		Validate.notNull(destination, "ProductOptionSet must not be null");
		
		destination.setId(source.getId());
		destination.setCode(source.getCode());
		destination.setOptionDisplayOnly(source.isReadOnly());
		
		ProductOption option = productOptionService.getById(store, source.getOption());
		destination.setOption(option);
		
		if(!CollectionUtils.isEmpty(source.getOptionValues())) {
			List<ProductOptionValue> values = source.getOptionValues().stream().map(id -> value(id, store)).collect(Collectors.toList());
			destination.setValues(values);
		}
		
		if(!CollectionUtils.isEmpty(source.getProductTypes())) {
			try {
				List<ProductType> types = productTypeService.listProductTypes(source.getProductTypes(), store, language);
				Set<ProductType> typesSet = new HashSet<ProductType>(types);
				destination.setProductTypes(typesSet);
			} catch (ServiceException e) {
				throw new ConversionRuntimeException("Error while mpping ProductOptionSet", e);
			}
		}
		
		return destination;
	}

}
