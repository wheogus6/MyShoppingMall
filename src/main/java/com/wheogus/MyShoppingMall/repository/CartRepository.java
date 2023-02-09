package com.wheogus.MyShoppingMall.repository;

import com.wheogus.MyShoppingMall.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
