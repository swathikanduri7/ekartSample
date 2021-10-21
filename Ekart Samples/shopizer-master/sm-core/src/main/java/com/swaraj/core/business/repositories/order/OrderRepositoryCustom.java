package com.swaraj.core.business.repositories.order;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.order.OrderCriteria;
import com.swaraj.core.model.order.OrderList;




public interface OrderRepositoryCustom {

	OrderList listByStore(MerchantStore store, OrderCriteria criteria);
	OrderList listOrders(MerchantStore store, OrderCriteria criteria);
}
