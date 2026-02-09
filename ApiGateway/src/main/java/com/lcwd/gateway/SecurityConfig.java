//package com.lcwd.gateway; // Use your correct package structure
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//// Since you are using spring-boot-starter-webflux (reactive stack),
//// we use WebFlux security configuration.
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//
//        http
//                // 1. Disable CSRF for all requests in the Gateway
//                .csrf(csrf -> csrf.disable())
//
//                // 2. Disable default HTTP Basic/Form-based login
//                .httpBasic(httpBasic -> httpBasic.disable())
//                .formLogin(formLogin -> formLogin.disable())
//
//                // 3. Allow all requests (or secure them with OAuth/JWT later)
//                .authorizeExchange(exchange -> exchange.anyExchange().permitAll());
//
//        return http.build();
//    }
//}