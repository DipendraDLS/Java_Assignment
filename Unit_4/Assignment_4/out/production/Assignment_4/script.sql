create database JavaJDBC;
use JavaJDBC;

CREATE TABLE students (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(25) NOT NULL,
    district varchar(25),
    age int,
    PRIMARY KEY (id)
);
