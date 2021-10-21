package com.encatch.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "product_variants")
public class ProductVariants {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_variants_product_variants_images",
            joinColumns = @JoinColumn(name = "product_variants_id"),
            inverseJoinColumns = @JoinColumn(name = "product_variants_image_id"))
    private Set<ProductVariantsImages> productVariantsImages = new HashSet<>();

    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_variants_products",
            joinColumns = @JoinColumn(name = "product_variants_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();
    
	public ProductVariants() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Set<ProductVariantsImages> getProductVariantsImages() {
		return productVariantsImages;
	}

	public void setProductVariantsImages(Set<ProductVariantsImages> productVariantsImages) {
		this.productVariantsImages = productVariantsImages;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	
}
