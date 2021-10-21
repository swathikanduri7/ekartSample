package com.swaraj.shop.store.controller.zone.facade;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.reference.zone.Zone;
import com.swaraj.shop.model.references.ReadableZone;

import java.util.List;

public interface ZoneFacade {

  List<ReadableZone> getZones(String countryCode, Language language, MerchantStore merchantStore);

}
