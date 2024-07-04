package com.ftscepconsumer.fts_cep_consumer.exceptions;

public class Is4xxException extends Exception {
  private int statusCode;

  public Is4xxException(int statusCode) {
    super("4xx error on remote server");
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return this.statusCode;
  }
}
