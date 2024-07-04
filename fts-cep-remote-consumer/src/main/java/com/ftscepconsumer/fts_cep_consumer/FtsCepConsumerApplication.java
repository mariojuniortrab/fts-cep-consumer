package com.ftscepconsumer.fts_cep_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FtsCepConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtsCepConsumerApplication.class, args);
	}

}
