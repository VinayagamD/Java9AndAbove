DROP SCHEMA books;
CREATE SCHEMA books;
USE books;


-- DDL
CREATE TABLE author
(
    id         INTEGER NOT NULL AUTO_INCREMENT,
    name       VARCHAR(30),
    email      VARCHAR(25),
    gender     ENUM ('male', 'female', 'others') DEFAULT 'male',
    created_at TIMESTAMP                         DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP                         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT author_pk PRIMARY KEY (id),
    CONSTRAINT author_email_uq UNIQUE KEY (email)
);

CREATE TABLE books
(
    id         INTEGER     NOT NULL,
    isbn       INTEGER     NOT NULL,
    name       VARCHAR(30) NOT NULL,
    author_id  INTEGER     NOT NULL,
    ed_num     INTEGER,
    price      DECIMAL(10, 2),
    pages      INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT books_pk PRIMARY KEY (isbn),
    CONSTRAINT books_uq UNIQUE KEY (id),
    CONSTRAINT book_author_fk FOREIGN KEY (author_id) REFERENCES author (id)
);

-- DML

DESC author;
DESC books;
INSERT INTO author(name, email, gender)
VALUES ('Kraig Muller', 'Wordnewton@gmail.com', 'male'),
       ('Karrie Nicolette', 'karrie23@gmail.com', 'female');
SELECT *
FROM author;
-- INSERT VALUES to books
DESC books;
INSERT INTO books (id, isbn, name, author_id, ed_num, price, pages)
VALUES (1, 001, 'Glimpses of the past', 1, 1, 650.00, 396),
       (2, 002, 'Beyond The Horizons of Venus', 1, 1, 650.00, 396),
       (3, 003, 'Ultrasonic Aquaculture', 2, 1, 799.00, 500),
       (4, 004, 'Cyrogenic Engines', 2, 1, 499.00, 330);

SELECT *
FROM books;
SELECT *
FROM author;


-- STORED PROCEDURE
-- CREATE PROCEDURES DISPLAY BOOK

DELIMITER //
CREATE PROCEDURE display_book()
BEGIN
    SELECT * FROM books;
END;
//

-- CALL THE Stored Procedures
CALL display_book();

/*
3 Parameters in Procedure

IN Parmater -> Input
OUT Parmater -> Output
INOUT Parmater -> InputOutput

Syntax:
CREATE PROCEDURE <procedure-name>(<parameter-type> <parametername> <mysql-datatype>)
BEGIN
 <procedure-body>
END;
*/

-- Procedure with IN parameter:

-- Procedure to update price of a book taking ISBN of the book and its new price as input: (considering the tables above)

DELIMITER //
CREATE PROCEDURE update_price(IN temp_isbn VARCHAR(10), IN new_price DECIMAL(10, 2))
BEGIN
    UPDATE books SET price=new_price WHERE isbn = temp_isbn;
END;
//

-- CALL THE Stored Procedures Update the book price
CALL update_price('001', 600.00);

SET @isbn='002';
SET @price=700.50;
CALL update_price(@isbn, @price);


-- Procedure with OUT parameter:


-- Procedure to display the highest price among all the books with an output parameter:
DELIMITER //
CREATE PROCEDURE disp_max(OUT highest_price DECIMAL(10, 2))
BEGIN
    SELECT MAX(price) INTO highest_price FROM books;
END;
//

-- Call the procedure display max price
CALL disp_max(@M);
SELECT @M AS max_price;

-- Procedure with IN-OUT parameter:
-- Procedure to take gender type input (‘Male’/’Female’ here) with an in-out parameter which reflects the number of authors falling in that gender category/type:
DELIMITER //
CREATE PROCEDURE disp_gender(INOUT mfgender INTEGER, IN emp_gender VARCHAR(6))
BEGIN
    SELECT COUNT(gender) INTO mfgender FROM author WHERE gender = emp_gender;
END;
//

DELIMITER ;
CALL disp_gender(@M, 'male');
SELECT @M;
CALL disp_gender(@F, 'female');
SELECT @F;

DELIMITER //
CREATE PROCEDURE disp_gender_single(INOUT mfgender VARCHAR(10))
BEGIN
    SELECT COUNT(gender) INTO mfgender FROM author WHERE gender = mfgender;
END;
//
DELIMITER ;
SET @M = 'male';
CALL disp_gender_single(@M);
SELECT @M MALE_COUNT;

-- CREATE VIEW
SELECT b.id id, b.name name, a.name author FROM books b JOIN author a ON  a.id = b.author_id;

CREATE VIEW books_author AS SELECT b.id id, b.name name, a.name author FROM books b JOIN author a ON  a.id = b.author_id;

SELECT * FROM books_author;
