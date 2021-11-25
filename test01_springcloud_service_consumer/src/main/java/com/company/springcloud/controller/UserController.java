package com.company.springcloud.controller;

import com.company.springcloud.domain.User;
import com.company.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zytwl
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${myname:}")
    private String name;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user2/{username}")
    public String getUser(@PathVariable String username){
        System.out.println("========="+name);
        ServiceInstance serviceInstance = loadBalancerClient.choose("servie-provider");
        String url = String.format("http://servie-provider/user/%s",username);
        System.out.println("request url:"+url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/user/{user}")
    public String getUser2(@PathVariable String user){
//        return restTemplate.getForObject("http://servie-provider/user/{1}",String.class,user);
        return userService.echo(user);
    }

    @GetMapping("/user/{username}/{userpassword}")
    public String getUser3(@PathVariable String username,@PathVariable String userpassword){
        return restTemplate.getForObject("http://servie-provider/user/{1}/{2}",String.class,username,userpassword);
    }

    @GetMapping("/getuser/{userid}")
    public User getUser4(@PathVariable Integer userid){
        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("id",userid);
        return restTemplate.getForEntity("http://servie-provider/getuser/{id}",User.class,paramMap).getBody();
    }

    //@GetMapping("/adduser")
    public User getUser5(@RequestParam String username,@RequestParam String password){
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("username",username);
        map.put("password",password);
        return restTemplate.getForObject("http://servie-provider/adduser?username={username}&password={password}",User.class,map);
    }

    @GetMapping("/adduser")
    public User getUser6(@RequestParam String username,@RequestParam String password){
        return userService.getUser3(username, password);
    }








}
