package com.practice.challenges;

import java.util.*;

public class StringChallenges {


    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if (s.length() == 1) {
            return 0;
        }
        else if (arr.length == 0 || arr.length == 1) {
            return s.length();
        }

        return arr[arr.length-1].length();
    }


    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.
    public boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}") ||
                s.endsWith("(") || s.endsWith("[") || s.endsWith("{")) {

            return false;
        }
        if (!(s.length() % 2 == 0)) {
            return false;
        }

        String str = removeProperty(s);
        if (str.length() > 0) {
            return false;
        }
        return true;
    }

    public String removeProperty(String str) {
        System.out.println("Calling... removeProperty: " + str);
        ArrayList<String> openerList = new ArrayList<>(Arrays.asList("(", "[", "{"));
        ArrayList<String> closerList = new ArrayList<>(Arrays.asList(")", "]", "}"));

        String[] arr = str.split("");

        for (int i = 0; i < arr.length-1; i++) {
            if (openerList.indexOf(arr[i]) == closerList.indexOf(arr[i+1]) && openerList.indexOf(arr[i]) > -1 && closerList.indexOf(arr[i+1]) > -1) {
                str = str.replace(arr[i]+arr[i+1], "");
                return removeProperty(str);
            }
        }
        return str;
    }


    // 392. Is Subsequence
    // Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    //
    // A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
    // of the characters without disturbing the relative positions of the remaining characters.
    // (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
    //
    // Example 1:
    //
    // Input: s = "abc", t = "ahbgdc"
    // Output: true

    // Example 2:
    //
    // Input: s = "axc", t = "ahbgdc"
    // Output: false

    // Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
    // and you want to check one by one to see if t has its subsequence.
    // In this scenario, how would you change your code?

    public boolean isSubsequence(String s, String t) {
        Stack<Character> stack = new Stack<>(); // O(n) space complexity
        for (int i = s.length()-1; i >= 0; i--) {
            stack.push(s.charAt(i)); // insert s chars in reverse
        }

        for (int i = 0; i < t.length(); i++) {
            if (!stack.isEmpty() && stack.peek().equals(t.charAt(i))) {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public boolean isSubsequence_withPointers(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        else if (s.isEmpty()) {
            return true;
        }

        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }


    // 844. Backspace String Compare
    // Given two strings s and t, return true if they are equal when both are typed into empty text editors.
    // '#' means a backspace character.
    //
    // Note that after backspacing an empty text, the text will continue empty.
    //
    // Example 1:
    //
    // Input: s = "ab#c", t = "ad#c"
    // Output: true
    // Explanation: Both s and t become "ac".
    // Example 2:
    //
    // Input: s = "ab##", t = "c#d#"
    // Output: true
    // Explanation: Both s and t become "".
    // Example 3:
    //
    // Input: s = "a#c", t = "b"
    // Output: false
    // Explanation: s becomes "c" while t becomes "b".

    // Follow up: Can you solve it in O(n) time and O(1) space?
    public boolean backSpaceCompare(String s, String t) {
        return this.delComparer(s).equals(this.delComparer(t));
    }

    public Stack<Character> delComparer(String s) {
        Stack<Character> stack = new Stack<Character>();
        //  ^ O(n) space complexity

        int delsFound = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#' && delsFound == 0) {
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == '#') {
                stack = this.stackPopper(stack, delsFound);
                delsFound = 0;
            }
            else {
                delsFound++;
            }
        }

        return stack;
    }

    private Stack<Character> stackPopper(Stack<Character> stack, int dels) {
        for (int i = 0; i <= dels; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack;
    }

}
