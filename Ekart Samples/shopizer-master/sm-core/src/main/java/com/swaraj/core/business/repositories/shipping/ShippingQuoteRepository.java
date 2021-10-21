package com.swaraj.core.business.repositories.shipping;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swaraj.core.model.shipping.Quote;

public interface ShippingQuoteRepository extends JpaRepository<Quote, Long> {
	
	
	@Query("select q from Quote as q where q.orderId = ?1")
	List<Quote> findByOrder(Long order);

}
