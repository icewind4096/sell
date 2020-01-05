package com.windvalley.sell.service;

import com.windvalley.sell.dto.OrderDTO;
import com.windvalley.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    //订单创建
    OrderDTO create(OrderDTO orderDTO);

    //订单查询单个
    OrderDTO findOne(String orderId);

    //订单查询列表
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    //订单取消
    OrderDTO cancel(OrderDTO orderDTO);

    //订单完结
    OrderDTO finish(OrderDTO orderDTO);

    //订单支付
    OrderDTO paid(OrderDTO orderDTO);
}
