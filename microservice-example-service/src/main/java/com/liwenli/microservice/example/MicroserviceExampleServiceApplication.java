package com.liwenli.microservice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MicroserviceExampleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceExampleServiceApplication.class, args);
        System.out.println("start success... ...");
    }

}
