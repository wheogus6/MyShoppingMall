package com.wheogus.MyShoppingMall.service;

import com.wheogus.MyShoppingMall.dto.Articleform;
import com.wheogus.MyShoppingMall.entity.Article;
import com.wheogus.MyShoppingMall.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(Articleform dto) {
        Article article = dto.toEntity();
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, Articleform dto) {
        //1. 수정용 엔티티 생성
        Article article = dto.toEntity();
        log.info("id : {}, article: {}", id, article.toString());

        //2. 대상 엔티티를 조회
        Article target = articleRepository.findById(id).orElse(null);
        //3. 잘못된 요청 처리(대상이 없거나, id가 다를 경우)
        if (target == null || id != article.getId()) {
            log.info("잘못된 요청! id{}, article: {}", id, article.toString());
            return null;
        }
        //4. 업데이트
        target.patch(article);
        Article update = articleRepository.save(target);
        return update;
    }

    public Article delete(Long id) {
        // 1. 대상조회
        Article target = articleRepository.findById(id).orElse(null);
        if(target == null){
            return null; }
        // 3. 대상 삭제
        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<Articleform> dtos) {
        // dtos 묶음을 entity묶으므로 변환
         List<Article> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());
        // entity 묶음을 DB에 저장
        articleList.stream()
                .forEach(article -> articleRepository.save(article));
        // 강제 예외 발생
        articleRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("결재 실패!")
        );
        // 결과값 반환
        return articleList;
    }
}
