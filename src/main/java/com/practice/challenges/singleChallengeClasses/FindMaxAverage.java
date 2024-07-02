package com.practice.challenges.singleChallengeClasses;

public class FindMaxAverage {

    // 643. Maximum Average Subarray I
    // You are given an integer array nums consisting of n elements, and an integer k.
    //
    // Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
    // Any answer with a calculation error less than 10-5 will be accepted.
    //
    // Example 1:
    //
    // Input: nums = [1,12,-5,-6,50,3], k = 4
    // Output: 12.75000
    // Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

    // Example 2:
    //
    // Input: nums = [5], k = 1
    // Output: 5.00000
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        int j = k-1;
        double result = Double.MIN_VALUE;
        Double tempVal = 0.0;
        for (int i = 0; j < nums.length; i++) {
            tempVal = tempVal != null ? tempVal + nums[i] : nums[i];

            if (i == j) {
                if (tempVal/k > result || result == Double.MIN_VALUE) {
                    result = tempVal/k;
                }
                tempVal = null;

                i = i - (k-1); // this puts runtime way above O(n)
                j++;
            }

        }

        return result;
    }

    public double findMaxAverage_improved(int[] nums, int k) { // not my solution todo learn this
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }


}
