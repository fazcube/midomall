package com.itheima.foodconsumer.hystrix;

import com.entity.Cart;
import com.entity.Foods;
import com.itheima.foodconsumer.service.FoodService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodServiceHystrix implements FoodService{

    @Override
    public List<Foods> getAllFoods() {
        return null;
    }

    @Override
    public List<Foods> getOneFoods(String gname) {
        return null;
    }

    @Override
    public Foods getOneById(int gid) {
        return null;
    }

    @Override
    public int updateCart(int number, int id) {
        return 0;
    }

    @Override
    public int intcart(String goodsname, int number, int price, int goodid, int uid) {
        return 0;
    }

    @Override
    public List<Cart> getAllcart(int uid) {
        return null;
    }


}
