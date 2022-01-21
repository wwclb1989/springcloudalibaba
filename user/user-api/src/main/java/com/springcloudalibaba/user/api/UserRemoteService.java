package com.springcloudalibaba.user.api;

import com.springcloudalibaba.user.api.fallback.UserRemoteServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-provider", fallback = UserRemoteServiceFallBack.class)
public interface UserRemoteService {

    @RequestMapping(value = "/user/findById", method = RequestMethod.GET)
    String getUser(@RequestParam Integer userId);

    @RequestMapping(value = "/user/addUser", method = RequestMethod.GET)
    String addUser(@RequestParam String userName);

}
