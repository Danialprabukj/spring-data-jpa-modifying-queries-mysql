package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class ExampleClient {

    @Autowired
    private EmployeeRepository repo;

    public void run() {
        List<Employee> employees = createEmployees();
        repo.saveAll(employees);

        System.out.println("-- all employees --");
        repo.findAll().forEach(System.out::println);

        System.out.println(" -- increasing salaries by 20% for IT dept   --");
        int updateCount = repo.updateDeptSalaries("IT", 20);
        System.out.println("Update count: " + updateCount);

        System.out.println("-- all employees after update--");
        repo.findAll().forEach(System.out::println);
    }

    private List<Employee> createEmployees() {
        return Arrays.asList(
                Employee.create("Diana", "Sales", 2000),
                Employee.create("Rose", "IT", 4000),
                Employee.create("Sara", "Sales", 3000),
                Employee.create("Charlie", "IT", 2500)
        );
    }
}