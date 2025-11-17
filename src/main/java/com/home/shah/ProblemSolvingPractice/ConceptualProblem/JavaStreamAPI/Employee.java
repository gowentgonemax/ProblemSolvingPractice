package com.home.shah.ProblemSolvingPractice.ConceptualProblem.JavaStreamAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

public class Employee {
    private final int id;
    private final String name;
    private final String department;
    private final double salary;



    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class SampleData {
    public static List<Employee> sampleEmployees() {
        return List.of(
                new Employee(1, "Alice Johnson", "Engineering", 95000),
                new Employee(2, "Bob Smith", "HR", 68000),
                new Employee(3, "Carol Nguyen", "Engineering", 102000),
                new Employee(4, "Dave Lee", "Sales", 72000),
                new Employee(5, "Eve García", "Engineering", 99000),
                new Employee(6, "Frank Miller", "HR", 64000),
                new Employee(7, "Grace Kim", "Sales", 75000),
                new Employee(8, "Heidi Patel", "Marketing", 70000)
        );
    }
}
