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
    private String product_num;
    private Integer product_cnt;
    private String price;



    public static CartDto createCart(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getProduct_num(),
                cart.getProduct_cnt(),
                cart.getPrice()
        );
    }
}
