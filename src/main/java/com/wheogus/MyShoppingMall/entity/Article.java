package com.wheogus.MyShoppingMall.entity;

import jakarta.persistence.*;
import lombok.*;

//엔티티
@Entity //DB가 해당 객체를 인식 가능! (해당 클래스로 테이블을 만든다)
@AllArgsConstructor
@NoArgsConstructor  // 디폴트 생성자 어노테이션
@ToString
@Getter
public class Article {

    @Id // 대표값울 지정! like a 주민번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 id를 자동 생성
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null) {
            this.title = article.title;  // 바디로 넘어온 article의 title이 존재하면 this.title에 article.title 값을 넣는다.
        }
        if (article.content != null) {
            this.content = article.content;
        }
    }
}
