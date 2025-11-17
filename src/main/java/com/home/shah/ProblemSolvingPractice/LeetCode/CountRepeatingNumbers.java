package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountRepeatingNumbers {
    public static void main(String[] args) {
        //approach1();
        approach2();
    }
    static void approach1(){


        // Converting number to string
        String s = " " ;
        Map<Character, Long> groups
                = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c, Collectors.counting()));
        System.out.println(groups);


    }
    static void approach2(){
        int[] arr = {4,5,2,4,4,3,3,6,5,4,3};
        Map<Integer,Long> map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(a->a,Collectors.counting()));
        map.entrySet().stream().filter(a->a.getValue()>1).map(Map.Entry::getKey).forEach(System.out::println);
    }
}
