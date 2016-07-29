package com.globant.ms.god.workstationPositions.ws.rest.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globant.ms.god.domain.Workstation;

@FeignClient("WORKSTATIONS-SERVICE")
public interface IWorkstationsFeignClient {

	@RequestMapping(value = "/v1/workstations/{id}", method = RequestMethod.GET)
	public Workstation getWorkstationById(@PathVariable("id") Long id);

}
