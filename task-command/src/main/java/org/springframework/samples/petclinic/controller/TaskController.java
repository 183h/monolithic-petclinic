package org.springframework.samples.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.dto.TaskDTO;
import org.springframework.samples.petclinic.command.CreateTask;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @Autowired
    CreateTask command;

    @PutMapping(consumes = "application/json")
    public void createTask(@RequestBody TaskDTO dto) {
        command.execute(dto);
    }
}
