package com.itheima.userprovider.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    /**
     * 用户注册功能
     * @param upassword
     * @param uname
     * @param usex
     * @return
     */
    int register(@Param(value = "upassword")String upassword,
                 @Param(value = "uname")String uname,
                 @Param(value = "usex") String usex);

    /**
     * 用户登录功能
     * @param uname
     * @return
     */
    User login(@Param(value = "uname") String uname);

}
