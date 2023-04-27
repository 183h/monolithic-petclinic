package org.springframework.samples.petclinic.repository;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.domain.Team;

public interface TeamRepository extends Repository<Team, Integer> {
}
