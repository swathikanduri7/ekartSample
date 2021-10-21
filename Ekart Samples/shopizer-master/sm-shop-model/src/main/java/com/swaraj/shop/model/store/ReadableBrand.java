package com.swaraj.shop.model.store;

import com.swaraj.shop.model.content.ReadableImage;

public class ReadableBrand extends MerchantStoreBrand {
  
  private ReadableImage logo;

  public ReadableImage getLogo() {
    return logo;
  }

  public void setLogo(ReadableImage logo) {
    this.logo = logo;
  }

}
