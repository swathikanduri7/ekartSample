package com.swaraj.shop.mapper.tax;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.tax.taxclass.TaxClass;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.tax.PersistableTaxClass;

@Component
public class PersistableTaxClassMapper implements Mapper<PersistableTaxClass, TaxClass> {

	@Override
	public TaxClass convert(PersistableTaxClass source, MerchantStore store, Language language) {
		Validate.notNull(source, "PersistableTaxClass cannot be null");
		Validate.notNull(store, "MerchantStore cannot be null");
		TaxClass taxClass = new TaxClass();
		taxClass.setMerchantStore(store);
		taxClass.setTitle(source.getName());
		taxClass.setId(source.getId());
		return this.merge(source, taxClass, store, language);
	}

	@Override
	public TaxClass merge(PersistableTaxClass source, TaxClass destination, MerchantStore store, Language language) {
		Validate.notNull(source, "PersistableTaxClass cannot be null");
		Validate.notNull(destination, "TaxClass cannot be null");
		Validate.notNull(store, "MerchantStore cannot be null");
		
		destination.setCode(source.getCode());
		if(source.getId()!=null && source.getId().longValue() > 0) {
			destination.setId(source.getId());
		}
		destination.setMerchantStore(store);
		destination.setTitle(source.getName());
		
		return destination;
	}

}
