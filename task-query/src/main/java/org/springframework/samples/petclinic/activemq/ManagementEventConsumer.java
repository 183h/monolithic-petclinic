package org.springframework.samples.petclinic.activemq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.samples.petclinic.domain.DashboardEntry;
import org.springframework.samples.petclinic.repository.DashboardEntryRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ManagementEventConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(ManagementEventConsumer.class);

  private ObjectMapper objectMapper;

  @Autowired
  DashboardEntryRepository repository;

  public ManagementEventConsumer(DashboardEntryRepository repository, ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    this.repository = repository;

    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
  }

  @JmsListener(destination = "${task.management-topic}")
  public void onMessage(String message) {
    try {
      LOGGER.info("Received Message: () ",  message);
      TaskCreated taskCreated = objectMapper.readValue(message, TaskCreated.class);

      repository.saveAndFlush(toDashboardEntry(taskCreated));

    } catch (Exception e) {
      LOGGER.error("Received Exception : ", e);
    }
  }

  private DashboardEntry toDashboardEntry(TaskCreated task) {
    DashboardEntry entry = new DashboardEntry();
    entry.setTaskName(task.getName());
    entry.setInstructions(task.getInstructions());
    entry.setDueDate(task.getDueDate());
    entry.setCreated(LocalDateTime.now());
    entry.setStatus(task.getStatus());

    return entry;
  }
}