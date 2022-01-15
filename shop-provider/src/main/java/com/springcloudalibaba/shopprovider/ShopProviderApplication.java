package com.springcloudalibaba.shopprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopProviderApplication.class, args);
    }

}
