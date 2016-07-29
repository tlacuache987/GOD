package com.globant.ms.god.globers.ws.rest.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globant.ms.god.domain.Glober;

@FeignClient("WORKSTATIONPOSITIONS-SERVICE")
public interface IWorkstationPositionsRestClient {

	@RequestMapping(value = "/v1/workstationPositions/{id}", method = RequestMethod.GET)
	public Glober getGloberById(@PathVariable("id") Long id);

}
