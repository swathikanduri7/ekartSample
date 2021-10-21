package com.swaraj.shop.mapper.optin;

import org.springframework.stereotype.Component;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.system.optin.Optin;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.system.ReadableOptin;

@Component
public class ReadableOptinMapper implements Mapper<Optin, ReadableOptin> {


  @Override
  public ReadableOptin convert(Optin source, MerchantStore store, Language language) {
    ReadableOptin optinEntity = new ReadableOptin();
    optinEntity.setCode(source.getCode());
    optinEntity.setDescription(source.getDescription());
    optinEntity.setOptinType(source.getOptinType().name());
    return optinEntity;
  }

  @Override
  public ReadableOptin merge(Optin source, ReadableOptin destination, MerchantStore store,
                             Language language) {
    return destination;
  }
}
