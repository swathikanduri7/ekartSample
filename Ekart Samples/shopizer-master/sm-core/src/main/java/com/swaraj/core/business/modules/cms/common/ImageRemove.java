package com.swaraj.core.business.modules.cms.common;

import com.swaraj.core.business.exception.ServiceException;


public interface ImageRemove {

  void removeImages(final String merchantStoreCode) throws ServiceException;

}
