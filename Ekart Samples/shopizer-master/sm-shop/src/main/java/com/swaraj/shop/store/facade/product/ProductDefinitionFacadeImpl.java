package com.swaraj.shop.store.facade.product;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.swaraj.core.business.services.catalog.category.CategoryService;
import com.swaraj.core.business.services.catalog.product.PricingService;
import com.swaraj.core.business.services.catalog.product.ProductService;
import com.swaraj.core.business.services.catalog.product.attribute.ProductAttributeService;
import com.swaraj.core.business.services.catalog.product.relationship.ProductRelationshipService;
import com.swaraj.core.business.services.catalog.product.review.ProductReviewService;
import com.swaraj.core.business.services.customer.CustomerService;
import com.swaraj.shop.mapper.catalog.PersistableProductDefinitionMapper;
import com.swaraj.shop.mapper.catalog.ReadableProductDefinitionMapper;
import com.swaraj.shop.model.catalog.product.ReadableProduct;
import com.swaraj.shop.model.catalog.product.product.definition.PersistableProductDefinition;
import com.swaraj.shop.model.catalog.product.product.definition.ReadableProductDefinition;
import com.swaraj.shop.model.catalog.product.product.definition.ReadableProductDefinitionFull;
import com.swaraj.shop.populator.catalog.ReadableProductPopulator;
import com.swaraj.shop.store.api.exception.ServiceRuntimeException;
import com.swaraj.shop.store.controller.product.facade.ProductDefinitionFacade;
import com.swaraj.shop.utils.ImageFilePath;
import com.swaraj.core.business.services.reference.language.LanguageService;
import com.swaraj.core.model.catalog.product.Product;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;

@Service("productDefinitionFacade")
@Profile({ "default", "cloud", "gcp", "aws", "mysql" })
public class ProductDefinitionFacadeImpl implements ProductDefinitionFacade {
	
	
	@Inject
	private CategoryService categoryService;

	@Inject
	private LanguageService languageService;
	
	@Inject
	private ProductAttributeService productAttributeService;

	@Inject
	private ProductService productService;

	@Inject
	private PricingService pricingService;

	@Inject
	private CustomerService customerService;

	@Inject
	private ProductReviewService productReviewService;

	@Inject
	private ProductRelationshipService productRelationshipService;

	@Autowired
	private PersistableProductDefinitionMapper persistableProductDefinitionMapper;
	
	@Autowired
	private ReadableProductDefinitionMapper readableProductDefinitionMapper;

	@Inject
	@Qualifier("img")
	private ImageFilePath imageUtils;

	@Override
	public Long saveProductDefinition(MerchantStore store, PersistableProductDefinition product, Language language) {
		

		Product target = null;
		if (product.getId() != null && product.getId().longValue() > 0) {
			target = productService.getById(product.getId());
		} else {
			target = new Product();
		}

		try {
			target = persistableProductDefinitionMapper.merge(product, target, store, language);
			if (target.getId() != null && target.getId() > 0) {
				productService.update(target);
			} else {
				productService.create(target);
				product.setId(target.getId());
			}

			return target.getId();
		} catch (Exception e) {
			throw new ServiceRuntimeException(e);
		}
		
	}

	@Override
	public void update(Long id, PersistableProductDefinition product, MerchantStore merchant,
			Language language) {
		product.setId(id);
		this.saveProductDefinition(merchant, product, language);
	}

	@Override
	public ReadableProductDefinition getProduct(MerchantStore store, Long id, Language language) {
		Product product = productService.findOne(id, store);
		return readableProductDefinitionMapper.convert(product, store, language);
	}

	@Override
	public ReadableProductDefinition getProductByCode(MerchantStore store, String uniqueCode, Language language) {
		
		Product product = productService.getByCode(uniqueCode, store);
		return readableProductDefinitionMapper.convert(product, store, language);

	}

}
