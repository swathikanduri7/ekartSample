package com.swaraj.shop.populator.catalog;

import org.apache.commons.lang3.Validate;

import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.utils.AbstractDataPopulator;
import com.swaraj.core.model.catalog.product.Product;
import com.swaraj.core.model.catalog.product.image.ProductImage;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.catalog.product.PersistableImage;

public class PersistableProductImagePopulator extends AbstractDataPopulator<PersistableImage, ProductImage> {

	
	private Product product;
	
	@Override
	public ProductImage populate(PersistableImage source, ProductImage target, MerchantStore store, Language language)
			throws ConversionException {
		
		Validate.notNull(product,"Must set a product setProduct(Product)");
		Validate.notNull(product.getId(),"Product must have an id not null");
		Validate.notNull(source.getContentType(),"Content type must be set on persistable image");

		
		target.setDefaultImage(source.isDefaultImage());
		target.setImageType(source.getImageType());
		target.setProductImage(source.getName());
		if(source.getImageUrl() != null) {
			target.setProductImageUrl(source.getImageUrl());
		}
		target.setProduct(product);
		
		return target;
	}

	@Override
	protected ProductImage createTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
