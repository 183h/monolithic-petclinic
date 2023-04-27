package org.springframework.samples.petclinic.repository;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.domain.Task;

public interface TaskRepository extends Repository<Task, Integer> {
}
