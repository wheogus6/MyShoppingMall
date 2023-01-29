package com.wheogus.MyShoppingMall.dto;

import com.wheogus.MyShoppingMall.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ProductDto {
    private Long product_no;
    private String p_name;
    private String p_category_num;

    public Product toEntity() {
        return new Product(product_no, p_name, p_category_num);
    }
}
