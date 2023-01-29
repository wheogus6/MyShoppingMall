package com.wheogus.MyShoppingMall.repository;

import com.wheogus.MyShoppingMall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
