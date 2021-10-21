package com.swaraj.core.business.services.order.orderproduct;

import java.util.List;

import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.order.orderproduct.OrderProductDownload;


public interface OrderProductDownloadService extends SalesManagerEntityService<Long, OrderProductDownload> {

	/**
	 * List {@link OrderProductDownload} by order id
	 * @param orderId
	 * @return
	 */
	List<OrderProductDownload> getByOrderId(Long orderId);

}
