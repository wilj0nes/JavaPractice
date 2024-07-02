package com.practice.challenges.singleChallengeClasses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    //22. Generate Parentheses
    //Medium
    //Topics
    //Companies
    //Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    //
    //
    //
    //Example 1:
    //
    //Input: n = 3
    //Output: ["((()))","(()())","(())()","()(())","()()()"]
    //Example 2:
    //
    //Input: n = 1
    //Output: ["()"]
    //
    //
    //Constraints:
    //
    //1 <= n <= 8
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        this.traverse("(", 1, 0, n, results);

        return results;
    }

    public void traverse(String str, int left, int right, int n, List<String> results) {

        // first check if the string is equal then check if malformed
        if (str.length() / 2 == n) {
            // str is even and both sides of str are "(" meaning it's already malformed
            results.add(str);
            return;
        }

        if (left < n) {
            this.traverse(str + "(", left + 1, right, n, results);
        }

        if (right < left && right < n) {
            this.traverse(str + ")", left, right + 1, n, results);
        }

    }


}
















