package com.practice.challenges.singleChallengeClasses;

public class MoveZeros {


    // 283. Move Zeroes
    // Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    // Note that you must do this in-place without making a copy of the array.
    //      In-place means we should not be allocating any space for extra array.

    // Example 1:
    //
    // Input: nums = [0,1,0,3,12]
    // Output: [1,3,12,0,0]
    // Example 2:
    //
    // Input: nums = [0]
    // Output: [0]
    // Follow up: Could you minimize the total number of operations done?
    public int[] moveZeros(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == 0 && nums[j] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
                else if (nums[i] != 0 && nums[j] == 0) {
                    i = j;
                }
            }
        }

        return nums;
    }
    public int[] moveZeros_betterTimeComplexity(int[] nums) { // mostly my solution
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int i, j;
        for (i = 0, j = 0; j < nums.length;) {
            if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
            else if (nums[i] == 0 && nums[j] == 0) {
                j++;
            }
            else if (nums[i] != 0 && nums[j] != 0) {
                i++;
                j++;
            }
        }

        return nums;
    }
    public void moveZeros_betterTimeComplexity_simplified(int[] nums) { // not my solution
        int i, j;
        for (i = 0, j = 0; i < nums.length;) {
            if (nums[i] == 0) {
                i++;
            }
            else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
    }


}
