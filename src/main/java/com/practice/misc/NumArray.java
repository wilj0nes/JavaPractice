package com.practice.misc;

public class NumArray {


    // 303. Range Sum Query - Immutable
    //Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
    // Implement the NumArray class:

    // NumArray(int[] nums) Initializes the object with the integer array nums.
    //int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive
    // (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


    // Input
    // ["NumArray", "sumRange", "sumRange", "sumRange"]
    // [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
    // Output
    // [null, 1, -1, -3]

    // Explanation
    // NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
    // numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
    // numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
    // numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

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
