package com.company.springcloud.controller;


import com.company.springcloud.domain.User;
import com.company.springcloud.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zytwl
 */

@RestController
public class UserController implements UserService {

    @Override
    @GetMapping("/user/{string}")
    public String echo(@PathVariable String string){
        return "你好"+string;
    }

    @GetMapping("/user/{username}/{userpassword}")
    public String getUser(@PathVariable String username, @PathVariable String userpassword){
        return username+userpassword;
    }

    @GetMapping("/getuser/{id}")
    public User getUser2(@PathVariable Integer id){
        return new User("wanglin",id,23);
    }

    @Override
    @GetMapping("/adduser")
    public User getUser3(@RequestParam String username,@RequestParam String password){
        System.out.println("provider2在处理");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return new User("wanglin123",001,25);
    }
}
