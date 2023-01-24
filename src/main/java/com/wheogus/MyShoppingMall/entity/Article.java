package com.wheogus.MyShoppingMall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity //DB가 해당 객체를 인식 가능!
@AllArgsConstructor
@NoArgsConstructor  // 디폴트 생성자 어노테이션
@ToString
public class Article {

    @Id // 대표값울 지정! like a 주민번호
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String content;


}
