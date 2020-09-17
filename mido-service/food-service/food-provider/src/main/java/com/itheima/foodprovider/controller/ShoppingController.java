package com.itheima.foodprovider.controller;

import com.entity.Cart;
import com.itheima.foodprovider.dao.ShoppingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingController {

    @Autowired
    ShoppingDao shoppingDao;

    @RequestMapping(value = "/updateCart",method = RequestMethod.GET)
    public int updateCart(@RequestParam(value = "number")int number,
                          @RequestParam(value = "id")int id){
        return shoppingDao.updateCart(number,id);
    }

    @RequestMapping(value = "/getAllCart",method = RequestMethod.GET)
    public List<Cart> getAllCart(@RequestParam(value = "uid")int uid){
        System.out.println(uid);
        return shoppingDao.getAllCart(uid);
    }

    @RequestMapping(value = "/intCart",method = RequestMethod.GET)
    public int intCart(@RequestParam(value = "goodsname")String goodsname,
                       @RequestParam(value = "number")int number,
                       @RequestParam(value = "price")int price,
                       @RequestParam(value = "goodid")int goodid,
                       @RequestParam(value = "uid")int uid){
        return shoppingDao.intCart(goodsname,number,price,goodid,uid);
    }

    @RequestMapping(value = "/deleteCart",method = RequestMethod.GET)
    public int deleteCart(@RequestParam(value = "did")int did){
        return shoppingDao.deleteCart(did);
    }

}
