package com.rudyvissers.example2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HelloWorldConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldConfiguration.class, args);
    }

}