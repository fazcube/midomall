package com.itheima.foodconsumer.controller;

import com.entity.CommonsResult;
import com.entity.Foods;
import com.itheima.foodconsumer.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/getAllFoods",method = RequestMethod.GET)
    public CommonsResult getAllFoods(){
        List<Foods> list = foodService.getAllFoods();
        return CommonsResult.success(list,"查询成功！");
    }



}
