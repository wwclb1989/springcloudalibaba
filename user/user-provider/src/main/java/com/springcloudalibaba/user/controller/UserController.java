package com.springcloudalibaba.user.controller;

import com.springcloudalibaba.shop.rpcapi.RpcShopService;
import com.springcloudalibaba.user.api.UserRemoteService;
import com.springcloudalibaba.user.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserRemoteService {

    @Autowired
    private UserService userService;

    @DubboReference
    private RpcShopService rpcShopService;

    @Override
    public String getUser(Integer userId) {
        return userService.getUserById(userId);
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
        return rpcShopService.getShopById(shopId);
    }


}
