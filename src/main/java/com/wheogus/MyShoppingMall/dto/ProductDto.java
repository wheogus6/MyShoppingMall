package com.wheogus.MyShoppingMall.dto;

import com.wheogus.MyShoppingMall.entity.Product;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class ProductDto {
    private Long productNo;
    private Integer p_category_num;
    private String p_name;
    private String price;

    public static ProductDto createProductDto(Product product) {
        return new ProductDto(
                product.getProductNo(),
                product.getP_category_num(),
                product.getP_name(),
                product.getPrice()

        );
    }



}
