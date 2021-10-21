package com.swaraj.core.business.repositories.user;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.common.Criteria;
import com.swaraj.core.model.common.GenericEntityList;
import com.swaraj.core.model.user.User;

public interface UserRepositoryCustom {
  
  GenericEntityList<User> listByCriteria(Criteria criteria) throws ServiceException;

}
