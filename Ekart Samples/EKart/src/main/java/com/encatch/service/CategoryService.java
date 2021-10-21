package com.encatch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encatch.model.Category;
import com.encatch.model.Product;
import com.encatch.payload.CategoryResponse;
import com.encatch.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

	public List<Category> getCategories() {
		LOGGER.debug(" CategoryService :::: getCategories :::::::");
		List<Category> categories=categoryRepository.findAllByCategoryIdAsc();		
	/*	List<CategoryResponse> categoriesList= new ArrayList<>();
		for(Category category:categories){
			CategoryResponse categoryResponse=new CategoryResponse();
			categoryResponse.setCategoryName(category.getCategoryname());
			categoryResponse.setId(category.getId());
			categoriesList.add(categoryResponse);
		}
		return categoriesList;*/
		return categories;
	}

	public Category getCategory(Long categoryId) {
		LOGGER.debug(" ProductService :::: getProduct :::::::");
		Optional<Category> categories=categoryRepository.findById(categoryId);
		if(categories.isPresent())
		      return categories.get();
		else 
			return null;
	}

	public Category saveCategory(Category category) {
		LOGGER.debug(" ProductService :::: getProducts :::::::");
		Category category1 = categoryRepository.save(category);	
		return category1;
	}

	
		
}
