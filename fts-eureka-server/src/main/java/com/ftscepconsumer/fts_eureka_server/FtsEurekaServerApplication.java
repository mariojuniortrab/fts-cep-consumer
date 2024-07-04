package com.ftscepconsumer.fts_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FtsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtsEurekaServerApplication.class, args);
	}

}
