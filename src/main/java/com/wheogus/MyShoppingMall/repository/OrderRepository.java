package com.wheogus.MyShoppingMall.repository;

import com.wheogus.MyShoppingMall.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
