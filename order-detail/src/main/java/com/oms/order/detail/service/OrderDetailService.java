package com.oms.order.detail.service;

import com.oms.order.detail.model.OrderDetail;
import com.oms.order.detail.model.OrderDetailRequest;
import com.oms.order.detail.model.OrderDetailResponse;

/**
 * @author hardik.sanghani
 *
 */
public interface OrderDetailService {
	
	/**
	 * @param orderDetail
	 * @return
	 */
	public OrderDetail saveOrderDetail(OrderDetailRequest orderDetailRequest);
	
	/**
	 * @param id
	 * @return
	 */
	public OrderDetailResponse getOrderDetail(long id);


}
