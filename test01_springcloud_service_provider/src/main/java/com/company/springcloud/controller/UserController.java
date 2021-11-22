package com.company.springcloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zytwl
 */

@RestController
public class UserController {

    @GetMapping("/user/{string}")
    public String echo(@PathVariable String string){
        return "你好"+string;
    }
}
