package com.springcloudalibaba.shop.service;

public interface ShopService {

    String getShopById(Integer shopId);

    String getUserById(Integer userId);

    void addShop(String shopName);

    void addShopUser(String shopName, String userName);
}
