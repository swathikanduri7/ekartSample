package com.swaraj.core.business.services.shipping;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.order.Order;
import com.swaraj.core.model.shipping.Quote;
import com.swaraj.core.model.shipping.ShippingSummary;

import java.util.List;

/**
 * Saves and retrieves various shipping quotes done by the system
 * @author c.samson
 *
 */
public interface ShippingQuoteService extends SalesManagerEntityService<Long, Quote> {
	
	/**
	 * Find shipping quotes by Order
	 * @param order
	 * @return
	 * @throws ServiceException
	 */
	List<Quote> findByOrder(Order order) throws ServiceException;
	
	
	/**
	 * Each quote asked for a given shopping cart creates individual Quote object
	 * in the table ShippingQuote. This method allows the creation of a ShippingSummary 
	 * object to work with in the services and in the api.
	 * @param quoteId
	 * @return
	 * @throws ServiceException
	 */
	ShippingSummary getShippingSummary(Long quoteId, MerchantStore store) throws ServiceException;

}
