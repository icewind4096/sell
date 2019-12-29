package com.windvalley.sell.service;

import com.windvalley.sell.entity.ProductCategory;

import java.util.List;

public interface ICategoryService {
    ProductCategory findOne(Integer id);
    List<ProductCategory> findAll();
    List<ProductCategory> findByTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
