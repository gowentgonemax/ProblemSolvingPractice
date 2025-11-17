package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappyHour(82));
//        testSpace();

    }

    public static boolean isHappyHour(int num) {

        boolean isHappy = false;
        int sum = 0;
        Set<Integer> seen = new HashSet<>();
        while (num != 0) {
            int digit = num%10;
            sum += digit;
//            if (sum != 1 && seen.contains(sum)) {
//                seen.add(sum);
//            }
//            isHappy = !(arr.contains(sum));
            num = num / 10;
        }

        return isHappy;


    }

    public static int getNext() {
        int num = 12345;

        int digit = num % 10;
        int sum = (int) Math.pow(num % 10, 2);
        return sum;

    }
}
