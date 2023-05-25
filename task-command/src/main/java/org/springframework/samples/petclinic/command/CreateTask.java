package org.springframework.samples.petclinic.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.activemq.Publisher;
import org.springframework.samples.petclinic.activemq.TaskCreated;
import org.springframework.samples.petclinic.dto.TaskDTO;
import org.springframework.samples.petclinic.domain.Status;
import org.springframework.samples.petclinic.domain.Task;
import org.springframework.samples.petclinic.repository.TaskRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateTask {
    @Autowired
    TaskRepository repository;

    @Autowired
    Publisher publisher;

    @Transactional
    public void execute(TaskDTO dto) {
        Task task = new Task();
        task.setName(dto.getName());
        task.setInstructions(dto.getInstructions());
        task.setDueDate(dto.getDueDate());
        task.setStatus(Status.NEW);

        Task savedTask = repository.saveAndFlush(task);

        TaskCreated message = new TaskCreated();
        message.setId(savedTask.getId());
        message.setName(savedTask.getName());
        message.setInstructions(savedTask.getInstructions());
        message.setDueDate(savedTask.getDueDate());
        message.setStatus(savedTask.getStatus());

        publisher.sendMessage(message);
    }
}
