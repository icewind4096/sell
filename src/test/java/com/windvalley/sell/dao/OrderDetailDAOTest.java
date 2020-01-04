package com.windvalley.sell.dao;

import com.windvalley.sell.entity.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailDAOTest {
    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Test
    void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId("OrderDetailID_1235");
        orderDetail.setOrderId("OrderID_123456");
        orderDetail.setProductId("123457");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(3.2));
        orderDetail.setProductQuantity(10);
        orderDetail.setProductIcon("http://xxx.jpg");

        OrderDetail result = orderDetailDAO.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    void findByOrderIdTest() {
        List<OrderDetail> orderDetailList = orderDetailDAO.findByOrderId("OrderID_123456");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}