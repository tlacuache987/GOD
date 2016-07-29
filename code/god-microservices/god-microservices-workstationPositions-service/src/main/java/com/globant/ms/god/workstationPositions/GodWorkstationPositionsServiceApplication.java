package com.globant.ms.god.workstationPositions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@EntityScan(basePackages = { "com.globant.ms.god.domain" })
public class GodWorkstationPositionsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GodWorkstationPositionsServiceApplication.class, args);
	}
}
