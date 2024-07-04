package com.ftscepconsumer.fts_cep_retriever.services;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ftscepconsumer.fts_cep_retriever.entities.Address;
import com.ftscepconsumer.fts_cep_retriever.exceptions.ServerErrorException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

@Service
public class AddressService {

  private final WebClient webClient;

  public AddressService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("http://localhost:8080/remote/address").build();
  }

  @CircuitBreaker(name = "internalService")
  public Mono<Address> getAddressByCep(String cep) {
    return this.webClient.get()
        .uri("/{cep}", cep)
        .retrieve()
        .onStatus(HttpStatusCode::isError,
            response -> Mono.error(
                new ServerErrorException(response.statusCode().value(), response.bodyToMono(String.class).toString())))
        .bodyToMono(Address.class)
        .onErrorResume(ServerErrorException.class, ex -> {
          System.out.println("StatusCode: " + ex.getStatusCode());
          System.out.println("Body: " + ex.getBody());
          return Mono.just(new Address());
        });
  }
}
