package com.practice.leetcode;

import java.util.*;

public class Challenges {

    public void callClimbStairs() { // https://leetcode.com/problems/climbing-stairs/
        int n;
        n = climbStairs(2);
        System.out.println("result (2):" + n);
        n = climbStairs(3);
        System.out.println("result (3):" + n);
        n = climbStairs(5);
        System.out.println("result (8):" + n);


        n = climbStairs_memoization(2);
        System.out.println("result (2):" + n);
        n = climbStairs_memoization(3);
        System.out.println("result (3):" + n);
        n = climbStairs_memoization(5);
        System.out.println("result (8):" + n);
    }

    public int climbStairs_memoization(int n ) {
        int memo[] = new int[n + 1];
        return climb_memo(0, n, memo);
    }

    public int climb_memo(int i, int n, int memo[]) {
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


    public void callSetZeros() {
        int[][] matrix = new int[3][];
        int[] ar1, ar2, ar3;

        ar1 = new int[]{1, 1, 1};
        ar2 = new int[]{1, 0, 1};
        ar3 = new int[]{1, 1, 1};
        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;
        setZeros(matrix);

        matrix = new int[3][];
        ar1 = new int[]{0, 1, 2, 0};
        ar2 = new int[]{3, 4, 5, 2};
        ar3 = new int[]{1, 3, 1, 5};
        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;
        setZeros(matrix);

    }

    // Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    public void setZeros(int[][] matrix) {
        HashMap<Integer, Integer> hashCols = new HashMap<>();

        boolean zeroFound;
        for (int i = 0; i < matrix.length; i++) {
            zeroFound = false;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    hashCols.put(j, i); // keep track of j, the column value
                    zeroFound = true;
                }
            }

            if (zeroFound) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (hashCols.get(j) != null) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void callLongestPalindrome() {
        String str = "babad";
        System.out.println(str + " longest palindrome --> " + longestPalindrome(str));
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


    public void callIsPalendrome() {
        System.out.println("A man, a plan, a canal: Panama --> " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("race a car --> " + isPalindrome("race a car"));
        System.out.println("racecar --> " + isPalindrome("racecar"));
        System.out.println("0P --> " + isPalindrome("0P"));
    }

    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        StringBuilder revStr = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            revStr.append(s.charAt(i));
        }

        return s.toUpperCase().equals(revStr.toString().toUpperCase());
    }


    public void callGroupAnagrams() {
        String[] arr = new String[]{"eat","tea","tan","ate","nat","bat"}; // [[eat, tea, ate], [bat], [tan, nat]]
        System.out.println(groupAnagrams(arr));
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

        return resultList;
    }


    public void callIsAnagram() {
        System.out.println("anagram --> nagaram : " + isAnagram("anagram", "nagaram"));
        System.out.println("rat --> car : " + isAnagram("rat", "car"));
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
            System.out.println(entry);
            if (tMap.get(entry.getKey()) == null) {
                return false;
            }
            else if (tMap.get(entry.getKey()) != null && !tMap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    public void callImprovedMaxArea() {
        int[] arr;
        arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("result (49):" + improvedMaxArea(arr));

        arr = new int[]{4, 3, 2, 1, 4};
        System.out.println("result (16):" + improvedMaxArea(arr));
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

    public void callMaxArea() {
        int[] arr;
        arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("result (49):" + maxArea(arr));

        arr = new int[]{4, 3, 2, 1, 4};
        System.out.println("result (16):" + maxArea(arr));


        arr = new int[]{1, 1};
        System.out.println("result (1):" + maxArea(arr));

        arr = new int[]{1, 2, 1};
        System.out.println("result (2):" + maxArea(arr));
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

    public void callMaxSubArray() {
        int n;
        n = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("Output (6):" + n);

        n = maxSubArray(new int[]{1});
        System.out.println("Output (1):" + n);
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

    public void callProductExceptSelf() {
        int[] arr;
        arr = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(arr));
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


    public void callContainsDuplicate() {
        boolean bool;
        bool = containsDuplicate(new int[]{1, 2, 3, 1});
        System.out.println("output: " + bool);
    }

    // Given an array of integers, find if the array contains any duplicates.
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) != null) {
                return true;
            }
            else {
                hashMap.put(nums[i], i);
            }
        }
        return false;
    }

    public void callMaxProfit() {
        int n;
        n = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("profit (5):" + n);

        n = maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println("profit (0):" + n);

        n = maxProfit(new int[]{2, 4, 1});
        System.out.println("profit (2):" + n);

        n = maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println("profit (0):" + n);

        n = maxProfit(new int[]{2, 1, 2, 0, 1});
        System.out.println("profit (1):" + n);

        n = maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2});
        System.out.println("profit (2):" + n);

