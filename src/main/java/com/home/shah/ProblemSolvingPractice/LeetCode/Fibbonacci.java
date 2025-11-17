package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.HashMap;

public class Fibbonacci {
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    public static void main(String[] args) {
        System.out.println(fib(5));
        timeChecker();
    }
    static void timeChecker(){
        long start = System.nanoTime();
        System.out.println(fib(100));
        long end = System.nanoTime();
        long timetaken = end-start;
        System.out.println(" Time taken:" + timetaken);
    }
    static int fib(int n){
return 0;
    }

}
