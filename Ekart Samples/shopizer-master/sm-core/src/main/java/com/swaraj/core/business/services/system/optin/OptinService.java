package com.swaraj.core.business.services.system.optin;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.system.optin.Optin;
import com.swaraj.core.model.system.optin.OptinType;

/**
 * Registers Optin events
 * @author carlsamson
 *
 */
public interface OptinService extends SalesManagerEntityService<Long, Optin> {
	
	
	Optin getOptinByMerchantAndType(MerchantStore store, OptinType type) throws ServiceException;
	Optin getOptinByCode(MerchantStore store, String code) throws ServiceException;

}
