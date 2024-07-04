package com.ftscepconsumer.fts_cep_consumer.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ftscepconsumer.fts_cep_consumer.entities.Address;
import com.ftscepconsumer.fts_cep_consumer.exceptions.Is4xxException;
import com.ftscepconsumer.fts_cep_consumer.exceptions.Is5xxException;

import reactor.core.publisher.Mono;

@Service
public class AddressService {

  private final WebClient webClient;

  public AddressService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://viacep.com.br/ws/").build();
  }

  public Mono<Address> getAddressByCep(String cep) {
    return this.webClient.get()
        .uri("/{cep}/json/", cep)
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError,
            response -> Mono.error(new Is4xxException(response.statusCode().value())))
        .onStatus(HttpStatusCode::is5xxServerError,
            response -> Mono.error(new Is5xxException()))
        .bodyToMono(Address.class)
        .onErrorResume(Is4xxException.class, ex -> {
          if (ex.getStatusCode() == HttpStatus.NOT_FOUND.value()) {
            return Mono.just(new Address()); // Return a default address or handle as needed
          }

          return Mono.error(ex);
        })
        .onErrorResume(Is5xxException.class, ex -> Mono.just(new Address()));
  }
}
