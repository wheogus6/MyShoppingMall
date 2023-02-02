package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.dto.ProductDto;
import com.wheogus.MyShoppingMall.entity.Product;

import com.wheogus.MyShoppingMall.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    // 상품 상세 조회
    @GetMapping("/shop/product/{product_no}")
    public Product show(@PathVariable Long product_no) {
        return productService.show(product_no);
    }

    // 상품 등록
    @PostMapping("/shop/product")
    public ResponseEntity<ProductDto> newProduct(@RequestBody ProductDto dto) {
        log.info("dto = "+ dto);
        ProductDto productDto = productService.newProduct(dto);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    // 상품 삭제
    @DeleteMapping("/shop/product/{product_no}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable Long product_no){
        ProductDto delete = productService.productDelete(product_no);
        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }

    // 상품 수정
    @PatchMapping("/shop/product/{product_no}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long product_no, @RequestBody ProductDto dto) {
        ProductDto updateDto = productService.updateProduct(product_no, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updateDto);
    }

    // 키테고리별 상품 조회
    @GetMapping("/category/list/{category}")
    public List<Product> categoryProduct(@PathVariable Integer category){
        log.info("p_category_num = "  + category);
        return productService.categoryProduct(category);
    }

    // 카테고리명 조회
//    @GetMapping("/category/{category}")
//    public Product category(@PathVariable Integer category) {
//        log.info("p_category_num = "  + category);
//        return productService.category(category);
//    }

}
