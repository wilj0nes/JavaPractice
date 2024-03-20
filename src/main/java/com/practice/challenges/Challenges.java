package com.practice.challenges;

import java.util.*;

public class Challenges {

    public int climbStairs_memoization(int n ) {
        int memo[] = new int[n + 1];
        return climb_memo(0, n, memo);
    }

    public int climb_memo(int i, int n, int memo[]) { // https://leetcode.com/problems/climbing-stairs/
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }

        // the result of each step is stored in the memo array
        // and returning result the result from array when fcn is called again
        // this way the recursion tree is reduced reducing runtime to O(n)
        memo[i] = climb_memo(i + 1, n, memo) + climb_memo(i + 2, n, memo);
        System.out.println(Arrays.toString(memo));

        System.out.println("returning: " + memo[i]);
        return memo[i];
    }
    // You are climbing a staircase. It takes n steps to reach to the top.
    //Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    public int climbStairs(int n) { // brute force solution | O(2^n) time complexity
        return climb( 0, n);
    }
    public int climb(int i, int n) {
        System.out.println("climb( " + i + ", " + n + " )");
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb(i + 1, n) + climb(i + 2, n);
    }


    public List<Integer> findDisappearedNumbers_improvedMemory(int[] nums) { // this works but leetcode is a cunt
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {        // 1 .. num.length
            for (int j = 0; j < nums.length; j++) {     // 0 .. num.length-1
                if (i == nums[j]) {
                    break;
                }
                else if (j == nums.length-1 && i != nums[j]) {
                    result.add(i);
                }
            }
        }

//        System.out.println(result);
        return result;
    }



    // Given a string s, return the longest palindromic substring in s.
    // A string is palindromic if it reads the same forward and backward.
    //    Input: s = "babad"
    //    Output: "bab"
    //    Explanation: "aba" is also a valid answer.
    public String longestPalindrome(String s) {
        return s;
    }

    public boolean isPal(String str) {
        String strReversed = new StringBuilder(str).reverse().toString();
        return str.equals(strReversed);
    }


    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", ""); // regex will remove everything that's NOT alphanumeric
        StringBuilder revStr = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            revStr.append(s.charAt(i));
        }

        return s.toUpperCase().equals(revStr.toString().toUpperCase());
    }



    // Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    // An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    // typically using all the original letters exactly once.
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> resultList = new ArrayList<>();
        if (strs.length == 1) {
            resultList.add(new ArrayList<>(Arrays.asList(strs[0])));
            return resultList;
        }

        HashMap<String, String> stringHash = new HashMap<>();
        for (String s : strs) {
            String[] arr = s.split("");
            Arrays.sort(arr);
            String sortedString = Arrays.toString(arr).replaceAll("[^a-z]", "");

            if (stringHash.get(sortedString) == null) {
                stringHash.put(sortedString, s);
            }
            else {
                String str = stringHash.get(sortedString);
                str += "/" + s;
                stringHash.put(sortedString, str);
            }
        }

        for (Map.Entry<String, String> entry : stringHash.entrySet()) {
            resultList.add(new ArrayList<>(Arrays.asList(entry.getValue().split("/"))));
        }

        System.out.println(resultList);
        return resultList;
    }


    // Given two strings s and t , write a function to determine if t is an anagram of s.
    public boolean isAnagram(String s, String t) {
        int length = 0;
        if (s.length() != t.length()) {
            return false;
        }
        else {
            length = s.length();
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (sMap.get(s.charAt(i)) == null) {
                sMap.put(s.charAt(i), 1);
            }
            else {
                int quantity = sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), ++quantity);
            }

            if (tMap.get(t.charAt(i)) == null) {
                tMap.put(t.charAt(i), 1);
            }
            else {
                int quantity = tMap.get(t.charAt(i));
                tMap.put(t.charAt(i), ++quantity);
            }
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
//            System.out.println(entry);
            if (tMap.get(entry.getKey()) == null) {
                return false;
            }
            else if (tMap.get(entry.getKey()) != null && !tMap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }

        return true;
    }


    public int improvedMaxArea(int[] height) { // not my solution
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right-left));
            if (height[left] < height[right]) {
                left++;
            }
            else {
                 right--;
            }
        }
        return maxArea;
    }


    public int maxArea(int[] height) {
        int widthVal;
        int maxArea = 0;
        int tempArea;

        for (int i = 0; i < height.length; i++) {
            System.out.println("i ==> height[" + i + "] = " + height[i]);

            for (int j = height.length-1; j > i; j--) {
                System.out.println("j ==> height[" + j + "] = " + height[j]);
                widthVal = j - i;
                System.out.println("widthVal: " + widthVal);
                tempArea = widthVal * Math.min(height[j], height[i]);
                System.out.println("tempArea: " + tempArea);

                if (tempArea > maxArea) {
                    maxArea = tempArea;
                    System.out.println("maxArea: " + maxArea);
                }
            }
        }

        return maxArea;
    }


    // Given an integer array nums, find the contiguous subarray (containing at least one number)
    // which has the largest sum and return its sum.
    // Follow up: If you have figured out the O(n) solution,
    // try coding another solution using the divide and conquer approach, which is more subtle.
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) { // <-- Kadane's algorithm
            currentSum = Math.max(0, currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }


    // Given an array nums of n integers where n > 1,
    // return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
    // Constraint: It's guaranteed that the product of the elements of any prefix
    // or suffix of the array (including the whole array) fits in a 32 bit integer.
    // Note: Please solve it without division and in O(n).
    public int[] productExceptSelf(int[] nums) { // not my solution
        int numsLength = nums.length;
        int[] result = new int[numsLength];
        int right = 1, left = 1;

        System.out.println(Arrays.toString(nums));
        Arrays.fill(result, 1);
        System.out.println(Arrays.toString(result));

        for (int i = 0; i < numsLength; i++) {
            result[i] *= left;
            System.out.println("result[i] * left ==> " + result[i] + " * " + left);
            left *= nums[i];
//            System.out.println("left is: " + left  + " * " + nums[i]);
        }
        System.out.println(Arrays.toString(result));

        for (int i = numsLength - 1; i >= 0; i--) {
            result[i] *= right;
            System.out.println("result[i] * right ==> " + result[i] + " * " + right);
            right *= nums[i];
//            System.out.println("right is: " + right + " * " + nums[i]);
        }

        return result;
    }




    // Say you have an array for which the ith element is the price of a given stock on day i.
    // If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock)
    // design an algorithm to find the maximum profit.

    public int betterMaxProfit(int[] prices) { // not my solution
        System.out.println("prices: " + Arrays.toString(prices));
        int lowest = Integer.MAX_VALUE;
        int currentProfit;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (lowest > prices[i]) {
                lowest = prices[i];
            }

            currentProfit = prices[i] - lowest;

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }

        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int buyVal = Integer.MAX_VALUE;
        int sellVal = 0;

        if (prices.length == 1) {
            return sellVal;
        }

        for (int i = 0; i < prices.length; i++) { // O(n^2)
            if (buyVal > prices[i]) {
                for (int j = i; j < prices.length; j++) { // check the future
                    if (prices[j] - prices[i] > sellVal - buyVal) {
                        buyVal = prices[i];
                        sellVal = prices[j];
                        break;
                    }
                }
            }
            else if (sellVal < prices[i]) {
                sellVal = prices[i];
            }
        }
        System.out.println("buyVal: " + buyVal);
        System.out.println("sellVal: " + sellVal);

        if (sellVal == 0 || buyVal > sellVal) {
            return 0;
        }

        return sellVal - buyVal;
    }


    // 1. Two Sum
    // Given an array of integers nums and integer target,
    // return the indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.

    public int[] twoSumWithBetterRunTime(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) != null) {
                int hashNum = hashMap.get(nums[i]);

                if (nums[i] + nums[hashNum] == target && i != hashNum) {
                    result[0] = i;
                    result[1] = hashNum;
                    return result;
                }
            }
        }

        return result;
    }


    // Given an m x n grid filled with non-negative numbers,
    // find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    // Note: You can only move either down or right at any point in time.
    public int minPathSum(int[][] grid) { // TODO investigate further
        System.out.println(Arrays.deepToString(grid));
        for(int i = 1; i < grid.length; i++) {
            System.out.println("-- > " + Arrays.toString(grid[i]));
            grid[i][0] = grid[i-1][0] + grid[i][0];
            System.out.println(grid[i-1][0] + " + " + grid[i][0]);
        }
        System.out.println(Arrays.deepToString(grid));
        for(int j = 1; j < grid[0].length; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }

        System.out.println(Arrays.deepToString(grid));
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return grid[grid.length-1][grid[0].length-1];

    }


    // You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    // You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
    // DO NOT allocate another 2D matrix and do the rotation

    // Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    // Output: [[7,4,1],[8,5,2],[9,6,3]]

    // Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

    public int[][] rotate(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        else if (matrix.length == 1) {
            return matrix;
        }

        for (int i = 0; i < matrix.length; i++) { // transpose matrix
            for (int j = 0; j < matrix[i].length; j++) {
                if (j >= i) {
                    System.out.print(matrix[i][j] + " <--> " + matrix[j][i] + "\t\t\t" + "i:" + i + ", j:" + j  + "\n");
                    int x = matrix[i][j];
                    int y = matrix[j][i];
                    matrix[i][j] = y;
                    matrix[j][i] = x;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) { // reverse each sub array
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;
            }
        }
        return matrix;
    }

    public int reverse(int x) {
        long reverseNum=0;
        do {
            long remainder = x % 10;
            x = x/10;
            reverseNum = reverseNum*10 + remainder;
        }
        while (x!=0);

        if (reverseNum >= Integer.MIN_VALUE && reverseNum <= Integer.MAX_VALUE) {
            return (int) reverseNum;
        }
        return 0;
    }


    // Given a 32-bit signed integer, reverse digits of an integer.
    public int reverseInteger(int x) { // finished but has shit test cases on leetCode, so fuck you close enough
        System.out.println("reverseInteger( " + x + " )");

        String str = String.valueOf(x);
        if (str.length() == 1) {
            return x;
        }

        char[] charArray = str.toCharArray();
        String newStr = "";

        for (int i = charArray.length - 1; i >= 0; i--) {
            newStr = newStr + ""+charArray[i];
        }

        if (newStr.contains("-")) {
            newStr = newStr.replaceAll("-", "");
            newStr = "-" + newStr;
        }

        return Integer.parseInt(newStr);
    }

    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach((row) -> {
            System.out.print("[");
            Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
            System.out.println("]");
        });
    }

}


