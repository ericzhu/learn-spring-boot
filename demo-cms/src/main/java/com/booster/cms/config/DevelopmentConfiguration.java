package com.booster.cms.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.booster.cms.core.service.EmailService;
import com.booster.cms.core.service.spring.EmailServiceMockImpl;

@Configuration
@Profile(Profiles.DEV)
@PropertySource("file:C:/Users/eric/cms/application-dev.properties")
public class DevelopmentConfiguration {

    @Bean
    public EmailService emailService() {
        return new EmailServiceMockImpl();
    }

    @Bean
    public ServletRegistrationBean h2ConsoleServletRegistration() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new WebServlet());
        bean.addUrlMappings("/h2console/*");
        return bean;
    }
}