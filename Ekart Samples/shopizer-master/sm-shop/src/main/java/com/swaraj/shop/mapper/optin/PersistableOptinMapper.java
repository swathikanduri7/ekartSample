package com.swaraj.shop.mapper.optin;

import org.springframework.stereotype.Component;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.system.optin.Optin;
import com.swaraj.core.model.system.optin.OptinType;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.system.PersistableOptin;

@Component
public class PersistableOptinMapper implements Mapper<PersistableOptin, Optin> {


  @Override
  public Optin convert(PersistableOptin source, MerchantStore store, Language language) {
    Optin optinEntity = new Optin();
    optinEntity.setCode(source.getCode());
    optinEntity.setDescription(source.getDescription());
    optinEntity.setOptinType(OptinType.valueOf(source.getOptinType()));
    optinEntity.setMerchant(store);
    return optinEntity;
  }

  @Override
  public Optin merge(PersistableOptin source, Optin destination, MerchantStore store,
                     Language language) {
    return destination;
  }
}
