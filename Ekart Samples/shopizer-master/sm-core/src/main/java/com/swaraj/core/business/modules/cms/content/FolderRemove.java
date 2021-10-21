/**
 * 
 */
package com.swaraj.core.business.modules.cms.content;

import java.util.Optional;

import com.swaraj.core.business.exception.ServiceException;


public interface FolderRemove {
  void removeFolder(final String merchantStoreCode, String folderName, Optional<String> folderPath)
      throws ServiceException;

}
