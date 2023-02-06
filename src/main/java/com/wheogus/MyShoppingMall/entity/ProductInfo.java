package com.wheogus.MyShoppingMall.entity;

import com.wheogus.MyShoppingMall.dto.ProductInfoDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {

        @Id
        private Long product_no;
        @Column
        private String p_img;
        @Column
        private String p_detail;
        @Column
        private Integer p_stock;
        @Column
        private Integer p_sell;


    public static ProductInfo createInfo(ProductInfoDto dto) {
        return new ProductInfo(
                dto.getProduct_no(),
                dto.getP_img(),
                dto.getP_detail(),
                dto.getP_stock(),
                dto.getP_sell()
        );
    }

}
