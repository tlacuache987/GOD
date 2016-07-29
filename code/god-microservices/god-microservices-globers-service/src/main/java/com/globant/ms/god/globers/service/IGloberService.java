package com.globant.ms.god.globers.service;

import java.util.List;

import com.globant.ms.god.domain.Glober;

public interface IGloberService {

	List<Glober> getAll();

	Glober create(Glober glober);

	Glober getById(Long id);

	Glober modify(Long id, Glober glober);

	Glober delete(Long id);

	Glober getByName(String name);

	List<Glober> getAllWithWorkstationPosition();

}
