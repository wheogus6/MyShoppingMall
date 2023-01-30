package com.wheogus.MyShoppingMall.entity;

import com.wheogus.MyShoppingMall.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.PathVariable;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private Long product_no;

    @Column
    private Integer p_category_num;

    @Column
    private String p_name;


    public static Product createProduct(ProductDto dto) {
        // 엔티티 생성 및 반환
        return new Product(
            dto.getProduct_no(),
                dto.getP_category_num(),
                dto.getP_name()
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
    }
}
