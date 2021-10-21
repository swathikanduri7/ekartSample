package com.swaraj.core.business.services.order.ordertotal;

import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.order.OrderSummary;
import com.swaraj.core.model.order.OrderTotalVariation;
import com.swaraj.core.model.reference.language.Language;

/**
 * Additional dynamic order total calculation
 * from the rules engine and other modules
 * @author carlsamson
 *
 */
public interface OrderTotalService {
	
	OrderTotalVariation findOrderTotalVariation(final OrderSummary summary, final Customer customer, final MerchantStore store, final Language language) throws Exception;

}
