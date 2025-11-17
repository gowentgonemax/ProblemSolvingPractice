package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharacters {
    public static void main(String[] args) {
        String input = " Java  JavaEE" ;
        Map<Character,Long> result = input.
                chars().mapToObj(c->(char)c).
                collect(Collectors.groupingBy(c-> c,Collectors.counting()));

        System.out.println(result);
    }

}
