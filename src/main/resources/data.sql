insert into article(id, title, content) values (1, '가가가', '1111');
insert into article(id, title, content) values (2, '나나나', '2222');
insert into article(id, title, content) values (3, '다다다', '3333');

-- article 더미 데이터
insert into article(id, title, content) values (4, '당신의 인생 영화는?', '댓글ㄱ');
insert into article(id, title, content) values (5, '당신의 소울푸드는?', '댓글ㄱㄱ');
insert into article(id, title, content) values (6, '당신의 취미는?', '댯글ㄱㄱㄱ');

--comment 더미 데이타
insert into comment(id, article_id, nickname, body) values (1, 4, 'wheogus', '스파이더맨');
insert into comment(id, article_id, nickname, body) values (2, 4, 'wheogus2', '햄버거');
insert into comment(id, article_id, nickname, body) values (3, 4, 'wheogus3', '영화');

insert into comment(id, article_id, nickname, body) values (4, 5, 'wheogus4', '스파이더맨2');
insert into comment(id, article_id, nickname, body) values (5, 5, 'wheogus5', '피자');
insert into comment(id, article_id, nickname, body) values (6, 5, 'wheogus6', '영화');

insert into comment(id, article_id, nickname, body) values (7, 5, 'wheogus7', '스파이더맨3');
insert into comment(id, article_id, nickname, body) values (8, 5, 'wheogus8', '햄버거');
insert into comment(id, article_id, nickname, body) values (9, 5, 'wheogus9', '플스');
