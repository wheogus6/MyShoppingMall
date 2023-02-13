package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.dto.OrderDto;
import com.wheogus.MyShoppingMall.entity.Order;
import com.wheogus.MyShoppingMall.repository.OrderRepository;
import com.wheogus.MyShoppingMall.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //주문 내역 조회
    @GetMapping("/shop/order")
    public ResponseEntity getOrder(@CookieValue(value = "token", required = false)String token){
        if (jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        List<Order> orders = orderRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    //주문 하기
    @PostMapping("/shop/order")
    public ResponseEntity pushOrder(@RequestBody OrderDto dto, @CookieValue(value = "token", required = false)String token) {
        if (jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Order newOrder = new Order();
        newOrder.setUserId(jwtService.getId(token));
        newOrder.setName(dto.getName());
        newOrder.setAddress(dto.getAddress());
        newOrder.setPayment(dto.getPayment());
        newOrder.setProducts(dto.getProducts());

        orderRepository.save(newOrder);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 2:59:24

}
