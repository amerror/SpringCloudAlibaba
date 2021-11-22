package com.company.springcloud;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Test01SpringcloudServiceConsumerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Test01SpringcloudServiceConsumerApplication.class, args);
        String name = applicationContext.getEnvironment().getProperty("myname");
        System.out.println("============test===============");
        System.out.println("======================"+name+"====================");

    }

}
