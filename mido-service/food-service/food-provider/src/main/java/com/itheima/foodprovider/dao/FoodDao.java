package com.itheima.foodprovider.dao;

import com.entity.Foods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoodDao {

    List<Foods> getAllFoods();

    List<Foods> getOneFoods(@Param(value = "gname")String gname);

    Foods getOneById(@Param(value = "gid")int gid);

}
