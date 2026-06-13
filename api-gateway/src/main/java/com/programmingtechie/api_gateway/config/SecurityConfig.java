package com.programmingtechie.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

// @Configuration
// @EnableWebFluxSecurity
// public class SecurityConfig {
//     @Bean
//     public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
//         serverHttpSecurity
//                 .csrf().disable()
//                 .authorizeExchange(exchanges -> exchanges
//                         .pathMatchers("/eureka/**").permitAll().anyExchange().authenticated())
//                 .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
//         return serverHttpSecurity.build();
//     }
// }
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/eureka/**").permitAll()
                        .pathMatchers("/api/product/**").permitAll()
                        .pathMatchers("/api/order/**").permitAll()
                        .pathMatchers("/api/inventory/**").permitAll()
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .build();
    }
}