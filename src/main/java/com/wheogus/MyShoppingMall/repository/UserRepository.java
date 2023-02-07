package com.wheogus.MyShoppingMall.repository;

import com.wheogus.MyShoppingMall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String username);
}
