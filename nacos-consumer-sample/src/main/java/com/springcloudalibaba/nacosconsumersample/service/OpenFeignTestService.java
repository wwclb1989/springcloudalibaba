package com.springcloudalibaba.nacosconsumersample.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "nacos-provider-sample", fallback = OpenFeignTestServiceFallBack.class)
public interface OpenFeignTestService {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String openFeignProviderTest();


}
