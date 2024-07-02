package com.practice.challenges.singleChallengeClasses;

import java.util.Arrays;

public class HouseRobber {

    // 198. House Robber
    // Medium
    // Topics
    // Companies
    // You are a professional robber planning to rob houses along a street.
    // Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is
    // that adjacent houses have security systems connected and it will automatically contact the police
    // if two adjacent houses were broken into on the same night.
    //
    // Given an integer array nums representing the amount of money of each house,
    // return the maximum amount of money you can rob tonight without alerting the police.
    //
    // Example 1:
    //
    // Input: nums = [1,2,3,1]
    // Output: 4
    // Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    // Total amount you can rob = 1 + 3 = 4.
    // Example 2:
    //
    // Input: nums = [2,7,9,3,1]
    // Output: 12
    // Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
    // Total amount you can rob = 2 + 9 + 1 = 12.
    //
    //
    // Constraints:
    //
    // 1 <= nums.length <= 100
    // 0 <= nums[i] <= 400
    public int rob_FUNCTIONAL_ATTEMPT(int[] nums) {
        // solution works but takes waaaaaaaaayyyyyyyyyyyyyyyyy to long to process large arrays
        return Math.max(this.traverseRob(0, 0, nums), this.traverseRob(1, 0, nums));
    }

    public int traverseRob(int index, int val, int[] nums) {
        if (index < 0 || index >= nums.length) {
            return val;
        }
        val += nums[index];

        return Math.max(this.traverseRob(index + 2, val, nums), this.traverseRob(index + 3, val, nums));
    }


    public int rob_FORK(int[] nums) { // equally flawed but cleaner fork
        return traverseRob_FORK(nums,nums.length - 1);
    }

    public int traverseRob_FORK(int[] nums, int index) {
        if (index < 0) {
            return 0;
        }

        return Math.max(this.traverseRob_FORK(nums, index-2) + nums[index], this.traverseRob_FORK(nums, index-1));
    }

    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return this.rob_memo(nums, nums.length-1);
    }

    private int rob_memo(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }

        if (memo[i] >= 0) {
            return this.memo[i];
        }
        int result = Math.max(this.rob_memo(nums, i - 2) + nums[i], this.rob_memo(nums, i - 1));
        this.memo[i] = result;
        return result;
    }



}
