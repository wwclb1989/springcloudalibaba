package com.springcloudalibaba.user.api.fallback;

import com.springcloudalibaba.user.api.UserRemoteService;
import org.springframework.stereotype.Component;

@Component
public class UserRemoteServiceFallBack implements UserRemoteService {

    @Override
    public String getUser(Integer userId) {
        return "用户服务不可用";
    }

    @Override
    public String addUser(String userName) {
        return "用户服务不可用";
    }
}
