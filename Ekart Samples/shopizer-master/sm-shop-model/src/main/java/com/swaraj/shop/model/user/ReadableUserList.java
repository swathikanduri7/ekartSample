package com.swaraj.shop.model.user;

import java.util.ArrayList;
import java.util.List;

import com.swaraj.shop.model.entity.ReadableList;

public class ReadableUserList extends ReadableList {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private List<ReadableUser> data = new ArrayList<ReadableUser>();

  public List<ReadableUser> getData() {
    return data;
  }

  public void setData(List<ReadableUser> data) {
    this.data = data;
  }

}
