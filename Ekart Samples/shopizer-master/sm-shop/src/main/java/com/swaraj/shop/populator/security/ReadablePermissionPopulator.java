package com.swaraj.shop.populator.security;

import com.swaraj.core.business.exception.ConversionException;
import com.swaraj.core.business.utils.AbstractDataPopulator;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;
import com.swaraj.core.model.user.Permission;
import com.swaraj.shop.model.security.ReadablePermission;

public class ReadablePermissionPopulator extends AbstractDataPopulator<Permission, ReadablePermission> {

  @Override
  public ReadablePermission populate(Permission source, ReadablePermission target,
      MerchantStore store, Language language) throws ConversionException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected ReadablePermission createTarget() {
    // TODO Auto-generated method stub
    return null;
  }

}
