package com.ps.tutorial.repositories;

import com.ps.tutorial.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")
public interface CountryRepository extends CrudRepository<Country, Integer> {

    List<Country> findByName(@Param("name") String name);

}
