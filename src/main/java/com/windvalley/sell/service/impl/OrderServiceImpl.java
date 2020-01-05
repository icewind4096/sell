package com.windvalley.sell.service.impl;

import com.windvalley.sell.dao.OrderDetailDAO;
import com.windvalley.sell.dao.OrderMasterDAO;
import com.windvalley.sell.dto.CartDTO;
import com.windvalley.sell.dto.OrderDTO;
import com.windvalley.sell.entity.OrderDetail;
import com.windvalley.sell.entity.OrderMaster;
import com.windvalley.sell.entity.ProductInfo;
import com.windvalley.sell.enums.ResultEnum;
import com.windvalley.sell.exception.SellException;
import com.windvalley.sell.service.IOrderService;
import com.windvalley.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    OrderMasterDAO orderMasterDAO;

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        //0. 首先产生OrderID
        String orderId = KeyUtil.genUniqueKey();

        //1. 查询商品->数量，价格
        BigDecimal orderAmount = new BigDecimal(0);
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2. 计算总价
            orderAmount = orderAmount.add(productInfo.getPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())));

            //3. 写入订单数据库->detail
            orderDetail.setOrderId(orderId);
            orderDetail.setId(KeyUtil.genUniqueKey());
            orderDetail.setProductId(productInfo.getId());
            orderDetail.setProductName(productInfo.getName());
            orderDetail.setProductPrice(productInfo.getPrice());
            orderDetail.setProductIcon(productInfo.getIcon());
            orderDetailDAO.save(orderDetail);
        }

        //4. 写入订单数据库->master
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterDAO.save(orderMaster);

        //5. 扣库存
        List<CartDTO> cartDTOList = new ArrayList<CartDTO>();
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()){
            cartDTOList.add(new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity()));
        }
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
