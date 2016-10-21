package com.booster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class StockConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockConfigServiceApplication.class, args);
	}
}
