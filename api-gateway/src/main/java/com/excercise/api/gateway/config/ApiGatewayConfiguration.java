//package com.excercise.api.gateway.config;
//
//import com.ludus.microservice.apigateway.constants.URLConstants;
//import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
//import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import reactor.core.publisher.Mono;
//
//@Configuration
//public class ApiGatewayConfiguration {
//
//    private static final String DEFAULT_CONTEXT_PATH = "/partner-webservice";
//
//    @Bean
//    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//        //custom route without using application discovery
//        return builder.routes()
//                .route(p -> p
//                        // Domain Agency Sub User Management
//                        // path client call to api
//                        .path(DEFAULT_CONTEXT_PATH + URLConstants.DOMAIN_AGENCY_SUB_USER_MANAGEMENT_GATEWAY + "**")
//                        /*
//                            we rewrite it to the path needed on the microservices we call
//                            use this to get all value after prefix (?<segment>.*) and put to the new path we need
//                            For example : http://abc.com?a=5&c=6
//                            (?<segment>.*) is for ?a=5&c=6
//                         */
//                        .filters(f -> f.rewritePath(DEFAULT_CONTEXT_PATH + URLConstants.DOMAIN_AGENCY_SUB_USER_MANAGEMENT_GATEWAY + "(?<segment>.*)",
//                                URLConstants.DOMAIN_AGENCY_SUB_USER_MANAGEMENT_MICROSERVICE + "${segment}")
//                        )
//                        // lb is for application name we register on eureka ( server discovery)
//                        .uri("lb://domain-agency-sub-user-management"))
//                // Domain authorization service
//                .route(p -> p
//                        // path client call to api
//                        .path(DEFAULT_CONTEXT_PATH + URLConstants.DOMAIN_AUTHENTICATION_SERVICE_GATE_WAY + "**")
//                        .filters(f -> f
//                                .rewritePath(DEFAULT_CONTEXT_PATH + URLConstants.DOMAIN_AUTHENTICATION_SERVICE_MICROSERVICE + "(?<segment>.*)"
//                                , URLConstants.DOMAIN_AUTHENTICATION_SERVICE_MICROSERVICE + "${segment}")
//                                // Limit Request
//                                .requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter()).setStatusCode(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED))
//                        )
//                        // lb is for application name we register on eureka ( server discovery)
//                        .uri("lb://domain-authentication-service"))
//                .build();
//    }
//
//    @Bean
//    public KeyResolver userKeyResolver() {
//        return exchange -> Mono.just("1");
//    }
//
//    @Bean
//    // Tạo ra một bean component redisRateLimiter
//    public RedisRateLimiter redisRateLimiter() {
//        return new RedisRateLimiter(1, 1);
//    }
//}
