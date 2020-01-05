package com.windvalley.sell.dto;

import com.windvalley.sell.entity.OrderDetail;
import com.windvalley.sell.enums.OrderStatusEnum;
import com.windvalley.sell.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderDTO {
    //订单ID
    private String id;

    //买家名称
    private String buyerName;

    //买家电话
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家微信OpenID
    private String buyerOpenID;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态, 默认0-新订单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态, 默认0-未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //订单建立日期
    private Timestamp crTime;

    //订单修改日期
    private Timestamp updateTime;

    //订单详细
    private List<OrderDetail> orderDetailList;
}
