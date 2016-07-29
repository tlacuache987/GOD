package com.globant.ms.god.workstationPositions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.globant.ms.god.domain.WorkstationPosition;

public interface IWorkstationPositionRepository extends JpaRepository<WorkstationPosition, Long> {

	List<WorkstationPosition> findAll();

	WorkstationPosition findByIdGlober(@Param("idGlober") Long idGlober);

	WorkstationPosition findByIdWorkstation(@Param("idWorkstation") Long idWorkstation);

}
