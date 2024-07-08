package com.ftscepconsumer.fts_query_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftscepconsumer.fts_query_ms.entities.QueryAddress;
import com.ftscepconsumer.fts_query_ms.services.QueryAddressService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/query/address")
public class QueryAddressController {

  @Autowired
  private QueryAddressService queryAddressService;

  @GetMapping("/{cep}")
  public Mono<ResponseEntity<QueryAddress>> getAddress(@PathVariable String cep) {
    QueryAddress queryAddress = queryAddressService.getAddress(cep);

    return Mono.justOrEmpty(queryAddress)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
