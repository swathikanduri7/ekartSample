package com.swaraj.core.business.services.system.optin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.repositories.system.OptinRepository;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityServiceImpl;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.system.optin.Optin;
import com.swaraj.core.model.system.optin.OptinType;

@Service
public class OptinServiceImpl extends SalesManagerEntityServiceImpl<Long, Optin> implements OptinService {
	
	
	private OptinRepository optinRepository;
	
	@Inject
	public OptinServiceImpl(OptinRepository optinRepository) {
		super(optinRepository);
		this.optinRepository = optinRepository;
	}


	@Override
	public Optin getOptinByCode(MerchantStore store, String code) throws ServiceException {
		return optinRepository.findByMerchantAndCode(store.getId(), code);
	}

	@Override
	public Optin getOptinByMerchantAndType(MerchantStore store, OptinType type) throws ServiceException {
		return optinRepository.findByMerchantAndType(store.getId(), type);
	}

}
