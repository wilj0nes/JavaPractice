package com.practice.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Other {

    public static void callTwoSum() {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        int[] nums2 = {3, 2, 4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        System.out.println(nums.length);
        int[] resultArr = new int[2];

//        Given an array of integers nums and and integer target,
//        return the indices of the two numbers such that they add up to target.
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//        You can return the answer in any order.

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                System.out.println(nums[i] + ", " + nums[j]);

                if (nums[i] + nums[j] == target) {
                    resultArr[0] = i;
                    resultArr[1] = j;
                    return resultArr;
                }


            }
        }

        return null;
    }

    public static List<Integer> cellCompete(int[] states, int days){
        System.out.println("cellComplete()");
        // WRITE YOUR CODE HERE

        List<Integer> newStates = new ArrayList<>(states.length);

        for (int i = 0; i < states.length; i++) {

            if (i == 0 && states[1] == 0) {
                newStates.add(i, 0);
            }
            else if (i == 0 && states[1] == 1) {
                newStates.add(i, 1);
            }
            else if (i == states.length-1 && states[i-1] == 0) {
                newStates.add(i, 0);
            }
            else if (i == states.length-1 && states[i-1] == 1) {
                newStates.add(i, 1);
            }
            else if (states[i-1] == states[i+1]) {
                newStates.add(i, 0);
            }
            else if (states[i-1] != states[i+1]) {
                newStates.add(i, 1);
            }
        }
        days--;
        if (days == 0) {
            return newStates;
        }
        else {
            int[] arr = new int[newStates.size()];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = newStates.get(i);
            }
            return cellCompete(arr, days);
        }
    }


}
