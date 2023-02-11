package com.wheogus.MyShoppingMall.repository;

import com.wheogus.MyShoppingMall.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

//    List<Cart> findByUserId(String userId);

//    Cart findByUserIdAndProductNo(String userId, Integer productNo);
}
