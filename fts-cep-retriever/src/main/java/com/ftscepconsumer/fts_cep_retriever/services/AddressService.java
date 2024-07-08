package com.ftscepconsumer.fts_cep_retriever.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftscepconsumer.fts_cep_retriever.entities.Address;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

@Service
public class AddressService {

  @Autowired
  private WebClient webClient;

  @Autowired
  private AmqpTemplate amqpTemplate;

  private final ObjectMapper objectMapper = new ObjectMapper();

  private String remoteMSUri = "http://localhost:8080/remote/address/{cep}";
  private String databaseMSUri = "http://localhost:8080/query/address/{cep}";

  @CircuitBreaker(name = "internalService")
  public Mono<Address> getAddressByCep(String cep) {
    return this.getAddressFromDatabaseService(cep);
  }

  private Mono<Address> getAddressFromDatabaseService(String cep) {
    System.out.println("Trying to get address from database service");

    return this.getDataFromServer(this.databaseMSUri, cep)
        .bodyToMono(Address.class)
        .onErrorResume(Exception.class, ex -> this.getAddressFromExternalService(cep));
  }

  private Mono<Address> getAddressFromExternalService(String cep) {
    System.out.println("Trying to get address from external service");

    return this.getDataFromServer(this.remoteMSUri, cep)
        .bodyToMono(Address.class)
        .map(address -> this.callQueueCommandAddressAndReturn(address))
        .onErrorResume(Exception.class, ex -> Mono.empty());
  }

  private Address callQueueCommandAddressAndReturn(Address address) {
    System.out.println("Calling queue command address");
    try {
      amqpTemplate.convertAndSend(
          "command-address-exchange",
          "command-address-route-key",
          objectMapper.writeValueAsString(address));
      return address;

    } catch (Exception e) {
      return address;
    }
  }

  private ResponseSpec getDataFromServer(String uri, String cep) {
    return this.webClient.get()
        .uri(uri, cep)
        .retrieve()
        .onStatus(HttpStatusCode::isError, res -> Mono.error(Exception::new));
  }
}
