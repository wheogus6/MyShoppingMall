package com.wheogus.MyShoppingMall.api;

import com.wheogus.MyShoppingMall.entity.Article;
import com.wheogus.MyShoppingMall.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // RestAPI 용 컨트롤러 데이터(JSON)을 반환.
public class ArticleApiController {

    @Autowired
    private ArticleRepository articleRepository;

    //GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }
    //POST

    //PATCH

    //DELETE
}
