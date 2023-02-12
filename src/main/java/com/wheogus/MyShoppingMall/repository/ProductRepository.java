package com.wheogus.MyShoppingMall.repository;

import com.wheogus.MyShoppingMall.dto.ProductInfoDto;
import com.wheogus.MyShoppingMall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value =
            "select * from product where p_category_num = :category", nativeQuery = true)
    List<Product> findByCategory(@Param("category") Integer category);

    List<Product> findByIdIn(List<Integer> ids);

}
