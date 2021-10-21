package com.encatch.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encatch.model.Product;
import com.encatch.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

	public List<Product> getProducts() {
		LOGGER.debug(" ProductService :::: getProducts :::::::");
		List<Product> products=productRepository.findAll();		
		return products;
	}
	
	public Product saveProduct(Product product) {
		LOGGER.debug(" ProductService :::: getProducts :::::::");
		Product product1 = productRepository.save(product);	
		return product1;
	}

	public Product getProduct(Long productId) {
		LOGGER.debug(" ProductService :::: getProduct :::::::");
		Optional<Product> products=productRepository.findById(productId);
		if(products.isPresent())
		      return products.get();
		else 
			return null;
	}
}
