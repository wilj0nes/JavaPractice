package com.practice.other;

import java.util.*;

public class Other { // challenges that were presented in interviews


    // Get the String representation of array
//    Arrays.toString(arr);





    public void callLengthOfLongestSubstring() {
        int n;
        n = lengthOfLongestSubstring("abcabcbb"); // 'abc' is the longest substring return 3
        System.out.println("answer: " +n + " -- 3");
        n = lengthOfLongestSubstring("");
        System.out.println("answer: " +n + " -- 0");
        n = lengthOfLongestSubstring(" ");
        System.out.println("answer: " +n + " -- 1");
        n = lengthOfLongestSubstring("au");
        System.out.println("answer: " +n + " -- 2");
        n = lengthOfLongestSubstring("bbbbb"); // 1
        System.out.println("answer: " +n + " -- 1");
        n = lengthOfLongestSubstring("dvdf"); // 3
        System.out.println("answer: " +n + " -- 3");
        n = lengthOfLongestSubstring("pwwkew"); // 3
        System.out.println("answer: " +n + " -- 3");
    }

    // Given a string s, find the length of the longest substring without repeating characters.
    public int lengthOfLongestSubstring(String s) {
        System.out.println("input: " + s);
        int bigLength = 0;
        if (s.length() == 1) {
            return 1;
        }
        else if (s.equals("")) {
            return 0;
        }

        char[] arr = s.toCharArray();

        StringBuilder str = new StringBuilder();
        for (char c: arr) {
            if (str.toString().contains(""+c)) {
                if (str.length() > bigLength) {
                    bigLength = str.length();
                    System.out.println("biggest: " + bigLength);
                }
                str = new StringBuilder();
                str.append(c);
            }
            else {
                str.append(c);
                System.out.println("str: " + str);
            }
        }



        return bigLength;
    }


    public static List<Integer> cellCompete(int[] states, int days){
        System.out.println("cellComplete()");
        // WRITE YOUR CODE HERE

        List<Integer> newStates = new ArrayList<>(states.length);

        for (int i = 0; i < states.length; i++) {

            if (i == 0 && states[1] == 0) {
                newStates.add(i, 0);
            }
            else if (i == 0 && states[1] == 1) {
                newStates.add(i, 1);
            }
            else if (i == states.length-1 && states[i-1] == 0) {
                newStates.add(i, 0);
            }
            else if (i == states.length-1 && states[i-1] == 1) {
                newStates.add(i, 1);
            }
            else if (states[i-1] == states[i+1]) {
                newStates.add(i, 0);
            }
            else if (states[i-1] != states[i+1]) {
                newStates.add(i, 1);
            }
        }
        days--;
        if (days == 0) {
            return newStates;
        }
        else {
            int[] arr = new int[newStates.size()];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = newStates.get(i);
            }
            return cellCompete(arr, days);
        }
    }

    public static void callRearrangeWord() {
        System.out.println("abc --> " + rearrangeWord("abc")); // bcaa
//        System.out.println("baca --> " + rearrangeWord("baca")); // bcaa
//        System.out.println("hefg --> " + rearrangeWord("hefg")); // hegf
    }

    // JPMorgan Chase interview question

    // Given word, return the next alphabetically greateer string in all permutations of that word. if there is no greater permutation
    // return the string "no asnwer" instead
    //The string 'baca' has the following permutations in alphabetical order:
    // 'aabc', 'aacb; 'abac' 'abca', 'acab', 'acha', 'baac' 'baca', 'bcaa', caab' 'caba', and 'cbaa'
    // The next alphabetically greater permutation of the original string is 'baa:

    public static Map<String, Integer> map = new TreeMap<>();
    public static String rearrangeWord(String word) {

        int length = word.length();
        permute(word, 0, length - 1);
        System.out.println(map.toString());

        boolean found = false;

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getKey().equals(word)) {
                found = true;
            }
            else if (found) {
                map = new TreeMap<>();
                return entry.getKey();
            }
        }


        return null;
    }

    public static void permute(String str, int start, int end) {

        if (start == end) {
            System.out.println(">> " + str);
            map.put(str, null);
        }
        else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                permute(str, start + 1, end);
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char tempChar;
        char[] charArr = str.toCharArray();

        System.out.println("swap: " + charArr[i] + " <--> " + charArr[j]);

        tempChar = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = tempChar;

        return String.valueOf(charArr);
    }
}




























