package com.ftscepconsumer.fts_query_ms.repositories;

import org.springframework.stereotype.Repository;

import com.ftscepconsumer.fts_query_ms.entities.QueryAddress;

@Repository
public interface QueryAddressRepository {
  QueryAddress findByCep(String cep);
}
