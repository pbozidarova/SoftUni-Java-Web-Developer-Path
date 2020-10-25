// Define several classes, that represent a company’s employee records. Every employee has a name and age, a salary and a list of tasks, 
// while every position has specific properties not present in the others. Place all common functionality in a parent abstract class. 
// Follow the diagram bellow:
// Every position has different tasks. In addition to all common properties, the manager position has a dividend he can collect along 
// with his salary.
// All employees have a work() function that when called cycles trough the list responsibilities for that position and prints the current 
// one. When all tasks have been printed, the list starts over from the beginning. Employees can also collect salary, which outputs the 
// amount, plus any bonuses.
// Your program needs to expose a module, containing the three classes Junior, Senior and Manager. The properties name and age are set 
// trough the constructor, while the salary and a manager’s dividend are initially set to zero and can be changed later. The list of tasks 
// is filled by each position. The resulting objects also expose the functions work() and collectSalary(). When work() is called, one of 
// the following lines is printed on the console, depending on the current task in the list:
// "{employee name} is working on a simple task."
// "{employee name} is working on a complicated task."
// "{employee name} is taking time off work."
// "{employee name} is supervising junior workers."
// "{employee name} scheduled a meeting."
// "{employee name} is preparing a quarterly report."
// And when collectSalary() is called, print the following:
// "{employee name} received {salary + bonuses} this month."

function createPeopleClasses() {
    class Employee {
        constructor(name, age) {
            if (new.target === Employee) {
                throw new Error('Employee class cannot be instantiated.')
            }

            this.name = name;
            this.age = age;
            this.salary = 0;
            this.tasks = [];
        }

        work() {
            let currentTask = this.tasks.shift();
            console.log(`${this.name} ${currentTask}`);
            this.tasks.push(currentTask);
        }

        collectSalary() {
            console.log(`${this.name} received ${this._calculateSalary()} this month.`);
        }

        _calculateSalary() {
            return this.salary;
        }
    }

    class Junior extends Employee {
        constructor(name, age) {
            super(name, age);

            this.tasks.push('is working on a simple task.');
        }
    }

    class Senior extends Employee {
        constructor(name, age) {
            super(name, age);

            this.tasks.push('is working on a complicated task.');
            this.tasks.push('is taking time off work.');
            this.tasks.push('is supervising junior workers.');
        }
    }

    class Manager extends Employee {
        constructor(name, age) {
            super(name, age);
            this.dividend = 0;

            this.tasks.push('scheduled a meeting.');
            this.tasks.push('is preparing a quarterly report.');
        }

        _calculateSalary() {
            return this.salary + this.dividend;
        }
    }

    return {Employee, Junior, Senior, Manager};
}