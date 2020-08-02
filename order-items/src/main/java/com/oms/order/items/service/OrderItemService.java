package com.oms.order.items.service;

import java.util.List;

import com.oms.order.items.model.OrderItem;

/**
 * @author hardik.sanghani
 *
 */
public interface OrderItemService {

	/**
	 * @param orderItems
	 * @return
	 */
	public List<OrderItem> saveOrderItems(List<OrderItem> orderItems, long orderDetailId);
	
	/**
	 * @param orderDetailId
	 * @return
	 */
	public List<OrderItem> getOrderItems(long orderDetailId);
}
