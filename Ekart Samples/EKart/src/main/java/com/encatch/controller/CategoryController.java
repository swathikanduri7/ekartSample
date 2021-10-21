package com.encatch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encatch.model.Category;
import com.encatch.model.Product;
import com.encatch.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class   CategoryController {

	@Autowired
    private CategoryService categoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<Category> getCategories() {
    	LOGGER.debug("CategoryService  :: getCategories ::::::::: ");    	
        return categoryService.getCategories();
    }
    
    
    @GetMapping ("/{categoryId}" )
    @PreAuthorize("hasRole('USER')")
    public Category getCategoryById(@PathVariable Long categoryId) {
    	LOGGER.debug("CategoryService  :: getCategoryById ::::::::: ");    	
        return categoryService.getCategory(categoryId);
    }
    
    @PostMapping   
    @PreAuthorize("hasRole('USER')")
    public Category saveCategory( @RequestBody Category category) {
    	LOGGER.debug("CategoryService  :: saveCategory ::::::::: ");    	
        return categoryService.saveCategory(category);
    }

  
}
