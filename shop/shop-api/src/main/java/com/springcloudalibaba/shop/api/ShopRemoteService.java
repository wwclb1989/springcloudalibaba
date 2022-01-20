package com.springcloudalibaba.shop.api;

import com.springcloudalibaba.shop.api.fallback.ShopRemoteServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shop-provider", fallback = ShopRemoteServiceFallBack.class)
public interface ShopRemoteService {

    @RequestMapping(value = "/shop/findById", method = RequestMethod.GET)
    String getShop(@RequestParam Integer shopId);


}
