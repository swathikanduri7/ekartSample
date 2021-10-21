package com.swaraj.shop.store.controller.country.facade;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.country.Country;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.references.ReadableCountry;

import java.util.List;

public interface CountryFacade {
  List<ReadableCountry> getListCountryZones(Language language, MerchantStore merchantStore);
}
