package com.swaraj.shop.populator.references;

import org.apache.commons.collections4.CollectionUtils;

import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.utils.AbstractDataPopulator;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.reference.zone.Zone;
import com.swaraj.core.model.reference.zone.ZoneDescription;
import com.swaraj.shop.model.references.ReadableZone;

public class ReadableZonePopulator extends AbstractDataPopulator<Zone, ReadableZone> {

	@Override
	public ReadableZone populate(Zone source, ReadableZone target, MerchantStore store, Language language)
			throws ConversionException {
		if(target==null) {
			target = new ReadableZone();
		}
		
		target.setId(source.getId());
		target.setCode(source.getCode());
		target.setCountryCode(source.getCountry().getIsoCode());
		
		if(!CollectionUtils.isEmpty(source.getDescriptions())) {
			for(ZoneDescription d : source.getDescriptions()) {
				if(d.getLanguage().getId() == language.getId()) {
					target.setName(d.getName());
					continue;
				}
			}
		}
		
		return target;
		
	}

	@Override
	protected ReadableZone createTarget() {
		// TODO Auto-generated method stub
		return null;
	}

}
