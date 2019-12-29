package com.windvalley.sell.service.impl;

import com.windvalley.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getId());
    }

    @Test
    void findAll() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    void findByTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findByTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertEquals(1, productCategoryList.size());
    }

    @Test
    void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("女生最爱榜", 11);
        Assert.assertNotNull(productCategory);
    }
}