package com.swaraj.core.business.services.user;

import java.util.List;

import org.springframework.data.domain.Page;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.common.Criteria;
import com.swaraj.core.model.common.GenericEntityList;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.user.User;
import com.swaraj.core.model.user.UserCriteria;



public interface UserService extends SalesManagerEntityService<Long, User> {

  User getByUserName(String userName) throws ServiceException;
  User getByUserName(String userName, String storeCode) throws ServiceException;

  List<User> listUser() throws ServiceException;
  
  User getById(Long id, MerchantStore store);
  
  User getByPasswordResetToken(String storeCode, String token);

  /**
   * Create or update a User
   * 
   * @param user
   * @throws ServiceException
   */
  void saveOrUpdate(User user) throws ServiceException;

  List<User> listByStore(MerchantStore store) throws ServiceException;

  User findByStore(Long userId, String storeCode) throws ServiceException;

  @Deprecated
  GenericEntityList<User> listByCriteria(Criteria criteria) throws ServiceException;
  
  Page<User> listByCriteria(UserCriteria criteria, int page, int count) throws ServiceException;
  
  User findByResetPasswordToken (String userName, String token, MerchantStore store) throws ServiceException;




}
