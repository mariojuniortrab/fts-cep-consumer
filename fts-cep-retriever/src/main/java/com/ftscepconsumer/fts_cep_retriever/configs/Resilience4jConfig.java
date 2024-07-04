package com.ftscepconsumer.fts_cep_retriever.configs;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;

@Configuration
public class Resilience4jConfig {
  @Bean
  public CircuitBreakerConfigCustomizer internalServiceCircuitBreakerConfig() {
    return CircuitBreakerConfigCustomizer
        .of("internalService",
            builder -> builder.slidingWindowSize(10)
                .slidingWindowType(SlidingWindowType.COUNT_BASED)
                .waitDurationInOpenState(Duration.ofSeconds(5))
                .minimumNumberOfCalls(5)
                .failureRateThreshold(50.0f));
  }
}
