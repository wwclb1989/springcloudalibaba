package com.springcloudalibaba.shop.service.impl;

import com.springcloudalibaba.shop.service.ShopService;
import com.springcloudalibaba.user.api.UserRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private UserRemoteService userRemoteService;

    private final Map<Integer, String> shopInfo = new HashMap<Integer, String>() {{
        put(1, "万顺福小卖部");
        put(2, "沃尔玛");
        put(1024, "美宜佳");
    }};


    @Override
    public String getShopById(Integer shopId) {
        return shopInfo.get(shopId);
    }

    @Override
    public String getUserById(Integer userId) {
        return userRemoteService.getUser(userId);
    }
}
