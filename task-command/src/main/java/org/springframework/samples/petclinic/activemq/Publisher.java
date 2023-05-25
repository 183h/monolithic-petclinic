package org.springframework.samples.petclinic.activemq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

  private static final Logger LOGGER = LoggerFactory.getLogger(Publisher.class);


  private ObjectMapper objectMapper;

  private JmsTemplate jmsTemplate;

  @Value("${task.management-topic}")
  private String topic;

  @Autowired
  public Publisher(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;

    objectMapper = new ObjectMapper();

    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }

  public void sendMessage(TaskCreated message) {
    try {
      String data = objectMapper.writeValueAsString(message);
      jmsTemplate.convertAndSend(topic, data);
      LOGGER.info("Message sent!", data);
    } catch (Exception e) {
      LOGGER.error("Recieved Exception during send Message: ", e);
    }
  }

}
