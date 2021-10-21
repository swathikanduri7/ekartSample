package com.swaraj.core.business.modules.cms.product;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.catalog.product.Product;
import com.swaraj.core.model.catalog.product.image.ProductImage;
import com.swaraj.core.business.modules.cms.common.ImageRemove;


public interface ProductImageRemove extends ImageRemove {

  void removeProductImage(ProductImage productImage) throws ServiceException;

  void removeProductImages(Product product) throws ServiceException;

}
