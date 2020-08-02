package com.oms.order.detail.validator;

import java.util.ArrayList;
import java.util.List;

import com.oms.order.detail.model.OrderDetailRequest;

/**
 * @author hardik.sanghani
 *
 */
public class OrderDetailValidator {

	public static List<String> validate(OrderDetailRequest OrderDetailRequest) {
		List<String> msg = new ArrayList<String>();
		if (OrderDetailRequest != null) {
			if (OrderDetailRequest.getCustomerName() == null || OrderDetailRequest.getCustomerName().equals("")) {
				msg.add("Customer name can not be empty.");
			}
			if (OrderDetailRequest.getTotal() == 0) {
				msg.add("Total amount can not be empty..");
			}
			if (OrderDetailRequest.getOrderItems().isEmpty()) {
				msg.add("Order items can not be empty.");
			}
			if (OrderDetailRequest.getOrderDate() == null) {
				msg.add("Order date can not be empty.");
			}
			if (OrderDetailRequest.getShippingAddress() == null || OrderDetailRequest.getShippingAddress().equals("")) {
				msg.add("Shipping address can not be empty.");
			}
		}
		return msg;
	}

}
