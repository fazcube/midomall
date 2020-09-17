package com.itheima.foodconsumer.controller;

import com.entity.Cart;
import com.entity.CommonsResult;
import com.entity.Foods;
import com.itheima.foodconsumer.service.FoodService;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    /**
     * 测试方法
     * @param model
     * @return
     */
    @RequestMapping("/test")
    public String test(Model model){
        Foods foods = new Foods();
        foods.setGname("我是测试数据");
        model.addAttribute("test",foods);
        return "test";
    }

    /**
     * 查询所有商品
     * @return
     */
    @RequestMapping(value = "/getAllFoods",method = RequestMethod.GET)
    public String getAllFoods(Model model){
        List<Foods> list = foodService.getAllFoods();
        model.addAttribute("foods",list);
        System.out.println(list);
        return "index";
    }

    /**
     * 根据关键字查询商品
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/getOneFoods",method = RequestMethod.GET)
    public String getOne(HttpServletRequest request, Model model){
        String foodName = request.getParameter("name");
        System.out.println("关键字："+foodName);
        List<Foods> list = foodService.getOneFoods(foodName);
        System.out.println(list);
        model.addAttribute("detail",list);
        return "detail";
    }

    /**
     * 加入购物车
     * @param cart
     * @return
     */
    @RequestMapping(value = "/intCart",method = RequestMethod.GET)
    public String addCart(Cart cart){
        System.out.println("进入加购方法");
        System.out.println("获取到的商品数据："+cart);
        int result = foodService.intCart(cart.getGoodsname(),cart.getNumber(),cart.getPrice(),cart.getGoodid(),10026);
        System.out.println("执行加入购物车返回值："+result);
        return "index";
    }

    /**
     * 查询购物车所有商品
     * @param uid
     * @return
     */
    @RequestMapping(value = "/getAllCart",method = RequestMethod.GET)
    public String getAllCart(int uid,Model model){
        System.out.println("获取到的用户ID是："+uid);
        List<Cart> carts = foodService.getAllCart(uid);
        System.out.println("购物车："+carts);
        model.addAttribute("carts",carts);
        return "settle";
    }

    /**
     * 根据id删除购物车数据
     * @param did
     * @return
     */
    @RequestMapping(value = "/deleteCart",method = RequestMethod.GET)
    public String deleteCart(int did){
        System.out.println("获取到的购物车ID是："+did);
        int result = foodService.deleteCart(did);
        System.out.println("删除返回结果值："+result);
        return "settle";
    }



}
