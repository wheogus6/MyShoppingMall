package com.wheogus.MyShoppingMall.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer order_id;

        @JoinColumn(name = "userId")
        private Integer userId;

        @Column
        private String name;

        @Column
        private String address;

        @Column
        private String payment;

        @Column
        private String products;


}
