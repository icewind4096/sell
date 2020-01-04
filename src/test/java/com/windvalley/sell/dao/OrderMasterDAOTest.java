package com.windvalley.sell.dao;

import com.windvalley.sell.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDAOTest {
    @Autowired
    private OrderMasterDAO orderMasterDAO;

    private final String OPENID = "BuyerOpenId_001";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setId("OrderID_123457");
        orderMaster.setBuyerName("BuyerName");
        orderMaster.setBuyerPhone("123456789");
        orderMaster.setBuyerAddress("BuyerAddress");
        orderMaster.setBuyerOpenID("BuyerOpenId_001");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster result = orderMasterDAO.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenID() {
        Page<OrderMaster> orderMasterPage = orderMasterDAO.findByBuyerOpenID(OPENID, PageRequest.of(0, 2));
        Assert.assertNotEquals(0, orderMasterPage.getTotalElements());
    }
}