package com.springcloudalibaba.user.controller;

import com.springcloudalibaba.shop.rpcapi.RpcShopService;
import com.springcloudalibaba.user.api.UserRemoteService;
import com.springcloudalibaba.user.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserRemoteService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @DubboReference
    private RpcShopService rpcShopService;

    @Override
    public String getUser(Integer userId) {
        return userService.getUserById(userId);
    }

    @Override
    public String addUser(String userName) {
        userService.addUser(userName);
        return "success";
    }

    /**
     * 测试feign
     * @param shopId
     * @return
     */
    @RequestMapping("/user/getShop/{shopId}")
    public String getShop(@PathVariable Integer shopId) {
        return userService.getShopById(shopId);
    }

    @RequestMapping("/user/findShop/{shopId}")
    public String findShop(@PathVariable Integer shopId) {
        logger.info("user服务调用dubbo接口查询商户，shopId = {}", shopId);
        return rpcShopService.getShopById(shopId);
    }




}
