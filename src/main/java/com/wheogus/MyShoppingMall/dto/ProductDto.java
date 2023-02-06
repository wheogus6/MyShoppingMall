package com.wheogus.MyShoppingMall.dto;

import com.wheogus.MyShoppingMall.entity.Product;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class ProductDto {
    private Long product_no;
    private Integer p_category_num;
    private String p_name;

    public static ProductDto createProductDto(Product Product) {
        return new ProductDto(
                Product.getProduct_no(),
                Product.getP_category_num(),
                Product.getP_name()
        );
    }


//    public Product toEntity() {
//        return new Product(product_no, p_category_num, p_name);
//    }
}
