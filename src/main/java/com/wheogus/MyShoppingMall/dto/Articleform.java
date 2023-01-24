package com.wheogus.MyShoppingMall.dto;

import com.wheogus.MyShoppingMall.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Articleform {

    private String title;
    private String content;
    public Article toEntity() {
        return new Article(null, title, content);
    }
}
