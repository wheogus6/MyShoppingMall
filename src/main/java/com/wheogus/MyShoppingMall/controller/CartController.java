package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.entity.Cart;
import com.wheogus.MyShoppingMall.entity.Product;
import com.wheogus.MyShoppingMall.entity.User;
import com.wheogus.MyShoppingMall.repository.CartRepository;
import com.wheogus.MyShoppingMall.repository.ProductRepository;
import com.wheogus.MyShoppingMall.service.JwtService;
import com.wheogus.MyShoppingMall.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ProductRepository productRepository;

    // 카트 조회
//    @GetMapping("/cart/{id}")
//    public Optional<Cart> showCart(@PathVariable String id) {
//        return cartService.showCart(id);
//    }

    @GetMapping("/cart/product/")
    public ResponseEntity getCart(@CookieValue(value = "token", required = false) String token) {
        if (jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int userId = jwtService.getId(token);
        List<Cart> carts = cartRepository.findByUserId(userId);

        // **카트의 제품번호만 추출**
        List<Long> ids = carts.stream().map(Cart::getProductNo).toList();
        List<Product> products = productRepository.findByProductNoIn(ids);

        return new ResponseEntity<>(products, HttpStatus.OK);

    }


//     카트 담기
    @PostMapping("/cart/product/{productNo}")
    public ResponseEntity pushCart(@PathVariable("productNo") Long productNo, @CookieValue(value = "token", required = false)String token) {
        if (jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int userId = jwtService.getId(token);
       Cart cart = cartRepository.findByUserIdAndProductNo(userId, productNo);
        log.info("userId = " + userId);

        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setUserId(userId);
            newCart.setProductNo(productNo);
            cartRepository.save(newCart);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cart/product/{productNo}")
    public ResponseEntity removeCart(@PathVariable("productNo") Long productNo, @CookieValue(value = "token", required = false) String token) {
        if (jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int userId = jwtService.getId(token);
        Cart cart = cartRepository.findByUserIdAndProductNo(userId, productNo);

        cartRepository.delete(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
