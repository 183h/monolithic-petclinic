package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.domain.DashboardEntry;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardEntryRepository extends JpaRepository<DashboardEntry, Integer> {
}
