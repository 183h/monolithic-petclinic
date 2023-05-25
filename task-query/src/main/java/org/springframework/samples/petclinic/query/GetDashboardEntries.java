package org.springframework.samples.petclinic.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.domain.DashboardEntry;
import org.springframework.samples.petclinic.repository.DashboardEntryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetDashboardEntries {

    @Autowired
    DashboardEntryRepository repository;
    public List<DashboardEntry> execute() {
        return repository.findAll();
    }
}
