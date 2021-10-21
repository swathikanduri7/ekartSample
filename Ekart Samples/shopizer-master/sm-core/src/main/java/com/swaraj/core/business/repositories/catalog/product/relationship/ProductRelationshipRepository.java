package com.swaraj.core.business.repositories.catalog.product.relationship;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.core.model.catalog.product.relationship.ProductRelationship;


public interface ProductRelationshipRepository extends JpaRepository<ProductRelationship, Long>, ProductRelationshipRepositoryCustom {

}
