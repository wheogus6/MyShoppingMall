package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.dto.ProductDto;
import com.wheogus.MyShoppingMall.entity.Product;
import com.wheogus.MyShoppingMall.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // 상품 등록
    @PostMapping("/shop/product")
    private ResponseEntity<Product> newProduct(@RequestBody ProductDto dto) {
        Product product = productService.newProduct(dto);

        return (product != null) ?
                ResponseEntity.status(HttpStatus.OK).body(product) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
