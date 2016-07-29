package com.globant.ms.god.workstations.ws.rest.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globant.ms.god.domain.Glober;

@FeignClient("GLOBERS-SERVICE")
public interface IGlobersRestClient {

	@RequestMapping(value = "/v1/globers/{id}", method = RequestMethod.GET)
	public Glober getGloberById(@PathVariable("id") Long id);

}
