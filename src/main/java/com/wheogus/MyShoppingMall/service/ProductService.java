package com.wheogus.MyShoppingMall.service;

import com.wheogus.MyShoppingMall.dto.ProductDto;
import com.wheogus.MyShoppingMall.entity.Product;
import com.wheogus.MyShoppingMall.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    // 상품 전체 조회
    public List<Product> showAll() {
        return productRepository.findAll();
    }
    // 상품 상세 조회
    public Product show(Long product_no) {
        return productRepository.findById(product_no).orElse(null);
    }

    // 상품 등록
    @Transactional
    public ProductDto newProduct(ProductDto dto) {
        Product product = Product.createProduct(dto);

        Product newProduct =  productRepository.save(product);
        log.info("newProduct = " + newProduct);
        return ProductDto.createProductDto(newProduct);
    }

    // 상품 삭제
    public ProductDto productDelete(Long product_no) {
        Product target = productRepository.findById(product_no).orElseThrow(() -> new IllegalArgumentException("해당 제품아 없습니다."));

        productRepository.delete(target);
        return ProductDto.createProductDto(target);
    }

    // 상품 수정
    public ProductDto updateProduct(Long product_no, ProductDto dto) {
        Product target = productRepository.findById(product_no).orElseThrow(() -> new IllegalArgumentException("상품 수정 불가! 해당 상품은 없습니다."));
        target.patch(dto);
        Product updated = productRepository.save(target);
        return ProductDto.createProductDto(updated);
    }

    public List<Product> categoryProduct(Integer category) {
        log.info("p_category_num = " + category);
        return productRepository.findByCategory(category);
    }

    // 카테고리 별 상품리스트 조회

}
