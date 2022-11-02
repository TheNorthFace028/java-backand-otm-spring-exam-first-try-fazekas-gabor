DROP TABLE IF EXISTS STUDENT CASCADE;
CREATE TABLE STUDENT
(
    id               varchar(50) NOT NULL PRIMARY KEY,
    name             varchar(50),
    has_history_book boolean NOT NULL,
    has_english_book boolean  NOT NULL,
    has_math_book boolean
);