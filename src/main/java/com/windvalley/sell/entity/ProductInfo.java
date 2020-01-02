package com.windvalley.sell.entity;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
public class ProductInfo {
    //产品ID
    @Id
    private String id;

    //产品名称
    private String name;

    //产品单价
    private BigDecimal price;

    //产品库存
    private int stock;

    //产品描述
    private String description;

    //产品小图链接地址
    private String icon;

    //产品状态
    private int status;

    //产品类别编号
    private int categoryType;

    //创建时间
    private Timestamp crTime;

    //修改时间
    private Timestamp updateTime;
}
