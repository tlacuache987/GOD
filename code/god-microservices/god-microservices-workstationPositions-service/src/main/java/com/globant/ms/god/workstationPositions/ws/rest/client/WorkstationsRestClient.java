package com.globant.ms.god.workstationPositions.ws.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.ms.god.domain.Workstation;
import com.globant.ms.god.workstationPositions.ws.rest.client.feign.IWorkstationsFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class WorkstationsRestClient {

	@Autowired
	private IWorkstationsFeignClient workstationsFeignClient;

	@HystrixCommand(fallbackMethod = "getFallbackWorkstation")
	public Workstation getWorkstationFromFeignClient(Long idWorkstation) {
		return workstationsFeignClient.getWorkstationById(idWorkstation);
	}

	public Workstation getFallbackWorkstation(Long idWorkstation) {
		return new Workstation(0L, "---", "---", "---");
	}

}
