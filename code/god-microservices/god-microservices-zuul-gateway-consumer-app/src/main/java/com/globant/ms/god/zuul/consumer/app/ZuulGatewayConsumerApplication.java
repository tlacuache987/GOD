package com.globant.ms.god.zuul.consumer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayConsumerApplication.class, args);
	}
}
