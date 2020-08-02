package com.oms.order.items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.order.detail.constant.ResponseMessage;
import com.oms.order.items.model.OrderItem;
import com.oms.order.items.model.OrderItemsResponse;
import com.oms.order.items.service.OrderItemService;

/**
 * @author hardik.sanghani
 *
 */
@RestController
@RequestMapping("oms/order-item")
public class OrderItemController {
	
	@Autowired(required=true) 
	private OrderItemService orderItemService;
	
	/**
	 * @param orderDetail
	 * @return
	 */
	@PostMapping("/api/create-items")
	public ResponseEntity<OrderItemsResponse> createItems(@RequestBody List<OrderItem> orderItems, long orderDetailId) {
		System.out.println(orderItems.size());
		// init variables
		OrderItemsResponse orderItemsResponse = new OrderItemsResponse();
		
		// save order details
		orderItemsResponse.setData((Object)orderItemService.saveOrderItems(orderItems, orderDetailId));
		
		orderItemsResponse.setStatusCode(HttpStatus.OK.value());
		orderItemsResponse.setStatus(ResponseMessage.SUCCESS_SAVE);
		return new ResponseEntity<OrderItemsResponse>(orderItemsResponse, HttpStatus.OK);
	}
	
	/**`
	 * @param orderId
	 * @return
	 */
	@GetMapping("/api/get-order-items/{orderDetailId}")
	public List<OrderItem> getOrderItems(@PathVariable(name="orderDetailId")long orderDetailId) {
		return orderItemService.getOrderItems(orderDetailId);
	}
}
