package com.ftscepconsumer.fts_command_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftscepconsumer.fts_command_ms.entities.CommandAddress;
import com.ftscepconsumer.fts_command_ms.repositories.CommandAdressRepository;

@Service
public class CommandAddressService {

  @Autowired
  private CommandAdressRepository commandAdressRepository;

  public void save(CommandAddress address) {
    commandAdressRepository.save(address);
  }
}
