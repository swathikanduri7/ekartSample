/**
 * 
 */
package com.swaraj.core.business.utils;

import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;

/**
 * @author Umesh A
 *
 */
public interface DataPopulator<Source,Target> {

    Target populate(Source source,Target target, MerchantStore store, Language language) throws ConversionException;
    Target populate(Source source, MerchantStore store, Language language) throws ConversionException;

}
