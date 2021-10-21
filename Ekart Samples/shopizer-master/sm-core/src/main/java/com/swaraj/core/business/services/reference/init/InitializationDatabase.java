package com.swaraj.core.business.services.reference.init;

import com.swaraj.core.business.exception.ServiceException;

public interface InitializationDatabase {
	
	boolean isEmpty();
	
	void populate(String name) throws ServiceException;

}
