-- Functions
-- 1.	Count Employees by Town
-- Write a function ufn_count_employees_by_town(town_name) that accepts town_name as parameter and returns the count of employees who live in that town.
DROP FUNCTION IF EXISTS ufn_count_employees_by_town;
DELIMITER //
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
RETURNS INT DETERMINISTIC
BEGIN
	DECLARE emp_count INT;
    SET emp_count := 
		(SELECT COUNT(*) FROM `employees`
			JOIN `addresses` USING (`address_id`) 
			JOIN `towns` USING (`town_id`) 
            WHERE `towns`.`name` = town_name);
	RETURN emp_count;
END//
DELIMITER ;

SELECT ufn_count_employees_by_town('Sofia');
SELECT ufn_count_employees_by_town('Berlin');

SELECT employee_id, first_name, last_name, t.`name` FROM employees
	NATURAL JOIN  addresses
	NATURAL JOIN towns t
	WHERE t.`name` = 'Carnation';

-- Procedures
DROP FUNCTION IF EXISTS diff_years;
DELIMITER //
CREATE FUNCTION  diff_years(date1 DATETIME, date2 DATETIME)
RETURNS INT DETERMINISTIC
BEGIN
	RETURN ROUND(DATEDIFF(date1, date2) / 365.25);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_select_employees_by_seniority;
DELIMITER //
CREATE PROCEDURE usp_select_employees_by_seniority(IN years_employed INT)
BEGIN
	SELECT `employee_id`, `first_name`, `last_name`, `hire_date`, 
		diff_years(NOW(), `hire_date`) 
	FROM `employees`
    WHERE diff_years(NOW(), `hire_date`)  < years_employed;
END//
DELIMITER ;

CALL usp_select_employees_by_seniority(20);

-- IN-OUT Parameters
DROP procedure IF EXISTS `usp_add_numbers`;
DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_add_numbers` (
	IN a INT, 
    IN b INT,
    OUT result INT)
BEGIN
	SET result := a + b;
END$$
DELIMITER ;

SET @answer = 0;
CALL usp_add_numbers(17, 9, @answer);
SELECT @answer;

DROP procedure IF EXISTS `usp_increment`;
DELIMITER $$
CREATE PROCEDURE `usp_increment` (
    INOUT result INT)
BEGIN
	SET result := result + 1;
END$$
DELIMITER ;

CALL usp_increment( @answer);
SELECT @answer;

-- 2.	Employees Promotion
-- Procedure updating tables
-- Write a stored procedure usp_raise_salaries(department_name) to raise the salary of all employees in given department as parameter by 5%. 
DROP procedure IF EXISTS `usp_raise_salaries`;
DELIMITER $$
CREATE PROCEDURE `usp_raise_salaries` (
	IN department_name VARCHAR(50),
	IN percentage DOUBLE
)
BEGIN
	UPDATE `employees` JOIN `departments` d USING (`department_id`) 
    SET `salary` = `salary` * (1 + percentage/100)
    WHERE d.`name` = department_name;
END $$
DELIMITER ;

CALL usp_raise_salaries('Sales', 10);
SELECT `employee_id`, `first_name`, `last_name`, `salary`
FROM `employees` JOIN `departments` d USING (`department_id`) 
WHERE d.`name` = 'Sales';

CALL usp_raise_salaries('Finance', 5);
SELECT `employee_id`, `first_name`, `last_name`, `salary`
FROM `employees` JOIN `departments` d USING (`department_id`) 
WHERE d.`name` = 'Finance';

-- 3. Employees Promotion by ID
-- Write a stored procedure usp_raise_salary_by_id(id) that raises a given employee’s salary (by id as parameter) by 5%. 
-- Consider that you cannot promote an employee that doesn’t exist – if that happens, no changes to the database should be made. 
DROP procedure IF EXISTS `usp_raise_salary_by_id`;
DELIMITER $$
CREATE PROCEDURE `usp_raise_salary_by_id`(emp_id INT)
BEGIN
	START TRANSACTION;
    IF( (SELECT COUNT(*) FROM `employees` WHERE `employee_id` = emp_id ) <> 1)
    THEN ROLLBACK;
    ELSE 
		UPDATE `employees`
		SET `salary` = `salary` * 1.05
		WHERE `employee_id` = emp_id;
        COMMIT;
	END IF;
END $$
DELIMiTER ;

CALL usp_raise_salary_by_id(178);
SELECT `employee_id`, `first_name`, `last_name`, `salary` 
FROM `employees` 
WHERE `employee_id` = 178;

CALL usp_raise_salary_by_id(268);
SELECT `employee_id`, `first_name`, `last_name`, `salary` 
FROM `employees` 
WHERE `employee_id` = 268;

CALL usp_raise_salary_by_id(50000);
SELECT SUM(`salary`) FROM `employees`;

-- 4. Triggered
-- Create a table deleted_employees(employee_id PK, first_name,last_name,middle_name,job_title,deparment_id,salary) that will hold information about fired(deleted) 
-- employees from the employees table. Add a trigger to employees table that inserts the corresponding information in deleted_employees. 
DROP TABLE IF EXISTS deleted_employees;
CREATE TABLE deleted_employees (
  `employee_id` INT PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `job_title` varchar(50) NOT NULL,
  `department_id` int(10) DEFAULT NULL,
  `salary` decimal(19,4) NOT NULL
);

DELIMITER $$
CREATE TRIGGER tr_deleted_employees
AFTER DELETE 
ON `employees`
FOR EACH ROW 
BEGIN
	INSERT INTO `deleted_employees`(
		`employee_id`, `first_name`, `last_name`, `middle_name`, `job_title`,
		`department_id`,  `salary`)
    VALUES 
		(OLD.`employee_id`, OLD.`first_name`, OLD.`last_name`, OLD.`middle_name`, 
		OLD.`job_title`, OLD.`department_id`, OLD.`salary`);
END$$
DELIMITER ;

DELETE FROM `soft_uni`.`employees`
WHERE employee_id = 3;