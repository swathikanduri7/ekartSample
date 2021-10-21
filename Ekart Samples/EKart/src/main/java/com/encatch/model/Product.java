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

import com.encatch.model.audit.DateAudit;

@Entity
@Table(name = "product")
public class Product extends DateAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String currency;	
	private double retailPrice;
    private double sellingPrice;
    private String description;
   
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  	@JoinTable(name = "product_product_image", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "product_image_id"))
  	private Set<ProductImage> productImages = new HashSet<>();	
   
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "product_product_type", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "product_type_id"))
	private Set<ProductType> productType = new HashSet<>();	
	
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "product_brands", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "brands_id"))
	private Set<Brands> brands = new HashSet<>();	
	
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "product_sellers", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "sellers_id"))
	private Set<Seller> sellers = new HashSet<>();	
    
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "product_ratings", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "ratings_reviews_id"))
	private Set<RatingsAndReviews> ratings = new HashSet<>();
	
	
	public Product() {
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


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<RatingsAndReviews> getRatings() {
		return ratings;
	}


	public void setRatings(Set<RatingsAndReviews> ratings) {
		this.ratings = ratings;
	}


	public double getRetailPrice() {
		return retailPrice;
	}


	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}


	public double getSellingPrice() {
		return sellingPrice;
	}


	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public Set<ProductImage> getProductImages() {
		return productImages;
	}


	public void setProductImages(Set<ProductImage> productImages) {
		this.productImages = productImages;
	}


	public Set<ProductType> getProductType() {
		return productType;
	}


	public void setProductType(Set<ProductType> productType) {
		this.productType = productType;
	}


	public Set<Brands> getBrands() {
		return brands;
	}


	public void setBrands(Set<Brands> brands) {
		this.brands = brands;
	}


	public Set<Seller> getSellers() {
		return sellers;
	}


	public void setSellers(Set<Seller> sellers) {
		this.sellers = sellers;
	}
	
	
	
	
}
