package com.encatch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.encatch.model.audit.DateAudit;

@Entity
@Table(name = "product_type")
public class ProductType extends DateAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//private String name;

	@Enumerated(EnumType.STRING)
    @NaturalId
	@Column(length = 60)
	private ProductTypeName productType;

	public ProductType() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductTypeName getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeName productType) {
		this.productType = productType;
	}

	
}
