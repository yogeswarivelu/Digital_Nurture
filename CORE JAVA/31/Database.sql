CREATE DATABASE schooldb;

USE schooldb;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    department VARCHAR(50)
);
INSERT INTO students VALUES
(1, 'Rahul', 20, 'CSE'),
(2, 'Anu', 21, 'IT'),
(3, 'Kiran', 22, 'ECE');