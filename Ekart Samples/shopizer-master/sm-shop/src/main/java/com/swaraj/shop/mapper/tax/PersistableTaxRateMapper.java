package com.swaraj.shop.mapper.tax;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swaraj.core.business.services.reference.country.CountryService;
import com.swaraj.core.business.services.reference.language.LanguageService;
import com.swaraj.core.business.services.reference.zone.ZoneService;
import com.swaraj.core.business.services.tax.TaxClassService;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.tax.taxrate.TaxRate;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.tax.PersistableTaxRate;
import com.swaraj.shop.model.tax.TaxRateDescription;
import com.swaraj.shop.store.api.exception.ServiceRuntimeException;

@Component
public class PersistableTaxRateMapper implements Mapper<PersistableTaxRate, TaxRate> {
	
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private ZoneService zoneService;
	
	@Autowired
	private LanguageService languageService;
	
	@Autowired
	private TaxClassService taxClassService;

	@Override
	public TaxRate convert(PersistableTaxRate source, MerchantStore store, Language language) {
		TaxRate rate = new TaxRate();
		return this.merge(source, rate, store, language);
	}

	@Override
	public TaxRate merge(PersistableTaxRate source, TaxRate destination, MerchantStore store, Language language) {
		Validate.notNull(destination, "destination TaxRate cannot be null");
		Validate.notNull(source, "source TaxRate cannot be null");
		try {
			destination.setId(source.getId());
			destination.setCode(source.getCode());
			destination.setTaxPriority(source.getPriority());
			
			destination.setCountry(countryService.getByCode(source.getCountry()));
			destination.setZone(zoneService.getByCode(source.getZone()));
			destination.setStateProvince(source.getZone());
			destination.setMerchantStore(store);
			destination.setTaxClass(taxClassService.getByCode(source.getTaxClass(), store));
			destination.setTaxRate(source.getRate());
			this.taxRate(destination, source);
			
			return destination;
		
		} catch (Exception e) {
			throw new ServiceRuntimeException("An error occured withe creating tax rate",e);
		}
		

		
		
	}
	
	private com.swaraj.core.model.tax.taxrate.TaxRate taxRate(com.swaraj.core.model.tax.taxrate.TaxRate destination, PersistableTaxRate source) throws Exception {
		//List<com.swaraj.core.model.tax.taxrate.TaxRateDescription> descriptions = new ArrayList<com.swaraj.core.model.tax.taxrate.TaxRateDescription>();
		
	      if(!CollectionUtils.isEmpty(source.getDescriptions())) {
	          for(TaxRateDescription desc : source.getDescriptions()) {
	        	com.swaraj.core.model.tax.taxrate.TaxRateDescription description = null;
	            if(!CollectionUtils.isEmpty(destination.getDescriptions())) {
	              for(com.swaraj.core.model.tax.taxrate.TaxRateDescription d : destination.getDescriptions()) {
	                if(!StringUtils.isBlank(desc.getLanguage()) && desc.getLanguage().equals(d.getLanguage().getCode())) {
	              	  d.setDescription(desc.getDescription());
	              	  d.setName(desc.getName());
	              	  d.setTitle(desc.getTitle());
	              	  description = d;
	              	  break;
	                } 
	              }
	            } 
	            if(description == null) {
	  	          description = description(desc);
	  	          description.setTaxRate(destination);
	  	          destination.getDescriptions().add(description);
	            }
	          }
	        }

	        return destination;

	}
	
	private com.swaraj.core.model.tax.taxrate.TaxRateDescription description(TaxRateDescription source) throws Exception {
		
		
	    Validate.notNull(source.getLanguage(),"description.language should not be null");
	    com.swaraj.core.model.tax.taxrate.TaxRateDescription desc = new com.swaraj.core.model.tax.taxrate.TaxRateDescription();
	    desc.setId(null);
	    desc.setDescription(source.getDescription());
	    desc.setName(source.getName());
	    if(source.getId() != null && source.getId().longValue()>0) {
	      desc.setId(source.getId());
	    }
	    Language lang = languageService.getByCode(source.getLanguage());
	    desc.setLanguage(lang);
	    return desc;
		

		
	}



}
