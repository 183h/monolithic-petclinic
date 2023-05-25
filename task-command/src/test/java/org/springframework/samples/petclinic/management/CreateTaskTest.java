package org.springframework.samples.petclinic.management;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.dto.TaskDTO;
import org.springframework.samples.petclinic.command.CreateTask;
import org.springframework.samples.petclinic.domain.Task;
import org.springframework.samples.petclinic.repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CreateTaskTest {

    @Autowired
    CreateTask createTask;

    @Autowired
    TaskRepository repository;

    @Test
    void createTask() {


        TaskDTO dto = new TaskDTO();
        dto.setName("clean the floor");
        dto.setInstructions("take the mop, take the bin, clean the floor");
        dto.setDueDate(LocalDate.now());

        createTask.execute(dto);

        List<Task> tasks = repository.findAll();


        assertThat(tasks).hasSize(1);
    }
}
