package com.example.fullstackPractice.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public abstract class WebSecurityConfigurerAdapter {
    protected abstract void configure(HttoSecurity http) throws exception;

    //temporarily to send POST request without return error
        //any endpoint that comes through this path will be allowed
        protected abstract void configure(HttpSecurity http) throws exception;
}
