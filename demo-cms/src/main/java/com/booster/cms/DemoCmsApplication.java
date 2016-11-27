package com.booster.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.booster.cms.core.repository")
public class DemoCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCmsApplication.class, args);
    }
}