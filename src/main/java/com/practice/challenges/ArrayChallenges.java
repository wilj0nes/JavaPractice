package com.practice.challenges;

import javax.print.DocFlavor;
import java.util.*;

public class ArrayChallenges {

    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach((row) -> {
            System.out.print("[");
            Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
            System.out.println("]");
        });
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
                resultArr[i] = temp;
            }
        }
        return resultArr;
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


    // 448. Find All Numbers Disappeared in an Array
    // Given an array nums of n integers where nums[i] is in the range [1, n],
    // return an array of all the integers in the range [1, n] that do not appear in nums

    //Example 1:
    //
    //Input: nums = [4,3,2,7,8,2,3,1]
    //Output: [5,6]

    //Example 2:
    //
    //Input: nums = [1,1]
    //Output: [2]

    // Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>(); // adds space complexity
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 1; i <= length; i++) {
            if (hashMap.get(i) == null) {
                result.add(i);
            }
        }

//        System.out.println(result);
        return result;
    }


    public List<Integer> findDisappearedNumbers_improvedMemory2(int[] nums) { // not my solution
        List<Integer> result = new ArrayList<>();
        int index = 0;

        while (index < nums.length) {
            int correct = nums[index] - 1;

            if (nums[index] != nums[correct]) {
                int temp = nums[index];
                nums[index] = nums[correct];
                nums[correct] = temp;
            }
            else {
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) { // check if vals are in sequental order
                result.add(i + 1);
            }
        }

        return result;
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





    // 704. Binary Search
    // Given an array of integers nums which is sorted in ascending order, and an integer target,
    // write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
    // You must write an algorithm with O(log n) runtime complexity.

    //Example 1:
    //Input: nums = [-1,0,3,5,9,12], target = 9
    //Output: 4
    //Explanation: 9 exists in nums and its index is 4

    //Example 2:
    //Input: nums = [-1,0,3,5,9,12], target = 2
    //Output: -1
    //Explanation: 2 does not exist in nums so return -1

    public int search(int[] nums, int target) {
        // // O(n) runtime, it wants O(log n)
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
        int low = 0;
        int high = nums.length - 1;

        return binarySearch(nums, low, high, target);
    }

    public int binarySearch(int[] nums, int low, int high, int target) { // not my solution
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        else if (target > nums[mid]) {
            return binarySearch(nums, mid+1, high, target);
        }
        else {
            return binarySearch(nums, low, mid-1, target);
        }
    }

    // 744. Find Smallest Letter Greater Than Target
    // You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
    // There are at least two different characters in letters.
    // Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist,
    // return the first character in letters.

    // Example 1:
    // Input: letters = ["c","f","j"], target = "a"
    // Output: "c"
    // Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

    // Example 2:
    // Input: letters = ["c","f","j"], target = "c"
    // Output: "f"
    // Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

    // Example 3:
    // Input: letters = ["x","x","y","y"], target = "z"
    // Output: "x"
    // Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
    public char nextGreatestLetter(char[] letters, char target) {
        char result = 'z';
        boolean found = false;

        for (char c: letters) {
            if (c > target && c <= result) {
                result = c;
                found = true;
            }
        }

        if (!found) {
            return letters[0];
        }
        return result;
    }

    public char nextGreatestLetter_binarySearch(char[] letters, char target) { // not my solution
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return letters[start % letters.length];
    }

    // 338. Counting Bits
    // Given an integer n, return an array and of length n + 1 such that for each i (0 <= i <= n),
    // ans[i] is the number of 1's in the binary representation of i.

    // Example 1:
    //
    // Input: n = 2
    // Output: [0,1,1]
    // Explanation:
    // 0 --> 0
    // 1 --> 1
    // 2 --> 10

    // Example 2:
    //
    // Input: n = 5
    // Output: [0,1,1,2,1,2]
    // Explanation:
    // 0 --> 0
    // 1 --> 1
    // 2 --> 10
    // 3 --> 11
    // 4 --> 100
    // 5 --> 101

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
//            String str = Integer.toBinaryString(i).replace("0", "");
//            str = str.replace("0", "");
//            result[i] = str.length();
            result[i] = Integer.bitCount(i); // this returns number of "one" bits in an int
            // much faster
        }

        return result;
    }


    public int[] twoSum(int[] nums, int target) {
        int[] resultArr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) { // O(n^2)

                if (nums[i] + nums[j] == target) {
                    resultArr[0] = i;
                    resultArr[1] = j;
                    return resultArr;
                }
            }
        }

        // somehow this solution used less memory than all other submissions on leetcode
        // but leetcode is retarded so prob doesn't matterr
        return null;
    }

    // 238. Product of Array Except Self
    // Given an integer array nums, return an array answer such that answer[i]
    // is equal to the product of all the elements of nums except nums[i].
    //
    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    //
    // You must write an algorithm that runs in O(n) time and without using the division operation.
    //
    // Example 1:
    //
    // Input: nums = [1,2,3,4]
    // Output: [24,12,8,6]

    // Example 2:
    //
    // Input: nums = [-1,1,0,-3,3]
    // Output: [0,0,9,0,0]

    // Follow up: Can you solve the problem in O(1) extra space complexity?
    // (The output array does not count as extra space for space complexity analysis.)
    public int[] productExceptSelf(int[] nums) { // not my solution
        int[] ans = new int[nums.length];
        int current = 1;
        // Calculating product till i except nums[i] from left
        // At this point, ans[i] holds product from nums[0] to nums[i-1]

        for (int i = 0; i < nums.length; i++) {
            ans[i] = current;
            current = current * nums[i];

        }
        //Calculating product from right & multiply with ans[i] and store in ans

        current = 1;
        for (int i = nums.length -1; i >= 0; i--) {
            ans[i] = ans[i] * current; // we're multiplying cur(right product) & ans[i] holding product from left
            current = current * nums[i]; // calculating product from right side
        }
        return ans;
    }


    // 442. Find All Duplicates in an Array
    // Medium
    // Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
    //
    // You must write an algorithm that runs in O(n) time and uses only constant extra space.
    //
    // Example 1:
    //
    // Input: nums = [4,3,2,7,8,2,3,1]
    // Output: [2,3]
    // Example 2:
    //
    // Input: nums = [1,1,2]
    // Output: [1]
    // Example 3:
    //
    // Input: nums = [1]
    // Output: []
    // Each element in nums appears once or twice.
    public List<Integer> findDuplicates(int[] nums) {
        int totalFound = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) == null) {
                hashMap.put(nums[i], 1);
            }
            else {
                int count = hashMap.get(nums[i]) + 1;
                totalFound++;
                hashMap.put(nums[i], count);
            }
        }

        List<Integer> answer = new ArrayList<>(totalFound);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                answer.add(entry.getKey());
            }
        }

        return answer;
    }


    // 169. Majority Element
    // Given an array nums of size n, return the majority element.
    //
    // The majority element is the element that appears more than ⌊n / 2⌋ times.
    // You may assume that the majority element always exists in the array.
    //
    // Example 1:
    //
    // Input: nums = [3,2,3]
    // Output: 3
    // Example 2:
    //
    // Input: nums = [2,2,1,1,1,2,2]
    // Output: 2

    // Follow-up: Could you solve the problem in linear time and in O(1) space?
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // key: nums, value: frequency
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            }
            else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int highestFrequency = 0;
        int keyVal = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > highestFrequency) {
                highestFrequency = entry.getValue();
                keyVal = entry.getKey();
            }
        }
        return keyVal;
    }

    public int majorityElement_ConstantSpace(int[] nums) { // not my solution
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 128. Longest Consecutive Sequence
    // Medium
    // Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    //
    // You must write an algorithm that runs in O(n) time.
    //
    // Example 1:
    // Input: nums = [100,4,200,1,3,2]
    // Output: 4
    // Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    // Example 2:
    //
    // Input: nums = [0,3,7,2,5,8,4,6,0,1]
    // Output: 9
    public int longestConsecutive(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // this sorts keys
        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], i);
        }


        int count = 0;
        int maxCount = 0;
        int placeHolder = Integer.MIN_VALUE; // keeps track of the previous entry in the loop
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (placeHolder == Integer.MIN_VALUE && placeHolder < entry.getKey() || entry.getKey() == placeHolder + 1) {
                count++;
            }
            else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
            placeHolder = entry.getKey();
        }

        return Math.max(maxCount, count);
    }


    // 2022. Convert 1D Array Into 2D Array
    // You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n.
    // You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using all the elements from original.
    //
    // The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array,
    // the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.
    //
    // Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.
    //
    // Example 1:
    //
    // Input: original = [1,2,3,4], m = 2, n = 2
    // Output: [[1,2],[3,4]]
    // Explanation: The constructed 2D array should contain 2 rows and 2 columns.
    // The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.
    // The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.

    // Example 2:
    //
    // Input: original = [1,2,3], m = 1, n = 3
    // Output: [[1,2,3]]
    // Explanation: The constructed 2D array should contain 1 row and 3 columns.
    // Put all three elements in original into the first row of the constructed 2D array.

    // Example 3:
    //
    // Input: original = [1,2], m = 1, n = 1
    // Output: []
    // Explanation: There are 2 elements in original.
    // It is impossible to fit 2 elements in a 1x1 2D array, so return an empty 2D array.
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0];
        }
        int matrix[][] = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = original[count++];
            }
        }

        return matrix;
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



}








