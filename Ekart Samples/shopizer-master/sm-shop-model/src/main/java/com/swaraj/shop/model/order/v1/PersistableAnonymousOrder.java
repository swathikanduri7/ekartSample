package com.swaraj.shop.model.order.v1;

import com.swaraj.shop.model.customer.PersistableCustomer;

public class PersistableAnonymousOrder extends PersistableOrder {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private PersistableCustomer customer;

  public PersistableCustomer getCustomer() {
    return customer;
  }

  public void setCustomer(PersistableCustomer customer) {
    this.customer = customer;
  }

}
