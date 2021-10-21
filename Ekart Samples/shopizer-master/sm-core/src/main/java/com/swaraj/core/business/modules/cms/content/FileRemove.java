/**
 * 
 */
package com.swaraj.core.business.modules.cms.content;

import java.util.Optional;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.content.FileContentType;


/**
 * @author Umesh Awasthi
 *
 */
public interface FileRemove {
  void removeFile(String merchantStoreCode, FileContentType staticContentType,
      String fileName, Optional<String> path) throws ServiceException;

  void removeFiles(String merchantStoreCode, Optional<String> path) throws ServiceException;

}
