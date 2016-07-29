package com.globant.ms.god.workstations.ws.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.ms.god.domain.Workstation;
import com.globant.ms.god.workstations.service.IWorkstationService;

@RestController
@RefreshScope
@RequestMapping("/v1/workstations")
public class WorkstationsRestController {

	@Autowired
	private IWorkstationService workstationsService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Workstation> getAll() {
		return workstationsService.getAll();
	}

	@RequestMapping(value = "/with-facilitiesSerialNumber/{facilitiesSerialNumber}", method = RequestMethod.GET)
	public Workstation getByFacilitiesSerialNumber(
			@PathVariable("facilitiesSerialNumber") String facilitiesSerialNumber) {
		return workstationsService.getByFacilitiesSerialNumber(facilitiesSerialNumber);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Workstation create(@RequestBody Workstation workstation) {
		return workstationsService.create(workstation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Workstation get(@PathVariable Long id) {
		return workstationsService.getById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Workstation update(@PathVariable Long id, @RequestBody Workstation workstation) {

		return workstationsService.modify(id, workstation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Workstation delete(@PathVariable Long id) {

		return workstationsService.delete(id);
	}
}
