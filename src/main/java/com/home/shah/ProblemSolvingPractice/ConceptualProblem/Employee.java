package com.home.shah.ProblemSolvingPractice.ConceptualProblem;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {
    private String id;
    private String name;
    private Double salary;
    private String departmentName;


}
