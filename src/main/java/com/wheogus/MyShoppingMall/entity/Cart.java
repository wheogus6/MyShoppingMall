package com.wheogus.MyShoppingMall.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class Cart {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer cart_id;

        @Column
        private String user_id;

        @Column
        private Integer product_no;

//        @Column
//        private String price;
//        @Column
//        private Integer product_no;

//    public static Cart createCart(User user) {
//        Cart cart = new Cart();
//        cart.setProduct_cnt(0);
//        cart.setUser(user);
//        return cart;
//    }



//    public static Cart createCart(CartDto dto) {
//        return new Cart(
//                dto.getCart_id(),
//                dto.getId(),
//                dto.getProduct_no(),
//                dto.getProduct_cnt(),
//                dto.getPrice()
//        );
//    }

}
