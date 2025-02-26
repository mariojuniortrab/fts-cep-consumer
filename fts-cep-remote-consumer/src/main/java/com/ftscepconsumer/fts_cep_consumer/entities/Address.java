package com.ftscepconsumer.fts_cep_consumer.entities;

import java.io.Serializable;

public class Address implements Serializable {
  private static final long serialVersionUID = 1L;

  private String id;
  private String cep;
  private String logradouro;
  private String complemento;
  private String bairro;
  private String localidade;
  private String uf;

  public Address() {

  }

  public Address(String id, String cep, String logradouro, String complemento, String bairro, String localidade,
      String uf) {
    this.id = id;
    this.cep = cep;
    this.logradouro = logradouro;
    this.complemento = complemento;
    this.bairro = bairro;
    this.localidade = localidade;
    this.uf = uf;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

}
