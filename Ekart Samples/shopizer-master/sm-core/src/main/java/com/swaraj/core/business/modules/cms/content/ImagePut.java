package com.swaraj.core.business.modules.cms.content;

import java.util.List;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.content.InputContentFile;

public interface ImagePut {


  void addImage(final String merchantStoreCode, InputContentFile image)
      throws ServiceException;

  void addImages(final String merchantStoreCode, List<InputContentFile> imagesList)
      throws ServiceException;

}
