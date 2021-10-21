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

import com.encatch.model.Product;
import com.encatch.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
    private ProductService productService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @GetMapping  
    @PreAuthorize("hasRole('USER')")
    public List<Product> getProducts() {
    	LOGGER.debug("ProductService  :: getProducts ::::::::: ");    	
        return productService.getProducts();
    }
    
    @GetMapping ("/{productId}" )
    @PreAuthorize("hasRole('USER')")
    public Product getProductsById(@PathVariable Long productId) {
    	LOGGER.debug("ProductService  :: getProducts ::::::::: ");    	
        return productService.getProduct(productId);
    }
    
    @PostMapping
   
    @PreAuthorize("hasRole('USER')")
    public Product saveProduct( @RequestBody Product product) {
    	LOGGER.debug("ProductService  :: saveProduct ::::::::: ");    	
        return productService.saveProduct(product);
    }

}
