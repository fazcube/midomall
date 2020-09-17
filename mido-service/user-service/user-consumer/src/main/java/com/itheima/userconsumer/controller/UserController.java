package com.itheima.userconsumer.controller;

import com.itheima.userconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/toregister")
    public String toregister() {
        return "register";
    }

    @GetMapping(value = "/register")
    public String register(HttpServletRequest request, String upassword, String uname, String usex) {
        if(userService.register(upassword, uname, usex)>0){
            System.out.print("注册成功");
            return "login";
        }
        System.out.print("注册失败");
        return "register";
    }

    @GetMapping(value = "/tologin")
    public String tologin() {
        return "login";
    }

    @GetMapping(value = "/login")
    public String login(String uname, String upassword, HttpServletRequest
            request) {
        if (userService.login(uname)!= null) {
            if (userService.login(uname).getUpassword().equals(upassword)){
                HttpSession session = request.getSession(true);
                session.setAttribute("user", userService.login(uname));
                System.out.print("登录成功");
                System.out.println(session.getAttribute("user"));
                return "redirect:http://localhost:8300/food/getAllFoods";
            }
        }
        System.out.print("登录失败");
        return "login";
    }



}
