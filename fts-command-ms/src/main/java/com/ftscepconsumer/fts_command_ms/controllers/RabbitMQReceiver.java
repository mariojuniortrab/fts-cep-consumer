package com.ftscepconsumer.fts_command_ms.controllers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftscepconsumer.fts_command_ms.entities.CommandAddress;
import com.ftscepconsumer.fts_command_ms.services.CommandAddressService;

@Component
public class RabbitMQReceiver {
  @Autowired
  private CommandAddressService commandAddressService;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @RabbitListener(queues = "command-address-queue")
  public void receiveMessage(String message) {
    try {
      CommandAddress address = objectMapper.readValue(message, CommandAddress.class);
      System.err.println(address);
      commandAddressService.save(address);
    } catch (Exception e) {
      return;
    }
  }
}
