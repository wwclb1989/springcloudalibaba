package com.springcloudalibaba.nacosconsumersample.controller;

import com.springcloudalibaba.nacosconsumersample.service.OpenFeignTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final String SERVER_URL = "http://nacos-provider-sample";

    @Autowired
    private OpenFeignTestService openFeignTestService;

    @RequestMapping("/test")
    public String test() {

        return openFeignTestService.openFeignProviderTest();
    }


}
