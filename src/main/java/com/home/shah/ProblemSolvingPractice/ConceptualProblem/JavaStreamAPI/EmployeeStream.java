package com.home.shah.ProblemSolvingPractice.ConceptualProblem.JavaStreamAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeStream {
    public static void main(String[] args) {
        List<Employee> employees = SampleData.sampleEmployees();
        System.out.println(employees);      // prints the sample list
        groupBy(employees);

    }
    //    Group a list of employees by department using `Collectors.groupingBy`.
    public static   void groupBy(List<Employee> givenEmployee) {
        Map<String, List<Employee>> collect = givenEmployee.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect);
    }
    //   Find the longest string in a list using `reduce`.
    public static   void LongestString(List<Employee> givenEmployee) {
        Map<String, List<Employee>> collect = givenEmployee.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect);
    }
    public static void  groupByDepartment(List<Employee> employee){
        Map<String, List<Employee>> collect = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect);



    }

}
