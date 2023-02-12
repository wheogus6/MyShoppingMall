package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.entity.Cart;
import com.wheogus.MyShoppingMall.entity.Product;
import com.wheogus.MyShoppingMall.entity.User;
import com.wheogus.MyShoppingMall.repository.CartRepository;
import com.wheogus.MyShoppingMall.repository.ProductRepository;
import com.wheogus.MyShoppingMall.service.JwtService;
import com.wheogus.MyShoppingMall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
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
        int memberId = jwtService.getId(token);
        List<Cart> carts = cartRepository.findByUserId(memberId);
        // **카트의 제품번호만 추출**
        List<Integer> productNos = carts.stream().map(Cart::getProduct_no).toList();
        List<Product> products = productRepository.findByIdIn(productNos);

        return new ResponseEntity<>(products, HttpStatus.OK);

    }


//     카트 담기
    @PostMapping("/cart/product/{product_no}")
    public ResponseEntity pushCart(@PathVariable("product_no") Integer product_no, @CookieValue(value = "token", required = false)String token) {
        if (jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int memberId = jwtService.getId(token);
       Cart cart = cartRepository.findByUserIdAndProductNo(memberId, product_no);

        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setUser_id(memberId);
            newCart.setProduct_no(product_no);
            cartRepository.save(newCart);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
