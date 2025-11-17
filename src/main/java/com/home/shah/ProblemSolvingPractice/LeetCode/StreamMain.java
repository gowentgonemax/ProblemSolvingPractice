package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        //Create a list and filter all even numbers from list

        List<Integer> list1  = List.of(2,4,5,6,1,33,54,34,67);


//        List<Integer> list2  = new ArrayList<>();
//        List<Integer> evenList = list1.stream().filter(ele->ele % 2 == 0).collect(Collectors.toList());
//        System.out.println(evenList);
//        List<Integer> greaterList = list1.stream().filter(ele->ele >50).collect(Collectors.toList());
//        System.out.println(greaterList);
//        System.out.println(list1.stream().max(Integer::compareTo).get());
//        System.out.println(list1.stream().count());
//
//        String input = " Java articles are Awesome" ;
        //Character  character = input.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s))).collect();
        streamBoxed();

    }

    static void streamBoxed(){
        IntStream stream = IntStream.range(3, 8);

        // Creating a Stream of Integers
        // Using IntStream boxed() to return
        // a Stream consisting of the elements
        // of this stream, each boxed to an Integer.
        Stream<Integer> stream1 = stream.boxed();
        Stream<Object> stream2 = Stream.concat(stream1,
                Stream.of(" Geeks" , " for" , " Geeks" ));

        // Displaying the elements
        stream1.forEach(System.out::println);
    }

}
