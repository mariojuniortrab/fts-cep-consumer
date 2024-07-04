package com.ftscepconsumer.fts_cep_retriever.exceptions;

public class ServerErrorException extends Exception {
  private int statusCode;
  private String body;

  public ServerErrorException(int statusCode, String body) {
    super("fts-cep-remote-consumer returned an error");
    this.statusCode = statusCode;
    this.body = body;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getBody() {
    return body;
  }

}
