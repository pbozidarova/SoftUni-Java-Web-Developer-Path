CREATE DATABASE `tbl_relations`;
USE `tbl_relations`;

-- 1.	One-To-One Relationship
CREATE TABLE `passports` (
	`passport_id` INT PRIMARY KEY AUTO_INCREMENT,
    `passport_number` VARCHAR(20) UNIQUE
);

CREATE TABLE `people` (
	`person_id`  INT PRIMARY KEY AUTO_INCREMENT,
    `passport_number` VARCHAR(20) NOT NULL,
    `salary` DECIMAL(10,2),
    `passport_id` INT UNIQUE,
    CONSTRAINT fk_people_passports
	FOREIGN KEY (`passport_id`)
    REFERENCES `passports`(`passport_id`)
);

INSERT INTO `passports` 
VALUES 
(101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

INSERT INTO `people` (`first_name`, `salary`, `passport_id`)
VALUES
('Roberto', 43300, 102),
('Tom', 56100, 103),
('Yana', 60200, 101);

-- 2.	One-To-Many Relationship
CREATE TABLE `manufacturers`(
	`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(25),
    `established_on` DATE
);

CREATE TABLE `models` (
	`model_id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(25),	
    `manufacturer_id` INT,
    CONSTRAINT fk_models_manufacturers
    FOREIGN KEY (`manufacturer_id`)
    REFERENCES `manufacturers`(`manufacturer_id`)
);

INSERT INTO `manufacturers` (`name`, `established_on`)
VALUES 
('BMW', '1916-03-01'),
('Tesla', '2003-01-01'),
('Lada', '1966-05-01');

INSERT INTO `models`
VALUES 
(101, 'X1', 1),
(102, 'i6', 1),
(103, 'Model S', 2),
(104, 'Model X', 2),
(105, 'Model 3', 2),
(106, 'Nova', 3);

-- 3.	Many-To-Many Relationship
CREATE TABLE `students` (
	`student_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `exams` (
	`exam_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `students_exams` (
	`student_id` INT,
    `exam_id` INT,
    
    CONSTRAINT pk_students_exams
    PRIMARY KEY (`student_id`, `exam_id`),
    
    CONSTRAINT fk_students_exams_students
    FOREIGN KEY (`student_id`)
    REFERENCES `studetns`(`student_id`),
    
    CONSTRAINT fk_students_exams_exams
    FOREIGN KEY (`exam_id`)
    REFERENCES `exams`(`exam_id`)
);

INSERT INTO `students` (`name`)
VALUES ('Mila'), ('Toni'), ('Ron');

INSERT INTO `exams`
VALUES (101, 'Spring MVC'), ( 102, 'Neo4j'), (103, 'Oracle 11g');

INSERT INTO `students_exams`
VALUES 
(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

-- 4.	Self-Referencing

-- 5.	Online Store Database

-- 6.	University Database

-- 7.	SoftUni Design

-- 8.	Geography Design

-- 9.	Peaks in Rila

