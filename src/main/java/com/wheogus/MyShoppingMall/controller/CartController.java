package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.entity.Cart;
import com.wheogus.MyShoppingMall.entity.Product;
import com.wheogus.MyShoppingMall.entity.User;
import com.wheogus.MyShoppingMall.repository.CartRepository;
import com.wheogus.MyShoppingMall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    private CartRepository cartRepository;


    // 카트 조회
//    @GetMapping("/cart/{id}")
//    public Optional<Cart> showCart(@PathVariable String id) {
//        return cartService.showCart(id);
//    }

    // 카트 담기
//    @PostMapping("/cart/products/{product_no}")
//    public List<Product> pushCart(@PathVariable("product_no") Long product_no) {
//        int userID =
//    }

}
