package com.globant.ms.god.globers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.globant.ms.god.globers.domain.Glober;

@RepositoryRestResource(path = "globers")
public interface IGloberRepository extends CrudRepository<Glober, Long> {

	List<Glober> findAll();

	Glober findByNameIgnoreCase(@Param("name") String name);

}
