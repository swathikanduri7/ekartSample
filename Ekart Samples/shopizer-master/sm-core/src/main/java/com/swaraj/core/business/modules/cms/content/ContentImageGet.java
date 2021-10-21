package com.swaraj.core.business.modules.cms.content;

import java.util.List;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.modules.cms.common.ImageGet;
import com.swaraj.core.model.content.FileContentType;
import com.swaraj.core.model.content.OutputContentFile;

public interface ContentImageGet extends ImageGet {

  OutputContentFile getImage(final String merchantStoreCode, String imageName,
      FileContentType imageContentType) throws ServiceException;

  List<String> getImageNames(final String merchantStoreCode,
      FileContentType imageContentType) throws ServiceException;

}
