package com.springcloudalibaba.nacosprovidersample8082;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderSample8082Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderSample8082Application.class, args);
    }

}
