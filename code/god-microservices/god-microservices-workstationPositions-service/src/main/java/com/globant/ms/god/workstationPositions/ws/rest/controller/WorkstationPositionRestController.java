package com.globant.ms.god.workstationPositions.ws.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.ms.god.domain.WorkstationPosition;
import com.globant.ms.god.workstationPositions.service.IWorkstationPositionService;

@RestController
@RefreshScope
@RequestMapping("/v1/workstationPositions")
public class WorkstationPositionRestController {

	@Autowired
	private IWorkstationPositionService workstationPositionService;

	@RequestMapping(method = RequestMethod.GET)
	public List<WorkstationPosition> getAll() {
		return workstationPositionService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public WorkstationPosition create(@RequestBody WorkstationPosition workstationPosition) {
		return workstationPositionService.create(workstationPosition);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public WorkstationPosition get(@PathVariable Long id) {
		return workstationPositionService.getById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public WorkstationPosition update(@PathVariable Long id, @RequestBody WorkstationPosition workstationPosition) {
		return workstationPositionService.modify(id, workstationPosition);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public WorkstationPosition delete(@PathVariable Long id) {
		return workstationPositionService.delete(id);
	}
}
