package com.springcloudalibaba.shop.controller;

import com.springcloudalibaba.shop.api.ShopRemoteService;
import com.springcloudalibaba.shop.service.ShopService;
import com.springcloudalibaba.user.rpcapi.RpcUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController implements ShopRemoteService {
    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ShopService shopService;

    @DubboReference
    private RpcUserService rpcUserService;

    @Value("${customer.name}")
    private String customerName;


    @Override
    public String getShop(Integer shopId) {
        return shopService.getShopById(shopId);
    }

    /**
     * 测试feign接口
     * @param userId
     * @return
     */
    @RequestMapping("/shop/getUser/{userId}")
    public String getUser(@PathVariable Integer userId) {
        return shopService.getUserById(userId);
    }

    /**
     * 测试dubbo接口
     * @param userId
     * @return
     */
    @RequestMapping("/shop/findUser/{userId}")
    public String findUser(@PathVariable Integer userId) {
        logger.info("shop服务调用dubbo接口查询用户，userId = {}", userId);
        return rpcUserService.getUserById(userId);
    }

    /**
     * 测试nacos config
     * @return
     */
    @RequestMapping("/shop/testConfig")
    public String testConfig() {
        return customerName;
    }

    @RequestMapping("/shop/addShop")
    public String addShop(@RequestParam String shopName) {
        shopService.addShop(shopName);
        return "success";
    }

    @RequestMapping("/shop/addShopUser")
    public String addShop(@RequestParam String shopName, @RequestParam String userName) {
        shopService.addShopUser(shopName, userName);
        return "success";
    }
}
