package com.home.shah.ProblemSolvingPractice.ConceptualProblem;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.println(" UserDefined: " +binarySearch(sortedArray,17));
        System.out.println(" InBuild: " +Arrays.binarySearch(sortedArray,17));
    }
// Non-Recursive
    public static int binarySearch(int[] givenArray,int target){
        int left = 0;
        int right = givenArray.length-1;

        while(left<=right){
            int mid = left + (right - left) / 2;
            if (givenArray[mid]==target){
                return mid;
            }
            else if(givenArray[mid]< target) {

                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}
