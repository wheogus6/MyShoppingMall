package com.wheogus.MyShoppingMall.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String email;
    @Column
    private String pwd;
}
