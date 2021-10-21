package com.swaraj.shop.admin.model.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import com.swaraj.core.model.catalog.category.CategoryDescription;

/**
 * Wrapper to ease admin jstl
 * @author carlsamson
 *
 */
public class Category implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private com.swaraj.core.model.catalog.category.Category category;
  
  @Valid
  private List<CategoryDescription> descriptions = new ArrayList<CategoryDescription>();

  public com.swaraj.core.model.catalog.category.Category getCategory() {
    return category;
  }

  public void setCategory(com.swaraj.core.model.catalog.category.Category category) {
    this.category = category;
  }

  public List<CategoryDescription> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(List<CategoryDescription> descriptions) {
    this.descriptions = descriptions;
  }

}
