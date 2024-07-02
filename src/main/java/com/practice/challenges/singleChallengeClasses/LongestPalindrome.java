package com.practice.challenges.singleChallengeClasses;

import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPalindrome {

    // 5. Longest Palindromic Substring
    // Medium
    // Topics
    // Companies
    // Hint
    // Given a string s, return the longest
    // palindromic
    // substring in String s.
    //
    //
    //
    // Example 1:
    //
    // Input: s = "babad"
    // Output: "bab"
    // Explanation: "aba" is also a valid answer.
    // Example 2:
    //
    // Input: s = "cbbd"
    // Output: "bb"
    //
    //
    // Constraints:
    //
    // 1 <= s.length <= 1000
    // s consist of only digits and English letters.

    public String longestPalindrome(String s) {
        String result = "";
        List<String> listStr = new ArrayList<>(Arrays.asList(s.split("")));

        for (int i = 0; i < s.length(); i++) {
            String sub = this.traverseString(i, "", s);
            if (sub.length() > result.length()) {
                result = sub;
            }
        }

        return result;
    }

    public String traverseString(int index, String subString, String inputString) {

        String reverse = new StringBuilder(subString).reverse().toString();

        if (subString.equals(reverse) && index+1 == inputString.length()) {
            return subString;
        }
        else if (subString.equals(reverse)) {
            return subst)
        }

    }



}


