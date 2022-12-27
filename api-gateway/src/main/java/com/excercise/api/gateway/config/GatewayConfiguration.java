package com.excercise.api.gateway.config;

import com.excercise.api.gateway.constant.PatternConstants;
import com.excercise.api.gateway.constant.URLConstants;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path(URLConstants.PRODUCT_SERVICE_GATEWAY_URL + "**")
                        .filters((f -> f.rewritePath(URLConstants.PRODUCT_SERVICE_GATEWAY_URL + PatternConstants.PATTERN_PARAM_IN_URL_BEFORE_REWRITE,
                                URLConstants.PRODUCT_SERVICE_MICROSERVICE_URL + PatternConstants.PATTERN_PARAM_IN_URL_AFTER_REWRITE)))
                        .uri("lb://product-service"))
                .build();
    }

}
