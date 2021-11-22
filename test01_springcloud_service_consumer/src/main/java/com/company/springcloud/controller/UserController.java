package com.company.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zytwl
 */
@RestController
public class UserController {

    @Value("${myname:}")
    private String name;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{username}")
    public String getUser(@PathVariable String username){
        System.out.println("========="+name);
        ServiceInstance serviceInstance = loadBalancerClient.choose("servie-provider");
        String url = String.format("http://servie-provider/user/%s",username);
        System.out.println("request url:"+url);
        return restTemplate.getForObject(url, String.class);
    }


}
