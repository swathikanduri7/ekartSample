/**
 * This application is maintained by CSTI consulting (www.csticonsulting.com).
 * Licensed under LGPL - Feel free to use it and modify it to your needs !
 *
 */
package com.swaraj.test.common;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swaraj.core.business.services.catalog.category.CategoryService;
import com.swaraj.core.business.services.catalog.product.PricingService;
import com.swaraj.core.business.services.catalog.product.ProductService;
import com.swaraj.core.business.services.catalog.product.attribute.ProductAttributeService;
import com.swaraj.core.business.services.catalog.product.attribute.ProductOptionService;
import com.swaraj.core.business.services.catalog.product.attribute.ProductOptionSetService;
import com.swaraj.core.business.services.catalog.product.attribute.ProductOptionValueService;
import com.swaraj.core.business.services.catalog.product.availability.ProductAvailabilityService;
import com.swaraj.core.business.services.catalog.product.image.ProductImageService;
import com.swaraj.core.business.services.catalog.product.manufacturer.ManufacturerService;
import com.swaraj.core.business.services.catalog.product.price.ProductPriceService;
import com.swaraj.core.business.services.catalog.product.relationship.ProductRelationshipService;
import com.swaraj.core.business.services.catalog.product.review.ProductReviewService;
import com.swaraj.core.business.services.catalog.product.type.ProductTypeService;
import com.swaraj.core.business.services.customer.CustomerService;
import com.swaraj.core.business.services.customer.attribute.CustomerOptionService;
import com.swaraj.core.business.services.customer.attribute.CustomerOptionSetService;
import com.swaraj.core.business.services.customer.attribute.CustomerOptionValueService;
import com.swaraj.core.business.services.merchant.MerchantStoreService;
import com.swaraj.core.business.services.order.OrderService;
import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.payments.PaymentService;
import com.swaraj.core.business.services.reference.country.CountryService;
import com.swaraj.core.business.services.reference.currency.CurrencyService;
import com.swaraj.core.business.services.reference.init.InitializationDatabase;
import com.swaraj.core.business.services.reference.language.LanguageService;
import com.swaraj.core.business.services.reference.zone.ZoneService;
import com.swaraj.core.business.services.shoppingcart.ShoppingCartService;
import com.swaraj.core.business.services.system.EmailService;
import com.swaraj.test.configuration.ConfigurationTest;


/**
 * @author c.samson
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ConfigurationTest.class)
@Ignore
public class AbstractSalesManagerCoreTestCase {

	
	
	protected static String CAD_CURRENCY_CODE = "CAD";
	protected static String USD_CURRENCY_CODE = "USD";
	
	protected static String ENGLISH_LANGUAGE_CODE = "en";
	protected static String FRENCH_LANGUAGE_CODE = "fr";
	
	@Inject
	protected InitializationDatabase   initializationDatabase;
	
	@Inject
	protected ProductService productService;
	
	@Inject
	protected PricingService pricingService;
	
	@Inject
	protected ProductPriceService productPriceService;
	
	@Inject
	protected ProductAttributeService productAttributeService;
	
	@Inject
	protected ProductOptionService productOptionService;
	
	@Inject
	protected ProductOptionSetService productOptionSetService;
	
	@Inject
	protected ProductOptionValueService productOptionValueService;
	
	@Inject
	protected ProductAvailabilityService productAvailabilityService;
	
	@Inject
	protected ProductReviewService productReviewService;
	
	@Inject
	protected ProductImageService productImageService;
	
	@Inject
	protected ProductRelationshipService productRelationshipService;
	
	@Inject
	protected CategoryService categoryService;
	
	@Inject
	protected MerchantStoreService merchantService;
	
	@Inject
	protected ProductTypeService productTypeService;
	
	@Inject
	protected LanguageService languageService;
	
	@Inject
	protected CountryService countryService;
	
	@Inject
	protected CurrencyService currencyService;
	
	@Inject
	protected ManufacturerService manufacturerService;
	
	@Inject
	protected ZoneService zoneService;
	
	@Inject
	protected CustomerService customerService;
	
	@Inject
	protected CustomerOptionService customerOptionService;
	
	@Inject
	protected CustomerOptionValueService customerOptionValueService;
	
	@Inject
	protected CustomerOptionSetService customerOptionSetService;
	
	@Inject
	protected OrderService orderService;
	
	@Inject
	protected PaymentService paymentService;
	
	@Inject
	protected ShoppingCartService shoppingCartService;
	
	@Inject
	protected EmailService emailService;
	
	@Before
	public void init() throws ServiceException {
		if(initializationDatabase.isEmpty()) {
		  populate();
		}

	}
	
	@After
	public void close() throws ServiceException {

	}
	
	private void populate() throws ServiceException {
		initializationDatabase.populate("TEST");
	}

}
