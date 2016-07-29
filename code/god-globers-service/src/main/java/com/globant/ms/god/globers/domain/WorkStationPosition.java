package com.globant.ms.god.globers.domain;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class WorkStationPosition {

	private String floor;

	private int deskNumber;

	private String workStation;
}
