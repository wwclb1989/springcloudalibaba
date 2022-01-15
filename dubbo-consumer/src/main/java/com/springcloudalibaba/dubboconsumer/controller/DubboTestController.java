package com.springcloudalibaba.dubboconsumer.controller;

import com.springcloudalibaba.dubboapi.service.TestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboTestController {

    @DubboReference
    private TestService testService;

    @RequestMapping("/dubboTest")
    public String dubboTest() {
        return testService.dubboTest("消费服务者");
    }


}
