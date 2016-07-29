package com.globant.ms.god.workstations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.globant.ms.god.domain.Workstation;

//@RepositoryRestResource(path = "workstations")
public interface IWorkstationRepository extends JpaRepository<Workstation, Long> {

	List<Workstation> findAll();

	Workstation findByFacilitiesSerialNumberIgnoreCase(@Param("facilitiesSerialNumber") String facilitiesSerialNumber);

}
