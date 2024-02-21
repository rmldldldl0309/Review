use board;

#1
INSERT `user` (email, password, nickname, tel_number, address, address_detail, agreed_personal) 
VALUES ('email@email.com', 'P!ssw0rd', 'rose', '010-1234-5678', '부산광역시 사하구', '낙동대로', true);
#2
UPDATE `user` SET  profile_image = 'https://cdn.onews.tv/news/photo/202103/62559_62563_456.jpg' 
WHERE email = 'email@email.com';
#3
INSERT board (title, contents, writer_email) 
VALUES ('첫번째 게시물', '반갑습니다. 처음뵙겠습니다.','email2@email.com');
-- 오류: board테이블의 writer_email은 user테이블에 있는 email의 외래키로써 user의 email에 없는 값은 존재 할 수 없다.
#4
INSERT board (title, contents, writer_email) 
VALUES ('첫번째 게시물', '반갑습니다. 처음뵙겠습니다.','email@email.com');
#5
INSERT board_image (board_number, image_url) 
VALUES (1, 'https://image.van-go.co.kr/place_main/2022/04/04/12217/035e1737735049018a2ed2964dda596c_750S.jpg');
#6
UPDATE board SET favorite_count = favorite_count + 1 WHERE board_number = 1;
#7
SELECT 
	B.board_number,
    B.title, 
    B.contents, 
    B.view_count, 
    B.comment_count, 
    B.favorite_count, 
    B.write_datetime, 
    B.writer_email,
    U.profile_image,
    U.nickname
FROM `user` U 
LEFT JOIN board B
ON U.email = B.writer_email;
#8
CREATE VIEW board_view AS
SELECT 
	B.board_number,
    B.title, 
    B.contents, 
    B.view_count, 
    B.comment_count, 
    B.favorite_count, 
    B.write_datetime, 
    B.writer_email,
    U.profile_image,
    U.nickname
FROM `user` U 
LEFT JOIN board B
ON U.email = B.writer_email;
#9
SELECT *
FROM board_view
WHERE title LIKE '%반갑%' || contents LIKE '%반갑%';
#10
CREATE INDEX board_title_idx
ON board (title); 
