package com.globant.ms.god.globers.ws.rest.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globant.ms.god.domain.WorkstationPosition;

@FeignClient("WORKSTATIONPOSITIONS-SERVICE")
public interface IWorkstationPositionsFeignClient {

	@RequestMapping(value = "/v1/globers/{id}/workstationPositions", method = RequestMethod.GET)
	public WorkstationPosition getWorkstationPositionByIdGlober(@PathVariable("id") Long id);

}
