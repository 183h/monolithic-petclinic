package org.springframework.samples.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.domain.DashboardEntry;
import org.springframework.samples.petclinic.query.GetDashboardEntries;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {
    @Autowired
    GetDashboardEntries command;

    @GetMapping(path="/all")
    public List<DashboardEntry> getAllDashboardEntries() {
        return command.execute();
    }
}
