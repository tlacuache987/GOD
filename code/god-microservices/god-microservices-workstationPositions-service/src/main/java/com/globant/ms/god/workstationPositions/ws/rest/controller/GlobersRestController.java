package com.globant.ms.god.workstationPositions.ws.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.ms.god.domain.WorkstationPosition;
import com.globant.ms.god.workstationPositions.service.IWorkstationPositionService;

@RestController
@RefreshScope
@RequestMapping("/v1/globers")
public class GlobersRestController {

	@Autowired
	private IWorkstationPositionService workstationPositionService;

	@RequestMapping(value = "/{id}/workstationPositions", method = RequestMethod.GET)
	public WorkstationPosition getWorkstationPositionByIdGlober(@PathVariable("id") Long id) {
		return workstationPositionService.getByIdGlober(id);
	}
}
