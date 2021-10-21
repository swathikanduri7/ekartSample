package com.swaraj.core.business.repositories.shoppingcart;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.core.model.shoppingcart.ShoppingCartAttributeItem;
public interface ShoppingCartAttributeRepository extends JpaRepository<ShoppingCartAttributeItem, Long> {


}
