package com.swaraj.shop.mapper.catalog;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.swaraj.core.model.catalog.product.attribute.ProductOptionValue;
import com.swaraj.core.model.catalog.product.attribute.ProductOptionValueDescription;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.shop.mapper.Mapper;
import com.swaraj.shop.model.catalog.product.attribute.api.ReadableProductOptionValueEntity;
import com.swaraj.shop.model.catalog.product.attribute.api.ReadableProductOptionValueFull;
import com.swaraj.shop.utils.ImageFilePath;

@Component
public class ReadableProductOptionValueMapper implements Mapper<ProductOptionValue, ReadableProductOptionValueEntity> {

  @Autowired
  @Qualifier("img")
  private ImageFilePath imageUtils;

  @Override
  public ReadableProductOptionValueEntity merge(ProductOptionValue source, ReadableProductOptionValueEntity destination,
                                                MerchantStore store, Language language) {
    ReadableProductOptionValueEntity readableProductOptionValue = new ReadableProductOptionValueEntity();
    if(language == null) {
    	readableProductOptionValue = new ReadableProductOptionValueFull();
      List<com.swaraj.shop.model.catalog.product.attribute.ProductOptionValueDescription> descriptions = new ArrayList<com.swaraj.shop.model.catalog.product.attribute.ProductOptionValueDescription>();
      for(ProductOptionValueDescription desc : source.getDescriptions()) {
          com.swaraj.shop.model.catalog.product.attribute.ProductOptionValueDescription d = this.description(desc);
          descriptions.add(d);
      }
      ((ReadableProductOptionValueFull)readableProductOptionValue).setDescriptions(descriptions);
    } else {
    	readableProductOptionValue = new ReadableProductOptionValueEntity();
      if(!CollectionUtils.isEmpty(source.getDescriptions())) {
        for(ProductOptionValueDescription desc : source.getDescriptions()) {
          if(desc != null && desc.getLanguage()!= null && desc.getLanguage().getId() == language.getId()) {
            com.swaraj.shop.model.catalog.product.attribute.ProductOptionValueDescription d = this.description(desc);
            readableProductOptionValue.setDescription(d);
          }
        }
      }
    }
    
    readableProductOptionValue.setCode(source.getCode());
    if(source.getId()!=null) {
    	readableProductOptionValue.setId(source.getId().longValue());
    }
    if(source.getProductOptionValueSortOrder()!=null) {
    	readableProductOptionValue.setOrder(source.getProductOptionValueSortOrder().intValue());
    }
    if(!StringUtils.isBlank(source.getProductOptionValueImage())) {
    	readableProductOptionValue.setImage(imageUtils.buildProductPropertyImageUtils(store, source.getProductOptionValueImage()));
    }
    
    return readableProductOptionValue;
  }



  com.swaraj.shop.model.catalog.product.attribute.ProductOptionValueDescription description(ProductOptionValueDescription description) {
    com.swaraj.shop.model.catalog.product.attribute.ProductOptionValueDescription desc = new com.swaraj.shop.model.catalog.product.attribute.ProductOptionValueDescription();
    desc.setDescription(description.getDescription());
    desc.setName(description.getName());
    desc.setId(description.getId());
    desc.setLanguage(description.getLanguage().getCode());
    return desc;
  }


@Override
public ReadableProductOptionValueEntity convert(ProductOptionValue source, MerchantStore store, Language language) {
    ReadableProductOptionValueEntity destination = new ReadableProductOptionValueEntity();
    return merge(source, destination, store, language);
}

}