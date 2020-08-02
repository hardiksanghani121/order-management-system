package com.oms.order.detail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author hardik.sanghani
 *
 */
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.*")
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class OrderDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderDetailApplication.class, args);
	}

}


