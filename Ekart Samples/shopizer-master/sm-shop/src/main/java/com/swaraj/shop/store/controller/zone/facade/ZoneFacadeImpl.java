package com.swaraj.shop.store.controller.zone.facade;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.reference.zone.ZoneService;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.reference.zone.Zone;
import com.swaraj.shop.model.references.ReadableZone;
import com.swaraj.shop.populator.references.ReadableZonePopulator;
import com.swaraj.shop.store.api.exception.ConversionRuntimeException;
import com.swaraj.shop.store.api.exception.ServiceRuntimeException;

@Service
public class ZoneFacadeImpl implements ZoneFacade {

  @Inject
  private ZoneService zoneService;

  @Override
  public List<ReadableZone> getZones(String countryCode, Language language, MerchantStore merchantStore) {
    List<Zone> listZones = getListZones(countryCode, language);
    if (listZones.isEmpty()){
    	return Collections.emptyList();   
      //throw new ResourceNotFoundException("No zones found");
    }
    return listZones.stream()
        .map(zone -> convertToReadableZone(zone, language, merchantStore))
        .collect(Collectors.toList());
  }

  private ReadableZone convertToReadableZone(Zone zone, Language language, MerchantStore merchantStore) {
    try{
      ReadableZonePopulator populator = new ReadableZonePopulator();
      return populator.populate(zone, new ReadableZone(), merchantStore, language);
    } catch (ConversionException e){
      throw new ConversionRuntimeException(e);
    }
  }

  private List<Zone> getListZones(String countryCode, Language language) {
    try{
      return zoneService.getZones(countryCode, language);
    } catch (ServiceException e){
      throw new ServiceRuntimeException(e);
    }
  }
}
