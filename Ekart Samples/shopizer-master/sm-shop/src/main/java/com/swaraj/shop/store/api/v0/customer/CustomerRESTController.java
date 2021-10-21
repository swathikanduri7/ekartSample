package com.swaraj.shop.store.api.v0.customer;

import com.swaraj.core.business.services.customer.CustomerService;
import com.swaraj.core.business.services.customer.attribute.CustomerOptionService;
import com.swaraj.core.business.services.customer.attribute.CustomerOptionValueService;
import com.swaraj.core.business.services.merchant.MerchantStoreService;
import com.swaraj.shop.admin.model.userpassword.UserReset;
import com.swaraj.shop.constants.Constants;
import com.swaraj.shop.model.customer.PersistableCustomer;
import com.swaraj.shop.model.customer.ReadableCustomer;
import com.swaraj.shop.model.customer.attribute.PersistableCustomerOption;
import com.swaraj.shop.model.customer.attribute.PersistableCustomerOptionValue;
import com.swaraj.shop.populator.customer.CustomerPopulator;
import com.swaraj.shop.populator.customer.PersistableCustomerOptionPopulator;
import com.swaraj.shop.populator.customer.PersistableCustomerOptionValuePopulator;
import com.swaraj.shop.populator.customer.ReadableCustomerPopulator;
import com.swaraj.shop.store.api.v0.category.ShoppingCategoryRESTController;
import com.swaraj.shop.utils.EmailTemplatesUtils;
import com.swaraj.shop.utils.LabelUtils;
import com.swaraj.shop.utils.LocaleUtils;
import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.reference.country.CountryService;
import com.swaraj.core.business.services.reference.language.LanguageService;
import com.swaraj.core.business.services.reference.zone.ZoneService;
import com.swaraj.core.business.services.system.EmailService;
import com.swaraj.core.business.services.user.GroupService;
import com.swaraj.core.model.customer.Customer;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.user.Group;
import com.swaraj.core.model.user.GroupType;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/services")
public class CustomerRESTController {

	@Inject
	private CustomerService customerService;
	
	@Inject
	private CustomerOptionValueService customerOptionValueService;
	
	@Inject
	private CustomerOptionService customerOptionService;
	
	
	@Inject
	private MerchantStoreService merchantStoreService;
	
	@Inject
	private LanguageService languageService;
	

	@Inject
	private CountryService countryService;
	
	@Inject
	private GroupService   groupService;
	
	@Inject
	private ZoneService zoneService;
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
	@Inject
	EmailService emailService;
	
	@Inject
	private LabelUtils messages;
	
	@Inject
	private EmailTemplatesUtils emailTemplatesUtils;
	
