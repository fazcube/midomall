package com.itheima.foodprovider.controller;

import com.entity.Foods;
import com.itheima.foodprovider.dao.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodDao foodDao;

    @RequestMapping(value = "/getAllFoods",method = RequestMethod.GET)
    public List<Foods> getAllFoods(){
        return foodDao.getAllFoods();
    }
    @RequestMapping(value = "/getOneFoods",method = RequestMethod.GET)
    public List<Foods> getOneFoods(@RequestParam(value = "gname")String gname){
        return foodDao.getOneFoods(gname);
    }
    @RequestMapping(value = "/getOneById",method = RequestMethod.GET)
    public Foods getOneById(@RequestParam(value = "gid")int gid){
        return foodDao.getOneById(gid);
    }

}
