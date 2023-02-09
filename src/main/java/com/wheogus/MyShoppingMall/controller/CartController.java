package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.dto.CartDto;
import com.wheogus.MyShoppingMall.entity.Cart;
import com.wheogus.MyShoppingMall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    // 카트 조회
    @GetMapping("/cart/{id}")
    public Optional<Cart> showCart(@PathVariable Long id) {
        return cartService.showCart(id);
    }

    // 카트 담기
    @PostMapping("/cart")
    public ResponseEntity<CartDto> insertCart(@RequestBody CartDto dto) {
        CartDto cartDto = cartService.insert(dto);
        return ResponseEntity.status(HttpStatus.OK).body(cartDto);

    }
}
