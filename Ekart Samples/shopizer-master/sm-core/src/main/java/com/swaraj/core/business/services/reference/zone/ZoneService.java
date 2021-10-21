package com.swaraj.core.business.services.reference.zone;

import java.util.List;
import java.util.Map;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.reference.country.Country;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.reference.zone.Zone;
import com.swaraj.core.model.reference.zone.ZoneDescription;

public interface ZoneService extends SalesManagerEntityService<Long, Zone> {
	
	Zone getByCode(String code);

	void addDescription(Zone zone, ZoneDescription description) throws ServiceException;

	List<Zone> getZones(Country country, Language language)
			throws ServiceException;

	Map<String, Zone> getZones(Language language) throws ServiceException;

	List<Zone> getZones(String countryCode, Language language) throws ServiceException;


}
