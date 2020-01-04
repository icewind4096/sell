package com.windvalley.sell.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISH(1, "订单完成"),
    CANCEL(2, "订单取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
