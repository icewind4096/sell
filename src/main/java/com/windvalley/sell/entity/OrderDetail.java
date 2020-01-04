package com.windvalley.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@DynamicUpdate
public class OrderDetail {
        //订单ID
        @Id
        private String id;

        //订单ID
        private String orderId;

        //产品编号
        private String productId;

        //产品名称
        private String productName;

        //产品单价
        private BigDecimal productPrice;

        //产品数量
        private Integer productQuantity;

        //产品小图地址
        private String productIcon;

        //订单建立日期
        private Timestamp crTime;

        //订单修改日期
        private Timestamp updateTime;
}
