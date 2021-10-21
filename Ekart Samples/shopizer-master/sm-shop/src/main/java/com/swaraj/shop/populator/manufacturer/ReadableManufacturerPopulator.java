package com.swaraj.shop.populator.manufacturer;

import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.utils.AbstractDataPopulator;
import com.swaraj.core.model.catalog.product.manufacturer.ManufacturerDescription;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.model.catalog.manufacturer.ReadableManufacturer;
import com.swaraj.shop.model.catalog.manufacturer.ReadableManufacturerFull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReadableManufacturerPopulator extends
    AbstractDataPopulator<com.swaraj.core.model.catalog.product.manufacturer.Manufacturer, ReadableManufacturer> {



  @Override
  public ReadableManufacturer populate(
      com.swaraj.core.model.catalog.product.manufacturer.Manufacturer source,
      ReadableManufacturer target, MerchantStore store, Language language)
      throws ConversionException {


    if (language == null) {
      target = new ReadableManufacturerFull();
    }
    target.setOrder(source.getOrder());
    target.setId(source.getId());
    target.setCode(source.getCode());
    if (source.getDescriptions() != null && source.getDescriptions().size() > 0) {

      List<com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription> fulldescriptions =
          new ArrayList<com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription>();

      Set<ManufacturerDescription> descriptions = source.getDescriptions();
      ManufacturerDescription description = null;
      for (ManufacturerDescription desc : descriptions) {
        if (language != null && desc.getLanguage().getCode().equals(language.getCode())) {
          description = desc;
          break;
        } else {
          fulldescriptions.add(populateDescription(desc));
        }
      }



      if (description != null) {
        com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription d =
            populateDescription(description);
        target.setDescription(d);
      }

      if (target instanceof ReadableManufacturerFull) {
        ((ReadableManufacturerFull) target).setDescriptions(fulldescriptions);
      }

    }



    return target;
  }

  @Override
  protected ReadableManufacturer createTarget() {
    return null;
  }

  com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription populateDescription(
      ManufacturerDescription description) {
    if (description == null) {
      return null;
    }
    com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription d =
        new com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription();
    d.setName(description.getName());
    d.setDescription(description.getDescription());
    d.setId(description.getId());
    d.setTitle(description.getTitle());
    if (description.getLanguage() != null) {
      d.setLanguage(description.getLanguage().getCode());
    }
    return d;
  }

}
