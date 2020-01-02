package com.windvalley.sell.dao;

import com.windvalley.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDAOTest {
    @Autowired
    private ProductInfoDAO productInfoDAO;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId("123456");
        productInfo.setName("皮蛋瘦肉粥");
        productInfo.setPrice(new BigDecimal(3.2));
        productInfo.setStock(100);
        productInfo.setDescription("很好喝的粥");
        productInfo.setIcon("http://xxx.jpg");
        productInfo.setStatus(0);
        productInfo.setCategoryType(2);
        Assert.assertNotEquals(null, productInfoDAO.save(productInfo));
    }

    @Test
    public void findByStatusTest() {
        List<ProductInfo> productInfoList = productInfoDAO.findByStatus(0);
        Assert.assertNotNull(productInfoList);
    }
}