package com.home.shah.ProblemSolvingPractice.SlidingWindows;

public class MaxSum {
    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println(" Array before sorting:" );
        for (int num : data) {
            System.out.print(num + "  " );
        }
        System.out.println();


        System.out.println(" Array after sorting:" );
        for (int num : data) {
            System.out.print(num + "  " );
        }
        System.out.println();
    }

    public int findMaxSum(int[] arr,int k) {
      int sum =0;
        for (int i = 0; i < arr.length-1; i++) {
            sum = sum + arr[i];
        }
      return sum;
    }
}
