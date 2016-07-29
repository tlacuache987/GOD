package com.globant.ms.god.globers.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Glober {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Embedded
	private WorkStationPosition workstation;
}
