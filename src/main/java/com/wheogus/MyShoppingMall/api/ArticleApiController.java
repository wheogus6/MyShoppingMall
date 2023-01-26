package com.wheogus.MyShoppingMall.api;

import com.wheogus.MyShoppingMall.dto.Articleform;
import com.wheogus.MyShoppingMall.entity.Article;
import com.wheogus.MyShoppingMall.repository.ArticleRepository;
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
    private ArticleRepository articleRepository;

    //GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }
    @GetMapping("/api/articles/{id}")
    public Article index(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping("/api/articles")
    public Article create(@RequestBody Articleform dto) {
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }

    //PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Articleform dto) {

        //1. 수정용 엔티티 생성
        Article article = dto.toEntity();
        log.info("id : {}, article: {}", id, article.toString());

        //2. 대상 엔티티를 조회
        Article target = articleRepository.findById(id).orElse(null);
        //3. 잘못된 요청 처리(대상이 없거나, id가 다를 경우)
        if (target == null || id != article.getId()) {
            log.info("잘못된 요청! id{}, article: {}", id, article.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
            //4. 업데이트 및 정상 응답(200)
             target.patch(article);
            Article update = articleRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(update);  //상태코드
    }

    //DELETE

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        // 1. 대상조회
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리
        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 3. 대상 삭제
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
