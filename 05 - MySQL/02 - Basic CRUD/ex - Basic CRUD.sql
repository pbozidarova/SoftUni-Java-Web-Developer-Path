SELECT `first_name`, `last_name` FROM `employees`;

SELECT concat(`first_name`, ' ', `last_name`) as `full_name` FROM `employees`;

CREATE VIEW `v_full_name_and_salary` AS
SELECT `first_name`, `last_name`, `salary` FROM `employees`;

-- Part I – Queries for SoftUni Database 
-- 1. Find All Information About Departments 
-- Write a SQL query to find all available information about the departments. Sort the information by id. 
SELECT * FROM `departments` ORDER BY `department_id`;

-- 2. Find all Department Names 
-- Write SQL query to find all department names. Sort the information by id.
SELECT `name` FROM `departments` ORDER BY `department_id`;

-- 3. Find salary of Each Employee 
-- Write SQL query to find the first name, last name and salary of each employee. Sort the information by id.
SELECT `first_name`, `last_name`, `salary` FROM `employees` ORDER BY `employee_id`;

-- 4. Find Full Name of Each Employee 
-- Write SQL query to find the first, middle and last name of each employee. Sort the information by id.
SELECT `first_name`,`middle_name`, `last_name` FROM `employees`;

-- 5. Find Email Address of Each Employee 
-- Write a SQL query to find the email address of each employee. (by his first and last name). Consider that the email domain is softuni.bg. 
-- Emails should look like “John.Doe@softuni.bg". The produced column should be named "full_ email_address".
SELECT concat(`first_name`,'.', `last_name`, '@softuni.bg') as `full_email_address` FROM `employees`;

-- 6. Find All Different Employee’s Salaries 
-- Write a SQL query to find all different employee’s salaries. Show only the salaries. Sort the information by id.  
SELECT DISTINCT `salary` FROM `employees`;

-- 7. Find all Information About Employees 
-- Write a SQL query to find all information about the employees whose job title is “Sales Representative”. Sort the information by id.
SELECT * FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id` ASC;

-- 8. Find Names of All Employees by salary in Range 
-- Write a SQL query to find the first name, last name and job title of all employees whose salary is in the range [20000, 30000]. Sort the information by id.
SELECT `first_name`, `last_name`, `job_title` FROM `employees` 
WHERE `salary` BETWEEN 20000 AND 30000;

-- 9.  Find Names of All Employees  
-- Write a SQL query to find the full name of all employees whose salary is 25000, 14000, 12500 or 23600. Full Name is combination 
-- of first, middle and last name (separated with single space) and they should be in one column called “Full Name”.
SELECT CONCAT_WS(' ', `first_name`,`middle_name` , `last_name`) AS `Full name`
FROM `employees`
WHERE `salary` IN (25000, 14000, 12500, 23600);

-- 10. Find All Employees Without Manager 
-- Write a SQL query to find first and last names about those employees that does not have a manager.
SELECT `first_name`, `last_name` FROM `employees` WHERE  `manager_id` IS NULL;

-- 11. Find All Employees with salary More Than 50000 
-- Write a SQL query to find first name, last name and salary of those employees who has salary more than 50000. Order them in decreasing order by salary. 
SELECT `first_name`, `last_name`, `salary` FROM `employees` 
WHERE `salary` > 50000
ORDER BY  `salary` DESC;

-- 12. Find 5 Best Paid Employees 
-- Write SQL query to find first and last names about 5 best paid Employees ordered descending by their salary. 
SELECT `first_name`, `last_name`, `salary` FROM `employees` 
ORDER BY  `salary` DESC
LIMIT 5;

-- 13. Find All Employees Except Marketing 
-- Write a SQL query to find the first and last names of all employees whose department ID is different from 4.
SELECT `first_name`, `last_name` FROM `employees` WHERE `department_id` != 4;

-- 14. Sort Employees Table 
-- Write a SQL query to sort all records in the еmployees table by the following criteria:  
-- •	First by salary in decreasing order 
-- •	Then by first name alphabetically 
-- •	Then by last name descending 
-- •	Then by middle name alphabetically 

SELECT * FROM `employees`
ORDER BY `salary` DESC, `first_name`, `last_name` DESC, `middle_name`; 

-- 15. Create View Employees with Salaries 
-- Write a SQL query to create a view v_employees_salaries with first name, last name and salary for each employee. 
CREATE VIEW `v_employees_salaries` AS 
SELECT `first_name`, `last_name`, `salary` FROM `employees`;
SELECT * FROM `v_employees_salaries`;
 
-- 16. Create View Employees with Job Titles 
-- Write a SQL query to create view v_employees_job_titles with full employee name and job title. When middle name is NULL replace it with empty string (‘’). 
CREATE VIEW `v_employees_job_titles` AS
SELECT CONCAT_WS(' ', `first_name`, `middle_name`, `last_name`) as `full_name`, `salary` 
FROM `employees`;
SELECT * FROM `v_employees_job_titles`;

-- 17.  Distinct Job Titles 
-- Write a SQL query to find all distinct job titles. Sort the result by job title alphabetically.
SELECT DISTINCT `job_title` FROM `employees` ORDER BY `job_title`;

-- 18. Find First 10 Started Projects 
-- Write a SQL query to find first 10 started projects. Select all information about them and sort them by start date, then by name. Sort the information by id.  
SELECT * FROM `projects`
ORDER BY `start_date`, `name`, `project_id`
LIMIT 10;

-- 19.  Last 7 Hired Employees 
-- Write a SQL query to find last 7 hired employees. Select their first, last name and their hire date.
SELECT `first_name`, `last_name`, `hire_date`
FROM `employees`
ORDER BY `hire_date` DESC
LIMIT 7;

-- 20. Increase Salaries 
-- Write a SQL query to increase salaries of all employees that are in the Engineering, Tool Design, Marketing or Information Services department by 12%. 
-- Then select Salaries column from the Employees table.
UPDATE `employees`
SET `salary` = `salary` * 1.12
WHERE `department_id` IN (1, 2, 4, 11);
SELECT * FROM departments;
SELECT `salary` FROM `employees`;

-- Part II – Queries for Geography Database 
-- 21.  All Mountain Peaks 
-- Display all mountain peaks in alphabetical order.
SELECT * FROM `peaks` ORDER BY `peak_name`;

-- 22.  Biggest Countries by Population 
-- Find the 30 biggest countries by population from Europe. Display the country name and population. 
-- Sort the results by population (from biggest to smallest), then by country alphabetically. 
SELECT `country_name`, `population` FROM `countries` 
WHERE `continent_code` = 'EU'
ORDER BY `population` DESC LIMIT 30;

-- 23.  Countries and Currency (Euro / Not Euro) 
-- Find all countries along with information about their currency. Display the country name, country code and information about its currency: 
-- either "Euro" or "Not Euro". Sort the results by country name alphabetically. 
SELECT `country_name`, `population`, 
CASE
	WHEN `currency_code` = 'EUR' THEN 'Euro'
	ELSE 'Not Euro'
END
AS `currency`
FROM `countries` 
ORDER BY `country_name`;

-- Part III – Queries for Diablo Database 
-- 24.  All Diablo Characters 
-- Display the name of all characters in alphabetical order. 
SELECT `name` FROM `characters` ORDER BY `name`;