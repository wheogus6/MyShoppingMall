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
    private String price;

    public static ProductDto createProductDto(Product product) {
        return new ProductDto(
                product.getProduct_no(),
                product.getP_category_num(),
                product.getP_name(),
                product.getPrice()

        );
    }


//    public Product toEntity() {
//        return new Product(product_no, p_category_num, p_name);
//    }
}
