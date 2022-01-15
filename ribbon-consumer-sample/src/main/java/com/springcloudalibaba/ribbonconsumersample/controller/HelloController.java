package com.springcloudalibaba.ribbonconsumersample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    private RestTemplate restTemplate;

    @GetMapping("/hi")
    public String hello() {
        return null;
    }


}
