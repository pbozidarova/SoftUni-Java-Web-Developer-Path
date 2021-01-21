USE `camp`;
-- 1.	 Mountains and Peaks
CREATE TABLE `mountains`(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	name VARCHAR(45) NOT NULL
);

DROP TABLE IF EXISTS `peaks`;
CREATE TABLE `peaks`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(45) NOT NULL,
    `mountain_id` INT,
    CONSTRAINT fk_peaks_mountains FOREIGN KEY(`mountain_id`)
		REFERENCES `mountains`(`id`) 
        ON UPDATE CASCADE
        ON DELETE SET NULL
);
-- 2.	 Trip Organization
SELECT v.`driver_id`, v.`vehicle_type`, 
CONCAT(c.`first_name`, ' ' , c.`last_name`) AS`driver_name` 
FROM `vehicles` AS v JOIN `campers` AS c ON v.`driver_id` = c.`id`;	

-- 3.	SoftUni Hiking
SELECT r.`starting_point` AS `route_starting_point`, 
	r.`end_point` AS `route_ending_point`, 
	r.`leader_id`, CONCAT(c.`first_name`, ' ', c.`last_name` ) AS `leader_name`
FROM `routes` as r JOIN `campers` as c ON r.`leader_id` = c.`id`;

-- 4.	Delete Mountains
ALTER TABLE `peaks` DROP FOREIGN KEY `fk_peaks_mountains`;

ALTER TABLE `peaks`
ADD CONSTRAINT fk_peaks_mountains FOREIGN KEY(`mountain_id`)
		REFERENCES `mountains`(`id`) 
        ON UPDATE CASCADE
        ON DELETE CASCADE;

-- 5.	 Project Management DB*
CREATE TABLE `clients` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `client_name` VARCHAR(100)
);

CREATE TABLE `projects` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`client_id` INT,
    `project_lead_id` INT,
    CONSTRAINT `fk_projects_clients`
    FOREIGN KEY (`client_id`)
    REFERENCES `clients`(`id`),
    CONSTRAINT `fk_projects_employees`
    FOREIGN KEY (`project_lead_id`)
    REFERENCES `employees`(`id`)
);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30),
    `last_name` VARCHAR(30),
    `project_id` INT(11),
    CONSTRAINT `fk_employees_projects`
    FOREIGN KEY (`project_id`)
    REFERENCES `projects`(`id`)
);