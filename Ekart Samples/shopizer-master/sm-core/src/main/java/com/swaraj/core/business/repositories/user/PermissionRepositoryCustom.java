package com.swaraj.core.business.repositories.user;

import com.swaraj.core.model.user.PermissionCriteria;
import com.swaraj.core.model.user.PermissionList;




public interface PermissionRepositoryCustom {

	PermissionList listByCriteria(PermissionCriteria criteria);


}
