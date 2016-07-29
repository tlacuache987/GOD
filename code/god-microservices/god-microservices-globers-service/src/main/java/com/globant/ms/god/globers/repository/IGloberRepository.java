package com.globant.ms.god.globers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.globant.ms.god.domain.Glober;

//@RepositoryRestResource(path = "globers")
public interface IGloberRepository extends JpaRepository<Glober, Long> {

	List<Glober> findAll();

	Glober findByNameIgnoreCase(@Param("name") String name);

}
