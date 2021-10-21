package com.swaraj.core.business.modules.order;

import java.io.ByteArrayOutputStream;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.order.Order;
import com.swaraj.core.model.reference.language.Language;


public interface InvoiceModule {
	
	ByteArrayOutputStream createInvoice(MerchantStore store, Order order, Language language) throws Exception;

}
