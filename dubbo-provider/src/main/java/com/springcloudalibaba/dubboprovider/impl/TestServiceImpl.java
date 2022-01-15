package com.springcloudalibaba.dubboprovider.impl;

import com.springcloudalibaba.dubboapi.service.TestService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class TestServiceImpl implements TestService {

    @Override
    public String dubboTest(String message) {
        return "服务提供者，收到消息" + message;
    }
}
