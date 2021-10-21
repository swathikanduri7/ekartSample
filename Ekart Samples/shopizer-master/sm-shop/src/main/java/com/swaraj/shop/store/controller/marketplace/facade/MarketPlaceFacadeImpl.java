package com.swaraj.shop.store.controller.marketplace.facade;

import java.util.Optional;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.system.optin.OptinService;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.system.optin.Optin;
import com.swaraj.core.model.system.optin.OptinType;
import com.swaraj.shop.model.marketplace.ReadableMarketPlace;
import com.swaraj.shop.model.store.ReadableMerchantStore;
import com.swaraj.shop.model.system.ReadableOptin;
import com.swaraj.shop.populator.system.ReadableOptinPopulator;
import com.swaraj.shop.store.api.exception.ConversionRuntimeException;
import com.swaraj.shop.store.api.exception.ResourceNotFoundException;
import com.swaraj.shop.store.api.exception.ServiceRuntimeException;
import com.swaraj.shop.store.controller.store.facade.StoreFacade;

@Component
public class MarketPlaceFacadeImpl implements MarketPlaceFacade {

	@Inject
	private StoreFacade storeFacade;

	@Inject
	private OptinService optinService;

	@Override
	public ReadableMarketPlace get(String store, Language lang) {
		ReadableMerchantStore readableStore = storeFacade.getByCode(store, lang);
    return createReadableMarketPlace(readableStore);
	}

  private ReadableMarketPlace createReadableMarketPlace(ReadableMerchantStore readableStore) {
    //TODO add info from Entity
    ReadableMarketPlace marketPlace = new ReadableMarketPlace();
    marketPlace.setStore(readableStore);
    return marketPlace;
  }

  @Override
	public ReadableOptin findByMerchantAndType(MerchantStore store, OptinType type) {
		Optin optin = getOptinByMerchantAndType(store, type);
    return convertOptinToReadableOptin(store, optin);
	}

  private Optin getOptinByMerchantAndType(MerchantStore store, OptinType type) {
	  try{
      return Optional.ofNullable(optinService.getOptinByMerchantAndType(store, type))
          .orElseThrow(() -> new ResourceNotFoundException("Option not found"));
    } catch (ServiceException e) {
	    throw new ServiceRuntimeException(e);
    }

  }

  private ReadableOptin convertOptinToReadableOptin(MerchantStore store, Optin optin) {
	  try{
      ReadableOptinPopulator populator = new ReadableOptinPopulator();
      return populator.populate(optin, null, store, null);
    } catch (ConversionException e) {
	    throw new ConversionRuntimeException(e);
    }

  }

}
