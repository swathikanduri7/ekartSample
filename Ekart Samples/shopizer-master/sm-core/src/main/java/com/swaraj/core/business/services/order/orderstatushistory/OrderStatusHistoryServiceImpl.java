package com.swaraj.core.business.services.order.orderstatushistory;

import com.swaraj.core.business.repositories.order.OrderStatusHistoryRepository;
import com.swaraj.core.model.order.Order;
import com.swaraj.core.model.order.orderstatus.OrderStatusHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusHistoryServiceImpl implements OrderStatusHistoryService{
    @Autowired
    private OrderStatusHistoryRepository orderStatusHistoryRepository;

    @Override
    public List<OrderStatusHistory> findByOrder(Order order) {
        return orderStatusHistoryRepository.findByOrderId(order.getId());
    }
}
