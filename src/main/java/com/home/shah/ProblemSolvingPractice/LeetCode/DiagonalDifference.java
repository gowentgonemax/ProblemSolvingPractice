package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {

    }
    public static int diagonalDifference() {
        // Write your code here
        List<List<Integer>> arr =  new ArrayList<>();
        int lr = 0;
        int rl = 0;
        for(int i=0;i<arr.size()-1;i++){
            for(int j = 0;j<arr.size()-1;j++){
                if (i==j){
                    lr = lr + (arr.get(0).get(0));
                    System.out.println(lr)  ;

                }

            }
        }
        return Math.abs(lr-0);
    }
}
