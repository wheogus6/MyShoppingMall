package com.wheogus.MyShoppingMall.api;

import com.wheogus.MyShoppingMall.dto.Articleform;
import com.wheogus.MyShoppingMall.entity.Article;
import com.wheogus.MyShoppingMall.repository.ArticleRepository;
import com.wheogus.MyShoppingMall.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j    //log 사용 가능 어노테이션
@RestController  // RestAPI 용 컨트롤러 데이터(JSON)을 반환.
public class ArticleApiController {
    @Autowired
    private ArticleService articleSrvice;

    //GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleSrvice.index();
    }
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleSrvice.show(id);
    }

    //POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody Articleform dto) {
        Article create = articleSrvice.create(dto);
        return (create != null) ?
                ResponseEntity.status(HttpStatus.OK).body(create) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Articleform dto) {

        Article update = articleSrvice.update(id, dto);
        return (update != null) ?
                ResponseEntity.status(HttpStatus.OK).body(update) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //DELETE

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        Article deleted = articleSrvice.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
                ;
    }

    //트랜젝션 -> 실패 ->롤백
    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<Articleform> dtos) {
        List<Article> createList = articleSrvice.createArticles(dtos);
        return (createList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
