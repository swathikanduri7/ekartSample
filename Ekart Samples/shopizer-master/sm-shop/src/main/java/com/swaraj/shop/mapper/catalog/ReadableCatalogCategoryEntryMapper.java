package com.swaraj.shop.mapper.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.swaraj.core.model.catalog.catalog.CatalogCategoryEntry;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.catalog.catalog.ReadableCatalogCategoryEntry;
import com.swaraj.shop.model.catalog.category.ReadableCategory;
import com.swaraj.shop.store.api.exception.ConversionRuntimeException;
import com.swaraj.shop.utils.ImageFilePath;

import java.util.Optional;

@Component
public class ReadableCatalogCategoryEntryMapper implements Mapper<CatalogCategoryEntry, ReadableCatalogCategoryEntry> {
	
	
	@Autowired
	private ReadableCategoryMapper readableCategoryMapper;
	
	//@Autowired
	//private PricingService pricingService;
	
	@Autowired
	@Qualifier("img")
	private ImageFilePath imageUtils;

	@Override
	public ReadableCatalogCategoryEntry convert(CatalogCategoryEntry source, MerchantStore store, Language language) {
		ReadableCatalogCategoryEntry destination = new ReadableCatalogCategoryEntry();
		return merge(source, destination, store, language);
	}

	@Override
	public ReadableCatalogCategoryEntry merge(CatalogCategoryEntry source, ReadableCatalogCategoryEntry destination, MerchantStore store,
											  Language language) {
		ReadableCatalogCategoryEntry convertedDestination = Optional.ofNullable(destination)
				.orElse(new ReadableCatalogCategoryEntry());
		
		try {
			//ReadableProductPopulator readableProductPopulator = new ReadableProductPopulator();
			//readableProductPopulator.setimageUtils(imageUtils);
			//readableProductPopulator.setPricingService(pricingService);
			
			//ReadableProduct readableProduct = readableProductPopulator.populate(source.getProduct(), store, language);
			ReadableCategory readableCategory = readableCategoryMapper.convert(source.getCategory(), store, language);

			convertedDestination.setCatalog(source.getCatalog().getCode());

			convertedDestination.setId(source.getId());
			convertedDestination.setVisible(source.isVisible());
			convertedDestination.setCategory(readableCategory);
			//destination.setProduct(readableProduct);
			return convertedDestination;
		} catch (Exception e) {
			throw new ConversionRuntimeException("Error while creating ReadableCatalogEntry", e);
		}
	}
}
