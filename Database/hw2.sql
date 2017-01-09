drop database if exists deanery; 
create database deanery;
\c deanery

create table Students(
    id SERIAL PRIMARY KEY,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL,
    groupId int
);

create table Groups(
    id SERIAL PRIMARY KEY,
    name varchar(5) NOT NULL
);

create table Teachers(
    id SERIAL PRIMARY KEY,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL
);

create table Courses(
    id SERIAL PRIMARY KEY,
    name varchar(50) NOT NULL,
    term int NOT NULL,
    teacherId int REFERENCES Teachers
);

create table Mark(
    studentId int REFERENCES Students(id),
    courseId int REFERENCES Courses(id),
    mark char NOT NULL,
    PRIMARY KEY (studentId, courseId)
);

create table StudyPlan(
    groupId int REFERENCES Groups(id),
    courseId int REFERENCES Courses(id),
    PRIMARY KEY (groupId, courseId)
);

alter table Students add FOREIGN KEY (groupId) REFERENCES Groups(id);


insert into Groups(name) values ('M3432'), ('M3439');
select * from Groups;

insert into Students(firstName, lastName, groupId) values ('Дима', 'Филиппов', 2), ('Григорий', 'Шовкопляс', 1), ('Илья', 'Збань', 1);
set client_encoding='WIN866';
select * from Students;
set client_encoding='WIN1251';

insert into Teachers(firstName, lastName) values ('Андрей', 'Станкевич'), ('Георгий', 'Корнеев');
set client_encoding='WIN866';
select * from Teachers;
set client_encoding='WIN1251';

insert into Courses(name, term, teacherId) values ('АСД', 2, 1), ('JAVA', 1, 2), ('БД', 4, 2); 
set client_encoding='WIN866';
select * from Courses;
set client_encoding='WIN1251';

insert into StudyPlan(groupId, courseId) values (1, 2), (2, 1), (2, 3);
insert into Mark(studentId, courseId, mark) values (1, 2, 'E'), (2, 3, 'A'), (3, 2, 'A');

set client_encoding='WIN866';
select * from Mark natural join Students, Courses;
set client_encoding='WIN1251';

