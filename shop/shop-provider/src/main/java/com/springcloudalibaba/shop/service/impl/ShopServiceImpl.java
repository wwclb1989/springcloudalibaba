package com.springcloudalibaba.shop.service.impl;

import com.springcloudalibaba.shop.service.ShopService;
import com.springcloudalibaba.user.api.UserRemoteService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {
    private static final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Autowired
    private UserRemoteService userRemoteService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    @Override
    public void addShop(String shopName) {
        String sql = "insert into shop_info(name) values (?)";
        jdbcTemplate.update(sql, shopName);
    }

    @Transactional
    @GlobalTransactional
    @Override
    public void addShopUser(String shopName, String userName) {
        addShop(shopName);

        userRemoteService.addUser(userName);
        throw new RuntimeException();
    }

}
