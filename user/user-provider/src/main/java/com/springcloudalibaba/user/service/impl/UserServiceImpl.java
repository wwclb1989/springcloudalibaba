package com.springcloudalibaba.user.service.impl;

import com.springcloudalibaba.shop.api.ShopRemoteService;
import com.springcloudalibaba.user.service.UserService;
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
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final Map<Integer, String> userInfo = new HashMap<Integer, String>() {{
        put(1, "张三");
        put(2, "李四");
        put(1024, "Lisi");
    }};

    @Autowired
    private ShopRemoteService shopRemoteService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getUserById(Integer userId) {
        logger.info("user服务查询用户，userId:{}", userId);
        return userInfo.get(userId);
    }

    @Override
    public String getShopById(Integer shopId) {
        logger.info("user服务调用feign接口查询商户shopId:{}", shopId);
        return shopRemoteService.getShop(shopId);
    }

    @Transactional
    @GlobalTransactional
    @Override
    public void addUser(String userName) {

        String sql = "insert into user_info(name) values (?)";
        jdbcTemplate.update(sql, userName);
    }
}
