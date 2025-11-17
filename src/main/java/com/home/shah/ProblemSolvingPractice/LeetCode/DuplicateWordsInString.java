package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateWordsInString {
    public static void main(String[] args) {
        String inputString = " cat mat sat fat cat mat nat" ;




    }
    public static void usingStream(String inputString){
        final String[] words = inputString.toLowerCase().split(" \\W+" );
        System.out.println(Arrays.toString(Arrays.stream(words).toArray()));
        final Map<String,Integer> result = (Map<String, Integer>) Arrays.stream(words).collect(Collectors.toList());
        System.out.println(result);
    }
}
