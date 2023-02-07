package com.wheogus.MyShoppingMall.repository;

import com.wheogus.MyShoppingMall.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
}
