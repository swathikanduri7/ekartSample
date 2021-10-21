package com.swaraj.shop.store.controller.optin;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.system.optin.OptinService;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.system.optin.Optin;
import com.swaraj.shop.mapper.optin.PersistableOptinMapper;
import com.swaraj.shop.mapper.optin.ReadableOptinMapper;
import com.swaraj.shop.model.system.PersistableOptin;
import com.swaraj.shop.model.system.ReadableOptin;
import com.swaraj.shop.store.api.exception.ServiceRuntimeException;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class OptinFacadeImpl implements OptinFacade {

  @Inject
  private OptinService optinService;

  @Inject
  private ReadableOptinMapper readableOptinConverter;
  @Inject
  private PersistableOptinMapper persistableOptinConverter;

  @Override
  public ReadableOptin create(
      PersistableOptin persistableOptin, MerchantStore merchantStore, Language language) {
    Optin optinEntity = persistableOptinConverter.convert(persistableOptin, merchantStore, language);
    Optin savedOptinEntity = createOptin(optinEntity);
    return readableOptinConverter.convert(savedOptinEntity, merchantStore, language);
  }

  private Optin createOptin(Optin optinEntity) {
    try{
      optinService.create(optinEntity);
      return optinEntity;
    } catch (ServiceException e){
      throw new ServiceRuntimeException(e);
    }

  }
}
