package com.wheogus.MyShoppingMall.entity;

import com.wheogus.MyShoppingMall.dto.ProductDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private Long product_no;

    @Column
    @JoinColumn(name = "category")
    private Integer p_category_num;

    @Column
    private String p_name;

    @Column
    private String price;


    public static Product createProduct(ProductDto dto) {
        // 엔티티 생성 및 반환
        return new Product(
            dto.getProduct_no(),
                dto.getP_category_num(),
                dto.getP_name(),
                dto.getPrice()
        );
    }

    public void patch(ProductDto dto) {
        if(this.product_no != dto.getProduct_no())
            throw new IllegalArgumentException("수정 실패! 다른 제품입니다.");

        if(dto.getProduct_no() != null)
            this.product_no = dto.getProduct_no();
        if(dto.getP_category_num() != null)
            this.p_category_num = dto.getP_category_num();
        if (dto.getP_name() != null)
            this.p_name = dto.getP_name();
        if (dto.getPrice() != null)
            this.price = dto.getPrice();
    }
}
