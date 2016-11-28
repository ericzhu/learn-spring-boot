package com.booster.cms.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "com.booster.cms.core.repository")
@EntityScan(basePackages = "com.booster.cms.core.domain")
@EnableTransactionManagement
public class ApplicationConfiguration {

}