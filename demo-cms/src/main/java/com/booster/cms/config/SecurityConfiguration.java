package com.booster.cms.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment           env;

    private static final String[] PUBLIC_MATCHERS = { "/webjars/**",   //
        "/css/**",
        "/js/**",
        "/images/**",
        "/",
        "/about/**",
        "/contact/**",
        "/error/**/*", 
        "/h2console/**" // H2 in-memory database url
        };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<String> activeProfiles = Arrays.asList(env.getActiveProfiles());

        // Disable csrf and frameoptions for dev profile. This is required to run H2 Console properly.
        if (activeProfiles.contains(Profiles.DEV)) {
            http.csrf().disable();
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
            .antMatchers(PUBLIC_MATCHERS)
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/payload")
            .failureUrl("/login?error")
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("demo").password("pass").roles("USER", "ADMIN");
    }

}
