package com.wheogus.MyShoppingMall.dto;

import com.wheogus.MyShoppingMall.entity.ProductInfo;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class ProductInfoDto {
    private Long productNo;
    private String p_img;
    private String p_detail;
    private Integer p_stock;
    private Integer p_sell;


    public static ProductInfoDto createInfoDto(ProductInfo productInfo) {
        return new ProductInfoDto(
            productInfo.getProductNo(),
                productInfo.getP_img(),
                productInfo.getP_detail(),
                productInfo.getP_stock(),
                productInfo.getP_sell()
        );
    }
}
