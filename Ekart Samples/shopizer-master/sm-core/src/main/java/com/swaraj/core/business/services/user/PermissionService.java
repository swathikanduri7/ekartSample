package com.swaraj.core.business.services.user;

import java.util.List;
import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.user.Group;
import com.swaraj.core.model.user.Permission;
import com.swaraj.core.model.user.PermissionCriteria;
import com.swaraj.core.model.user.PermissionList;



public interface PermissionService extends SalesManagerEntityService<Integer, Permission> {

  List<Permission> getByName();

  List<Permission> listPermission() throws ServiceException;

  Permission getById(Integer permissionId);

  List<Permission> getPermissions(List<Integer> groupIds) throws ServiceException;

  void deletePermission(Permission permission) throws ServiceException;

  PermissionList listByCriteria(PermissionCriteria criteria) throws ServiceException;

  void removePermission(Permission permission, Group group) throws ServiceException;

}
