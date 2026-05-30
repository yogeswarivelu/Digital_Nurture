CREATE DATABASE bankdb;

USE bankdb;

CREATE TABLE accounts (
    account_no INT PRIMARY KEY,
    account_holder VARCHAR(50),
    balance DOUBLE
);
INSERT INTO accounts VALUES
(101, 'Rahul', 5000),
(102, 'Anu', 3000);