package A06_DefiningClasses.e02CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );

        int n = Integer.parseInt(reader.readLine());

        HashMap<String, Department> departments = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String departmentName = tokens[3];

            Employee emp = new Employee(tokens[0],
                    Double.parseDouble(tokens[1]),
                    tokens[2]);

            if (tokens.length == 5) {
                if (Character.isDigit(tokens[4].charAt(0))) {
                    emp.setAge(Integer.parseInt(tokens[4]));
                } else {
                    emp.setEmail(tokens[4]);
                }
            } else if (tokens.length == 6) {
                emp.setEmail(tokens[4]);
                emp.setAge(Integer.parseInt(tokens[5]));
            }

            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department());
            }

            departments.get(departmentName).addEmployee(emp);
        }

        departments.entrySet().stream()
                .sorted((f, s) -> Double.compare(s.getValue().getAverageSalary(), f.getValue().getAverageSalary()))
                .limit(1)
                .forEach(entry -> {

                    System.out.println(String.format("Highest Average Salary: %s", entry.getKey()));
                    entry.getValue().getEmployees()
                            .stream()
                            .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                            .forEach(employee -> System.out.println(String.format("%s %.2f %s %d",
                                    employee.getName(),
                                    employee.getSalary(),
                                    employee.getEmail(),
                                    employee.getAge())));

                });
    }
}
