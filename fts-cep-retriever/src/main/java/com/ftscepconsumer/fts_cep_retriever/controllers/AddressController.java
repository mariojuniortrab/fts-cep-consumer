package com.ftscepconsumer.fts_cep_retriever.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ftscepconsumer.fts_cep_retriever.entities.Address;
import com.ftscepconsumer.fts_cep_retriever.services.AddressService;

import reactor.core.publisher.Mono;

@RestController
public class AddressController {

  @Autowired
  private AddressService addressService;

  @Cacheable(value = "addressCache", key = "#cep", unless = "#result == null")
  @GetMapping("/address/{cep}")
  public Mono<Address> getAddress(@PathVariable String cep) {
    return addressService
        .getAddressByCep(cep);
  }
}
