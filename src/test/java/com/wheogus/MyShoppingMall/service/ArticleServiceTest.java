package com.wheogus.MyShoppingMall.service;

import com.wheogus.MyShoppingMall.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // 예상
        Article a = new Article(1L, "가가가", "1111");
        Article b = new Article(2L, "나나나", "2222");
        Article c = new Article(3L, "다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));

        // 실제
        List<Article> articles = articleService.index();

        // 비교
        assertEquals(expected.toString(), articles.toString());

    }
}