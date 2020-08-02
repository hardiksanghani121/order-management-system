package com.oms.order.detail.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.order.detail.feign.client.OrderItemClient;
import com.oms.order.detail.model.OrderDetail;
import com.oms.order.detail.model.OrderDetailRequest;
import com.oms.order.detail.model.OrderDetailResponse;
import com.oms.order.detail.model.OrderItem;
import com.oms.order.detail.repository.OrderDetailRepository;
import com.oms.order.detail.service.OrderDetailService;

/**
 * @author hardik.sanghani
 *
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired(required = true)
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderItemClient orderItemClient;
	
	/**
	 *
	 */
	@Override
	public OrderDetail saveOrderDetail(OrderDetailRequest orderDetailRequest) {
		OrderDetail orderDetail = orderDetailRepository.save(orderDetailRequest.getOrderDetail());
		orderItemClient.createItems(orderDetailRequest.getOrderItems(),orderDetail.getId());
		return orderDetail;
	}

	/**
	 *
	 */
	@Override
	public OrderDetailResponse getOrderDetail(long orderDetailId) {
		// init variables
		OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
		if(!orderDetailRepository.findById(orderDetailId).isPresent()) {
			
		}
		orderDetailResponse.setOrderDetail(orderDetailRepository.findById(orderDetailId).get());
		orderDetailResponse.setOrderItems(orderItemClient.getOrderItems(orderDetailId));
		return orderDetailResponse;
	}
}
