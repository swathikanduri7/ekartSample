package com.swaraj.core.business.repositories.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.core.model.order.OrderTotal;

public interface OrderTotalRepository extends JpaRepository<OrderTotal, Long> {


}
