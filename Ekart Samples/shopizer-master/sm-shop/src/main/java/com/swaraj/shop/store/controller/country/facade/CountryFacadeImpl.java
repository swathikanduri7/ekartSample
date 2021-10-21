package com.swaraj.shop.store.controller.country.facade;

import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.reference.country.CountryService;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.country.Country;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.references.ReadableCountry;
import com.swaraj.shop.populator.references.ReadableCountryPopulator;
import com.swaraj.shop.store.api.exception.ConversionRuntimeException;
import com.swaraj.shop.store.api.exception.ServiceRuntimeException;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class CountryFacadeImpl implements CountryFacade {

  @Inject
  private CountryService countryService;

  @Override
  public List<ReadableCountry> getListCountryZones(Language language, MerchantStore merchantStore) {
    return getListOfCountryZones(language)
        .stream()
        .map(country -> convertToReadableCountry(country, language, merchantStore))
        .collect(Collectors.toList());
  }

  private ReadableCountry convertToReadableCountry(Country country, Language language, MerchantStore merchantStore) {
    try{
      ReadableCountryPopulator populator = new ReadableCountryPopulator();
      return populator.populate(country, new ReadableCountry(), merchantStore, language);
    } catch (ConversionException e) {
      throw new ConversionRuntimeException(e);
    }
  }

  private List<Country> getListOfCountryZones(Language language) {
    try{
      return countryService.listCountryZones(language);
    } catch (ServiceException e) {
      throw new ServiceRuntimeException(e);
    }
  }
}
