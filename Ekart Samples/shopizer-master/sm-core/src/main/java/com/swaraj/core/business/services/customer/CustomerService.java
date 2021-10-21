package com.swaraj.core.business.services.customer;


import java.util.List;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.common.Address;
import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.customer.CustomerCriteria;
import com.swaraj.core.model.customer.CustomerList;
import com.swaraj.core.model.merchant.MerchantStore;



public interface CustomerService  extends SalesManagerEntityService<Long, Customer> {

	List<Customer> getByName(String firstName);

	List<Customer> getListByStore(MerchantStore store);

	Customer getByNick(String nick);

	void saveOrUpdate(Customer customer) throws ServiceException ;

	CustomerList getListByStore(MerchantStore store, CustomerCriteria criteria);

	Customer getByNick(String nick, int storeId);
	Customer getByNick(String nick, String code);
	
	/**
	 * Password reset token
	 * @param storeCode
	 * @param token
	 * @return
	 */
	Customer getByPasswordResetToken(String storeCode, String token);

	/**
	 * Return an {@link com.swaraj.core.business.common.model.Address} object from the client IP address. Uses underlying GeoLocation module
	 * @param store
	 * @param ipAddress
	 * @return
	 * @throws ServiceException
	 */
	Address getCustomerAddress(MerchantStore store, String ipAddress)
			throws ServiceException;


}
