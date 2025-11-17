package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Question {
    // Online Java Compiler
// Use this editor to write, compile and run your Java code online


        public static void main(String[] args) {
            //firstElement();
            DuplicateElement();
        }
        public void DistinctValue(){
            List<Integer>  list = Arrays.asList(2,2,3,4,5,6,7,8,9);
            System.out.println(list.stream().distinct().collect(Collectors.toList()));
        }
        
        public static void firstElement(){
            List<String> stringList = Arrays.asList(" Geek_First" , " Geek_2" , " Geek_3" , " Geek_4" , " Geek_Last" );
            String reduce = stringList.stream().reduce((a, b) -> a).orElse(null);
            System.out.println(reduce);

        }
        public static void DuplicateElement(){
            List<Integer>  list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
            //list.stream().filter((a-> Collections.frequency(list, a)>1).;
            var collect = list.stream()

                    // Count the frequency of each element
                    // and filter the elements
                    // with frequency > 1
                    .filter(i -> Collections.frequency(list, i) > 1)

                    // And Collect them in a Set
                    .collect(Collectors.toSet());
            System.out.println(collect);

        }
}
