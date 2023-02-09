package com.wheogus.MyShoppingMall.dto;

import com.wheogus.MyShoppingMall.entity.Cart;
import com.wheogus.MyShoppingMall.entity.ProductInfo;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class CartDto {
    private Long id;
    private Integer product_no;
    private Integer product_cnt;
    private String price;



    public static CartDto createCart(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getProduct_no(),
                cart.getProduct_cnt(),
                cart.getPrice()
        );
    }
}
