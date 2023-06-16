package com.example.assigment_TigerJS.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/shipment-booking/**").authenticated()
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/shipment-booking")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
    }
}
