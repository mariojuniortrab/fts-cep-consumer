package com.ftscepconsumer.fts_cep_consumer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftscepconsumer.fts_cep_consumer.entities.Address;
import com.ftscepconsumer.fts_cep_consumer.services.AddressService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/remote/address")
public class AddressController {

  @Autowired
  private AddressService addressService;

  @GetMapping(value = "/{cep}")
  public Mono<ResponseEntity<Address>> getAddress(@PathVariable String cep) {
    return addressService
        .getAddressByCep(cep)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
