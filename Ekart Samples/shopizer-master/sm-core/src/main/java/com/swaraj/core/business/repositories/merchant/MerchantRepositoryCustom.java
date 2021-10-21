package com.swaraj.core.business.repositories.merchant;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.common.GenericEntityList;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.merchant.MerchantStoreCriteria;

public interface MerchantRepositoryCustom {

  GenericEntityList<MerchantStore> listByCriteria(MerchantStoreCriteria criteria)
      throws ServiceException;


}
