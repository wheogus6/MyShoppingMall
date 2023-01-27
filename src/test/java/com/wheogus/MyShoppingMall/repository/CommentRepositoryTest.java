package com.wheogus.MyShoppingMall.repository;

import com.wheogus.MyShoppingMall.entity.Article;
import com.wheogus.MyShoppingMall.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // JPA와 연동한 테스트!
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;


    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1 : 4번 게시글의 모든 댓글 조회 */
        {// 입력 데이터 준비
            Long articleId = 4L;
            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 예상하기
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글ㄱ");
            Comment a = new Comment(1L, article, "wheogus", "스파이더맨");
            Comment b = new Comment(2L, article, "wheogus2", "햄버거");
            Comment c = new Comment(3L, article, "wheogus3", "영화");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력!");
        }
    }

    @Test
    void findByNickname() {
    }
}