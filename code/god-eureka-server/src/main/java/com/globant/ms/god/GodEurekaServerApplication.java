package com.globant.ms.god;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GodEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GodEurekaServerApplication.class, args);
	}
}
