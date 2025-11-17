package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayIssue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
//        findSimilarElementByIndex(arr);
//        sendtoList(arr);
        productOfArrayElements();
    }

    public static void findSimilarElementByIndex(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    sum = sum + 1;
                }
            }
        }
        System.out.println(sum);
    }

    public static void sendtoList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for (int num : nums) {
            if (list.contains(num)) {
                list.add(num);
            }
        }
        System.out.println(list);
    }

    public static void digitFrequency() {
        String input = " 2234256754389934" ;

    }

    public static void productOfArrayElements() {
        int[] nums = {1, 2, 4, 7};
        int pro =1;
        int[] output = new int[5];
        for(int i: nums){
            pro*=i;
        }
        System.out.println(output);
        for (int i=0;i<nums.length;i++) {
            output[i] = pro / i;
        }
    }
    public long interchangeableRectangles(int[][] rectangles) {
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = 0; j < rectangles.length; j++) {
                if (i < j) {
                    System.out.println(i + " ,"  + j);
                    System.out.println(rectangles[i][j]);
                }

            }

        }
    return 3;
    }
    public static void arrayasList(){
        int[] arr = {1, 2, 4, 7};
        List<Integer> myList = Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}