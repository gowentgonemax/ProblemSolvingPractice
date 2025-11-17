package com.home.shah.ProblemSolvingPractice.RestClientDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class Companies {
    private String id;
    private String name;
    private String address;
    private String zip;
    private String country;
    private int employeeCount;
    private String industry;
    private Double marketCap;
    private String domain;
    private String logo;
    private String ceoName;

}
