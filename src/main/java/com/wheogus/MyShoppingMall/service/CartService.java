package com.wheogus.MyShoppingMall.service;


import com.wheogus.MyShoppingMall.dto.CartDto;
import com.wheogus.MyShoppingMall.entity.Cart;
import com.wheogus.MyShoppingMall.entity.Product;
import com.wheogus.MyShoppingMall.repository.CartRepository;
import com.wheogus.MyShoppingMall.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;


    public Optional<Cart> showCart(Long id) {
        return cartRepository.findById(id);
    }


    public CartDto insert(CartDto dto) {
//        Integer product_no = Integer.valueOf(dto.getProduct_num());
//        Optional<Product> product = productRepository.findById(Long.valueOf(product_no));
//        log.info("product = "+ product);
        Cart cart = Cart.createCart(dto);
        Cart insertProduct = cartRepository.save(cart);
        return CartDto.createCart(insertProduct);
    }
}
