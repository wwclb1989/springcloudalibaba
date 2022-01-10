package com.springcloudalibaba.nacosconsumersample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope   // 通过spring cloud原生注解实现配置自动更新
public class ConfigController {

    @Value("${custom.info}")
    private String config;

    @RequestMapping("/getConfig")
    public String getConfig() {
        return config;
    }


}
