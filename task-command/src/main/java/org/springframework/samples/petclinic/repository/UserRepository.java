package org.springframework.samples.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.domain.Task;
import org.springframework.samples.petclinic.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
