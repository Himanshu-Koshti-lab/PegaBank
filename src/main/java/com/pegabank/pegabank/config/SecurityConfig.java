package com.pegabank.pegabank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //    Initial point where spring security get all filter details.
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        String ADMIN_ACCESS_URL = "/Welcome";
        String OPEN_ACCESS_URL = "/register";
        http
                .csrf().disable()  //To allow access through postman
                .authorizeRequests()
                .mvcMatchers(ADMIN_ACCESS_URL).authenticated()
                .mvcMatchers(OPEN_ACCESS_URL).permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
