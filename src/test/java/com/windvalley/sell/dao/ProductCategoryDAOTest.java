package com.windvalley.sell.dao;

import com.windvalley.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDAOTest {
    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Test
    public void findOneTest(){
        Optional<ProductCategory> optionalProductCategory = productCategoryDAO.findById(1);
        if (optionalProductCategory.isPresent() == true){
            System.out.println(optionalProductCategory.get().toString());
        }
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱榜", 3);
        ProductCategory result = productCategoryDAO.save(productCategory);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void updateTest(){
        Optional<ProductCategory> optionalProductCategory = productCategoryDAO.findById(1);
        if (optionalProductCategory.isPresent() == true) {
            ProductCategory productCategory = optionalProductCategory.get();
            productCategory.setType(3);
            productCategoryDAO.save(productCategory);
        }
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<ProductCategory> result = productCategoryDAO.findByTypeIn(list);
        Assert.assertNotNull(result);
    }
}