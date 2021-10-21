package com.swaraj.core.business.repositories.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swaraj.core.model.order.orderstatus.OrderStatusHistory;

import java.util.List;

public interface OrderStatusHistoryRepository extends JpaRepository<OrderStatusHistory, Long> {

    @Query("select osh from OrderStatusHistory osh" +
            " join fetch osh.order o" +
            " where o.id = ?1 order by osh.dateAdded desc")
    List<OrderStatusHistory> findByOrderId(Long id);
}
