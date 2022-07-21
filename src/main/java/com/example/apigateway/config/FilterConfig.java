package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {
//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route.path("/user/**")
                        .filters(filter -> filter.addRequestHeader("user-request", "user-request-header")
                                .addResponseHeader("user-response", "user-response-header"))
                        .uri("http://localhost:8081/"))
                .route(route -> route.path("/order/**")
                        .filters(filter -> filter.addRequestHeader("order-request", "order-request-header")
                                .addResponseHeader("order-response", "order-response-header"))
                        .uri("http://localhost:8082/"))

                .build();
    }
}
