package com.ftscepconsumer.fts_cep_retriever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FtsCepRetrieverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtsCepRetrieverApplication.class, args);
	}

}
