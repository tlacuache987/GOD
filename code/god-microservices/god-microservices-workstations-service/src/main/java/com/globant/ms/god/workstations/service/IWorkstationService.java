package com.globant.ms.god.workstations.service;

import java.util.List;

import com.globant.ms.god.domain.Workstation;

public interface IWorkstationService {

	List<Workstation> getAll();

	Workstation create(Workstation workstation);

	Workstation getById(Long id);

	Workstation modify(Long id, Workstation workstation);

	Workstation delete(Long id);

	Workstation getByFacilitiesSerialNumber(String facilitiesSerialNumber);

}
