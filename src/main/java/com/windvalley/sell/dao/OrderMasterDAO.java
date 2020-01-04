package com.windvalley.sell.dao;

import com.windvalley.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterDAO extends JpaRepository<OrderMaster, String> {
    Page<OrderMaster> findByBuyerOpenID(String buyerOpenId, Pageable pageable);
}
