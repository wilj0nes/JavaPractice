package com.practice.leetcode;

import java.util.*;

public class Challenges {

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
//        int n;
//        n = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
//        System.out.println("profit (5):" + n);
//
//        n = maxProfit(new int[]{7, 6, 4, 3, 1});
//        System.out.println("profit (0):" + n);
//
//        n = maxProfit(new int[]{2, 4, 1});
//        System.out.println("profit (2):" + n);
//
//        n = maxProfit(new int[]{7, 6, 4, 3, 1});
//        System.out.println("profit (0):" + n);
//
//        n = maxProfit(new int[]{2, 1, 2, 0, 1});
//        System.out.println("profit (1):" + n);
//
//        n = maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2});
//        System.out.println("profit (2):" + n);
//
//        n = maxProfit(new int[]{1, 2});
//        System.out.println("profit (1):" + n);
//
//        n = maxProfit(new int[]{2, 1, 4});
//        System.out.println("profit (3):" + n);
//
//        n = maxProfit(new int[]{2,1,2,1,0,0,1});
//        System.out.println("profit (1):" + n);
//
//        n = maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
//        System.out.println("profit (4):" + n);

        callImprovedMaxProfit();
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

        for (int i = 0; i < prices.length; i++) {
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

    // Given a m x n grid filled with non-negative numbers,
    // find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    // Note: You can only move either down or right at any point in time.
    public int minPathSum(int[][] grid) { // TODO finish
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

}
