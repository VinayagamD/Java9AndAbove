CREATE DATABASE test_jdbc;

CREATE TABLE test_data(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    CONSTRAINT test_data_pk PRIMARY KEY (id)
);

# DDL DML
CREATE DATABASE books;

DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;

CREATE TABLE author (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(30),
    email VARCHAR(25),
    gender ENUM ('M','F','O') DEFAULT 'M',
    CONSTRAINT author_pk PRIMARY KEY (id)
);

CREATE TABLE book (
    id INTEGER NOT NULL,
    isbn INTEGER,
    name VARCHAR(30) NOT NULL,
    author_id INTEGER,
    ed_num INTEGER,
    price INTEGER,
    pages INTEGER,
    CONSTRAINT book_pk PRIMARY KEY (id),
    CONSTRAINT book_author_fk FOREIGN KEY (author_id) REFERENCES author(id)
);

INSERT INTO author (name, email, gender) VALUES
('Kraig Muller', 'Wordnewton@gmail.com', 'M'),
('Karrie Nicolette', 'karrie23@gmail.com', 'F');

INSERT INTO book VALUES
(1, 001, 'Glimpses of the past', 1, 1, 650, 396),
(2, 002, 'Beyond The Horizons of Venus', 1, 1, 650, 396),
(3, 003, 'Ultrasonic Aquaculture', 2, 1, 799, 500),
(4, 004, 'Cyrogenic Engines', 2, 1, 499, 330);

# Stored Procedure
SELECT * FROM book;

DELIMITER //
CREATE PROCEDURE display_book()
    BEGIN
        SELECT * FROM book;
    end //

CALL display_book(); //

CREATE PROCEDURE update_price(IN temp_isbn VARCHAR(10), IN new_price INTEGER)
BEGIN
    UPDATE book SET price=new_price WHERE isbn=temp_isbn;
end //

CALL update_price(004,500);

CREATE PROCEDURE disp_max(OUT highest_price INTEGER)
BEGIN
    SELECT MAX(price) INTO highest_price FROM book;
end //

CALL disp_max(@M);//
SELECT @M;

CREATE PROCEDURE disp_gender(INOUT mfgender VARCHAR(6))
BEGIN
    SELECT COUNT(gender) INTO mfgender FROM author WHERE gender = mfgender;
end //

SET @m = 'M';

CALL disp_gender(@m);
SELECT @m;
SET @m = 'F';
CALL disp_gender(@m);
SELECT @m;

SELECT * FROM test_data;
