
DROP DATABASE IF EXISTS si_assignment4;
CREATE DATABASE si_assignment4;

DROP TABLE IF EXISTS students;
CREATE TABLE students(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    mail varchar(40),
    balance int
);

DROP TABLE IF EXISTS books;
CREATE TABLE books(
    id int NOT NULL AUTO_INCREMENT,
    title varchar(50),
    price int
);

insert into students (name, mail, BALANCE) values('Ronja', 'ro@mail.dk', 100);
insert into students (name, mail, BALANCE) values('Bastian', 'ba@mail.dk', 100);
insert into students (name, mail, BALANCE) values('Alice', 'al@mail.wld', 100);
insert into students (name, mail, BALANCE) values('Bob', 'bo@bobov.dol', 100);
insert into students (name, mail, BALANCE) values('Jonathan', 'jo@mail.us', 100);
insert into students (name, mail, BALANCE) values('Frida', 'fri@mail.us', 200);
insert into students (name, mail, BALANCE) values('Freya', 'fre@mail.us', 101);

insert into books (title, price) values('Title1', 200);
insert into books (title, price) values('Title2', 3000);
insert into books (title, price) values('Title3', 500);
insert into books (title, price) values('Title4', 50);


