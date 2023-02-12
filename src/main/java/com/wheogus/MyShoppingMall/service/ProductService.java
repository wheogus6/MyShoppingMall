package com.wheogus.MyShoppingMall.service;

import com.wheogus.MyShoppingMall.dto.ProductDto;
import com.wheogus.MyShoppingMall.dto.ProductInfoDto;
import com.wheogus.MyShoppingMall.entity.Product;
import com.wheogus.MyShoppingMall.entity.ProductInfo;
import com.wheogus.MyShoppingMall.repository.ProductInfoRepository;
import com.wheogus.MyShoppingMall.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductInfoRepository productInfoRepository;


    // 상품 전체 조회
    public List<Product> showAll() {
        return productRepository.findAll();
    }

    // 상품 조회
    public Product show(Long productNo) {
        return productRepository.findById(productNo).orElse(null);
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
    public ProductDto productDelete(Long productNo) {
        productInfoRepository.deleteById(productNo);
        Product target = productRepository.findById(productNo).orElseThrow(() -> new IllegalArgumentException("해당 제품아 없습니다."));

        productRepository.delete(target);

        return ProductDto.createProductDto(target);
    }

    // 상품 수정
    public ProductDto updateProduct(Long productNo, ProductDto dto) {
        Product target = productRepository.findById(productNo).orElseThrow(() -> new IllegalArgumentException("상품 수정 불가! 해당 상품은 없습니다."));
        target.patch(dto);
        Product updated = productRepository.save(target);
        return ProductDto.createProductDto(updated);
    }

    // 카테고리 별 상품리스트 조회
    public List<Product> categoryProduct(Integer category) {
        return productRepository.findByCategory(category);
    }

    //상품 상세 조회
    public ProductInfo showInfo(Long productNo) {
        return productInfoRepository.findById(productNo).orElse(null);
    }


    @Transactional
    public ProductInfoDto newProductInfo(ProductInfoDto dto) {
        ProductInfo Info = ProductInfo.createInfo(dto);
        ProductInfo newInfo =  productInfoRepository.save(Info);
        return ProductInfoDto.createInfoDto(newInfo);
    }
}
