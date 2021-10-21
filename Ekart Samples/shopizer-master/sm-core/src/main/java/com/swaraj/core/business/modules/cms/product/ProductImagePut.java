package com.swaraj.core.business.modules.cms.product;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.catalog.product.image.ProductImage;
import com.swaraj.core.model.content.ImageContentFile;


public interface ProductImagePut {

  void addProductImage(ProductImage productImage, ImageContentFile contentImage)
      throws ServiceException;

}
