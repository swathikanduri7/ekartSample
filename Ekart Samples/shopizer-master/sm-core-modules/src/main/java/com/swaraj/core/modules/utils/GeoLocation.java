package com.swaraj.core.modules.utils;

import com.swaraj.core.model.common.Address;

public interface GeoLocation {
	
	Address getAddress(String ipAddress) throws Exception;

}
