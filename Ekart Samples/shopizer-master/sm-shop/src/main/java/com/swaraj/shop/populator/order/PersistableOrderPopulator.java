package com.swaraj.shop.populator.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import com.swaraj.core.business.services.catalog.product.ProductService;
import com.swaraj.core.business.services.catalog.product.attribute.ProductAttributeService;
import com.swaraj.core.business.services.catalog.product.file.DigitalProductService;
import com.swaraj.core.business.services.customer.CustomerService;
import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.services.reference.country.CountryService;
import com.swaraj.core.business.services.reference.currency.CurrencyService;
import com.swaraj.core.business.services.reference.zone.ZoneService;
import com.swaraj.core.business.utils.AbstractDataPopulator;
import com.swaraj.core.business.utils.CreditCardUtils;
import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.order.Order;
import com.swaraj.core.model.order.orderproduct.OrderProduct;
import com.swaraj.core.model.order.orderstatus.OrderStatus;
import com.swaraj.core.model.order.orderstatus.OrderStatusHistory;
import com.swaraj.core.model.order.payment.CreditCard;
import com.swaraj.core.model.reference.country.Country;
import com.swaraj.core.model.reference.currency.Currency;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.reference.zone.Zone;
import com.swaraj.shop.model.customer.PersistableCustomer;
import com.swaraj.shop.model.order.PersistableOrderProduct;
import com.swaraj.shop.model.order.total.OrderTotal;
import com.swaraj.shop.model.order.v0.PersistableOrder;
import com.swaraj.shop.utils.LocaleUtils;

public class PersistableOrderPopulator extends
		AbstractDataPopulator<PersistableOrder, Order> {
	
	private CustomerService customerService;
	private CountryService countryService;
	private CurrencyService currencyService;


	private ZoneService zoneService;
	private ProductService productService;
	private DigitalProductService digitalProductService;
	private ProductAttributeService productAttributeService;

	@Override
	public Order populate(PersistableOrder source, Order target,
			MerchantStore store, Language language) throws ConversionException {
		
		
		Validate.notNull(productService,"productService must be set");
		Validate.notNull(digitalProductService,"digitalProductService must be set");
		Validate.notNull(productAttributeService,"productAttributeService must be set");
		Validate.notNull(customerService,"customerService must be set");
		Validate.notNull(countryService,"countryService must be set");
		Validate.notNull(zoneService,"zoneService must be set");
		Validate.notNull(currencyService,"currencyService must be set");

		try {
			

			Map<String,Country> countriesMap = countryService.getCountriesMap(language);
			Map<String,Zone> zonesMap = zoneService.getZones(language);
			/** customer **/
			PersistableCustomer customer = source.getCustomer();
			if(customer!=null) {
				if(customer.getId()!=null && customer.getId()>0) {
					Customer modelCustomer = customerService.getById(customer.getId());
					if(modelCustomer==null) {
						throw new ConversionException("Customer id " + customer.getId() + " does not exists");
					}
					if(modelCustomer.getMerchantStore().getId().intValue()!=store.getId().intValue()) {
						throw new ConversionException("Customer id " + customer.getId() + " does not exists for store " + store.getCode());
					}
					target.setCustomerId(modelCustomer.getId());
					target.setBilling(modelCustomer.getBilling());
					target.setDelivery(modelCustomer.getDelivery());
					target.setCustomerEmailAddress(source.getCustomer().getEmailAddress());


					
				} 
			}
			
			target.setLocale(LocaleUtils.getLocale(store));
			
			CreditCard creditCard = source.getCreditCard();
			if(creditCard!=null) {
				String maskedNumber = CreditCardUtils.maskCardNumber(creditCard.getCcNumber());
				creditCard.setCcNumber(maskedNumber);
				target.setCreditCard(creditCard);
			}
			
			Currency currency = null;
			try {
				currency = currencyService.getByCode(source.getCurrency());
			} catch(Exception e) {
				throw new ConversionException("Currency not found for code " + source.getCurrency());
			}
			
			if(currency==null) {
				throw new ConversionException("Currency not found for code " + source.getCurrency());
			}
			
			target.setCurrency(currency);
			target.setDatePurchased(source.getDatePurchased());
			//target.setCurrency(store.getCurrency());
			target.setCurrencyValue(new BigDecimal(0));
			target.setMerchant(store);
			target.setStatus(source.getOrderStatus());
			target.setPaymentModuleCode(source.getPaymentModule());
			target.setPaymentType(source.getPaymentType());
			target.setShippingModuleCode(source.getShippingModule());
			target.setCustomerAgreement(source.isCustomerAgreed());
			target.setConfirmedAddress(source.isConfirmedAddress());
			if(source.getPreviousOrderStatus()!=null) {
				List<OrderStatus> orderStatusList = source.getPreviousOrderStatus();
				for(OrderStatus status : orderStatusList) {
					OrderStatusHistory statusHistory = new OrderStatusHistory();
					statusHistory.setStatus(status);
					statusHistory.setOrder(target);
					target.getOrderHistory().add(statusHistory);
				}
			}
			
			if(!StringUtils.isBlank(source.getComments())) {
				OrderStatusHistory statusHistory = new OrderStatusHistory();
				statusHistory.setStatus(null);
				statusHistory.setOrder(target);
				statusHistory.setComments(source.getComments());
				target.getOrderHistory().add(statusHistory);
			}
			
			List<PersistableOrderProduct> products = source.getOrderProductItems();
			if(CollectionUtils.isEmpty(products)) {
				throw new ConversionException("Requires at least 1 PersistableOrderProduct");
			}
			com.swaraj.shop.populator.order.PersistableOrderProductPopulator orderProductPopulator = new PersistableOrderProductPopulator();
			orderProductPopulator.setProductAttributeService(productAttributeService);
			orderProductPopulator.setProductService(productService);
			orderProductPopulator.setDigitalProductService(digitalProductService);
			
			for(PersistableOrderProduct orderProduct : products) {
				OrderProduct modelOrderProduct = new OrderProduct();
				orderProductPopulator.populate(orderProduct, modelOrderProduct, store, language);
				target.getOrderProducts().add(modelOrderProduct);
			}
			
			List<OrderTotal> orderTotals = source.getTotals();
			if(CollectionUtils.isNotEmpty(orderTotals)) {
				for(OrderTotal total : orderTotals) {
					com.swaraj.core.model.order.OrderTotal totalModel = new com.swaraj.core.model.order.OrderTotal();
					totalModel.setModule(total.getModule());
					totalModel.setOrder(target);
					totalModel.setOrderTotalCode(total.getCode());
					totalModel.setTitle(total.getTitle());
					totalModel.setValue(total.getValue());
					target.getOrderTotal().add(totalModel);
				}
			}
			
		} catch (Exception e) {
			throw new ConversionException(e);
		}
		
		
		return target;
	}

	@Override
	protected Order createTarget() {
		return null;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setDigitalProductService(DigitalProductService digitalProductService) {
		this.digitalProductService = digitalProductService;
	}

	public DigitalProductService getDigitalProductService() {
		return digitalProductService;
	}

	public void setProductAttributeService(ProductAttributeService productAttributeService) {
		this.productAttributeService = productAttributeService;
	}

	public ProductAttributeService getProductAttributeService() {
		return productAttributeService;
	}
	
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	public CurrencyService getCurrencyService() {
		return currencyService;
	}

	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	public ZoneService getZoneService() {
		return zoneService;
	}

	public void setZoneService(ZoneService zoneService) {
		this.zoneService = zoneService;
	}

}
