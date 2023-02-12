package com.wheogus.MyShoppingMall.entity;

import io.swagger.models.auth.In;
import lombok.*;

import javax.persistence.*;


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

        @JoinColumn(name = "userId")
        private Integer userId;

        @Column
        private Long productNo;

}
