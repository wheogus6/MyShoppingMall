package com.wheogus.MyShoppingMall.dto;

import com.wheogus.MyShoppingMall.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class Articleform {

    private Long id;
    private String title;
    private String content;
    public Article toEntity() {
        return new Article(id, title, content);
    }
}
