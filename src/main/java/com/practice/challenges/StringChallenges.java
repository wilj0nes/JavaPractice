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



    // 784. Letter Case Permutation
    // Medium
    // Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
    //
    // Return a list of all possible strings we could create. Return the output in any order.
    //
    // Example 1:
    //
    // Input: s = "a1b2"
    // Output: ["a1b2","a1B2","A1b2","A1B2"]

    // Example 2:
    //
    // Input: s = "3z4"
    // Output: ["3z4","3Z4"]
    //
    // Constraints:
    // 1 <= s.length <= 12
    // s consists of lowercase English letters, uppercase English letters, and digits.
    // backtracking example
    public List<String> letterCasePermutation(String s) { // not my solution
        List<String> resultList = new ArrayList<>();
        this.recurse(s.toCharArray(), 0, resultList);

        return resultList;
    }

    public void recurse(char[] str, int index, List<String> result) {
        if (index == str.length) { // leaf found
            result.add(new String(str));
            return;
        }

        if (Character.isLetter(str[index])) {
            if (Character.isUpperCase(str[index])) { // if uppercase make it lowercase that recurse
                str[index] = Character.toLowerCase(str[index]);

                // start new branch in tree,
                this.recurse(str, index + 1, result);

                // backtracking, undo the change so the code can start a new branch in the recursion tree.
                str[index] = Character.toUpperCase(str[index]);
            }
            else { // else make it uppercase
                str[index] = Character.toUpperCase(str[index]);
                this.recurse(str, index + 1, result);

                // backtracking again for same reason
                str[index] = Character.toLowerCase(str[index]);
            }
        }
        // this branch explores options that are possible
        this.recurse(str, index + 1, result);
    }

    public List<String> letterCasePermutation_attempt(String s) { // failed attempt
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        Set<String> resultSet = new HashSet<>();
        List<String> resultList = new ArrayList<>();

        s = s.toLowerCase();
        resultSet.add(s);
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                String x = this.convertCharArray(charArray, i, Character.toUpperCase(charArray[i]));
                resultSet.add(x);
                resultList.add(x);
            }
        }
        s = s.toUpperCase();
        resultSet.add(s);
        charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                String x = this.convertCharArray(charArray, i, Character.toLowerCase(charArray[i]));
                resultSet.add(x);
                resultList.add(x);
            }
        }

        return new ArrayList<>(resultSet);
    }

    public String convertCharArray(char[] charArray, int index, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (i != index) {
                sb.append(charArray[i]);
            }
            else {
                sb.append(ch);
            }
        }

        return sb.toString();
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
