package com.globant.ms.god.globers.ws.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.ms.god.domain.WorkstationPosition;
import com.globant.ms.god.globers.ws.rest.client.feign.IWorkstationPositionsFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class WorkstationPositionsRestClient {

	@Autowired
	private IWorkstationPositionsFeignClient workstationPositionsFeignClient;

	@HystrixCommand(fallbackMethod = "getFallbackWorkstationPosition")
	public WorkstationPosition getWorkstationPositionByIdGloberFromFeignClient(Long idGlober) {
		return workstationPositionsFeignClient.getWorkstationPositionByIdGlober(idGlober);
	}

	public WorkstationPosition getFallbackWorkstationPosition(Long idGlober) {
		return null;
	}

}
