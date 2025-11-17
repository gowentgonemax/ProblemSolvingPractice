package com.home.shah.ProblemSolvingPractice.ConceptualProblem.JavaStreamAPI;

import java.util.Comparator;
import java.util.List;

public class JavaStreamProblems {
    public static void main(String[] args) {
        List<String> givenString = List.of(
                "alice",
                "Bob",
                "hello world",
                "Java",
                "stream",
                "  spaces  ",
                "",
                "apple", "apache",
                "123",
                "éclair",
                "😀 emoji"
        );
    List<Integer> givenIntegers = List.of(2,4,6,11,33,76,87,99,44,44,3,2,6,33);
        System.out.println(convertToUpperCase(givenString));
        filterEvenNumbers(givenIntegers);
        CountString(givenString);
        SortingInteger(givenIntegers);
        distinct(givenIntegers);
                    // use your existing groupBy method

    }

    //Convert a list of strings to uppercase using streams.
    public static List<String> convertToUpperCase(List<String> strings) {
        return strings.stream().map(String::toUpperCase).toList();
    }
//Filter even numbers from a list of integers.
    public static void filterEvenNumbers(List<Integer> givenIntegers){
        List<Integer> list = givenIntegers.stream().filter(e -> e % 2 == 0).toList();
        System.out.println(list);
    }
    //   Count how many strings in a list start with the letter "A".
    public static void CountString(List<String> givenString){
        long a1 = givenString.stream().filter(e->e.toUpperCase().startsWith("A")).count();
        System.out.println(a1);
    }
    //    Sort a list of integers in descending order using streams.
    public static void SortingInteger(List<Integer> givenIntegers) {
        List<Integer> list = givenIntegers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list);
    }
    public static void distinct(List<Integer> givenIntegers) {
        List<Integer> distinct = givenIntegers.stream().distinct().toList();
        System.out.println(distinct);
    }


}
