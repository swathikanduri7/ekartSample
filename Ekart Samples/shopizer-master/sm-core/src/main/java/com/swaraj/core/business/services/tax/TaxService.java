package com.swaraj.core.business.services.tax;

import java.util.List;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.order.OrderSummary;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.tax.TaxConfiguration;
import com.swaraj.core.model.tax.TaxItem;


public interface TaxService   {

	/**
	 * Retrieves tax configurations (TaxConfiguration) for a given MerchantStore
	 * @param store
	 * @return
	 * @throws ServiceException
	 */
	TaxConfiguration getTaxConfiguration(MerchantStore store)
			throws ServiceException;

	/**
	 * Saves ShippingConfiguration to MerchantConfiguration table
	 * @param shippingConfiguration
	 * @param store
	 * @throws ServiceException
	 */
	void saveTaxConfiguration(TaxConfiguration shippingConfiguration,
			MerchantStore store) throws ServiceException;

	/**
	 * Calculates tax over an OrderSummary
	 * @param orderSummary
	 * @param customer
	 * @param store
	 * @param locale
	 * @return
	 * @throws ServiceException
	 */
	List<TaxItem> calculateTax(OrderSummary orderSummary, Customer customer,
			MerchantStore store, Language language) throws ServiceException;


}
