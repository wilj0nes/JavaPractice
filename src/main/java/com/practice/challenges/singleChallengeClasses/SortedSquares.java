package com.practice.challenges.singleChallengeClasses;

import java.util.Arrays;

public class SortedSquares {

    // 977. Squares of a Sorted Array
    // Given an integer array nums sorted in non-decreasing order,
    // return an array of the squares of each number sorted in non-decreasing order.
    //
    // Example 1:
    //
    // Input: nums = [-4,-1,0,3,10]
    // Output: [0,1,9,16,100]
    // Explanation: After squaring, the array becomes [16,1,0,9,100].
    // After sorting, it becomes [0,1,9,16,100].

    // Example 2:
    //
    // Input: nums = [-7,-3,2,3,11]
    // Output: [4,9,9,49,121]

    // Follow up: Squaring each element and sorting the new array is very trivial,
    // could you find an O(n) solution using a different approach?
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) { // O(n)
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums); // adds O(n logn) complexity
        return nums;
    }

    // two pointers solution
    public int[] sortedSquares_betterRuntime(int[] nums) { // not my solution
        int n, m;
        int[] result = new int[nums.length];

        int i = 0;                  // points to beginning of arr
        int j = nums.length - 1;    // points to end of arr

        int e = nums.length - 1;

        while (i < j) {
            n = (int) Math.pow(nums[j], 2);
            m = (int) Math.pow(nums[i], 2);

            if (n > m) {
                result[e] = n;
                j--;
            }
            else {
                result[e] = m;
                i++;
            }
            e--;
        }

        result[e] = ((int) Math.pow(nums[i], 2));
        return result;
    }

}
