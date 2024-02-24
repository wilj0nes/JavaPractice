package com.practice.leetcode;

public class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        if (nums.length < 1) {
            return nums[0];
        }
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += nums[i];
        }

        return result;
    }
}
