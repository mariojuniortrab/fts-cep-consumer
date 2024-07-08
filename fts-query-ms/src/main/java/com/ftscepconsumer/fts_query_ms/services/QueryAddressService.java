package com.ftscepconsumer.fts_query_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftscepconsumer.fts_query_ms.entities.QueryAddress;
import com.ftscepconsumer.fts_query_ms.repositories.QueryAddressRepository;

@Service
public class QueryAddressService {

  @Autowired
  private QueryAddressRepository queryAddressRepository;

  public QueryAddress getAddress(String cep) {
    QueryAddress address = queryAddressRepository.findByCep(cep);

    return address;
  }

}
