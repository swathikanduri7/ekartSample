package com.swaraj.shop.store.controller.system;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.system.Configs;

public interface MerchantConfigurationFacade {

  Configs getMerchantConfig(MerchantStore merchantStore, Language language);

}
