package com.swaraj.shop.populator.order.transaction;

import org.apache.commons.lang3.Validate;

import com.swaraj.core.business.services.catalog.product.PricingService;
import com.swaraj.core.business.services.order.OrderService;
import com.swaraj.shop.model.order.transaction.ReadableTransaction;
import com.swaraj.shop.utils.DateUtil;
import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.utils.AbstractDataPopulator;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.payments.Transaction;
import com.swaraj.core.model.reference.language.Language;


public class ReadableTransactionPopulator extends AbstractDataPopulator<Transaction, ReadableTransaction> {

	
	private OrderService orderService;
	private PricingService pricingService;
	
	@Override
	public ReadableTransaction populate(Transaction source, ReadableTransaction target, MerchantStore store,
			Language language) throws ConversionException {

		
		Validate.notNull(source,"PersistableTransaction must not be null");
		Validate.notNull(orderService,"OrderService must not be null");
		Validate.notNull(pricingService,"OrderService must not be null");
		
		if(target == null) {
			target = new ReadableTransaction();
		}
		
		
		try {
			

			target.setAmount(pricingService.getDisplayAmount(source.getAmount(), store));
			target.setDetails(source.getDetails());
			target.setPaymentType(source.getPaymentType());
			target.setTransactionType(source.getTransactionType());
			target.setTransactionDate(DateUtil.formatDate(source.getTransactionDate()));
			target.setId(source.getId());
			
			if(source.getOrder() != null) {
				target.setOrderId(source.getOrder().getId());

			}
			
			return target;
			
			
		
		} catch(Exception e) {
			throw new ConversionException(e);
		}
		
	}

	@Override
	protected ReadableTransaction createTarget() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public PricingService getPricingService() {
		return pricingService;
	}

	public void setPricingService(PricingService pricingService) {
		this.pricingService = pricingService;
	}

}
