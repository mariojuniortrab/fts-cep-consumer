package com.ftscepconsumer.fts_query_ms.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ftscepconsumer.fts_query_ms.entities.QueryAddress;

@Repository
public class JdbcQueryAddressRepository implements QueryAddressRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public QueryAddress findByCep(String cep) {
    try {
      if (cep.length() == 8) {
        cep = formatCep(cep);
      }

      System.out.println(cep);
      System.out.println("SELECT * FROM addresses WHERE cep=" + cep);
      QueryAddress address = jdbcTemplate.queryForObject("SELECT * FROM addresses WHERE cep=?",
          BeanPropertyRowMapper.newInstance(QueryAddress.class), cep);

      return address;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  private String formatCep(String str) {
    String ch = "-";
    StringBuilder sb = new StringBuilder(str);
    sb.insert(5, ch);
    return sb.toString();
  }
}
