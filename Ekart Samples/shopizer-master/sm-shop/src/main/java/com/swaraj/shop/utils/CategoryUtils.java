package com.swaraj.shop.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.swaraj.core.model.catalog.category.Category;
import com.swaraj.core.model.catalog.category.CategoryDescription;
import com.swaraj.core.model.reference.language.Language;

public class CategoryUtils {
  
  
  public static com.swaraj.shop.admin.model.catalog.Category readableCategoryConverter(Category category, Language language) {
    com.swaraj.shop.admin.model.catalog.Category readableCategory = new com.swaraj.shop.admin.model.catalog.Category();
    readableCategory.setCategory(category);
    
    List<CategoryDescription> descriptions = new ArrayList<CategoryDescription>(category.getDescriptions());
    
    //descriptions
    //.stream();
    //.filter(desc -> desc.getLanguage().getCode().equals(language.getCode()));
    
    
    readableCategory.setDescriptions(descriptions);
    return readableCategory;
  }
  
  public static List<com.swaraj.shop.admin.model.catalog.Category> readableCategoryListConverter(List<Category> categories, Language language) {
    
    List<com.swaraj.shop.admin.model.catalog.Category> readableCategories = 
        categories.stream()
         .map(cat -> readableCategoryConverter(cat, language))
         .collect(Collectors.toList());
    
    return readableCategories;
    
  }

}
