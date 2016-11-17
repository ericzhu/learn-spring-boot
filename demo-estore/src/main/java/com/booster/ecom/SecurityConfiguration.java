package com.booster.ecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.booster.ecom.service.spring.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .permitAll();
    }
    
    @Autowired
    protected void configureJpaBasedUsers(AuthenticationManagerBuilder auth, SpringDataUserDetailsService userDetailsService) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // auth.inMemoryAuthentication()//
    // .withUser("test")
    // .password("test")
    // .roles("ADMIN", "USER")
    // .and()
    // .withUser("john")
    // .password("john")
    // .roles("USER")
    // .accountLocked(true);
    // }
}