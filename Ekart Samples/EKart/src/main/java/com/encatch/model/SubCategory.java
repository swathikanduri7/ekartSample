package com.encatch.model;

import java.util.HashSet;
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
@Table(name = "sub_categories")
public class SubCategory {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
	

    
    
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "sub_categories_product_variants", joinColumns = @JoinColumn(name = "sub_category_id"), inverseJoinColumns = @JoinColumn(name = "product_variants_id"))
	private Set<ProductVariants> productVariants = new HashSet<>();
	
	
	public SubCategory() {	}


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


	public Set<ProductVariants> getProductVariants() {
		return productVariants;
	}


	public void setProductVariants(Set<ProductVariants> productVariants) {
		this.productVariants = productVariants;
	}


	

}
