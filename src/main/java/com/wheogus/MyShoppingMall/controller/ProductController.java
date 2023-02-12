package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.dto.ProductDto;
import com.wheogus.MyShoppingMall.dto.ProductInfoDto;
import com.wheogus.MyShoppingMall.entity.Product;

import com.wheogus.MyShoppingMall.entity.ProductInfo;
import com.wheogus.MyShoppingMall.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ProductController {


    @Autowired
    private ProductService productService;



    // 상품 전체 조회
    @GetMapping("/shop/product")
    public List<Product> allProduct() {
        return productService.showAll();
    }
    // 상품 조회
    @GetMapping("/shop/product/{productNo}")
    public Product show(@PathVariable Long productNo) {
        return productService.show(productNo);
    }

    // 상품 등록
    @PostMapping("/shop/product")
    public ResponseEntity<ProductDto> newProduct(@RequestBody ProductDto dto) {
        log.info("dto = "+ dto);
        ProductDto productDto = productService.newProduct(dto);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }


    // 상품 삭제
    @DeleteMapping("/shop/product/{productNo}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable Long productNo){
        ProductDto delete = productService.productDelete(productNo);
        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }

    // 상품 수정
    @PatchMapping("/shop/product/{productNo}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productNo, @RequestBody ProductDto dto) {
        log.info("productNo = " + productNo);
        log.info("dto = "+ dto);
        ProductDto updateDto = productService.updateProduct(productNo, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updateDto);
    }

    // 키테고리별 상품 조회
    @GetMapping("/category/list/{category}")
    public List<Product> categoryProduct(@PathVariable Integer category){
        log.info("p_category_num = "  + category);
        return productService.categoryProduct(category);
    }

    // 상품 상세 조회
    @GetMapping("/shop/productInfo/{productNo}")
    public ProductInfo productInfo(@PathVariable Long productNo) {
        log.info("productNo = "+ productNo);
        return productService.showInfo(productNo);
    }

    // 상품 상세 등록
    @PostMapping("/shop/productInfo")
    public ResponseEntity<ProductInfoDto> newInfo(@RequestBody ProductInfoDto dto) {
        ProductInfoDto productInfoDto = productService.newProductInfo(dto);
        return ResponseEntity.status(HttpStatus.OK).body(productInfoDto);
    }
}
