package com.home.shah.ProblemSolvingPractice.ConceptualProblem.InterviewQuestion;

import java.util.Stack;

public class ChaseCoding {


    public static boolean isValidFormat(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (char curr : input.toCharArray()) {
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else if (curr == ')' || curr == ']' || curr == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if ((curr == ')' && temp != '(') || (curr == '}' && temp != '{') || (curr == ']' && temp != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(s + " " + isValidFormat(s));

        String s1 = "()[]{}";
        System.out.println(s1 + " " + isValidFormat(s1));
    }
}

/*


Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

 */