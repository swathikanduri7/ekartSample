package com.swaraj.core.business.modules.cms.content;

import java.util.List;
import java.util.Optional;

import com.swaraj.core.business.exception.ServiceException;

public interface FolderList {
	
	  List<String> listFolders(final String merchantStoreCode, Optional<String> path)
		      throws ServiceException;

}
