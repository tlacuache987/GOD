package com.globant.ms.god.globers.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.ms.god.domain.Glober;
import com.globant.ms.god.globers.repository.IGloberRepository;
import com.globant.ms.god.globers.service.IGloberService;

@Service
public class GloberServiceImpl implements IGloberService {

	@Autowired
	private IGloberRepository globerRepository;

	@Override
	public List<Glober> getAll() {
		return globerRepository.findAll();
	}

	@Override
	public List<Glober> getAllWithWorkstationPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Glober create(Glober glober) {
		return globerRepository.save(glober);
	}

	@Override
	public Glober getById(Long id) {
		return globerRepository.findOne(id);
	}

	@Override
	public Glober modify(Long id, Glober glober) {
		Glober existingGlober = globerRepository.findOne(id);

		BeanUtils.copyProperties(glober, existingGlober);

		return globerRepository.saveAndFlush(existingGlober);
	}

	@Override
	public Glober delete(Long id) {
		Glober existingGlober = globerRepository.findOne(id);

		globerRepository.delete(existingGlober);

		return existingGlober;
	}

	@Override
	public Glober getByName(String name) {
		return globerRepository.findByNameIgnoreCase(name);
	}

}
