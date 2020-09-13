package com.itheima.foodconsumer.service;

import com.entity.Cart;
import com.entity.Foods;
import com.itheima.foodconsumer.hystrix.FoodServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "food-provider",fallback = FoodServiceHystrix.class)
public interface FoodService {

    @RequestMapping(value = "/getAllFoods",method = RequestMethod.GET)
    List<Foods> getAllFoods();
    @RequestMapping(value = "/getOneFoods",method = RequestMethod.GET)
    List<Foods> getOneFoods(@RequestParam(value = "gname") String gname);
    @RequestMapping(value = "/getOneById",method = RequestMethod.GET)
    Foods getOneById(@RequestParam(value = "gid") int gid);

    @RequestMapping(value = "/updateCart",method = RequestMethod.GET)
    public int updateCart(@RequestParam(value = "number") int
                                  number,
                          @RequestParam(value = "id") int id);
    @RequestMapping(value = "/intcart",method = RequestMethod.GET)
    public int intcart(@RequestParam(value = "goodsname") String
                               goodsname,
                       @RequestParam(value = "number") int number,
                       @RequestParam(value = "price") int price,
                       @RequestParam(value = "goodid") int goodid,
                       @RequestParam(value = "uid") int uid);
    @RequestMapping(value = "/getAllcart",method = RequestMethod.GET)
    public List<Cart> getAllcart(@RequestParam(value = "uid") int
                                         uid);

}
