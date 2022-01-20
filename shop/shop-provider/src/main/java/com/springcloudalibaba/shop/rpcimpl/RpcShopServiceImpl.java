package com.springcloudalibaba.shop.rpcimpl;

import com.springcloudalibaba.shop.rpcapi.RpcShopService;
import com.springcloudalibaba.shop.service.ShopService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class RpcShopServiceImpl implements RpcShopService {

    @Autowired
    private ShopService shopService;

    @Override
    public String getShopById(Integer shopId) {
        return shopService.getShopById(shopId);
    }
}
