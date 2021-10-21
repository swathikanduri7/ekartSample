/**
 *
 */
package com.swaraj.core.business.services.shoppingcart;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.order.OrderTotalSummary;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.shoppingcart.ShoppingCart;

/**
 * Interface declaring various methods used to calculate {@link ShoppingCart}
 * object details.
 * 
 * @author Umesh Awasthi
 * @since 1.2
 *
 */
public interface ShoppingCartCalculationService {
	/**
	 * Method which will be used to calculate price for each line items as well
	 * Total and Sub-total for {@link ShoppingCart}.
	 * 
	 * @param cartModel
	 *            ShoopingCart mode representing underlying DB object
	 * @param customer
	 * @param store
	 * @param language
	 * @throws ServiceException
	 */
	OrderTotalSummary calculate(final ShoppingCart cartModel, final Customer customer, final MerchantStore store,
			final Language language) throws ServiceException;

	/**
	 * Method which will be used to calculate price for each line items as well
	 * Total and Sub-total for {@link ShoppingCart}.
	 * 
	 * @param cartModel
	 *            ShoopingCart mode representing underlying DB object
	 * @param store
	 * @param language
	 * @throws ServiceException
	 */
	OrderTotalSummary calculate(final ShoppingCart cartModel, final MerchantStore store, final Language language)
			throws ServiceException;
}