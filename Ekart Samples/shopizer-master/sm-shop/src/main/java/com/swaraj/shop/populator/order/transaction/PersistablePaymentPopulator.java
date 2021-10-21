package com.swaraj.shop.populator.order.transaction;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.Validate;

import com.swaraj.core.business.services.catalog.product.PricingService;
import com.swaraj.shop.model.order.transaction.PersistablePayment;
import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.utils.AbstractDataPopulator;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.payments.Payment;
import com.swaraj.core.model.payments.PaymentType;
import com.swaraj.core.model.payments.TransactionType;
import com.swaraj.core.model.reference.language.Language;

public class PersistablePaymentPopulator extends AbstractDataPopulator<PersistablePayment, Payment> {
	
	
	PricingService pricingService;



	@Override
	public Payment populate(PersistablePayment source, Payment target, MerchantStore store, Language language)
			throws ConversionException {
		
		Validate.notNull(source,"PersistablePayment cannot be null");
		Validate.notNull(pricingService,"pricingService must be set");
		if(target == null) {
			target = new Payment();
		}
		
		try {
		
			target.setAmount(pricingService.getAmount(source.getAmount()));
			target.setModuleName(source.getPaymentModule());
			target.setPaymentType(PaymentType.valueOf(source.getPaymentType()));
			target.setTransactionType(TransactionType.valueOf(source.getTransactionType()));
			
			Map<String,String> metadata = new HashMap<String,String>();
			metadata.put("paymentToken", source.getPaymentToken());
			target.setPaymentMetaData(metadata);
			
			return target;
		
		} catch(Exception e) {
			throw new ConversionException(e);
		}
	}

	@Override
	protected Payment createTarget() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PricingService getPricingService() {
		return pricingService;
	}

	public void setPricingService(PricingService pricingService) {
		this.pricingService = pricingService;
	}

}
