package com.swaraj.shop.populator.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swaraj.core.business.services.customer.CustomerService;
import com.swaraj.shop.model.customer.PersistableCustomer;
import com.swaraj.shop.model.order.v1.PersistableAnonymousOrder;
import com.swaraj.shop.model.order.v1.PersistableOrder;
import com.swaraj.shop.populator.customer.CustomerPopulator;
import com.swaraj.shop.utils.LocaleUtils;
import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.services.reference.currency.CurrencyService;
import com.swaraj.core.business.utils.AbstractDataPopulator;
import com.swaraj.core.model.common.Billing;
import com.swaraj.core.model.common.Delivery;
import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.order.Order;
import com.swaraj.core.model.order.OrderChannel;
import com.swaraj.core.model.order.attributes.OrderAttribute;
import com.swaraj.core.model.order.orderstatus.OrderStatus;
import com.swaraj.core.model.order.orderstatus.OrderStatusHistory;
import com.swaraj.core.model.payments.PaymentType;
import com.swaraj.core.model.reference.currency.Currency;
import com.swaraj.core.model.reference.language.Language;

@Component
public class PersistableOrderApiPopulator extends AbstractDataPopulator<PersistableOrder, Order> {

	@Autowired
	private CurrencyService currencyService;
	@Autowired
	private CustomerService customerService;
/*	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductAttributeService productAttributeService;
	@Autowired
	private DigitalProductService digitalProductService;*/
	@Autowired
	private CustomerPopulator customerPopulator;
	
	

	


	@Override
	public Order populate(PersistableOrder source, Order target, MerchantStore store, Language language)
			throws ConversionException {
		

/*		Validate.notNull(currencyService,"currencyService must be set");
		Validate.notNull(customerService,"customerService must be set");
		Validate.notNull(shoppingCartService,"shoppingCartService must be set");
		Validate.notNull(productService,"productService must be set");
		Validate.notNull(productAttributeService,"productAttributeService must be set");
		Validate.notNull(digitalProductService,"digitalProductService must be set");*/
		Validate.notNull(source.getPayment(),"Payment cannot be null");
		
		try {
			
			if(target == null) {
				target = new Order();
			}
		
			//target.setLocale(LocaleUtils.getLocale(store));

			target.setLocale(LocaleUtils.getLocale(store));
			
			
			Currency currency = null;
			try {
				currency = currencyService.getByCode(source.getCurrency());
			} catch(Exception e) {
				throw new ConversionException("Currency not found for code " + source.getCurrency());
			}
			
			if(currency==null) {
				throw new ConversionException("Currency not found for code " + source.getCurrency());
			}
			
			//Customer
			Customer customer = null;
			if(source.getCustomerId() != null && source.getCustomerId().longValue() >0) {
			  Long customerId = source.getCustomerId();
			  customer = customerService.getById(customerId);

			  if(customer == null) {
				throw new ConversionException("Curstomer with id " + source.getCustomerId() + " does not exist");
			  }
			  target.setCustomerId(customerId);
			
			} else {
			  if(source instanceof PersistableAnonymousOrder) {
			    PersistableCustomer persistableCustomer = ((PersistableAnonymousOrder)source).getCustomer();
			    customer = new Customer();
			    customer = customerPopulator.populate(persistableCustomer, customer, store, language);
			  } else {
			    throw new ConversionException("Curstomer details or id not set in request");
			  } 
			}
			
			
			target.setCustomerEmailAddress(customer.getEmailAddress());
			
			Delivery delivery = customer.getDelivery();
			target.setDelivery(delivery);
			
			Billing billing = customer.getBilling();
			target.setBilling(billing);
			
			if(source.getAttributes() != null && source.getAttributes().size() > 0) {
				Set<OrderAttribute> attrs = new HashSet<OrderAttribute>();
				for(com.swaraj.shop.model.order.OrderAttribute attribute : source.getAttributes()) {
					OrderAttribute attr = new OrderAttribute();
					attr.setKey(attribute.getKey());
					attr.setValue(attribute.getValue());
					attr.setOrder(target);
					attrs.add(attr);
				}
				target.setOrderAttributes(attrs);
			}

			target.setDatePurchased(new Date());
			target.setCurrency(currency);
			target.setCurrencyValue(new BigDecimal(0));
			target.setMerchant(store);
			target.setChannel(OrderChannel.API);
			//need this
			target.setStatus(OrderStatus.ORDERED);
			target.setPaymentModuleCode(source.getPayment().getPaymentModule());
			target.setPaymentType(PaymentType.valueOf(source.getPayment().getPaymentType()));
			
			target.setCustomerAgreement(source.isCustomerAgreement());
			target.setConfirmedAddress(true);//force this to true, cannot perform this activity from the API

			
			if(!StringUtils.isBlank(source.getComments())) {
				OrderStatusHistory statusHistory = new OrderStatusHistory();
				statusHistory.setStatus(null);
				statusHistory.setOrder(target);
				statusHistory.setComments(source.getComments());
				target.getOrderHistory().add(statusHistory);
			}
			
			return target;
		
		} catch(Exception e) {
			throw new ConversionException(e);
		}
	}

	@Override
	protected Order createTarget() {
		// TODO Auto-generated method stub
		return null;
	}


/*	public CurrencyService getCurrencyService() {
		return currencyService;
	}

	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductAttributeService getProductAttributeService() {
		return productAttributeService;
	}

	public void setProductAttributeService(ProductAttributeService productAttributeService) {
		this.productAttributeService = productAttributeService;
	}

	public DigitalProductService getDigitalProductService() {
		return digitalProductService;
	}

	public void setDigitalProductService(DigitalProductService digitalProductService) {
		this.digitalProductService = digitalProductService;
	}*/



}
