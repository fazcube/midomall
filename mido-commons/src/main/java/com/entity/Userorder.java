package com.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * (Userorder)实体类
 *
 * @author makejava
 * @since 2020-09-09 10:31:38
 */
@Data
@Entity
public class Userorder implements Serializable {
    private static final long serialVersionUID = 319837396838438663L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 商品名称
     */
    private String goodsname;
    /**
     * 购买数量
     */
    private Integer number;
    /**
     * 总价
     */
    private Integer price;

    private Date time;

    private Integer uid;

}