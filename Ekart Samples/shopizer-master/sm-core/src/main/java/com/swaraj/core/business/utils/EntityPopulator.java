/**
 * 
 */
package com.swaraj.core.business.utils;

import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.model.merchant.MerchantStore;

/**
 * @author Umesh A
 *
 */
public interface EntityPopulator<Source,Target>
{

    Target populateToEntity(Source source, Target target, MerchantStore store)  throws ConversionException;
    Target populateToEntity(Source source) throws ConversionException;
}
