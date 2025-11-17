package com.home.shah.ProblemSolvingPractice.LeetCode;

public class DigitExtractor {
    public static void main(String[] args) {
        findLastDigit(1234567);
    }

    public static void findLastDigit(int n){
        while (n!=0) {
            int digit = (int) Math.pow(n % 10,2);
            n= n/10;
            System.out.println(digit);
        }
    }
}
