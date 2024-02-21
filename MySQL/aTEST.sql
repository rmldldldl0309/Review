CREATE DATABASE board;
USE board;

CREATE TABLE `user`(
	email VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    nickname VARCHAR(20) UNIQUE NOT NULL,
    tel_number VARCHAR(15) UNIQUE NOT NULL,
    address TEXT NOT NULL,
    address_detail TEXT,
    profile_image TEXT,
    agreed_personal BOOLEAN NOT NULL
);

CREATE TABLE board(
	board_number INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    contents TEXT NOT NULL,
    write_datetime DATETIME NOT NULL DEFAULT(NOW()),
    favorite_count INT NOT NULL DEFAULT(0),
    comment_count INT NOT NULL DEFAULT(0),
    view_count INT NOT NULL DEFAULT(0),
    writer_email VARCHAR(50) NOT NULL
);

CREATE TABLE `comment`(
	comment_number INT PRIMARY KEY,
    contents TEXT NOT NULL,
    write_datetime DATETIME NOT NULL DEFAULT(NOW()),
    user_email VARCHAR(50),
    board_number INT
);

CREATE TABLE favorite(
	user_email VARCHAR(50),
    board_board_number INT,
    PRIMARY KEY (user_email, board_board_number)
);

CREATE TABLE board_image(
	sequence INT AUTO_INCREMENT PRIMARY KEY, 
    board_number INT NOT NULL,
    image_url TEXT
);

CREATE TABLE search_log(
	sequence INT PRIMARY KEY NOT NULL,
    search_word TEXT NOT NULL,
    relation_word TEXT,
    relation BOOLEAN NOT NULL
);

ALTER TABLE board ADD CONSTRAINT writer FOREIGN KEY (writer_email) REFERENCES `user` (email);

ALTER TABLE `comment` ADD CONSTRAINT comment_writer FOREIGN KEY (user_email) REFERENCES `user` (email) ;
ALTER TABLE `comment` ADD CONSTRAINT board_comment FOREIGN KEY (board_number) REFERENCES board (board_number);

ALTER TABLE favorite ADD CONSTRAINT user_favorite FOREIGN KEY (user_email) REFERENCES `user` (email);
ALTER TABLE favorite ADD CONSTRAINT board_favorite FOREIGN KEY (board_board_number) REFERENCES board (board_number);

ALTER TABLE board_image ADD CONSTRAINT board_image FOREIGN KEY (board_number) REFERENCES board (board_number);

-- DROP DATABASE board;