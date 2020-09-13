package com.itheima.userconsumer.service;

import com.entity.User;
import com.itheima.userconsumer.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "user-provider",fallback =
        UserServiceHystrix.class)
public interface UserService {

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    int register(@RequestParam(value = "upassword")String upassword,
                 @RequestParam(value = "uname")String uname,
                 @RequestParam(value = "usex") String usex);

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(@RequestParam(value = "uname") String uname);

}

