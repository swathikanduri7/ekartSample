package com.swaraj.shop.store.controller.optin;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.system.PersistableOptin;
import com.swaraj.shop.model.system.ReadableOptin;

public interface OptinFacade {

  ReadableOptin create(PersistableOptin persistableOptin, MerchantStore merchantStore, Language language);
}
