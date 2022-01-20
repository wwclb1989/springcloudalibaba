package com.springcloudalibaba.shop.api.fallback;

import com.springcloudalibaba.shop.api.ShopRemoteService;
import org.springframework.stereotype.Component;

@Component
public class ShopRemoteServiceFallBack implements ShopRemoteService {

    @Override
    public String getShop(Integer shopId) {
        return "shop服务不可用";
    }
}
