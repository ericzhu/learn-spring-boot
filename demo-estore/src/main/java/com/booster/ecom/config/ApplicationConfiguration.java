package com.booster.ecom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.booster.ecom.constant.Profiles;
import com.booster.ecom.data.DemoDataSetup;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @Profile(Profiles.DEMO)
    public DemoDataSetup demoDataSetup() {
        return new DemoDataSetup();
    }
}
