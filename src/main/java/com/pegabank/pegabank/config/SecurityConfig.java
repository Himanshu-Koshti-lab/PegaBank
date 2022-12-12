package com.pegabank.pegabank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //    Initial point where spring security get all filter details.
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        String ADMIN_ACCESS_URL = "/Welcome";
        String CLIENT_ACCESS_URL = "/Home";
        String OPEN_ACCESS_URL = "";
        http.authorizeRequests()
                .mvcMatchers(ADMIN_ACCESS_URL).authenticated()
                .mvcMatchers(CLIENT_ACCESS_URL).authenticated()
                .mvcMatchers(OPEN_ACCESS_URL).permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.withDefaultPasswordEncoder().username("Himanshu").password("12345").authorities("admin").build();
        UserDetails client = User.withDefaultPasswordEncoder().username("Raj").password("12345").authorities("client").build();

        return new InMemoryUserDetailsManager(admin, client);
    }


}
