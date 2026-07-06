package com.home.shah.ProblemSolvingPractice.ConceptualProblem;


import com.home.shah.ProblemSolvingPractice.ConceptualProblem.JavaStreamAPI.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamAPIDemo {

    public static void main(String[] args) {
        Employee employee = new Employee(" 1" ," Ravi" ," Science",12000.90 );
        List<String> givenStrings = Arrays
                .asList(" apple" , " banana" , " cherry" , " date" , " grapefruit" );

        Optional<String> longestString = givenStrings.stream().max(Comparator.comparingInt(String::length));
        System.out.println(longestString);









        System.out.println(employee.getDepartment());
    }
}

