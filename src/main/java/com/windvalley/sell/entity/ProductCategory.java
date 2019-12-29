package com.windvalley.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@DynamicUpdate
public class ProductCategory {
    //类目编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //类目名称
    private String name;

    //类目编号
    private Integer type;

    //创建时间
    private Timestamp crTime;

    //修改时间
    private Timestamp updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String name, Integer type) {
        this.name = name;
        this.type = type;
    }
}
