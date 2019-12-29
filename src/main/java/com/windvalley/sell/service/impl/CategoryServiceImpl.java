package com.windvalley.sell.service.impl;

import com.windvalley.sell.dao.ProductCategoryDAO;
import com.windvalley.sell.entity.ProductCategory;
import com.windvalley.sell.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ProductCategoryDAO productCategoryDAO;

    @Override
    public ProductCategory findOne(Integer id) {
        Optional<ProductCategory> optionalProductCategory = productCategoryDAO.findById(1);
        if (optionalProductCategory.isPresent() == true){
            return optionalProductCategory.get();
        }
        return null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDAO.findAll();
    }

    @Override
    public List<ProductCategory> findByTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDAO.findByTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDAO.save(productCategory);
    }
}
