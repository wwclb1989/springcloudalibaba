package com.springcloudalibaba.user.service.impl;

import com.springcloudalibaba.shop.api.ShopRemoteService;
import com.springcloudalibaba.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final Map<Integer, String> userInfo = new HashMap<Integer, String>() {{
        put(1, "张三");
        put(2, "李四");
        put(1024, "Lisi");
    }};

    @Autowired
    private ShopRemoteService shopRemoteService;

    @Override
    public String getUserById(Integer userId) {
        return userInfo.get(userId);
    }

    @Override
    public String getShopById(Integer shopId) {
        return shopRemoteService.getShop(shopId);
    }
}
