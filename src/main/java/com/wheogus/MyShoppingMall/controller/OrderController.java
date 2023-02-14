package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.dto.OrderDto;
import com.wheogus.MyShoppingMall.entity.Order;
import com.wheogus.MyShoppingMall.repository.CartRepository;
import com.wheogus.MyShoppingMall.repository.OrderRepository;
import com.wheogus.MyShoppingMall.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    //주문 내역 조회
    @GetMapping("/shop/order")
    public ResponseEntity getOrder(@CookieValue(value = "token", required = false)String token){
        if (jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Integer userId = jwtService.getId(token);
        List<Order> orders = orderRepository.findByUserIdOrderByOrderIdDesc(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    //주문 하기
    @Transactional
    @PostMapping("/shop/order")
    public ResponseEntity pushOrder(@RequestBody OrderDto dto, @CookieValue(value = "token", required = false)String token) {
        if (jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Integer userId = jwtService.getId(token);
        Order newOrder = new Order();
        newOrder.setUserId(userId);
        newOrder.setName(dto.getName());
        newOrder.setAddress(dto.getAddress());
        newOrder.setPayment(dto.getPayment());
        newOrder.setProducts(dto.getProducts());

        orderRepository.save(newOrder);
        cartRepository.deleteByUserId(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 2:59:24

}
