package com.oms.order.detail;

import java.util.List;
import java.util.stream.Collectors;

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
import com.oms.order.detail.model.OrderDetailRequest;
import com.oms.order.detail.model.OrderDetailResponse;
import com.oms.order.detail.service.OrderDetailService;
import com.oms.order.detail.validator.OrderDetailValidator;

/**
 * @author hardik.sanghani
 *
 */
@RestController
@RequestMapping("oms/order")
public class OrderDetailController {
	
	@Autowired(required=true) 
	private OrderDetailService orderDetailService;
	
	/**
	 * @param orderDetail
	 * @return
	 */
	@PostMapping("/api/create-order")
	public ResponseEntity<OrderDetailResponse> createOrder(@RequestBody OrderDetailRequest orderDetailRequest) {
		// init variables
		OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
		List<String> errorMessageList = OrderDetailValidator.validate(orderDetailRequest);
		if(!errorMessageList.isEmpty()) {
			orderDetailResponse.setStatus(errorMessageList.stream().collect(Collectors.joining(", ")));
			orderDetailResponse.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<OrderDetailResponse>(orderDetailResponse, HttpStatus.OK);
		}
		
		// save order details
		orderDetailResponse.setOrderDetail(orderDetailService.saveOrderDetail(orderDetailRequest));
		orderDetailResponse.setOrderItems(orderDetailRequest.getOrderItems());
		
		orderDetailResponse.setStatusCode(HttpStatus.OK.value());
		orderDetailResponse.setStatus(ResponseMessage.SUCCESS_SAVE);
		return new ResponseEntity<OrderDetailResponse>(orderDetailResponse, HttpStatus.OK);
	}
	
	/**
	 * @param orderId
	 * @return
	 */
	@GetMapping("/api/get-order/{orderDetailId}")
	public ResponseEntity<OrderDetailResponse> getOrderDetail(@PathVariable(name="orderDetailId")long orderDetailId) {
		System.out.println(orderDetailId);
		// fetch order details
		OrderDetailResponse orderDetailResponse = orderDetailService.getOrderDetail(orderDetailId);
			
		// return order details
		orderDetailResponse.setStatusCode(HttpStatus.OK.value());
		orderDetailResponse.setStatus(ResponseMessage.SUCCESS_FETCH);
		return new ResponseEntity<OrderDetailResponse>(orderDetailResponse, HttpStatus.OK);
	}
}
