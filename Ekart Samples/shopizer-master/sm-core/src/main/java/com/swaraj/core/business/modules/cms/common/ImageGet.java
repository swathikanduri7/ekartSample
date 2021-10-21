package com.swaraj.core.business.modules.cms.common;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.content.FileContentType;
import com.swaraj.core.model.content.OutputContentFile;

import java.util.List;

public interface ImageGet {

  List<OutputContentFile> getImages(final String merchantStoreCode,
      FileContentType imageContentType) throws ServiceException;

}
