package com.hfwas.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author HFwas
 * @Date 2021/11/24 23:46
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("path_route1", route ->
                        route.path("/guonei")
                                .uri("http://news.baidu.com/guonei"))
                .build();
    }

    @Bean
    public RouteLocator routeLocatorLB(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("path_route2", route ->
                        route.path("/payment/lb")
                                .uri("http://localhost:8001"))
                .build();
    }

}
