package com.wheogus.MyShoppingMall.repository;

import com.wheogus.MyShoppingMall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value =
            "select * from product where p_category_num = :p_category_num", nativeQuery = true)
    List<Product> findByCategory(Integer p_category_num);
}
