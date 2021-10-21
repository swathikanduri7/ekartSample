package com.swaraj.shop.store.api.v1.references;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.currency.Currency;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.references.MeasureUnit;
import com.swaraj.shop.model.references.ReadableCountry;
import com.swaraj.shop.model.references.ReadableZone;
import com.swaraj.shop.model.references.SizeReferences;
import com.swaraj.shop.model.references.WeightUnit;
import com.swaraj.shop.store.controller.country.facade.CountryFacade;
import com.swaraj.shop.store.controller.currency.facade.CurrencyFacade;
import com.swaraj.shop.store.controller.language.facade.LanguageFacade;
import com.swaraj.shop.store.controller.store.facade.StoreFacade;
import com.swaraj.shop.store.controller.zone.facade.ZoneFacade;
import com.swaraj.shop.utils.LanguageUtils;

/**
 * Get system Language, Country and Currency objects
 *
 * @author c.samson
 */
@RestController
@RequestMapping("/api/v1")
public class ReferencesApi {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReferencesApi.class);


  @Inject private StoreFacade storeFacade;

  @Inject private LanguageUtils languageUtils;

  @Inject private LanguageFacade languageFacade;

  @Inject private CountryFacade countryFacade;

  @Inject private ZoneFacade zoneFacade;

  @Inject private CurrencyFacade currencyFacade;

  /**
   * Search languages by language code private/languages returns everything
   *
   * @return
   */
  @GetMapping("/languages")
  public List<Language> getLanguages() {
    return languageFacade.getLanguages();
  }

  /**
   * Returns a country with zones (provinces, states) supports language set in parameter
   * ?lang=en|fr|ru...
   *
   * @param request
   * @return
   */
  @GetMapping("/country")
  public List<ReadableCountry> getCountry(HttpServletRequest request) {
    MerchantStore merchantStore = storeFacade.getByCode(request);
    Language lang = languageUtils.getRESTLanguage(request);
    return countryFacade.getListCountryZones(lang, merchantStore);
  }

  @GetMapping("/zones")
  public List<ReadableZone> getZones(
      @RequestParam("code") String code, HttpServletRequest request) {
    MerchantStore merchantStore = storeFacade.getByCode(request);
    Language lang = languageUtils.getRESTLanguage(request);
    return zoneFacade.getZones(code, lang, merchantStore);
  }

  /**
   * Currency
   *
   * @return
   */
  @GetMapping("/currency")
  public List<Currency> getCurrency() {
    return currencyFacade.getList();
  }

  @GetMapping("/measures")
  public SizeReferences measures() {
    SizeReferences sizeReferences = new SizeReferences();
    sizeReferences.setMeasures(Arrays.asList(MeasureUnit.values()));
    sizeReferences.setWeights(Arrays.asList(WeightUnit.values()));
    return sizeReferences;
  }
}
