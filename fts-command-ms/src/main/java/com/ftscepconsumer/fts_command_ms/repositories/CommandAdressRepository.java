package com.ftscepconsumer.fts_command_ms.repositories;

import org.springframework.stereotype.Repository;

import com.ftscepconsumer.fts_command_ms.entities.CommandAddress;

@Repository
public interface CommandAdressRepository {
  void save(CommandAddress address);
}
