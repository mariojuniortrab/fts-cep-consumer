package com.ftscepconsumer.fts_cep_consumer.exceptions;

public class Is5xxException extends Exception {

  public Is5xxException() {
    super("5xx error on remote server");
  }
}