        n = maxProfit(new int[]{1, 2});
        System.out.println("profit (1):" + n);

        n = maxProfit(new int[]{2, 1, 4});
        System.out.println("profit (3):" + n);

        n = maxProfit(new int[]{2,1,2,1,0,0,1});
        System.out.println("profit (1):" + n);

        n = maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println("profit (4):" + n);

    }

    // Say you have an array for which the ith element is the price of a given stock on day i.
    // If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock)
    // design an algorithm to find the maximum profit.
    public int maxProfit(int[] prices) {
        System.out.println(Arrays.toString(prices));
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

    public void callImprovedMaxProfit() {
        int n;
        n = improvedMaxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("profit (5):" + n);

        n = improvedMaxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println("profit (0):" + n);

        n = improvedMaxProfit(new int[]{2, 4, 1});
        System.out.println("profit (2):" + n);

        n = improvedMaxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println("profit (0):" + n);

        n = improvedMaxProfit(new int[]{2, 1, 2, 0, 1});
        System.out.println("profit (1):" + n);

        n = improvedMaxProfit(new int[]{2, 1, 2, 1, 0, 1, 2});
        System.out.println("profit (2):" + n);

        n = improvedMaxProfit(new int[]{1, 2});
        System.out.println("profit (1):" + n);

        n = improvedMaxProfit(new int[]{2, 1, 4});
        System.out.println("profit (3):" + n);

        n = improvedMaxProfit(new int[]{2,1,2,1,0,0,1});
        System.out.println("profit (1):" + n);

        n = improvedMaxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println("profit (4):" + n);
    }

    public int improvedMaxProfit(int[] prices) { // not my solution
        System.out.println(Arrays.toString(prices));
        int answer = 0;
        if (prices.length == 0) {
            return answer;
        }
        int bought = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > bought) {
                if (answer < (prices[i] - bought)) {
                    answer = prices[i] - bought;
                }
            }
            else {
                bought = prices[i];
            }
        }
        return answer;

    }

    public void callMinPathSum() {
        int[][] grid = new int[3][];
        int[] ar1 = new int[]{1,3,1};
        int[] ar2 = new int[]{1,5,1};
        int[] ar3 = new int[]{4,2,1};
        grid[0] = ar1;
        grid[1] = ar2;
        grid[2] = ar3;
        System.out.println(minPathSum(grid));
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

    public void callConvert() {
        System.out.println("PAYPALISHIRING --> " + convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
    }


    //The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
    //      like this: (you may want to display this pattern in a fixed font for better legibility)
    // P   A   H   N
    // A P L S I I G
    // Y   I   R
    public String convert(String s, int numRows) {

        String[][] stringMatrix = new String[s.length() / 2][numRows-1];

        return null;
    }

    public void callRotate() {
        int[][] matrix = new int[3][];
        int[] ar1, ar2, ar3;

        ar1 = new int[]{1, 2, 3};
        ar2 = new int[]{4, 5, 6};
        ar3 = new int[]{7, 8, 9};
        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;

        printMatrix(matrix);
        System.out.println("\n");
        printMatrix(rotate(matrix));

        int[][] bigMatrix = new int[4][];
        bigMatrix[0] = new int[]{5, 1, 9, 11};
        bigMatrix[1] = new int[]{2, 4, 8, 10};
        bigMatrix[2] = new int[]{13, 3, 6, 7};
        bigMatrix[3] = new int[]{15, 14, 12, 16};

        System.out.println("\n");

        printMatrix(bigMatrix);
        System.out.println("\n");
        printMatrix(rotate(bigMatrix));
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

    public void callIntToRoman() {
//        System.out.println("Input: 3000 --> " + intToRoman(3000)); // MMM
//        System.out.println("Input: 1994 --> " + intToRoman(1994)); // MCMXCIV
//        System.out.println("Input: 9 --> " + intToRoman(9)); // IX
//        System.out.println("Input: 8 --> " + intToRoman(8)); // IX
//        System.out.println("Input: 7 --> " + intToRoman(7)); //
//        System.out.println("Input: 58 --> " + intToRoman(58)); // LVIII
        System.out.println("Input: 99 --> " + intToRoman(99)); // MDCCCXCIV
    }

    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    //    Symbol       Value
    //    I             1
    //    V             5
    //    X             10
    //    L             50
    //    C             100
    //    D             500
    //    M             1000

    //    For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
    //    The number 27 is written as XXVII, which is XX + V + II.

    //    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
    //    Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
    //    The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    //    I can be placed before V (5) and X (10) to make 4 and 9.
    //    X can be placed before L (50) and C (100) to make 40 and 90.
    //    C can be placed before D (500) and M (1000) to make 400 and 900.
    //    Constraints: 1 <= num <= 3999

    public String intToRoman(int num) { // not finished
        int numHolder = num;
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new LinkedHashMap<>(); // preserves the insertion order
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);

        while (num > 0) {
            int tempNum = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (num >= entry.getValue() && num >= num - entry.getValue()) {
                    answer.append(entry.getKey());
                    num = num - entry.getValue();
                    System.out.println("num: " + num + ", answer: " + answer);
                    break;
                }
            }
        }

        System.out.println("answer: " + answer.toString());
        String str = answer.toString();
        if (numHolder < 10) {
            str = str.replace("VIIII", "IX");
        }
        else {
            str = str.replace("DCCCC", "CM").replace("LXXXX", "XC").replace("IIII", "IV");
        }
        return str;
    }

    public void callSingleNumber() {
        System.out.println("[2,2,1] : " + singleNumber(new int[]{2, 2, 1})); // 1
        System.out.println("[4,1,2,1,2] : " + singleNumber(new int[]{4,1,2,1,2})); // 4
        System.out.println("[1,1,2,3,3,4] : " + singleNumber(new int[]{1,1,3,3,4})); //
        // somehow XOR bitwise operations on each element magically returns the fucking solution
    }

    // 136. Single Number

    // Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    // You must implement a solution with a linear runtime complexity and use only constant extra space.
    // Example 1:
    //
    //Input: nums = [2,2,1]
    //Output: 1
    //Example 2:
    //
    //Input: nums = [4,1,2,1,2]
    //Output: 4
    //Example 3:
    //
    //Input: nums = [1]
    //Output: 1

    public int singleNumber(int[] nums) { // not my solution
        int answer = nums[0];

        int i = 0;

        while (i < nums.length - 1) {
            int n = nums[i + 1];
            answer = answer ^ n; // XOR bit manipulation
            i++;
        }

        return answer;
    }

    public void callMissingNumber() {
        System.out.println("[3,0,1] : " + missingNumber(new int[]{3,0,1})); // 2
        System.out.println("[9,6,4,2,3,5,7,0,1] : " + missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); // 8

    }

    // 268. Missing Number
    // Given an array nums containing n distinct numbers in the range [0, n],
    // return the only number in the range that is missing from the array.
    // Input: nums = [3,0,1]
    // Output: 2
    // Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
    // 2 is the missing number in the range since it does not appear in nums.

    public int missingNumber(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            count = count - nums[i];
            count = count + i+1;

        }

        return count;
    }

    public void callRunningSum() {
        int[] arr;
        arr = runningSum(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(arr));
        arr = runningSum(new int[]{1,1,1,1,1});
        System.out.println(Arrays.toString(arr));
        arr = runningSum(new int[]{3,1,2,10,1});
        System.out.println(Arrays.toString(arr));
    }

    // Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    // Return the running sum of nums.
    // Input: nums = [1,2,3,4]
    // Output: [1,3,6,10]
    // Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
    public int[] runningSum(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                resultArr[i] = nums[i];
            }
            else {
                int temp = 0;
                for (int j = 0; j <= i; j++) {
                    temp += nums[j];
                }
//                System.out.println("temp: " + temp);
                resultArr[i] = temp;
            }
        }
        return resultArr;
    }

    public void callNumIdenticalPairs() {
        int n;
        n = numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3});
        System.out.println("pairCount: " + n);
        n = numIdenticalPairs(new int[]{1,1,1,1});
        System.out.println("pairCount: " + n);
        n = numIdenticalPairs(new int[]{1,2,3});
        System.out.println("pairCount: " + n);
    }

    // Given an array of integers nums.
    // A pair (i,j) is called good if nums[i] == nums[j] and i < j.
    // Return the number of good pairs.
    public int numIdenticalPairs(int[] nums) {
        int pairCount = 0;
        if (nums.length < 2) {
            return pairCount;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    pairCount++;
                }
            }
        }
        return pairCount;
    }


    public void callPermute() {
        int[] intArr;
        intArr = new int[]{1,2,3};
        System.out.println(permute(intArr));
        //  [1,2,3],
        //  [1,3,2],
        //  [2,1,3],
        //  [2,3,1],
        //  [3,1,2],
        //  [3,2,1]

//        intArr = new int[] {1,2,3,4};
//        System.out.println(permute(intArr));
    }

    // Given a collection of distinct integers, return all possible permutations.
    public List<List<Integer>> permute(int[] nums) { // TODO investigate further
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> finalResult = new ArrayList<>();
        permuteRecur(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
        return finalResult;
    } // not my solution

    private void permuteRecur(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {
        System.out.println("currResult: " + currResult);
        System.out.println("used: " + Arrays.toString(used));
        System.out.println("nums: " + Arrays.toString(nums) + " \n");

        System.out.println(finalResult.get(0).get(0));

        if (currResult.size() == nums.length) {
            finalResult.add(new ArrayList<>(currResult));
            System.out.println("finalResult: " + finalResult);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // go to next iteration
            }
            currResult.add(nums[i]);
            used[i] = true;
            permuteRecur(nums, finalResult, currResult, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
        System.out.println("----------------------------------------------");
    }

    public void callMergeTwoLists() { }

    // Merge two sorted linked lists and return it as a new sorted list.
    // The new list should be made by splicing together the nodes of the first two lists.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { //TODO: finish
        return null;
    }

    public void callLengthOfLastWord() {
        int answer;
        answer = lengthOfLastWord("Hello world");
        System.out.println("length of last word: " + answer);
        answer = lengthOfLastWord("     ");
        System.out.println("length of last word: " + answer);
    }

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

    public void callIsValid() {
        System.out.println("() --> " + isValid("()")); // true
        System.out.println(")) --> " + isValid("))")); // false
        System.out.println("()) --> " + isValid("())")); // false
        System.out.println("()[]{} --> " + isValid("()[]{}")); // true
        System.out.println("([)] --> " + isValid("([)]")); // false
        System.out.println("{ { ( { } ) } } --> " + isValid("{{({})}}")); // true
        System.out.println("[ --> " + isValid("[")); // false
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


    public void callReverseInteger() {
        long x;
        x = reverseInteger(123); // output: 321
        System.out.println("reversed int: " + x);

        x = reverseInteger(-123); // output: 321
        System.out.println("reversed int: " + x);

        // 9,646,324,351 --> 1,534,236,469
//        x = reverse(9646324351); // 9646324351 --> 1534236469

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


    public void callLetterCombinations() { // TODO: finish
        List<String> str;
        str = letterCombinations("23"); //Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        System.out.println("answer: " + str);

        str = letterCombinations("234"); // ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
        System.out.println("answer: " + str);
    }

    //    Given a string containing digits from 2-9 inclusive,
    //    return all possible letter combinations that the number could represent.
    public List<String> letterCombinations(String digits) {
        System.out.println("Calling... letterCombinations( " + digits + " )");
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        hashMap.put(2, new ArrayList(Arrays.asList("a", "b", "c")));
        hashMap.put(3, new ArrayList(Arrays.asList("d", "e", "f")));
        hashMap.put(4, new ArrayList(Arrays.asList("g", "h","i")));
        hashMap.put(5, new ArrayList(Arrays.asList("j", "k","l")));
        hashMap.put(6, new ArrayList(Arrays.asList("m", "n", "o")));
        hashMap.put(7, new ArrayList(Arrays.asList("p", "q", "r", "s")));
        hashMap.put(8, new ArrayList(Arrays.asList("t", "u", "v")));
        hashMap.put(9, new ArrayList(Arrays.asList("w", "x", "y", "z")));

        ArrayList<String> firstLetterList = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();

        if (digits == null || digits.equals("") || digits.equals(" ")) {
            return answer;
        }
        else if (digits.length() == 1) {
            return hashMap.get(Integer.parseInt(digits));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            nums.add(Integer.parseInt(""+digits.charAt(i)));
        }

        firstLetterList.addAll(hashMap.get(nums.get(0)));
        nums.remove(nums.get(0));



        for (Integer i : nums) { // "2", "3"
            System.out.println(hashMap.get(i));
            for (String firstChar : firstLetterList) { // [a, b, c]

                for (String str : hashMap.get(i)) {
                    System.out.println(firstChar + " + " + str);
//                    answer.add(tempStr + str);

                    if (answer.size() > 0) {
                        answer.add(firstChar + str);

                        for (String ans : answer) {
                            if (!ans.contains(str) && ans.length() < digits.length()) {
                                System.out.println("ans : " + ans + " + " + str);
//                                answer.get(answer.indexOf(ans))
                                answer.set(answer.indexOf(ans), ans + str);
                            }
                            else {
                                // check "str" in each "ans"
//                                System.out.println(" -->" + firstChar + str);
//                                for ()
                            }
                        }

                    }
                    else {
                        answer.add(firstChar + str);
                    }
                    System.out.println(answer);
                }
            }
        }

        return answer;
    }

    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach((row) -> {
            System.out.print("[");
            Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
            System.out.println("]");
        });
    }

}











