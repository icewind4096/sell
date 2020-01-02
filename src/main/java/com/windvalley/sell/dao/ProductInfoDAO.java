package com.windvalley.sell.dao;

import com.windvalley.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDAO extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByStatus(Integer status);
}
