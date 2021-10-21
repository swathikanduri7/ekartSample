package com.swaraj.core.business.services.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.repositories.user.GroupRepository;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityServiceImpl;
import com.swaraj.core.model.user.Group;
import com.swaraj.core.model.user.GroupType;


@Service("groupService")
public class GroupServiceImpl extends SalesManagerEntityServiceImpl<Integer, Group>
    implements GroupService {

  GroupRepository groupRepository;


  @Inject
  public GroupServiceImpl(GroupRepository groupRepository) {
    super(groupRepository);
    this.groupRepository = groupRepository;

  }


  @Override
  public List<Group> listGroup(GroupType groupType) throws ServiceException {
    try {
      return groupRepository.findByType(groupType);
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  public List<Group> listGroupByIds(Set<Integer> ids) throws ServiceException {

      try {
        return ids.isEmpty() ? new ArrayList<Group>() : groupRepository.findByIds(ids);
      } catch (Exception e) {
        throw new ServiceException(e);
      }

  }


  @Override
  public Group findByName(String groupName) throws ServiceException {
    return groupRepository.findByGroupName(groupName);
  }


  @Override
  public List<Group> listGroupByNames(List<String> names) throws ServiceException {
    return groupRepository.findByNames(names);
  }


}
