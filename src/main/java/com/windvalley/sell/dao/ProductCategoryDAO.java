package com.windvalley.sell.dao;

import com.windvalley.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryDAO extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByTypeIn(List<Integer> categoryTypeList);
}
