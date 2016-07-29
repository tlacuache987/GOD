package com.globant.ms.god.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class WorkstationPosition {

	@Id
	@GeneratedValue
	private Long id;

	private Long idGlober;

	private Long idWorkstation;

	private String floor;

	private int deskNumber;

	@Transient
	private Workstation workstation;
}
