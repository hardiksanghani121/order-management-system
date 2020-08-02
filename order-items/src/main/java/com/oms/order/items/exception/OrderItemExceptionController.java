package com.oms.order.items.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author hardik.sanghani
 *
 */
@ControllerAdvice
public class OrderItemExceptionController {

	/**
	 * @param orderItemNotFoundException
	 * @return
	 */
	@ExceptionHandler(value = OrderItemNotFoundException.class)
	public ResponseEntity<Object> exception(OrderItemNotFoundException orderItemNotFoundException){
		return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
	}
}
