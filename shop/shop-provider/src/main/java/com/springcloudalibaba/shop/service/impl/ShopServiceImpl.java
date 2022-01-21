package com.springcloudalibaba.shop.service.impl;

import com.springcloudalibaba.shop.service.ShopService;
import com.springcloudalibaba.user.api.UserRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {
    private static final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Autowired
    private UserRemoteService userRemoteService;

    private final Map<Integer, String> shopInfo = new HashMap<Integer, String>() {{
        put(1, "万顺福小卖部");
        put(2, "沃尔玛");
        put(1024, "美宜佳");
    }};


    @Override
    public String getShopById(Integer shopId) {
        logger.info("shop服务查询商户，shopId:{}", shopId);
        return shopInfo.get(shopId);
    }

    @Override
    public String getUserById(Integer userId) {
        logger.info("shop服务调用feign客户端查询用户，userId = {}", userId);
        return userRemoteService.getUser(userId);
    }
}
