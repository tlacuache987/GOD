package com.globant.ms.god.workstations.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.ms.god.domain.Workstation;
import com.globant.ms.god.workstations.repository.IWorkstationRepository;
import com.globant.ms.god.workstations.service.IWorkstationService;

@Service
public class WorkstationServiceImpl implements IWorkstationService {

	@Autowired
	private IWorkstationRepository workstationRepository;

	@Override
	public List<Workstation> getAll() {
		return workstationRepository.findAll();
	}

	@Override
	public Workstation create(Workstation workstation) {
		return workstationRepository.save(workstation);
	}

	@Override
	public Workstation getById(Long id) {
		return workstationRepository.findOne(id);
	}

	@Override
	public Workstation modify(Long id, Workstation workstation) {
		Workstation existingWorkstation = workstationRepository.findOne(id);

		BeanUtils.copyProperties(workstation, existingWorkstation);

		return workstationRepository.saveAndFlush(existingWorkstation);
	}

	@Override
	public Workstation delete(Long id) {
		Workstation existingWorkstation = workstationRepository.findOne(id);

		workstationRepository.delete(existingWorkstation);

		return existingWorkstation;
	}

	@Override
	public Workstation getByFacilitiesSerialNumber(String facilitiesSerialNumber) {
		return workstationRepository.findByFacilitiesSerialNumberIgnoreCase(facilitiesSerialNumber);
	}

}
