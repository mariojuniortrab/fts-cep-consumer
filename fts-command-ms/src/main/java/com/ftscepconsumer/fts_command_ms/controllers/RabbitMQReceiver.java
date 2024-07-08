package com.ftscepconsumer.fts_command_ms.controllers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {
  @RabbitListener(queues = "command-address-queue")
  public void receiveMessage(String message) {
    System.out.println("Received Message: " + message);
  }
}
