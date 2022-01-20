package com.springcloudalibaba.shop;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
@EnableFeignClients(basePackages = "com.springcloudalibaba.*.api")
@ComponentScan(basePackages = {"com.springcloudalibaba.shop", "com.springcloudalibaba.*.api.fallback"})
public class ShopProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopProviderApplication.class, args);
    }

}
