package com.booster.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile(Profiles.PROD)
@PropertySource("file://C:/Users/eric/cms/application-prod.properties")
public class ProductionConfiguration {

}
