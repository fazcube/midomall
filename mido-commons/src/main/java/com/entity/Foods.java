package com.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2020-09-09 10:39:15
 */
@Data
@Entity
public class Foods implements Serializable {
    private static final long serialVersionUID = -58832349370422211L;
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    /**
     * 商品名称
     */
    private String gname;
    /**
     * 商品图片地址
     */
    private String gremain;
    /**
     * 商品介绍
     */
    private String gdetails;
    /**
     * 商品价格
     */
    private Integer gprice;
    /**
     * 商品类别
     */
    private Integer types;

}