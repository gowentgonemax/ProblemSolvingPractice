package com.home.shah.ProblemSolvingPractice.LeetCode;

import java.util.ArrayList;

public class AnaGram {
    public static void main(String[] args) {
        String s = " aacreet" ;
        String t = " aacreet" ;
        System.out.println(" Kabutar"  +isAnagram(s,t));

    }
    public static boolean isAnagram(String s, String t){
        if (s.length()!=t.length()){
            System.out.println(" ******* Length Check ******" );
            return false;
        }
        else{
            int [] charCount = new int[26];
            System.out.println(" Jaaa Kabutar: " +charCount[t.charAt(0)-'a']++);
            for (int i = 0; i < s.length(); i++) {
                charCount[s.charAt(i)-'a']++;
                charCount[t.charAt(i)-'a']--;
            }
            for (int count:charCount){
                if (count!=0){
                    return false;
                }
            }
        }
        return true;
    }
}
