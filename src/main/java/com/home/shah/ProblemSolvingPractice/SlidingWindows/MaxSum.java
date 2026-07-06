package com.home.shah.ProblemSolvingPractice.SlidingWindows;

public class MaxSum {
    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println(" Array before sorting:" );
        for (int num : data) {
            System.out.print(num + "  " );
        }
        System.out.println();


        int k = 3; // Example window size
        int maxSum = findMaxSum(data, k);
        System.out.println("\nMaximum sum of a subarray of size " + k + ": " + maxSum);
    }

    public static int findMaxSum(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid input: array too small or k invalid");
        }
        int maxSum = 0;
        int windowSum = 0;
        // Compute sum of first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }
        return maxSum;
    }
}
