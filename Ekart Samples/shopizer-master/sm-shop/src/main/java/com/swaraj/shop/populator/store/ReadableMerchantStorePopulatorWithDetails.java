package com.swaraj.shop.populator.store;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.store.ReadableMerchantStore;

/**
 * Populates MerchantStore core entity model object with more complete details than the traditional ReadableMerchantStorePopulator
 * @author rui pereira
 *
 */
public class ReadableMerchantStorePopulatorWithDetails extends
		ReadableMerchantStorePopulator {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public ReadableMerchantStore populate(MerchantStore source,
			ReadableMerchantStore target, MerchantStore store, Language language)
			throws ConversionException {

		target = super.populate(source, target, store, language);

		target.setTemplate(source.getStoreTemplate());

		// TODO Add more as needed

		return target;
	}

	@Override
	protected ReadableMerchantStore createTarget() {
		// TODO Auto-generated method stub
		return null;
	}

}
