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
CREATE TABLE `teachers` (
	`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `manager_id` INT
);

INSERT INTO `teachers`
VALUES 
(101, 'John', NULL),
(102, 'Maya', 106),
(103, 'Silvia', 106),
(104, 'Ted', 105),
(105, 'Mark', 101),
(106, 'Greta', 101);

ALTER TABLE `teachers`
ADD CONSTRAINT fk_teachers_managers
FOREIGN KEY (`manager_id`)
REFERENCES `teachers`(`teacher_id`);

-- 5.	Online Store Database
CREATE DATABASE `online_store`;
USE `online_store`;

CREATE TABLE `item_types`(
	`item_type_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `cities` (
	`city_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `customers` (
	`customer_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `birthday` DATE,
    `city_id` INT,
    CONSTRAINT fk_customers_cities
    FOREIGN KEY (`city_id`)
    REFERENCES `cities`(`city_id`)
);

CREATE TABLE `items` (
	`item_id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50),
	`item_type_id` INT,
    CONSTRAINT fk_items_item_types
    FOREIGN KEY (`item_type_id`) 
    REFERENCES `item_types`(`item_type_id`)
    
);

CREATE TABLE `orders` (
	`order_id` INT PRIMARY KEY AUTO_INCREMENT,
    `customer_id`INT,
    CONSTRAINT fk_orders_customers
    FOREIGN KEY (`customer_id`)
    REFERENCES `customers`(`customer_id`)
);

CREATE TABLE `orders_items` (
	`order_id` INT,
    `item_id` INT,
    
    CONSTRAINT pk_orders_items
    PRIMARY KEY (`order_id`, `item_id`),
    
    CONSTRAINT fk_orders_items_orders
    FOREIGN KEY (`order_id`)
    REFERENCES `orders`(`order_id`),
    
    CONSTRAINT fk_orders_items_items
    FOREIGN KEY (`item_id`)
    REFERENCES `items`(`item_id`)
);

-- 6.	University Database
CREATE DATABASE `university`;
USE `university`;

CREATE TABLE `subject` (
 `subject_id` INT PRIMARY KEY AUTO_INCREMENT,
 `subject_name` VARCHAR(50)
);

CREATE TABLE `majors` (
	`major_id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50)
);

CREATE TABLE `students` (
	`student_id` INT PRIMARY KEY AUTO_INCREMENT,
    `student_number` VARCHAR(12),
    `student_name` VARCHAR(50),
    `major_id` INT,
    
    CONSTRAINT fk_students_majors
    FOREIGN KEY (`major_id`)
    REFERENCES `majors`(`major_id`)
);

CREATE TABLE `agenda` (
	`student_id` INT,
    `subject_id` INT,
    
    CONSTRAINT pk_students_subject
    PRIMARY KEY (`student_id`, `subject_id`),
    
    CONSTRAINT fk_agenda_students
    FOREIGN KEY (`student_id`)
    REFERENCES `students`(`student_id`),
    
    CONSTRAINT fk_agenda_subject
    FOREIGN KEY (`subject_id`)
	REFERENCES `subject`(`subject_id`)
);

CREATE TABLE `payments` (
	`payment_id` INT PRIMARY KEY AUTO_INCREMENT,
    `payment_date` DATE,
    `payment_amount` DECIMAL(8, 2),
	`student_id` INT,
    
    CONSTRAINT fk_payments_student
    FOREIGN KEY (`student_id`)
    REFERENCES `students`(`student_id`)
);

-- 7.	SoftUni Design
-- Create an E/R Diagram of the SoftUni Database.

-- 8.	Geography Design
-- Create an E/R Diagram of the Geography Database.

-- 9.	Peaks in Rila
SELECT m.`mountain_range`, p.`peak_name`, p.`elevation` AS `peak_elevation`
FROM `peaks` AS p
JOIN `mountains` as m
ON p.`mountain_id` = m.`id`
WHERE m.`mountain_range` = 'Rila'
ORDER BY `peak_elevation` DESC;
