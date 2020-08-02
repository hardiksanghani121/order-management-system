package com.oms.order.detail.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.oms.order.detail.model.OrderItem;

/**
 * @author hardik.sanghani
 *
 */
@FeignClient(name = "order-items",url="http://localhost:8090/oms/order-item")
public interface OrderItemClient {

	/**
	 * @param orderItems
	 * @return
	 */
	@PostMapping("/api/create-items")
	public OrderItem createItems(@RequestBody List<OrderItem> orderItems, @RequestParam("orderDetailId") long orderDetailId);
	
	/**
	 * @param orderDetailId
	 * @return
	 */
	@GetMapping("/api/get-order-items/{orderDetailId}")
	public List<OrderItem> getOrderItems(@PathVariable(value = "orderDetailId") long orderDetailId);
}