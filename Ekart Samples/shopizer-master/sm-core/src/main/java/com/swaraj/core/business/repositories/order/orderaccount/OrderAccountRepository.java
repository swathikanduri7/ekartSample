package com.swaraj.core.business.repositories.order.orderaccount;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.core.model.order.orderaccount.OrderAccount;

public interface OrderAccountRepository extends JpaRepository<OrderAccount, Long> {


}
