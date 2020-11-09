package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.marketplace.model.Animal;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "animals", path = "animals")
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
