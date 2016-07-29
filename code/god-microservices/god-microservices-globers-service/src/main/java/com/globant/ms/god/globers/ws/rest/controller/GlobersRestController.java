package com.globant.ms.god.globers.ws.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.ms.god.domain.Glober;
import com.globant.ms.god.globers.service.IGloberService;

@RestController
@RefreshScope
@RequestMapping("/v1/globers")
public class GlobersRestController {

	@Autowired
	private IGloberService globersService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Glober> getAll() {
		return globersService.getAll();
	}

	@RequestMapping(value = "/with-workstationPosition", method = RequestMethod.GET)
	public List<Glober> getAllWithWorkstationPosition() {
		return globersService.getAllWithWorkstationPosition();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Glober create(@RequestBody Glober glober) {
		return globersService.create(glober);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Glober get(@PathVariable Long id) {
		return globersService.getById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Glober update(@PathVariable Long id, @RequestBody Glober glober) {

		return globersService.modify(id, glober);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Glober delete(@PathVariable Long id) {

		return globersService.delete(id);
	}
}
