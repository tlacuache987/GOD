package com.globant.ms.god.workstations.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.ms.god.domain.Glober;
import com.globant.ms.god.workstations.ws.rest.client.IGlobersRestClient;

@RestController
@RefreshScope
@RequestMapping("/v1")
public class WorkstationsLolController {

	@Value("${lol}")
	private String lolString;

	@Autowired
	private IGlobersRestClient globersClient;

	@RequestMapping(value = "/lol", method = RequestMethod.GET)
	public String getLolString() {
		return lolString;
	}

	@RequestMapping(value = "/getGloberById/{id}", method = RequestMethod.GET)
	public Glober getGloberById(@PathVariable("id") Long id) {
		return globersClient.getGloberById(id);
	}
}
