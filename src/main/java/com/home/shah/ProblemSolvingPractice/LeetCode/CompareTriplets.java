package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareTriplets {
    public List<Integer> compareTriplets() {

        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> b = new ArrayList<>(Arrays.asList(3, 2, 1));

        List<Integer> returnList = new ArrayList<>();
        int n = a.size();
        for(int i=0;i <= n-1;i++){
            if (a.get(i)>b.get(i)){
                returnList.add(0, returnList.get(i)+1);
                System.out.println(i);
            }
        }

        return returnList;
    }
}
