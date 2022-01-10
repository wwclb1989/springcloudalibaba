package com.springcloudalibaba.nacosconsumersample.service;

import org.springframework.stereotype.Component;

@Component
public class OpenFeignTestServiceFallBack implements OpenFeignTestService {

    @Override
    public String openFeignProviderTest() {
        return "这是降级方法";
    }
}
