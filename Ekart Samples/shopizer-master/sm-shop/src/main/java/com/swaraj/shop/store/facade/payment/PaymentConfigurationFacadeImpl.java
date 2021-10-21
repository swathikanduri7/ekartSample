package com.swaraj.shop.store.facade.payment;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.payments.PaymentService;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.payments.PaymentMethod;
import com.swaraj.core.model.system.IntegrationConfiguration;
import com.swaraj.shop.model.configuration.PersistableConfiguration;
import com.swaraj.shop.model.configuration.ReadableConfiguration;
import com.swaraj.shop.store.api.exception.ServiceRuntimeException;
import com.swaraj.shop.store.controller.configurations.ConfigurationsFacade;


@Service("paymentConfigurationFacade")
public class PaymentConfigurationFacadeImpl implements ConfigurationsFacade {
	
	
	@Autowired
	private PaymentService paymentService;

	@Override
	public List<ReadableConfiguration> configurations(MerchantStore store) {
		
		try {
			
			List<PaymentMethod> methods = paymentService.getAcceptedPaymentMethods(store);
			List<ReadableConfiguration> configurations = 
					methods.stream()
					.map(m -> configuration(m.getInformations(), store)).collect(Collectors.toList());
			return configurations;
			
		} catch (ServiceException e) {
			throw new ServiceRuntimeException("Error while getting payment configurations",e);
		}

	}

	@Override
	public ReadableConfiguration configuration(String module, MerchantStore store) {
		
		try {
			
			ReadableConfiguration config = null;
			List<PaymentMethod> methods = paymentService.getAcceptedPaymentMethods(store);
			Optional<ReadableConfiguration> configuration = 
					methods.stream()
					.filter(m -> module.equals(m.getModule().getCode()))
					.map(m -> this.configuration(m.getInformations(), store))
					.findFirst();
			
			if(configuration.isPresent()) {
				config = configuration.get();
			}
			
			return config;
		
		} catch (ServiceException e) {
			throw new ServiceRuntimeException("Error while getting payment configuration [" + module + "]",e);
		}

	}

	@Override
	public void saveConfiguration(PersistableConfiguration configuration, MerchantStore store) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteConfiguration(String module, MerchantStore store) {
		// TODO Auto-generated method stub

	}

	
	private ReadableConfiguration configuration(IntegrationConfiguration source, MerchantStore store) {
		
		ReadableConfiguration config = new ReadableConfiguration();
		config.setActive(source.isActive());
		config.setCode(source.getModuleCode());
		config.setKeys(source.getIntegrationKeys());
		config.setIntegrationOptions(source.getIntegrationOptions());
		
		return config;
	}


}
