package com.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-09-09 10:41:55
 */
@Data
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 931282197482114114L;
    /**
     * 账号
     */
    @Id
    private Integer uaccount;
    /**
     * 密码
     */
    private String upassword;
    /**
     * 姓名
     */
    private String uname;
    /**
     * 性别
     */
    private String usex;

}