	@Autowired
	private CustomerPopulator customerPopulator;


	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCategoryRESTController.class);
	
	
	/**
	 * Returns a single customer for a given MerchantStore
	 */
	@RequestMapping( value="/private/{store}/customer/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ReadableCustomer getCustomer(@PathVariable final String store, @PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MerchantStore merchantStore = (MerchantStore)request.getAttribute(Constants.MERCHANT_STORE);
		if(merchantStore!=null) {
			if(!merchantStore.getCode().equals(store)) {
				merchantStore = null;
			}
		}
		
		if(merchantStore== null) {
			merchantStore = merchantStoreService.getByCode(store);
		}
		
		if(merchantStore==null) {
			LOGGER.error("Merchant store is null for code " + store);
			response.sendError(503, "Merchant store is null for code " + store);
			return null;
		}
		
		Customer customer = customerService.getById(id);
		com.swaraj.shop.model.customer.Customer customerProxy;
		if(customer == null){
			response.sendError(404, "No Customer found with id : " + id);
			return null;
		}
		
		ReadableCustomerPopulator populator = new ReadableCustomerPopulator();
		ReadableCustomer readableCustomer = new ReadableCustomer();
		populator.populate(customer, readableCustomer, merchantStore, merchantStore.getDefaultLanguage());
		
		return readableCustomer;
	}
	
	
	/**
	 * Create a customer option value
	 * @param store
	 * @param optionValue
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value="/private/{store}/customer/optionValue", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public PersistableCustomerOptionValue createCustomerOptionValue(@PathVariable final String store, @Valid @RequestBody PersistableCustomerOptionValue optionValue, HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		try {
			
			MerchantStore merchantStore = (MerchantStore)request.getAttribute(Constants.MERCHANT_STORE);
			if(merchantStore!=null) {
				if(!merchantStore.getCode().equals(store)) {
					merchantStore = null;
				}
			}
			
			if(merchantStore== null) {
				merchantStore = merchantStoreService.getByCode(store);
			}
			
			if(merchantStore==null) {
				LOGGER.error("Merchant store is null for code " + store);
				response.sendError(503, "Merchant store is null for code " + store);
				return null;
			}

			PersistableCustomerOptionValuePopulator populator = new PersistableCustomerOptionValuePopulator();
			populator.setLanguageService(languageService);
			
			com.swaraj.core.model.customer.attribute.CustomerOptionValue optValue = new com.swaraj.core.model.customer.attribute.CustomerOptionValue();
			populator.populate(optionValue, optValue, merchantStore, merchantStore.getDefaultLanguage());
		
			customerOptionValueService.save(optValue);
			
			optionValue.setId(optValue.getId());
			
			return optionValue;
			
		} catch (Exception e) {
			LOGGER.error("Error while saving customer option value",e);
			try {
				response.sendError(503, "Error while saving product option value" + e.getMessage());
			} catch (Exception ignore) {
			}	
			return null;
		}
	}
	
	/**
	 * Create a customer option
	 * @param store
	 * @param option
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value="/private/{store}/customer/option", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public PersistableCustomerOption createCustomerOption(@PathVariable final String store, @Valid @RequestBody PersistableCustomerOption option, HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		try {
			
			MerchantStore merchantStore = (MerchantStore)request.getAttribute(Constants.MERCHANT_STORE);
			if(merchantStore!=null) {
				if(!merchantStore.getCode().equals(store)) {
					merchantStore = null;
				}
			}
			
			if(merchantStore== null) {
				merchantStore = merchantStoreService.getByCode(store);
			}
			
			if(merchantStore==null) {
				LOGGER.error("Merchant store is null for code " + store);
				response.sendError(503, "Merchant store is null for code " + store);
				return null;
			}

			PersistableCustomerOptionPopulator populator = new PersistableCustomerOptionPopulator();
			populator.setLanguageService(languageService);
			
			com.swaraj.core.model.customer.attribute.CustomerOption opt = new com.swaraj.core.model.customer.attribute.CustomerOption();
			populator.populate(option, opt, merchantStore, merchantStore.getDefaultLanguage());
		
			customerOptionService.save(opt);
			
			option.setId(opt.getId());
			
			return option;
			
		} catch (Exception e) {
			LOGGER.error("Error while saving customer option",e);
			try {
				response.sendError(503, "Error while saving product option value" + e.getMessage());
			} catch (Exception ignore) {
			}	
			return null;
		}
	}
	
	
	/**
	 * Returns all customers for a given MerchantStore
	 */
	@RequestMapping( value="/private/{store}/customer", method=RequestMethod.GET)
	@ResponseBody
	public List<ReadableCustomer> getCustomers(@PathVariable final String store, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MerchantStore merchantStore = (MerchantStore)request.getAttribute(Constants.MERCHANT_STORE);
		if(merchantStore!=null) {
			if(!merchantStore.getCode().equals(store)) {
				merchantStore = null;
			}
		}
		
		if(merchantStore== null) {
			merchantStore = merchantStoreService.getByCode(store);
		}
		
		if(merchantStore==null) {
			LOGGER.error("Merchant store is null for code " + store);
			response.sendError(503, "Merchant store is null for code " + store);
			return null;
		}
		
		List<Customer> customers = customerService.getListByStore(merchantStore);
		List<ReadableCustomer> returnCustomers = new ArrayList<ReadableCustomer>();
		for(Customer customer : customers) {

			ReadableCustomerPopulator populator = new ReadableCustomerPopulator();
			ReadableCustomer readableCustomer = new ReadableCustomer();
			populator.populate(customer, readableCustomer, merchantStore, merchantStore.getDefaultLanguage());
			returnCustomers.add(readableCustomer);
			
		}
		
		return returnCustomers;
	}

	
	
	/**
	 * Deletes a customer for a given MerchantStore
	 */
	@RequestMapping( value="/private/{store}/customer/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable final String store, @PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		try {
			
			Customer customer = customerService.getById(id);
			
			if(customer==null) {
				response.sendError(404, "No Customer found for ID : " + id);
				return;
			} 
				
				MerchantStore merchantStore = merchantStoreService.getByCode(store);
				if(merchantStore == null) {
					response.sendError(404, "Invalid merchant store : " + store);
					return;
				}
				
				if(merchantStore.getId().intValue()!= customer.getMerchantStore().getId().intValue()){
					response.sendError(404, "Customer id: " + id + " is not part of store " + store);
					return;
				}			
				
				customerService.delete(customer);
			
			
		} catch (ServiceException se) {
			LOGGER.error("Cannot delete customer",se);
			response.sendError(404, "An exception occured while removing the customer");
			return;
		}

	}
	
	
	/**
	 * Create new customer for a given MerchantStore
	 */
	@RequestMapping( value="/private/{store}/customer", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@Deprecated
	public PersistableCustomer createCustomer(@PathVariable final String store, @Valid @RequestBody PersistableCustomer customer, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MerchantStore merchantStore = (MerchantStore)request.getAttribute(Constants.MERCHANT_STORE);
		if(merchantStore!=null) {
			if(!merchantStore.getCode().equals(store)) {
				merchantStore = null;
			}
		}
		
		if(merchantStore== null) {
			merchantStore = merchantStoreService.getByCode(store);
		}
		
		if(merchantStore==null) {
			LOGGER.error("Merchant store is null for code " + store);
			response.sendError(503, "Merchant store is null for code " + store);
			return null;
		}
		
		Customer cust = new Customer();
		
/*		CustomerPopulator populator = new CustomerPopulator();
		populator.setCountryService(countryService);
		populator.setCustomerOptionService(customerOptionService);
		populator.setCustomerOptionValueService(customerOptionValueService);
		populator.setLanguageService(languageService);
		populator.setZoneService(zoneService);
		populator.setGroupService(groupService);*/
		customerPopulator.populate(customer, cust, merchantStore, merchantStore.getDefaultLanguage());
		
		List<Group> groups = groupService.listGroup(GroupType.ADMIN);
		cust.setGroups(groups);

		Locale customerLocale = LocaleUtils.getLocale(cust.getDefaultLanguage());
		
		String password = customer.getPassword();
		if(StringUtils.isBlank(password)) {
			password = UserReset.generateRandomString();
			customer.setPassword(password);
		}


		customerService.save(cust);
		customer.setId(cust.getId());
		
		emailTemplatesUtils.sendRegistrationEmail(customer, merchantStore, customerLocale, request.getContextPath());


		return customer;
	}
	
}
