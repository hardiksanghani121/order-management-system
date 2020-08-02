package com.oms.order.detail.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hardik.sanghani
 *
 */
public class OrderDetailRequest {
	
	private long id;
	private String customerName;
	private Date orderDate;
	private String shippingAddress;
	private long total;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}
	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	/**
	 * @return
	 */
	public OrderDetail getOrderDetail() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCustomerName(this.customerName);
		orderDetail.setOrderDate(this.orderDate);
		orderDetail.setShippingAddress(this.shippingAddress);
		orderDetail.setTotal(this.total);
		return orderDetail;
	}
}
