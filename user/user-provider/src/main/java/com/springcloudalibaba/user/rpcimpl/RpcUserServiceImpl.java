package com.springcloudalibaba.user.rpcimpl;

import com.springcloudalibaba.user.rpcapi.RpcUserService;
import com.springcloudalibaba.user.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class RpcUserServiceImpl implements RpcUserService {

    @Autowired
    private UserService userService;

    @Override
    public String getUserById(Integer userId) {
        return userService.getUserById(userId);
    }
}
