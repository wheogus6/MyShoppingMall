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

    public static ProductDto createProductDto(Product newProduct) {
        return new ProductDto(
                newProduct.getProduct_no(),
                newProduct.getP_category_num(),
                newProduct.getP_name()
        );
    }


//    public Product toEntity() {
//        return new Product(product_no, p_category_num, p_name);
//    }
}
