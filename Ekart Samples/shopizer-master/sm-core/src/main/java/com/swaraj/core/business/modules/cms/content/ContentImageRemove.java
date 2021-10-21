package com.swaraj.core.business.modules.cms.content;


import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.modules.cms.common.ImageRemove;
import com.swaraj.core.model.content.FileContentType;

public interface ContentImageRemove extends ImageRemove {



  void removeImage(final String merchantStoreCode, final FileContentType imageContentType,
      final String imageName) throws ServiceException;

}