package com.springcloudalibaba.shop.controller;

import com.springcloudalibaba.shop.api.ShopRemoteService;
import com.springcloudalibaba.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController implements ShopRemoteService {

    @Autowired
    private ShopService shopService;


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
}