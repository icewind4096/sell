package com.windvalley.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInfoVO {
    private String id;

    private String name;

    private BigDecimal price;

    private String description;

    private String icon;
}
