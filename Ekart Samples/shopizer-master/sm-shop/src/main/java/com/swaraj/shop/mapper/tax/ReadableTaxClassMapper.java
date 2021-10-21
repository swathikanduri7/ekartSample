package com.swaraj.shop.mapper.tax;

import org.springframework.stereotype.Component;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.tax.taxclass.TaxClass;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.tax.ReadableTaxClass;

@Component
public class ReadableTaxClassMapper implements Mapper<TaxClass, ReadableTaxClass> {

	@Override
	public ReadableTaxClass convert(TaxClass source, MerchantStore store, Language language) {
		ReadableTaxClass taxClass = new ReadableTaxClass();
		taxClass.setId(source.getId());
		taxClass.setCode(source.getCode());
		taxClass.setName(source.getTitle());
		taxClass.setStore(store.getCode());
		return taxClass;
	}

	@Override
	public ReadableTaxClass merge(TaxClass source, ReadableTaxClass destination, MerchantStore store,
								  Language language) {
		destination.setId(source.getId());
		destination.setCode(source.getCode());
		destination.setName(source.getTitle());
		destination.setStore(store.getCode());
		return destination;
	}

}
