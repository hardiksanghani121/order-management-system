package com.oms.order.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hardik.sanghani
 *
 */
@SpringBootApplication
@EnableFeignClients("com.oms.order.items")
public class OrderItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderItemsApplication.class, args);
	}

}
