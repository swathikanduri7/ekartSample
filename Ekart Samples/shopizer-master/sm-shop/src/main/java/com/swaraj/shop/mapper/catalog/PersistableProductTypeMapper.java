package com.swaraj.shop.mapper.catalog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.reference.language.LanguageService;
import com.swaraj.core.model.catalog.product.type.ProductType;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.catalog.product.type.PersistableProductType;
import com.swaraj.shop.model.catalog.product.type.ProductTypeDescription;
import com.swaraj.shop.store.api.exception.ConversionRuntimeException;


@Component
public class PersistableProductTypeMapper implements Mapper<PersistableProductType, ProductType> {
	
	@Autowired
	private LanguageService languageService;

	@Override
	public ProductType convert(PersistableProductType source, MerchantStore store, Language language) {
		ProductType type = new ProductType();
		return this.merge(source, type, store, language);
	}

	@Override
	public ProductType merge(PersistableProductType source, ProductType destination, MerchantStore store,
							 Language language) {
		Validate.notNull(destination, "ReadableProductType cannot be null");
		try {
			return type(source, destination);
		} catch (ServiceException e) {
			throw new ConversionRuntimeException(e);
		}
	}
	
	private ProductType type (PersistableProductType type, ProductType destination) throws ServiceException {
		if(destination == null) {
			destination = new ProductType();
		}
		destination.setCode(type.getCode());
		destination.setId(type.getId());
		destination.setAllowAddToCart(type.isAllowAddToCart());
		destination.setVisible(type.isVisible());
		//destination.set

		List<com.swaraj.core.model.catalog.product.type.ProductTypeDescription> descriptions = new ArrayList<com.swaraj.core.model.catalog.product.type.ProductTypeDescription>();
		if(!CollectionUtils.isEmpty(type.getDescriptions())) {
			
			for(ProductTypeDescription d : type.getDescriptions()) {
				com.swaraj.core.model.catalog.product.type.ProductTypeDescription desc = typeDescription(d, destination, d.getLanguage());
				descriptions.add(desc);
				
				
			}
			
			destination.setDescriptions(new HashSet<com.swaraj.core.model.catalog.product.type.ProductTypeDescription>(descriptions));
			
		}	

		return destination;
	}
	
	private com.swaraj.core.model.catalog.product.type.ProductTypeDescription typeDescription(ProductTypeDescription description, ProductType typeModel, String lang) throws ServiceException {
		
		com.swaraj.core.model.catalog.product.type.ProductTypeDescription desc = null;
		if(!CollectionUtils.isEmpty(typeModel.getDescriptions()) ){
			desc = this.findAppropriateDescription(typeModel, lang);
		}
		
		if(desc == null) {
			desc = new com.swaraj.core.model.catalog.product.type.ProductTypeDescription();
		}
		
		desc.setName(description.getName());
		desc.setDescription(description.getDescription());
		desc.setLanguage(languageService.getByCode(description.getLanguage()));
		desc.setProductType(typeModel);
		return desc;
	}
	
	private com.swaraj.core.model.catalog.product.type.ProductTypeDescription findAppropriateDescription(ProductType typeModel, String lang) {
		java.util.Optional<com.swaraj.core.model.catalog.product.type.ProductTypeDescription> d = typeModel.getDescriptions().stream().filter(t -> t.getLanguage().getCode().equals(lang)).findFirst();
		if(d.isPresent()) {
			return d.get();
		} else {
			return null;
		}
	}

}
