package com.company.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zytwl
 */
@Configuration
public class MyRibbonConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){return new RestTemplate();}
}
