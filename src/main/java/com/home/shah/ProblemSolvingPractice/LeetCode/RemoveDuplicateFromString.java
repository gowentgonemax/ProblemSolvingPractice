package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateFromString {
    public static void main(String[] args) {
        String data = " Good day day bye bye" ;
        Set<String> workingSet = new HashSet<>();
        System.out.println(" Original String: "  + data);
//
//        System.out.println(" *****using Set Approach****" );
//        usingSet(data);
//        System.out.println(" *****using Diff Approach****" );
//        usingStreamAPI(data);


    }

    public static void usingGeneral(String s){
        String[] elements = s.split("  " );
        String output =" " ;
        for (String str:elements){
            if(!output.contains(str)){
                output.concat(str);
            }
        }
        System.out.println(" Output  " +output);

    }
    public static void usingStreamAPI(String s){
        String[] elements = s.split("  " );
        System.out.println(Arrays.stream(elements).distinct().collect(Collectors.joining("  " )));
    }
    public static void usingSet(String s){
        String[] elements = s.split("  " );


        // 2. Convert Array to List
        List<String> elementList = Arrays.asList(elements);

        // 3. Create a Set from the List
        Set<String> elementSet = new HashSet<>(elementList);

        System.out.println(elementSet);    }
}
