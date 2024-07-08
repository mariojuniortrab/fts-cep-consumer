package com.ftscepconsumer.fts_command_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ftscepconsumer.fts_command_ms.entities.CommandAddress;
import com.ftscepconsumer.fts_command_ms.services.CommandAddressService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/command/address")
public class CommandAddressController {

  @Autowired
  private CommandAddressService commandAddressService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Void> saveAddress(@RequestBody CommandAddress address) {
    commandAddressService.save(address);
    return Mono.empty();
  }
}
