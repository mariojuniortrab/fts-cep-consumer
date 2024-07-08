package com.ftscepconsumer.fts_command_ms.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ftscepconsumer.fts_command_ms.entities.CommandAddress;

@Repository
public class JdbcCommandAddressRepository implements CommandAdressRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void save(CommandAddress address) {

    jdbcTemplate.update(
        "INSERT INTO addresses (cep, logradouro, complemento, bairro, localidade, uf) VALUES(?,?,?,?,?,?) ON DUPLICATE KEY UPDATE cep=cep;",
        new Object[] { address.getCep(), address.getLogradouro(), address.getComplemento(), address.getBairro(),
            address.getLocalidade(), address.getUf() });
  }
}
