package com.oms.order.items.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.oms.order.items.model.OrderItem;

/**
 * @author hardik.sanghani
 *
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
	
	/**
	 * @param orderDetailId
	 * @return
	 */
	public List<OrderItem> findByOrderDetailId(long orderDetailId);
	

}
	