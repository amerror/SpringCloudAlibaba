package com.company.springcloud.service;

import com.company.springcloud.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="servie-provider")
public interface UserService {

    @GetMapping("/adduser")
    User getUser3(@RequestParam(value="username") String username, @RequestParam(value = "password") String password);

    @GetMapping("/user/{string}")
    String echo(@PathVariable("string") String string);


}
