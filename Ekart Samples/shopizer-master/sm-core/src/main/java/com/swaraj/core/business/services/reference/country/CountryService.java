package com.swaraj.core.business.services.reference.country;

import java.util.List;
import java.util.Map;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.reference.country.Country;
import com.swaraj.core.model.reference.country.CountryDescription;
import com.swaraj.core.model.reference.language.Language;

public interface CountryService extends SalesManagerEntityService<Integer, Country> {

	Country getByCode(String code) throws ServiceException;
	
	void addCountryDescription(Country country, CountryDescription description) throws ServiceException;

	List<Country> getCountries(Language language) throws ServiceException;

	Map<String, Country> getCountriesMap(Language language)
			throws ServiceException;

	List<Country> getCountries(List<String> isoCodes, Language language)
			throws ServiceException;
	
	
	/**
	 * List country - zone objects by language
	 * @param language
	 * @return
	 * @throws ServiceException
	 */
	List<Country> listCountryZones(Language language) throws ServiceException;
}
