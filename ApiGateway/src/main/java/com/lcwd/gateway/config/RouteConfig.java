package com.lcwd.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/users/**")
                        .uri("lb://USER-SERVICE"))
                .route(r -> r.path("/ratings/**")
                        .uri("lb://HOTEL-SERVICE/"))
                .route(r -> r.path("/hotels/**")
                        .uri("lb://HOTEL-SERVICE/"))
                .route(r -> r.path("/socket/**")
                        .uri("lb://NOTIFICATION-SERVICE/"))
                .build();
    }
}
