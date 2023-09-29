package com.dnb.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnb.apigatewayservice.filter.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final JwtAuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().route("AUTH-SERVICE", r -> r.path("/authenticate/**").filters(f -> f.filter(filter)).uri("lb://AUTH-SERVICE"))
                .route("ACCOUNTSERVICE", r -> r.path("/account/**").filters(f -> f.filter(filter)).uri("lb://ACCOUNTSERVICE"))
                .route("CUSTOMERSERVICE", r -> r.path("/customer/**").filters(f -> f.filter(filter)).uri("lb://CUSTOMERSERVICE"))
                .build();
    }
}
