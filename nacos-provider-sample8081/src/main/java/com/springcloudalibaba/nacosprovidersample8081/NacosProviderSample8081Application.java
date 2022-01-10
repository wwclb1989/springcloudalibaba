package com.springcloudalibaba.nacosprovidersample8081;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderSample8081Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderSample8081Application.class, args);
    }

}
