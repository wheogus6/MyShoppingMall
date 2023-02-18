package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.entity.Cart;
import com.wheogus.MyShoppingMall.entity.Product;
import com.wheogus.MyShoppingMall.repository.CartRepository;
import com.wheogus.MyShoppingMall.repository.ProductRepository;
import com.wheogus.MyShoppingMall.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Slf4j
@RestController
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ProductRepository productRepository;

    // 카트 조회
    @GetMapping("/shop/cart/")
    public ResponseEntity getCart(@CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int userId = jwtService.getId(token);
        log.info("userId = " + userId);
        List<Cart> carts = cartRepository.findByUserId(userId);

        // **카트의 제품번호만 추출**
        List<Long> productNos = carts.stream().map(Cart::getProductNo).toList();
        List<Product> products = productRepository.findByProductNoIn(productNos);

        return new ResponseEntity<>(products, HttpStatus.OK);

    }





//     카트 담기
    @PostMapping("/shop/cart/{productNo}")
    public ResponseEntity pushCart(@PathVariable Long productNo, @CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int userId = jwtService.getId(token);
        log.info("userId = " + userId);
       Cart cart = cartRepository.findByUserIdAndProductNo(userId, productNo);
//        log.info("cart = " + cart);

        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setUserId(userId);
            newCart.setProductNo(productNo);
            cartRepository.save(newCart);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 카트 품목 삭제
    @DeleteMapping("/shop/cart/{productNo}")
    public ResponseEntity removeCart(@PathVariable("productNo") Long productNo, @CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int userId = jwtService.getId(token);
        Cart cart = cartRepository.findByUserIdAndProductNo(userId, productNo);

        cartRepository.delete(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
