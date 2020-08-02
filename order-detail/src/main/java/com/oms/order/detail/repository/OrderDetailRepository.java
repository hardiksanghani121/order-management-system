package com.oms.order.detail.repository;

import org.springframework.data.repository.CrudRepository;

import com.oms.order.detail.model.OrderDetail;

/**
 * @author hardik.sanghani
 *
 */
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {

}
