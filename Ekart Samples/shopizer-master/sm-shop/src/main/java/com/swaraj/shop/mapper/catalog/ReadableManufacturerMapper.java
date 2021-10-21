package com.swaraj.shop.mapper.catalog;

import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Component;

import com.swaraj.core.model.catalog.product.manufacturer.Manufacturer;
import com.swaraj.core.model.catalog.product.manufacturer.ManufacturerDescription;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.catalog.manufacturer.ReadableManufacturer;

@Component
public class ReadableManufacturerMapper implements Mapper<Manufacturer, ReadableManufacturer> {

  @Override
  public ReadableManufacturer convert(Manufacturer source, MerchantStore store, Language language) {

	if(language == null) {
		language = store.getDefaultLanguage();
	}
    ReadableManufacturer target = new ReadableManufacturer();

    Optional<com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription> description =
        getDescription(source, language, target);
    description.ifPresent(target::setDescription);

    target.setCode(source.getCode());
    target.setId(source.getId());
    target.setOrder(source.getOrder());
    Optional<com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription> desc = this.getDescription(source, language, target);
    if(description.isPresent()) {
    	target.setDescription(desc.get());
    }
    

    return target;
  }

  private Optional<com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription> getDescription(
      Manufacturer source, Language language, ReadableManufacturer target) {

    Optional<ManufacturerDescription> description =
        getDescription(source.getDescriptions(), language);
    if (source.getDescriptions() != null && !source.getDescriptions().isEmpty()
        && description.isPresent()) {
      return Optional.of(convertDescription(description.get(), source));
    } else {
      return Optional.empty();
    }
  }

  private Optional<ManufacturerDescription> getDescription(
      Set<ManufacturerDescription> descriptionsLang, Language language) {
    Optional<ManufacturerDescription> descriptionByLang = descriptionsLang.stream()
        .filter(desc -> desc.getLanguage().getCode().equals(language.getCode())).findAny();
    if (descriptionByLang.isPresent()) {
      return descriptionByLang;
    } else {
      return Optional.empty();
    }
  }

  private com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription convertDescription(
      ManufacturerDescription description, Manufacturer source) {
    final com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription desc =
        new com.swaraj.shop.model.catalog.manufacturer.ManufacturerDescription();

    desc.setFriendlyUrl(description.getUrl());
    desc.setId(description.getId());
    desc.setLanguage(description.getLanguage().getCode());
    desc.setName(description.getName());
    desc.setDescription(description.getDescription());
    return desc;
  }

  @Override
  public ReadableManufacturer merge(Manufacturer source, ReadableManufacturer destination,
                                    MerchantStore store, Language language) {
    return destination;
  }

}
