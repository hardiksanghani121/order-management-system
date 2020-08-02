package com.oms.order.items.model;

/**
 * @author hardik.sanghani
 *
 */
public class OrderItemsResponse {
	
	private String status;
	private int statusCode;
	private Object data;
	
	
	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return
	 */
	public int getStatusCode() {
		return statusCode;
	}
	
	/**
	 * @param statusCode
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	/**
	 * @return
	 */
	public Object getData() {
		return data;
	}
	
	/**
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
