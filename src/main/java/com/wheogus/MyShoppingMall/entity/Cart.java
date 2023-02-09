package com.wheogus.MyShoppingMall.entity;

import com.wheogus.MyShoppingMall.dto.CartDto;
import com.wheogus.MyShoppingMall.dto.ProductInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

        @Id
        private Long id;
        @Column
        private String product_num;
        @Column
        private Integer product_cnt;
        @Column
        private String price;




    public static Cart createCart(CartDto dto) {
        return new Cart(
                dto.getId(),
                dto.getProduct_num(),
                dto.getProduct_cnt(),
                dto.getPrice()
        );
    }

}
