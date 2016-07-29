package com.globant.ms.god.workstationPositions.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.ms.god.domain.Workstation;
import com.globant.ms.god.domain.WorkstationPosition;
import com.globant.ms.god.workstationPositions.repository.IWorkstationPositionRepository;
import com.globant.ms.god.workstationPositions.service.IWorkstationPositionService;
import com.globant.ms.god.workstationPositions.ws.rest.client.WorkstationsRestClient;

@Service
public class WorkstationPositionServiceImpl implements IWorkstationPositionService {

	@Autowired
	private IWorkstationPositionRepository workstationPositionRepository;

	@Autowired
	private WorkstationsRestClient workstationsRestClient;

	@Override
	public List<WorkstationPosition> getAll() {
		// workstationsPositionList without Workstation
		List<WorkstationPosition> workstationPositionsList = workstationPositionRepository.findAll();

		for (WorkstationPosition wsp : workstationPositionsList) {
			// getting and setting the workstation using IWorkstationRestClient

			Workstation ws = workstationsRestClient.getWorkstationFromFeignClient(wsp.getIdWorkstation());

			wsp.setWorkstation(ws);
		}

		return workstationPositionsList;
	}

	@Override
	public WorkstationPosition getById(Long id) {
		return workstationPositionRepository.findOne(id);
	}

	@Override
	public WorkstationPosition getByIdGlober(Long idGlober) {
		return workstationPositionRepository.findByIdGlober(idGlober);
	}

	@Override
	public WorkstationPosition getByIdWorkstation(Long idWorkstation) {
		return workstationPositionRepository.findByIdWorkstation(idWorkstation);
	}

	@Override
	public WorkstationPosition create(WorkstationPosition workstationPosition) {
		return workstationPositionRepository.save(workstationPosition);
	}

	@Override
	public WorkstationPosition modify(Long id, WorkstationPosition workstationPosition) {
		WorkstationPosition existingWorkstationPosition = workstationPositionRepository.findOne(id);

		BeanUtils.copyProperties(workstationPosition, existingWorkstationPosition);

		return workstationPositionRepository.saveAndFlush(existingWorkstationPosition);
	}

	@Override
	public WorkstationPosition delete(Long id) {
		WorkstationPosition existingWorkstationPosition = workstationPositionRepository.findOne(id);

		workstationPositionRepository.delete(existingWorkstationPosition);

		return existingWorkstationPosition;
	}
}
