package com.swaraj.core.business.services.order.orderstatushistory;

import com.swaraj.core.model.order.Order;
import com.swaraj.core.model.order.orderstatus.OrderStatusHistory;

import java.util.List;

public interface OrderStatusHistoryService {
    List<OrderStatusHistory> findByOrder(Order order);
}
