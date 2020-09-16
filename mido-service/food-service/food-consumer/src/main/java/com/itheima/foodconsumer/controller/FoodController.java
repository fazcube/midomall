package com.itheima.foodconsumer.controller;

import com.entity.Cart;
import com.entity.CommonsResult;
import com.entity.Foods;
import com.itheima.foodconsumer.service.FoodService;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @RequestMapping("/test")
    public String test(Model model){
        Foods foods = new Foods();
        foods.setGname("我是测试数据");
        model.addAttribute("test",foods);
        return "test";
    }

    @RequestMapping(value = "/getAllFoods",method = RequestMethod.GET)
    public CommonsResult getAllFoods(){
        List<Foods> list = foodService.getAllFoods();
        return CommonsResult.success(list,"查询成功！");
    }

    /*
    查询商品
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
     */
    @RequestMapping(value = "cart",method = RequestMethod.GET)
    public String addCart(Cart cart){
        System.out.println("进入加购方法");
        System.out.println("获取到的商品数据："+cart);
        int result = foodService.intcart(cart.getGoodsname(),cart.getNumber(),cart.getPrice(),cart.getGoodid(),10026);
        System.out.println("执行加入购物车返回值："+result);
        return "index";
    }


}
