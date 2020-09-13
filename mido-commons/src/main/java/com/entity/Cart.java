package com.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * (Cart)实体类
 *
 * @author makejava
 * @since 2020-09-09 10:41:38
 */
@Data
@Entity
public class Cart implements Serializable {
    private static final long serialVersionUID = 263900224490633768L;

    @Id
    private Integer id;

    private String goodsname;

    private Integer number;

    private Integer price;

    private Integer goodid;

    private Integer uid;

}