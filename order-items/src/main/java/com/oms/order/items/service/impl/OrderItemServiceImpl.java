package com.oms.order.items.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.order.items.model.OrderItem;
import com.oms.order.items.repository.OrderItemRepository;
import com.oms.order.items.service.OrderItemService;


/**
 * @author hardik.sanghani
 *
 */
@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired(required = true)
	OrderItemRepository orderItemRepository;
	
	/**
	 *
	 */
	@Override
	public List<OrderItem> saveOrderItems(List<OrderItem> orderItems, long orderDetailId) {
		for (OrderItem orderItem : orderItems) {
			orderItem.setOrderDetailId(orderDetailId);
			orderItemRepository.save(orderItem);
		}
		return orderItems;
	}

	/**
	 *
	 */
	@Override
	public List<OrderItem> getOrderItems(long orderDetailId) {
		return orderItemRepository.findByOrderDetailId(orderDetailId);
	}
	
}
