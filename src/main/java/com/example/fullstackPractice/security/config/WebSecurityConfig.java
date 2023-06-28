package com.example.fullstackPractice.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

//temporarily to send POST request without return error
    //any endpoint that comes through this path will be allowed
    @Override
    protected void configure(HttpSecurity http) throws exception {
        http.
                  authorizeHttpRequests(auth -> auth)
                .requestMatchers("/api/v*/registration/**")
                .permitAll().anyRequest()
                .authenticated().and
                .formLogin();

    }
}

