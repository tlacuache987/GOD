package com.globant.ms.god.workstationPositions.service;

import java.util.List;

import com.globant.ms.god.domain.WorkstationPosition;

public interface IWorkstationPositionService {

	List<WorkstationPosition> getAll();

	WorkstationPosition getById(Long id);

	WorkstationPosition getByIdGlober(Long idGlober);

	WorkstationPosition getByIdWorkstation(Long idWorkstation);

	WorkstationPosition create(WorkstationPosition workstationPosition);

	WorkstationPosition modify(Long id, WorkstationPosition workstationPosition);

	WorkstationPosition delete(Long id);

}
