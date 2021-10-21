package com.swaraj.shop.populator.order;

import org.apache.commons.lang3.Validate;

import com.swaraj.core.business.services.catalog.product.ProductService;
import com.swaraj.core.business.services.catalog.product.attribute.ProductAttributeService;
import com.swaraj.shop.model.order.PersistableOrderProduct;
import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.shoppingcart.ShoppingCartService;
import com.swaraj.core.business.utils.AbstractDataPopulator;
import com.swaraj.core.model.catalog.product.Product;
import com.swaraj.core.model.catalog.product.attribute.ProductAttribute;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.shoppingcart.ShoppingCartItem;

public class ShoppingCartItemPopulator extends
		AbstractDataPopulator<PersistableOrderProduct, ShoppingCartItem> {


	private ProductService productService;
	private ProductAttributeService productAttributeService;
	private ShoppingCartService shoppingCartService;

	@Override
	public ShoppingCartItem populate(PersistableOrderProduct source, /** TODO: Fix, target not used possible future bug ! **/ShoppingCartItem target,
									 MerchantStore store, Language language)
			throws ConversionException {
		Validate.notNull(productService, "Requires to set productService");
		Validate.notNull(productAttributeService, "Requires to set productAttributeService");
		Validate.notNull(shoppingCartService, "Requires to set shoppingCartService");

		Product product = productService.getById(source.getProduct().getId());
		if(source.getAttributes()!=null) {

			for(com.swaraj.shop.model.catalog.product.attribute.ProductAttribute attr : source.getAttributes()) {
				ProductAttribute attribute = productAttributeService.getById(attr.getId());
				if(attribute==null) {
					throw new ConversionException("ProductAttribute with id " + attr.getId() + " is null");
				}
				if(attribute.getProduct().getId().longValue()!=source.getProduct().getId().longValue()) {
					throw new ConversionException("ProductAttribute with id " + attr.getId() + " is not assigned to Product id " + source.getProduct().getId());
				}
				product.getAttributes().add(attribute);
			}
		}

		try {
			return shoppingCartService.populateShoppingCartItem(product);
		} catch (ServiceException e) {
			throw new ConversionException(e);
		}

	}

	@Override
	protected ShoppingCartItem createTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setProductAttributeService(ProductAttributeService productAttributeService) {
		this.productAttributeService = productAttributeService;
	}

	public ProductAttributeService getProductAttributeService() {
		return productAttributeService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

}
