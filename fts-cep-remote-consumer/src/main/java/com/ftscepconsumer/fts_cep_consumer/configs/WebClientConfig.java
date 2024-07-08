package com.ftscepconsumer.fts_cep_consumer.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

  @Bean
  public WebClient webClient() {
    return WebClient.builder().baseUrl("https://viacep.com.br/ws/").build();
  }
}
