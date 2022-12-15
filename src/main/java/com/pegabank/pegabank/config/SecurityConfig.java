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

//    This is for in-memory/JDBC
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails admin = User.withDefaultPasswordEncoder().username("Himanshu").password("12345").authorities("admin").build();
//        UserDetails client = User.withDefaultPasswordEncoder().username("Raj").password("12345").authorities("client").build();
//
//        return new InMemoryUserDetailsManager(admin, client);
//    }

//    IT will conflict with custom table which implement UDS
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
