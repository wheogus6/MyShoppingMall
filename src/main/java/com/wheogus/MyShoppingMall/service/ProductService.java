package com.wheogus.MyShoppingMall.service;

import com.wheogus.MyShoppingMall.dto.ProductDto;
import com.wheogus.MyShoppingMall.entity.Product;
import com.wheogus.MyShoppingMall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 상품 조회

    // 상품 등록
    @Transactional
    public Product newProduct(ProductDto dto) {
        Product product = dto.toEntity();
        if(product.getProduct_no() != null)
            return null;
        return productRepository.save(product);
    }
    // 상품 수정

    // 상품 삭제
}
