package com.windvalley.sell.service.impl;

import com.windvalley.sell.entity.ProductInfo;
import com.windvalley.sell.enums.ProductStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class ProductServiceImplTest {
    @Autowired
    ProductServiceImpl productService;

    @Test
    void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertEquals("123456", productInfo.getId());
    }

    @Test
    void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId("123457");
        productInfo.setName("皮皮虾");
        productInfo.setPrice(new BigDecimal(3.2));
        productInfo.setStock(100);
        productInfo.setDescription("很好喝的虾");
        productInfo.setIcon("http://xxx.jpg");
        productInfo.setStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        Assert.assertNotNull(productService.save(productInfo));
    }
}