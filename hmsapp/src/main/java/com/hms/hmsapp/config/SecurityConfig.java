package com.hms.hmsapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration   // tells spring boot that this is configuration class
@EnableWebSecurity   // avoid to use defualt configuration but to use custom configuration.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // ctrl +o to see al  method of parent class (i.e WebSecurityConfigurerAdapter) then select required method to override as per our requirement.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
